package com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    @JsonIgnoreProperties(value = {"profesors"}, allowSetters = true)
    @JoinTable(name = "tbl_profesores_asignaturas",
            joinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "asignatura_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"profesor_id", "asignatura_id"}))
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Asignatura> asignaturas;

    public Profesor() {
        this.asignaturas = new ArrayList<>();
    }

    public Profesor(String nombre, String apellido) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
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

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas.clear();
        asignaturas.forEach(this::addAsignatura);
    }

    public void addAsignatura(Asignatura asignatura) {
        this.asignaturas.add(asignatura);
        asignatura.getProfesors().add(this);
    }

    public void removeAsignatura(Asignatura asignatura) {
        asignatura.getProfesors().remove(this);
        this.asignaturas.remove(asignatura);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(id, profesor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Profesor{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
