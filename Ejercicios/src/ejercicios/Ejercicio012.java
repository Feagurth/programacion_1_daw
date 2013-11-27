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
 * Realiza un algoritmo que calcule la suma de los enteros entre 1 y 10, 
 * es decir 1+2+3+ … +10
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio012 {
   public void ejercicio()
   {
       int numero;
       
       numero = 0;
       
       for (int control = 0; control < 10; control++) {
           numero = numero + control;
       }
       
       System.out.println("La suma de los 10 primeros enteros es: " + numero);
   }
}
