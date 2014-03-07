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
 * Clase para realizar el ejercicio 4.30 del libro de texto Como Programar en
 * Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_30 {

    public void Ejercicio() {

        // Cadena para almacenar el texto introducido por el usuario
        String cadena;

        // Petición de datos al usuario
        cadena = PeticionDatos.pedirCadena("Introduzca una cadena de texto");

        // Realizamos la comprobación y mostramos el resultado
        if (esPalindromo(cadena)) {
            System.out.println("Es un palíndromo");
        } else {
            System.out.println("No es un palíndromo");
        }
    }

    /**
     * Función para comprobar si una cadena de texto es un palíndromo
     *
     * @param palindromo Cadena a comprobar
     * @return Resultado de la comprobación
     */
    private boolean esPalindromo(String palindromo) {
        boolean salida = true;
        int puntero = 0;
        
        // Quitamos espacios en blanco si los hubiese y pasamos a minúscula
        // todo el texto
        palindromo = palindromo.replace(" ", "").toLowerCase();        

        // Iteramos a lo largo de la cadena
        do {
            // Comprobamos que el vlaor dela posicón del puntero y el tamaño 
            // de la candena - el punteor son iguales. Si no son iguales no es
            // un palindromo
            if (palindromo.charAt(puntero)
                    != palindromo.charAt(palindromo.length() - puntero - 1)) {
                salida = false;
                break;
            }
            puntero++;
        } while ((palindromo.length() - puntero - 1) - puntero
                >= ((palindromo.length() % 2 == 0) ? 0 : 1));
        // Iteramos tantas veces como sean necesarias hasta que se cumple que la distancia
        // entre la "horquilla de comprobaciones" vale 1 en el caso de cadenas impares y 
        // 0 en el caso de las cadenas pares

        // Devolvemos el resultado
        return salida;
    }
}