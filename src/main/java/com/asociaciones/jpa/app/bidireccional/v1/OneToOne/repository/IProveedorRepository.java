package com.asociaciones.jpa.app.bidireccional.v1.OneToOne.repository;

import com.asociaciones.jpa.app.bidireccional.v1.OneToOne.entity.Proveedor;
import org.springframework.data.repository.CrudRepository;

public interface IProveedorRepository extends CrudRepository<Proveedor, Long> {
}
