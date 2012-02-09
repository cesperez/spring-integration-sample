package com.autentia.rest.cliente_entidad_rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name="cuentas")
public class Cuentas implements Serializable{

	private static final long serialVersionUID = -4385233773967421975L;
	
	@XmlElements({ @XmlElement(type = CuentaSaldo.class, name = "cuenta") })
	private final List<CuentaSaldo> cuentas;
	
	public Cuentas() {
		this.cuentas = new ArrayList<CuentaSaldo>();
	}

	public void add(String numeroCuenta, Float importe) {
		this.cuentas.add(new CuentaSaldo(numeroCuenta, importe));
	}
	
	public List<CuentaSaldo> getCuentas() {
		return this.cuentas;
	}
	
}

