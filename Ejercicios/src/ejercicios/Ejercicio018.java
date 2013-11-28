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
 * Leer una serie de números enteros positivos distintos de 0 (el último de la 
 * serie debe ser el -99) obtener el número mayor.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio018 {
    
    public void ejercicio()
    {
        int numero, mayor = 0;
        boolean salir = false;
        Scanner entrada = new Scanner(System.in);
        
        do {            
            System.out.print("Introduzca un número (-99 para salir): ");
            numero = entrada.nextInt();
            
            if (numero > 0) 
            {
                if (mayor < numero) {
                    mayor = numero;                    
                }
            }
            if(numero == -99)
            {
                salir = true;
            }
        } while (!salir);

        System.out.println("De los números introducidos el mayor es: " + mayor);
    
    }
    
}
