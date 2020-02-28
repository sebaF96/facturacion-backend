package ar.edu.um.facturacion.common;

import java.io.Serializable;

public interface Identificable<ID extends Serializable> {

    ID getId();

    void setDeleted(Boolean deleted);

    Boolean getDeleted();
}
