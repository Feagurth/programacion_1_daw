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
 * Leer un carácter y deducir si está situado antes o después de 
 * la ‘m’ en orden alfabético
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio014 {
    
    public void ejercicio(){
        char[] vector = new char[]{
            'a','b','c','d','e','f','g','h','i','j','k','l','m'
            };
        int control = 0;
        char letra;
        boolean encontradaLetra = false;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduzca la letra a localizar: ");
        letra = entrada.next().charAt(0);
        while (control <= 13 && !encontradaLetra)
        {
            if (vector[control] == letra) 
            {
                encontradaLetra = true;
            }
        }
        
        if (!encontradaLetra) {
            System.out.printf("La letra %c va depues de la m", letra);
        }
        else
        {
            System.out.printf("La letra %c va antes de la m", letra);
        }
    }
}
