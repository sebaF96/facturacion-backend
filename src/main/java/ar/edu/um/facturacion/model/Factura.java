package ar.edu.um.facturacion.model;

import java.util.List;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor


public class Factura {
    private Encabezado encabezado;
    private List<Items> items;
    private Pie pie;

}
