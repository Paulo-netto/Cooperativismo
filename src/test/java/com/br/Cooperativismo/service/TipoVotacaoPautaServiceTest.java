package com.br.Cooperativismo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.cooperativismo.domain.dto.tipovotacao.TipoVotacaoPautaDTO;
import com.br.cooperativismo.domain.model.Sessao;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.exception.NotFoundException;
import com.br.cooperativismo.repository.TipoVotacaoPautaRepository;
import com.br.cooperativismo.service.TipoVotacaoPautaService;

@SpringBootTest
class TipoVotacaoPautaServiceTest {
	
	private static final int TEST_INT = 10;

	private static final long TEST_ID = 1L;

	private static final String TEST_STRING = "teste";

	@Mock
	private TipoVotacaoPautaRepository tipoVotacaoPautaRepository;

	@InjectMocks
	private TipoVotacaoPautaService tipoVotacaoPautaService;

	@Test
	void testFindById() {
		Mockito.when(tipoVotacaoPautaRepository.findById(Mockito.anyLong())).thenReturn(getTipoVotacaoPautaOptional());
		assertNotNull(tipoVotacaoPautaService.findById(Mockito.anyLong()));
	}

	@Test
	void testSalvarTipoVotacaoPauta() {
		Mockito.when(tipoVotacaoPautaRepository.findById(Mockito.anyLong())).thenReturn(getTipoVotacaoPautaOptional());
		Mockito.when(tipoVotacaoPautaRepository.save(Mockito.any())).thenReturn(getTipoVotacaoPautaAberta());
		assertNotNull(tipoVotacaoPautaService.salvarTipoVotacaoPauta(getTipoVotacaoPautaAbertaDTO()));
	}

	@Test()
	void testSalvarNotFoundException() {
		Mockito.when(tipoVotacaoPautaRepository.findById(Mockito.anyLong())).thenReturn(getTipoVotacaoPautaOptional());
		Mockito.when(tipoVotacaoPautaRepository.save(Mockito.any())).thenReturn(getTipoVotacaoPautaAberta());
		assertThrows(NotFoundException.class,
				() -> tipoVotacaoPautaService.salvarTipoVotacaoPauta(getTipoVotacaoPautaAbertaDTOSemDescricao()));
	}

	private Optional<TipoVotacaoPauta> getTipoVotacaoPautaOptional() {
		TipoVotacaoPauta pauta = new TipoVotacaoPauta();
		pauta.setId(1L);
		pauta.setDescricao(TEST_STRING);
		pauta.setSessao(getOptionalSessaoAberta().get());
		return Optional.of(pauta);
	}

	private Optional<Sessao> getOptionalSessaoAberta() {
		Sessao sessao = new Sessao();
		sessao.setId(TEST_ID);
		sessao.setTempoInicial(LocalDateTime.now());
		sessao.setTempoFinal(LocalDateTime.now().plusMinutes(TEST_INT));
		sessao.setTipoVotacaoPauta(new TipoVotacaoPauta());
		return Optional.of(sessao);
	}

	private TipoVotacaoPauta getTipoVotacaoPautaAberta() {
		TipoVotacaoPauta pauta = new TipoVotacaoPauta();
		pauta.setId(TEST_ID);
		pauta.setDescricao(TEST_STRING);
		pauta.setSessao(getOptionalSessaoAberta().get());
		return pauta;
	}

	private TipoVotacaoPautaDTO getTipoVotacaoPautaAbertaDTO() {
		TipoVotacaoPautaDTO dto = new TipoVotacaoPautaDTO();
		dto.setDescricao(TEST_STRING);
		dto.setTipoVotacaoPautaId(TEST_ID);
		return dto;
	}

	private TipoVotacaoPautaDTO getTipoVotacaoPautaAbertaDTOSemDescricao() {
		TipoVotacaoPautaDTO dto = new TipoVotacaoPautaDTO();
		dto.setTipoVotacaoPautaId(TEST_ID);
		dto.setDescricao("");
		return dto;
	}

}
