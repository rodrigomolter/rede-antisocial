package cwi.antisocial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cwi.antisocial.model.Instrutor;
import cwi.antisocial.model.Usuario;

@Component
public class UsuarioDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Usuario persistirUsuario(Usuario usuario) {
		return entityManager.merge(usuario);
	}

	@Transactional
	public List<Usuario> buscarUsuarioPorNome(String nome) {
		TypedQuery<Usuario> query = entityManager
				.createQuery(
						"SELECT i from Usuario i WHERE upper(i.nome) like upper(:nome)",
						Usuario.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}

	@Transactional
	public Usuario autenticarUsuarioNoBanco(String email, String senha) {
		TypedQuery<Usuario> query = entityManager
				.createQuery(
						"SELECT user from Usuario user WHERE user.email = :email AND user.senha = :senha",
						Usuario.class);
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		List<Usuario> resultado = query.getResultList();
		if (!resultado.isEmpty()) {
			return resultado.get(0);
		} else {
			return null;
		}
	}

	@Transactional
	public void deletarUsuario(String email, String senha) {
		Usuario usuario = autenticarUsuarioNoBanco(email, senha);
		// Remove do banco
		entityManager.remove(usuario);
	}

	@Transactional
	public Usuario buscarUsuarioPorId(Integer id) {
		TypedQuery<Usuario> query = entityManager.createQuery(
				"SELECT i from Usuario i WHERE i.idUsuario = :idUsuario",
				Usuario.class);
		query.setParameter("idUsuario", id);
		return query.getResultList().get(0);
	}
}
