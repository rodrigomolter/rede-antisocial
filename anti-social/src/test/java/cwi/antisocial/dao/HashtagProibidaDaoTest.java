package cwi.antisocial.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cwi.antisocial.model.Hashtag;
import cwi.antisocial.model.HashtagProibida;
import cwi.antisocial.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test.xml")
@Transactional
public class HashtagProibidaDaoTest {
	
	@Inject
	private HashtagProibidaDao hashProibidaDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Inject
	private HashtagDao hashtagDao;
	
	@Test
	public void salvarAssociacaoBanco(){
		Usuario usuario = new Usuario();
		usuario.setNome("teste");
		usuario.setDataNascimento("30/10/1987");
		usuario.setSenha("teste123");
		usuario.setEmail("teste@teste.com");
		usuario.setLocalizacao("cidade teste");
		usuario.setGenero("masculino");
		usuario = usuarioDao.persistirUsuario(usuario);
		
		Hashtag hashtag = new Hashtag();
		hashtag.setNome("#NeymarJogaMuito");
		hashtag = hashtagDao.salvar(hashtag);
		
		HashtagProibida hashProibida = new HashtagProibida();
		hashProibida.setHashtag(hashtag);
		hashProibida.setUsuario(usuario);;
		
		assertEquals("#NeymarJogaMuito", hashProibidaDao.salvar(hashProibida).getHashtag().getNome());	
	}

	@Test 
	public void excluirAssociacao(){
		Usuario usuario = new Usuario();
		usuario.setNome("teste");
		usuario.setDataNascimento("30/10/1987");
		usuario.setSenha("teste123");
		usuario.setEmail("teste@teste.com");
		usuario.setLocalizacao("cidade teste");
		usuario.setGenero("masculino");
		usuario = usuarioDao.persistirUsuario(usuario);
		
		Hashtag hashtag = new Hashtag();
		hashtag.setNome("#NeymarJogaMuito");
		hashtag = hashtagDao.salvar(hashtag);
		
		HashtagProibida hashProibida = new HashtagProibida();
		hashProibida.setHashtag(hashtag);
		hashProibida.setUsuario(usuario);
		hashProibida = hashProibidaDao.salvar(hashProibida);
		hashProibidaDao.excluir(hashProibida.getIdHashtagProibida());
		
	}
	
	@Test
	public void buscarTodasAssociacoes(){
		Usuario usuario = new Usuario();
		usuario.setNome("teste");
		usuario.setDataNascimento("30/10/1987");
		usuario.setSenha("teste123");
		usuario.setEmail("teste@teste.com");
		usuario.setLocalizacao("cidade teste");
		usuario.setGenero("masculino");
		usuario = usuarioDao.persistirUsuario(usuario);
		
		Hashtag hashtag = new Hashtag();
		hashtag.setNome("#NeymarJogaMuito");
		hashtag = hashtagDao.salvar(hashtag);
		
		Hashtag hashtag2 = new Hashtag();
		hashtag2.setNome("#NeymarMeuIdolo");
		hashtag2 = hashtagDao.salvar(hashtag2);
		
		HashtagProibida hashProibida = new HashtagProibida();
		hashProibida.setHashtag(hashtag);
		hashProibida.setUsuario(usuario);
		hashProibida = hashProibidaDao.salvar(hashProibida);
		
		HashtagProibida hashProibida2 = new HashtagProibida();
		hashProibida2.setHashtag(hashtag2);
		hashProibida2.setUsuario(usuario);
		hashProibida2 = hashProibidaDao.salvar(hashProibida2);
		
		List<HashtagProibida> obtido = hashProibidaDao.buscarTodos();
		
		assertEquals(2, obtido.size());
		
	}
	
	@Test
	public void buscarHashtagPorUsuario(){
		Usuario usuario = new Usuario();
		usuario.setNome("teste");
		usuario.setDataNascimento("30/10/1987");
		usuario.setSenha("teste123");
		usuario.setEmail("teste@teste.com");
		usuario.setLocalizacao("cidade teste");
		usuario.setGenero("masculino");
		usuario = usuarioDao.persistirUsuario(usuario);
		
		Hashtag hashtag = new Hashtag();
		hashtag.setNome("#NeymarJogaMuito");
		hashtag = hashtagDao.salvar(hashtag);
		
		Hashtag hashtag2 = new Hashtag();
		hashtag2.setNome("#NeymarMeuIdolo");
		hashtag2 = hashtagDao.salvar(hashtag2);
		
		HashtagProibida hashProibida = new HashtagProibida();
		hashProibida.setHashtag(hashtag);
		hashProibida.setUsuario(usuario);
		hashProibida = hashProibidaDao.salvar(hashProibida);
		
		HashtagProibida hashProibida2 = new HashtagProibida();
		hashProibida2.setHashtag(hashtag2);
		hashProibida2.setUsuario(usuario);
		hashProibida2 = hashProibidaDao.salvar(hashProibida2);
		
		List<Hashtag> obtido = hashProibidaDao.hashtagsProibidasPorUsuario(usuario);
		
		assertEquals(2, obtido.size());
		
	}
	
	
}
