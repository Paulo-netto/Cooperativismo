package com.br.cooperativismo.service.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.br.cooperativismo.domain.dto.SessaoDTO;
import com.br.cooperativismo.domain.model.Sessao;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;

/**
 * Classe responsável pelo mapeamento de um {@link Sessao}.
 */
@Component
public class SessaoMapper {

	public Sessao mapper(SessaoDTO dto, TipoVotacaoPauta pauta, LocalDateTime tempo) {
		Sessao sessao = new Sessao();
		sessao.setTipoVotacaoPauta(pauta);
		sessao.setTempoInicial(tempo);
		sessao.setTempoFinal(dto.getVotoFinal());
		return sessao;
	}

}
