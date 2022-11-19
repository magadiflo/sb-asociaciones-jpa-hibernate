package com.asociaciones.jpa.app.unidireccional.v1.ManyToOne.resource;

import com.asociaciones.jpa.app.unidireccional.v1.ManyToOne.entity.Factura;
import com.asociaciones.jpa.app.unidireccional.v1.ManyToOne.repository.IFacturaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<?> guardarFactura(@RequestBody Factura factura) {
        return ResponseEntity.ok(this.facturaRepository.save(factura));
    }
}
