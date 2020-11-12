package com.br.cooperativismo.domain.dto.voto;

import javax.validation.constraints.NotEmpty;

import com.br.cooperativismo.domain.dto.tipovotacao.TipoVotacaoRespostaDTO;

public class VotoRespostaDTO {

	@NotEmpty(message = "O CPF não pode ser vazia")
	private String cpf;
	private TipoVotacaoRespostaDTO pauta;
	private SimNaoDTO resumoVotacao;

	public VotoRespostaDTO() {
	}

	public VotoRespostaDTO(String cpf) {
		this.cpf = cpf;
	}

	public VotoRespostaDTO(TipoVotacaoRespostaDTO tipoVotacaoRespostaDTO, SimNaoDTO simNaoDTO, String cpf) {
		this.cpf = cpf;
		this.pauta = tipoVotacaoRespostaDTO;
		this.resumoVotacao = simNaoDTO;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoVotacaoRespostaDTO getPauta() {
		return pauta;
	}

	public void setPauta(TipoVotacaoRespostaDTO pauta) {
		this.pauta = pauta;
	}

	public SimNaoDTO getResumoVotacao() {
		return resumoVotacao;
	}

	public void setResumoVotacao(SimNaoDTO resumoVotacao) {
		this.resumoVotacao = resumoVotacao;
	}

}
