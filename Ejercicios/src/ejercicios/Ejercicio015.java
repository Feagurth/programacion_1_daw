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
 * Ejercicio 15: Leer dos caracteres y deducir si están en orden alfabético
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio015 
{
    
    public void ejercicio()
    {
    
        char[] vector = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char letra1, letra2;
        int control, posLetra1 = 0, posLetra2 = 0;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduzca la primera letra: ");
        letra1 = entrada.nextLine().charAt(0);

        System.out.print("Introduzca la segunda letra: ");
        letra2 = entrada.nextLine().charAt(0);

        control = 0;
        
        while (control <27) 
        {            
            if(vector[control] == letra1)
            {
                posLetra1 = control;
            }
            
            if(vector[control] == letra2)
            {
                posLetra2 = control;
            }
            control++;
        }
        
        if(posLetra1 < posLetra2)
        {
            System.out.println("Están ordenadas alfabeticamente");
        }
        else
        {
            System.out.println("No están ordenadas alfabeticamente");
        }

        
    }
    
}
