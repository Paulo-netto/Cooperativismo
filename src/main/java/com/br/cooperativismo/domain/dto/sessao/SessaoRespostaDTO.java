package com.br.cooperativismo.domain.dto.sessao;

import javax.validation.constraints.NotEmpty;

public class SessaoRespostaDTO {

	@NotEmpty(message = "A descrição não pode ser vazia")
	private String descricao;

	public SessaoRespostaDTO() {
	}

	public SessaoRespostaDTO(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
