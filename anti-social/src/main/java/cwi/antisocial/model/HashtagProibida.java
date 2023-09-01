package cwi.antisocial.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HashtagProibida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHashtagProibida;
	
	@ManyToOne
	@JoinColumn(name="idHashtag", nullable = false)
	private Hashtag hashtag;
	
	@ManyToOne
	@JoinColumn(name="idUsuario", nullable = false)
	private Usuario usuario;

	public Hashtag getHashtag() {
		return hashtag;
	}
	
	public int getIdHashtagProibida() {
		return idHashtagProibida;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setHashtag(Hashtag hashtag) {
		this.hashtag = hashtag;
	}
	
	public void setIdHashtagProibida(int idHashtagProibida) {
		this.idHashtagProibida = idHashtagProibida;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
