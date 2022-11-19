package com.asociaciones.jpa.app.unidireccional.v1.OneToMany.pordefecto.repository;

import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.pordefecto.entity.PersonaDefault;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaRepositoryDefault extends CrudRepository<PersonaDefault, Long> {
}
