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
package Trimestre.Segundo.Ejercicios;

import java.util.Scanner;

/**
 * Un procedimiento que obtenga la matriz suma de dos matrices.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio094 {

    public void Ejercicio() {

        // Objeto para pedir datos al usuario por teclado
        Scanner entrada = new Scanner(System.in);

        // Variables
        int valorX, valorY;

        // Petición de datos al usuario
        do {
            System.out.print("Introduzca la altura de las matrices: ");
            valorX = entrada.nextInt();
        } while (valorX <= 0);

        do {
            System.out.print("Introduzca la anchura de las matrices: ");
            valorY = entrada.nextInt();
        } while (valorY <= 0);

        // Creamos las matrices nesarias
        // Dos para recoger los datos del usuario y otra
        // para almacenar el resultado de la suma
        int[][] matrizSuma1 = new int[valorX][valorY];
        int[][] matrizSuma2 = new int[valorX][valorY];
        int[][] matrizResultado;

        // Volvemos a pedir datos al usuario
        for (int i = 0; i < matrizSuma1.length; i++) {
            for (int j = 0; j < matrizSuma1[0].length; j++) {
                System.out.print("Introduzca el valor para "
                        + "[" + i + "," + j + "] para la primera matriz: ");
                matrizSuma1[i][j] = entrada.nextInt();
            }
        }

        System.out.println("");

        for (int i = 0; i < matrizSuma2.length; i++) {
            for (int j = 0; j < matrizSuma2[0].length; j++) {
                System.out.print("Introduzca el valor para "
                        + "[" + i + "," + j + "] para la segunda matriz: ");
                matrizSuma2[i][j] = entrada.nextInt();
            }
        }

        // Realizamos la suma de matrices
        matrizResultado = sumaMatrices(matrizSuma1, matrizSuma2);

        // Mostramos resultados
        System.out.println("Resultado de la operación");

        // Iteramos primero por la altura de la matriz
        for (int i = 0; i < matrizSuma1.length; i++) {

            // Iteramos ahora la primera matriz mostrando sus valores
            for (int j = 0; j < matrizSuma1[0].length; j++) {
                System.out.print("\t" + matrizSuma1[i][j]);
            }

            // Calculamos si estamos a la mitad de la altura de las matrices
            // para colocar el simbolo de sumar, si no simplemente ponemos
            // las tabulaciones
            if (i == Math.round(matrizSuma1.length / 2)) {
                System.out.print("\t + \t");
            } else {
                System.out.print("\t\t");
            }

            // Iteramos ahora la segunda matriz mostrando sus valores
            for (int j = 0; j < matrizSuma2[0].length; j++) {
                System.out.print("\t" + matrizSuma2[i][j]);
            }

            // Calculamos si estamos a la mitad de la altura de las matrices
            // para colocar el simbolo igual, si no simplemente ponemos
            // las tabulaciones
            if (i == Math.round(matrizSuma2.length / 2)) {
                System.out.print("\t = \t");
            } else {
                System.out.print("\t\t");
            }

            // Iteramos finalmente la matriz resultado mostrando sus valores
            for (int j = 0; j < matrizResultado[0].length; j++) {
                System.out.print("\t" + matrizResultado[i][j]);
            }

            // Añadimos un retorno de carro
            System.out.println("");
        }
    }

    /**
     * Función que nos permite sumar dos matrices de igual tamaño
     *
     * @param matriz1 Primer sumando
     * @param matriz2 Segundo sumando
     * @return Suma de las dos matrices
     */
    private int[][] sumaMatrices(int[][] matriz1, int[][] matriz2) {
        int[][] resultado = new int[matriz1.length][matriz1[0].length];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return resultado;
    }
}
