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
 * Sumar los 10 números introducidos por teclado.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio024 {
   
    /**
     * Ejercicio principal
     */
public void ejercicio()
    {
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();
        
        // Variables
        int numero, suma = 0, contador = 0;
        
        while (contador <= 10) {            
            contador++;

            // Petición de datos al usuario
            numero = Integer.parseInt(msg.PedirDatos("Introduzca un número", 
                    "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));
            
            // Sumamos el número introducido a la suma existente
            suma += numero;
        }
        
        // Muestra de resultados al usuario
        msg.MostrarMensaje("El resultado es: " + suma, 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }
}
