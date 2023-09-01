package cwi.antisocial.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.springframework.expression.ParseException;

/*
 * Classe com as principais caracteristicas do Usuario
 * 
 */
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String genero;
	
	@Transient
	private boolean usuarioPerseguido;

	// Antigo mapeamento para criação da tabela UsuarioAmigo
	/*
	 * @ManyToMany(cascade = { CascadeType.ALL })
	 * 
	 * @JoinTable(name="UsuarioAmigo", joinColumns = { @JoinColumn(name =
	 * "idUsuario") }, inverseJoinColumns = { @JoinColumn(name = "idAmigo") })
	 * private Set<Usuario> amigos = new HashSet<Usuario>();
	 * 
	 * @ManyToMany(cascade = { CascadeType.ALL })
	 * 
	 * @JoinTable(name="UsuarioAmigo" , joinColumns = { @JoinColumn(name =
	 * "idAmigo") }, inverseJoinColumns = { @JoinColumn(name = "idUsuario") })
	 * private Set<Usuario> amigoDosUsuarios = new HashSet<Usuario>();
	 */

	private String localizacao;
	private String dataNascimento;
	
	@Column
	private String avatar;
	

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIdade() throws java.text.ParseException{
		
		if(dataNascimento != null) {

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    String dateInString = dataNascimento;
			Date date = formatter.parse(dateInString);
			Calendar dateOfBirth = new GregorianCalendar();
			dateOfBirth.setTime(date);
			Calendar today = Calendar.getInstance();
			int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
			dateOfBirth.add(Calendar.YEAR, age);
			if (today.before(dateOfBirth)) {
				age--;
			}
			return age + " anos";
		} else {
			return "";
		}
	}
	
	public void setUsuarioPerseguido(boolean usuarioPerseguido) {
		this.usuarioPerseguido = usuarioPerseguido;
	}
	
	public boolean isUsuarioPerseguido() {
		return usuarioPerseguido;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
