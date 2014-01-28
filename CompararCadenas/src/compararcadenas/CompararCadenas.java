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

package compararcadenas;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class CompararCadenas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s1 = new String("hola");
        String s2 = "adios";
        String s3 = "Feliz cumpleaños";
        String s4 = "feliz cumpleaños";
        String s5 = new String(s1);
        String s6 = s1;
        
        System.out.printf("s1 = %s\n", s1);
        System.out.printf("s2 = %s\n", s2);
        System.out.printf("s3 = %s\n", s3);
        System.out.printf("s4 = %s\n", s4);
        System.out.printf("s5 = %s\n", s5);
        System.out.printf("s6 = %s\n", s6);
        
        if(s1.equals("hola"))
        {
            System.out.println("S1 es igual a \"hola\"");
        }
        else
        {
            System.out.println("S1 no es igual a \"hola\"");
        }
        
        if(s1 == "hola")
        {
            System.out.println("S1 es igual al objeto \"hola\"");
        }
        else
        {
            System.out.println("S1 no es igual al objeto \"hola\"");
        }

        if(s1 == s5)
        {
            System.out.println("S1 es igual al objeto S5");
        }
        else
        {
            System.out.println("S1 no es igual al objeto S5");
        }
        
        if(s1 == s6)
        {
            System.out.println("S1 es igual al objeto S6");
        }
        else
        {
            System.out.println("S1 no es igual al objeto S6");
        }
        
        if(s3.equalsIgnoreCase(s4))
        {
            System.out.println("S3 es igual a s4 si se ignoran las mayúsculas");
        }
        else
        {
            System.out.println("S3 no es igual a S4");
        }
        
        System.out.printf("s1.compareTo(s2) es %d\n", s1.compareTo(s2));
        System.out.printf("s3.compareTo(s4) es %d\n", s3.compareTo(s4));
        
        
    }
    
}
