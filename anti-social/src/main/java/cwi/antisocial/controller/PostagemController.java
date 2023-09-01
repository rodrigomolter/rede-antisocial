package cwi.antisocial.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cwi.antisocial.dao.HashtagDao;
import cwi.antisocial.dao.HashtagPostagemDao;
import cwi.antisocial.dao.HashtagProibidaDao;
import cwi.antisocial.dao.PostagemDao;
import cwi.antisocial.dao.UsuarioAmigoDao;
import cwi.antisocial.model.DescurtidaUsuario;
import cwi.antisocial.model.Hashtag;
import cwi.antisocial.model.HashtagPostagem;
import cwi.antisocial.model.HashtagProibida;
import cwi.antisocial.model.Postagem;
import cwi.antisocial.model.Usuario;

@Controller
public class PostagemController {
	@Inject
	UsuarioAmigoDao usuarioAmigoDao;
	@Inject
	PostagemDao postagemDao;
	@Inject
	HashtagDao hashtagDao;
	@Inject
	HashtagProibidaDao hashProibidaDao;
	@Inject
	HashtagPostagemDao hashtagPostagemDao;

	@RequestMapping(value = "/postar", method = RequestMethod.POST)
	public String adicionaPostagem(@RequestBody Postagem postagem, Model model,
			HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		postagem.setUsuario(usuario);
		postagem = postagemDao.salvar(postagem);

		String[] lista = postagem.getMensagem().split(" ");
		List<String> list = Arrays.asList(lista);
		for (String word : list) {
			if (word.contains("#")) {
				Hashtag hashtag = new Hashtag();
				if (hashtagDao.buscaPorNome(word).isEmpty()) {
					hashtag.setNome(word);
					hashtag = hashtagDao.salvar(hashtag);
				} else {
					hashtag = hashtagDao.buscaPorNome(word).get(0);
				}
				HashtagPostagem hashtagPostagem = new HashtagPostagem();
				hashtagPostagem.setHashtag(hashtag);
				hashtagPostagem.setPostagem(postagem);
				hashtagPostagemDao.salvar(hashtagPostagem);
			}
		}

		List<Postagem> postagens = new LinkedList<Postagem>();
		postagens.add(postagem);
		model.addAttribute("postagens", postagens);
		model.addAttribute("avatar", usuario.getAvatar());
		return "postAppendable.html";
	}

	@ResponseBody
	@RequestMapping(value = "/descurtir", method = RequestMethod.POST)
	public Postagem descurtirPagina(@RequestBody Postagem postagem,
			Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		postagem = postagemDao.descurtir(postagem, usuario);
		System.out.println(postagem.getIdPostagem());
		String[] lista = postagem.getMensagem().split(" ");
		List<String> list = Arrays.asList(lista);
		for (String word : list) {
			if (word.contains("#")) {
				Hashtag hashtag = hashtagDao.buscaPorNome(word).get(0);
				HashtagProibida hashProibida = new HashtagProibida();
				if (!hashProibidaDao.verificaProibicaoDaHashtagParaUmUsuario(
						hashtag, usuario)) {
					hashProibida.setHashtag(hashtag);
					hashProibida.setUsuario(usuario);
					hashProibidaDao.salvar(hashProibida);
				}
			}
		}
		List<Postagem> postagens = new LinkedList<Postagem>();
		postagens.add(postagem);
		model.addAttribute("postagens", postagens);
		return postagem;
	}

	@RequestMapping(value = "/atualiza/feed", method = RequestMethod.GET)
	public String buscaPostsAtuaisParaUsuarioDaSessao(Model model,
			HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		List<Usuario> amigos = usuarioAmigoDao.buscaOsAmigosDoUsuario(usuario);
		List<DescurtidaUsuario> descurtidas = postagemDao
				.buscarDescurtidasUsuario();

		List<Postagem> postagemDosAmigos = new LinkedList<Postagem>();

		List<Integer> idsPostagensDescurtidasUsuario = new ArrayList<Integer>();
		for (DescurtidaUsuario d : descurtidas) {
			if (d.getUsuario().getIdUsuario().equals(usuario.getIdUsuario())) {
				idsPostagensDescurtidasUsuario.add(d.getPostagem()
						.getIdPostagem());
			}
		}

		for (Usuario amigo : amigos) {
			postagemDosAmigos.addAll(postagemDao
					.buscaTodasPostagemPorUsuario(amigo));
		}

		postagemDosAmigos.addAll(postagemDao
				.buscaTodasPostagemPorUsuario(usuario));

		for (Postagem postagem : postagemDosAmigos) {
			if (idsPostagensDescurtidasUsuario.contains(postagem
					.getIdPostagem())) {
				postagem.setDescurtidoUsuario(true);
			}
		}

		List<Hashtag> hashProibidas = hashProibidaDao
				.hashtagsProibidasPorUsuario(usuario);
		List<Postagem> postagemBloqueadas = new ArrayList<Postagem>();

		for (Hashtag hashProibida : hashProibidas) {
			postagemBloqueadas.addAll(hashtagPostagemDao
					.buscaPostagemPorHashtag(hashProibida));
		}

		postagemDosAmigos.removeAll(postagemBloqueadas);
		
		Collections.sort(postagemDosAmigos, Collections.reverseOrder());
		// envia uma sublist das postagens (envia só uma parte das postagens)
		if (postagemDosAmigos.size() >= 10) {
			model.addAttribute("postagens", postagemDosAmigos.subList(0, 10));
		} else {
			model.addAttribute("postagens", postagemDosAmigos);
		}
		return "postAppendable.html";
	}
}