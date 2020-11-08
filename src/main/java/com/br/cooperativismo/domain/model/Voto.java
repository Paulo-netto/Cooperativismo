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
@Table(name = "votos")
public class Voto implements Serializable{

	private static final long serialVersionUID = -9040499939260737359L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "voto_id")
	private Long id;

	@OneToOne()
	@JoinColumn(name = "pauta_id")
	private Pauta pauta;

	@Column(name = "voto_descricao")
	private String descricao;

	@Column(name = "votoSimNao")
	private Boolean voto;

	public Voto() {
		super();
	}

	public Voto(Long id, Pauta pauta, String descricao, Boolean voto) {
		super();
		this.id = id;
		this.pauta = pauta;
		this.descricao = descricao;
		this.voto = voto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getVoto() {
		return voto;
	}

	public void setVoto(Boolean voto) {
		this.voto = voto;
	}
	
	

}
