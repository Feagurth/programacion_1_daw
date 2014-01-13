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

/**
 * Clase para realizar el ejercicio 4.38 del libro de texto Como Programar en
 * Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_38 {

    /**
     * Ejercicio principal
     */
    public void Ejercicio() {
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();

        // Variables
        int m, x;
        float resultado, resultadoPotencia;

        do {
            // Petición de datos al usuario
            m = Integer.parseInt(msg.PedirDatos("Introduzca el numero de "
                    + "iteraciones","Petición de datos", 
                    Mensajes.TipoMensaje.PREGUNTA));

            x = Integer.parseInt(msg.PedirDatos("Introduzca el valor de "
                    + "la potencia","Petición de datos", 
                    Mensajes.TipoMensaje.PREGUNTA));


            // Verificación de que los datos introducidos sean correctos
            if (m > 0 && x > 0) {
                // Se calcula el resultado y se muestra al usuario
                resultado = calculoE(m);
                
                resultadoPotencia = calculoEPowX(m, x);

                msg.MostrarMensaje("El resultado es " + resultado,
                        "Resultado", Mensajes.TipoMensaje.INFORMACION);

                msg.MostrarMensaje("El resultado de la potencia es " + resultadoPotencia,
                        "Resultado", Mensajes.TipoMensaje.INFORMACION);
                

            } else {
                msg.MostrarMensaje("Los valores introducidos no eran correcto",
                        "Atención", Mensajes.TipoMensaje.ERROR);
            }
        } while (m < 0 || x < 0);
    }

    /**
     * Función para calcular la potencia de e elevado a x
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
