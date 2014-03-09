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

import Utiles.Mensajes;
import Utiles.PeticionDatos;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Implementa tres funciones que permitan averiguar los valores de e^(x), cos(x)
 * y sen(x)
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio010 {

    /**
     * Función para calcular el factorial de un número
     *
     * @param valor número del que se quiere calcular el factorial
     * @return Valor del factorial
     */
    private BigInteger Factorial(double valor) {

        // Creamos un objeto BigInteger para generar el factorial
        // debido a su mayor precisión respecto a tipos primitivos
        BigInteger resultado = BigInteger.ONE;

        // Comprobamos que no queremos calcular el factorial de 0
        if (valor != 0) {

            // Iteramos desde 1 hasta el valor a calcular
            for (int i = 1; i <= valor; i++) {
                // Multiplicamos el valor actual por el acumulado de las 
                // multiplicaciones de los anteriores terminos
                resultado = resultado.multiply(BigInteger.valueOf(i));
            }
        }
        return resultado;
    }

    /**
     * Función para calcular el valor de e^x usando series
     *
     * @param valor Valor del exponente de e
     * @return Resultado de e^ valor
     */
    private BigDecimal CalcularEx(double valor, int iteraciones, int precision) {

        // Variables para contener los diversos valores intermedios 
        // de las operaciones
        BigDecimal resultado = BigDecimal.ZERO;
        BigDecimal apoyo;

        // Transformamos el valor a calcular en un objeto BigDecimal
        BigDecimal tempValor = BigDecimal.valueOf(valor);

        // Iteramos tantas veces como se nos haya especificado
        for (int i = 0; i < iteraciones; i++) {
            apoyo = tempValor.pow(i).divide(new BigDecimal(Factorial(i)),
                    precision, BigDecimal.ROUND_HALF_UP);

            // Sumamos el valor al resultado
            resultado = resultado.add(apoyo);
        }

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Función para calcular el coseno mediante series de Taylor
     *
     * @param valor Valor al que calcular el coseno
     * @return Coseno del valor
     */
    private BigDecimal CalcularCoseno(double valor, int iteraciones, int precision) {
                // Variables
        int signo = -1;
        BigDecimal resultado = BigDecimal.ONE;
        BigDecimal apoyo;

        // Transformamos el valor a calcular en un objeto BigDecimal
        BigDecimal tempValor = BigDecimal.valueOf(valor);

        // Iteramos tantas veces como sea necesario
        for (int i = 1; i < iteraciones; i++) {

            // Realizamos las operaciones
            apoyo = tempValor.pow(((2 * i)));
            apoyo = apoyo.divide(new BigDecimal(Factorial(((2 * i)))),
                    precision, BigDecimal.ROUND_HALF_DOWN);

            apoyo = apoyo.multiply(BigDecimal.valueOf(signo));

            resultado = resultado.add(apoyo);

            // Cambiamos el valor del signo para la siguiente operación
            signo *= -1;
        }

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Función para calcular el seno mediante series de Taylor
     *
     * @param valor Valor al que calcular el seno
     * @return Seno del valor
     */
    private BigDecimal CalcularSeno(double valor, int iteraciones, int precision) {
        // Variables
        int signo = -1;
        BigDecimal resultado = BigDecimal.valueOf(valor);
        BigDecimal apoyo;
       
        // Transformamos el valor a calcular en un objeto BigDecimal
        BigDecimal tempValor = BigDecimal.valueOf(valor);

        // Iteramos tantas veces como sea necesario
        for (int i = 1; i < iteraciones; i++) {

            // Realizamos las operaciones
            apoyo = tempValor.pow(((2 * i) + 1));
            apoyo = apoyo.divide(new BigDecimal(Factorial(((2 * i) + 1))),
                    precision, BigDecimal.ROUND_HALF_DOWN);

            apoyo = apoyo.multiply(BigDecimal.valueOf(signo));

            resultado = resultado.add(apoyo);

            // Cambiamos el valor del signo para la siguiente operación
            signo *= -1;
        }

        // Devolvemos el resultado
        return resultado;
    }

    public void Ejercicio() {

        // Variables
        Double numero;
        int iterac;
        
        // Pedimos el número de iteraciones que van a la realizar los algoritmos
        // para acercarnos al resultado
        iterac = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el número "
                + "de iteraciones para calcular los valores");

        // Pedimos al usuario el valor del exponente
        numero = PeticionDatos.pedirReal("Introduzca el valor para el exponente "
                + "de e^x");
        
        // Mostramos resultados
        Mensajes.MostrarMensaje("e^" + numero + ": " + 
                CalcularEx(numero, iterac, 30).doubleValue(), 
                Mensajes.TipoMensaje.INFORMACION);
        
        // Pedimos al usuario el angulo para calcular el seno
        numero = Math.toRadians(PeticionDatos.pedirReal("\nIntroduzca el valor "
                + "del angulo en grados para calcular sen(x)"));

        // Mostramos el resultado
        Mensajes.MostrarMensaje("Sen(" + numero + "): " + 
                CalcularSeno(numero, iterac, 30).doubleValue(), 
                Mensajes.TipoMensaje.INFORMACION);

        // Pedimos al usuario el angulo para calcular el coseno
        numero = Math.toRadians(PeticionDatos.pedirReal("\nIntroduzca el valor "
                + "del angulo en grados para calcular cos(x)"));

        // Mostramos el resultado
        Mensajes.MostrarMensaje("Cos(" + numero + "): " + 
                CalcularCoseno(numero, iterac, 30).doubleValue(), 
                Mensajes.TipoMensaje.INFORMACION);
    }
}
