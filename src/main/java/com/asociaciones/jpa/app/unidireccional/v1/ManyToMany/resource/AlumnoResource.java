package com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.resource;

import com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.entity.Alumno;
import com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.entity.Curso;
import com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.repository.IAlumnoRepository;
import com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.repository.ICursoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/unidireccional/v1/many-to-many/alumnos")
public class AlumnoResource {

    private final IAlumnoRepository alumnoRepository;
    private final ICursoRepository cursoRepository;


    public AlumnoResource(IAlumnoRepository alumnoRepository, ICursoRepository cursoRepository) {
        this.alumnoRepository = alumnoRepository;
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public ResponseEntity<?> listarAlumnos() {
        return ResponseEntity.ok(this.alumnoRepository.findAll());
    }

    @PostMapping(path = "/{alumnoId}")
    public ResponseEntity<?> agregarCurso(@RequestBody Curso curso, @PathVariable Long alumnoId) {
        Alumno alumno = this.alumnoRepository.findById(alumnoId).orElseThrow();
        alumno.getCursos().add(curso);

        return ResponseEntity.ok(this.alumnoRepository.save(alumno));
    }


}
