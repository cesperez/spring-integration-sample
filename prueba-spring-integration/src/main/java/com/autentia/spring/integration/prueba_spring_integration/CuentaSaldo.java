package com.autentia.spring.integration.prueba_spring_integration;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.adictosaltrabajo.com/spring/ws/schemas", propOrder = {"cuenta", "saldo"})
@XmlAccessorType(XmlAccessType.FIELD)
public class CuentaSaldo implements Serializable {

	private static final long serialVersionUID = -4105886047391142732L;

	@XmlElement(required = true)
	private String cuenta;
	
	@XmlElement(required = true)
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
