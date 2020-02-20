package ar.edu.um.facturacion.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
public class Encabezado implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String numero;
    private String letra;
    @OneToOne
    private Cliente cliente;
    private Boolean anulado;
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