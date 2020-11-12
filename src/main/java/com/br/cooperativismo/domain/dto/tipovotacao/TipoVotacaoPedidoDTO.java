package com.br.cooperativismo.domain.dto.tipovotacao;

import javax.validation.constraints.NotEmpty;

public class TipoVotacaoPedidoDTO {

	@NotEmpty(message = "A descrição não pode ser vazia")
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
