package com.asociaciones.jpa.app.unidireccional.v1.OneToOne.repository;

import com.asociaciones.jpa.app.unidireccional.v1.OneToOne.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {

}
