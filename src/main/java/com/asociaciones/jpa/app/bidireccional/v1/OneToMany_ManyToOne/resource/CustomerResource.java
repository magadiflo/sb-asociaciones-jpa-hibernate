package com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.resource;

import com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.entity.Customer;
import com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.entity.Invoice;
import com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.repository.ICustomerRepository;
import com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.repository.IInvoiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> guardarCustomerConInvoices(@RequestBody Customer customer) {
        return ResponseEntity.ok(this.customerRepository.save(customer));
    }

    // Aquí está dentro del contexto de persistencia, ya que vamos a buscar directamente a la BD al Invoice,
    // el mismo objeto lo va a eliminar
    @DeleteMapping(path = "{customerId}/invoice/{invoiceId}")
    public ResponseEntity<?> buscarInvoiceYEliminarDeCustomer(@PathVariable Long customerId, @PathVariable Long invoiceId) {
        Customer customer = this.customerRepository.findById(customerId).orElseThrow();
        Invoice invoice = this.iInvoiceRepository.findById(invoiceId).orElseThrow();
        customer.removeInvoice(invoice);

        this.customerRepository.save(customer);
        return ResponseEntity.noContent().build();
    }

    // Fuera del contexto de persistencia, se necesita implementar el equals() en Invoice
    @DeleteMapping(path = "{customerId}")
    public ResponseEntity<?> eliminarInvoiceDeCustomer(@PathVariable Long customerId, @RequestBody Invoice invoice) {
        Customer customer = this.customerRepository.findById(customerId).orElseThrow();
        customer.removeInvoice(invoice);

        this.customerRepository.save(customer);
        return ResponseEntity.noContent().build();
    }


}
