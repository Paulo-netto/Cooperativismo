package com.br.cooperativismo.domain.model;

import java.io.Serializable;

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

//	@Column(name = "descricao")
	private String descricao;

//	@Column(name = "votoSimNao")
	private Boolean simOuNao;

	public Voto() {
		super();
	}

	public Voto(Long id, TipoVotacaoPauta tipoVotacaoPauta, String descricao, Boolean simOuNao) {
		super();
		this.id = id;
		this.tipoVotacaoPauta = tipoVotacaoPauta;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getSimOuNao() {
		return simOuNao;
	}

	public void setSimOuNao(Boolean simOuNao) {
		this.simOuNao = simOuNao;
	}

}
