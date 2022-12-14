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

package Trimestre.Segundo.Ejercicios.LibroPdf;

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * Clase para realizar el ejercicio 5.11 del libro de texto Como Programar en
 * Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_11 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Variables
        int cantidadNumeros;
        int numMayor = Integer.MIN_VALUE;
        int numero;
        
        // Pedimos la cantidad de números a introducir a el usuario
        cantidadNumeros = PeticionDatos.pedirEnteroPositivoNoCero("¿Cantidad de números a introducir?");

        // Iteramos tantas veces como sea necesario
        for (int i = 0; i < cantidadNumeros; i++) {

            // Pedimos al usuario un número nuevo
            numero = PeticionDatos.pedirEntero("Introduzca el valor del número " + (i + 1));
            
            // Comprobamos si el número es mayor que el que tenemos almacenado
            if(numMayor < numero)
            {
                // Si es así este número pasará a ser el mayor
                numMayor = numero;
            }            
        }

        // Mostramos el resultado
        Mensajes.mostrarMensaje("El mayor número introducido es el " + 
                numMayor, Mensajes.TipoMensaje.INFORMACION);
    }    
}
