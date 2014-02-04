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

package stringbuildercaplen;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class StringBuilderCapLen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        StringBuilder buffer = new StringBuilder("Programación en Java");
        
        System.out.printf("Buffer = %s\n", buffer.toString());
        System.out.printf("Longitud = %s\n", buffer.length());
        System.out.printf("Capacidad = %s\n", buffer.capacity());
        buffer.ensureCapacity(75);
        System.out.printf("Nueva Capacidad = %s\n", buffer.capacity());
        buffer.setLength(10);
        System.out.printf("Nueva Longitud = %s\n", buffer.length());
        System.out.printf("Buffer = %s\n", buffer.toString());        
            
    }
    
}
