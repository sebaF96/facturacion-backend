package ar.edu.um.facturacion.service.impl;

import ar.edu.um.facturacion.common.GenericServiceImpl;
import ar.edu.um.facturacion.model.Pie;
import ar.edu.um.facturacion.repository.PieRepository;
import ar.edu.um.facturacion.service.api.PieServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PieServiceImpl extends GenericServiceImpl<Pie, Long> implements PieServiceAPI {

    private final PieRepository pieRepository;

    @Autowired
    public PieServiceImpl(PieRepository pieRepository) {
        this.pieRepository = pieRepository;
    }

    @Override
    public JpaRepository<Pie, Long> getRepository() {
        return pieRepository;
    }
}
