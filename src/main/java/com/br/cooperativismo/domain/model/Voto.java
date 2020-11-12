package com.br.cooperativismo.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voto")
public class Voto implements Serializable {

	private static final long serialVersionUID = -9040499939260737359L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne()
	@JoinColumn(name = "tipo_votacao_pauta_id")
	private TipoVotacaoPauta tipoVotacaoPauta;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "votoSimNao")
	private Boolean simOuNao;

	public Voto() {
	}

	public Voto(TipoVotacaoPauta tipoVotacaoPauta, String cpf, Boolean simOuNao) {
		this.tipoVotacaoPauta = tipoVotacaoPauta;
		this.cpf = cpf;
		this.simOuNao = simOuNao;
	}

	public Voto(Long id, TipoVotacaoPauta tipoVotacaoPauta, String cpf, Boolean simOuNao) {
		super();
		this.id = id;
		this.tipoVotacaoPauta = tipoVotacaoPauta;
		this.cpf = cpf;
		this.simOuNao = simOuNao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoVotacaoPauta getTipoVotacaoPauta() {
		return tipoVotacaoPauta;
	}

	public void setTipoVotacaoPauta(TipoVotacaoPauta tipoVotacaoPauta) {
		this.tipoVotacaoPauta = tipoVotacaoPauta;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getSimOuNao() {
		return simOuNao;
	}

	public void setSimOuNao(Boolean simOuNao) {
		this.simOuNao = simOuNao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((simOuNao == null) ? 0 : simOuNao.hashCode());
		result = prime * result + ((tipoVotacaoPauta == null) ? 0 : tipoVotacaoPauta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (simOuNao == null) {
			if (other.simOuNao != null)
				return false;
		} else if (!simOuNao.equals(other.simOuNao))
			return false;
		if (tipoVotacaoPauta == null) {
			if (other.tipoVotacaoPauta != null)
				return false;
		} else if (!tipoVotacaoPauta.equals(other.tipoVotacaoPauta))
			return false;
		return true;
	}

}
