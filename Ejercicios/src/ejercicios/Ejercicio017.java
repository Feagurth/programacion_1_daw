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

package ejercicios;

/**
 * Se desea calcular independientemente la suma de los números pares e 
 * impares comprendidos entre 1 y 200.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio017 {
    
    public void ejercicio()
    {
        // Objeto para mensajes y recogida de datos        
        Mensajes msg = new Mensajes();
        
        // Variables de control
        int contador, sumaPar, sumaImpar;
        
        contador = 0;
        sumaPar = 0;
        sumaImpar = 0;
        
        // Iteramos por los 200 primeros números
        do {
            contador++;
            
            // Si el módulo del número entre 2 es cero, es par
            if(contador % 2 == 0)
            {
                // Se aumenta el contador de los pares
                sumaPar++;
            }
            else // Si no, es impar
            {
                // Se aumenta el contador de los impares
                sumaImpar++;
            }
            
        } while (contador != 200);
        
        
        // Se muestran los resultados al usuario
        msg.MostrarMensaje("La suma de los pares de los 200 primeros números es: "
                + sumaPar, "Información", Mensajes.TipoMensaje.INFORMACION);
        
        msg.MostrarMensaje("La suma de los impares de los 200 primeros números es: "
                + sumaImpar, "Información", Mensajes.TipoMensaje.INFORMACION);
        
    }
    
}
