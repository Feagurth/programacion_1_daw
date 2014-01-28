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

package inicarray;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class InicArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array1[][] = {{1, 2, 3}, {4, 5, 6}};
        int array2[][] = {{1, 2}, {3}, {4, 5, 6}};
        
        System.out.println("Los valores del primer array son: ");
        imprimirArray(array1);
        System.out.println("Los valores del segundo array son: ");
        imprimirArray(array2);
    }

    public static void imprimirArray(int array[][]) {
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%d ", array[i][j]);
            }
               System.out.println();            
        }
    }
    
}
