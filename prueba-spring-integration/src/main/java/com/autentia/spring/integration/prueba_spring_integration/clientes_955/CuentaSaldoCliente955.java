package com.autentia.spring.integration.prueba_spring_integration.clientes_955;


public class CuentaSaldoCliente955 {

	private final String cuenta;
	
	private final Float saldo;

	public CuentaSaldoCliente955(String cuenta, Float saldo) {
		this.cuenta = cuenta;
		this.saldo = saldo;
	}
	
	public String getCuenta() {
		return cuenta;
	}

	public Float getSaldo() {
		return saldo;
	}
	
	public String toString() {
		return "Cuenta:" + cuenta + " con saldo:" + saldo; 
	}
	
}
