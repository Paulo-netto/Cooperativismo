package com.br.cooperativismo.domain.dto.voto;

public class VotoDTO {

	private Long votosSim;
	private Long votosNao;
	private Long TipoVotacaoPautaId;
	private String cpf;
	private Boolean voto;
	private Boolean votoSucesso;
	private String TipoVotacaoPautaDescricao;

	public VotoDTO() {
	}

	public VotoDTO(Long votosSim, Long votosNao, Long tipoVotacaoPautaId, String cpf, Boolean voto, Boolean votoSucesso,
			String tipoVotacaoPautaDescricao) {
		this.votosSim = votosSim;
		this.votosNao = votosNao;
		this.TipoVotacaoPautaId = tipoVotacaoPautaId;
		this.cpf = cpf;
		this.voto = voto;
		this.votoSucesso = votoSucesso;
		this.TipoVotacaoPautaDescricao = tipoVotacaoPautaDescricao;
	}

	public VotoDTO(Boolean votoSucesso) {
		this.votoSucesso = votoSucesso;
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

	public Long getTipoVotacaoPautaId() {
		return TipoVotacaoPautaId;
	}

	public void setTipoVotacaoPautaId(Long tipoVotacaoPautaId) {
		TipoVotacaoPautaId = tipoVotacaoPautaId;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getVoto() {
		return voto;
	}

	public void setVoto(Boolean voto) {
		this.voto = voto;
	}

	public Boolean getVotoSucesso() {
		return votoSucesso;
	}

	public void setVotoSucesso(Boolean votoSucesso) {
		this.votoSucesso = votoSucesso;
	}

	public String getTipoVotacaoPautaDescricao() {
		return TipoVotacaoPautaDescricao;
	}

	public void setTipoVotacaoPautaDescricao(String tipoVotacaoPautaDescricao) {
		TipoVotacaoPautaDescricao = tipoVotacaoPautaDescricao;
	}

}
