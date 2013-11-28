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

/**
 * Calcular y visualizar la suma y el producto de los números pares 
 * comprendidos entre 20 y 400, ambos inclusive.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio019 {
   
    public void ejercicio()
    {
        int suma = 0;
        double producto = 1;
        boolean desbordeDouble = false;
        
        for (int i = 20; i < 400; i = i + 2) {
            
            suma = suma + i;
            producto = producto * i;
            
            // Comparación para verificar que la variable double no se desborde
            if(producto >= Double.MAX_VALUE && !desbordeDouble)
            {
                // Si la variable desborda, ponemos el control de entrada en la
                // condicional a verdadero y mostramos un mensaje de error por 
                // consola
                desbordeDouble = true;
                System.err.println("El valor de la multiplicación desborda la "
                        + "variables doble en la iteración " + i );
            }
        }
   
        System.out.println("Suma: " + suma);
        System.out.println("Multiplicación: " + producto);
    }
}
