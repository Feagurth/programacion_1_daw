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
package Trimestre.Segundo.Ejercicios.LibroPdf;

import Utiles.Mensajes;

/**
 * He aquí otro adelanto. En este capítulo, aprendió acerca de los enteros y el
 * tipo int. Java puede también representar letras en mayúsculas, en minúsculas
 * y una considerable variedad de símbolos especiales. Cada carácter tiene su
 * correspondiente representación entera. El conjunto de caracteres que utiliza
 * una computadora, y las correspondientes representaciones enteras de esos
 * caracteres, se conocen como el conjunto de caracteres de esa computadora.
 * Usted puede indicar un valor de carácter en un programa con sólo encerrar ese
 * carácter entre comillas sencillas, como en 'A'. Usted puede determinar el
 * equivalente entero de un carácter si antepone a ese carácter la palabra
 * (int), como en (int) 'A' Esta forma se conoce como operador de conversión de
 * tipo. (Hablaremos más sobre estos operadores en el capítulo 4). La siguiente
 * instrucción imprime un carácter y su equivalente entero: System.out.printf(
 * "El caracter %c tiene el valor %d\n", 'A', ((int) 'A' )); Cuando se ejecuta
 * esta instrucción, muestra el carácter A y el valor 65 (del conjunto de
 * caracteres conocido como Unicode ®) como parte de la cadena. Observe que el
 * especificador de formato %c es un receptáculo para un carácter (en este caso,
 * el carácter 'A'). Utilizando instrucciones similares a la mostrada
 * anteriormente en este ejercicio, escriba una aplicación que muestre los
 * equivalentes enteros de algunas letras en mayúsculas, en minúsculas, dígitos
 * y símbolos especiales. Muestre los equivalentes enteros de los siguientes
 * caracteres: A B C a b c 0 1 2 $ * + / y el carácter en blanco.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio2_29 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        String resultado;

        // Concatenamos el valor para A
        resultado = String.format("El caracter %c tiene el valor %d%n",
                'A', ((int) 'A'));

        // Concatenamos el valor para B
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", 'B', ((int) 'B'));

        // Concatenamos el valor para C
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", 'C', ((int) 'C'));

        // Concatenamos el valor para a
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", 'a', ((int) 'a'));

        // Concatenamos el valor para b
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", 'b', ((int) 'b'));

        // Concatenamos el valor para c
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", 'c', ((int) 'c'));

        // Concatenamos el valor para 0
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", '0', ((int) '0'));

        // Concatenamos el valor para 1
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", '1', ((int) '1'));

        // Concatenamos el valor para 2
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", '2', ((int) '2'));

        // Concatenamos el valor para $
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", '$', ((int) '$'));

        // Concatenamos el valor para *
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", '*', ((int) '*'));

        // Concatenamos el valor para +
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", '+', ((int) '+'));

        // Concatenamos el valor para /
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", '/', ((int) '/'));

        // Concatenamos el valor para el espacio en blanco
        resultado += String.format(
                "El caracter %c tiene el valor %d%n", ' ', ((int) ' '));

        // Imprimimos los resultados
        Mensajes.mostrarMensaje(resultado, Mensajes.TipoMensaje.INFORMACION);

    }
}
