package ar.edu.um.facturacion.model;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode


public class Factura {
    private Encabezado encabezado;
    private List<Items> items;
    private Pie pie;

}
