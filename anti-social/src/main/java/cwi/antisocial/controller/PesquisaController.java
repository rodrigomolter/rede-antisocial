package cwi.antisocial.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cwi.antisocial.dao.UsuarioAmigoDao;
import cwi.antisocial.dao.UsuarioDao;
import cwi.antisocial.model.Postagem;
import cwi.antisocial.model.Usuario;

@Controller
public class PesquisaController {

	@Inject
	UsuarioDao usuarioDao;

	@Inject
	UsuarioAmigoDao usuarioAmigoDao;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String abrePesquisa(Model model, HttpSession session) {
		if (session.getAttribute("usuarioLogado") == null) {
			return "redirect:/login";
		}
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("mustacheusername", usuarioLogado.getNome());
		model.addAttribute("userlocation", usuarioLogado.getLocalizacao());
		model.addAttribute("userdate", usuarioLogado.getDataNascimento());
		model.addAttribute("avatar", usuarioLogado.getAvatar());
		return "search.html";
	}

	@RequestMapping(value = "/search/users", method = RequestMethod.GET)
	public String pesquisarUsuarios(@RequestParam("pesquisa") String pesquisa,
			Model model, HttpSession session) {
		if (session.getAttribute("usuarioLogado") == null) {
			return "redirect:/login";
		}

		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("mustacheusername", usuarioLogado.getNome());
		model.addAttribute("userlocation", usuarioLogado.getLocalizacao());
		model.addAttribute("userdate", usuarioLogado.getDataNascimento());
		model.addAttribute("avatar", usuarioLogado.getAvatar());

		// verificação para adição da flag de usuário já perseguido
		List<Usuario> amigosDoUsuario = usuarioAmigoDao
				.buscaOsAmigosDoUsuario(usuarioLogado);
		List<Integer> idsAmigosDoUsuario = new ArrayList<Integer>();
		for (Usuario amigo : amigosDoUsuario) {
			idsAmigosDoUsuario.add(amigo.getIdUsuario());
		}

		List<Usuario> usuarios = usuarioDao.buscarUsuarioPorNome(pesquisa);
		for (Usuario user : usuarios) {
			if (idsAmigosDoUsuario.contains(user.getIdUsuario())) {
				user.setUsuarioPerseguido(true);
			}
		}
		//fim da verificação para adição da flag de usuário já perseguido
		
		model.addAttribute("resultado", usuarios);
		return "search.html";
	}

	@ResponseBody
	@RequestMapping(value = "/perseguir", method = RequestMethod.POST)
	public Integer perseguirUsuario(@RequestBody Usuario amigo, Model model,
			HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

		amigo = usuarioDao.buscarUsuarioPorId(amigo.getIdUsuario());
		System.out.println(amigo);

		usuarioAmigoDao.adicionaAmigoAoUsuario(usuarioLogado, amigo);
		model.addAttribute("avatar", usuarioLogado.getAvatar());
		List<Usuario> amigos = new ArrayList<Usuario>();
		amigos.add(amigo);
		System.out.println(amigo);
		return amigo.getIdUsuario();
	}
}