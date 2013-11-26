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
 * Diseñar un algoritmo que imprima y sume la serie de 
 * números 3, 6, 9, 12, …, 99
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio003 
{
    public void ejercicio()
    {
        int numero = 3;
        
        while (numero <=99) 
        {            
            System.out.println(numero);
            numero = numero +3;
        }       
    }
}