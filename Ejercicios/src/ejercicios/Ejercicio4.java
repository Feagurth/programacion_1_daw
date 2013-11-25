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
 * Escribir un algoritmo que lea cuatro números y, a continuación, escriba el mayor de los cuatro.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4 
{
    public void ejercicio4()
    {
        int numero1, numero2, numero3, numero4;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduzca un valor para el número 1: ");
        numero1 = entrada.nextInt();
        System.out.print("Introduzca un valor para el número 2: ");
        numero2 = entrada.nextInt();
        System.out.print("Introduzca un valor para el número 3: ");
        numero3 = entrada.nextInt();
        System.out.print("Introduzca un valor para el número 4: ");
        numero4 = entrada.nextInt();
        
        if (numero1 > numero2) 
        {
            if (numero1 > numero3) 
            {
                if(numero1 > numero4)
                {
                    System.out.println("El numero mayor es: " + numero1);
                }
                else
                {
                    System.out.println("El numero mayor es: " + numero4);
                }
            }
            else
            {
                if (numero3 > numero4) 
                {
                    System.out.println("El numero mayor es: " + numero3);
                }
                else
                {
                    System.out.println("El numero mayor es: " + numero4);
                }
            }
        }
        else
        {
            if(numero2 > numero3)
            {
                if(numero2 > numero4)
                {
                    System.out.println("El numero mayor es: " + numero2);
                }
                else
                {
                    System.out.println("El numero mayor es: " + numero4);
                }
            }
            else
            {
                if(numero3 > numero4)
                {
                    System.out.println("El numero mayor es: " + numero3);
                }
                else
                {
                    System.out.println("El numero mayor es: " + numero4);
                }
            }               
        }
    }
}
