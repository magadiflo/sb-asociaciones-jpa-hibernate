package com.asociaciones.jpa.app.unidireccional.v1.OneToMany.entity;

import javax.persistence.*;

@Entity
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String avenida;

    private String manzana;

    private Integer lote;

    public Direccion() {
    }

    public Direccion(String avenida, String manzana, Integer lote) {
        this.avenida = avenida;
        this.manzana = manzana;
        this.lote = lote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvenida() {
        return avenida;
    }

    public void setAvenida(String avenida) {
        this.avenida = avenida;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Direccion{");
        sb.append("id=").append(id);
        sb.append(", avenida='").append(avenida).append('\'');
        sb.append(", manzana='").append(manzana).append('\'');
        sb.append(", lote=").append(lote);
        sb.append('}');
        return sb.toString();
    }
}
