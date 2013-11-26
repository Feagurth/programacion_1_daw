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
 * Diseñar un algoritmo para calcular la velocidad (en metros/segundo) de 
 * los corredores de una carrera de 1500m. La entrada serán las parejas 
 * (minutos, segundos) que darán el tiempo para cada corredor. Por cada 
 * corredor, se imprimirá el tiempo en minutos y segundos, así como la 
 * velocidad media. El bucle se ejecutará hasta que demos una entrada 0,0 que 
 * será la marca de fin de entrada de datos. Imprimir también el nombre del 
 * corredor.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio005 
{
    public void ejercicio()
    {
        int RECORRIDO = 1500;
        String nombre;
        int minutos, segundos;
        double media;
        Scanner entrada;
        
        entrada = new Scanner(System.in);
        System.out.print("Introduzca el nombre del corredor: ");
        nombre = entrada.nextLine();
        System.out.print("Introduzca la cantidad de minutos para el corredor: ");
        minutos = entrada.nextInt();
        System.out.print("Introduzca la cantidad de segundos para el corredor: ");
        segundos = entrada.nextInt();
        
        while (segundos != 0 || minutos != 0) 
        {            
            System.out.println(nombre);
            System.out.println(minutos);
            System.out.println(segundos);
            
            segundos = segundos + (minutos * 60);
            media = (RECORRIDO / (double)segundos);
            
            System.out.println("Su media es de : " + media);
            
            entrada = new Scanner(System.in);
            
            System.out.print("Introduzca el nombre del corredor: ");
            nombre = entrada.nextLine();
            System.out.print("Introduzca la cantidad de minutos para el corredor: ");
            minutos = (int)entrada.nextInt();
            System.out.print("Introduzca la cantidad de segundos para el corredor: ");
            segundos = (int)entrada.nextInt();
        }
    }
}
