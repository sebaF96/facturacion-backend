package ar.edu.um.facturacion.repository;

import ar.edu.um.facturacion.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
