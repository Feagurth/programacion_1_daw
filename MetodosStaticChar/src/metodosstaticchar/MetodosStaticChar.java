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

package metodosstaticchar;

import java.util.Scanner;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class MetodosStaticChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        char caracter;
        String entrada;
               
        System.out.print("Escriba un caracter y pulse intro: ");
        entrada = teclado.next();
        caracter = entrada.charAt(0);
        
        System.out.printf("Está definido: %b\n", Character.isDefined(caracter));
        System.out.printf("¿Es digito?: %b\n", Character.isDigit(caracter));
        System.out.printf("¿Es letra?: %b\n", Character.isLetter(caracter));
        System.out.printf("¿Es válido como primer caracter en Java?: %b\n", 
                Character.isJavaIdentifierStart(caracter));
        
        System.out.printf("¿Es letra o digito?: %b\n", Character.isLetterOrDigit(caracter));
        
        
        
    }
    
}
