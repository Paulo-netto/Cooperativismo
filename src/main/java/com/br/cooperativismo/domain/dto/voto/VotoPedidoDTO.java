package com.br.cooperativismo.domain.dto.voto;

public class VotoPedidoDTO {

	private Boolean voto;
	private String descricao;

	public VotoPedidoDTO() {
	}

	public VotoPedidoDTO(Boolean voto, String descricao) {
		this.voto = voto;
		this.descricao = descricao;
	}

	public Boolean getVoto() {
		return voto;
	}

	public void setVoto(Boolean voto) {
		this.voto = voto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
