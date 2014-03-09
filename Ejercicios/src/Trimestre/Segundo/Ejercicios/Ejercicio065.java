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
package Trimestre.Segundo.Ejercicios;

import Utiles.Mensajes;

/**
 * Algoritmo que transforma un número introducido por teclado en notación
 * decimal a romana. El número será entero y positivo y no excederá de 3000.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio065 {

    /**
     * Función para pasar un número arábigo a romano
     *
     * @param numero Número a convertir
     * @return Número convertido
     */
    private String ArabigoARomano(int numero) {
        // Variables
        String resultado = "";
        int resto = numero;

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
                    resultado += "M";
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
                    resultado += "CM";
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
                    resultado += "D";
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
                    resultado += "CD";
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
                    resultado += "C";
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
                    resultado += "XC";
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
                    resultado += "L";
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
                    resultado += "XL";
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
                    resultado += "X";
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
                    resultado += "IX";
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
                    resultado += "V";
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
                    resultado += "IV";
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
                    resultado += "I";
                } while (resto >= 1);
            }
        } while (resto != 0);

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variable para almacenar el valor a convertir
        int valor;

        // Variable para alamcenar el resultado de la conversión
        String resultado;

        // Iteramos mientras no se cumpla la condición
        do {
            // Petición de datos al usuario
            valor = Integer.parseInt(Mensajes.pedirDatos("Introduzca un número "
                    + "entero entre 1 y 3000", "Petición de Datos",
                    Mensajes.TipoMensaje.PREGUNTA));
        } while (valor <= 0 || valor > 3000);

        // Realizamos la conversión
        resultado = ArabigoARomano(valor);

        // Mostramos el resultado al usuario
        Mensajes.mostrarMensaje("El valor de " + valor + " en números romanos "
                + "es " + resultado, "Resultado",
                Mensajes.TipoMensaje.INFORMACION);
    }   
}
