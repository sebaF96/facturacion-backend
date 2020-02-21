package ar.edu.um.facturacion.service.impl;

import ar.edu.um.facturacion.model.Encabezado;
import ar.edu.um.facturacion.model.Factura;
import ar.edu.um.facturacion.model.Items;
import ar.edu.um.facturacion.model.Pie;
import ar.edu.um.facturacion.repository.*;
import ar.edu.um.facturacion.service.api.FacturaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaServiceAPI {


    private EncabezadoRepository encabezadoRepository;
;

    @Autowired
    public FacturaServiceImpl(EncabezadoRepository encabezadoRepository) {
        this.encabezadoRepository = encabezadoRepository;

    }


    @Override
    public ResponseEntity<Factura> createFactura(Encabezado encabezado, List<Items> items, Pie pie) {

        try {
            items.forEach(i -> i.setSubTotal(i.getProductos().getPrecio().multiply(i.getCantidad())));
            items.forEach(i -> i.setNombre(i.getProductos().getNombre()));
            encabezado.getItems().addAll(items);
            pie.setFacturas_encabezado(encabezado);
            pie.setPrecioTotal(BigDecimal.valueOf(items.stream().map(Items::getSubTotal).mapToInt(BigDecimal::intValue).sum()));

            encabezadoRepository.save(encabezado);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
