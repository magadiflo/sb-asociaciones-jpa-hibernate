package com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    /**
     * En este caso, la tabla Alumnos será la tabla principal o parent,
     * por esa razón es que manejamos el CASCADE, para que cuando se cree
     * o actualice, se haga en cascada.
     * <p>
     * Importante, no podemos colocar el CascadeType.ALL ya que eso incluiría
     * el REMOVE y en una relación de muchos a muchos puede que alguna entidad
     * tenga también los cursos y si se elimina la entidad Alumno, esta eliminaría
     * en cascada sus cursos asociados generando un error de constraint, ya que
     * otros alumnos también podrían estar relacionados con esos cursos
     */

    @JoinTable(name = "tbl_alumnos_cursos",
            joinColumns = @JoinColumn(name = "alumno_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"alumno_id", "curso_id"}))
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Curso> cursos;

    public Alumno() {
        this.cursos = new ArrayList<>();
    }

    public Alumno(String nombre, String apellido) {
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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Alumno{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
