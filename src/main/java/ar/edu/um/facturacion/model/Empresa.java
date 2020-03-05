package ar.edu.um.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import ar.edu.um.facturacion.common.Identificable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "empresas")
public class Empresa implements Serializable, Identificable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String direccion;
    @NotEmpty
    private String provincia;
    @NotEmpty
    private String pais;
    @NotEmpty
    private String cuit;
    @NotEmpty
    private String codigo_postal;
    @NotEmpty
    private String ciudad;
    @Enumerated(EnumType.ORDINAL)
    private CondicionIva condicionIva;

    @Override
    public void setActive(Boolean active) {

    }

    @Override
    public Boolean getActive() {
        return true;
    }
}