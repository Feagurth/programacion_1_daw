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
 * Clase para realizar el ejercicio 4.21 del libro de texto Como Programar en
 * Java 7ed Deitel
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_21 {

    /**
     * Clase para encontrar el número mayor en un array
     */
    static public class NumeroMayor {

        // Variables
        private final int[] NUMEROS;
        private int numeroMayor;

        /**
         * Devuelve el número mayor del array
         *
         * @return El número mayor del array
         */
        public int getNumeroMayor() {
            return numeroMayor;
        }

        /**
         * Constructor de la clase
         *
         * @param numeros array con los valores a comparar
         */
        public NumeroMayor(int[] numeros) {
            this.NUMEROS = numeros.clone();

            // Inicializamos con el primer valor del array
            numeroMayor = this.NUMEROS[0];

            // Iteramos la longitud del array
            for (int i = 0; i < this.NUMEROS.length; i++) {

                // Comparamos con el resto de valores y cambiamos el valor de la 
                // variable si esta es menor que el numero actual
                if (numeroMayor < this.NUMEROS[i]) {
                    numeroMayor = this.NUMEROS[i];
                }
            }
        }
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Objeto que usaremos para encontrar el número mayor
        NumeroMayor numMayor;

        // Variable para almacenar la cantidad de números a comparar
        int tamanyoArray;

        // Array para almacenar los números a comparar
        int[] numeros;

        // Pedimos datos al usuario
        tamanyoArray = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca la cantidad de números a comparar");

        numeros = new int[tamanyoArray];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = PeticionDatos.pedirEntero("Introduzca el valor para el dígito número " + (i + 1));
        }

        // Creamos el objeto con los datos introducidos
        numMayor = new NumeroMayor(numeros);

        // Mostramos el resultado
        Mensajes.mostrarMensaje("El número mayor es: "
                + numMayor.getNumeroMayor(),
                Mensajes.TipoMensaje.INFORMACION);

    }

}
