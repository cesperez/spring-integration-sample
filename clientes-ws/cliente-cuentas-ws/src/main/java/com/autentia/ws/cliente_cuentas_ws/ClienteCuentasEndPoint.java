package com.autentia.ws.cliente_cuentas_ws;


import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ClienteCuentasEndPoint {

	private static final Logger LOG = LoggerFactory.getLogger(ClienteCuentasEndPoint.class);
	
	private static final String NAMESPACE_URI = "http://www.adictosaltrabajo.com/spring/ws/schemas/088";

	private final XPath IDExpression;
	
	private final Namespace namespace;
	
	public ClienteCuentasEndPoint() throws JDOMException {
		this.namespace = Namespace.getNamespace("sc", NAMESPACE_URI);
		this.IDExpression = XPath.newInstance("//sc:ID");
		IDExpression.addNamespace(namespace);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "cliente")
	@ResponsePayload
	public Element handleInfoUSuarioRequest(@RequestPayload Element cliente) throws Exception {
		final String id = IDExpression.valueOf(cliente);
		LOG.trace("Receiving client ID:{}", id);
		return createResponse();
	}
	
	private Element createResponse() {
		final Element element = new Element("cuentas", namespace);
		element.addContent(createCuentaSaldo("088-2264-000325-0009", 1098.7f));
		element.addContent(createCuentaSaldo("088-2269-000901-0007", 38.0f));
		return element;
	}
	
	private Element createCuentaSaldo(String cuenta, Float saldo) {
		final Element element = new Element("cuentaSaldo", namespace);		
		element.addContent(createCuenta(cuenta));
		element.addContent(createSaldo(saldo));
		return element;
	}
	
	private Element createCuenta(String cuenta) {
		final Element element = new Element("cuenta", namespace);
		element.addContent(cuenta);
		return element;
	}
	
	private Element createSaldo(Float saldo) {
		final Element element = new Element("saldo", namespace);
		element.addContent(saldo.toString());
		return element;
	}

}

