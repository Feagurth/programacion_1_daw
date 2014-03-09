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

import Utiles.PeticionDatos;

/**
 * Clase para realizar el ejercicio 5.25 del libro de texto Como Programar en
 * Java 7ed Deitel
 *
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_25 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // Variables
        int alto;
        String resultado = "";

        // Pedimos datos al usuario y nos aseguramos de que es impar
        do {
            alto = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca un numero impar");

        } while (alto % 2 == 0);

        for (int i = 1; i <= ((alto / 2) + 1); i++) {
            for (int k = 1; k <= alto / 2 - i + 1; k++) {
                resultado += " ";
            }

            // Iteramos para dibujar la parte superior del rombo
            for (int j = (alto / 2) - i + 2; j <= (alto / 2) + i; j++) {
                resultado += "*";
            }
            resultado += "\n";
        }

        // Iteramos para dibujar la parte inferior del rombo
        for (int l = 1; l <= alto / 2; l++) {

            // Imprimimos espacios
            for (int m = 1; m <= l; m++) {
                resultado += " ";
            }

            for (int n = l + 1; n <= alto - l; n++) {
                resultado += "*";
            }
            resultado += "\n";
        }

        // Mostramos resultados. 
        System.out.print(resultado);
    }

}
