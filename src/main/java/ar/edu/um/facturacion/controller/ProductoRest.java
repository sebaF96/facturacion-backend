package ar.edu.um.facturacion.controller;

import ar.edu.um.facturacion.model.Producto;
import ar.edu.um.facturacion.service.api.ProductoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductoRest {

    private final ProductoServiceAPI productoServiceAPI;

    @Autowired
    public ProductoRest(ProductoServiceAPI productoServiceAPI) {
        this.productoServiceAPI = productoServiceAPI;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> getProductos() {
        return productoServiceAPI.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
        return productoServiceAPI.get(id);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search")
    public List<Producto> searchProductos(@RequestParam String query) {
        return productoServiceAPI.findByNombreOrCodigo(query, query);
    }


    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProductoById(@PathVariable Long id) {
        return productoServiceAPI.delete(id);
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@Valid @RequestBody Producto producto) {
        return productoServiceAPI.add(producto);

    }

    @PutMapping
    public ResponseEntity<Producto> updateProducto(@Valid @RequestBody Producto producto) {
        return productoServiceAPI.update(producto);
    }

}
