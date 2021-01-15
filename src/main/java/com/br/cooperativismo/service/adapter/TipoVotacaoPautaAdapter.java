package com.br.cooperativismo.service.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.cooperativismo.domain.dto.tipovotacao.TipoVotacaoPautaDTO;
import com.br.cooperativismo.domain.dto.tipovotacao.TipoVotacaoPedidoDTO;
import com.br.cooperativismo.service.TipoVotacaoPautaService;
import com.br.cooperativismo.service.mapper.TipoVotacaoPautaMapper;

@Component
public class TipoVotacaoPautaAdapter {

	@Autowired
	private TipoVotacaoPautaService tipoVotacaoPautaService;

	public TipoVotacaoPautaAdapter(TipoVotacaoPautaService tipoVotacaoPautaService) {
		this.tipoVotacaoPautaService = tipoVotacaoPautaService;
	}

	public void salvar(TipoVotacaoPedidoDTO pedido) {
		TipoVotacaoPautaDTO dto = TipoVotacaoPautaMapper.mapper(pedido);
		TipoVotacaoPautaMapper.mapperResposta(tipoVotacaoPautaService.salvarTipoVotacaoPauta(dto));
		
	}
	
	
}
