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
package Trimestre.Segundo.Ejercicios.RegExp;

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * Crear un programa en Java que convierta un número natural (menor a 4000) en
 * romano (construido como una cadena de caracteres).
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio002 {

    /**
     * Función para pasar un número arábigo a romano
     *
     * @param numero Número a convertir
     * @return Número convertido
     */
    private String arabigoARomano(int numero) {
        // Variables
        int resto = numero;
        
        // Creamos un objeto StringBuilder para concatener el resultado
        StringBuilder buf = new StringBuilder();

        // Iteraremos realizando los calculos correspondientes
        // hasta que el resto sea 0. Comprobaremos si el resto es divisible
        // entre cada uno de los valores comparables para realizar la conversión        
        do {

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 1000
            if (resto / 1000 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 1000;
                    buf.append("M");
                } while (resto >= 1000);
            }

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 900
            if (resto / 900 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 900;
                    buf.append("CM");
                } while (resto >= 900);
            }

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 500
            if (resto / 500 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 500;
                    buf.append("D");
                } while (resto >= 500);
            }

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 400
            if (resto / 400 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 400;
                    buf.append("CD");
                } while (resto >= 400);
            }

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 100
            if (resto / 100 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 100;
                    buf.append("C");
                } while (resto >= 100);
            }

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 90
            if (resto / 90 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 90;
                    buf.append("XC");
                } while (resto >= 90);
            }

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 50
            if (resto / 50 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 50;
                    buf.append("L");
                } while (resto >= 50);
            }

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 40
            if (resto / 40 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 40;
                    buf.append("XL");                    
                } while (resto >= 40);
            }

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 10
            if (resto / 10 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 10;
                    buf.append("X");
                } while (resto >= 10);
            }

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 9
            if (resto / 9 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 9;
                    buf.append("IX");
                } while (resto >= 9);
            }

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 5
            if (resto / 5 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 5;
                    buf.append("V");
                } while (resto >= 5);
            }

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 4
            if (resto / 4 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 4;
                    buf.append("IV");
                } while (resto >= 4);
            }

            // Si el resto es divisible entre 1000 quiere decir que podemos
            // convertir ese valor en el valor romano para 1
            if (resto / 1 != 0) {
                // Iteramos quitandole al resto el valor y concatenando al
                // resultado el valor romano correspondiente hasta que no
                // podamos quitarle más al resto sin hacerlo negativo
                do {
                    resto -= 1;
                    buf.append("I");
                } while (resto >= 1);
            }
        } while (resto != 0);

        // Devolvemos el resultado
        return buf.toString();
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variable para almacenar el número introducido por el usuario
        int numero;

        // Pedimos al usuario un número y lo almacenamos en la variable
        // destinada a ello
        numero = PeticionDatos.pedirEnteroRango("Introduzca un número "
                + "entre 1 y 3999", 1, 3999);

        // Mostramos el resultado
        Mensajes.mostrarMensaje("El valor de " + numero + " en números romanos "
                + "es: " + arabigoARomano(numero),
                Mensajes.TipoMensaje.INFORMACION);
    }
}
