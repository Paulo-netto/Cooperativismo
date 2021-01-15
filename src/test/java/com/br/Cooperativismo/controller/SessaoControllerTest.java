package com.br.Cooperativismo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.br.cooperativismo.domain.dto.sessao.SessaoPedidoDTO;
import com.br.cooperativismo.service.adapter.SessaoAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class SessaoControllerTest {

	private static final int TEST_INT = 10;
	private static final String TEST_URL = "/sessao/1/nova";

	@MockBean
	private SessaoAdapter sessaoAdapter;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testAbrirSessao() throws Exception {
		SessaoPedidoDTO dto = new SessaoPedidoDTO();
		dto.setTempoFinal(LocalDateTime.now().plusMinutes(TEST_INT));
		mockMvc.perform(
				post(TEST_URL).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(dto)))
				.andExpect(status().isOk());
	}

}
