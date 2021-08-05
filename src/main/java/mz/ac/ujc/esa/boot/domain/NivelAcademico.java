package mz.ac.ujc.esa.boot.domain;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="NIVEL_ACADEMICO")
public class NivelAcademico extends AbstractEntity<Long> {

	@Column(nullable=false, unique = true)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
		
}
