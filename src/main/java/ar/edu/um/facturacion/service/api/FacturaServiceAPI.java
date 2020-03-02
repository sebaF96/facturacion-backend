package ar.edu.um.facturacion.service.api;


import ar.edu.um.facturacion.model.Encabezado;
import ar.edu.um.facturacion.model.Factura;
import ar.edu.um.facturacion.model.Items;
import ar.edu.um.facturacion.model.Pie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FacturaServiceAPI {

    ResponseEntity<Factura> createFactura(Encabezado encabezado, List<Items> items, Pie pie);
    ResponseEntity<Factura> getFacturaById(Long id);
    ResponseEntity<String> deleteFacturaById(Long id);
    List<Factura> getFacturaByCliente(Long id);
    List<Factura> getAll();

}
