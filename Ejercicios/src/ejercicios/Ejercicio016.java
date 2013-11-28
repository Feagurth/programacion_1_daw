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
 *  Leer un carácter y deducir si está o no comprendido entre las 
 *  letras I y M ambas inclusive
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio016 {
    
    public void ejercicio()
    {
        char letra1;
        char[] vector = new char[]{'i', 'j', 'k', 'l', 'm'};
        boolean encontrado = false;
        int control;
        
        Scanner entrada = new Scanner(System.in);
        
        control = 0;
        
        System.out.print("Introduzca la primera letra: ");
        letra1 = entrada.nextLine().charAt(control);
        
        while ((control <= 4) && (!encontrado)) {            
            if (vector[control] == letra1) {
                encontrado = true;
            }
            control++;
        }
        
        if (encontrado) 
        {
            System.out.println("La letra introducida esta entre i y m");
        }
        else
        {
            System.out.println("La letra introducida no está entre i y m");
        }
        
    }
}
