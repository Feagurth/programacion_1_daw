/*
 * Copyright (C) 2014 Luis Cabrerizo Gómez
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
package RelacionesDeEjercicios.Relacion3;

import Utiles.PeticionDatos;
import java.util.Scanner;

/**
 * Visualizar la matriz traspuesta de una matriz M de 6 x 7 elementos
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio004 {

    /**
     * Método que nos permite crear una matriz y rellenarla con datos
     *
     * @param ancho Ancho de la matriz
     * @param alto Alto de la matriz
     * @return Matriz con valores
     */
    private int[][] crearMatriz(int ancho, int alto) {
        // Creamos una matriz para almacenar los datos
        int[][] matrizInicial = new int[alto][ancho];

        // Pedimos datos al usuario
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                matrizInicial[i][j] = PeticionDatos.pedirEntero("Introduce el "
                        + "valor para la posición [" + i + "," + j + "]");
            }
        }

        // Devolvemos la matriz con los datos introducidos
        return matrizInicial;
    }

    /**
     * Método que nos permite transponer una matriz
     *
     * @param matriz Matriz a transponer
     * @return Matriz transpuesta
     */
    private int[][] transponerMatriz(int[][] matriz) {
        // Creamos una nueva matriz para almacenar el resultado cuya altura
        // será del tamaño del ancho de la matriz original y la anchura
        // corresponderá a la altura de la matriz original
        int[][] matrizFinal = new int[matriz[1].length][matriz.length];

        // Iteramos por la matriz inicial
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[1].length; j++) {

                // El valor de la matriz final será
                // el valor traspuesto de la matriz inicial
                // esto es, el que esta cambiando los valores 
                // de x e y
                matrizFinal[j][i] = matriz[i][j];
            }
        }

        // Devolvemos la matriz transpuesta
        return matrizFinal;

    }

    /**
     * Método que nos permite mostrar una matriz
     *
     * @param matriz Matriz a mostrar
     */
    private void mostrarMatriz(int[][] matriz) {
        for (int[] matriz1 : matriz) {
            for (int j = 0; j < matriz[1].length; j++) {
                System.out.printf("\t" + matriz1[j]);
            }
            System.out.println("");
        }

    }

    public void Ejercicio() {
        // Objeto para pedir datos al usuario desde el teclado
        Scanner entrada = new Scanner(System.in);

        // Variables
        int tamanyoX, tamanyoY;

        // Pedimos datos al usuario
        tamanyoX = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el ancho de la matriz");

        tamanyoY = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el alto de la matriz");

        // Creamos una matriz para almacenar los datos
        int[][] matrizInicial = crearMatriz(tamanyoX, tamanyoY);

        // Creamos una nueva matriz para almacenar el resultado de la 
        // transposición
        int[][] matrizFinal;

        // Realizamos la transposición
        matrizFinal = transponerMatriz(matrizInicial);

        // Pintamos la matriz inicial
        System.out.println("Matriz Inicial");

        mostrarMatriz(matrizInicial);

        // Pintamos la matriz final
        System.out.println("Matriz Final");

        mostrarMatriz(matrizFinal);

    }
}
