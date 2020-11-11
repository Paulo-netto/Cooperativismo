package com.br.cooperativismo.service.mapper;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.br.cooperativismo.domain.dto.sessao.SessaoDTO;
import com.br.cooperativismo.domain.dto.sessao.SessaoPedidoDTO;
import com.br.cooperativismo.domain.dto.sessao.SessaoRespostaDTO;
import com.br.cooperativismo.domain.model.Sessao;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.util.ConstantsUtil;

/**
 * Classe responsável pelo mapeamento de um {@link Sessao}.
 */
@Component
public class SessaoMapper {

	public static Sessao mapper(SessaoDTO dto, TipoVotacaoPauta pauta, LocalDateTime tempo) {
		Sessao sessao = new Sessao();
		sessao.setTipoVotacaoPauta(pauta);
		sessao.setTempoInicial(LocalDateTime.now());
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

	public static SessaoDTO mapper(Long tipoVotacaoId, SessaoPedidoDTO pedido) {
		SessaoDTO dto = new SessaoDTO();
		dto.setTipoVotacaoPautaId(tipoVotacaoId);
		dto.setVotoFinal(pedido.getTempoFinal());
		return dto;
	}

	public static SessaoRespostaDTO mapper(SessaoDTO abrirSesao) {
		if (!abrirSesao.isSessaoAberta()) {
			return new SessaoRespostaDTO(ConstantsUtil.SESSAO_ABERTA);
		}
		return new SessaoRespostaDTO(ConstantsUtil.SESSAO_FECHADA);
	}

}
