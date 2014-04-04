/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaempleadobasemascomision;

/**
 *
 * @author Super
 */
public class EmpleadoPorComision {

    private String primerNombre;
    private String apellidoPaterno;
    private String numeroSeguroSocial;
    private double ventasBrutas;
    private double tarifaComision;

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    public void setNumeroSeguroSocial(String numeroSeguroSocial) {
        this.numeroSeguroSocial = numeroSeguroSocial;
    }

    public double getVentasBrutas() {
        return ventasBrutas;
    }

    public void setVentasBrutas(double ventasBrutas) {
        this.ventasBrutas = (ventasBrutas > 0 ? ventasBrutas : 0);
    }

    public double getTarifaComision() {
        return tarifaComision;
    }

    public void setTarifaComision(double tarifaComision) {
        this.tarifaComision = (tarifaComision > 0.0 && tarifaComision < 1.0 ? tarifaComision : 0);
    }

    public EmpleadoPorComision(String primerNombre, String apellidoPaterno, String numeroSeguroSocial, double ventasBrutas, double tarifaComision) {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroSeguroSocial = numeroSeguroSocial;
        setTarifaComision(tarifaComision);
        setVentasBrutas(ventasBrutas);
    }

    public double ingresos() {

        return this.tarifaComision * this.ventasBrutas;
    }

    @Override
    public String toString() {
        return "EmpleadoPorComision{" 
                + "primerNombre=" + primerNombre + ", "
                + "apellidoPaterno=" + apellidoPaterno + ", "
                + "numeroSeguroSocial=" + numeroSeguroSocial + ", "
                + "ventasBrutas=" + ventasBrutas + ", "
                + "tarifaComision=" + tarifaComision + '}';
    }

}
