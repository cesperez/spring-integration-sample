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

public class Entidad088Marshaller implements Marshaller, Unmarshaller {

	private static final Log LOG = LogFactory.getLog(Entidad088Marshaller.class);

	public Object unmarshal(Source source) throws IOException, XmlMappingException {
		final Node cuentasNode = ((DOMSource)source).getNode();

		LOG.debug("Receiving request " + cuentasNode + " length ");

		final List<CuentaSaldo> cuentaSaldos = new ArrayList<CuentaSaldo>();
		if (cuentasNode.getLocalName().equals("cuentas")) {
			final NodeList cuentas = cuentasNode.getChildNodes();
			for (int i = 0; i < cuentas.getLength(); i++) {
				final Node cuenta = cuentas.item(i);
				LOG.debug("Nodename " + cuenta.getNodeName());
				if (cuenta.getLocalName().equals("cuentaSaldo")) {
					cuentaSaldos.add(createCuentaSaldo(cuenta));
				}
			}

		}
		return cuentaSaldos;
	}

	private CuentaSaldo createCuentaSaldo(final Node node) {
		final NodeList childs = node.getChildNodes();
		String cuenta = "";
		String saldo = "";
		for (int i = 0; i < childs.getLength(); i++) {
			final Node child = childs.item(i);
			if (child.getLocalName().equals("cuenta")) {
				cuenta = child.getTextContent();
			} else if (child.getLocalName().equals("saldo")) {
				saldo = child.getTextContent();
			}
		}
		return new CuentaSaldo(cuenta, Float.valueOf(saldo));
	}

	public boolean supports(Class<?> clazz) {
		return false;
	}

	public void marshal(Object object, Result result) throws IOException, XmlMappingException {

		final UsuarioEntidad usuario = (UsuarioEntidad)object;

		final String xmlString = "<sc:cliente xmlns:sc=\"http://www.adictosaltrabajo.com/spring/ws/schemas/088\"><sc:ID>"
				+ usuario.getUsuario() + "</sc:ID></sc:cliente>";

		try {
			final Transformer transformer = new TransformerFactoryImpl().newTransformer();
			transformer.transform(new StringSource(xmlString), result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
