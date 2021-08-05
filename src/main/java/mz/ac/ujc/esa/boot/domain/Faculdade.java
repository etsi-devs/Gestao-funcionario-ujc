package mz.ac.ujc.esa.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="FACULDADE")
public class Faculdade extends AbstractEntity<Long> {

	@Column(name="nome", nullable=false, unique = true)
	private String nome;
	
	@Column(name="descricao", nullable =false, length = 60)
	private String descricao;
	
	@Column(name ="localizacao", nullable=false)
	private String localizacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	
}
