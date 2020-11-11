package com.br.cooperativismo.resttemplate;

import org.springframework.stereotype.Component;

@Component
public class StatusInforVoto {

	private static final String ABLE_TO_VOTE = "APTO_A_VOTAR";

	private String status;

	public StatusInforVoto() {
	}

	public StatusInforVoto(String status) {

		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Boolean isApto() {
		return getStatus().equalsIgnoreCase(ABLE_TO_VOTE);
	}

}
