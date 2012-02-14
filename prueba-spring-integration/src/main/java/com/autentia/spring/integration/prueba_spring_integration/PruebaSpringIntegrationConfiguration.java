package com.autentia.spring.integration.prueba_spring_integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.ws.server.endpoint.MessageEndpoint;
import org.springframework.ws.server.endpoint.mapping.UriEndpointMapping;

@Configuration
public class PruebaSpringIntegrationConfiguration {

	// the ws:inbound-gateway is in fact a reference to this base Spring WS object
	@Value("#{wsInboundGateway}")
	private MessageEndpoint wsInboundGateway;

	@Bean
	public UriEndpointMapping uriEndpointMapping() {
		final UriEndpointMapping uriEndpointMapping = new UriEndpointMapping();
		uriEndpointMapping.setDefaultEndpoint(wsInboundGateway);
		return uriEndpointMapping;
	}

	@Bean
	public CastorMarshaller castorMarshaller() {
		CastorMarshaller castorMarshaller = new CastorMarshaller();
		castorMarshaller.setTargetClasses(new Class[] { Usuario.class });
		return castorMarshaller;
	}

}
