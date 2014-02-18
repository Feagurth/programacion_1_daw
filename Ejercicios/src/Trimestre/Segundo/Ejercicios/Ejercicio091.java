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
 * Determinar si una matriz de tres filas y tres columnas es un cuadrado mágico.
 * Se considera un cuadrado mágico aquel en el cual las filas, columnas, y las
 * diagonales principal y secundaria suman lo mismo.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio091 {

    public void Ejercicio() {
        // Objeto para pedir datos al usuario por el teclado
        Scanner entrada = new Scanner(System.in);

        // Variables
        int valorLado;

        // Pedimos al usuario el tamaño del lado de la matriz
        do {
            System.out.print("Introduzca el valor del lado de la matriz: ");
            valorLado = entrada.nextInt();
        } while (valorLado <= 0);

        // Creamos la matriz
        int[][] matriz = new int[valorLado][valorLado];

        // Pedimos al usuario que rellene la matriz
        for (int i = 0; i < valorLado; i++) {
            for (int j = 0; j < valorLado; j++) {
                System.out.print("Introduzca el valor de la posición "
                        + "[" + i + "," + j + "]: ");
                matriz[i][j] = entrada.nextInt();
            }
        }

        // Pasamos la matriz a la función de verificación y mostramos el 
        // resultado
        if (esCuadradoMagico(matriz)) {
            System.out.println("La matriz introducida es un cuadrado mágico");
        } else {
            System.out.println("La matriz introducida no es un cuadrado mágico");
        }

    }

    /**
     * Función que nos permite verificar si una matriz es un cuadrado mágico
     *
     * @param matriz Matriz a comprobar
     * @return Resultado de la comprobación
     */
    private boolean esCuadradoMagico(int[][] matriz) {

        // Variables
        int suma;
        int apoyo = 0;

        // Calculamos el valor de la primera fila de de la matriz
        // que usaremos para como valor de verificación para comprobar
        // si la matriz es un cuadrado mágico
        for (int[] matriz1 : matriz) {
            apoyo += matriz1[0];
        }

        // Recorremos las columnas de la matriz sumando sus resultados        
        for (int[] matriz1 : matriz) {

            // Reseteamos el acumulador de sumas
            suma = 0;

            for (int j = 0; j < matriz.length; j++) {
                suma += matriz1[j];
            }

            // Verificamos si el valor es distinto al de apoyo
            if (suma != apoyo) {
                return false;
            }
        }

        // Recorremos las filas de la matriz sumando sus resultados
        for (int i = 0; i < matriz.length; i++) {

            // Reseteamos el acumulador de sumas
            suma = 0;

            for (int[] matriz1 : matriz) {
                suma += matriz1[i];
            }

            // Verificamos si el valor es distinto al de apoyo
            if (suma != apoyo) {
                return false;
            }
        }

        // Reseteamos el acumulador de sumas
        suma = 0;

        // Recorremos la diagonal [0,0] a [N,N]
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz.length; j++) {

                if (i == j) {
                    suma += matriz[i][j];
                }
            }
        }

        // Verificamos si el valor es distinto al de apoyo
        if (suma != apoyo) {
            return false;
        }

        // Reseteamos el acumulador de sumas
        suma = 0;

        // Recorremos la diagonal [N,N] a [0,0]
        for (int i = matriz.length - 1; i >= 0; i--) {

            for (int j = matriz.length - 1; j >= 0; j--) {

                if (i == j) {
                    suma += matriz[i][j];
                }
            }
        }

        // Retornamos el resultado
        return suma == apoyo;
    }
}
