package com.br.cooperativismo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.cooperativismo.domain.dto.TipoVotacaoPautaDTO;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.repository.TipoVotacaoPautaRepository;
import com.br.cooperativismo.service.mapper.TipoVotacaoPautaMapper;

@Service
@Transactional
public class TipoVotacaoPautaService {

	@Autowired
	private TipoVotacaoPautaRepository tipoVotacaoPautaRepository;

	public TipoVotacaoPautaService(TipoVotacaoPautaRepository tipoVotacaoPautaRepository) {
		this.tipoVotacaoPautaRepository = tipoVotacaoPautaRepository;
	}

	public TipoVotacaoPautaDTO salvarTipoVotacaoPauta(TipoVotacaoPautaDTO dto) {
		TipoVotacaoPauta mapper = TipoVotacaoPautaMapper.mapper(dto);
		TipoVotacaoPauta salvar = tipoVotacaoPautaRepository.save(mapper);
		return TipoVotacaoPautaMapper.mapper(salvar);
	}

	public Optional<TipoVotacaoPauta> findById(Long id) {
		return tipoVotacaoPautaRepository.findById(id);
	}
}
