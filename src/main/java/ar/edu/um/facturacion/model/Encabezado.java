package ar.edu.um.facturacion.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import ar.edu.um.facturacion.common.Identificable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "facturas_encabezado")
public class Encabezado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    @Enumerated(EnumType.ORDINAL)
    private TipoFactura letra;
    @OneToOne
    private Cliente cliente;
    @JsonIgnore
    @OneToMany(mappedBy = "encabezado")
    private List<Items> items;

}