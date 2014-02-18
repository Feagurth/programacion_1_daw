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

import java.util.Scanner;

/**
 * Diseñar una función con la que dadas dos matrices pasadas como parámetros,
 * comprobar si son idénticas
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio007 {

    public void Ejercicio() {
        // Objeto para pedir datos al usuario desde el teclado
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
        // Dos para recoger los datos del usuario
        int[][] matriz1 = new int[valorX][valorY];
        int[][] matriz2 = new int[valorX][valorY];

        // Volvemos a pedir datos al usuario
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                System.out.print("Introduzca el valor para "
                        + "[" + i + "," + j + "] para la primera matriz: ");
                matriz1[i][j] = entrada.nextInt();
            }
        }

        System.out.println("");

        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[0].length; j++) {
                System.out.print("Introduzca el valor para "
                        + "[" + i + "," + j + "] para la segunda matriz: ");
                matriz2[i][j] = entrada.nextInt();
            }
        }

        // Comparamos las matrices y mostramos el resultado
        if (matricesIguales(matriz1, matriz2)) {
            System.out.println("Las matrices son iguales");
        } else {
            System.out.println("Las matrices no son iguales");
        }
    }

    /**
     * Función que nos permite comparar dos matrices para ver si son iguales
     * @param matriz1 Primera matriz a comparar
     * @param matriz2 Segunda matriz a comparar
     * @return Resultado de la comparación
     */
    private boolean matricesIguales(int[][] matriz1, int[][] matriz2) {

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                if (matriz1[i][j] != matriz2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
