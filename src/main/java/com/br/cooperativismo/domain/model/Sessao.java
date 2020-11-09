package com.br.cooperativismo.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sessao")
public class Sessao implements Serializable {

	private static final long serialVersionUID = -7248876188302336693L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne()
	@JoinColumn(name = "tipo_votacao_pauta_id")
	private TipoVotacaoPauta tipoVotacaoPauta;

	@Column(name = "tempo_inicial_sessao")
	private LocalDateTime tempoInicial;

	@Column(name = "tempo_final_sessao")
	private LocalDateTime tempoFinal;

	public Sessao() {
		super();
	}

	public Sessao(Long id, TipoVotacaoPauta tipoVotacaoPauta, LocalDateTime tempoInicial, LocalDateTime tempoFinal) {
		super();
		this.id = id;
		this.tipoVotacaoPauta = tipoVotacaoPauta;
		this.tempoInicial = tempoInicial;
		this.tempoFinal = tempoFinal;
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

	public LocalDateTime getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoInicial(LocalDateTime tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	public LocalDateTime getTempoFinal() {
		return tempoFinal;
	}

	public void setTempoFinal(LocalDateTime tempoFinal) {
		this.tempoFinal = tempoFinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tempoFinal == null) ? 0 : tempoFinal.hashCode());
		result = prime * result + ((tempoInicial == null) ? 0 : tempoInicial.hashCode());
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
		Sessao other = (Sessao) obj;
		if (tempoFinal == null) {
			if (other.tempoFinal != null)
				return false;
		} else if (!tempoFinal.equals(other.tempoFinal))
			return false;
		if (tempoInicial == null) {
			if (other.tempoInicial != null)
				return false;
		} else if (!tempoInicial.equals(other.tempoInicial))
			return false;
		if (tipoVotacaoPauta == null) {
			if (other.tipoVotacaoPauta != null)
				return false;
		} else if (!tipoVotacaoPauta.equals(other.tipoVotacaoPauta))
			return false;
		return true;
	}

}
