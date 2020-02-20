package ar.edu.um.facturacion.service.impl;

import ar.edu.um.facturacion.common.GenericServiceImpl;
import ar.edu.um.facturacion.model.Empresa;
import ar.edu.um.facturacion.repository.EmpresaRepository;
import ar.edu.um.facturacion.service.api.EmpresaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl extends GenericServiceImpl<Empresa, Long> implements EmpresaServiceAPI {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {

        this.empresaRepository = empresaRepository;
    }

    @Override
    public JpaRepository<Empresa, Long> getRepository() {

        return empresaRepository;
    }
}
