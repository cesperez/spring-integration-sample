package com.autentia.ws.cliente_entidad_ws;

import javax.xml.ws.Endpoint;

public class ClienteEntidadPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/clienteEntidad", new ClienteEntidadImpl());

	}

}
