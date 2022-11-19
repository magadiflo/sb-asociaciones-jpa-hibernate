package com.asociaciones.jpa.app.unidireccional.v1.OneToOne.repository;

import com.asociaciones.jpa.app.unidireccional.v1.OneToOne.entity.Credencial;
import org.springframework.data.repository.CrudRepository;

public interface ICredencialRepository extends CrudRepository<Credencial, Long> {
}
