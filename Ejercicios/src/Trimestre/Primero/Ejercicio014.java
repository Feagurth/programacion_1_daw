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
 * Leer un carácter y deducir si está situado antes o después de 
 * la ‘m’ en orden alfabético
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio014 {
    
    /**
    * Ejercicio principal
    */
    public void ejercicio(){
        
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();
        
        // Array que contiene las letras del abecedario de la a la m ordenadas
        char[] vector = new char[]{
            'a','b','c','d','e','f','g','h','i','j','k','l','m'
            };
        
        // Variables
        int control = 0;
        char letra;
        boolean encontradaLetra = false;
        
        // Petición de datos al usuario
        letra = msg.PedirDatos("Introduzca la letra a localizar", "Petición de datos", 
                Mensajes.TipoMensaje.PREGUNTA).charAt(0);

        // Mientras la letra no se encuentre y no se haya recorrido todo el
        // array
        while (control <= 13 && !encontradaLetra)
        {
            // Si se localiza la letra
            if (vector[control] == letra) 
            {
                // Cambiamos el control de la variable centinela
                encontradaLetra = true;
            }
        }
        
        // Mostramos información al usuario dependiendo del resultado
        if (!encontradaLetra) {
            msg.MostrarMensaje("La letra " + letra + " va depues de la m", 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);
        }
        else
        {
            msg.MostrarMensaje("La letra " + letra + " va antes de la m", 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);            
        }
    }
}
