package ar.edu.um.facturacion.service.impl;

import ar.edu.um.facturacion.common.GenericServiceImpl;
import ar.edu.um.facturacion.model.Encabezado;
import ar.edu.um.facturacion.repository.EncabezadoRepository;
import ar.edu.um.facturacion.service.api.EncabezadoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EncabezadoServiceImpl extends GenericServiceImpl<Encabezado, Long> implements EncabezadoServiceAPI {

    private final EncabezadoRepository encabezadoRepository;

    @Autowired
    public EncabezadoServiceImpl(EncabezadoRepository encabezadoRepository) {
        this.encabezadoRepository = encabezadoRepository;
    }


    @Override
    public JpaRepository<Encabezado, Long> getRepository() {
        return encabezadoRepository;
    }
}
