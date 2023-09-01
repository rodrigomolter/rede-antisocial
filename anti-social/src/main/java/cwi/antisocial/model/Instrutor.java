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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * Esta classe foi criada como exemplo e pode ser excluída.
 * As classes Disciplina e Instrutor mostram 
 * exemplos de como são o mapeamento 1 pra muitos/muitos pra um.
 */
@Entity
public class Instrutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInstrutor;
	
	@Column(nullable = false)
	private String nome;
	
	//UM instrutor para MUITAS disciplinas
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="instrutor", targetEntity = Disciplina.class)
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public void adicionarDisciplina(Disciplina disciplina){
		disciplina.setInstrutor(this);
		this.disciplinas.add(disciplina);
	}
	public Integer getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(Integer idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	
}
