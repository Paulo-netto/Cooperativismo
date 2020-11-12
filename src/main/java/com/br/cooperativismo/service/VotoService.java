package com.br.cooperativismo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.cooperativismo.domain.dto.voto.VotoDTO;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.domain.model.Voto;
import com.br.cooperativismo.exception.NegocioExeption;
import com.br.cooperativismo.repository.VotoRepository;
import com.br.cooperativismo.resttemplate.StatusInforVoto;
import com.br.cooperativismo.resttemplate.UserInfoApiRestCliente;
import com.br.cooperativismo.service.mapper.VotoMapper;
import com.br.cooperativismo.util.ConstantsUtil;

@Service
@Transactional
public class VotoService {

	@Autowired
	private VotoRepository votoRepository;

	@Autowired
	private TipoVotacaoPautaService tipoVotacaoPautaService;

	@Autowired
	private SessaoService sessaoService;

	@Autowired
	private UserInfoApiRestCliente restCliente;

	public VotoDTO vote(VotoDTO dto) {

		Optional<TipoVotacaoPauta> optional = tipoVotacaoPautaService.findById(dto.getTipoVotacaoPautaId());
		StatusInforVoto status = restCliente.consultarPermissaoParaVotar(dto.getCpf());
		if (status.isApto()) {
			validarSessaoDeVotacao(optional);
			Voto novoVoto = VotoMapper.mapper(optional.get(), dto);
			Voto votoSalvo = votoRepository.save(novoVoto);
			return VotoMapper.mapper(votoSalvo);
		}
		throw new NegocioExeption(ConstantsUtil.NAO_APTO);

	}

	public VotoDTO resultadoVotacao(VotoDTO dto) {

		Optional<TipoVotacaoPauta> optional = tipoVotacaoPautaService.findById(dto.getTipoVotacaoPautaId());
		validarSessaoDeVotacao(optional);
		return VotoMapper.mapper(optional.get(), votoRepository.countByTipoVotacaoPautaAndSimOuNaoTrue(optional.get()),
				votoRepository.countByTipoVotacaoPautaAndSimOuNaoFalse(optional.get()));
	}

	/**
	 * Metodo responsavel por validar a votação
	 * 
	 * @param tipoVotacaoPauta
	 */
	private void validarSessaoDeVotacao(Optional<TipoVotacaoPauta> tipoVotacaoPauta) {
		if (!tipoVotacaoPauta.isPresent()) {
			throw new NegocioExeption(ConstantsUtil.PAUTA_NAO_EXISTE);
		}
		if (!sessaoService.hasSessaoAberta(tipoVotacaoPauta.get())) {
			throw new NegocioExeption(ConstantsUtil.SESSAO_FECHADA);
		}

	}

}
