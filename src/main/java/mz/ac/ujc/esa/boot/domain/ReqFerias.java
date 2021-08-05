package mz.ac.ujc.esa.boot.domain;

import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "REQ_FERIAS")
public class ReqFerias extends AbstractEntity<Long> {

	@Column(name = "data_inicio", nullable = false, columnDefinition = "DATE")
	private Date data_inicio;

	@Column(name = "data_fim", nullable = false, columnDefinition = "DATE")
	private Date data_fim;

	@Column(nullable = false)
	private String estado;

	@ManyToOne
	@JoinColumn(name = "funcionario_id_fk", nullable = false)
	private Funcionario funcionario;

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
