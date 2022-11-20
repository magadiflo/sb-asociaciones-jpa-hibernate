package com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.resource;

import com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.repository.IAsignaturaRepository;
import com.asociaciones.jpa.app.bidireccional.v1.ManyToMany.repository.IProfesorRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bidireccional/v1/many-to-many/profesores")
public class ProfesorResource {

    private final IProfesorRepository profesorRepository;
    private final IAsignaturaRepository asignaturaRepository;

    public ProfesorResource(IProfesorRepository profesorRepository, IAsignaturaRepository asignaturaRepository) {
        this.profesorRepository = profesorRepository;
        this.asignaturaRepository = asignaturaRepository;
    }


}
