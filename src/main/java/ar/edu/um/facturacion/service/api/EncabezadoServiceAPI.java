package ar.edu.um.facturacion.service.api;

import ar.edu.um.facturacion.common.GenericServiceAPI;
import ar.edu.um.facturacion.model.Cliente;
import ar.edu.um.facturacion.model.Encabezado;

public interface EncabezadoServiceAPI extends GenericServiceAPI<Encabezado, Long> {

    public Cliente getCliente(Long id);
}
