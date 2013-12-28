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

package Trimestre.Primero.Ejercicios.LibroPdf;

/**
 * Clase para encontrar el número mayor en un array
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_21 {
    
    private final int[] numeros;
    private int numeroMayor;

    /**
     * Devuelve el número mayor del array
     * @return El número mayor del array
     */
    public int getNumeroMayor() {
        return numeroMayor;
    }
    
    /**
     * Constructor de la clase
     * @param numeros array con los valores a comparar
     */
    public Ejercicio4_21(int[] numeros) {
        this.numeros = numeros;
        
        // Inicializamos con el primer valor del array
        numeroMayor = numeros[0];
        
        // Iteramos la longitud del array
        for (int i = 0; i < numeros.length; i++) {

            // Comparamos con el resto de valores y cambiamos el valor de la 
            // variable si esta es menor que el numero actual
            if(numeroMayor < numeros[i])
                numeroMayor = numeros[i];
        }
    }    
}
