package ar.edu.um.facturacion.repository;

import ar.edu.um.facturacion.model.Encabezado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncabezadoRepository extends JpaRepository<Encabezado, Long> {
}
