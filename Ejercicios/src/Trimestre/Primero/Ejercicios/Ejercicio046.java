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
 * Escribir un algoritmo que permita calcular X^n, donde: X → puede ser
 * cualquier numero real distinto de 0 n → puede ser cualquier entero positivo,
 * negativo o nulo. Nota: suponemos que no esta implementado el operador de
 * exponenciación
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio046 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables
        double base, resultado = 0;
        int exponente, contador;

        // Petición de datos al usuario
        base = Double.parseDouble(Mensajes.pedirDatos("Introduzca un valor para "
                + "la base", "Petición de Datos",
                Mensajes.TipoMensaje.INFORMACION));

        exponente = Integer.parseInt(Mensajes.pedirDatos("Introduzca un valor "
                + "para el exponente", "Petición de Datos",
                Mensajes.TipoMensaje.INFORMACION));

        // Comprobamos que la base es mayor de cero
        if (base > 0) {

            // Dependiendo del exponente haremos una u otra cosa
            switch (exponente) {
                case 0:
                    resultado = 1;
                    break;
                case 1:
                    resultado = base;
                    break;
                default:
                    // Igualamos el resultado a la base
                    resultado = base;

                    // Iteramos tantas veces como sea necesario
                    for (contador = 1; contador < exponente; contador++) {
                        resultado = resultado * base;
                    }
                    break;
            }
        }

        // Mostramos el resultado al usuario
        Mensajes.mostrarMensaje(String.valueOf(resultado), "Información",
                Mensajes.TipoMensaje.INFORMACION);
    }

}
