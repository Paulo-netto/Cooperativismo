package com.br.cooperativismo.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.cooperativismo.domain.dto.voto.VotoPedidoDTO;
import com.br.cooperativismo.domain.model.Voto;
import com.br.cooperativismo.exception.NegocioException;
import com.br.cooperativismo.exception.NotFoundException;
import com.br.cooperativismo.service.adapter.VotoAdapter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Endpoints de Votacao" })
@RequestMapping("votacao")
public class VotoControllers {

	private Logger log = LoggerFactory.getLogger(VotoControllers.class);

	@Autowired
	private VotoAdapter VotoAdapter;

	@PostMapping
	@ApiOperation(value = "Cadastrar um novo voto", response = Voto.class)
	public ResponseEntity<?> salvar(@RequestParam Long tipoVotacaoPautaId,  @RequestBody @Valid VotoPedidoDTO pedido) {
		log.info("Requisição REST para cadastrar um voto o : {}", pedido);
		VotoAdapter.vota(tipoVotacaoPautaId, pedido);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{codigoPauta}")
	@ApiOperation(value = "Retornar o resultado da votação", response = Voto.class)
	public ResponseEntity<?> getResultadoVotacao(@PathVariable Long codigoPauta) {
		log.debug("Requisição REST para retornar o resultado da votacao : {}", codigoPauta);
		return ResponseEntity.ok(VotoAdapter.resultadoVotacao(codigoPauta));
	}

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<JsonNode> handleExceptionServeErro(NegocioException e) {
		HttpStatus error = HttpStatus.INTERNAL_SERVER_ERROR;
		ObjectNode jsonNode = new ObjectMapper().createObjectNode();
		jsonNode.put("Mensagem", e.getMessage());
		return ResponseEntity.status(error).body(jsonNode);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<JsonNode> handleException(NotFoundException e) {
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ObjectNode jsonNode = new ObjectMapper().createObjectNode();
		jsonNode.put("Mensagem", e.getMessage());
		return ResponseEntity.status(badRequest).body(jsonNode);
	}

}
