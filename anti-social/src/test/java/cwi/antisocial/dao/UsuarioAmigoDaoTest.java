package cwi.antisocial.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cwi.antisocial.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test.xml")
@Transactional
public class UsuarioAmigoDaoTest {

	@Inject
	private UsuarioAmigoDao usuarioAmigoDao;

	@Inject
	private UsuarioDao usuarioDao;

	@Test
	public void insereAmigoEmUsuarioEBusca() {
		Usuario usuario = criaUsuario();
		Usuario amigo = criaAmigo();
		usuario = usuarioDao.persistirUsuario(usuario);
		amigo = usuarioDao.persistirUsuario(amigo);

		assertEquals("teste",
				usuarioAmigoDao.adicionaAmigoAoUsuario(usuario, amigo)
						.getUsuario().getNome());
	}

	@Test
	public void deletaAmigoDeUsuarioEBusca() {
		Usuario usuario = criaUsuario();
		Usuario amigo = criaAmigo();
		usuario = usuarioDao.persistirUsuario(usuario);
		amigo = usuarioDao.persistirUsuario(amigo);

		usuarioAmigoDao.adicionaAmigoAoUsuario(usuario, amigo);

		usuarioAmigoDao.deletaAmigoDeUsuario(usuario, amigo);

		assertTrue(usuarioAmigoDao.buscaOsAmigosDoUsuario(usuario).isEmpty());
	}

	// Não é teste, função auxiliar
	public Usuario criaUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("teste");
		usuario.setDataNascimento("30/10/1987");
		usuario.setSenha("teste123");
		usuario.setEmail("teste@teste.com");
		usuario.setLocalizacao("cidade teste");
		usuario.setGenero("masculino");
		return usuario;
	}

	// Não é teste, função auxiliar
	public Usuario criaAmigo() {
		Usuario usuario = new Usuario();
		usuario.setNome("teste2");
		usuario.setDataNascimento("30/10/1987");
		usuario.setSenha("teste123");
		usuario.setEmail("teste2@teste.com");
		usuario.setLocalizacao("cidade teste");
		usuario.setGenero("masculino");
		return usuario;
	}

}
