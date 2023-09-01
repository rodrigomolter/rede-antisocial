package cwi.antisocial.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cwi.antisocial.model.Postagem;
import cwi.antisocial.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test.xml")
@Transactional
public class PostagemDaoTest {
	
	@Inject
	private PostagemDao postagemDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	//Não é teste, função auxiliar
	public void novoUsuario(Usuario usuario){
		usuario.setNome("teste");
		usuario.setDataNascimento("30/10/1987");
		usuario.setSenha("teste123");
		usuario.setEmail("teste@teste.com");
		usuario.setLocalizacao("cidade teste");
		usuario.setGenero("masculino");
		usuarioDao.persistirUsuario(usuario);
	}
	
	//Não é teste, função auxiliar
	public Postagem inserirPostagem(Postagem postagem) {
		postagem.setMensagem("Ola olal oal oalol oaloalaolaolal");
		postagem.setDescurtidas(3);
		return postagemDao.salvar(postagem);
	}
	
	//Não é teste, função auxiliar
	public void inserirPostagem(Postagem postagem, Usuario usuario) {
		postagem.setMensagem("Ola olal oal oalol oaloalaolaolal");
		postagem.setDescurtidas(3);
		novoUsuario(usuario);
		postagem.setUsuario(usuario);
		postagemDao.salvar(postagem);
	}
	
	
	@Test
	public void inserirPostagemNoBanco(){
		Postagem postagem = new Postagem();
		inserirPostagem(postagem);
		
		assertEquals("Ola olal oal oalol oaloalaolaolal", postagem.getMensagem());
	}
	
	@Test
	public void deletarPostagem(){
		Postagem postagem = new Postagem();
		postagem = inserirPostagem(postagem);
		postagemDao.excluir(postagem.getIdPostagem());
	}
	
	@Test
	public void buscarTodosAsPostagensDeUmUsuario(){
		Postagem postagem = new Postagem();
		Usuario usuario = new Usuario();
		inserirPostagem(postagem, usuario);
		List<Postagem> obtido = postagemDao.buscaTodasPostagemPorUsuario(usuario);
	
		assertEquals(1, obtido.size());
	}
	
	@Test
	public void buscarTodasPostagens(){
		Postagem postagem = new Postagem();
		inserirPostagem(postagem);
		List<Postagem> obtido = postagemDao.buscarTodos();
		
		assertEquals(1, obtido.size());
	}

}
