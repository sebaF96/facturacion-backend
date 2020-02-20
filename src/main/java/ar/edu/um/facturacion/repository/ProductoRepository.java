package ar.edu.um.facturacion.repository;

import ar.edu.um.facturacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
