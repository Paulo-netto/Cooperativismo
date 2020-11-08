package com.br.cooperativismo.service.mapper;

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
		// TODO Auto-generated method stub
		return null;
	}

	public static VotoDTO mapper(Voto salvar) {
		// TODO Auto-generated method stub
		return null;
	}

	public static VotoDTO mapper(TipoVotacaoPauta tipoVotacaoPauta, Long votosSim, Long votosNao) {
		// TODO Auto-generated method stub
		return null;
	}

}
