package com.br.cooperativismo.service.mapper;

import org.springframework.stereotype.Component;

import com.br.cooperativismo.domain.dto.tipovotacao.TipoVotacaoPautaDTO;
import com.br.cooperativismo.domain.dto.tipovotacao.TipoVotacaoPedidoDTO;
import com.br.cooperativismo.domain.dto.tipovotacao.TipoVotacaoRespostaDTO;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.exception.NegocioExeption;
import com.br.cooperativismo.util.ConstantsUtil;

/**
 * Classe responsável pelo mapeamento de um {@link TipoVotacaoPauta}.
 */

@Component
public class TipoVotacaoPautaMapper {

	public static TipoVotacaoPautaDTO mapper(TipoVotacaoPauta pauta) {
		TipoVotacaoPautaDTO dto = new TipoVotacaoPautaDTO();
		dto.setDescricao(pauta.getDescricao());
		dto.setTipoVotacaoPautaId(pauta.getId());
		return dto;
	}

	public static TipoVotacaoPauta mapper(TipoVotacaoPautaDTO dto) {
		TipoVotacaoPauta pauta = new TipoVotacaoPauta();
		pauta.setDescricao(dto.getDescricao());
		return pauta;
	}

	public static TipoVotacaoPautaDTO mapper(TipoVotacaoPedidoDTO pedido) {
		if (!pedido.getDescricao().isEmpty()) {
			TipoVotacaoPautaDTO dto = new TipoVotacaoPautaDTO();
			dto.setDescricao(pedido.getDescricao());
			return dto;
		}	
		throw new NegocioExeption(ConstantsUtil.SEM_DESCRICAO);
	}
	
	public static TipoVotacaoRespostaDTO mapperResposta(TipoVotacaoPautaDTO dto) {
		TipoVotacaoRespostaDTO resposta = new TipoVotacaoRespostaDTO();
		resposta.setDescricao(dto.getDescricao());
		return resposta;
	}
	
	

}
