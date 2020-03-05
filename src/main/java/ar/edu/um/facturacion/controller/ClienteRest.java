package ar.edu.um.facturacion.controller;

import ar.edu.um.facturacion.model.Cliente;
import ar.edu.um.facturacion.service.api.ClienteServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
        return clienteServiceAPI.get(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search")
    public List<Cliente> searchClientes(@RequestParam String query) {

        return clienteServiceAPI.findByNombreOrCuit(query, query);
    }

    @PostMapping
    public ResponseEntity<Cliente> addCliente(@Valid @RequestBody Cliente cliente) {
        return clienteServiceAPI.add(cliente);

    }

    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@Valid @RequestBody Cliente cliente) {

        return clienteServiceAPI.update(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCliente(@PathVariable Long id) {
        return clienteServiceAPI.delete(id);
    }

}