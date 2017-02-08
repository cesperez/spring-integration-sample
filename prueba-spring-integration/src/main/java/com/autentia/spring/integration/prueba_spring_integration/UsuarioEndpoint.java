package com.autentia.spring.integration.prueba_spring_integration;

import javax.xml.transform.dom.DOMSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
public class UsuarioEndpoint {

	private static final Log LOG = LogFactory.getLog(UsuarioEndpoint.class);

//	@ServiceActivator
//	public Usuario handleRequest(DOMSource source) throws Exception {
//		final NodeList nodeList = source.getNode().getChildNodes();
//
//		LOG.debug("Receiving request " + nodeList + " length " + nodeList.getLength());
//
//		String nif = "";
//		if (nodeList.getLength() > 1) {
//			for (int i = 0; i < nodeList.getLength(); i++) {
//				final Node node = nodeList.item(i);
//				LOG.debug("Nodename " + node.getNodeName());
//				if (node.getNodeName().equals("NIF")) {
//					nif = node.getTextContent();
//				}
//			}
//		}
//				
//		return getUsuario(nif);
//		
//	}

	@ServiceActivator
	public Usuario handleRequest(DOMSource source) throws Exception {
		final NodeList nodeList = source.getNode().getChildNodes();

		LOG.debug("Receiving request " + nodeList + " length " + nodeList.getLength());

		String nif = "";
		if (nodeList.getLength() > 1) {
			for (int i = 0; i < nodeList.getLength(); i++) {
				final Node node = nodeList.item(i);
				LOG.debug("Nodename " + node.getNodeName());
				if (node.getNodeName().equals("arg0")) {
					final NodeList nodeList2 = node.getChildNodes();
					for (int j = 0; j < nodeList2.getLength(); j++) {
						final Node node2 = nodeList2.item(j);
						LOG.debug("Nodename2 " + node2.getNodeName());
						if (node2.getNodeName().equals("NIF")) {
							nif = node.getTextContent().trim();
						}
					}
				}
					
					
					
			}
		}
				
		return getUsuario(nif);
		
	}
	
	
	
	
	private Usuario getUsuario(String nif) {
		final Usuario usuario = new Usuario();
		usuario.setNIF(nif);
		return usuario;
	}
}
