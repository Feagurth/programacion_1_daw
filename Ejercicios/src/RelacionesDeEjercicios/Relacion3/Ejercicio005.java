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
 * Un procedimiento que obtenga la matriz suma de dos matrices.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio005 {

    
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
     * Método para mostrar el resultado de las una de dos matrices
     * @param matrizSumando1 Primer sumando de la suma de matrices
     * @param matrizSumando2 Segundo sumando de la suma de matrices
     * @param resultado  Resultado de la suma de matrices
     */
    private void mostrarResultadoSuma(int[][] matrizSumando1, 
            int[][]matrizSumando2, int[][] resultado)
    {
        // Iteramos primero por la altura de la matriz
        for (int i = 0; i < matrizSumando1.length; i++) {

            // Iteramos ahora la primera matriz mostrando sus valores
            for (int j = 0; j < matrizSumando1[0].length; j++) {
                System.out.print("\t" + matrizSumando1[i][j]);
            }

            // Calculamos si estamos a la mitad de la altura de las matrices
            // para colocar el simbolo de sumar, si no simplemente ponemos
            // las tabulaciones
            if (i == Math.round(matrizSumando1.length / 2)) {
                System.out.print("\t + \t");
            } else {
                System.out.print("\t\t");
            }

            // Iteramos ahora la segunda matriz mostrando sus valores
            for (int j = 0; j < matrizSumando2[0].length; j++) {
                System.out.print("\t" + matrizSumando2[i][j]);
            }

            // Calculamos si estamos a la mitad de la altura de las matrices
            // para colocar el simbolo igual, si no simplemente ponemos
            // las tabulaciones
            if (i == Math.round(matrizSumando2.length / 2)) {
                System.out.print("\t = \t");
            } else {
                System.out.print("\t\t");
            }

            // Iteramos finalmente la matriz resultado mostrando sus valores
            for (int j = 0; j < resultado[0].length; j++) {
                System.out.print("\t" + resultado[i][j]);
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
        
    public void Ejercicio() {

        // Objeto para pedir datos al usuario por teclado
        Scanner entrada = new Scanner(System.in);

        // Variables
        int valorX, valorY;

        // Pedimos datos al usuario
        valorX = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el ancho de la matriz");

        valorY = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el alto de la matriz");

        // Creamos las matrices nesarias
        // Dos para recoger los datos del usuario y otra
        // para almacenar el resultado de la suma
        
        System.out.println("Primera matriz");
        int[][] matrizSuma1 = crearMatriz(valorX, valorY);
        
        System.out.println("Segunda matriz");
        int[][] matrizSuma2 = crearMatriz(valorX, valorY);
        int[][] matrizResultado;

        // Realizamos la suma de matrices
        matrizResultado = sumaMatrices(matrizSuma1, matrizSuma2);

        // Mostramos resultados
        System.out.println("Resultado de la operación");

        mostrarResultadoSuma(matrizSuma1, matrizSuma2, matrizResultado);

    }    
}
