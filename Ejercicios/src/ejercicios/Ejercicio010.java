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
 * Diseñar un programa que lea el peso de un hombre en libras y nos devuelva su peso 
 * en kilogramos y gramos (Nota: una libra equivale a 0,453592 kilogramos)
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio010 {
    
    public void ejercicio()
    {
        final double LIBRA = 0.453592;
    
        double peso;
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduzca el peso en libras: ");
        peso = entrada.nextDouble();
        
        peso = peso * LIBRA;
        System.out.println("El peso en kgs es: " + peso);
        System.out.println("El peso en gramos es: " + peso * 1000);        
    }
    
}
