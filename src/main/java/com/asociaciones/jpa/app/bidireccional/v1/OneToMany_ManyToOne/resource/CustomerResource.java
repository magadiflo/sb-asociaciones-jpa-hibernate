package com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.resource;

import com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.entity.Customer;
import com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.repository.ICustomerRepository;
import com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.repository.IInvoiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/bidireccional/v1/one-to-many_many-to-one/customers")
public class CustomerResource {

    private final ICustomerRepository customerRepository;
    private final IInvoiceRepository iInvoiceRepository;

    public CustomerResource(ICustomerRepository customerRepository, IInvoiceRepository iInvoiceRepository) {
        this.customerRepository = customerRepository;
        this.iInvoiceRepository = iInvoiceRepository;
    }

    @GetMapping
    public ResponseEntity<?> listarClientes() {
        List<Customer> customers = (List<Customer>) this.customerRepository.findAll();
        return ResponseEntity.ok(customers);
    }


}
