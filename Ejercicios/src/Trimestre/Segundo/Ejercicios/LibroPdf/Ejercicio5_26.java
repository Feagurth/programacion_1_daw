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

import Utiles.Mensajes;

/**
 * Clase para realizar el ejercicio 5.26 del libro de texto Como Programar en
 * Java 7ed Deitel*
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_26 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Variables
        int i;
        
        // Variable de control para salir del bucle
        boolean control = true;

        // Iteración con condición doble
        for (i = 1; i <= 10 && control; i++ )
        {
            // Comparación para salir del bucle
            if ( 5 == i )  
            {
                // Cambiando la variable de control de valor
                control = false;
            }
        }

        // Muestra de resultados al usuario
        Mensajes.mostrarMensaje("Se ha salido de la bucle en la iteración " + 
                (i -1), Mensajes.TipoMensaje.INFORMACION);
    }   
}
