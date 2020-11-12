package com.br.cooperativismo.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.cooperativismo.domain.dto.sessao.SessaoPedidoDTO;
import com.br.cooperativismo.domain.model.Sessao;
import com.br.cooperativismo.exception.NegocioExeption;
import com.br.cooperativismo.service.adapter.SessaoAdapter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Endpoints de Sessão" })
@RequestMapping(value = "sessao")
public class SessaoControllers {

	private Logger log = LoggerFactory.getLogger(SessaoControllers.class);

	@Autowired
	private SessaoAdapter sessao;

	public SessaoControllers(SessaoAdapter sessao) {
		this.sessao = sessao;
	}

	@RequestMapping(value = "/{codigoPauta}/nova", method = RequestMethod.POST)
	@ApiOperation(value = "Abrir uma sessao", response = Sessao.class)
	public ResponseEntity<?> abrirSessao(@PathVariable Long codigoPauta, @RequestBody @Valid SessaoPedidoDTO pedido) {
		log.debug("Requisição REST para abrir uma Sessao o : {}", pedido);
		sessao.abrirSessaoAdapter(codigoPauta, pedido);
		return ResponseEntity.ok().build();
	}

	@ExceptionHandler(NegocioExeption.class)
	public ResponseEntity<JsonNode> handleExceptionServeErro(NegocioExeption e) {
		HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;
		ObjectNode jsonNode = new ObjectMapper().createObjectNode();
		jsonNode.put("status", badRequest.value());
		jsonNode.put("message", e.getMessage());
		return ResponseEntity.status(badRequest).body(jsonNode);
	}

}
