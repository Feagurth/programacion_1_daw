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
 * Leer una serie de números enteros positivos distintos de 0 (el último de la 
 * serie debe ser el -99) obtener el número mayor.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio018 {
    
    /**
    * Ejercicio principal
    */
    public void ejercicio()
    {
        // Variables de controls
        int numero, mayor = 0;
        boolean salir = false;

        
        // Iteramos mientras no se cumpla la condición de salida
        do {            
            
            // Petición de datos al usuario
            numero = Integer.parseInt(Mensajes.pedirDatos("Introduzca un número (-99 para salir)"
                    , "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));

            // Si el número introducido es mayor que cero
            if (numero > 0) 
            {
                // Si el numero introducido es mayor que el número mayor actual
                // el número se convierte en el nuevo mayor
                if (mayor < numero) {
                    mayor = numero;                    
                }
            }
            
            // Comprobamos si el numero introducido es el de la condición de
            // salida
            if(numero == -99)
            {
                // De ser así cambiamos el valor del centinela
                salir = true;
            }
        } while (!salir);

        // Mostramos resultados al usuario
        Mensajes.mostrarMensaje("De los números introducidos el mayor es: " + mayor, 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    
    }
    
}
