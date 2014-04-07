/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebainterfazporpagar;

/**
 *
 * @author Super
 */
public class Factura implements PorPagar {

    private String numeroArticulo;
    private String descripcionPieza;
    private int cantidad;
    private double precioPorArticulo;

    public String getNumeroArticulo() {
        return numeroArticulo;
    }

    public void setNumeroArticulo(String numeroArticulo) {
        this.numeroArticulo = numeroArticulo;
    }

    public String getDescripcionPieza() {
        return descripcionPieza;
    }

    public void setDescripcionPieza(String descripcionPieza) {
        this.descripcionPieza = descripcionPieza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = (cantidad < 0 ? 0 : cantidad);
    }

    public double getPrecioPorArticulo() {
        return precioPorArticulo;
    }

    public void setPrecioPorArticulo(double precioPorArticulo) {
        this.precioPorArticulo = precioPorArticulo;
    }

    public Factura(String numeroArticulo, String descripcionPieza, int cantidad, double precioPorArticulo) {
        setNumeroArticulo(numeroArticulo);
        setDescripcionPieza(descripcionPieza);
        setCantidad(cantidad);
        setPrecioPorArticulo(precioPorArticulo);
    }

    @Override
    public double obtenerMontoPago() {
        return (getCantidad() * getPrecioPorArticulo());
    }

    @Override
    public String toString() {
        return String.format("Numero Artículo: %s%n"
                + "Descripción: %s%n"
                + "Cantidad: %s%n"
                + "Precio Por Artículo: %s",
                getNumeroArticulo(),
                getDescripcionPieza(),
                getCantidad(),
                getPrecioPorArticulo());
    }
}
