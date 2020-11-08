package com.br.cooperativismo.domain.enumeration;

public enum SimNaoEnum {

	SIM("S"), NAO("N");

	private String opcao;

	SimNaoEnum(String opcao) {
		this.opcao = opcao;
	}

	public String getOpcao() {
		return this.opcao;
	}

}
