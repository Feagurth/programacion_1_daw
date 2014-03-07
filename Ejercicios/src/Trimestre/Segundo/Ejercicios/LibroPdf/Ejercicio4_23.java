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

import Utiles.PeticionDatos;

/**
 * Clase para realizar el ejercicio 4.23 del libro de texto Como Programar en
 * Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_23 {

    int numMayor1, numMayor2;

    public void Ejercicio() {
        // Variable para almacenar la cantidad de números a comparar
        int tamanyoArray;

        // Array para almacenar los números a comparar
        int[] numeros;

        // Pedimos datos al usuario
        tamanyoArray = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca la cantidad de números a comparar");

        numeros = new int[tamanyoArray];

        // Pedimos los valores necesarios al usuario
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = PeticionDatos.pedirEntero("Introduzca el valor para el dígito número " + (i + 1));
        }

        // Ejecutamos el procedimiento para encontrar los numeros
        encontrar2Mayores(numeros);

        // Mostramos resultados
        System.out.println("Los numeros mayores son: " + numMayor1 + " y " + numMayor2);
    }

    /**
     * Función que permite encontrar los dos números mayores en una array
     * @param numeros Array con los números
     */
    private void encontrar2Mayores(int[] numeros) {
        // Inicializamos las variables que contendrán los valores
        numMayor1 = 0;
        numMayor2 = 0;

        // Iteramos el array para encontrar el valor más alto
        for (int j = 0; j < numeros.length; j++) {
            if (numMayor1 < numeros[j]) {
                numMayor1 = numeros[j];
            }
        }
        
        // Iteramos de nuevo para encontrar el valor más alto distinto del anterior
        for (int j = 0; j < numeros.length; j++) {
            if ((numMayor2 < numeros[j]) && (numeros[j] != numMayor1)) {
                numMayor2 = numeros[j];
            }
        }
    }
}
