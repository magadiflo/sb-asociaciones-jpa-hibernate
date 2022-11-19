package com.asociaciones.jpa.app.unidireccional.v1.OneToMany.repository;

import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.entity.Direccion;
import org.springframework.data.repository.CrudRepository;

public interface IDireccionRepository extends CrudRepository<Direccion, Long> {

}
