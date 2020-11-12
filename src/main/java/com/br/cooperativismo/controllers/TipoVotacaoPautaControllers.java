package com.br.cooperativismo.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cooperativismo.domain.dto.tipovotacao.TipoVotacaoPedidoDTO;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.exception.NotFoundException;
import com.br.cooperativismo.service.adapter.TipoVotacaoPautaAdapter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@Api(tags = { "Endpoints de Pauta" })
@RequestMapping("pautas")
public class TipoVotacaoPautaControllers {

	private Logger log = LoggerFactory.getLogger(TipoVotacaoPautaControllers.class);

	@Autowired
	private TipoVotacaoPautaAdapter TipoVotacaoPautaAdapter;

	@PostMapping
	@ApiOperation(value = "Criar um novo tipo de votacao na pauta", response = TipoVotacaoPauta.class)
	public ResponseEntity<?> criarTipoVotacaoPauta(@RequestBody @Valid TipoVotacaoPedidoDTO pedido) {
		log.debug("Requisição REST para criar um tipo de votacao o : {}", pedido);
		TipoVotacaoPautaAdapter.salvar(pedido);
		return ResponseEntity.ok().build();
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<JsonNode> handleException(NotFoundException e) {
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ObjectNode jsonNode = new ObjectMapper().createObjectNode();
		jsonNode.put("Mensagem", e.getMessage());
		return ResponseEntity.status(badRequest).body(jsonNode);
	}

}
