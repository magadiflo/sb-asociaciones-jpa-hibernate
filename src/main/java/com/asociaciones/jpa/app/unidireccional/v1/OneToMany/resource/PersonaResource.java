package com.asociaciones.jpa.app.unidireccional.v1.OneToMany.resource;

import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.entity.PersonaDefault;
import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.repository.IDireccionRepositoryDefault;
import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.repository.IPersonaRepositoryDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/unidireccional/v1/one-to-many/default/personas")
public class PersonaResource {

    private final IPersonaRepositoryDefault personaRepositoryDefault;
    private final IDireccionRepositoryDefault direccionRepositoryDefault;

    public PersonaResource(IPersonaRepositoryDefault personaRepositoryDefault, IDireccionRepositoryDefault direccionRepositoryDefault) {
        this.personaRepositoryDefault = personaRepositoryDefault;
        this.direccionRepositoryDefault = direccionRepositoryDefault;
    }

    @GetMapping
    public ResponseEntity<?> listarPersonas() {
        return ResponseEntity.ok(this.personaRepositoryDefault.findAll());
    }

    @PostMapping
    public ResponseEntity<?> guardarPersonaConDirecciones(@RequestBody PersonaDefault personaDefault) {
        return ResponseEntity.ok(this.personaRepositoryDefault.save(personaDefault));
    }
}
