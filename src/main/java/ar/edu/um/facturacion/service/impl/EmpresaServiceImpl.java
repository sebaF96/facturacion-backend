package ar.edu.um.facturacion.service.impl;

import ar.edu.um.facturacion.common.GenericServiceImpl;
import ar.edu.um.facturacion.model.Empresa;
import ar.edu.um.facturacion.repository.EmpresaRepository;
import ar.edu.um.facturacion.service.api.EmpresaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl extends GenericServiceImpl<Empresa, Long> implements EmpresaServiceAPI {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {

        this.empresaRepository = empresaRepository;
    }

    @Override
    public ResponseEntity<HttpStatus> delete(Long id) {

        if (!empresaRepository.findById(id).isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        empresaRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Empresa> getFirst() {

        if (empresaRepository.findAll().size() == 0) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(empresaRepository.findAll().get(0), HttpStatus.OK);

    }

    @Override
    public JpaRepository<Empresa, Long> getRepository() {

        return empresaRepository;
    }
}
