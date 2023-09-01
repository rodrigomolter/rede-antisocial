package cwi.antisocial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import cwi.antisocial.model.Hashtag;
import cwi.antisocial.model.HashtagProibida;
import cwi.antisocial.model.Usuario;

@Component
public class HashtagProibidaDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public HashtagProibida salvar(HashtagProibida hashProibida) {
		return entityManager.merge(hashProibida);
	}

	@Transactional
	public void excluir(Integer idHashProibida) {
		HashtagProibida hashProibida = entityManager.find(
				HashtagProibida.class, idHashProibida);

		entityManager.remove(hashProibida);
	}

	@Transactional
	public List<HashtagProibida> buscarTodos() {
		// Apesar de ser parecido, isto NÃO é SQL. Se chama JPQL e tem uma
		// sintaxe um poooouco diferente.
		TypedQuery<HashtagProibida> query = entityManager.createQuery(
				"SELECT hashProibida from HashtagProibida hashProibida",
				HashtagProibida.class);
		return query.getResultList();
	}

	public boolean verificaProibicaoDaHashtagParaUmUsuario(Hashtag hashtag, Usuario usuario) {
		TypedQuery<HashtagProibida> query = entityManager
				.createQuery(
						"SELECT hashProibida from HashtagProibida hashProibida where idUsuario = :idUsuario AND idHashtag = :idHashtag",
						HashtagProibida.class);
		query.setParameter("idUsuario", usuario.getIdUsuario());
		query.setParameter("idHashtag", hashtag.getIdHashtag());
		List<HashtagProibida> proibidas = query.getResultList();
		if (proibidas.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public List<Hashtag> hashtagsProibidasPorUsuario(Usuario usuario){
		TypedQuery<Hashtag> query = entityManager
				.createQuery(
						"SELECT hashtag from cwi.antisocial.model.HashtagProibida hb WHERE hb.usuario.idUsuario = :idUsuario",
						Hashtag.class);
		query.setParameter("idUsuario", usuario.getIdUsuario());
		return query.getResultList();
	}

}
