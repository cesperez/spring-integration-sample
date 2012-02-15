package com.autentia.spring.integration.prueba_spring_integration.clientes_955;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service(value="cuentasCliente955")
public class CuentasCliente955Impl implements CuentasCliente955 {

	public List<CuentaSaldoCliente955> getCuentasCliente(String cliente) {
		final List<CuentaSaldoCliente955> cuentas = new ArrayList<CuentaSaldoCliente955>();
		cuentas.add(createCuentaSaldo("955-88990-0098-0006", 13206.5f));
		cuentas.add(createCuentaSaldo("955-77014-0103-0003", 11.9f));
		cuentas.add(createCuentaSaldo("955-52001-2209-0017", 31.0f));
		return cuentas;
	} 
	
	private CuentaSaldoCliente955 createCuentaSaldo(final String cuenta, final Float saldo) {
		return new CuentaSaldoCliente955(cuenta, saldo);
	}
	
}
