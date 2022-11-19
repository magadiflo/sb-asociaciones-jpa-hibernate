package com.asociaciones.jpa.app.unidireccional.v1.OneToMany.custom.resource;

import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.custom.entity.Persona;
import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.custom.repository.IDireccionRepository;
import com.asociaciones.jpa.app.unidireccional.v1.OneToMany.custom.repository.IPersonaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/unidireccional/v1/one-to-many/custom/personas")
public class PersonaResource {

    private final IPersonaRepository personaRepository;
    private final IDireccionRepository direccionRepository;

    public PersonaResource(IPersonaRepository personaRepository, IDireccionRepository direccionRepository) {
        this.personaRepository = personaRepository;
        this.direccionRepository = direccionRepository;
    }

    @GetMapping
    public ResponseEntity<?> listarPersonas() {
        return ResponseEntity.ok(this.personaRepository.findAll());
    }
    
    @PostMapping
    public ResponseEntity<?> guardarPersonaConDirecciones(@RequestBody Persona persona) {
        return ResponseEntity.ok(this.personaRepository.save(persona));
    }
}
