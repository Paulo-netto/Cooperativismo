package com.br.cooperativismo.resttemplate;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.br.cooperativismo.exception.NegocioExeption;
import com.br.cooperativismo.util.ConstantsUtil;

@Component
public class RestCliente {

	private RestTemplate restTemplate;
	private ConfiguracaoVoto configuracaoVoto;

	public RestCliente(RestTemplate restTemplate, ConfiguracaoVoto configuracaoVoto) {
		this.restTemplate = restTemplate;
		this.configuracaoVoto = configuracaoVoto;
	}

	public Boolean validateDocument(String descricao) {
		try {
			URI uri = URI.create(String.format(configuracaoVoto.getUrl(), descricao));
			StatusInforVoto status = restTemplate.getForObject(uri, StatusInforVoto.class);
			return status.isApto();
		} catch (NegocioExeption e) {
			throw new NegocioExeption(ConstantsUtil.NAO_ENCONTROU_DOCUMENTO);
		}
	}

}
