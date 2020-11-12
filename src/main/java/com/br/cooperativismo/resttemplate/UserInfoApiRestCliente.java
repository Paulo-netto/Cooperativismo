package com.br.cooperativismo.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.br.cooperativismo.exception.NegocioException;
import com.br.cooperativismo.util.ConstantsUtil;

@Component
public class UserInfoApiRestCliente {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${user.info.api.url}")
	private String userInfoApiUrl;

	public UserInfoApiRestCliente() {
	}

	public StatusInforVoto consultarPermissaoParaVotar(String cpfSocio) {
		try {
			return restTemplate.getForObject(userInfoApiUrl, StatusInforVoto.class, cpfSocio);
		} catch (NegocioException e) {
			throw new NegocioException(ConstantsUtil.NAO_ENCONTROU_DOCUMENTO);
		}
	}

}
