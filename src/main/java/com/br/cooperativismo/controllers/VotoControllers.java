package com.br.cooperativismo.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cooperativismo.domain.dto.VotoDTO;
import com.br.cooperativismo.domain.model.Voto;
import com.br.cooperativismo.service.VotoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("voto")
public class VotoControllers {

	private Logger log = LoggerFactory.getLogger(VotoControllers.class);

	@Autowired
	private VotoService votoService;

	@PostMapping
	@ApiOperation(value = "Cadastrar um novo voto", response = Voto.class)
	public ResponseEntity<?> salvar(@RequestBody @Valid VotoDTO dto) {
		log.debug("Requisição REST para cadastrar um voto o : {}", dto);
		VotoDTO voto = votoService.vote(dto);
		return new ResponseEntity<>(voto, HttpStatus.OK);
	}

	@GetMapping("/{TipoVotacaoPautaId}")
	@ApiOperation(value = "Retornar o resultado da votação", response = Voto.class)
	public ResponseEntity<?> getResultadoVotacao(@PathVariable Long tipoVotacaoPautaId) {
		log.debug("Requisição REST para retornar o resultado da votacao : {}", tipoVotacaoPautaId);
		return null;
	}

}
