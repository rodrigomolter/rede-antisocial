package cwi.antisocial.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import cwi.antisocial.model.DescurtidaUsuario;
import cwi.antisocial.model.Postagem;
import cwi.antisocial.model.Usuario;

/*
 * Classe de Data Acess Objetct para a Classe Postagem
 * Manipula os dados referens a uma Postagem no banco
 * 
 */
@Component
public class PostagemDao {

	@PersistenceContext
	private EntityManager entityManager;

	// Salva um post no banco, se ja houver ele altera o existente.
	@Transactional
	public Postagem salvar(Postagem postagem) {
		postagem.setData(new Date());
		return entityManager.merge(postagem);
	}

	@Transactional
	public Postagem descurtir(Postagem postagem, Usuario usuario) {
		Postagem postagemBanco = buscarPostagemPorId(postagem).get(0);
		int incrementadescurtir = (postagemBanco.getDescurtidas() + 1);
		postagemBanco.setDescurtidas(incrementadescurtir);
		postagemBanco = entityManager.merge(postagemBanco);

		DescurtidaUsuario descurtida = new DescurtidaUsuario();
		descurtida.setUsuario(usuario);
		descurtida.setPostagem(postagemBanco);

		descurtida = entityManager.merge(descurtida);
		return postagemBanco;
	}

	@Transactional
	public void excluir(Integer idPostagem) {
		Postagem postagem = entityManager.find(Postagem.class, idPostagem);
		entityManager.remove(postagem);
	}

	@Transactional
	public List<Postagem> buscaTodasPostagemPorUsuario(Usuario usuario) {
		TypedQuery<Postagem> query = entityManager.createQuery(
				"SELECT post from Postagem post WHERE idUsuario = :idUsuario",
				Postagem.class);
		query.setParameter("idUsuario", usuario.getIdUsuario());
		return query.getResultList();
	}

	@Transactional
	public List<Postagem> buscarTodos() {
		// Apesar de ser parecido, isto NÃO é SQL. Se chama JPQL e tem uma
		// sintaxe um poooouco diferente.
		TypedQuery<Postagem> query = entityManager.createQuery(
				"SELECT post from Postagem post", Postagem.class);
		return query.getResultList();
	}

	@Transactional
	public List<DescurtidaUsuario> buscarDescurtidasUsuario() {
		// Apesar de ser parecido, isto NÃO é SQL. Se chama JPQL e tem uma
		// sintaxe um poooouco diferente.
		TypedQuery<DescurtidaUsuario> query = entityManager.createQuery(
				"SELECT descurtida from DescurtidaUsuario descurtida",
				DescurtidaUsuario.class);
		return query.getResultList();
	}

	@Transactional
	public List<Postagem> buscarPostagemPorId(Postagem postagem) {
		TypedQuery<Postagem> query = entityManager
				.createQuery(
						"SELECT post from Postagem post WHERE post.idPostagem = :idPostagem",
						Postagem.class);
		query.setParameter("idPostagem", postagem.getIdPostagem());
		return query.getResultList();
	}

}
