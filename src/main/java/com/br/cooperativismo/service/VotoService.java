package com.br.cooperativismo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.cooperativismo.repository.VotoRepository;

@Service
@Transactional
public class VotoService {
	
	private VotoRepository votoRepository;

}
