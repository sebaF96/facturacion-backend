package ar.edu.um.facturacion.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="empresas")
public class Empresa implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String provincia;
    private String pais;
    private String cuit;
    private String codigo_postal;
    private String ciudad;
    @Enumerated(EnumType.ORDINAL)
    private CondicionIva condicionIva;

}