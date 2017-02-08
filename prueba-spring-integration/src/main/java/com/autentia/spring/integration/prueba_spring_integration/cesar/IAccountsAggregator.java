package com.autentia.spring.integration.prueba_spring_integration.cesar;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.autentia.spring.integration.prueba_spring_integration.Cuentas;
import com.autentia.spring.integration.prueba_spring_integration.Usuario;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface IAccountsAggregator {

	@WebMethod Cuentas getAccount (@WebParam Usuario usuario);
	
}
