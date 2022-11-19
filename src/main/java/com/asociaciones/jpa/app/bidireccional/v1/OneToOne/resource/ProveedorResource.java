package com.asociaciones.jpa.app.bidireccional.v1.OneToOne.resource;

import com.asociaciones.jpa.app.bidireccional.v1.OneToOne.entity.Proveedor;
import com.asociaciones.jpa.app.bidireccional.v1.OneToOne.entity.ProveedorDetalle;
import com.asociaciones.jpa.app.bidireccional.v1.OneToOne.repository.IProveedorDetalleRepository;
import com.asociaciones.jpa.app.bidireccional.v1.OneToOne.repository.IProveedorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bidireccional/v1/many-to-one/proveedores")
public class ProveedorResource {

    private final IProveedorRepository proveedorRepository;
    private final IProveedorDetalleRepository proveedorDetalleRepository;

    public ProveedorResource(IProveedorRepository proveedorRepository, IProveedorDetalleRepository proveedorDetalleRepository) {
        this.proveedorRepository = proveedorRepository;
        this.proveedorDetalleRepository = proveedorDetalleRepository;
    }

    @GetMapping
    public ResponseEntity<?> listarProveedores() {
        return ResponseEntity.ok(this.proveedorRepository.findAll());
    }
    @GetMapping(path = "/detalles")
    public ResponseEntity<?> listarProveedorDetalles() {
        return ResponseEntity.ok(this.proveedorDetalleRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> guardarProveedorDetallePorDefault(@RequestBody Proveedor proveedor) {
        ProveedorDetalle proveedorDetalle = new ProveedorDetalle("minorista");
        proveedor.addProveedorDetalle(proveedorDetalle);

        return ResponseEntity.ok(this.proveedorRepository.save(proveedor));
    }
}
