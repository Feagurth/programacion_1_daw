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
package iniciararray2;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Iniciararray2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[] = {32, 27, 64, 18, 95, 14, 90, 70, 60, 37};

        System.out.println("Indice\tValor");

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d\t%d\n", i, array[i]);
        }
    }

}
