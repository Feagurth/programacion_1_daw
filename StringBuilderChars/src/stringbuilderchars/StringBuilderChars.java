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

package stringbuilderchars;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class StringBuilderChars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringBuilder buffer = new StringBuilder("Hola a todos");
        
        char arrayChars[] = new char[buffer.length()];
        
        
        System.out.printf("Buffer = %s\n", buffer.toString());
        System.out.printf("Carácter en 0: %s\n", buffer.charAt(0));
        System.out.printf("Buffer = %s\n", buffer.toString());
        System.out.printf("Carácter en 3: %s\n", buffer.charAt(3));
        
        buffer.getChars(0, buffer.length(), arrayChars, 0);

        for (char c : arrayChars) {
            System.out.print(c);
        }
        System.out.println("");
        
        buffer.setCharAt(0, 'h');
        System.out.printf("Buffer = %s\n", buffer.toString());
        
        buffer.reverse();
        System.out.printf("Buffer = %s\n", buffer.toString());
    }
    
}
