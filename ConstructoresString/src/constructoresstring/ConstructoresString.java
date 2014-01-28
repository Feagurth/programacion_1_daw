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

package constructoresstring;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class ConstructoresString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char arrayChar[] = {'c', 'u', 'm', 'p', 'l', 'e', ' ', 'a', 'ñ', 'o', 's'};
        
        String s1 = new String("Hola");
        String s2 = new String(s1);
        String s3 = new String(arrayChar);
        String s4 = new String(arrayChar,7, 4);
        
        System.out.printf("S1 = %s\nS2 = %s\nS3 = %s\nS4 = %s\n", 
                s1, s2, s3, s4);
    }

    
    
}
