package ar.edu.um.facturacion.controller;


import ar.edu.um.facturacion.model.Items;
import ar.edu.um.facturacion.service.api.ItemsServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/items")
public class ItemsRest {

    private ItemsServiceAPI itemsServiceAPI;

    @Autowired
    public ItemsRest(ItemsServiceAPI itemsServiceAPI) {
        this.itemsServiceAPI = itemsServiceAPI;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Items> getItem(@PathVariable Long id){
        return itemsServiceAPI.get(id);
    }

    @PostMapping
    public ResponseEntity<Items> createItem(@Valid @RequestBody Items item){
        return itemsServiceAPI.add(item);
    }

    @PostMapping("/add")
    public ResponseEntity<List<Items>> createItems(@Valid @RequestBody List<Items> items){

        items.forEach(i -> itemsServiceAPI.add(i));
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Items> updateItems(@Valid @RequestBody Items item){
        return itemsServiceAPI.update(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable Long id){
        return itemsServiceAPI.delete(id);
    }

    @GetMapping("/add")
    public ResponseEntity<Items> adddd(){
        Items item = new Items();

        item.setProductos(itemsServiceAPI.getProducto(1L));
        item.setCantidad(BigDecimal.valueOf(5));
        item.setSubTotal(item.getCantidad().multiply(item.getProductos().getPrecio()));

        return itemsServiceAPI.add(item);
    }

}
