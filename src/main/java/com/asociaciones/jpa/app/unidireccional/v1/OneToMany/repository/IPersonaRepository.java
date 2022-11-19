package com.asociaciones.jpa.app.unidireccional.v1.OneToMany.repository;

import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaRepository extends CrudRepository<Persona, Long> {
}
