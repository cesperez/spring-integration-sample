package com.autentia.ws.cliente_entidad_ws;


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
public class ClienteEntidadEndPoint {

	private static final Logger LOG = LoggerFactory.getLogger(ClienteEntidadEndPoint.class);
	
	private static final String NAMESPACE_URI = "http://www.adictosaltrabajo.com/spring/ws/schemas";

	private final XPath NIFExpression;
	
	private final Namespace namespace;

	public ClienteEntidadEndPoint() throws JDOMException {
		
		LOG.trace("COnstructor de ClienteEntidadEndpoint");
		this.namespace = Namespace.getNamespace("schemas", NAMESPACE_URI);
		this.NIFExpression = XPath.newInstance("//schemas:NIF");
		NIFExpression.addNamespace(namespace);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "usuario")
	@ResponsePayload
	public Element handleInfoUSuarioRequest(@RequestPayload
			Element usuario) throws Exception {
		final String nif = NIFExpression.valueOf(usuario);
		LOG.trace("Receiving NIF:{}", nif);
		return createResponse();
	}
	
	private Element createResponse() {
		final Element element = new Element("respuesta", namespace);
		element.addContent(createInfoUsuario("088", "25654654"));
		element.addContent(createInfoUsuario("767", "E4486551589"));
		element.addContent(createInfoUsuario("955", "177-A00028"));
		return element;
	}
	
	private Element createInfoUsuario(String codigoEntidad, String identificadorCliente) {
		final Element element = new Element("infoUsuario", namespace);		
		element.addContent(createCodigoEntidad(codigoEntidad));
		element.addContent(createIdentificadorCliente(identificadorCliente));
		return element;
	}
	
	private Element createCodigoEntidad(String codigoEntidad) {
		final Element element = new Element("codigoEntidad", namespace);
		element.addContent(codigoEntidad);
		return element;
	}
	
	private Element createIdentificadorCliente(String identificadorCliente) {
		final Element element = new Element("identificador", namespace);
		element.addContent(identificadorCliente);
		return element;
	}

}
