package cwi.antisocial.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/*
 * Classe com as principais caracteristicas do Usuario
 * 
 */
@Entity
public class DescurtidaUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDescurtidaUsuario;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idPostagem", nullable = false)
	private Postagem postagem;
	
	public int getIdDescurtidaUsuario() {
		return idDescurtidaUsuario;
	}
	
	public Postagem getPostagem() {
		return postagem;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setIdDescurtidaUsuario(int idDescurtidaUsuario) {
		this.idDescurtidaUsuario = idDescurtidaUsuario;
	}
	
	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
