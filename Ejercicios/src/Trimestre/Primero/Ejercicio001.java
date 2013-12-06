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

package Trimestre.Primero;

import ejercicios.Mensajes;

/**
 * Escribir un algoritmo para determinar el máximo común divisor usando el 
 * algoritmo de Euclides
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio001 
{
    /**
    * Ejercicio principal
    */
    public void ejercicio()
    {
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();
        
        // Variables
        int valor1, valor2, resto;
        
        // Petición de datos al usuario
        valor1 = Integer.parseInt(msg.PedirDatos("Introduzca el valor1", 
                "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));
        
        valor2 = Integer.parseInt(msg.PedirDatos("Introduzca el valor2", 
                "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));
        
        // Mientras que el modulo de los dos valores sea distinto de cero
        // seguimos iterando
        while (valor1 % valor2 != 0) 
        {            
            // Calculamos el resto de la división de los dos números
            resto = valor1 % valor2;
            
            // El valor del divisor pasa a ser el del dividendo
            valor1 = valor2;
            // El resto pasa a ser el valor divisor
            valor2 = resto;
        }
        
        // Muestra de resultados al usuario
        msg.MostrarMensaje("El maximo común divisor es: " + valor1, 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
     }
}
