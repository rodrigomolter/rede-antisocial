package cwi.antisocial.dao;

import static org.junit.Assert.*;

import java.util.List;

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
public class UsuarioDaoTest {

	@Inject
	private UsuarioDao usuarioDao;
	
	//Não é teste, função auxiliar
	public void inserirUsuario(Usuario usuario){
			usuario.setNome("teste");
			usuario.setDataNascimento("30/10/1987");
			usuario.setSenha("teste123");
			usuario.setEmail("teste@teste.com");
			usuario.setLocalizacao("cidade teste");
			usuario.setGenero("masculino");
			usuarioDao.persistirUsuario(usuario);
	}
	
	@Test
	public void inserirUsuarioNoBanco() {
		Usuario usuario = new Usuario();
		inserirUsuario(usuario);
		
		assertEquals("teste@teste.com", usuario.getEmail());
	}
	
	@Test
	public void deletaUsuario(){
		Usuario usuario = new Usuario();
		inserirUsuario(usuario);
		usuarioDao.deletarUsuario("teste@teste.com", "teste123");
	}
	
	@Test
	public void buscarUsuarioExistente(){
		Usuario usuario = new Usuario();
		inserirUsuario(usuario);
		List<Usuario> novo = usuarioDao.buscarUsuarioPorNome(usuario.getNome());
		
		assertEquals(1, novo.size());
	}
	
	@Test
	public void buscaUsuarioNaoExistente() {
		assertTrue(usuarioDao.buscarUsuarioPorNome("teste").isEmpty());		
	}

}
