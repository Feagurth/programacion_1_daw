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
 * Clase para realizar el ejercicio 4.29 del libro de texto Como Programar en
 * Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_29 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // Variable para almacenar el tamaño del cuadrado
        int tamanyoLado;

        // Variable para mostrar el resultado
        String resultado;

        // Petición de datos al usuario
        tamanyoLado = PeticionDatos.pedirEnteroRango("Introduzca un valor ente 1 y 20", 1, 20);

        // Ejecutamos la función que genera el cuadrado
        resultado = pintarCuadrado(tamanyoLado);

        // Muestra de resultado en consola
        System.out.print(resultado);        
    }

    /**
     * Función para pintar el cuadrado
     * @param lado Tamaño del lado del cuadrado
     * @return Cadena con el cuadrado formado listo para imprimir
     */
    private String pintarCuadrado(int lado) {
        StringBuilder salida = new StringBuilder();

        // Iteramos 2 veces una por cada lado del cuadrado
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {

                // Comprobamos si la iteración pertenece a la primera o 
                // la última fila
                if (i == 0 || i == lado - 1) {
                    salida.append("*");
                } else // Comprobamos si es la primera o la ultima columna
                if (j == 0 || j == lado - 1) {
                    salida.append("*");
                } else {
                    salida.append(" ");
                }
            }
            // Añadimos un retorno de carro al final de cada linea
            salida.append("\n");
        }
        // Devolvemos el resultado
        return salida.toString();
    }
}
