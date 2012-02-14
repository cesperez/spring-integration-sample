package com.autentia.spring.integration.prueba_spring_integration;

import java.io.Serializable;


public class CuentaSaldo implements Serializable {

	private static final long serialVersionUID = -4105886047391142732L;

	private String cuenta;
	
	private Float saldo;
	
	public CuentaSaldo() {}
	
	public CuentaSaldo(String cuenta, Float saldo) {
		this.cuenta = cuenta;
		this.saldo = saldo;
	}
	
	public String getCuenta() {
		return cuenta;
	}
	
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	
	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}
	 
	public String toString() {
		return "Cuenta:" + cuenta + " con saldo:" + saldo;
	}
	
}
