package com.br.cooperativismo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cooperativismo.domain.dto.tipovotacao.TipoVotacaoPautaDTO;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.exception.NotFoundException;
import com.br.cooperativismo.repository.TipoVotacaoPautaRepository;
import com.br.cooperativismo.service.mapper.TipoVotacaoPautaMapper;
import com.br.cooperativismo.util.ConstantsUtil;

@Service
public class TipoVotacaoPautaService {

	@Autowired
	private TipoVotacaoPautaRepository tipoVotacaoPautaRepository;

	public TipoVotacaoPautaDTO salvarTipoVotacaoPauta(TipoVotacaoPautaDTO dto) {

		if (!dto.getDescricao().isEmpty()) {
			TipoVotacaoPauta tipo = TipoVotacaoPautaMapper.mapper(dto);
			TipoVotacaoPauta salvar = tipoVotacaoPautaRepository.save(tipo);
			return TipoVotacaoPautaMapper.mapper(salvar);
		}
		throw new NotFoundException(ConstantsUtil.SEM_DESCRICAO);

	}

	public Optional<TipoVotacaoPauta> findById(Long id) {
		return tipoVotacaoPautaRepository.findById(id);
	}
}
