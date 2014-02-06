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

package otrosmetodoschar;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class OtrosMetodosChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Character c1 = 'A';
        Character c2 = 'a';
        
        
        System.out.printf("c1 = %s\n", c1.charValue());
        System.out.printf("c2 = %s\n", c2.charValue());
        
        if(c1.equals(c2))
        {
            System.out.println("c1 y c2 son iguales");
        }
        else
        {
            System.out.println("c1 y c2 no son iguales");
        }
        
    }
    
}
