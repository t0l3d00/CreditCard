package com.example.ibm.academy.restapi.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.ibm.academy.restapi.modelo.entidades.Clientes;

public interface ClienteRepository extends CrudRepository<Clientes, Long>
{

}
