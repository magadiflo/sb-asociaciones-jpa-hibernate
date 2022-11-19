package com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.repository;

import com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface IAlumnoRepository extends CrudRepository<Alumno, Long> {
}
