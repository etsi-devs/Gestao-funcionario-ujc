package mz.ac.ujc.esa.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractEntity<Long> {

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false)
	private String distrito;

	@Column(nullable = false)
	private String bairro;

	@Column(nullable = true)
	private String rua;

	@Column(nullable = false)
	private Integer numeroDeCasa;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumeroDeCasa() {
		return numeroDeCasa;
	}

	public void setNumeroDeCasa(Integer numeroDeCasa) {
		this.numeroDeCasa = numeroDeCasa;
	}

}
