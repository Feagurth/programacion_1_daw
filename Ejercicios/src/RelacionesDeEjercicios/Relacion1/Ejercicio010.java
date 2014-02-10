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
package RelacionesDeEjercicios.Relacion1;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Implementa tres funciones que permitan averiguar los valores de eX, cos(x) y
 * sen(x)
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio010 {

    /**
     * Función para calcular el factorial de un número
     *
     * @param valor Numero del que se quiere calcular el factorial
     * @return Valor del factorial
     */
    private BigDecimal Factorial(int valor) {

        // Inicializamos la variable
        BigDecimal resultado = BigDecimal.ONE;       

        // Ireramos multiplicando el resultado por el valor anterior
        for (int i = valor; i > 1; i--) {
            resultado = resultado.multiply(BigDecimal.valueOf(i));
        }

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Función para calcular el valor de e^x usando series
     *
     * @param valor Valor del exponente de e
     * @return Resultado de e^ valor
     */
    private double CalcularEx(double valor, int iteraciones) {
        // Variables        
        double resultado = 0;

        // Iteramos desde el segundo dígito hasta el valor del número
        // dividiendo por el factorial del valor de la iteración el 
        // número elevado al valor de la iteración
        for (int i = 2; i <= iteraciones; i++) {
            resultado += Math.pow(valor, i) / Factorial(i).floatValue();
        }

        // Añadimos 1 + el valor del número
        resultado += 1 + valor;

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Función para calcular el coseno mediante series
     *
     * @param valor Valor al que calcular el coseno
     * @return Coseno del valor
     */
    private double CalcularCoseno(double valor, int iteraciones) {
        // Variables
        double resultado = 1;

        // Iteramos desde el 1 hasta el valor de las iteraciones
        for (int i = 1; i <= iteraciones; i++) {
            // Si la iteración es par, sumamos, si no, restamos
            if (i % 2 == 0) {
                resultado += (Math.pow(valor, (2 * i))
                        / Factorial(2 * i).doubleValue());
            } else {
                resultado -= (Math.pow(valor, (2 * i))
                        / Factorial(2 * i).doubleValue());
            }
        }

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Función para calcular el seno mediante series
     *
     * @param valor Valor al que calcular el seno
     * @return Seno del valor
     */
    private double CalcularSeno(double valor, int iteraciones) {
        // Variables
        double resultado = (float) valor;

        // Iteramos desde 1 hasta el valor de las iteraciones
        for (int i = 1; i <= iteraciones; i++) {

            // Si la iteración es par sumamos, si es impar, restamos
            if (i % 2 == 0) {
                resultado += Math.pow(valor, ((2 * i) + 1))
                        / Factorial((2 * i) + 1).doubleValue();
            } else {
                resultado -= Math.pow(valor, ((2 * i) + 1))
                        / Factorial((2 * i) + 1).doubleValue();
            }
        }

        // Devolvemos el resultado
        return resultado;
    }

    public void Ejercicio() {

        // Objeto leer datos del teclado
        Scanner scanner = new Scanner(System.in);

        // Variables
        Double numero;
        int iterac;

        // Pedimos el número de iteraciones que van a la realizar los algoritmos
        // para acercarnos al resultado
        System.out.print("Introduzca el número de iteraciones para "
                + "calcular los valores: ");
        iterac = scanner.nextInt();

        // Pedimos al usuario el valor del exponente
        System.out.print("Introduzca el valor para el exponente de e^x: ");
        numero = scanner.nextDouble();

        // Mostramos resultados
        System.out.print("<H>e^" + numero + ": " + CalcularEx(numero, iterac));
        System.out.print("\n<C>e^" + numero + ": " + Math.pow(Math.E, numero));

        // Pedimos al usuario el angulo para calcular el seno
        System.out.print("\nIntroduzca el valor del angulo en grados para calcular "
                + "sen(x): ");
        numero = Math.toRadians(scanner.nextDouble());

        // Mostramos el resultado
        System.out.print("<H>Sen(" + numero + "): " + CalcularSeno(numero, iterac));
        System.out.print("\n<C>Sen(" + numero + "): " + Math.sin(numero));

        // Pedimos al usuario el angulo para calcular el coseno
        System.out.print("\nIntroduzca el valor del angulo en grados para calcular "
                + "cos(x): ");
        numero = Math.toRadians(scanner.nextDouble());

        // Mostramos el resultado
        System.out.print("<H>Cos(" + numero + "): " + CalcularCoseno(numero, iterac));
        System.out.print("\n<C>Cos(" + numero + "): " + Math.cos(numero));
    }
}
