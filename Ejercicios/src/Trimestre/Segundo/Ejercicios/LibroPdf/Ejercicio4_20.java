/*
 * Copyright (C) 2013 Luis Cabrerizo Gómez
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package Trimestre.Segundo.Ejercicios.LibroPdf;

/**
 * Clase para controlar el sueldo de los empleados
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_20 {
    
    private final int numHorasTrabajadas;
    private final double precioHoraTrabajo;
    private double sueldoBruto = 0;

    /**
     * Devuelve el sueldo bruto del trabajador
     * @return El sueldo bruto del trabajador
     */
    public double getSueldoBruto() {
        return sueldoBruto;
    }
    
    /**
     * Constructor de la clase
     * @param numHorasTrabajadas Número de horas trabajadas
     * @param precioHoraTrabajo Precio por hora de trabajo
     */
    public Ejercicio4_20(int numHorasTrabajadas, double precioHoraTrabajo) {
        this.numHorasTrabajadas = numHorasTrabajadas;
        this.precioHoraTrabajo = precioHoraTrabajo;
        
        // Comprobamos si el número de horas trabajadas es superior a 40
        if(numHorasTrabajadas < 40)
        {
            // Si no lo es, calculamos el sueldo de forma normal
            this.sueldoBruto = this.numHorasTrabajadas * this.precioHoraTrabajo;
        }
        else
        {
            // Si es superior a 40, primero calculamos de forma normal las 
            // primeras 40 horas
            this.sueldoBruto = 40 * this.precioHoraTrabajo;
            
            // Calculamos las horas restantes con un precio multiplicado por 1.5
            this.sueldoBruto += (numHorasTrabajadas - 40) * 
                    (precioHoraTrabajo * 1.5);
        }        
    }
}
