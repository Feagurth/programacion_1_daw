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

    public void Ejercicio() {
        
        // Imprimimos el valor para A
        System.out.printf(
                "El caracter %c tiene el valor %d\n", 'A', ((int) 'A'));
        
        // Imprimimos el valor para B
        System.out.printf(
                "El caracter %c tiene el valor %d\n", 'B', ((int) 'B'));
        
        // Imprimimos el valor para C
        System.out.printf(
                "El caracter %c tiene el valor %d\n", 'C', ((int) 'C'));
        
        // Imprimimos el valor para a
        System.out.printf(
                "El caracter %c tiene el valor %d\n", 'a', ((int) 'a'));
        
        // Imprimimos el valor para b
        System.out.printf(
                "El caracter %c tiene el valor %d\n", 'b', ((int) 'b'));
        
        // Imprimimos el valor para c
        System.out.printf(
                "El caracter %c tiene el valor %d\n", 'c', ((int) 'c'));
        
        // Imprimimos el valor para 0
        System.out.printf(
                "El caracter %c tiene el valor %d\n", '0', ((int) '0'));
        
        // Imprimimos el valor para 1
        System.out.printf(
                "El caracter %c tiene el valor %d\n", '1', ((int) '1'));
        
        // Imprimimos el valor para 2
        System.out.printf(
                "El caracter %c tiene el valor %d\n", '2', ((int) '2'));
        
        // Imprimimos el valor para $
        System.out.printf(
                "El caracter %c tiene el valor %d\n", '$', ((int) '$'));
        
        // Imprimimos el valor para *
        System.out.printf(
                "El caracter %c tiene el valor %d\n", '*', ((int) '*'));
        
        // Imprimimos el valor para +
        System.out.printf(
                "El caracter %c tiene el valor %d\n", '+', ((int) '+'));
        
        // Imprimimos el valor para /
        System.out.printf(
                "El caracter %c tiene el valor %d\n", '/', ((int) '/'));
        
        // Imprimimos el valor para el espacio en blanco
        System.out.printf(
                "El caracter %c tiene el valor %d\n", ' ', ((int) ' '));
    }
}
