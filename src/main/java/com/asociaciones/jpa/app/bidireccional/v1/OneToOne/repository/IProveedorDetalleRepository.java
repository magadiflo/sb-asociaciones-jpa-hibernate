package com.asociaciones.jpa.app.bidireccional.v1.OneToOne.repository;

import com.asociaciones.jpa.app.bidireccional.v1.OneToOne.entity.ProveedorDetalle;
import org.springframework.data.repository.CrudRepository;

public interface IProveedorDetalleRepository extends CrudRepository<ProveedorDetalle, Long> {
}
