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

/**
 * Clase para realizar el ejercicio 4.21 del libro de texto
 * Como Programar en Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class MainEjercicio4_21 {
    
    public void Ejercicio()
    {
        // Objeto para pedir y mostrar información al usuario
        Mensajes mensaje = new Mensajes();
    
        // Objeto que usaremos para encontrar el número mayor
        Ejercicio4_21 numMayor;
        
        // Variable para almacenar la cantidad de números a comparar
        int tamanyoArray;
        
        // Array para almacenar los números a comparar
        int[] numeros;
        
        // Pedimos datos al usuario
        tamanyoArray = Integer.parseInt(mensaje.PedirDatos("Introduzca la "
                + "cantidad de números a comparar", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
                
        numeros = new int[tamanyoArray];
                
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Integer.parseInt(mensaje.PedirDatos("Introduzca el "
                    + "valor para el dígito número " + (i + 1), "Petición de Datos", 
                    Mensajes.TipoMensaje.PREGUNTA));            
        }

        // Creamos el objeto con los datos introducidos
        numMayor = new Ejercicio4_21(numeros);
        
        // Mostramos el resultado
        mensaje.MostrarMensaje("El número mayor es: " + 
                numMayor.getNumeroMayor(), "Resultado", 
                Mensajes.TipoMensaje.INFORMACION);
    }
}
