package mz.ac.ujc.esa.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "TIPO")
public class Tipo extends AbstractEntity<Long> {

	@Column(nullable = false)
	private String designacao;

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

}
