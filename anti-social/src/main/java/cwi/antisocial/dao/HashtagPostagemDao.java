package cwi.antisocial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import cwi.antisocial.model.Hashtag;
import cwi.antisocial.model.HashtagPostagem;
import cwi.antisocial.model.Postagem;

@Component
public class HashtagPostagemDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public HashtagPostagem salvar(HashtagPostagem hashPost){
		return entityManager.merge(hashPost);
	}
	
	@Transactional
	public void excluir(Integer idHashPost){
		HashtagPostagem hashPost = entityManager.find(HashtagPostagem.class, idHashPost);
		entityManager.remove(hashPost);
	}
	
	@Transactional
	public List<Postagem> buscaPostagemPorHashtag(Hashtag hashtag){
		TypedQuery<Postagem> queryPosts = entityManager.createQuery("SELECT post "
				+ " from HashtagPostagem hp "
				+ " join hp.postagem post "
				+ " join hp.hashtag h"
				+ " WHERE h.idHashtag = :idHashtag",
				Postagem.class);
		queryPosts.setParameter("idHashtag", hashtag.getIdHashtag());
		return queryPosts.getResultList();
	}

}
