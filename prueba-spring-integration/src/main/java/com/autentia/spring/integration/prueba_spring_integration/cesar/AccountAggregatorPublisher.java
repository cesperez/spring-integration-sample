package com.autentia.spring.integration.prueba_spring_integration.cesar;

import javax.xml.ws.Endpoint;

public class AccountAggregatorPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/accountAggregator", new AccountsAggregatorImpl());

	}

}
