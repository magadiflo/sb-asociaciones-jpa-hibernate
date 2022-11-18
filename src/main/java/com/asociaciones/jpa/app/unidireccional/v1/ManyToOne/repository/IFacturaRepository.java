package com.asociaciones.jpa.app.unidireccional.v1.ManyToOne.repository;

import com.asociaciones.jpa.app.unidireccional.v1.ManyToOne.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaRepository extends CrudRepository<Factura, Long> {

}
