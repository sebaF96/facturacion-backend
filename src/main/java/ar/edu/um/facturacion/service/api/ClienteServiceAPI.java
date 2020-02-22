package ar.edu.um.facturacion.service.api;

import ar.edu.um.facturacion.common.GenericServiceAPI;
import ar.edu.um.facturacion.model.Cliente;
import ar.edu.um.facturacion.model.Producto;

import java.util.List;

public interface ClienteServiceAPI extends GenericServiceAPI<Cliente, Long> {

    List<Cliente> findByNombreOrCuit(String nombre, String cuit);

}