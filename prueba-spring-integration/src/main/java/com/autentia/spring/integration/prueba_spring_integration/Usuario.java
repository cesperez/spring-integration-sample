package com.autentia.spring.integration.prueba_spring_integration;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Usuario", namespace = "http://www.adictosaltrabajo.com/spring/ws/schemas", propOrder = {"NIF"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 892841676755794499L;

	@XmlElement(required = true)
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
