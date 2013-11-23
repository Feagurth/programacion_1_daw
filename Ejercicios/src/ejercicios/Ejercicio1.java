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
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio1 
{

    /*
    Escribir un algoritmo para determinar el máximo común divisor de dos números enteros por
    el algoritmo de Euclides
    */
    public static void ejercicio1()
    {
        int valor1, valor2, resto;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduzca el valor1: ");
        valor1 = entrada.nextInt();
        System.out.print("Introduzca el valor2: ");
        valor2 = entrada.nextInt();
                
        while (valor1 % valor2 != 0) 
        {            
            resto = valor1 % valor2;
            valor1 = valor2;
            valor2 = resto;
        }
        
        System.out.printf("El maximo común divisor es: %d", valor1);
     }
    
    
}
