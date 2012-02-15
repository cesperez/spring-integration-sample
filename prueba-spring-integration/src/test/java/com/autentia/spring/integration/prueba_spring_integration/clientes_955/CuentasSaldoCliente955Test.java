package com.autentia.spring.integration.prueba_spring_integration.clientes_955;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CuentasSaldoCliente955Test {

	private final CuentasCliente955 cuentasCliente = new CuentasCliente955Impl();

	@Test
	public void shouldReturnCuentasList() {
		final List<CuentaSaldoCliente955> cuentas = cuentasCliente.getCuentasCliente("787fdsfda");
		assertNotNull(cuentas);
		assertEquals(3, cuentas.size());
		assertEquals("955-88990-0098-0006", cuentas.get(0).getCuenta());
		assertEquals("955-77014-0103-0003", cuentas.get(1).getCuenta());
		assertEquals("955-52001-2209-0017", cuentas.get(2).getCuenta());
	}

}
