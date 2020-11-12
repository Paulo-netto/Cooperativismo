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
		VotoDTO votoPedido = VotoMapper.mapper(tipoVotacaoPedidoId, pedido);
		VotoDTO votoResposta = votoService.vote(votoPedido);
		VotoMapper.mapper(votoResposta);
	}

	public VotoRespostaDTO resultadoVotacao(Long tipoVotacaoPedidoId) {
		VotoDTO votoPedido = VotoMapper.mapper(tipoVotacaoPedidoId);
		VotoDTO votoResposta = votoService.resultadoVotacao(votoPedido);
		VotoRespostaDTO resultado = VotoMapper.mapper(votoResposta, votoResposta.getTipoVotacaoPautaDescricao());
		return resultado;
	}

}
