package com.asociaciones.jpa.app.unidireccional.v1.ManyToOne.repository;

import com.asociaciones.jpa.app.unidireccional.v1.ManyToOne.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {
}
