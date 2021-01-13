package com.br.Cooperativismo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.cooperativismo.domain.dto.voto.VotoDTO;
import com.br.cooperativismo.domain.model.Sessao;
import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.exception.NegocioException;
import com.br.cooperativismo.exception.NotFoundException;
import com.br.cooperativismo.repository.VotoRepository;
import com.br.cooperativismo.resttemplate.StatusInforVoto;
import com.br.cooperativismo.resttemplate.UserInfoApiRestCliente;
import com.br.cooperativismo.service.SessaoService;
import com.br.cooperativismo.service.TipoVotacaoPautaService;
import com.br.cooperativismo.service.VotoService;

@SpringBootTest
class VotoServiceTest {
	
	private static final long TEST_ID = 1L;

	private static final String TEST_STRING = "descricao";

	private static final String FAKE_CPF_TEST = "08669648857";

	@Mock
	private VotoRepository votoRepository;
	
	@InjectMocks
	private VotoService votoService;
	
	@Mock
	private TipoVotacaoPautaService tipoVotacaoPautaService;
	
	@Mock
	private SessaoService sessaoService;
	
	@Mock
	private UserInfoApiRestCliente restCliente;


	@Test()
	void testiVote() {
		Mockito.when(tipoVotacaoPautaService.findById(Mockito.anyLong())).thenReturn(getTipoVotacaoPautaOptional());
		Mockito.when(restCliente.consultarPermissaoParaVotar(Mockito.anyString())).thenReturn(getStatusInforVoto());
		Mockito.when(sessaoService.isSessionAbertar(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(votoRepository.save(Mockito.any())).thenReturn(Mockito.any());
		assertNotNull(votoService.vote(getVotoDTO()));
	}
	

	@Test()
	void testiVote2() {
		Mockito.when(tipoVotacaoPautaService.findById(Mockito.anyLong())).thenReturn(getTipoVotacaoPautaOptional());
		Mockito.when(restCliente.consultarPermissaoParaVotar(Mockito.anyString())).thenReturn(getStatusInforVoto());
		assertThrows(NotFoundException.class, () -> votoService.vote(getVotoDTOSemPauta()));
	}
	

	
	@Test()
	void testSessaoFechada() {
		Mockito.when(tipoVotacaoPautaService.findById(Mockito.anyLong())).thenReturn(getTipoVotacaoPautaOptional());
		Mockito.when(restCliente.consultarPermissaoParaVotar(Mockito.anyString())).thenReturn(getStatusInforVoto());
		Mockito.when(sessaoService.isSessionAbertar(getTipoVotacaoPautaAberta())).thenReturn(Boolean.FALSE);
		assertThrows(NotFoundException.class, () -> votoService.vote(getVotoDTO()));
	}
	
	
	@Test()
	void testUnableVotoException() {
		Mockito.when(tipoVotacaoPautaService.findById(Mockito.anyLong())).thenReturn(getTipoVotacaoPautaOptional());
		Mockito.when(restCliente.consultarPermissaoParaVotar(Mockito.anyString())).thenReturn(getStatusInforVotoUnable());
		Mockito.when(sessaoService.isSessionAbertar(getTipoVotacaoPautaAberta())).thenReturn(Boolean.FALSE);
		assertThrows(NegocioException.class, () -> votoService.vote(getVotoDTO()));
	}
	
	
	@Test()
	void testResultadoVotacao() {
		Mockito.when(tipoVotacaoPautaService.findById(Mockito.anyLong())).thenReturn(getTipoVotacaoPautaOptional());
		Mockito.when(sessaoService.isSessionAbertar(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(votoRepository.countByTipoVotacaoPautaAndSimOuNaoFalse(getTipoVotacaoPautaAberta())).thenReturn(Mockito.anyLong());
		Mockito.when(votoRepository.countByTipoVotacaoPautaAndSimOuNaoTrue(getTipoVotacaoPautaAberta())).thenReturn(Mockito.anyLong());
		assertNotNull(votoService.resultadoVotacao(getVotoDTO()));
	}
	

	@Test()
	void testResultadoVotacaoNotFoundException() {
		Mockito.when(tipoVotacaoPautaService.findById(Mockito.anyLong())).thenReturn(getTipoVotacaoPautaOptional());
		Mockito.when(sessaoService.isSessionAbertar(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(votoRepository.countByTipoVotacaoPautaAndSimOuNaoFalse(getTipoVotacaoPautaAberta())).thenReturn(Mockito.anyLong());
		Mockito.when(votoRepository.countByTipoVotacaoPautaAndSimOuNaoTrue(getTipoVotacaoPautaAberta())).thenReturn(Mockito.anyLong());
		assertThrows(NotFoundException.class, () -> votoService.resultadoVotacao(getVotoDTO()));
	}
	
	
	private Optional<TipoVotacaoPauta> getTipoVotacaoPautaOptional() {
		TipoVotacaoPauta pauta = new TipoVotacaoPauta();
		pauta.setId(TEST_ID);
		pauta.setDescricao(TEST_STRING);
		pauta.setSessao(getOptionalSessaoAberta().get());
		return Optional.of(pauta);
	}
	
	private Optional<Sessao> getOptionalSessaoAberta() {
		Sessao sessao = new Sessao();
		sessao.setId(TEST_ID);
		sessao.setTempoInicial(LocalDateTime.now());
		sessao.setTempoFinal(LocalDateTime.now().plusMinutes(10));
		sessao.setTipoVotacaoPauta(getTipoVotacaoPautaAberta2());
		return Optional.of(sessao);
	}
	
	private TipoVotacaoPauta getTipoVotacaoPautaAberta() {
		TipoVotacaoPauta pauta = new TipoVotacaoPauta();
		pauta.setId(TEST_ID);
		pauta.setDescricao(TEST_STRING);
		pauta.setSessao(getOptionalSessaoAberta().get());
		return pauta;
	}
	
	private TipoVotacaoPauta getTipoVotacaoPautaAberta2() {
		TipoVotacaoPauta pauta = new TipoVotacaoPauta();
		pauta.setId(TEST_ID);
		pauta.setDescricao(TEST_STRING);
		return pauta;
	}
	

	
	
	private StatusInforVoto getStatusInforVoto() {
		StatusInforVoto status = new StatusInforVoto();
		status.setStatus("ABLE_TO_VOTE");
		return status;
	}
	
	private StatusInforVoto getStatusInforVotoUnable() {
		StatusInforVoto status = new StatusInforVoto();
		status.setStatus("UNABLE_TO_VOTE");
		return status;
	}
	
	private VotoDTO getVotoDTO() {
		VotoDTO dto = new VotoDTO();
		dto.setCpf(FAKE_CPF_TEST);
		dto.setVotosSim(TEST_ID);
		dto.setTipoVotacaoPautaDescricao(TEST_STRING);
		dto.setTipoVotacaoPautaId(TEST_ID);
		dto.setVotoSucesso(Boolean.TRUE);
		dto.setVoto(Boolean.TRUE);
		return dto;
	}
	
	
	private VotoDTO getVotoDTOSemPauta() {
		VotoDTO dto = new VotoDTO();
		dto.setCpf(FAKE_CPF_TEST);
		dto.setVotosSim(TEST_ID);
		dto.setTipoVotacaoPautaDescricao(TEST_STRING);
		dto.setTipoVotacaoPautaId(null);
		dto.setVotoSucesso(Boolean.TRUE);
		dto.setVoto(Boolean.TRUE);
		return dto;
	}
	
	
	
	


}
