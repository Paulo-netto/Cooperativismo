package com.br.cooperativismo.service.mapper;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.br.cooperativismo.domain.dto.VotoDTO;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.domain.model.Voto;

/**
 * Classe responsável pelo mapeamento de um {@link Voto}.
 */
@Component
public class VotoMapper {

	public static Voto mapper(TipoVotacaoPauta tipoVotacaoPauta, VotoDTO dto) {
		return new Voto(tipoVotacaoPauta, dto.getDescricao(), dto.getVoto());
	}

	public static VotoDTO mapper(Voto voto) {
		return new VotoDTO(Objects.nonNull(voto));
	}

	public static VotoDTO mapper(TipoVotacaoPauta tipoVotacaoPauta, Long votosSim, Long votosNao) {
		VotoDTO dto = new VotoDTO();
		dto.setDescricao(tipoVotacaoPauta.getDescricao());
		dto.setVotosSim(votosSim);
		dto.setVotosNao(votosNao);
		return dto;
	}

	public static VotoDTO mapper(Long tipoVotacaoPautaId) {
		VotoDTO dto = new VotoDTO();
		dto.setTipoVotacaoPautaId(tipoVotacaoPautaId);
		return dto;
	}

}
