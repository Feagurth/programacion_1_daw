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
public class EmpleadoBaseMasComision extends EmpleadoPorComision {

    private double salarioBase;

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = (salarioBase < 0.0 ? 0.0 : salarioBase);
    }

    public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno, String numeroSeguroSocial, double ventasBrutas, double tarifaComision, double salarioBase) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial, ventasBrutas, tarifaComision);
        setSalarioBase(salarioBase);
    }

    @Override
    public double ingresos()
    {
        return getSalarioBase() + super.ingresos();
    }

    @Override
    public String toString() {
        return String.format("%s %s\n%s: %.2f",
                "Con Sueldo Base", 
                super.toString(), 
                "Salario Base", 
                getSalarioBase());
    }

    
    
    
    

}
