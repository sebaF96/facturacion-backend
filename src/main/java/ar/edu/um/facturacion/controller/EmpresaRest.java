package ar.edu.um.facturacion.controller;


import ar.edu.um.facturacion.model.Empresa;
import ar.edu.um.facturacion.service.api.EmpresaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/empresa")
public class EmpresaRest {

    private final EmpresaServiceAPI empresaServiceAPI;

    @Autowired
    public EmpresaRest(EmpresaServiceAPI empresaServiceAPI) {
        this.empresaServiceAPI = empresaServiceAPI;
    }

    @GetMapping
    public ResponseEntity<Empresa> getOneEmpresa() {
        return empresaServiceAPI.getFirst();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable Long id) {
        return empresaServiceAPI.get(id);
    }

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@Valid @RequestBody Empresa empresa) {
        return empresaServiceAPI.add(empresa);
    }

    @PutMapping
    public ResponseEntity<Empresa> updateEmpresa(@Valid @RequestBody Empresa empresa) {
        return empresaServiceAPI.update(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEmpresa(@PathVariable Long id) {
        return empresaServiceAPI.delete(id);
    }

}
