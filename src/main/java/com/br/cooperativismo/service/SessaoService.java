package com.br.cooperativismo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.cooperativismo.repository.SessaoRepositoy;

@Service
@Transactional
public class SessaoService {

	@Autowired
	private SessaoRepositoy sessaoRepositoy;
	@Autowired
	private TipoVotacaoPautaService tipoVotacaoPautaService;

	public SessaoService(SessaoRepositoy sessaoRepositoy, TipoVotacaoPautaService tipoVotacaoPautaService) {
		this.sessaoRepositoy = sessaoRepositoy;
		this.tipoVotacaoPautaService = tipoVotacaoPautaService;
	}

	
}
