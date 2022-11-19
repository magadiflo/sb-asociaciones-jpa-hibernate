package com.asociaciones.jpa.app.unidireccional.v1.OneToOne.resource;

import com.asociaciones.jpa.app.unidireccional.v1.OneToOne.repository.ICredencialRepository;
import com.asociaciones.jpa.app.unidireccional.v1.OneToOne.repository.IUsuarioRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/unidireccional/v1/one-to-one/usuarios")
public class UsuarioResource {

    private final IUsuarioRepository usuarioRepository;
    private final ICredencialRepository credencialRepository;

    public UsuarioResource(IUsuarioRepository usuarioRepository, ICredencialRepository credencialRepository) {
        this.usuarioRepository = usuarioRepository;
        this.credencialRepository = credencialRepository;
    }


}
