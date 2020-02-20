package ar.edu.um.facturacion.repository;

import ar.edu.um.facturacion.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Long> {
}
