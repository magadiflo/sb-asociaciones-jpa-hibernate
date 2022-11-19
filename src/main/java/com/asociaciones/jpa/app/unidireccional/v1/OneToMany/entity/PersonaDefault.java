package com.asociaciones.jpa.app.unidireccional.v1.OneToMany.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personas_default")
public class PersonaDefault {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    /**
     * Por defecto, tal y como está ahora la relación OneToMany,
     * JPA/Hibernate creará una tabla intermedia entre
     * personas_default y direcciones_default con el identificador
     * de cada tabla. Donde, no creará una clave primaria en esta tabla
     * intermedia, sino más bien creará dos claves,
     * única: direcciones_default_id
     * foránea: persona_default_id
     * <p>
     * create table personas_default_direcciones_default (
     *      persona_default_id bigint not null,
     *      direcciones_default_id bigint not null
     * ) engine=InnoDB
     */

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // Las definimos porque Persona es una clase principal
    private List<DireccionDefault> direccionesDefault;

    @PrePersist
    private void prePersist() {
        this.createAt = LocalDateTime.now();
    }

    public PersonaDefault() {
        this.direccionesDefault = new ArrayList<>();
    }

    public PersonaDefault(String nombre, String apellido) {
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

    public List<DireccionDefault> getDireccionesDefault() {
        return direccionesDefault;
    }

    public void setDireccionesDefault(List<DireccionDefault> direccionesDefault) {
        this.direccionesDefault = direccionesDefault;
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
