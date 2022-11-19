package com.asociaciones.jpa.app.bidireccional.v1.OneToMany_ManyToOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
     *
     * @JsonIgnoreProperties omite las propiedades lógicas especificadas en
     * la serialización y deserialización de JSON. En este caso, la propiedad
     * customer ha sido especificada en el @JsonIgnoreProperties, por lo tanto,
     * esta propiedad no participará en la Serialización y deserialización de JSON,
     * de esta forma evitamos que se genere un ciclo infinito ya que estamos en
     * uan relación BIDIRECCIONAL.
     * <p>
     * allowGetters = true, se permitirán los getters para las propiedades lógicas
     * especificadas. Significa que las propiedades lógicas especificadas en
     * @JsonIgnoreProperties participará en la serialización de JSON, pero
     * NO en la deserialización.
     * <p>
     * allowSetters = true, se permitirán los setters para las propiedades lógicas
     * especificadas. Significa que las propiedades lógicas especificadas en
     * @JsonIgnoreProperties participarán en la DESEREALIZACIÓN de JSON, pero
     * NO en la serialización.
     * <p>
     * NOTA:
     * La SERIALIZACIÓN es el proceso que consiste en convertir la
     * representación de un objeto en un stream (flujo de secuencia) de bytes.
     * <p>
     * La DESEREALIZACIÓN consiste en reconstruir un objeto a partir de un
     * stream de bytes.
     */
    @JsonIgnoreProperties(value = {"customer"}, allowSetters = true)
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
        // Elimina todos los elementos de la lista, la dejamos vacía.
        // Cada elemento de la lista que viene en este parámetro será agregada con el método addInvoice(...)
        this.invoices.clear();
        invoices.forEach(this::addInvoice);
    }

    //********* IMPORTANTE ESTABLECER LA RELACIÓN EN AMBOS LADOS *********
    public void addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
        invoice.setCustomer(this); // Para que guarde la FK de customer en tabla Invoice (atributo customer_id) de la BD.
    }

    public void removeInvoice(Invoice invoice) {
        this.invoices.remove(invoice);
        // Al invoice le quitamos la FK de customer, quedando huérfana,
        // de esa manera como tenemos el orphanRemoval=true, se eliminará
        invoice.setCustomer(null);
    }
    //*********

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
