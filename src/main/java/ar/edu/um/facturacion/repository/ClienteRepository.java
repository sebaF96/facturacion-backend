package ar.edu.um.facturacion.repository;

import ar.edu.um.facturacion.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNombreContainingOrCuitContaining(String nombre, String cuit);
}
