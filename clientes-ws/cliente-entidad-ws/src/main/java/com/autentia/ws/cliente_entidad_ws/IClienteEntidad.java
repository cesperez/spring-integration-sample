package com.autentia.ws.cliente_entidad_ws;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface IClienteEntidad {

	@WebMethod Collection<ClienteEntidad> getClienteEntidades(NIF nif);
}
