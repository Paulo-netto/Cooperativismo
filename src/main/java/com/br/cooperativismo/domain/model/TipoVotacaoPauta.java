package com.br.cooperativismo.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_votacao_pauta")
public class TipoVotacaoPauta implements Serializable {

	private static final long serialVersionUID = -8140475595313680784L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipo_votacao_pauta_id")
	private Long id;

	@Column(name = "descricao")
	private String descricao;

	@OneToOne(mappedBy = "tipoVotacaoPauta")
	private Sessao sessao;

	public TipoVotacaoPauta() {
		super();
	}

	public TipoVotacaoPauta(Long id, String descricao, Sessao sessao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.sessao = sessao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((sessao == null) ? 0 : sessao.hashCode());
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
		TipoVotacaoPauta other = (TipoVotacaoPauta) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (sessao == null) {
			if (other.sessao != null)
				return false;
		} else if (!sessao.equals(other.sessao))
			return false;
		return true;
	}

}
