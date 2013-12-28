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

package Trimestre.Primero.Ejercicios.LibroPdf;

import Utiles.Mensajes;

/**
 * Clase para realizar el ejercicio 4.20 del libro de texto
 * Como Programar en Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class MainEjercicio4_20 {
    
    /**
     * Método para ejecutar el ejercicio
     */
    public void Ejercicio()
    {
        // Objeto para pedir y mostrar datos al usuario
        Mensajes mensaje = new Mensajes();

        // Objeto para calcular el sueldo de un empleado
        Ejercicio4_20 sueldo;

        // Variable para almacenar las horas trabajadas por un empleado
        int numHorasTrabajadas;

        // Variable para almacenar el precio de una hora de trabajo
        double precioHoraTrabajo;
        
        // Iteramos tantas veces como trabajadores haya
        for (int i = 1; i < 4; i++) {

            // Pedimos al usuario el numero de horas trabajadas por cada trabajador
            numHorasTrabajadas = Integer.parseInt(mensaje.PedirDatos("Introduzca "
                    + "el número de horas trabajadas por el trabajador " + i, 
                    "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
            
            // Pedimos al usuario el precio por hora de cada trabajador
            precioHoraTrabajo = Double.parseDouble(mensaje.PedirDatos("Introduzca "
                    + "el precio por hora para el trabajador " + i, "Petición "
                            + "de Datos", Mensajes.TipoMensaje.PREGUNTA));
            
            // Creamos el objeto con los datos requeridos
            sueldo = new Ejercicio4_20(numHorasTrabajadas, precioHoraTrabajo);
            
            // Mostramos el resultado
            mensaje.MostrarMensaje("El sueldo bruto del trabajador " + i + 
                    " es de: " + sueldo.getSueldoBruto(), "Resultado", 
                    Mensajes.TipoMensaje.INFORMACION);
        }
    }
}
