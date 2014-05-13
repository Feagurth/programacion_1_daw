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
package Calculadora;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase para realizar las operaciones de una calculadora científica usando
 * cadenas con las operaciones a realizar
 *
 * @author Luis Cabrerizo Gómez
 */
public class ParserCalculadora {

    /**
     * Método para analizar las operaciones a realizar y calcular el resultado
     *
     * @param cadena Cadena con las operaciones a realizar
     * @return Cadena con el resultado de las operaciones
     */
    public static String parser(String cadena) {

        // Variable para almacenar el resultado de salida
        BigDecimal numero1 = BigDecimal.ZERO;

        // Variable para controlar la precisión de las divisiones
        final int precision = 15;

        // Variables para controlar las posiciones de las operaciones buscadas
        int pos1;
        int pos2 = 0;
        int pos3 = 0;

        // Operaciones admitidas por el parseador
        // Las operaciones van ordenados por jerarquía de operaciones
        String operaciones[] = {"N", "(", ")", "!", "s", "Q", "l", "L", "S", "C", "T", "%", "*", "/", "+", "-"};

        // Eliminamos los espacios en blanco
        cadena = cadena.replace(" ", "");

        cadena = transformarNegativos(cadena);

        // Transformamos las representaciones de las las funciones a letras
        // entendibles por el parseador
        cadena = transformarFunciones(cadena);

        // Transformamos la cadena de caracteres a una lista para trabajar
        ArrayList valor = cadenaALista(cadena, operaciones);

        // Iteraremos mientras haya operaciones en la lista
        do {

            // Iteramos para cada operación del array de operaciones
            for (String operacion : operaciones) {

                // Iteramos mientras haya operaciones del tipo de la iteración
                // en la lista
                do {

                    // Comprobamos que la operación este en la lista
                    if (valor.contains(operacion)) {

                        // Si lo está realizaremos busquedas específicas para
                        // cada una de las operaciones
                        switch (operacion) {

                            case "N": {
                                // Buscamos el índice de la primera operación en la lista
                                pos1 = valor.indexOf(operacion);

                                // Igualamos la posición de corte anterior a la 
                                // posición de la operación
                                pos2 = pos1;

                                // Buscamos cualquiera que sea la siguiente operación de la lista
                                // desde el índice de la primera operación y el final de la lista
                                pos3 = pos1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), operaciones, true);

                                numero1 = new BigDecimal(valor.get(pos3).toString());
                                numero1 = numero1.multiply(new BigDecimal("-1"));
                                break;

                            }

                            // Si la operación seleccionada es un paréntesis
                            case "(": {

                                // Localizamos la posición del último paréntesis
                                // abierto que haya en la lista
                                pos1 = valor.lastIndexOf(operacion);

                                // El valor de la posición de corte anterior
                                // será la del paréntesis
                                pos2 = pos1;

                                // La posición de corte posterior será la siguiente
                                // operación del resto de la lista, donde buscaremos
                                // el primer paréntesis cerrado
                                pos3 = pos1 + 1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), new String[]{")"}, true);

                                // Dentro de los paréntesis puede haber 
                                // cualquier conjunto de operaciones, para 
                                // calcular el valor resultante del paréntesis
                                // transformamos la lista de valores a una cadena
                                // y la volvemos a pasar por el parser de forma
                                // recursiva. Almacenamos el resultado
                                numero1 = new BigDecimal(parser(listaACadena(valor.subList(pos2 + 1, pos3))));

                                break;
                            }
                            case "s":
                            case "l":
                            case "L":
                            case "!":
                            case "Q": {

                                // Buscamos el índice de la primera operación en la lista
                                pos1 = valor.indexOf(operacion);

                                // Igualamos la posición de corte anterior a la 
                                // posición de la operación
                                pos2 = pos1;

                                // Buscamos cualquiera que sea la siguiente operación de la lista
                                // desde el índice de la primera operación y el final de la lista
                                pos3 = pos1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), operaciones, true);

                                // Comprobamos la operación
                                switch (operacion) {

                                    // Calculamos la operación necesaria usando
                                    // el valor de la lista correspondiente
                                    case "!": {
                                        numero1 = factorial(Double.valueOf(valor.get(pos3).toString()));
                                        break;
                                    }
                                    case "Q": {
                                        numero1 = new BigDecimal(Math.sqrt(Double.valueOf(valor.get(pos3).toString())));
                                        break;
                                    }
                                    case "l": {
                                        numero1 = new BigDecimal(Math.log(Double.valueOf(valor.get(pos3).toString())));
                                        break;
                                    }
                                    case "L": {
                                        numero1 = new BigDecimal(Math.log10(Double.valueOf(valor.get(pos3).toString())));
                                        break;
                                    }
                                    case "s": {
                                        numero1 = new BigDecimal(Math.pow((Double.valueOf(valor.get(pos3).toString())), 2));
                                        break;
                                    }
                                }

                                break;
                            }
                            case "T":
                            case "C":
                            case "S": {

                                // Buscamos el índice de la primera operación en la lista
                                pos1 = valor.indexOf(operacion);

                                // Igualamos la posición de corte anterior a la 
                                // posición de la operación                                
                                pos2 = pos1;

                                // Buscamos cualquiera que sea la siguiente operación de la lista
                                // desde el índice de la primera operación y el final de la lista                                
                                pos3 = pos1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), operaciones, true);

                                // Pasamos el número a calcular a un double para
                                // realizar las operaciones
                                double numero = Double.valueOf(valor.get(pos3).toString());

                                // Comprobamos el tipo de operación y la realizamos
                                // tras pasar el número a radianes
                                switch (operacion) {
                                    case "S": {
                                        numero = Math.sin(Math.toRadians(numero));
                                        break;
                                    }
                                    case "C": {
                                        numero = Math.cos(Math.toRadians(numero));
                                        break;
                                    }
                                    case "T": {
                                        numero = Math.tan(Math.toRadians(numero));
                                        break;
                                    }
                                }

                                // Almacenamos el resultado
                                numero1 = new BigDecimal(numero);

                                break;
                            }
                            case "%": {
                                // Buscamos el índice de la operación
                                pos1 = valor.indexOf(operacion);

                                // Buscamos la operación anterior y nos 
                                // posicionamos en el siguiente elemento de la 
                                // lista
                                pos2 = buscarOperacion(valor.subList(0, pos1), operaciones, false) + 1;

                                // Buscamos la operación posterior y nos posicionamos
                                // en el elemento anterior
                                pos3 = pos1;

                                // Convertimos los números de antes y despues de
                                // la operación a BigDecimal y operamos con ellos
                                numero1 = new BigDecimal(valor.get(pos2).toString());
                                numero1 = numero1.divide(new BigDecimal("100"), precision, RoundingMode.DOWN);

                                break;
                            }
                            case "+": {
                                // Buscamos el índice de la operación
                                pos1 = valor.indexOf(operacion);

                                // Buscamos la operación anterior y nos 
                                // posicionamos en el siguiente elemento de la 
                                // lista
                                pos2 = buscarOperacion(valor.subList(0, pos1), operaciones, false) + 1;

                                // Buscamos la operación posterior y nos posicionamos
                                // en el elemento anterior
                                pos3 = pos1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), operaciones, true);

                                // Convertimos los números de antes y despues de
                                // la operación a BigDecimal y operamos con ellos
                                numero1 = new BigDecimal(valor.get(pos2).toString());
                                numero1 = numero1.add(new BigDecimal(valor.get(pos3).toString()));
                                break;
                            }
                            case "-": {
                                // Buscamos el índice de la operación
                                pos1 = valor.indexOf(operacion);

                                // Buscamos la operación anterior y nos 
                                // posicionamos en el siguiente elemento de la 
                                // lista                                
                                pos2 = buscarOperacion(valor.subList(0, pos1), operaciones, false) + 1;

                                // Buscamos la operación posterior y nos posicionamos
                                // en el elemento anterior                                
                                pos3 = pos1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), operaciones, true);

                                // Convertimos los números de antes y despues de
                                // la operación a BigDecimal y operamos con ellos                                
                                numero1 = new BigDecimal(valor.get(pos2).toString());
                                numero1 = numero1.subtract(new BigDecimal(valor.get(pos3).toString()));
                                break;
                            }
                            case "*": {
                                // Buscamos el índice de la operación
                                pos1 = valor.indexOf(operacion);

                                // Buscamos la operación anterior y nos 
                                // posicionamos en el siguiente elemento de la 
                                // lista                                                                
                                pos2 = buscarOperacion(valor.subList(0, pos1), operaciones, false) + 1;

                                // Buscamos la operación posterior y nos posicionamos
                                // en el elemento anterior                                                                
                                pos3 = pos1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), operaciones, true);

                                // Convertimos los números de antes y despues de
                                // la operación a BigDecimal y operamos con ellos                                
                                numero1 = new BigDecimal(valor.get(pos2).toString());
                                numero1 = numero1.multiply(new BigDecimal(valor.get(pos3).toString()));
                                break;
                            }
                            case "/": {
                                // Buscamos el índice de la operación
                                pos1 = valor.indexOf(operacion);

                                // Buscamos la operación anterior y nos 
                                // posicionamos en el siguiente elemento de la 
                                // lista                                                                                                
                                pos2 = buscarOperacion(valor.subList(0, pos1), operaciones, false) + 1;

                                // Buscamos la operación posterior y nos posicionamos
                                // en el elemento anterior                                                                                                
                                pos3 = pos1 + buscarOperacion(valor.subList(pos1 + 1, valor.size()), operaciones, true);

                                // Convertimos los números de antes y despues de
                                // la operación a BigDecimal y operamos con ellos                                                                
                                numero1 = new BigDecimal(valor.get(pos2).toString());
                                numero1 = numero1.divide(new BigDecimal(valor.get(pos3).toString()), precision, RoundingMode.HALF_DOWN);
                                break;
                            }
                        }

                        // Quitamos los ceros sobrantes y almacenamos el número
                        // posición de corte anterior
                        valor.set(pos2, numero1.stripTrailingZeros().toString());

                        // Limpiamos los valores de la lista entre la posición 
                        // de corte anterior + 1 y la posición de corte posterior + 1
                        // eliminando los valores de la lista que se han calculado
                        // y guardando el resultado en la última posición tratada
                        valor.subList(pos2 + 1, pos3 + 1).clear();

                        // Ajustamos la lista si tuviese espacios vacios
                        valor.trimToSize();

                    }
                } // Seguimos iterando encontremos la operación de la iteración
                // en la lista
                while (valor.contains(operacion));
            }
        } // Seguimos operando mientras haya operaciones
        while (!Collections.disjoint(valor, Arrays.asList(operaciones)));

        // Dividimos el numero resultante entre 1 para ajustar la preción del
        // resultado
        numero1 = new BigDecimal(valor.get(0).toString());
        numero1 = numero1.divide(BigDecimal.ONE, precision, RoundingMode.FLOOR);

        // Devolvemos el resultado
        return numero1.stripTrailingZeros().toPlainString();
    }


    private static String transformarNegativos(String cadena) {

        String signos[] = {"N", "(", "!", "s", "Q", "l", "L", "S", "C", "T", "%", "*", "/", "+", "-"};
        
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '-') {
                if (i == 0 || Arrays.asList(signos).contains(String.valueOf(cadena.charAt(i - 1)))) {
                    int siguiente = cadena.length();

                    for (int j = i + 1; j < cadena.length(); j++) {
                        if (Arrays.asList(signos).contains(String.valueOf(cadena.charAt(j)))) {
                            siguiente = j;
                            break;
                        }
                    }
                    cadena = (cadena.substring(0, i) + "N(" + cadena.substring(i + 1, siguiente) + ")" + cadena.substring(siguiente, cadena.length()));

                }
            }
        }

        return cadena;
    }

    /**
     * Función para transformar una lista a una cadena
     *
     * @param lista Lista con los valores a transformar
     * @return Una cadena con con los valores de la lista como cadena
     */
    private static String listaACadena(List lista) {
        String cadena = "";

        // Iteramos por la lista
        for (Object object : lista) {

            // Concatenamos los valores de la lista a una cadena
            cadena = cadena.concat(object + "");
        }

        // Devolvemos la cadena con los valores concatenados
        return cadena;
    }

    /**
     * Función para pasar una cadena de texto a una lista, delimitada por las
     * operaciones que pudiera contener
     *
     * @param valor Cadena con las operaciones y dígitos
     * @param operaciones Posibles operaciones que puede contener la cadena
     * @return Lista que tiene el contenido de la cadena delimitado en números y
     * operaciones
     */
    private static ArrayList cadenaALista(String valor, String[] operaciones) {

        // Definimos una lista de tipo cadena donde almacenar los carácteres
        ArrayList<String> chars = new ArrayList<>();
        String cadena = "";

        // Iteramos por los caracteres de la cadena
        for (char c : valor.toCharArray()) {

            // Si la lista de operaciones contiene el caracter de la iteración
            if (Arrays.asList(operaciones).contains(c + "")) {

                // Comprobamos que la cadena que contiene la suceción de números
                // no sea vacía
                if (!cadena.equals("")) {
                    // Si no lo es, la añadimos a la lista como un número completo
                    chars.add(cadena);
                }

                // Como es una operación, añadimos la operación tambien a la lista
                cadena = "";

                // Añadimos tambien
                chars.add(c + "");
            } else {

                // Si no es una operación es un número, y no estará completo 
                // hasta que no haya una operación, por tanto lo concatenamos
                cadena = cadena.concat(c + "");
            }
        }

        // Si la cadena es distinta de nulo, la añadimos al final
        // Por si fuese solo una serie de números
        if (!cadena.equals("")) {
            chars.add(cadena);
        }

        // Devolvemos el resultado
        return chars;
    }

    /**
     * Función para buscar la posición de la operación más cercana de una lista
     * dígitos y operaciones
     *
     * @param valores Lista con los dígitos y las operaciones a analizar
     * @param operaciones Operaciones a buscar
     * @param izqDer Para realizar la búsqueda de izquierda a derecha o a la
     * inversa
     * @return Posición de la operación más cercana
     */
    private static int buscarOperacion(List valores, String[] operaciones, boolean izqDer) {

        // Iniciamos la variable de resultado. 
        // Si la búsqueda es de izquierda a derecha, su valor inicial será
        // el tamaño de la lista, si no es así será cero
        int resultado = (izqDer ? valores.size() : 0);

        // Iteramos por todas las operaciones disponibles
        for (String operacion : operaciones) {

            // Varificamos el sentido de la búsqueda
            if (!izqDer) {

                // Si el índice de la operación del bucle es menor que el valor
                // almacenado en resultado, eso indica que está más a la derecha
                // de la lista y seria posterior a la anterior que hubiesemos 
                // guardado
                if (resultado < valores.lastIndexOf(operacion)) {

                    // Si esto es asi, guardamos su posición para devolverla al 
                    // final de la función
                    resultado = valores.lastIndexOf(operacion);
                }
            } else {
                // Comprobamos inicialmente que la operación está en la lista
                if (valores.indexOf(operacion) != -1) {

                    // De ser así, comprobamos si su indice es menor que el que 
                    // tenemos almacenado en la variable de resultado, lo cual 
                    // querría decir que la operación es anterior a la que 
                    // habíamos guardado
                    if (resultado > valores.indexOf(operacion)) {

                        // Si esto es así, guardamos la posición para devolverla
                        // al final de la función
                        resultado = valores.indexOf(operacion);
                    }
                }
            }
        }

        // Si el resultado es cero, eso quiero decir que no había operación
        // en la lista y devolvemos un valor de -1, si tenemos un resultado
        // devolvemos el valor.
        return (resultado == 0 ? -1 : resultado);
    }

    /**
     * Modifica la cadena de texto visible al usuario transformándola en una
     * legible para el parseador de operaciones
     *
     * @param cadena Cadena a transformar
     * @return Cadena transformada
     */
    private static String transformarFunciones(String cadena) {
        String salida = cadena;

        // Cambiamos las funciones por identificativos de una letra
        salida = salida.replace("Sin", "S");
        salida = salida.replace("Cos", "C");
        salida = salida.replace("Tan", "T");
        salida = salida.replace("Fact", "!");
        salida = salida.replace("Sqrt", "Q");
        salida = salida.replace("Ln", "l");
        salida = salida.replace("Log", "L");
        salida = salida.replace("Sqr", "s");

        // Devolvemos el resultado
        return salida;
    }

    /**
     * Método para calcular el factorial de un número
     *
     * @param n Número al que calcular el factorial
     * @return Factorial del número introducido
     */
    public static BigDecimal factorial(double n) {

        // Inicializamos la variable de salida
        BigDecimal factorial = BigDecimal.ONE;

        // Iteramos multiplicando el valor de la iteración por el acumulado del
        // factorial hasta llegar al número de entrada
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigDecimal.valueOf(i));
        }

        // Devolvemos el resultado
        return factorial;
    }
}
