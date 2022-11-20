package com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.resource;

import com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.entity.Asignatura;
import com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.entity.Profesor;
import com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.repository.IAsignaturaRepository;
import com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.repository.IProfesorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bidireccional/v1/many-to-many/profesores")
public class ProfesorResource {

    private final IProfesorRepository profesorRepository;
    private final IAsignaturaRepository asignaturaRepository;

    public ProfesorResource(IProfesorRepository profesorRepository, IAsignaturaRepository asignaturaRepository) {
        this.profesorRepository = profesorRepository;
        this.asignaturaRepository = asignaturaRepository;
    }

    @GetMapping
    public ResponseEntity<?> listarProfesores() {
        return ResponseEntity.ok(this.profesorRepository.findAll());
    }

    @GetMapping(path = "/asignaturas")
    public ResponseEntity<?> listarAsignaturas() {
        return ResponseEntity.ok(this.asignaturaRepository.findAll());
    }

    @PostMapping(path = "/{profesorId}")
    public ResponseEntity<?> guardarAsignaturaAProfesor(@RequestBody Asignatura asignatura, @PathVariable Long profesorId) {
        Profesor profesor = this.profesorRepository.findById(profesorId).orElseThrow();
        profesor.getAsignaturas().add(asignatura);
        return ResponseEntity.ok(this.profesorRepository.save(profesor));
    }

    @PostMapping(path = "/asignatura/{asignaturaId}")
    public ResponseEntity<?> guardarProfesorACurso(@RequestBody Profesor profesor, @PathVariable Long asignaturaId) {
        Asignatura asignatura = this.asignaturaRepository.findById(asignaturaId).orElseThrow();
        profesor.addAsignatura(asignatura);
        return ResponseEntity.ok(this.profesorRepository.save(profesor));
    }

}
