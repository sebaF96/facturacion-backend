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
import java.util.stream.Collectors;

@Service
public class FacturaServiceImpl implements FacturaServiceAPI {


    private EncabezadoRepository encabezadoRepository;
    private PieRepository pieRepository;
    private ItemsRepository itemsRepository;
    private ProductoRepository productoRepository;


    @Autowired
    public FacturaServiceImpl(EncabezadoRepository encabezadoRepository,
                              PieRepository pieRepository, ItemsRepository itemsRepository, ProductoRepository productoRepository) {
        this.encabezadoRepository = encabezadoRepository;
        this.pieRepository = pieRepository;
        this.itemsRepository = itemsRepository;
        this.productoRepository = productoRepository;
    }


    @Override
    public ResponseEntity<Factura> createFactura(Encabezado encabezado, List<Items> items, Pie pie) {
        try {
            items.forEach(i -> i.setProductos(productoRepository.findById(i.getProductos().getId()).get()));
            items.forEach(i -> i.setSubTotal(i.getProductos().getPrecio().multiply(i.getCantidad())));
            items.forEach(i -> i.setNombre(i.getProductos().getNombre()));
            items.forEach(i -> i.setEncabezado(encabezado));
            pie.setFacturas_encabezado(encabezado);
            pie.setPrecioTotal(BigDecimal.valueOf(items.stream().map(Items::getSubTotal).mapToInt(BigDecimal::intValue).sum()));

            encabezadoRepository.save(encabezado);
            pieRepository.save(pie);
            items.forEach(i -> itemsRepository.save(i));

            Factura factura = new Factura();
            factura.setEncabezado(encabezado);
            factura.setItems(items);
            factura.setPie(pie);

            return new ResponseEntity<>(factura, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            items.forEach(System.out::println);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public ResponseEntity<Factura> getFacturaById(Long id) {
        try {
            Factura factura = new Factura();

            factura.setEncabezado(encabezadoRepository.findById(id).orElse(null));
            factura.setPie(pieRepository.findById(id).orElse(null));
            List<Items> items = itemsRepository
                    .findAll()
                    .stream()
                    .filter(i -> i.getEncabezado().getId().equals(id))
                    .collect(Collectors.toList());
            factura.setItems(items);

            return new ResponseEntity<>(factura, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
