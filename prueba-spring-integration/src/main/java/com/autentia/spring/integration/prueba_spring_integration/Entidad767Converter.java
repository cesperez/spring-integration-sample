package com.autentia.spring.integration.prueba_spring_integration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.dom.DOMSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.integration.xml.source.DomSourceFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Component
public class Entidad767Converter implements HttpMessageConverter<List<CuentaSaldo>> {

	private static final Log LOG = LogFactory.getLog(Entidad767Converter.class);
	
	private static final List<MediaType> SUPPORTED_MEDIA_TYPES = new ArrayList<MediaType>();
	static {
		SUPPORTED_MEDIA_TYPES.add(MediaType.APPLICATION_XML);
		SUPPORTED_MEDIA_TYPES.add(MediaType.TEXT_XML);
	}

	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		return clazz.equals(String.class);
	}

	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		return false;
	}

	public List<MediaType> getSupportedMediaTypes() {
		return SUPPORTED_MEDIA_TYPES;
	}

	public List<CuentaSaldo> read(Class<? extends List<CuentaSaldo>> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {

		final String xmlResponse = getResponse(inputMessage.getBody());
		LOG.debug("Received response from entity 767 " + xmlResponse);
		return getCuentas(xmlResponse);
	}
	
	private List<CuentaSaldo> getCuentas(final String response) {
		
		final List<CuentaSaldo> cuentas = new ArrayList<CuentaSaldo>();
		final DOMSource source = (DOMSource) new DomSourceFactory().createSource(response);
		final NodeList nodelist = source.getNode().getChildNodes();
		
		final Node cuentaNode = nodelist.item(0);
		if (cuentaNode.getLocalName().equals("cuenta")) {			
			for (int i=0; i<nodelist.getLength(); i++) {
				final Node cuenta = nodelist.item(i);
				cuentas.add(getCuentaSaldo(cuenta));
			}
		}
		
		return cuentas;
		
	}
	
	private CuentaSaldo getCuentaSaldo(final Node node) {
		final CuentaSaldo cuenta = new CuentaSaldo();
		String numeroCuenta = "";
		String saldo = "";
		if (node.getLocalName().equals("cuenta")) {
			final NodeList cuentaAndSaldo = node.getChildNodes();
			for (int i=0; i<cuentaAndSaldo.getLength(); i++) {
				final Node cuentaOrSaldoNode = cuentaAndSaldo.item(i);
				if (cuentaOrSaldoNode.getLocalName().equals("numeroCuenta")) {
					numeroCuenta = cuentaOrSaldoNode.getTextContent();
				} else if (cuentaOrSaldoNode.getLocalName().equals("importe")) {
					saldo = cuentaOrSaldoNode.getTextContent();
				}
			}
		}
		cuenta.setCuenta(numeroCuenta);
		cuenta.setSaldo(Float.valueOf(saldo));
		return cuenta;
	}
	

	private String getResponse(InputStream inputStream) throws IOException {
		if (inputStream != null) {
			final Writer writer = new StringWriter();

			char[] buffer = new char[1024];
			try {
				final Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				inputStream.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}

	public void write(List<CuentaSaldo> t, MediaType contentType, HttpOutputMessage outputMessage) throws IOException,
			HttpMessageNotWritableException {

	}

}
