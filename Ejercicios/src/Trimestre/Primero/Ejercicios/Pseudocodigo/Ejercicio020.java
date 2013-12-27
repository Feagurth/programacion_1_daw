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

package Trimestre.Primero.Ejercicios.Pseudocodigo;

import Utiles.Mensajes;

/**
 * Leer 500 números enteros y obtener cuántos son positivos
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio020 {
    
    /**
    * Ejercicio principal
    */
    public void ejercicio()
    {
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();
        
        // Variables
        int entero, contador = 0, numPositivos = 0;

        // Iteramos hasta que se cumpla la condición de salida
        do {
            contador++;
            
            // Petición de datos al usuario
            entero = Integer.parseInt(msg.PedirDatos("Introduzca un número", 
                    "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));
            
            // Comprobamos si el número es maypr de cero
            if(entero > 0)
            {
                // Aumentamos la cuenta de positivos
                numPositivos++;
            }
        } while (contador < 500);
        
        // Muestra de resultados al usuario
        msg.MostrarMensaje("La cantidad de números positivos es: " + numPositivos, 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
        
    
    }
    
}
