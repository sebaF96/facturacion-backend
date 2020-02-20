package ar.edu.um.facturacion.model;

public enum TipoFactura {
    A("A"), B("B"), C("C");

    private String tipo;

    TipoFactura(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
