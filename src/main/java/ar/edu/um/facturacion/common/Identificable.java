package ar.edu.um.facturacion.common;

import java.io.Serializable;

public interface Identificable<ID extends Serializable> {

    ID getId();

    void setActive(Boolean active);

    Boolean getActive();

    String getNombre();
}
