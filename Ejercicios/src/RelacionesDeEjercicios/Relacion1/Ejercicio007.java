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
import java.util.Random;

/**
 * Crear un programa que genere de forma aleatoria una resultado de 10x10
 * elementos, donde cada uno es una letra. El programa debe imprimir ese array
 * bidimensional y mostrar cuantas vocales y consonantes tiene.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio007 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // Array para almacenar los elementos
        char[][] array = new char[10][10];

        int vocales = 0;
        int consonantes = 0;
        String resultado = "";

        // Generador de numeros con los que generaremos los caracteres
        Random generador = new Random();

        // Iteramos para las columnas
        for (int i = 0; i < 10; i++) {

            // Iteramos para las filas
            for (int j = 0; j < 10; j++) {

                // Generamos un caracter a base de generar un numero aleatorio
                // de o a 24 y sumando 97, lo que nos da un rango de 97 a 122
                // que corresponde a las letras de a la z en minúscula en la 
                // tabla de caracteres
                char caracter = (char) ((char) generador.nextInt(26) + 97);

                // Comprobamos si el caracter generado es una vocal
                if ("aeiou".indexOf(caracter) != -1) {
                    // Si es una vocal, aumentamos el contador
                    vocales++;
                } else {
                    // Si es una consonante, aumentamos el contador
                    consonantes++;
                }

                // Guardamos el caracter en su posición correspondiente
                array[i][j] = caracter;

                // Añadimos el caracter a la matriz de resultado con 
                // una tabulación
                resultado += caracter + "\t";
            }
            // En el cambio de fila, introducimos un retorno de carro
            resultado += "\n";
        }

        // Mostramos resultados
        resultado += "\nCantidad de vocales: " + vocales;
        resultado += "\nCantidad de consonantes: " + consonantes;
        
        Mensajes.mostrarMensaje(resultado,"Resultado", Mensajes.TipoMensaje.INFORMACION, true);
        
    }
}
