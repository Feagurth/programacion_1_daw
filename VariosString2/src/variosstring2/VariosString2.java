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

package variosstring2;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class VariosString2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s1 = new String("hola");
        String s2 = new String("ADIOS");
        String s3 = new String("     espacios     ");
        
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
        
        System.out.println("Reemplazar el caracter 'l' con el caracter 'L' "
                + "en s1: " + s1.replace('l', 'L'));

        System.out.println("Cambiar s1 a mayúsculas: " + s1.toUpperCase());
        System.out.println("Cambiar s2 a minúsculas: " + s2.toLowerCase());
        System.out.println("s3 sin espacios en blanco: " + s3.trim());
        

        char arrayChar[] = s1.toCharArray();

        for (char caracter : arrayChar) {
            System.out.print(caracter);
        }
        System.out.println();
        
        
        
        
        
    }
    
}
