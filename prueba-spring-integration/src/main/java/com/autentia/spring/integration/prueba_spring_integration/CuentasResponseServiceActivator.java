package com.autentia.spring.integration.prueba_spring_integration;

import javax.xml.transform.Source;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.springframework.xml.transform.StringSource;

@Component
public class CuentasResponseServiceActivator {

	@ServiceActivator
	public Source handleCuentas(final Cuentas cuentas) {
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<cuentas>");
		for (CuentaSaldo cuenta : cuentas.getCuentas()) {
			appendCuenta(cuenta, stringBuilder);
		}
		stringBuilder.append("</cuentas>");
		return new StringSource(stringBuilder.toString());
	}

	private void appendCuenta(final CuentaSaldo cuenta, final StringBuilder stringBuilder) {
		stringBuilder.append("<cuenta>").append("<numero>").append(cuenta.getCuenta()).append("</numero>")
				.append("<saldo>").append(cuenta.getSaldo()).append("</saldo>").append("</cuenta>");
	}

}
