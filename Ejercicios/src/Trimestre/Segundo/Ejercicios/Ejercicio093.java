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

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * Diseñar una función con la que dadas dos matrices pasadas como parámetros,
 * comprobar si son idénticas
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio093 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables
        int valorX, valorY;

        // Petición de datos al usuario
        // Petición de datos usando una clase auxiliar
        valorX = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca la "
                + "altura de las matrices");

        valorY = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca la "
                + "anchura de las matrices");

        // Creamos las matrices nesarias
        // Dos para recoger los datos del usuario
        int[][] matriz1 = crearMatriz(valorX, valorY, "Primera matriz");
        
        int[][] matriz2 = crearMatriz(valorX, valorY, "Segunda matriz");

        // Comparamos las matrices y mostramos el resultado
        if (matricesIguales(matriz1, matriz2)) {
            Mensajes.mostrarMensaje("Las matrices son iguales", 
                    Mensajes.TipoMensaje.INFORMACION);
        } else {
            Mensajes.mostrarMensaje("Las matrices no son iguales", 
                    Mensajes.TipoMensaje.INFORMACION);

        }
    }

    /**
     * Método que nos permite crear una matriz y rellenarla con datos
     *
     * @param ancho Ancho de la matriz
     * @param alto Alto de la matriz
     * @return Matriz con valores
     */
    private int[][] crearMatriz(int ancho, int alto, String mensaje) {
        // Creamos una matriz para almacenar los datos
        int[][] matrizInicial = new int[alto][ancho];

        // Pedimos datos al usuario
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                matrizInicial[i][j] = PeticionDatos.pedirEntero(mensaje + 
                        "\nIntroduce el valor para la posición "
                        + "[" + i + "," + j + "]");
            }
        }

        // Devolvemos la matriz con los datos introducidos
        return matrizInicial;
    }        
    
    /**
     * Función que nos permite comparar dos matrices para ver si son iguales
     *
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
