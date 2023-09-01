package cwi.antisocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UsuarioAmigo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idUsuarioAmigo", nullable = false)
	private Usuario usuarioAmigo;

	public Usuario getUsuarioAmigo() {
		return usuarioAmigo;
	}

	public void setUsuarioAmigo(Usuario usuarioAmigo) {
		this.usuarioAmigo = usuarioAmigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
