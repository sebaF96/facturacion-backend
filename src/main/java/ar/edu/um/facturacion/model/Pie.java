package ar.edu.um.facturacion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="factura_pie")
public class Pie implements Serializable{

    @Id
    private Long pie_id;

    @MapsId
    @OneToOne
    @JoinColumn(name="encabezado_id")
    private Encabezado facturas_encabezado;
    private BigDecimal precioTotal;
    private String observaciones;


}