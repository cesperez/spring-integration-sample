package com.autentia.spring.integration.prueba_spring_integration;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.autentia.spring.integration.prueba_spring_integration.clientes_955.CuentaSaldoCliente955;
import com.autentia.spring.integration.prueba_spring_integration.clientes_955.CuentasCliente955;

@Component
public class CuentasCliente955ServiceActivator {

	private static final Log LOG = LogFactory.getLog(CuentasCliente955ServiceActivator.class);

	private final CuentasCliente955 cuentasCliente;

	@Autowired
	public CuentasCliente955ServiceActivator(CuentasCliente955 cuentasCliente) {
		this.cuentasCliente = cuentasCliente;
	}

	@ServiceActivator
	public List<CuentaSaldo> handleCuentas(UsuarioEntidad usuario) {
		final List<CuentaSaldoCliente955> cuentas = cuentasCliente.getCuentasCliente(usuario.getUsuario());
		LOG.debug("Received cuentas:" + cuentas + " from user: " + usuario.getUsuario());
		return convertCuentaSaldo(cuentas);
	}

	private List<CuentaSaldo> convertCuentaSaldo(List<CuentaSaldoCliente955> cuentas) {
		final List<CuentaSaldo> convertedCuentas = new ArrayList<CuentaSaldo>();
		for (CuentaSaldoCliente955 cuenta : cuentas) {
			convertedCuentas.add(new CuentaSaldo(cuenta.getCuenta(), cuenta.getSaldo()));
		}
		return convertedCuentas;
	}

}
