package com.br.cooperativismo.resttemplate;

import org.springframework.stereotype.Component;

@Component
public class ConfiguracaoVoto {
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
