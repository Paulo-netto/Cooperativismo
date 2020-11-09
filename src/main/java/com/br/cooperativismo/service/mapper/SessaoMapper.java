package com.br.cooperativismo.service.mapper;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.br.cooperativismo.domain.dto.SessaoDTO;
import com.br.cooperativismo.domain.model.Sessao;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;

/**
 * Classe responsável pelo mapeamento de um {@link Sessao}.
 */
@Component
public class SessaoMapper {

	public static Sessao mapper(SessaoDTO dto, TipoVotacaoPauta pauta, LocalDateTime tempo) {
		Sessao sessao = new Sessao();
		sessao.setTipoVotacaoPauta(pauta);
		sessao.setTempoInicial(tempo);
		sessao.setTempoFinal(getFinalVoto(sessao.getTempoInicial(), tempo));
		return sessao;
	}

	public static SessaoDTO mapper(Sessao sessao) {
		return new SessaoDTO(Objects.nonNull(sessao));
	}

	/**
	 * Metodo responsavel para saber qual foi tempo final da sessao ou deixar como
	 * 1min default;
	 * 
	 * @param tempoInicial
	 * @param tempoFinal
	 * @return
	 */
	private static LocalDateTime getFinalVoto(LocalDateTime tempoInicial, LocalDateTime tempoFinal) {
		if (Objects.isNull(tempoFinal)) {
			return tempoInicial.plusMinutes(1);
		}
		return tempoFinal;
	}

}
