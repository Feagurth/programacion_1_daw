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

package variosstring;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class VariosString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s1 = "Hola a todos";
        char[] arrayChar = new char[5];
        
        System.out.printf("S1: %s\n", s1);
        System.out.printf("La longitud de S1 es %d\n", s1.length());
        
        for (int i = s1.length() -1; i >= 0; i--) {
            System.out.printf("%s ", s1.charAt(i));            
        }
        
        System.out.println("");
        
        s1.getChars(0, 4, arrayChar, 0);
        
        for (char caracter : arrayChar) {
            System.out.println(caracter);            
        }
        
        
    }
    
}
