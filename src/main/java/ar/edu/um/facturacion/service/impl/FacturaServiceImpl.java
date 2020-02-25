package ar.edu.um.facturacion.service.impl;

import ar.edu.um.facturacion.model.*;
import ar.edu.um.facturacion.repository.*;
import ar.edu.um.facturacion.service.api.FacturaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServiceImpl implements FacturaServiceAPI {

    private EncabezadoRepository encabezadoRepository;
    private PieRepository pieRepository;
    private ItemsRepository itemsRepository;
    private ProductoRepository productoRepository;
    private ClienteRepository clienteRepository;


    @Autowired
    public FacturaServiceImpl(EncabezadoRepository encabezadoRepository,
                              ClienteRepository clienteRepository,
                              PieRepository pieRepository,
                              ItemsRepository itemsRepository,
                              ProductoRepository productoRepository) {

        this.encabezadoRepository = encabezadoRepository;
        this.pieRepository = pieRepository;
        this.itemsRepository = itemsRepository;
        this.productoRepository = productoRepository;
        this.clienteRepository = clienteRepository;
    }


    @Override
    public ResponseEntity<Factura> createFactura(Encabezado encabezado, List<Items> items, Pie pie) {

        try {
            encabezado.setFecha(Date.valueOf(LocalDate.now()));
            encabezado.setCliente(clienteRepository.findById(encabezado.getCliente().getId()).orElse(null));
            encabezado.setLetra(encabezado.getCliente().getCondicionIva() == CondicionIva.RESPONSABLE_INSCRIPTO ? TipoFactura.A : TipoFactura.B);
            encabezadoRepository.save(encabezado);

            for (Items item : items) {
                item.setProducto(productoRepository.findById(item.getProducto().getId()).orElse(null));
                item.setSubTotal(item.getProducto().getPrecio().multiply(item.getCantidad()));
                item.setEncabezado(encabezado);
                itemsRepository.save(item);
            }

            pie.setFacturas_encabezado(encabezado);
            pie.setPrecioTotal(BigDecimal.valueOf(items.stream().map(Items::getSubTotal).mapToDouble(BigDecimal::doubleValue).sum()));
            pieRepository.save(pie);


            return new ResponseEntity<>(new Factura(encabezado, items, pie), HttpStatus.CREATED);
        } catch (NullPointerException e) {
            encabezadoRepository.delete(encabezado);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<Factura> getFacturaById(Long id) {
        try {
            Factura factura = new Factura();

            factura.setEncabezado(encabezadoRepository.findById(id).orElse(null));
            factura.setPie(pieRepository.findById(id).orElse(null));
            factura.setItems(factura.getEncabezado().getItems());

            return new ResponseEntity<>(factura, HttpStatus.OK);

        } catch (NullPointerException e) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Override
    public List<Factura> getFacturaByCliente(Long id) {

        if (!clienteRepository.findById(id).isPresent()) return null;

        Cliente cliente = clienteRepository.findById(id).get();
        ArrayList<Factura> facturas = new ArrayList<>();

        ArrayList<Encabezado> encabezados = (ArrayList<Encabezado>) encabezadoRepository.findAll()
                .stream()
                .filter(e -> e.getCliente().getId().equals(cliente.getId()))
                .collect(Collectors.toList());

        for (Encabezado encabezado : encabezados) {
            Factura factura = new Factura(encabezado, encabezado.getItems(), pieRepository.findById(encabezado.getId()).get());
            facturas.add(factura);
        }

        return facturas;
    }


}
