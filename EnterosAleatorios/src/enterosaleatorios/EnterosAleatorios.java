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
package enterosaleatorios;

import java.util.Random;

/**
 * Clase para trabajar con números aleatorios
 *
 * @author Luis Cabrerizo Gómez
 */
public class EnterosAleatorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Objeto para generar números aleatorios
        Random numerosAleatorios = new Random();

        // Variable
        int cara;

        // Bucle para lanzar el dado 20 veces
        for (int i = 1; i <= 20; i++) {

            // Lanzamos el dado
            cara = numerosAleatorios.nextInt(6) + 1;

            // Mostramos el resultado
            System.out.printf("%d ", cara);

            // Cada 5 valores introducimos un salto de linea
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }

}
