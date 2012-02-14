package com.autentia.spring.integration.prueba_spring_integration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.xml.transform.StringSource;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;

public class UsuarioToClienteEntidadMarshaller implements Marshaller, Unmarshaller {

	private static final Log LOG = LogFactory.getLog(UsuarioToClienteEntidadMarshaller.class);
	
	public Object unmarshal(Source source) throws IOException, XmlMappingException {
		
		final NodeList nodeList = ((DOMSource)source).getNode().getChildNodes();

		LOG.debug("Receiving request " + nodeList + " length " + nodeList.getLength());
		
		final List<UsuarioEntidad> usuarioEntidades = new ArrayList<UsuarioEntidad>();
		if (nodeList.getLength() > 1) {
			for (int i = 0; i < nodeList.getLength(); i++) {
				final Node node = nodeList.item(i);
				LOG.debug("Nodename " + node.getNodeName());
				if (node.getLocalName().equals("infoUsuario")) {
					usuarioEntidades.add(createUsuarioEntidad(node));
				}
			}
		}		
		return usuarioEntidades;
	}

	private UsuarioEntidad createUsuarioEntidad(final Node node) {
		final NodeList childs = node.getChildNodes();
		String id = "";
		String entidad = "";
		for (int i=0;i<childs.getLength(); i++) {
			final Node child = childs.item(i);
			if (child.getLocalName().equals("codigoEntidad")) {
				entidad = child.getTextContent();
			} else if (child.getLocalName().equals("identificador")) {
				id = child.getTextContent();
			}
		}
		return new UsuarioEntidad(id, entidad);
	}
	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void marshal(Object object, Result result) throws IOException, XmlMappingException {

		final Usuario usuario = (Usuario) object;
		
		final String xmlString = "<schemas:usuario xmlns:schemas=\"http://www.adictosaltrabajo.com/spring/ws/schemas\">"
				+ "<schemas:NIF>" + usuario.getNIF() + "</schemas:NIF></schemas:usuario>";

		try {
			final Transformer transformer = new TransformerFactoryImpl().newTransformer();
			transformer.transform(new StringSource(xmlString), result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}	

}
