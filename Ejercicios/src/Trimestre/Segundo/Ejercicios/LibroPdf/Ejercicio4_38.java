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
 * Clase para realizar el ejercicio 4.38 del libro de texto Como Programar en
 * Java 7ed Deitel
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_38 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables
        int m, x;
        float resultado, resultadoPotencia;
        String salida;

        // Petición de datos al usuario
        m = PeticionDatos.pedirEntero("Introduzca el numero de iteraciones");

        x = PeticionDatos.pedirEntero("Introduzca el valor de la potencia");

        // Se calcula el resultado
        resultado = calculoE(m);

        // Calculamos el resultaod de la potencia de e
        resultadoPotencia = calculoEPowX(m, x);

        // Preparamos la cadena de salida
        salida = "El resultado es " + resultado;
        salida += "\nEl resultado de la potencia es " + resultadoPotencia;

        // Mostramos la información al usuario
        Mensajes.mostrarMensaje(salida, Mensajes.TipoMensaje.INFORMACION);

    }

    /**
     * Función para calcular la potencia de e elevado a x
     *
     * @param iteraciones Numero de iteraciones para calcular la aproximación
     * @param valorPotencia Valor de la potencia
     * @return Resultado aproximado
     */
    private float calculoEPowX(int iteraciones, int valorPotencia) {
        float resultado = 0f;

        // Iteramos tantas veces como sea preciso
        for (int i = 0; i < iteraciones; i++) {

            // Si la iteración es la primera el valor es 1
            if (i == 0) {
                resultado += 1;
            } else {
                // Para el resto es igual a 1/ factorial de la iteración
                resultado += Math.pow(valorPotencia, i) / Factorial(i);
            }
        }

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Función para calcular la aproximación del número e
     *
     * @param iteraciones Cantidad de iteraciones para calcular el valor de e
     * @return valor aproximado de e
     */
    private float calculoE(int iteraciones) {
        float resultado = 0f;

        // Iteramos tantas veces como sea preciso
        for (int i = 0; i < iteraciones; i++) {

            // Si la iteración es la primera el valor es 1
            if (i == 0) {
                resultado += 1;
            } else {
                // Para el resto es igual a 1/ factorial de la iteración
                resultado += 1 / Factorial(i);
            }
        }

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Función para calcular el factorial de un número
     *
     * @param numero valor al que calcular el factorial
     * @return Devuelve el resultado de la factorización de número
     */
    private double Factorial(int numero) {
        // Iniciamos la variable que devolverá el resultado
        int resultado = 1;

        // Iteramos desde el número inicial hasta llegar a 1
        for (int i = numero; i > 1; i--) {
            // Multiplicamos el resultado anterior por el valor del contador
            // del bucle
            resultado = resultado * i;
        }

        return resultado;
    }
}
