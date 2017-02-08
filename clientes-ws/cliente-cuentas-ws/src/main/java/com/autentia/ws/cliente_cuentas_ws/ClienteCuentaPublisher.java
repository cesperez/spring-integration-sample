package com.autentia.ws.cliente_cuentas_ws;

import javax.xml.ws.Endpoint;

public class ClienteCuentaPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/clienteCuenta", new ClienteCuentaImpl());

	}

}
