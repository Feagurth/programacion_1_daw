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
package graficobarras;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class GraficoBarras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[] = {0, 0, 0, 0, 0, 0, 1, 2, 4, 2, 1};

        System.out.println("Distribución de las calificaciones");
        for (int i = 0; i < array.length; i++) {
            if (i == 10) {
                System.out.printf("%5d: ", 100);
            } else {
                System.out.printf("%d0-%d9: ", i, i);
            }
            for (int asteriscos = 0; asteriscos < array[i]; asteriscos++)
                System.out.print("*");
            System.out.println();
        }
    }

}
