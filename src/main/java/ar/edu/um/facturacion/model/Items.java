package ar.edu.um.facturacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name="factura_items")
public class Items implements Serializable, Identificable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "productos_id")
    private Producto productos;
    @ManyToOne
    @JoinColumn(name = "facturas_encabezado_id")
    private Encabezado encabezado;
    private BigDecimal cantidad;
    private BigDecimal subTotal;


}