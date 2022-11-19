package com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.repository;

import com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.entity.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface IInvoiceRepository extends CrudRepository<Invoice, Long> {
}
