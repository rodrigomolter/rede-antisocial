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
public class HashtagPostagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHashtagPostagem;
	
	@ManyToOne
	@JoinColumn(name="idHashtag", nullable = false)
	private Hashtag hashtag;
	
	@ManyToOne
	@JoinColumn(name="idPostagem", nullable = false)
	private Postagem postagem;
	
	public Hashtag getHashtag() {
		return hashtag;
	}
	
	public int getIdHashtagPostagem() {
		return idHashtagPostagem;
	}
	
	public Postagem getPostagem() {
		return postagem;
	}
	
	public void setHashtag(Hashtag hashtag) {
		this.hashtag = hashtag;
	}
	
	public void setIdHashtagPostagem(int idHashtagPostagem) {
		this.idHashtagPostagem = idHashtagPostagem;
	}
	
	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}
	
}
