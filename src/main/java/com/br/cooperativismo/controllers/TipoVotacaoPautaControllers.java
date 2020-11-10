package com.br.cooperativismo.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cooperativismo.domain.dto.TipoVotacaoPautaDTO;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.service.TipoVotacaoPautaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("tipo-votacoes")
public class TipoVotacaoPautaControllers {

	private Logger log = LoggerFactory.getLogger(TipoVotacaoPautaControllers.class);

	@Autowired
	private TipoVotacaoPautaService tipoVotacaoPautaService;

	@PostMapping
	@ApiOperation(value = "Criar um novo tipo de votacao na pauta", response = TipoVotacaoPauta.class)
	public ResponseEntity<Void> insertTopicVoting(@RequestBody @Valid TipoVotacaoPautaDTO dto) {
		log.debug("Requisição REST para criar um tipo de votacao o : {}", dto);
		tipoVotacaoPautaService.salvarTipoVotacaoPauta(dto);
		return ResponseEntity.ok().build();
	}

}
