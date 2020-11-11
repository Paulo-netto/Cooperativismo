package com.br.cooperativismo.service.mapper;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.br.cooperativismo.domain.dto.tipovotacao.TipoVotacaoRespostaDTO;
import com.br.cooperativismo.domain.dto.voto.SimNaoDTO;
import com.br.cooperativismo.domain.dto.voto.VotoDTO;
import com.br.cooperativismo.domain.dto.voto.VotoPedidoDTO;
import com.br.cooperativismo.domain.dto.voto.VotoRespostaDTO;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.domain.model.Voto;
import com.br.cooperativismo.util.ConstantsUtil;

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

	public static VotoRespostaDTO mapper(VotoDTO dto, String tipoVotacaoPautaDescricao) {
		return new VotoRespostaDTO(new TipoVotacaoRespostaDTO(dto.getDescricao()),
				new SimNaoDTO(dto.getVotosSim(), dto.getVotosNao()), contagem(dto.getVotosSim(), dto.getVotosNao()));

	}

	/**
	 * Metodo responsavel por saber como está a contagem de votos
	 * 
	 * @param votosSim
	 * @param votosNao
	 * @return
	 */
	private static String contagem(Long votosSim, Long votosNao) {
		if (Objects.equals(votosSim, votosNao)) {
			return ConstantsUtil.CONTAGEM_IGUAL;
		} else if (votosSim > votosNao) {
			return ConstantsUtil.VOTOS_SIM_MAIORES;
		}
		return ConstantsUtil.VOTOS_NAO_MAIORES;
	}

	public static VotoRespostaDTO mapper(VotoDTO dto) {
		if (Objects.isNull(dto)) {
			return new VotoRespostaDTO(ConstantsUtil.VOTO_CERTO);
		}
		return new VotoRespostaDTO(ConstantsUtil.VOTO_ERRADO);
	}

	public static VotoDTO mapper(Long tipoVotacaoPedidoId, VotoPedidoDTO pedido) {
		VotoDTO dto = new VotoDTO();
		dto.setTipoVotacaoPautaId(tipoVotacaoPedidoId);
		dto.setDescricao(pedido.getDescricao());
		dto.setVoto(pedido.getVoto());
		return dto;
	}

}
