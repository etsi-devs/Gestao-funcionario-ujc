package mz.ac.ujc.esa.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "TELEFONE")
public class Telefone extends AbstractEntity<Long> {

	
	@Column(name = "numero", nullable = false, unique = true)
	private Integer numero;
	
	@ManyToOne
	@JoinColumn(name="funcionario_id_fk", nullable=false) 
	private Funcionario funcionario;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
