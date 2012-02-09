package com.autentia.ws.cliente_entidad_ws;

import javax.xml.transform.Source;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

import static org.springframework.ws.test.server.RequestCreators.*;
import static org.springframework.ws.test.server.ResponseMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-ws-servlet.xml")
public class ClienteEntidadEndPointTest {

	@Autowired
	private ApplicationContext applicationContext;

	private MockWebServiceClient mockClient;

	@Before
	public void createClient() {
		mockClient = MockWebServiceClient.createClient(applicationContext);
	}

	@Test
	public void customerEndpoint() throws Exception {
		final Source requestPayload = new StringSource(
				"<usuario xmlns='http://www.adictosaltrabajo.com/spring/ws/schemas'><NIF>09033333A</NIF></usuario>");
		final Source responsePayload = new StringSource(
				"<schemas:respuesta xmlns:schemas='http://www.adictosaltrabajo.com/spring/ws/schemas'><schemas:infoUsuario><schemas:codigoEntidad>088</schemas:codigoEntidad><schemas:identificador>25654654</schemas:identificador></schemas:infoUsuario><schemas:infoUsuario><schemas:codigoEntidad>767</schemas:codigoEntidad><schemas:identificador>E4486551589</schemas:identificador></schemas:infoUsuario><schemas:infoUsuario><schemas:codigoEntidad>955</schemas:codigoEntidad><schemas:identificador>177-A00028</schemas:identificador></schemas:infoUsuario></schemas:respuesta>");

		mockClient.sendRequest(withPayload(requestPayload)).andExpect(payload(responsePayload));
	}

}
