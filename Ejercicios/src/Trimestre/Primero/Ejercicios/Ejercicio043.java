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
 * Un capital C esta situado a un tipo de interés R .Se doblara el capital al
 * termino de dos años? [La formula del interés compuesto es CF = C(1+R)^N donde
 * C → capital; R → interés; N → número de años]
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio043 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // Variables
        float capital, interes, capitalFinal;
        int anyos;

        // Petición de datos al usuario
        capital = Float.parseFloat(Mensajes.pedirDatos("Introduzca el capital",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        interes = Float.parseFloat(Mensajes.pedirDatos("Introduzca el interés",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        anyos = Integer.parseInt(Mensajes.pedirDatos("Introduzca el número de años",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        // Calculamos el capital final
        capitalFinal = (float) (capital * Math.pow((1 + interes), anyos));

        // Comprobamos si se dobla y mostramos el resultado
        if (capitalFinal >= capital * 2) {
            Mensajes.mostrarMensaje("Se dobla el capital!\n" + String.format("%.2f", capitalFinal),
                    "Información", Mensajes.TipoMensaje.INFORMACION);
        } else {
            Mensajes.mostrarMensaje("No se dobla el capital!\n" + String.format("%.2f", capitalFinal),
                    "Información", Mensajes.TipoMensaje.INFORMACION);
        }
    }
}
