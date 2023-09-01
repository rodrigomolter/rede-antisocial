package cwi.antisocial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import cwi.antisocial.model.Instrutor;

/**
 * DAO de exemplo. Pode ser excluído.
 * 
 * @author Marlon Bernardes
 */
@Component
public class InstrutorDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Instrutor salvar(Instrutor instrutor){
		//salva e retorna um instrutor com o campo idInstrutor já preenchido!
		//Faz insert caso o id esteja nulo ou update caso o id esteja preenchido
		return entityManager.merge(instrutor);
	}
	
	@Transactional
	public void excluir(Integer idInstrutor){
		//Busca um instrutor pelo id (PK da tabela)
		Instrutor instrutor = entityManager.find(Instrutor.class, idInstrutor);
		//Remove do banco
		entityManager.remove(instrutor);
	}
	
	@Transactional
	public List<Instrutor> buscarTodos(){
		//Apesar de ser parecido, isto NÃO é SQL. Se chama JPQL e tem uma sintaxe um poooouco diferente.
		TypedQuery<Instrutor> query = entityManager.createQuery("SELECT i from Instrutor i", Instrutor.class);
		return query.getResultList();
	}

	@Transactional
	public List<Instrutor> buscaPorNome(String nome){
		TypedQuery<Instrutor> query = entityManager.createQuery("SELECT i from Instrutor i WHERE i.nome like :nome ", Instrutor.class);
		query.setParameter("nome", nome + "%"); 
		return query.getResultList();
	}
	
}
