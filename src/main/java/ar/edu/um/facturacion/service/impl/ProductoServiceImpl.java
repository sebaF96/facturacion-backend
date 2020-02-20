package ar.edu.um.facturacion.service.impl;

import ar.edu.um.facturacion.common.GenericServiceImpl;
import ar.edu.um.facturacion.model.Producto;
import ar.edu.um.facturacion.repository.ProductoRepository;
import ar.edu.um.facturacion.service.api.ProductoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Long> implements ProductoServiceAPI {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public JpaRepository<Producto, Long> getRepository() {
        return productoRepository;
    }
}
