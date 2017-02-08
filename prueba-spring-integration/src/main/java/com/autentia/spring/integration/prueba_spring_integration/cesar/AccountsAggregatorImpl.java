package com.autentia.spring.integration.prueba_spring_integration.cesar;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.autentia.spring.integration.prueba_spring_integration.Cuentas;
import com.autentia.spring.integration.prueba_spring_integration.Usuario;
@WebService(endpointInterface = "com.autentia.spring.integration.prueba_spring_integration.cesar.IAccountsAggregator")
public class AccountsAggregatorImpl implements IAccountsAggregator {
	@WebMethod
	public Cuentas getAccount(@WebParam Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}


}
