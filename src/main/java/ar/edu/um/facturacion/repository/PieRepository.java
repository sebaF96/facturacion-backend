package ar.edu.um.facturacion.repository;

import ar.edu.um.facturacion.model.Pie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieRepository extends JpaRepository<Pie, Long> {

}
