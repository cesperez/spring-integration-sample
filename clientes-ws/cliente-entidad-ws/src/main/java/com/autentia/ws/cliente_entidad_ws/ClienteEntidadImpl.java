package com.autentia.ws.cliente_entidad_ws;

import java.util.ArrayList;
import java.util.Collection;

import javax.jws.WebService;

@WebService(endpointInterface = "com.autentia.ws.cliente_entidad_ws.IClienteEntidad")
public class ClienteEntidadImpl implements IClienteEntidad {

	@Override
	public Collection<ClienteEntidad> getClienteEntidades(NIF nif) {

		ClienteEntidad cliEnt1 = new ClienteEntidad();
		cliEnt1.setBank("088");
		cliEnt1.setAccount("25654654");
		ClienteEntidad cliEnt2 = new ClienteEntidad();
		cliEnt2.setBank("767");
		cliEnt2.setAccount("E4486551589");
		ClienteEntidad cliEnt3 = new ClienteEntidad();
		cliEnt3.setBank("955");
		cliEnt3.setAccount("177-A00028");

		Collection<ClienteEntidad> list = new ArrayList<ClienteEntidad>();
		list.add(cliEnt1);
		list.add(cliEnt2);
		list.add(cliEnt3);
		
		return list;
	}
	

}
