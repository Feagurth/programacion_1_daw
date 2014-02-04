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

package stringbuilderinsert;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class StringBuilderInsert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StringBuilder buffer = new StringBuilder();
        
        char caracter = ' ';
               
        System.out.println("Buffer: " + buffer.toString());

        Object refObjeto = "hola";        
        buffer.insert(0, refObjeto);        
        
        System.out.println("Buffer: " + buffer.toString());
        
        buffer.insert(2, caracter);
        
        System.out.println("Buffer: " + buffer.toString());
        
        buffer.delete(0, 1);
        
        System.out.println("Buffer: " + buffer.toString());

        buffer.deleteCharAt(0);
        
        System.out.println("Buffer: " + buffer.toString());
    }
    
}
