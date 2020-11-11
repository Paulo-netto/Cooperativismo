package com.br.cooperativismo.service.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.cooperativismo.domain.dto.voto.VotoDTO;
import com.br.cooperativismo.domain.dto.voto.VotoPedidoDTO;
import com.br.cooperativismo.domain.dto.voto.VotoRespostaDTO;
import com.br.cooperativismo.service.VotoService;
import com.br.cooperativismo.service.mapper.VotoMapper;

@Component
public class VotoAdapter {

	@Autowired
	private VotoService votoService;

	public void vota(Long tipoVotacaoPedidoId, VotoPedidoDTO pedido) {
		VotoDTO mapper = VotoMapper.mapper(tipoVotacaoPedidoId, pedido);
		VotoDTO service = votoService.vote(mapper);
		VotoMapper.mapper(service);
	}

	public VotoRespostaDTO resultadoVotacao(Long tipoVotacaoPedidoId) {
		VotoDTO mapper = VotoMapper.mapper(tipoVotacaoPedidoId);
		VotoDTO service = votoService.votacao(mapper);
		VotoRespostaDTO resultado = VotoMapper.mapper(service, service.getTipoVotacaoPautaDescricao());
		return resultado;
	}

}
