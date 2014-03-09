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
 * Clase para realizar el ejercicio 5.20 del libro de texto Como Programar en
 * Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_20 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Variables
        int iteraciones;
        float valorPi = 0;
        boolean controlSuma = true;
        
        // Pedimos al usuario el número de iteraciones para calcular el valor 
        // de pi
        iteraciones = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca la cantidad de iteraciones");
        
        
        // Iteramos desde 1 hasta el numero de iteraciones multiplicada por 2
        // con incremento de 2. Esto nos permite realizar tantas operaciones
        // como quiere el usuario, mientras que el valor de i será el de todos
        // los números impares que queramos
        for (int i = 1; i < iteraciones * 2; i += 2) {
            
            // Comprobamos si tenemos que sumar o restar
            if(controlSuma)
            {
                valorPi += (4f / i);
            }
            else
            {
                valorPi -= (4f / i);
            }
            // Preparamos la variable para que en la siguiente iteración
            // realize la operación contraria a la actual
            controlSuma = !controlSuma;
        }
        
        // Mostramos el resultado al usuario
        Mensajes.mostrarMensaje("El resultado es: " + valorPi, 
                Mensajes.TipoMensaje.INFORMACION);
    }    
}
