package com.example.imb.academy.restapi.servicios;

import com.example.ibm.academy.restapi.modelo.entidades.Clientes;
import com.example.ibm.academy.restapi.repositorios.ClienteRepository;


public class ClienteDAOImpl extends GenericoDAOImpl<Clientes, ClienteRepository> implements ClienteDAO
{

	public ClienteDAOImpl(ClienteRepository repository) {
		super(repository);
		
	}
}
