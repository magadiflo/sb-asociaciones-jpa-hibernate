package com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(name = "forma_pago")
    private String formaPago;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    /**
     * NOTA 01. Para cualquier relación BIDIRECCIONAL solo en el @OneToMany
     * se indica la relación INVERSA con el mappedBy. Con el mappedBy le
     * indicamos cuál es el atributo en la clase Invoice que está mapeado
     * a esta clase Customer, en nuestro caso es el atributo "customer" que
     * en la clase Invoice está definido como un atributo private.
     * <p>
     * NOTA 02. Como es una relación BIDIRECCIONAL el @JoinColumn en esta clase
     * Customer YA NO VA, tal como se hizo en la relación Unidireccional (@OneToMany).
     * El @JoinColumn va en la otra clase cuyo atributo está definido como un @ManyToOne,
     * que es dueña de la relación, es decir en la clase Invoice se creará la
     * FK de Customer
     * <p>
     * NOTA 03. Debemos evitar en el método toString() el atributo Invoice o Customer,
     * o solo debemos dejar uno de los dos, ya que si dejamos ambos se generará
     * un bucle infinito.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customer")
    private List<Invoice> invoices;

    @PrePersist
    private void prePersist() {
        this.createAt = LocalDateTime.now();
    }

    public Customer() {
        this.invoices = new ArrayList<>();
    }

    public Customer(String nombre, String apellido, String formaPago) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", formaPago='").append(formaPago).append('\'');
        sb.append(", createAt=").append(createAt);
        sb.append('}');
        return sb.toString();
    }
}
