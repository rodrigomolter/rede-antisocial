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
import cwi.antisocial.model.HashtagPostagem;
import cwi.antisocial.model.Postagem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test.xml")
@Transactional
public class HashtagPostagemDaoTest {
	
	@Inject
	private HashtagPostagemDao hashPostDao;
	
	@Inject
	private PostagemDao postagemDao;
	
	@Inject
	private HashtagDao hashtagDao;
	
	@Test
	public void salvarNoBanco(){
		Postagem postagem = new Postagem();
		postagem.setMensagem("Ola olal oal oalol oaloalaolaolal");
		postagem.setDescurtidas(3);
		postagem = postagemDao.salvar(postagem);
		
		Hashtag hashtag = new Hashtag();
		hashtag.setNome("#NeymarJogaMuito");
		hashtag = hashtagDao.salvar(hashtag);
		
		HashtagPostagem hashPost = new HashtagPostagem();
		hashPost.setHashtag(hashtag);
		hashPost.setPostagem(postagem);
		
		assertEquals("#NeymarJogaMuito", hashPostDao.salvar(hashPost).getHashtag().getNome());		
	}
	
	@Test
	public void excluirAssociacao(){
		Postagem postagem = new Postagem();
		postagem.setMensagem("Ola olal oal oalol oaloalaolaolal");
		postagem.setDescurtidas(3);
		postagem = postagemDao.salvar(postagem);
		
		Hashtag hashtag = new Hashtag();
		hashtag.setNome("#NeymarJogaMuito");
		hashtag = hashtagDao.salvar(hashtag);
		
		HashtagPostagem hashPost = new HashtagPostagem();
		hashPost.setHashtag(hashtag);
		hashPost.setPostagem(postagem);
		hashPost = hashPostDao.salvar(hashPost);
		hashPostDao.excluir(hashPost.getIdHashtagPostagem());
	}
	
	@Test
	public void buscarPostagemPorHashtag(){
		Postagem postagem = new Postagem();
		postagem.setMensagem("Ola olal oal oalol oaloalaolaolal");
		postagem.setDescurtidas(3);
		postagem = postagemDao.salvar(postagem);
		
		Postagem postagem2 = new Postagem();
		postagem2.setMensagem("TESTEEEE");
		postagem2.setDescurtidas(1);
		postagem2 = postagemDao.salvar(postagem2);
		
		Hashtag hashtag = new Hashtag();
		hashtag.setNome("#NeymarJogaMuito");
		hashtag = hashtagDao.salvar(hashtag);
		
		HashtagPostagem hashPost = new HashtagPostagem();
		hashPost.setHashtag(hashtag);
		hashPost.setPostagem(postagem);
		hashPostDao.salvar(hashPost);
		
		HashtagPostagem hashPost2 = new HashtagPostagem();
		hashPost2.setHashtag(hashtag);
		hashPost2.setPostagem(postagem2);
		hashPostDao.salvar(hashPost2);
		
		List<Postagem> obtido = hashPostDao.buscaPostagemPorHashtag(hashtag);
		
		assertEquals(2, obtido.size());
		
	}

}