package com.autentia.ws.cliente_cuentas_ws;

import static org.springframework.ws.test.server.RequestCreators.*;
import static org.springframework.ws.test.server.ResponseMatchers.*;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-ws-servlet.xml")
public class ClienteCuentasEndPointTest {

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
				"<cliente xmlns='http://www.adictosaltrabajo.com/spring/ws/schemas/088'><ID>25654654</ID></cliente>");
		final Source responsePayload = new StringSource(
				"<sc:cuentas xmlns:sc='http://www.adictosaltrabajo.com/spring/ws/schemas/088'><sc:cuentaSaldo><sc:cuenta>088-2264-000325-0009</sc:cuenta><sc:saldo>1098.7</sc:saldo></sc:cuentaSaldo><sc:cuentaSaldo><sc:cuenta>088-2269-000901-0007</sc:cuenta><sc:saldo>38.0</sc:saldo></sc:cuentaSaldo></sc:cuentas>");

		mockClient.sendRequest(withPayload(requestPayload)).andExpect(payload(responsePayload));
	}

	
}
