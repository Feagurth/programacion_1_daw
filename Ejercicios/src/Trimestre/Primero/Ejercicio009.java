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
 * Diseñar un algoritmo que lea cuatro variables y calcule e imprima su 
 * producto, su suma y su media aritmética
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio009 {
    
    /**
    * Ejercicio principal
    */
    public void ejercicio()
    {
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();        
        
        // Variables
        int a, b, c, d;
        String cadena;

        // Petición de datos al usuario
        a = Integer.parseInt(msg.PedirDatos("Introduzca el valor numérico para a", "Pedir datos", 
                Mensajes.TipoMensaje.PREGUNTA));
  
        b = Integer.parseInt(msg.PedirDatos("Introduzca el valor numérico para b", "Pedir datos", 
                Mensajes.TipoMensaje.PREGUNTA));
  
        c = Integer.parseInt(msg.PedirDatos("Introduzca el valor numérico para c", "Pedir datos", 
                Mensajes.TipoMensaje.PREGUNTA));
  
        d = Integer.parseInt(msg.PedirDatos("Introduzca el valor numérico para d", "Pedir datos", 
                Mensajes.TipoMensaje.PREGUNTA));
  
        // Creación de la cadena de resultados
        cadena = "El producto de las variables es: " + (a * b * c * d) + "\n";
        cadena += "La suma de las variables es: " + (a + b + c + d) + "\n";
        cadena += "Su media arimética es: " + ((a + b + c + d)/(float)4);
        
        // Muestra de resultados al usuario
        msg.MostrarMensaje(cadena, "Resultado", Mensajes.TipoMensaje.INFORMACION);
    
    }
}
