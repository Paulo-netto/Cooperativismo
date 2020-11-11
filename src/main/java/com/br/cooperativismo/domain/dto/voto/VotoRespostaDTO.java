package com.br.cooperativismo.domain.dto.voto;

import com.br.cooperativismo.domain.dto.tipovotacao.TipoVotacaoRespostaDTO;

public class VotoRespostaDTO {

	private String descricao;
	private TipoVotacaoRespostaDTO tipoVotacaoRespostaDTO;
	private SimNaoDTO simNaoDTO;

	public VotoRespostaDTO() {
	}

	public VotoRespostaDTO(String descricao) {
		this.descricao = descricao;
	}

	public VotoRespostaDTO(TipoVotacaoRespostaDTO tipoVotacaoRespostaDTO, SimNaoDTO simNaoDTO, String descricao) {
		this.descricao = descricao;
		this.tipoVotacaoRespostaDTO = tipoVotacaoRespostaDTO;
		this.simNaoDTO = simNaoDTO;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoVotacaoRespostaDTO getTipoVotacaoAptoDTO() {
		return tipoVotacaoRespostaDTO;
	}

	public void setTipoVotacaoAptoDTO(TipoVotacaoRespostaDTO tipoVotacaoRespostaDTO) {
		this.tipoVotacaoRespostaDTO = tipoVotacaoRespostaDTO;
	}

	public SimNaoDTO getSimNaoDTO() {
		return simNaoDTO;
	}

	public void setSimNaoDTO(SimNaoDTO simNaoDTO) {
		this.simNaoDTO = simNaoDTO;
	}

}
