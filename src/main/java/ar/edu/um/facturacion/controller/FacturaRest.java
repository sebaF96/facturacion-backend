package ar.edu.um.facturacion.controller;


import ar.edu.um.facturacion.model.Encabezado;
import ar.edu.um.facturacion.model.Factura;
import ar.edu.um.facturacion.model.Items;
import ar.edu.um.facturacion.model.Pie;
import ar.edu.um.facturacion.service.api.FacturaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/facturas")
public class FacturaRest {

    private FacturaServiceAPI facturaServiceAPI;

    @Autowired
    public FacturaRest(FacturaServiceAPI facturaServiceAPI) {
        this.facturaServiceAPI = facturaServiceAPI;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Factura> getFactura(@PathVariable Long id){
        return facturaServiceAPI.getFacturaById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cliente/{clienteId}")
    public List<Factura> getFacturasByCliente(@PathVariable Long clienteId){
        return facturaServiceAPI.getFacturaByCliente(clienteId);
    }

    @PostMapping
    public ResponseEntity<Factura> createFactura(@RequestBody Factura factura){
        return facturaServiceAPI.createFactura(factura.getEncabezado(), factura.getItems(), factura.getPie());
    }

}
