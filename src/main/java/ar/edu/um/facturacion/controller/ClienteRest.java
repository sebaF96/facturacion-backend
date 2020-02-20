package ar.edu.um.facturacion.controller;

import ar.edu.um.facturacion.model.Cliente;
import ar.edu.um.facturacion.model.CondicionIva;
import ar.edu.um.facturacion.service.api.ClienteServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/clientes")
public class ClienteRest {

    private final ClienteServiceAPI clienteServiceAPI;

    @Autowired
    public ClienteRest(ClienteServiceAPI clienteServiceAPI) {
        this.clienteServiceAPI = clienteServiceAPI;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> getAll() {

        return clienteServiceAPI.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {

        Cliente cliente = clienteServiceAPI.get(id);
        if (cliente == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search")
    public List<Cliente> searchClientes(@RequestParam String query) {

        return clienteServiceAPI.findByNombreOrCuit(query, query);
    }

    @PostMapping
    public ResponseEntity<Cliente> addCliente(@Valid @RequestBody Cliente cliente) {
        if (cliente.getId() != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        clienteServiceAPI.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);


    }

    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@Valid @RequestBody Cliente cliente) {
        if (clienteServiceAPI.get(cliente.getId()) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        clienteServiceAPI.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/add")
    public ResponseEntity<Cliente> test() {
        Cliente cliente = new Cliente();
        cliente.setDireccion("Cayetano Silva");
        cliente.setNombre("Luna Facunda");
        cliente.setCuit("398376262");
        cliente.setCondicionIva(CondicionIva.MONOTRIBUTISTA);

        clienteServiceAPI.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }
}