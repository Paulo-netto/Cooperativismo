package com.br.Cooperativismo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.cooperativismo.domain.dto.sessao.SessaoDTO;
import com.br.cooperativismo.domain.model.Sessao;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.repository.SessaoRepositoy;
import com.br.cooperativismo.service.SessaoService;
import com.br.cooperativismo.service.TipoVotacaoPautaService;

@SpringBootTest
class SessaoServiceTest {

	@Mock
	private SessaoRepositoy sessaoRepositoy;

	@Mock
	private TipoVotacaoPautaService tipoVotacaoPautaService;

	@InjectMocks
	private SessaoService sesssaoService;

	@SuppressWarnings("deprecation")
	@Test
	void testAbrirSessao() {
		Mockito.when(tipoVotacaoPautaService.findById(Matchers.anyLong())).thenReturn(getTipoVotacaoPautaOptional());
		Mockito.when(sessaoRepositoy.save(Matchers.any(Sessao.class))).thenReturn(getSessao());
		assertNotNull(sesssaoService.abrirSessao(getSessaoDTO()));
	}

	@SuppressWarnings("deprecation")
	@Test
	void testHasSessaoAberta() {
		Mockito.when(sessaoRepositoy.findById(Matchers.anyLong())).thenReturn(getOptionalSessaoAberta());
		assertNotNull(sesssaoService.hasSessaoAberta(getTipoVotacaoPautaAberta()));

	}

	@Test
	void testHasSessaoFechada() {
		Mockito.when(sessaoRepositoy.findById(Matchers.anyLong())).thenReturn(getOptionalSessaoFechada());
		assertNotNull(sesssaoService.hasSessaoAberta(getTipoVotacaoPautaFechada()));

	}

	private Optional<Sessao> getOptionalSessaoAberta() {
		Sessao sessao = new Sessao();
		sessao.setId(1L);
		sessao.setTempoInicial(LocalDateTime.now());
		sessao.setTempoFinal(LocalDateTime.now().plusMinutes(10));
		sessao.setTipoVotacaoPauta(new TipoVotacaoPauta());
		return Optional.of(sessao);
	}

	private Optional<Sessao> getOptionalSessaoFechada() {
		Sessao sessao = new Sessao();
		sessao.setId(2L);
		sessao.setTempoInicial(LocalDateTime.now());
		sessao.setTempoFinal(LocalDateTime.now());
		sessao.setTipoVotacaoPauta(new TipoVotacaoPauta());
		return Optional.of(sessao);
	}

	private TipoVotacaoPauta getTipoVotacaoPautaAberta() {
		TipoVotacaoPauta pauta = new TipoVotacaoPauta();
		pauta.setId(1L);
		pauta.setDescricao("teste");
		pauta.setSessao(getOptionalSessaoAberta().get());
		return pauta;
	}

	private TipoVotacaoPauta getTipoVotacaoPautaFechada() {
		TipoVotacaoPauta pauta = new TipoVotacaoPauta();
		pauta.setId(2L);
		pauta.setDescricao("teste");
		pauta.setSessao(getOptionalSessaoFechada().get());
		return pauta;
	}

	private Optional<TipoVotacaoPauta> getTipoVotacaoPautaOptional() {
		TipoVotacaoPauta pauta = new TipoVotacaoPauta();
		pauta.setId(1L);
		pauta.setDescricao("teste");
		pauta.setSessao(getOptionalSessaoAberta().get());
		return Optional.of(pauta);
	}

	private Sessao getSessao() {
		Sessao sessao = new Sessao();
		sessao.setId(1L);
		sessao.setTempoInicial(LocalDateTime.now());
		sessao.setTempoFinal(LocalDateTime.now().plusMinutes(10));
		sessao.setTipoVotacaoPauta(new TipoVotacaoPauta());
		return sessao;
	}

	private SessaoDTO getSessaoDTO() {
		SessaoDTO dto = new SessaoDTO();
		dto.setTipoVotacaoPautaId(1L);
		dto.setSessaoAberta(true);
		dto.setVotoFinal(LocalDateTime.now().plusMinutes(10));
		return dto;
	}

}
