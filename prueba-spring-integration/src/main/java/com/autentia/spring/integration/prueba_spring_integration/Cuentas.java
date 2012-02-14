package com.autentia.spring.integration.prueba_spring_integration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Cuentas implements Serializable {

	private static final long serialVersionUID = 2451339032708412769L;

	private final List<CuentaSaldo> cuentas;
	
	public Cuentas() {
		cuentas = new ArrayList<CuentaSaldo>();
	}
	
	public List<CuentaSaldo> getCuentas() {
		return cuentas;
	}
	
	public void addCuenta(final CuentaSaldo cuenta) {
		cuentas.add(cuenta);
	}
	
	public String toString() {
		final StringBuilder stringBuilder = new StringBuilder("Cuentas: ");
		for (CuentaSaldo cuenta : cuentas) {
			stringBuilder.append(cuenta);
		}
		return stringBuilder.toString();
	}
}
