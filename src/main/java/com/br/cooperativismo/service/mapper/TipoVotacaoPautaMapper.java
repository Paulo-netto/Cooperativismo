package com.br.cooperativismo.service.mapper;

import org.springframework.stereotype.Component;

import com.br.cooperativismo.domain.dto.TipoVotacaoPautaDTO;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;

/**
 * Classe responsável pelo mapeamento de um {@link TipoVotacaoPauta}.
 */

@Component
public class TipoVotacaoPautaMapper {
	
	public TipoVotacaoPautaDTO mapper(TipoVotacaoPauta pauta) {
		TipoVotacaoPautaDTO dto = new TipoVotacaoPautaDTO();
		dto.setDescricao(pauta.getDescricao());
		dto.setTipoVotacaoPautaId(pauta.getId());
		return dto;
	}
	
	public TipoVotacaoPauta mapper(TipoVotacaoPautaDTO dto) {
		TipoVotacaoPauta pauta = new TipoVotacaoPauta();
		pauta.setDescricao(dto.getDescricao());
		return pauta;
	}

}
