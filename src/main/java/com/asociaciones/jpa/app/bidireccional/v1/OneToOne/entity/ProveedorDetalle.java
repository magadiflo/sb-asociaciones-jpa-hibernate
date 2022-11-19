package com.asociaciones.jpa.app.bidireccional.v1.OneToOne.entity;

import javax.persistence.*;

@Entity
@Table(name = "proveedor_detalles")
public class ProveedorDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProveedorDetalle{");
        sb.append("id=").append(id);
        sb.append(", tipo='").append(tipo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
