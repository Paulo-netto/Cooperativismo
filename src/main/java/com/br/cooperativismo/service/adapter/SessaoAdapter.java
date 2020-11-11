package com.br.cooperativismo.service.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.cooperativismo.domain.dto.sessao.SessaoDTO;
import com.br.cooperativismo.domain.dto.sessao.SessaoPedidoDTO;
import com.br.cooperativismo.service.SessaoService;
import com.br.cooperativismo.service.mapper.SessaoMapper;

@Component
public class SessaoAdapter {

	@Autowired
	private SessaoService service;

	public void abrirSessaoAdapter(Long tipoVotacaoId, SessaoPedidoDTO pedido) {
		SessaoDTO dto = SessaoMapper.mapper(tipoVotacaoId, pedido);
		SessaoMapper.mapper(service.abrirSessao(dto));
	}

}
