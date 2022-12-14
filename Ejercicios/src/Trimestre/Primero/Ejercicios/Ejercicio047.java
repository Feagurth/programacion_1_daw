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
 * Se desea leer desde teclado una serie de números hasta que aparezca alguno
 * menor que 1000.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio047 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables
        double numero;

        // Petición de datos al usuario
        numero = Double.parseDouble(Mensajes.pedirDatos("Introduzca un número",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        // Verificamos si el número es menor de 1000
        while (numero >= 1000) {
            // Pedimos un número nuevo
            numero = Double.parseDouble(Mensajes.pedirDatos("Introduzca un "
                    + "número", "Petición de Datos",
                    Mensajes.TipoMensaje.PREGUNTA));
        }

        // Mostramos en número
        Mensajes.mostrarMensaje(String.valueOf(numero), "Información",
                Mensajes.TipoMensaje.INFORMACION);
    }

}
