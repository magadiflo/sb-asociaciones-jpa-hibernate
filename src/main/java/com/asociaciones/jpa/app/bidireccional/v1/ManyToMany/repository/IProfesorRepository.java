package com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.repository;

import com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.entity.Profesor;
import org.springframework.data.repository.CrudRepository;

public interface IProfesorRepository extends CrudRepository<Profesor, Long> {
}
