package ar.edu.um.facturacion.service.api;

import ar.edu.um.facturacion.common.GenericServiceAPI;
import ar.edu.um.facturacion.model.Producto;

import java.util.List;

public interface ProductoServiceAPI extends GenericServiceAPI<Producto, Long> {

    List<Producto> findByNombreOrCodigo(String nombre, String codigo);
}
