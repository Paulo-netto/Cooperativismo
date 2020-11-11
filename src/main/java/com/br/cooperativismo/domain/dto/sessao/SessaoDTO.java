package com.br.cooperativismo.domain.dto.sessao;

import java.time.LocalDateTime;

public class SessaoDTO {

	private Long TipoVotacaoPautaId;
	private LocalDateTime votoFinal;
	private boolean sessaoAberta;

	public SessaoDTO() {
	}

	public SessaoDTO(Long tipoVotacaoPautaId, LocalDateTime votoFinal, boolean sessaoAberta) {
		TipoVotacaoPautaId = tipoVotacaoPautaId;
		this.votoFinal = votoFinal;
		this.sessaoAberta = sessaoAberta;
	}

	public SessaoDTO(boolean sessaoAberta) {
		this.sessaoAberta = sessaoAberta;
	}

	public Long getTipoVotacaoPautaId() {
		return TipoVotacaoPautaId;
	}

	public void setTipoVotacaoPautaId(Long tipoVotacaoPautaId) {
		TipoVotacaoPautaId = tipoVotacaoPautaId;
	}

	public LocalDateTime getVotoFinal() {
		return votoFinal;
	}

	public void setVotoFinal(LocalDateTime votoFinal) {
		this.votoFinal = votoFinal;
	}

	public boolean isSessaoAberta() {
		return sessaoAberta;
	}

	public void setSessaoAberta(boolean sessaoAberta) {
		this.sessaoAberta = sessaoAberta;
	}

}
