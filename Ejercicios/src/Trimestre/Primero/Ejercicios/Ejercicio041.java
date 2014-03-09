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
 * Calcule la suma de los 50 primeros números enteros
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio041 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables
        int suma, contador;

        // Inicializamos la variable
        suma = 0;

        // Iteramos de 1 a 50
        for (contador = 1; contador <= 50; contador++) {
            // Sumamos los valores de forma consecutiva
            suma = suma + contador;
        }

        // Mostramos resultado al usuario
        Mensajes.mostrarMensaje("El resultado es: " + suma, "Resultado",
                Mensajes.TipoMensaje.INFORMACION);
    }
}
