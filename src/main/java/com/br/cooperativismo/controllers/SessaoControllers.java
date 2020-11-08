package com.br.cooperativismo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.cooperativismo.service.SessaoService;

@RestController
@RequestMapping("/api/estabelecimentos")
public class SessaoControllers {

	@Autowired
	private SessaoService sessaoService;

	public SessaoControllers(SessaoService sessaoService) {
		super();
		this.sessaoService = sessaoService;
	}

}
