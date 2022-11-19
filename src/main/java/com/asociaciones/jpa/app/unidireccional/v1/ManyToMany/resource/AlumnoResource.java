package com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.resource;

import com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.repository.IAlumnoRepository;
import com.asociaciones.jpa.app.unidireccional.v1.ManyToMany.repository.ICursoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/unidireccional/v1/many-to-many/alumnos")
public class AlumnoResource {

    private final IAlumnoRepository alumnoRepository;
    private final ICursoRepository cursoRepository;


    public AlumnoResource(IAlumnoRepository alumnoRepository, ICursoRepository cursoRepository) {
        this.alumnoRepository = alumnoRepository;
        this.cursoRepository = cursoRepository;
    }


}
