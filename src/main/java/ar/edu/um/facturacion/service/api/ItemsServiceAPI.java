package ar.edu.um.facturacion.service.api;

import ar.edu.um.facturacion.common.GenericServiceAPI;
import ar.edu.um.facturacion.model.Items;
import ar.edu.um.facturacion.model.Producto;

public interface ItemsServiceAPI extends GenericServiceAPI<Items, Long> {

    Producto getProducto(Long id);
}
