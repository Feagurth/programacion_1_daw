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

package iniciararray3;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Iniciararray3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int LONGITUD_ARRAY = 10;
        int array[] = new int[LONGITUD_ARRAY];
        
        System.out.printf("Indice\tValor\n");
        for (int i = 0; i < LONGITUD_ARRAY; i++) {
            array[i] = (i * 2) + 2;
            System.out.printf("%d\t%d\n", i, array[i]);
        }
    }
    
}
