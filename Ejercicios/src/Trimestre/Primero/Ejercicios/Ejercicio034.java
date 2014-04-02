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
 * Diseñar un algoritmo en el que a partir de una fecha introducida por teclado
 * con el formato DÍA, MES, AÑO, se obtenga la fecha del día siguiente.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio034 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables
        int dia, mes, anyo, apoyoBisiesto;

        // Lectura de datos
        dia = Integer.parseInt(Mensajes.pedirDatos("Introduzca el día",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        mes = Integer.parseInt(Mensajes.pedirDatos("Introduzca el mes",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        anyo = Integer.parseInt(Mensajes.pedirDatos("Introduzca el año",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        // Realizamos acciones segun el mes que sea y el dia en el que estemos
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if (dia == 31) {
                    dia = 1;
                    mes += 1;
                } else {
                    dia += 1;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (dia == 30) {
                    dia = 1;
                    mes += 1;
                } else {
                    dia += 1;
                }
                break;
            case 12:
                if (dia == 31) {
                    dia = 1;
                    mes = 1;
                    anyo += 1;
                } else {
                    dia += 1;
                }
                break;
            case 2:
                if (anyo % 4 == 0 && (anyo % 100 != 0 || anyo % 400 == 0)) {
                    apoyoBisiesto = 0;
                } else {
                    apoyoBisiesto = 1;
                }

                if (dia == (29 - apoyoBisiesto)) {
                    dia = 1;
                    mes += 1;
                } else {
                    dia += 1;
                }
                break;
            default: {
                break;
            }
        }

        // Muestra de resultados
        Mensajes.mostrarMensaje("El dia siguiente es " + dia + "/" + mes + "/" + anyo,
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }
}
