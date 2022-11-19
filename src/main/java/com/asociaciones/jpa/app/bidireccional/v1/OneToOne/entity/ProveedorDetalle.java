package com.asociaciones.jpa.app.bidireccional.v1.OneToOne.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "proveedores_detalles")
public class ProveedorDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @JsonIgnoreProperties(value = {"proveedorDetalle"})
    @OneToOne
    @JoinColumn(name = "proveedor_id") // Aquí estará la FK
    private Proveedor proveedor;

    public ProveedorDetalle() {
    }

    public ProveedorDetalle(String tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProveedorDetalle{");
        sb.append("id=").append(id);
        sb.append(", tipo='").append(tipo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
