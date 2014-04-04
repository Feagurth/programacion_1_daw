/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasistemanomina;

/**
 *
 * @author Super
 */
public class EmpleadoPorHoras extends Empleado{

    private double sueldo;
    private double horas;

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = (sueldo < 0.0) ? 0.0 : sueldo;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = (horas >= 0.0 && horas <= 168.0) ? horas : 0.0;
    }

    public EmpleadoPorHoras(String primerNombre, String apellidoPaterno, String numeroSeguroSocial, double sueldo, double horas) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
        setSueldo(sueldo);
        setHoras(horas);
    }

    @Override
    public double ingresos()
    {
        if(getHoras()<= 40)
        {
            return getSueldo() * 40;
        }
        else
        {
            return 40 * getSueldo() + (getHoras() - 40 ) * getSueldo() * 1.5;
        }
    }

    @Override
    public String toString() {
        return String.format("Empleado Por Horas: %s%n%s: $%,.2f%n%s: %,.2f", 
                super.toString(), "Sueldo Por Horas", getSueldo(), "Horas Trabajadas", getHoras());
    }

    
    
}
