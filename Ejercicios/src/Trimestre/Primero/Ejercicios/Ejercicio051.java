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
 * Implementar una función que permita devolver un valor entero, leído desde el
 * teclado, comprendido entre dos límites que introduciremos como parámetro.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio051 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // Variables
        int limiteSuperior, limiteInferior;

        // Petición de datos al usuario
        limiteInferior = Integer.parseInt(Mensajes.pedirDatos("Introduzca un "
                + "valor para el límite inferior", "Petición de Datos",
                Mensajes.TipoMensaje.PREGUNTA));

        limiteSuperior = Integer.parseInt(Mensajes.pedirDatos("Introduzca un "
                + "valor para el límite superior", "Petición de Datos",
                Mensajes.TipoMensaje.PREGUNTA));

        // Muestra de resultados al usuario
        Mensajes.mostrarMensaje("El número es "
                + calcularEntero(limiteInferior, limiteSuperior),
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }

    /**
     * Función para devolver un número entre dos valores
     *
     * @param limiteInf Limite inferior del rango
     * @param limiteSup Limite superior del rango
     * @return Número entre los dos rangos
     */
    private int calcularEntero(int limiteInf, int limiteSup) {
        if (limiteSup - limiteInf == 0) {
            return limiteInf;
        } else if (limiteSup - limiteInf > 0) {
            return limiteInf + 1;
        } else {
            return limiteSup;
        }
    }
}
