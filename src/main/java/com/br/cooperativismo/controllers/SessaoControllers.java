package com.br.cooperativismo.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.cooperativismo.domain.dto.sessao.SessaoPedidoDTO;
import com.br.cooperativismo.domain.model.Sessao;
import com.br.cooperativismo.service.adapter.SessaoAdapter;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("sessoes")
public class SessaoControllers {

	private Logger log = LoggerFactory.getLogger(SessaoControllers.class);

	@Autowired
	private SessaoAdapter sessao;

	public SessaoControllers(SessaoAdapter sessao) {
		this.sessao = sessao;
	}
	
	@RequestMapping(value = "/{tipoVotacaoId}/abrir-sessao", method = RequestMethod.POST)
	@ApiOperation(value = "Abrir uma sessao", response = Sessao.class)
	public ResponseEntity<?> abrirSessao(@PathVariable Long tipoVotacaoId, @RequestBody @Valid SessaoPedidoDTO pedido) {
		log.debug("Requisição REST para abrir uma Sessao o : {}", pedido);
		sessao.abrirSessaoAdapter(tipoVotacaoId, pedido);
		return ResponseEntity.ok().build();
	}

}
