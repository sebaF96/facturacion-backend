package ar.edu.um.facturacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
@Table(name = "producto")
public class Producto implements Serializable, Identificable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String codigo;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String descripcion;
    @NotNull
    private BigDecimal precio;
    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean active = true;


}
