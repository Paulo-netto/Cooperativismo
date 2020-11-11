package com.br.cooperativismo.domain.dto.tipovotacao;

public class TipoVotacaoRespostaDTO {

	private String descricao;

	public TipoVotacaoRespostaDTO() {
	}

	public TipoVotacaoRespostaDTO(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
