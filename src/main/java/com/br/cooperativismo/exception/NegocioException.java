package com.br.cooperativismo.exception;

public class NegocioException extends RuntimeException {


	private static final long serialVersionUID = -4668825357849206886L;

	public NegocioException(String msg) {
		super(msg);
	}
}