package cwi.antisocial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import cwi.antisocial.model.Hashtag;

@Component
public class HashtagDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//Salva uma hashtag no banco, se ja houver ele altera o existente.
	@Transactional
	public Hashtag salvar(Hashtag hashtag){
		return entityManager.merge(hashtag);
	}

	@Transactional
	public void excluir(Integer idHashtag){
		//Busca uma hashtag pelo id (PK da tabela)
		Hashtag hashtag = entityManager.find(Hashtag.class, idHashtag);
		//Remove do banco
		entityManager.remove(hashtag);
	}
	
	@Transactional
	public List<Hashtag> buscaPorNome(String nome){
		TypedQuery<Hashtag> query = entityManager.createQuery("SELECT hash from Hashtag hash WHERE hash.nome = :nome ", Hashtag.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}

	@Transactional
	public List<Hashtag> buscarTodos(){
		//Apesar de ser parecido, isto NÃO é SQL. Se chama JPQL e tem uma sintaxe um poooouco diferente.
		TypedQuery<Hashtag> query = entityManager.createQuery("SELECT hash from Hashtag hash", Hashtag.class);
		return query.getResultList();
	}


}
