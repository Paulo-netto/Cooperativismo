package com.br.cooperativismo.domain.dto.voto;

import javax.validation.constraints.NotEmpty;

public class VotoPedidoDTO {

	private Boolean voto;
	@NotEmpty(message = "O CPF não pode ser vazia")
	private String cpf;

	public VotoPedidoDTO() {
	}

	public VotoPedidoDTO(Boolean voto, String cpf) {
		this.voto = voto;
		this.cpf = cpf;
	}

	public Boolean getVoto() {
		return voto;
	}

	public void setVoto(Boolean voto) {
		this.voto = voto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
