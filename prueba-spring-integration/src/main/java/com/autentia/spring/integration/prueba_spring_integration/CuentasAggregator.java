package com.autentia.spring.integration.prueba_spring_integration;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.stereotype.Component;

@Component
public class CuentasAggregator {

	private static final Log LOG = LogFactory.getLog(CuentasAggregator.class);
	
	@Aggregator
	public Cuentas addCuentas(List<Collection<CuentaSaldo>> cuentasEntidades) {
		final Cuentas cuentas = new Cuentas();		
		for (Collection<CuentaSaldo> cuentasEntidad : cuentasEntidades) {
			LOG.debug("Adding " + cuentasEntidad + " to final data");
			for (CuentaSaldo cuentaSaldo : cuentasEntidad) {
				cuentas.addCuenta(cuentaSaldo);
			}
		}
		return cuentas;
	}
}
