/*
 * Copyright (C) 2014 Luis Cabrerizo Gómez
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
 * Clase para realizar el ejercicio 5.15 del libro de texto Como Programar en
 * Java 7ed Deitel
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_15 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        apartadoA();
        System.out.println();
        apartadoB();
        System.out.println();
        apartadoC();
        System.out.println();
        apartadoD();
    }

    /**
     * Realiza el dibujo especificado en el apartado A
     */
    private void apartadoA() {
        StringBuilder resultado = new StringBuilder();

        resultado.append("Apartado A\n");

        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < i; j++) {
                resultado.append("*");
            }
            resultado.append("\n");
        }

        // Mostramos el resultado por consola y por mensaje emergente
        System.out.println(resultado.toString());
        Mensajes.mostrarMensaje(resultado.toString(), "Resultado",
                Mensajes.TipoMensaje.INFORMACION, true);
    }

    /**
     * Realiza el dibujo especificado en el apartado B
     */
    private void apartadoB() {
        StringBuilder resultado = new StringBuilder();

        resultado.append("Apartado B\n");
        for (int i = 10; i >= 1; i--) {
            for (int j = i; j > 0; j--) {
                resultado.append("*");
            }
            resultado.append("\n");
        }

        // Mostramos el resultado por consola y por mensaje emergente
        System.out.println(resultado.toString());
        Mensajes.mostrarMensaje(resultado.toString(), "Resultado",
                Mensajes.TipoMensaje.INFORMACION, true);
    }

    /**
     * Realiza el dibujo especificado en el apartado C
     */
    private void apartadoC() {
        StringBuilder resultado = new StringBuilder();

        resultado.append("Apartado C\n");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j >= i) {
                    resultado.append("*");
                } else {
                    resultado.append(" ");
                }
            }
            resultado.append("\n");
        }
        // Mostramos el resultado por consola y por mensaje emergente
        System.out.println(resultado.toString());
        Mensajes.mostrarMensaje(resultado.toString(), "Resultado",
                Mensajes.TipoMensaje.INFORMACION, true);
    }

    /**
     * Realiza el dibujo especificado en el apartado D
     */
    private void apartadoD() {
        StringBuilder resultado = new StringBuilder();

        resultado.append("Apartado D\n");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j <= 10 - i) {
                    resultado.append(" ");
                } else {
                    resultado.append("*");
                }
            }
            resultado.append("\n");
        }

        // Mostramos el resultado por consola y por mensaje emergente
        System.out.println(resultado.toString());
        Mensajes.mostrarMensaje(resultado.toString(), "Resultado",
                Mensajes.TipoMensaje.INFORMACION, true);
    }
}
