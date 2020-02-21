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
@Table(name="facturas_encabezado")
public class Encabezado implements Serializable, Identificable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    @Enumerated(EnumType.ORDINAL)
    private TipoFactura letra;
    @OneToOne
    private Cliente cliente;
    @OneToMany(mappedBy = "encabezado")
    private List<Items> items;


    public void addItem(Items item){
        items.add(item);
        item.setEncabezado(this);
    }

    public void removeItem(Items item){
        items.remove(item);
        item.setEncabezado(null);
    }
}