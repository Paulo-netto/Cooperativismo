package com.br.cooperativismo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.cooperativismo.repository.SessaoRepositoy;

@Service
@Transactional
public class SessaoService {
	
	private SessaoRepositoy sessaoRepositoy;

}
