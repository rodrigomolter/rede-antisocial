package cwi.antisocial.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cwi.antisocial.model.Hashtag;
import cwi.antisocial.model.HashtagPostagem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test.xml")
@Transactional
public class HashtagDaoTest {

	@Inject
	private HashtagDao hashtagDao;
	
	@Test
	public void salvarHashtagNoBanco(){
		Hashtag hashtag = new Hashtag();
		hashtag.setNome("#NeymarJogaMuito");
		assertEquals("#NeymarJogaMuito", hashtagDao.salvar(hashtag).getNome());
	}
	
	@Test
	public void excluirHashtag(){
		Hashtag hashtag = new Hashtag();
		hashtag.setNome("#NeymarJogaaMuito");
		hashtag = hashtagDao.salvar(hashtag);
		hashtagDao.excluir(hashtag.getIdHashtag());
	}
	
	@Test
	public void buscarHashtagPorNome(){
		Hashtag hashtag = new Hashtag();
		hashtag.setNome("#NeymarJogaMuito");
		hashtagDao.salvar(hashtag);
		Hashtag hashtag2 = new Hashtag();
		hashtag2.setNome("#Abacaxi");
		hashtagDao.salvar(hashtag2);
		List<Hashtag> obtido = hashtagDao.buscaPorNome("#NeymarJogaMuito");
		assertEquals(1, obtido.size());
	}
	
	@Test
	public void buscarTodasHashtags(){
		Hashtag hashtag = new Hashtag();
		hashtag.setNome("#NeymarJogaMuito");
		hashtagDao.salvar(hashtag);
		List<Hashtag> obtido = hashtagDao.buscarTodos();
		assertEquals(1, obtido.size());
	}
	
}
