package ar.edu.um.facturacion.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;


@Service
public abstract class GenericServiceImpl<T extends Identificable<ID>, ID extends Serializable> implements GenericServiceAPI<T, ID> {

    @Override
    public ResponseEntity<T> add(T entity) {
        if(entity.getId() != null && getRepository().findById(entity.getId()).isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        getRepository().save(entity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<HttpStatus> delete(ID id) {
        if(!getRepository().findById(id).isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        T entity = getRepository().findById(id).get();
        entity.setDeleted(true);
        getRepository().save(entity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<T> get(ID id) {
        if(!getRepository().findById(id).isPresent() || getRepository().findById(id).get().getDeleted()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(getRepository().findById(id).get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<T> update(T entity) {
        if(!getRepository().findById(entity.getId()).isPresent() || entity.getDeleted()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        getRepository().save(entity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @Override
    public List<T> getAll() {
        return getRepository().findAll().stream().filter(e -> !e.getDeleted()).collect(Collectors.toList());
    }

    public abstract JpaRepository<T, ID> getRepository();

}
