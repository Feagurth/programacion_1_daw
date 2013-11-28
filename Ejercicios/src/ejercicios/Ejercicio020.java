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
 * Leer 500 números enteros y obtener cuántos son positivos
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio020 {
    
    public void ejercicio()
    {
        int entero, contador = 0, numPositivos = 0;
        Scanner entrada = new Scanner(System.in);
        
        do {
            contador++;
            System.out.print("Introduzca un número: ");
            entero = entrada.nextInt();
            
            if(entero > 0)
            {
                numPositivos++;
            }
        } while (contador < 500);
        
        System.out.println("La cantidad de números positivos es: " + numPositivos);
    
    }
    
}
