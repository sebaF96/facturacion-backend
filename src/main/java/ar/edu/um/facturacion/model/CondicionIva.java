package ar.edu.um.facturacion.model;

public enum CondicionIva {
    RESPONSABLE_INSCRIPTO("Responsable inscripto"),
    MONOTRIBUTISTA("Monotributista"),
    CONSUMIDOR_FINAL("Consumidor final");

    private String condicion;

    CondicionIva(String condicion) {
        this.condicion = condicion;
    }

    @Override
    public String toString() {
        return condicion;
    }
}
