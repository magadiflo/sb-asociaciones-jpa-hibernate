package com.asociaciones.jpa.app.unidireccional.v1.OneToOne.resource;

import com.asociaciones.jpa.app.unidireccional.v1.OneToOne.entity.Credencial;
import com.asociaciones.jpa.app.unidireccional.v1.OneToOne.entity.Usuario;
import com.asociaciones.jpa.app.unidireccional.v1.OneToOne.repository.ICredencialRepository;
import com.asociaciones.jpa.app.unidireccional.v1.OneToOne.repository.IUsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/unidireccional/v1/one-to-one/credenciales")
public class UsuarioResource {

    private final IUsuarioRepository usuarioRepository;
    private final ICredencialRepository credencialRepository;

    public UsuarioResource(IUsuarioRepository usuarioRepository, ICredencialRepository credencialRepository) {
        this.usuarioRepository = usuarioRepository;
        this.credencialRepository = credencialRepository;
    }

    @GetMapping
    public ResponseEntity<?> listarCredenciales() {
        return ResponseEntity.ok(this.credencialRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> guardarUsuarioCredencialesPorDefecto(@RequestBody Usuario usuario) {
        Usuario u = this.usuarioRepository.save(usuario);
        Credencial credencial = new Credencial(u.getEmail(), "123456", "user");
        credencial.setUsuario(u);
        return ResponseEntity.ok(this.credencialRepository.save(credencial));
    }


}
