package ar.edu.um.facturacion.service.impl;

import ar.edu.um.facturacion.common.GenericServiceImpl;
import ar.edu.um.facturacion.model.Items;
import ar.edu.um.facturacion.model.Producto;
import ar.edu.um.facturacion.repository.ItemsRepository;
import ar.edu.um.facturacion.repository.ProductoRepository;
import ar.edu.um.facturacion.service.api.ItemsServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl extends GenericServiceImpl<Items, Long> implements ItemsServiceAPI {

    private final ItemsRepository itemsRepository;
    private final ProductoRepository productoRepository;

    @Autowired
    public ItemsServiceImpl(ItemsRepository itemsRepository, ProductoRepository productoRepository) {
        this.itemsRepository = itemsRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public JpaRepository<Items, Long> getRepository() {
        return itemsRepository;
    }

    @Override
    public Producto getProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }
}
