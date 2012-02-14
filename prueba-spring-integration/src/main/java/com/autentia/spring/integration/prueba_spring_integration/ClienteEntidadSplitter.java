package com.autentia.spring.integration.prueba_spring_integration;

import java.util.Collection;
import java.util.List;

import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

@Component
public class ClienteEntidadSplitter {

	@Splitter
	public Collection<UsuarioEntidad> split (List<UsuarioEntidad> usuarioEntidades) {
		return usuarioEntidades;
	}
	
}
