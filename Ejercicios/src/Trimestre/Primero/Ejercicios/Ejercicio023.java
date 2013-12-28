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
 * Sumar los números pares de 2 al 100 e imprimir su valor.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio023 {

    /**
    * Ejercicio principal
    */
    public void ejercicio() {
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();

        // Variables
        int sumaPares = 0;

        // Iteramos sumando los pares
        for (int i = 2; i < 100; i++) {
            sumaPares += i;
        }

        // Muestra de resultados para el usuario
        msg.MostrarMensaje("El resultado es: " + sumaPares, "Resultado",
                Mensajes.TipoMensaje.INFORMACION);

    }
}
