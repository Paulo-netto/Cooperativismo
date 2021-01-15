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

import com.br.cooperativismo.domain.dto.sessao.SessaoDTO;
import com.br.cooperativismo.domain.model.Sessao;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.exception.NotFoundException;
import com.br.cooperativismo.repository.SessaoRepositoy;
import com.br.cooperativismo.service.SessaoService;
import com.br.cooperativismo.service.TipoVotacaoPautaService;

@SpringBootTest
class SessaoServiceTest {

	private static final int TEST_INT = 10;

	private static final long TEST_ID = 1L;

	private static final String TESTE_STRING = "teste";

	@Mock
	private SessaoRepositoy sessaoRepositoy;

	@Mock
	private TipoVotacaoPautaService tipoVotacaoPautaService;

	@InjectMocks
	private SessaoService sesssaoService;

	@Test
	void testAbrirSessao() {
		Mockito.when(tipoVotacaoPautaService.findById(Mockito.anyLong())).thenReturn(getTipoVotacaoPautaOptional());
		assertNotNull(sesssaoService.abrirSessao(getSessaoDTO()));
	}

	@Test
	void testAbrirSessaoNotFoundException() {
		Mockito.when(tipoVotacaoPautaService.findById(Mockito.anyLong())).thenReturn(getTipoVotacaoPautaOptional());
		assertThrows(NotFoundException.class, () -> sesssaoService.abrirSessao(getSessaoDTOSemPauta()));
	}

	@Test
	void testHasSessaoAberta() {
		Mockito.when(sessaoRepositoy.findByTipoVotacaoPauta(Mockito.any())).thenReturn(getOptionalSessaoAberta());
		assertNotNull(sesssaoService.isSessionAbertar(getTipoVotacaoPautaAberta()));

	}

	@Test
	void testHasSessaoFechada() {
		Mockito.when(sessaoRepositoy.findByTipoVotacaoPauta(null)).thenReturn(getOptionalSessaoAberta());
		assertThrows(NotFoundException.class, () -> sesssaoService.isSessionAbertar(getTipoVotacaoPautaAberta()));
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
		pauta.setDescricao(TESTE_STRING);
		pauta.setSessao(getOptionalSessaoAberta().get());
		return pauta;
	}

	private Optional<TipoVotacaoPauta> getTipoVotacaoPautaOptional() {
		TipoVotacaoPauta pauta = new TipoVotacaoPauta();
		pauta.setId(TEST_ID);
		pauta.setDescricao(TESTE_STRING);
		pauta.setSessao(getOptionalSessaoAberta().get());
		return Optional.of(pauta);
	}

	private SessaoDTO getSessaoDTO() {
		SessaoDTO dto = new SessaoDTO();
		dto.setTipoVotacaoPautaId(TEST_ID);
		dto.setSessaoAberta(Boolean.TRUE);
		dto.setVotoFinal(LocalDateTime.now().plusMinutes(TEST_INT));
		return dto;
	}

	private SessaoDTO getSessaoDTOSemPauta() {
		SessaoDTO dto = new SessaoDTO();
		dto.setSessaoAberta(Boolean.TRUE);
		dto.setVotoFinal(LocalDateTime.now().plusMinutes(TEST_INT));
		return dto;
	}
	


}