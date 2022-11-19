package com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.resource;

import com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.repository.ICustomerRepository;
import com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.repository.IInvoiceRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bidireccional/v1/one-to-many_many-to-one/customers")
public class CustomerResource {

    private final ICustomerRepository customerRepository;
    private final IInvoiceRepository iInvoiceRepository;

    public CustomerResource(ICustomerRepository customerRepository, IInvoiceRepository iInvoiceRepository) {
        this.customerRepository = customerRepository;
        this.iInvoiceRepository = iInvoiceRepository;
    }


}
