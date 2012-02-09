package com.autentia.rest.cliente_entidad_rest;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/cuentas")
public class CuentasUsuarioController {

	private static final Logger LOG = LoggerFactory.getLogger(CuentasUsuarioController.class);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Cuentas showCustomer(@PathVariable String id) {
		LOG.trace("Receiving id {}", id);
	    return getCuentas();
	}	
	
	private Cuentas getCuentas() {
		final Cuentas cuentas = new Cuentas();
		cuentas.add("767-0057-2291-000373-001", 505.5f);
		cuentas.add("767-0059-0016-001082-006", 12.0f);
		return cuentas;
	}
	
}
