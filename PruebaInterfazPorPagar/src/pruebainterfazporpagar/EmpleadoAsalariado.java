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
public class EmpleadoAsalariado extends Empleado {

    private double salarioSemanal;

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    public void setSalarioSemanal(double salarioSemanal) {
        this.salarioSemanal = salarioSemanal < 0.0 ? 0 : salarioSemanal;
    }

    public EmpleadoAsalariado(String primerNombre, String apellidoPaterno, String numeroSeguroSocial, double salarioSemanal) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
        setSalarioSemanal(salarioSemanal);
    }

    @Override
    public double ingresos() {
        return getSalarioSemanal();
    }

    @Override
    public String toString() {
        return String.format("Empleado Asalariado: %s\n%s: $%,.2f",
                super.toString(), "Salario Semanal", getSalarioSemanal());
    }

    @Override
    public double obtenerMontoPago() {
        return getSalarioSemanal();
    }

}
