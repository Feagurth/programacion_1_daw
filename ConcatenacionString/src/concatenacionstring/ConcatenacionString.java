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

package concatenacionstring;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class ConcatenacionString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s1 = new String("Programación ");
        String s2 = new String("en Java");
        
        System.out.printf("s1: %s\n", s1);
        System.out.printf("s2: %s\n", s2);
        System.out.printf("s1 concatenado con s2: %s\n", s1.concat(s2));
        
    }
    
    
    
}
