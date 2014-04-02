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
import Utiles.PeticionDatos;

/**
 * Diseñar un algoritmo que lea e imprima una serie de números distintos de 0.
 * El algoritmo debe terminar con un valor cero que no se debe imprimir.
 * Finalmente se desea obtener la cantidad de valores leídos distintos de 0
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio002 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables
        int contador = 0;
        int numero = -1;
        StringBuilder cadena = new StringBuilder();

        // Comprobamos que el número introducido es distinto de cero
        while (numero != 0) {
            numero = PeticionDatos.pedirEntero("Introduzca un número\n0 para salir");

            if (numero != 0) {
                cadena.append(numero);
                cadena.append(" ");
                contador++;
            }
        }
        cadena.append("\n");
        cadena.append("Número de valores introducidos: ");
        cadena.append(contador);

        Mensajes.mostrarMensaje(cadena.toString(), "Resultados", Mensajes.TipoMensaje.INFORMACION);

    }
}
