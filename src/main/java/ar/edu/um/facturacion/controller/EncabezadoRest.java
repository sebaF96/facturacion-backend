package ar.edu.um.facturacion.controller;


import ar.edu.um.facturacion.model.Cliente;
import ar.edu.um.facturacion.model.CondicionIva;
import ar.edu.um.facturacion.model.Encabezado;
import ar.edu.um.facturacion.model.TipoFactura;
import ar.edu.um.facturacion.service.api.EncabezadoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/encabezado")
public class EncabezadoRest {

    private EncabezadoServiceAPI encabezadoServiceAPI;

    @Autowired
    public EncabezadoRest(EncabezadoServiceAPI encabezadoServiceAPI) {
        this.encabezadoServiceAPI = encabezadoServiceAPI;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Encabezado> getEncabezado(@PathVariable Long id){
        return encabezadoServiceAPI.get(id);
    }

    @PostMapping
    public ResponseEntity<Encabezado> createEncabezado(@Valid @RequestBody Encabezado encabezado){
        return encabezadoServiceAPI.add(encabezado);
    }

    @PutMapping
    public ResponseEntity<Encabezado> updateEncabezado(@Valid @RequestBody Encabezado encabezado){
        return encabezadoServiceAPI.update(encabezado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEncabezado(@PathVariable Long id){
        return encabezadoServiceAPI.delete(id);
    }

    @GetMapping("/add")
        public ResponseEntity<Encabezado> adddd(){
        Encabezado encabezado = new Encabezado();
        encabezado.setCliente(encabezadoServiceAPI.getCliente(1L));
        encabezado.setLetra(TipoFactura.A);
        Date date = Date.valueOf(LocalDate.now());
        encabezado.setFecha(date);

        return encabezadoServiceAPI.add(encabezado);
    }
}
