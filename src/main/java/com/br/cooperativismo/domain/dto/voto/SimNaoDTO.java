package com.br.cooperativismo.domain.dto.voto;

public class SimNaoDTO {

	private Long votosSim;
	private Long votosNao;

	public SimNaoDTO() {
	}

	public SimNaoDTO(Long votosSim, Long votosNao) {
		this.votosSim = votosSim;
		this.votosNao = votosNao;
	}

	public Long getVotosSim() {
		return votosSim;
	}

	public void setVotosSim(Long votosSim) {
		this.votosSim = votosSim;
	}

	public Long getVotosNao() {
		return votosNao;
	}

	public void setVotosNao(Long votosNao) {
		this.votosNao = votosNao;
	}

}
