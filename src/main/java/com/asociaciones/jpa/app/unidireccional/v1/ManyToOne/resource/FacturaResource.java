package com.asociaciones.jpa.app.unidireccional.v1.ManyToOne.resource;

import com.asociaciones.jpa.app.unidireccional.v1.ManyToOne.repository.IFacturaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/unidireccional/v1/many-to-one/facturas")
public class FacturaResource {

    private final IFacturaRepository facturaRepository;

    public FacturaResource(IFacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @GetMapping
    public ResponseEntity<?> listarFacturas() {
        return ResponseEntity.ok(this.facturaRepository.findAll());
    }
}
