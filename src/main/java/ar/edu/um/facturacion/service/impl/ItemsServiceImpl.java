package ar.edu.um.facturacion.service.impl;

import ar.edu.um.facturacion.common.GenericServiceImpl;
import ar.edu.um.facturacion.model.Items;
import ar.edu.um.facturacion.repository.ItemsRepository;
import ar.edu.um.facturacion.service.api.ItemsServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl extends GenericServiceImpl<Items, Long> implements ItemsServiceAPI {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsServiceImpl(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @Override
    public JpaRepository<Items, Long> getRepository() {
        return itemsRepository;
    }
}
