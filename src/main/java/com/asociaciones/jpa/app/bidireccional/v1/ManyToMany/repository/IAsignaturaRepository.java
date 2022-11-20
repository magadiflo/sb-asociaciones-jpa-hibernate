package com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.repository;

import com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.entity.Asignatura;
import org.springframework.data.repository.CrudRepository;

public interface IAsignaturaRepository extends CrudRepository<Asignatura, Long> {
}
