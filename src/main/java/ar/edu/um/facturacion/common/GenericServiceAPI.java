package ar.edu.um.facturacion.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI<T, ID extends Serializable> {

    ResponseEntity<T> add(T entity);

    ResponseEntity<HttpStatus> delete(ID id);

    ResponseEntity<T> get(ID id);

    ResponseEntity<T> update(T entity);

    List<T> getAll();

}
