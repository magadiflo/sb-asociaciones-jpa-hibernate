package com.asociaciones.jpa.app.unidireccional.v1.OneToOne.entity;

import javax.persistence.*;

@Entity
@Table(name = "credenciales")
public class Credencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    public Credencial() {
    }

    public Credencial(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    private String rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Credencial{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", rol='").append(rol).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
