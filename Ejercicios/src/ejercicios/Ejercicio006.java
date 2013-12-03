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
 * Diseñar un algoritmo para determinar si un número n es primo. 
 * (Un número primo sólo es divisible por el mismo y por la unidad).
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio006 {
    
    /**
    * Ejercicio principal
    */
    public void ejercicio()
    {
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();

        // Variables
        int numero, contador = 2;

        numero = Integer.parseInt(msg.PedirDatos("Introduzca un número para saber si es primo", 
                "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));
        

        // Iteramos por todos los números desde el 2 hasta el mismo número
        // comprobando si el modulo del número y el contador es distinto de 0
        while((numero % contador) != 0) 
        {            
            contador++;
        }
        
        // Si al encontrarse un valor por el cual el número modulo el valor es 0
        // verificamos que el número es mayor que el contador es primo, si no 
        // es así, no lo es
        if (contador < numero) 
        {
            msg.MostrarMensaje(numero + " no es primo", 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);
        }
        else
        {
            msg.MostrarMensaje(numero + " es primo", 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);
        }        
    }
    
}
