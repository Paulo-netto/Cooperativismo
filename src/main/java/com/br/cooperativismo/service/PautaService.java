package com.br.cooperativismo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.cooperativismo.repository.PautaRepository;

@Service
@Transactional
public class PautaService {
	
	private PautaRepository pautaRepository;

}
