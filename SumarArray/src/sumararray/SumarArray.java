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

package sumararray;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class SumarArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[] = {87, 68, 94, 100, 83, 78, 85, 91, 76, 87};
        int total = 0;
        
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }    
        
        System.out.println("La suma de los elementos del array es: " + total);
    }
    
}
