package ar.edu.um.facturacion.repository;

import ar.edu.um.facturacion.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombreContainingOrCodigoContaining(String nombre, String codigo);
}
