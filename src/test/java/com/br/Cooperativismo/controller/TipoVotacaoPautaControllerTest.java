package com.br.Cooperativismo.controller;

import static org.mockito.Mockito.verify;
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

import com.br.cooperativismo.domain.dto.tipovotacao.TipoVotacaoPedidoDTO;
import com.br.cooperativismo.exception.NotFoundException;
import com.br.cooperativismo.service.adapter.TipoVotacaoPautaAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class TipoVotacaoPautaControllerTest {

	private static final String TEST_STRING_ERRO = "erro";
	private static final String TEST_STRING = "Descricao";

	private static final String PAUTAS_URL = "/pautas";

	@MockBean
	private TipoVotacaoPautaAdapter tipoVotacaoPautaAdapter;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testSalvar() throws Exception {
		TipoVotacaoPedidoDTO dto = new TipoVotacaoPedidoDTO();
		dto.setDescricao(TEST_STRING);
		mockMvc.perform(post(PAUTAS_URL).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(dto))).andExpect(status().isOk());
	}

	@Test
	public void handleException() throws Exception {

		Mockito.doThrow(new NotFoundException(TEST_STRING_ERRO)).when(tipoVotacaoPautaAdapter)
				.salvar(Mockito.any(TipoVotacaoPedidoDTO.class));

		mockMvc.perform(post(PAUTAS_URL).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(TipoVotacaoPedidoDTO.class)))
				.andExpect(status().isBadRequest());

		verify(tipoVotacaoPautaAdapter).salvar(Mockito.any(TipoVotacaoPedidoDTO.class));
	}

}
