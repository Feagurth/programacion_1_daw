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
 * Escribir un algoritmo que lea un valor entero, lo doble, se multiplique 
 * por 25 y  * visualice el resultado
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio8 {
    
    public void ejercicio()
    {
        int numero;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduce un número: ");
        numero = entrada.nextInt();
        
        System.out.println("El resultado de doblar el número " + numero +
                " y multiplicarlo por 25 es: " + numero * 50);
        
        
    
    }
    
}
