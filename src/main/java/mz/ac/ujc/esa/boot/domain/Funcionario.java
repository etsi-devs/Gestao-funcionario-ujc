package mz.ac.ujc.esa.boot.domain;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario extends AbstractEntity<Long> {

	@Column(nullable = false)
	private String nome;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_nascimento", nullable = false, columnDefinition = "DATE")
	private Date data_nasc;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_entrada", nullable = false, columnDefinition = "DATE")
	private Date dataEntrada;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_saida", columnDefinition = "DATE")
	private LocalDate dataSaida;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk", nullable = false)
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "departamento_id_fk")
	private Departamento departamento;

	@ManyToOne
	@JoinColumn(name = "tipo_id_fk", nullable = false)
	private Tipo tipo;

	@ManyToOne
	@JoinColumn(name = "nivelAcademico_id_fk", nullable = false)
	private NivelAcademico nivelAcademico;

	@OneToOne
	@JoinColumn(name = "cargo_id_fk")
	private Cargo cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public NivelAcademico getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(NivelAcademico nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}
