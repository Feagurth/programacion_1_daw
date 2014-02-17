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
 * Visualizar la matriz traspuesta de una matriz M de 6 x 7 elementos
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio092 {

    public void Ejercicio() {
        // Objeto para pedir datos al usuario desde el teclado
        Scanner entrada = new Scanner(System.in);

        // Variables
        int tamanyoX, tamanyoY;

        // Pedimos datos al usuario
        do {
            System.out.print("Introduzca el ancho de la matriz: ");
            tamanyoX = entrada.nextInt();
        } while (tamanyoX <= 0);

        do {
            System.out.print("Introduzca el alto de la matriz: ");
            tamanyoY = entrada.nextInt();
        } while (tamanyoY <= 0);

        // Creamos una matriz para almacenar los datos
        int[][] matrizInicial = new int[tamanyoY][tamanyoX];

        // Pedimos datos al usuario
        for (int i = 0; i < tamanyoY; i++) {
            for (int j = 0; j < tamanyoX; j++) {
                System.out.print("Introduce el valor para la posición "
                        + "[" + i + "," + j + "]: ");
                matrizInicial[i][j] = entrada.nextInt();
            }
        }

        // Creamos una nueva matriz para almacenar el resultado cuya altura
        // será del tamaño del ancho de la matriz original y la anchura
        // corresponderá a la altura de la matriz original
        int[][] matrizFinal = new int[tamanyoX][tamanyoY];

        // Iteramos por la matriz inicial
        for (int i = 0; i < tamanyoY; i++) {
            for (int j = 0; j < tamanyoX; j++) {
                
                // El valor de la matriz final será
                // el valor traspuesto de la matriz inicial
                // esto es, el que esta cambiando los valores 
                // de x e y
                matrizFinal[j][i] = matrizInicial[i][j];
            }
        }

        // Pintamos la matriz inicial
        System.out.println("Matriz Inicial"); 
                
        // Iteramos y mostramos los resultados
        for (int i = 0; i < tamanyoY; i++) {
            for (int j = 0; j < tamanyoX; j++) {                
                System.out.print("\t" + matrizInicial[i][j]);
            }
            System.out.println("");
        }

        // Pintamos la matriz final
        System.out.println("Matriz Final"); 
        
        // Iteramos y mostramos los resultados
        for (int i = 0; i < tamanyoX; i++) {
            for (int j = 0; j < tamanyoY; j++) {                
                System.out.printf("\t" + matrizFinal[i][j]);
            }
            System.out.println("");
        }
    }
}
