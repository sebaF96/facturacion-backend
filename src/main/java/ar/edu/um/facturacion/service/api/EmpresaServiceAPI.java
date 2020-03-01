package ar.edu.um.facturacion.service.api;

import ar.edu.um.facturacion.common.GenericServiceAPI;
import ar.edu.um.facturacion.model.Empresa;
import org.springframework.http.ResponseEntity;

public interface EmpresaServiceAPI extends GenericServiceAPI<Empresa, Long> {

    ResponseEntity<Empresa> getFirst();
}
