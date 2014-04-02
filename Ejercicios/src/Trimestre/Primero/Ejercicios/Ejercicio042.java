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
import java.awt.Dimension;

/**
 * Calcular y escribir los cuadrados de una serie de números distintos de 0
 * leídos desde el teclado
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio042 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // Variables
        int num_numeros, numero, contador;
        StringBuilder resultado = new StringBuilder();

        // Petición de datos al usuario
        num_numeros = Integer.parseInt(Mensajes.pedirDatos("¿Cantidad de "
                + "números a introducir?", "Petición de Datos",
                Mensajes.TipoMensaje.PREGUNTA));

        // Inicializamos el contador
        contador = 0;

        do {

            // Pedimos un valor al usuario
            numero = Integer.parseInt(Mensajes.pedirDatos("Introduzca un "
                    + "valor", "Petición de Datos",
                    Mensajes.TipoMensaje.PREGUNTA));

            // Verificamos si el número es distinto de cero
            if (numero != 0) {
                // Concatenamos resultados
                resultado.append(String.format("%d - %.0f%n", numero, Math.pow(numero, 2)));
            }

            // Aumentamos el contador
            contador++;
        } while (contador != num_numeros);

        // Mostramos el resultado
        Mensajes.mostrarMensaje(resultado.toString(), "Información",
                Mensajes.TipoMensaje.INFORMACION, true, new Dimension(10, 3));
    }
}
