/*
 * Copyright (C) 2013 Luis Cabrerizo Gómez
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

package ejercicios;

import java.util.Scanner;

/**
 * Diseñar un algoritmo que lea cuatro variables y calcule e imprima su 
 * producto, su suma y su media aritmética
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio009 {
    
    public void ejercicio()
    {
        int a, b, c, d;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduzca el valor para a: ");
        a = entrada.nextInt();
        System.out.print("Introduzca el valor para b: ");
        b = entrada.nextInt();
        System.out.print("Introduzca el valor para c: ");
        c = entrada.nextInt();
        System.out.print("Introduzca el valor para d: ");
        d = entrada.nextInt();
        
        System.out.println("El producto de las variables es: " + (a * b * c * d));
        System.out.println("La suma de las variables es: " + (a + b + c + d));
        System.out.println("Su media arimética es: " + ((a + b + c + d)/(float)4));
    
    }
}
