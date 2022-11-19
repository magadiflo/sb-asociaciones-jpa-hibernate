package com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.repository;

import com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
}
