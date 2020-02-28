package ar.edu.um.facturacion.service.impl;

import ar.edu.um.facturacion.common.GenericServiceImpl;
import ar.edu.um.facturacion.model.Cliente;
import ar.edu.um.facturacion.repository.ClienteRepository;
import ar.edu.um.facturacion.service.api.ClienteServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long> implements ClienteServiceAPI {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public JpaRepository<Cliente, Long> getRepository() {
        return clienteRepository;
    }

    @Override
    public List<Cliente> findByNombreOrCuit(String nombre, String cuit) {
        return clienteRepository.findByNombreContainingOrCuitContaining(nombre, cuit)
                .stream()
                .filter(Cliente::getActive)
                .collect(Collectors.toList());
    }

}