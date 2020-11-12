package com.br.cooperativismo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.cooperativismo.domain.dto.voto.VotoDTO;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.domain.model.Voto;
import com.br.cooperativismo.exception.NegocioException;
import com.br.cooperativismo.exception.NotFoundException;
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
			if (optional.isPresent()) {
				if (sessaoService.isSessionAbertar(optional.get())) {
					return votar(dto, optional);
				}
				throw new NotFoundException(ConstantsUtil.SESSAO_FECHADA);
			}
			throw new NotFoundException(ConstantsUtil.NAO_POSSIVEL_VOTAR_NESTA_SESSAO);
		}
		throw new NegocioException(ConstantsUtil.NAO_APTO);

	}

	/**
	 * Metodo responsavel por salvar um voto na pauta
	 * 
	 * @param dto
	 * @param tipoVotacaoPauta
	 * @return
	 */
	private VotoDTO votar(VotoDTO dto, Optional<TipoVotacaoPauta> tipoVotacaoPauta) {
		Voto entidade = VotoMapper.mapper(tipoVotacaoPauta.get(), dto);
		Voto salvar = votoRepository.save(entidade);
		return VotoMapper.mapper(salvar);
	}

	public VotoDTO resultadoVotacao(VotoDTO dto) {

		Optional<TipoVotacaoPauta> optional = tipoVotacaoPautaService.findById(dto.getTipoVotacaoPautaId());
		if (optional.isPresent() && sessaoService.isSessionAbertar(optional.get())) {
			return VotoMapper.mapper(optional.get(),
					votoRepository.countByTipoVotacaoPautaAndSimOuNaoTrue(optional.get()),
					votoRepository.countByTipoVotacaoPautaAndSimOuNaoFalse(optional.get()));
		}
		throw new NotFoundException(ConstantsUtil.SESSAO_FECHADA_ERRO);

	}
}
