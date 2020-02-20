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
@CrossOrigin("*")
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

        Producto producto = productoServiceAPI.get(id);

        if (producto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(producto, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProductoById(@PathVariable Long id) {

        if (productoServiceAPI.get(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        productoServiceAPI.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@Valid @RequestBody Producto producto) {
        if (producto.getId() != null && productoServiceAPI.get(producto.getId()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            productoServiceAPI.save(producto);
            return new ResponseEntity<>(producto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Producto> updateProducto(@Valid @RequestBody Producto producto){
        if(productoServiceAPI.get(producto.getId()) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        productoServiceAPI.save(producto);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
}
