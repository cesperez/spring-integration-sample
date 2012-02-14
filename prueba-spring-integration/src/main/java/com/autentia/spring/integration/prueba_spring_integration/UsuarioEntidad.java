package com.autentia.spring.integration.prueba_spring_integration;

import java.io.Serializable;


public class UsuarioEntidad implements Serializable {

	private static final long serialVersionUID = -2914863765082873348L;

	private String usuario;
	
	private String entidad;
	
	public UsuarioEntidad() {}
	
	public UsuarioEntidad(String usuario, String entidad) {
		this.usuario = usuario;
		this.entidad = entidad;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getEntidad() {
		return entidad;
	}
	
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	
	public String toString() {
		return "Usuario:" + usuario + " para entidad:" + entidad;
	}
	
}
