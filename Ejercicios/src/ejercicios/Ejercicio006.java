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
 * Diseñar un algoritmo para determinar si un número n es primo. 
 * (Un número primo sólo es divisible por el mismo y por la unidad).
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio006 {
    
    public void ejercicio()
    {
        int numero, contador = 2;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduzca un número para saber si es primo: ");
        numero = entrada.nextInt();
        
        while((numero % contador) != 0) 
        {            
            contador++;
        }
        
        if (contador < numero) 
        {
            System.out.println(numero + " no es primo");
        }
        else
        {
            System.out.println(numero + " es primo");
        }        
    }
    
}
