package com.asociaciones.jpa.app.unidireccional.v1.OneToMany.custom.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    /**
     * Como se ve en el directorio default, también hay una relación
     * OneToMany, pero por defecto allí Hibernate crea una tabla intermedia.
     * En este directorio /custom, cambiaremos ese comportamiento, donde
     * eliminaremos esa tabla intermedia creada por defecto y estableceremos
     * una FK en la tabla de cardinalidad Muchos (direcciones) de la BD.
     * Para eso usamos la anotación @JoinColumn(name = "persona_id") para
     * especificarle que la FK irá en la tabla direcciones de la BD, así ya
     * no creará esa tabla intermedia.
     *
     * "persona_id", ese atributo será la FK y lo colocará en la tabla direcciones de la BD.
     *
     * ¡IMPORTANTE!, la relación debe ser UNIDIRECCIONAL
     */
    @JoinColumn(name = "persona_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // Las definimos porque Persona es una clase principal
    private List<Direccion> direcciones;

    @PrePersist
    private void prePersist() {
        this.createAt = LocalDateTime.now();
    }

    public Persona() {
        this.direcciones = new ArrayList<>();
    }

    public Persona(String nombre, String apellido) {
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", createAt=").append(createAt);
        sb.append('}');
        return sb.toString();
    }
}
