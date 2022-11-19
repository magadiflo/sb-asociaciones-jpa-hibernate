package com.asociaciones.jpa.app.unidireccional.v1.OneToMany.custom.repository;

import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.custom.entity.Direccion;
import org.springframework.data.repository.CrudRepository;

public interface IDireccionRepository extends CrudRepository<Direccion, Long> {

}
