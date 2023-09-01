package cwi.antisocial.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
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
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

/*
 * Classe com as caracteristicas de uma postagem
 */

@Entity
public class Postagem implements Comparable<Postagem> {

	private static SimpleDateFormat FORMATA_HORA = new SimpleDateFormat("HH:mm");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPostagem;

	@Column(nullable = false)
	private String mensagem;

	@ManyToOne
	@JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
	private Usuario usuario;

	@Column
	@Type(type = "time")
	private Date data;

	@Column
	@Type(type = "integer")
	private int descurtidas;

	@Transient
	private boolean descurtidoUsuario;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setIdPostagem(Integer idPostagem) {
		this.idPostagem = idPostagem;
	}

	public int getIdPostagem() {
		return idPostagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getDescurtidas() {
		return descurtidas;
	}

	public void setDescurtidas(int descurtidas) {
		this.descurtidas = descurtidas;
	}

	@Override
	public int compareTo(Postagem o) {
		if (this.getIdPostagem() > o.getIdPostagem()) {
			return 1;
		} else if (this.getIdPostagem() < o.getIdPostagem()) {
			return -1;
		} else {
			return 0;
		}
	}

	public void setDescurtidoUsuario(boolean descurtidoUsuario) {
		this.descurtidoUsuario = descurtidoUsuario;
	}

	public boolean isDescurtidoUsuario() {
		return descurtidoUsuario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.idPostagem == ((Postagem) obj).getIdPostagem()) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getHoraFormatada(){
		if(data != null){
			return FORMATA_HORA.format(data);
		}
		return "";
	}
}