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

package pruebatoken;

import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class PruebaToken {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String enunciado;
        
        System.out.print("Escribe un enunciado y pulse Enter: ");
        enunciado = teclado.nextLine();
        
        StringTokenizer palabraTokens = new StringTokenizer(enunciado);
        
        System.out.println("Cantidad de palabras: " + palabraTokens.countTokens());
        System.out.print("Los Tokens son: ");
        
        while (palabraTokens.hasMoreTokens()) {            
            System.out.println(palabraTokens.nextToken());            
        }
            
        
    }
    
}
