package com.br.cooperativismo.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cooperativismo.domain.dto.SessaoDTO;
import com.br.cooperativismo.domain.model.Sessao;
import com.br.cooperativismo.service.SessaoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("sessoes")
public class SessaoControllers {

	private Logger log = LoggerFactory.getLogger(SessaoControllers.class);

	@Autowired
	private SessaoService sessaoService;

	public SessaoControllers(SessaoService sessaoService) {
		this.sessaoService = sessaoService;
	}

	@PostMapping
	@ApiOperation(value = "Abrir uma sessao", response = Sessao.class)
	public ResponseEntity<?> abrirSessao(@RequestBody @Valid SessaoDTO dto) {
		log.debug("Requisição REST para abrir uma Sessao o : {}", dto);
		SessaoDTO sessao = sessaoService.abrirSessao(dto);
		return new ResponseEntity<>(sessao, HttpStatus.OK);
	}

}
