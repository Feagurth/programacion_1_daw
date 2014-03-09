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
package Trimestre.Primero.Ejercicios;

import Utiles.Mensajes;

/**
 * Ejercicio 50. Realizar una función no recursiva que permita obtener el
 * término n de la serie Fibonacci. La serie de Fibonacci se define como:
 * Fibonaccin = Fibonacci(n-1) + Fibonacci(n-2) para todo n > 1 Para n <= 1,
 * Fibonacci(n) = 1 @author Luis Cabre
 *
 * rizo Gómez
 */
public class Ejercicio050 {

    /**
     * Función para calcular el termino n de la serie de Fibonacci
     *
     * @param n Elemento n de la serie de Fibonacci
     * @return El valor del elemento n en la serie de Fibonacci
     */
    private int Fibonacci(int n) {
        // Variables de apoyo
        int f1 = 0, f2 = 1, f3 = 0;

        // Comprobamos la posición que deseamos
        switch (n) {
            // Caso fijo
            case 0: {
                f3 = 0;
                break;
            }
            // Caso fijo
            case 1: {
                f3 = 1;
                break;
            }
            // Resto de casos
            default: {
                // Iteramos calculando los valores
                for (int i = 2; i <= n; i++) {
                    f3 = f1 + f2;
                    f1 = f2;
                    f2 = f3;
                }
            }
        }
        // Devolvemos el resultado
        return f3;
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables
        int limite, crearSerie;
        String resultadoSerie = "";

        do {
            // Petición de datos al usuario
            crearSerie = Integer.parseInt(Mensajes.pedirDatos("1.- Calcular un "
                    + "valor de la serie de Fibonacci\n2.- Calcular una serie de "
                    + "n valores", "Petición de Datos",
                    Mensajes.TipoMensaje.PREGUNTA));
        } while (crearSerie != 1 && crearSerie != 2);

        // Petición de datos al usuario
        limite = Integer.parseInt(Mensajes.pedirDatos("Introduzca un valor",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        if (crearSerie == 1) {
            // Muestra de resultados al usuario
            Mensajes.mostrarMensaje("El valor para " + limite + " es : "
                    + String.valueOf(Fibonacci(limite)), "Resultado",
                    Mensajes.TipoMensaje.INFORMACION);
        } else {

            // Iteramos calculando los valores y añadiendolos a la variable
            for (int i = 0; i <= limite; i++) {
                resultadoSerie += ((i == 0) ? "" : ", ") + String.valueOf(Fibonacci(i));

            }

            // Muestra de resultados al usuario
            Mensajes.mostrarMensaje("La serie es: " + resultadoSerie,
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);
        }
    }
}
