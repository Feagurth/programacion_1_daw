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
package Trimestre.Primero.Ejercicios;

import Utiles.Mensajes;
import java.math.BigDecimal;

/**
 * Implementa tres funciones que permitan averiguar los valores de ex, cos(x) y
 * sen(x) a partir de las series siguientes:
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio063 {

    /**
     * Función para calcular el factorial de un número
     *
     * @param valor Numero del que se quiere calcular el factorial
     * @return Valor del factorial
     */
    private BigDecimal factorial(int valor) {

        // Inicializamos la variable
        BigDecimal resultado = BigDecimal.ONE;

        // Ireramos multiplicando el resultado por el valor anterior
        for (int i = valor; i > 1; i--) {
            resultado = resultado.multiply(BigDecimal.valueOf(i));
        }

        return resultado;
    }

    /**
     * Función para calcular el valor de e^x usando series
     *
     * @param valor Valor del exponente de e
     * @return Resultado de e^ valor
     */
    private float calcularEx(double valor, int iteraciones) {
        // Variables        
        float resultado = 0;

        // Iteramos desde el segundo dígito hasta el valor del número
        // dividiendo por el factorial del valor de la iteración el 
        // número elevado al valor de la iteración
        for (int i = 2; i <= iteraciones; i++) {
            resultado += Math.pow(valor, i) / factorial(i).floatValue();
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
    private float calcularCoseno(double valor, int iteraciones) {
        // Variables
        float resultado = 1;

        // Iteramos desde el 1 hasta el valor de las iteraciones
        for (int i = 1; i <= iteraciones; i++) {
            // Si la iteración es par, sumamos, si no, restamos
            if (i % 2 == 0) {
                resultado += (Math.pow(valor, (2 * i))
                        / factorial(2 * i).floatValue());
            } else {
                resultado -= (Math.pow(valor, (2 * i))
                        / factorial(2 * i).floatValue());
            }
        }

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Función para calcular el seno mediante series
     * @param valor Valor al que calcular el seno
     * @return Seno del valor
     */
    private float calcularSeno(double valor, int iteraciones) {
        // Variables
        float resultado = (float)valor;

        // Iteramos desde 1 hasta el valor de las iteraciones
        for (int i = 1; i <= iteraciones; i++) {

            // Si la iteración es par sumamos, si es impar, restamos
            if (i % 2 == 0) {
                resultado += Math.pow(valor, ((2 * i) + 1))
                        / factorial((2 * i) + 1).floatValue();
            } else {
                resultado -= Math.pow(valor, ((2 * i) + 1))
                        / factorial((2 * i) + 1).floatValue();
            }
        }
        
        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables
        Double numero;
        int iterac;
        
        // Petición de datos al usuario
        numero = Double.parseDouble(Mensajes.pedirDatos("Introduzca un número", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        iterac = Integer.parseInt(Mensajes.pedirDatos("Introduzca el número de "
                + "iteraciones para calcular los valores", "Petición de Datos", 
                Mensajes.TipoMensaje.ERROR));
    
        // Muestra de resultados al usuario
        Mensajes.mostrarMensaje("e^" + numero + ": " + 
                calcularEx(numero, iterac), 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);

        Mensajes.mostrarMensaje("Cos(" + numero + "): " + 
                calcularCoseno(numero, iterac), 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);

        Mensajes.mostrarMensaje("Sen(" + numero + "): " + 
                calcularSeno(numero, iterac), 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }
}
