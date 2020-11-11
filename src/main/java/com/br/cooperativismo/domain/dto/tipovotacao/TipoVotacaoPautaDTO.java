package com.br.cooperativismo.domain.dto.tipovotacao;

public class TipoVotacaoPautaDTO {

	private Long TipoVotacaoPautaId;
	private String descricao;

	public TipoVotacaoPautaDTO() {
	}

	public TipoVotacaoPautaDTO(Long tipoVotacaoPautaId, String descricao) {
		TipoVotacaoPautaId = tipoVotacaoPautaId;
		this.descricao = descricao;
	}

	public Long getTipoVotacaoPautaId() {
		return TipoVotacaoPautaId;
	}

	public void setTipoVotacaoPautaId(Long tipoVotacaoPautaId) {
		TipoVotacaoPautaId = tipoVotacaoPautaId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
