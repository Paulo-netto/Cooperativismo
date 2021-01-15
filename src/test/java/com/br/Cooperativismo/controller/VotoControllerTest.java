package com.br.Cooperativismo.controller;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.br.cooperativismo.domain.dto.voto.VotoPedidoDTO;
import com.br.cooperativismo.exception.NegocioException;
import com.br.cooperativismo.exception.NotFoundException;
import com.br.cooperativismo.service.adapter.VotoAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class VotoControllerTest {

	private static final String TEST_STRING_ERRO = "erro";
	private static final String VOTO_RESULTADO_URL = "/votacao/";
	private static final String TIPO_VOTACAO_STRING = "tipoVotacaoPautaId";
	private static final String TEST_NUMERO_STRING = "1";

	private final Long TEST_ID = 1L;

	@MockBean
	private VotoAdapter votoAdapter;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testGetResultadoVotacao() throws Exception {
		mockMvc.perform(get(VOTO_RESULTADO_URL + TEST_ID).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testSalvar() throws Exception {
		VotoPedidoDTO voto = new VotoPedidoDTO(Boolean.TRUE, "08636344857");
		mockMvc.perform(post("/votacao").param(TIPO_VOTACAO_STRING, TEST_NUMERO_STRING)
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(voto)))
				.andExpect(status().isOk());
		votoAdapter.vota(TEST_ID, voto);
	}

	@Test
	public void handleException() throws Exception {
		Mockito.doThrow(new NegocioException (TEST_STRING_ERRO)).when(votoAdapter).resultadoVotacao(Mockito.anyLong());
		mockMvc.perform(get(VOTO_RESULTADO_URL + TEST_ID).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
		verify(votoAdapter).resultadoVotacao(Mockito.anyLong());
	}
	
	@Test
	public void handleExceptionNegocio() throws Exception {
		Mockito.doThrow(new NotFoundException(TEST_STRING_ERRO)).when(votoAdapter).resultadoVotacao(Mockito.anyLong());
		mockMvc.perform(get(VOTO_RESULTADO_URL + TEST_ID).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
		verify(votoAdapter).resultadoVotacao(Mockito.anyLong());
	}

}
