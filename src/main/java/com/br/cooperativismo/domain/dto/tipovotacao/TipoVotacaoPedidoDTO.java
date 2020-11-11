package com.br.cooperativismo.domain.dto.tipovotacao;


public class TipoVotacaoPedidoDTO {

	private String descricao;

	public TipoVotacaoPedidoDTO() {
	}

	public TipoVotacaoPedidoDTO(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
