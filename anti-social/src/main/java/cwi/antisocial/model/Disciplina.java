package cwi.antisocial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Esta classe foi criada como exemplo e pode ser excluída.
 * As classes Disciplina e Instrutor mostram 
 * exemplos de como são o mapeamento 1 pra muitos/muitos pra um.
 */
@Entity
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDisciplina;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private Instrutor instrutor;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int dificuldade;
	
	public Integer getIdDisciplina() {
		return idDisciplina;
	}
	
	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	public Instrutor getInstrutor() {
		return instrutor;
	}
	
	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	
	public int getDificuldade() {
		return dificuldade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
