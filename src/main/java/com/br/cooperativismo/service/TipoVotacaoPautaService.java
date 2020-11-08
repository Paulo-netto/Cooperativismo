package com.br.cooperativismo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.cooperativismo.repository.TipoVotacaoPautaRepository;

@Service
@Transactional
public class TipoVotacaoPautaService {
	
	private TipoVotacaoPautaRepository tipoVotacaoPautaRepository;

}
