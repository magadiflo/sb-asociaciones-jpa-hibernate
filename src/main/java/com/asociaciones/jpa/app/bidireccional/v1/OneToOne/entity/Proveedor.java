package com.asociaciones.jpa.app.bidireccional.v1.OneToOne.entity;

import javax.persistence.*;

@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String ruc;

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
