package com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.repository;

import com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface ICursoRepository extends CrudRepository<Curso, Long> {
}
