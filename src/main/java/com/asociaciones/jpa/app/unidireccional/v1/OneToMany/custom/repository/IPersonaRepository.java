package com.asociaciones.jpa.app.unidireccional.v1.OneToMany.custom.repository;

import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.custom.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaRepository extends CrudRepository<Persona, Long> {
}
