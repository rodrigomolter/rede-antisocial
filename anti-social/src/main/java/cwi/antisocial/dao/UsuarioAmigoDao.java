package cwi.antisocial.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.mapping.Array;
import org.springframework.stereotype.Component;

import cwi.antisocial.model.Usuario;
import cwi.antisocial.model.UsuarioAmigo;

@Component
public class UsuarioAmigoDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Inject
	private UsuarioDao usuarioDao;

	@Transactional
	public UsuarioAmigo adicionaAmigoAoUsuario(Usuario usuario, Usuario amigo) {
		UsuarioAmigo usuarioAmigo = new UsuarioAmigo();
		usuarioAmigo.setUsuario(usuario);
		usuarioAmigo.setUsuarioAmigo(amigo);
		return entityManager.merge(usuarioAmigo);
	}

	@Transactional
	public List<Usuario> buscaOsAmigosDoUsuario(Usuario usuario) {
		TypedQuery<UsuarioAmigo> query = entityManager
				.createQuery(
						"SELECT friend from UsuarioAmigo friend WHERE friend.usuario.idUsuario = :idUsuario",
						UsuarioAmigo.class);
		query.setParameter("idUsuario", usuario.getIdUsuario());
		List<UsuarioAmigo> usuarioAmigo = query.getResultList();
		List<Usuario> amigos = new ArrayList<Usuario>();
		for (UsuarioAmigo userFriend: usuarioAmigo){
			amigos.add(userFriend.getUsuarioAmigo());
		}
		return amigos;
	}

	@Transactional
	public void deletaAmigoDeUsuario(Usuario usuario, Usuario amigo) {
		UsuarioAmigo usuarioAmigo = new UsuarioAmigo();
		usuarioAmigo.setUsuario(usuario);
		usuarioAmigo.setUsuarioAmigo(amigo);
		entityManager.remove(usuarioAmigo);
	}
}
