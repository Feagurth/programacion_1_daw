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
 * Clase para realizar el ejercicio 5.24 del libro de texto Como Programar en
 * Java 7ed Deitel*
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_24 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // Variables
        final int alto = 9;
        StringBuilder buf = new StringBuilder();

        for (int i = 1; i <= ((alto / 2) + 1); i++) {
            for (int k = 1; k <= alto / 2 - i + 1; k++) {
                buf.append(" ");
            }

            // Iteramos para dibujar la parte superior del rombo
            for (int j = (alto / 2) - i + 2; j <= (alto / 2) + i; j++) {
                buf.append("*");
            }
            buf.append("\n");
        }

        // Iteramos para dibujar la parte inferior del rombo
        for (int l = 1; l <= alto / 2; l++) {

            // Imprimimos espacios
            for (int m = 1; m <= l; m++) {
                buf.append(" ");
            }
            
            for (int n = l + 1; n <= alto - l; n++) {
                buf.append("*");
            }
            buf.append("\n");
        }
        
        // Mostramos resultados. Se muestra tb por consola pues en un 
        // cuando de mensaje no queda bien alineado
        System.out.print(buf.toString());
        Mensajes.mostrarMensaje(buf.toString(), "Resultado", Mensajes.TipoMensaje.INFORMACION, true);
    }
}
