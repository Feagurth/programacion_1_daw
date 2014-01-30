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
package metodoindexstring;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class MetodoIndexString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String letras = "abcdefghijklmabcdefghijklm";

        System.out.printf("'c' se encuentra en la posición %d\n", 
                letras.indexOf('c'));
        
        System.out.printf("'a' se encuentra en la posición %d\n", 
                letras.indexOf('a', 1));        

        System.out.printf("'$' se encuentra en la posición %d\n", 
                letras.indexOf('$'));        
        
        System.out.printf("La última 'c' se encuentra en el indice %d\n", letras.lastIndexOf('c'));
        
        System.out.printf("\"def\" se encuentra en el índice %d\n", letras.indexOf("def"));
        
    }

}
