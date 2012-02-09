package com.autentia.rest.cliente_entidad_rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cuenta")
public class CuentaSaldo implements Serializable {

	private static final long serialVersionUID = 197144983769601692L;
	
	private String numeroCuenta;
	
	private Float importe;
	
	public CuentaSaldo(){}

	public CuentaSaldo(String numeroCuenta, Float importe) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.importe = importe;
	}
	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
	public Float getImporte() {
		return importe;
	}
	
	public void setImporte(Float importe) {
		this.importe = importe;
	}	
	
}
