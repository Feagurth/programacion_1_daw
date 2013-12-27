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
 * Escribir un algoritmo que lea un número y deduzca si está entre 10 y 100, 
 * ambos inclusive.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio039 {
   
    public void ejercicio(){
    
        // Objeto para la petición y muestra de datos al usuario
        Mensajes msg = new Mensajes();
        
        // Variables
        int numero;
        
        // Petición de datos al usuario
        numero = Integer.parseInt(msg.PedirDatos("Introduzca un número", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        
        // Hacemos la comparación y mostramos resultados
        if(numero >= 10 && numero <= 100)
        {
            msg.MostrarMensaje(numero + " está comprendido entre 10 y 100", 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);
        }
        else
        {
            msg.MostrarMensaje(numero + " no está comprendido entre 10 y 100", 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);        
        }        
    }
}
