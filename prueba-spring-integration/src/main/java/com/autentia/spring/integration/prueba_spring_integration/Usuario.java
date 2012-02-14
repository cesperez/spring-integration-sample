package com.autentia.spring.integration.prueba_spring_integration;

import java.io.Serializable;


public class Usuario implements Serializable {

	private static final long serialVersionUID = 892841676755794499L;

	private String NIF;
	
	public Usuario() {}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String toString() {
		return "Usuario con NIF: " + NIF;
	}
}
