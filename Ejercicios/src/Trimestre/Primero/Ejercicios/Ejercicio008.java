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

package Trimestre.Primero.Ejercicios;

import Utiles.Mensajes;

/**
 * Escribir un algoritmo que lea un valor entero, lo doble, se multiplique 
 * por 25 y  * visualice el resultado
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio008 {
    
    /**
    * Ejercicio principal
    */
    public void ejercicio()
    {
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();        
        
        // Variables
        int numero;

        // Petición de datos al usuario
        numero = Integer.parseInt(msg.PedirDatos("Introduce un número", 
                "Pedir datos", Mensajes.TipoMensaje.PREGUNTA));
                
        
        // Muestra de resultados al usuario
        msg.MostrarMensaje("El resultado de doblar el número " + numero +
                " y multiplicarlo por 25 es: " + numero * 50, 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }
}
