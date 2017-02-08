package com.autentia.ws.cliente_cuentas_ws;

import java.util.ArrayList;
import java.util.Collection;

import javax.jws.WebService;

@WebService(endpointInterface = "com.autentia.ws.cliente_cuentas_ws.IClienteCuenta")
public class ClienteCuentaImpl implements IClienteCuenta {

	@Override
	public Collection<BankAccount> getSaldos(ID clientId) {
		BankAccount ba1 = new BankAccount();
		ba1.setBankId("088-2264-000325-0009");
		ba1.setBalance(1098.7f);
		BankAccount ba2 = new BankAccount();
		ba2.setBankId("088-2269-000901-0007");
		ba2.setBalance(38.0f);
		Collection<BankAccount> list = new ArrayList<BankAccount>();
		list.add(ba1);
		list.add(ba2);
		
		return list;
		
	}

}
