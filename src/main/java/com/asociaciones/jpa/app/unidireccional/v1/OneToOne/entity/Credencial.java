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

    /**
     * La relación OneToOne en un tipo de
     * relación UNIDIRECCIONAL, podría estar
     * en el lado del Usuario y no en Credencial,
     * eso dependería del análisis que hagamos
     * y de cómo queremos manejarlo. Ahora, si fuese
     * una relación BIDIRECCIONAL, no habría qué tantas
     * vueltas darle al asunto, ya que la relación
     * estaría en ambos sentidos.
     * <p>
     * En este tipo de relación unidireccional, la
     * FK estaría en la tabla cuya clase tiene
     * la anotación @OneToOne, eso significa que en la
     * tabla credenciales de la BD tendríamos un FK
     * llamado usuario_id, por lo tanto, quien
     * es dueño de la relación es Credencial
     */
    @OneToOne
    @JoinColumn(name = "usuario_id") // Por defecto crea el fk usuario_id, pero nosotros seremos explícitos
    private Usuario usuario;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
