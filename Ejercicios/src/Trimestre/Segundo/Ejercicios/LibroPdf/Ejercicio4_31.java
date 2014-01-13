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
package Trimestre.Segundo.Ejercicios.LibroPdf;

import Utiles.Mensajes;

/**
 * Clase para realizar el ejercicio 4.31 del libro de texto Como Programar en
 * Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_31 {

    public void Ejercicio() {
        // Objeto para pedir y mostrar datos al usuario
        Mensajes mensaje = new Mensajes();

        // Variable para almacenar el valor introducido por el usuario
        String cadenaBinaria;

        // Pedimos datos al usuario
        cadenaBinaria = mensaje.PedirDatos("Introduzca un valor en binario",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA);

        // Mostramos el resultado
        mensaje.MostrarMensaje("Su valor es: "
                + enteroDeCadenaBinaria(cadenaBinaria), "Resultado",
                Mensajes.TipoMensaje.INFORMACION);
    }

    /**
     * Función para transformar una cadena en binario en un valor decimal
     *
     * @param cadena Valor binario a transformar
     * @return Valor decimal transformado
     */
    public static int enteroDeCadenaBinaria(String cadena) {
        int j = 0;

        // Iteramos por la candena
        for (int i = 0; i < cadena.length(); i++) {
            // Si el caracter de la iteración es un 1, calculamos su valor en
            // decimal dependiendo de su posición 
            if (cadena.charAt(i) == '1') {
                j += (int) (Math.pow(2, cadena.length() - 1 - i));
            }
        }
        return j;
    }
}
