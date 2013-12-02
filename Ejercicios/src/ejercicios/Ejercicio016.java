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
 *  Leer un carácter y deducir si está o no comprendido entre las 
 *  letras I y M ambas inclusive
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio016 {
    
    public void ejercicio()
    {
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();
        
        // Array con las letras del alfabeto de la i a la m
        char[] vector = new char[]{'i', 'j', 'k', 'l', 'm'};
        
        // Variables de control
        char letra1;        
        boolean encontrado = false;
        int control;
        
        control = 0;
        
        // Petición de datos al usuario
        letra1 = msg.PedirDatos("Introduzca la primera letra", "Petición de datos", 
                Mensajes.TipoMensaje.PREGUNTA).charAt(control);
        
        // Iteramos por el array para comprobar si la letra introducida está
        // dentro de él
        while ((control <= 4) && (!encontrado)) {            
            
            // Letra encontrada
            if (vector[control] == letra1) {
                
                // Ponemos la variable de control a verdadero
                encontrado = true;
            }
            control++;
        }
        
        // Mostramos resultado dependiendo del valor de la variable de control
        if (encontrado) 
        {
            msg.MostrarMensaje("La letra introducida está entre i y m", 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);
        }
        else
        {
            msg.MostrarMensaje("La letra introducida no está entre i y m", 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);

        }
        
    }
}
