package com.br.cooperativismo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.cooperativismo.domain.dto.sessao.SessaoDTO;
import com.br.cooperativismo.domain.model.Sessao;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.exception.NegocioExeption;
import com.br.cooperativismo.repository.SessaoRepositoy;
import com.br.cooperativismo.service.mapper.SessaoMapper;
import com.br.cooperativismo.util.ConstantsUtil;

@Service
public class SessaoService {

	@Autowired
	private SessaoRepositoy sessaoRepositoy;
	@Autowired
	private TipoVotacaoPautaService tipoVotacaoPautaService;

	public SessaoDTO abrirSessao(SessaoDTO dto) {

		Optional<TipoVotacaoPauta> tipoVotacaoPautaID = tipoVotacaoPautaService.findById(dto.getTipoVotacaoPautaId());
		if (!tipoVotacaoPautaID.isPresent()) {
			throw new NegocioExeption(ConstantsUtil.PAUTA_NAO_EXISTE);
		}
		Sessao entidade = SessaoMapper.mapper(dto, tipoVotacaoPautaID.get(), dto.getVotoFinal());
		Sessao salvar = sessaoRepositoy.save(entidade);
		return SessaoMapper.mapper(salvar);

	}

	public Boolean hasSessaoAberta(TipoVotacaoPauta tipoVotacaoPauta) {

		Optional<Sessao> optional = sessaoRepositoy.findById(tipoVotacaoPauta.getId());
		if (optional.isPresent()) {
			return LocalDateTime.now().isBefore(optional.get().getTempoFinal());
		}
		throw new NegocioExeption(ConstantsUtil.SESSAO_FECHADA);

	}

}
