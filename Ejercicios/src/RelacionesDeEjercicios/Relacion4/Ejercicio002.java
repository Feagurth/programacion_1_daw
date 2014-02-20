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
 * Construir las expresiones regulares para: 
 * a) El objeto String contiene exactamente el patrón “abc” 
 * b) El objeto String contiene “abc” 
 * c) El objeto String empieza por “abc” 
 * d) El objeto String empieza por “Abc” o por “abc” 
 * e) Comprobar si el String cadena empieza por un mínimo de letras mayúsculas 
 * o minúsculas y un máximo de 10
 * f) Comprobar si el String cadena empieza por un dígito 
 * g) Comprobar si el String cadena no termina con un dígito 
 * h) Comprobar si el String cadena sólo contiene los caracteres a ó b 
 * i) Comprobar que si el String cadena contiene un 1, no vaya seguido por un 2 
 * 
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio002 {
    
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
        System.out.println("a) El objeto String contiene exactamente el patrón “abc”");
        System.out.println("========================================================");
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "abc";
                
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
        System.out.println("");

        System.out.println("b) El objeto String contiene “abc”");
        System.out.println("=================================");
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = ".*abc.*";
                
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
        System.out.println("");

        System.out.println("c) El objeto String empieza por “abc”");
        System.out.println("====================================");
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "^abc.*";
                
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
        System.out.println("");

        System.out.println("d) El objeto String empieza por “Abc” o por “abc”");
        System.out.println("================================================");
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "^[Aa]bc.*";
                
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
        System.out.println("");

        System.out.println("Comprobar si el String cadena empieza por un mínimo "
                + "de letras mayúsculas o minúsculas y un máximo de 10");
        System.out.println("==================================================="
                + "====================================================");

        // Variable para almacenar la cantidad mínima de letras mayusculas y 
        // minúsculas
        String digito;
        
        do
        {
            System.out.print("Introduzca un número para definir la cantidad "
                    + "mínima de mayusculas o minusculas: ");
            digito = entrada.nextLine();        
        }while(!digito.matches("[1-9]|([1-9][0-9]*)"));
        
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "^[A-Za-z]{" + digito + ",10}[0-9 ]+.*";
                
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
        
        // Apartado f
        System.out.println("");

        System.out.println("Comprobar si el String cadena empieza por un dígito");
        System.out.println("===================================================");
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "^[0-9]+.*";
                
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
        
        // Apartado g
        System.out.println("");

        System.out.println("Comprobar si el String cadena no termina con un "
                + "dígito");
        System.out.println("================================================"
                + "======");
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = ".*[a-zA-Z ]$";
                
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
        
        // Apartado h
        System.out.println("");

        System.out.println("Comprobar si el String cadena sólo contiene los "
                + "caracteres a ó b");
        System.out.println("================================================"
                + "================");
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "[a|b]*";
                
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
        
        
        // Apartado i
        System.out.println("");

        System.out.println("Comprobar que si el String cadena contiene un 1, "
                + "no vaya seguido por un 2");
        System.out.println("================================================="
                + "========================");
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "^((?!12).)*$";
                
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
