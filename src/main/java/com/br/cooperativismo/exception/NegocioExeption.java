package com.br.cooperativismo.exception;

public class NegocioExeption extends RuntimeException {


	private static final long serialVersionUID = -4668825357849206886L;

	public NegocioExeption(String msg) {
		super(msg);
	}
}