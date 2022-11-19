package com.asociaciones.jpa.app.bidireccional.v1.OneToOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String ruc;

    /**
     * Nunca pueden estar juntos el @JoinColumn con el mappedBy
     */
    @JsonIgnoreProperties(value = {"proveedor"})
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "proveedor")
    private ProveedorDetalle proveedorDetalle;

    public Proveedor() {
    }

    public Proveedor(String nombre, String ruc) {
        this.nombre = nombre;
        this.ruc = ruc;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public ProveedorDetalle getProveedorDetalle() {
        return proveedorDetalle;
    }

    public void setProveedorDetalle(ProveedorDetalle proveedorDetalle) {
        this.proveedorDetalle = proveedorDetalle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Proveedor{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", ruc='").append(ruc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
