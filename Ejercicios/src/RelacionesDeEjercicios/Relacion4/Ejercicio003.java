/*
 * Copyright (C) 2014 Luis Cabrerizo Gómez
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

package RelacionesDeEjercicios.Relacion4;

import java.util.Scanner;

/**
 * Crear expresiones regulares para validar: 
 * a) Hora. Ten en cuenta los diferentes tipos de hora 
 * b) Tarjeta de crédito 
 * c) Número de teléfono. Ten en cuenta si el número es o no internacional 
 * d) Código postal 
 * e) CIF 
 * f) Números enteros 
 * g) Números reales
 * h) Dirección MAC o dirección física (suponemos que cada pareja de números 
 * hexadecimales van separados por “:”). Por ejemplo 00:54:56:01:00:A0 
 * (podría ser también 00-54-56-01-00-A0)
 * i) Etiqueta img del lenguaje HTML. Nota: consultar el lenguaje HTML para 
 * observar la estructura sintáctica de dicha etiqueta. 
 * 
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio003 {
    
    public void Ejercicio()
    {
        // Objeto pare pedir datos al usuario por teclado
        Scanner entrada = new Scanner(System.in);
    
        // Variable para almacenar las distitnas expresiones regulares que 
        // usaremos para validar los datos
        String expresionRegular;
        
        // Variable para almacenar los valores que introducirá el usuario por 
        // teclado
        String cadena;
                
        // Apartado a
        System.out.println("a) Hora. Ten en cuenta los diferentes tipos de hora");
        System.out.println("===================================================");
        
        // Definimos la expresión regular que necesitamos
        // Validación de horas formato 24 horas HH:MM o h:m
        expresionRegular = "(^(0?[0-9]|1[0-9]|2[0-3]):(0?[0-9]|[1-5][0-9]|60)$)";
        
        // Validación de horas formato 12 horas HH:mm am/pm o h:m am/pm
        expresionRegular += "|" + "(^(0?[1-9]|1[0-2]):(0?[0-9]|[1-5][0-9]|60)\\s?(([aA][mM])|[pP][mM])?$)";
                
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            System.out.print("Introduzca un valor para probar la expresión "
                    + "regular: ");
            cadena = entrada.nextLine();

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));    
        
        
        // Apartado b
        System.out.println("b) Tarjeta de crédito");
        System.out.println("=====================");
        
        // Definimos la expresión regular que necesitamos
        // Tarjetas de credito de 13 a 16 números sin guiones ni espacios en blanco
        expresionRegular = "(^[0-9]{13,16}$)";        
        
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            System.out.print("Introduzca un valor para probar la expresión "
                    + "regular: ");
            cadena = entrada.nextLine();

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));            
        
        // Apartado c
        System.out.println("c) Número de teléfono. Ten en cuenta si el número "
                + "es o no internacional");
        System.out.println("=================================================="
                + "=====================");
        
        // Definimos la expresión regular que necesitamos
        // Validación de número de telefono para los siguientes formatos
        // numero de 9 cifras
        // +(xx)xxxxxxxxx  +(xx) xxxxxxxxx
        // (xx)xxxxxxxxx    (xx) xxxxxxxxx
        // +xxxxxxxxxxx    +xx xxxxxxxxx
        // xxxxxxxxxxx      xx xxxxxxxxx
        // xxxxxxxxx
        expresionRegular = "((\\+)?(\\()?[0-9]{0,2}(\\))?)?( )?[0-9]{9}";
        
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            System.out.print("Introduzca un valor para probar la expresión "
                    + "regular: ");
            cadena = entrada.nextLine();

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));                    
        
        
        // Apartado d
        System.out.println("d) Código postal");
        System.out.println("================");
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "^[0-9]{5}$";        
        
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            System.out.print("Introduzca un valor para probar la expresión "
                    + "regular: ");
            cadena = entrada.nextLine();

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));                    
        
        
        // Apartado e
        System.out.println("e) CIF");
        System.out.println("======");
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "^[0-9]{5}$";        
        
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            System.out.print("Introduzca un valor para probar la expresión "
                    + "regular: ");
            cadena = entrada.nextLine();

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));                            
        
    }
    
}
