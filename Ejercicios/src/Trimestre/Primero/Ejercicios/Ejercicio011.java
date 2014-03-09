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
 * Escribir un algoritmo que calcule y escriba el cuadrado de un número.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio011 {
    
    /**
    * Ejercicio principal
    */
    public void ejercicio()
    {
        // Variables
        int numero;

        // Petición de datos al usuario
        numero = Integer.parseInt(Mensajes.pedirDatos("Introduzca un número", "Petición de datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        // Muestra de resultados al usuario
        Mensajes.mostrarMensaje("El cuadrado del número es: " + numero * numero, 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);

    }
    
}
