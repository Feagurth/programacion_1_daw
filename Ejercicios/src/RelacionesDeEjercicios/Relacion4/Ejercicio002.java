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

import Utiles.PeticionDatos;

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
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
    
        // Variable para almacenar las distitnas expresiones regulares que 
        // usaremos para validar los datos
        String expresionRegular;
        
        // Variable para almacenar los valores que introducirá el usuario por 
        // teclado
        String cadena;
        String apoyo;
                
        // Apartado a
        apoyo = "a) El objeto String contiene exactamente el patrón “abc”";
        apoyo += "\n====================================================";
        apoyo += "\nIntroduzca un valor para probar la expresión regular";
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "abc";
                
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            cadena = PeticionDatos.pedirCadenaNumeroSimbolos(apoyo);

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));
    
        // Apartado b

        apoyo = "b) El objeto String contiene “abc”";
        apoyo += "\n==============================";
        apoyo += "\nIntroduzca un valor para probar la expresión regular";

        
        // Definimos la expresión regular que necesitamos
        expresionRegular = ".*abc.*";
                
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            cadena = PeticionDatos.pedirCadenaNumeroSimbolos(apoyo);

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));

        
        // Apartado c
        apoyo = "c) El objeto String empieza por “abc”";
        apoyo += "\n==================================";
        apoyo += "\nIntroduzca un valor para probar la expresión regular";
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "^abc.*";
                
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            cadena = PeticionDatos.pedirCadenaNumeroSimbolos(apoyo);

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));        
        
        // Apartado d
        apoyo = "d) El objeto String empieza por “Abc” o por “abc”";
        apoyo += "\n=============================================";
        apoyo += "\nIntroduzca un valor para probar la expresión regular";

        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "^[Aa]bc.*";
                
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            cadena = PeticionDatos.pedirCadenaNumeroSimbolos(apoyo);
            
            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));        
        
        // Apartado e
        apoyo = "e) Comprobar si el String cadena empieza por un mínimo de letras "
                + "mayúsculas o minúsculas y un máximo de 10";
        apoyo += "\n=========================================================="
                + "=============================================";
        apoyo += "\nIntroduzca un valor para probar la expresión regular";

        
        // Variable para almacenar la cantidad mínima de letras mayusculas y 
        // minúsculas
        String digito;
        
        do
        {
            digito = PeticionDatos.pedirCadenaSoloNumeros("Introduzca un número "
                    + "para definir la cantidad mínima de mayusculas o "
                    + "minusculas");
        }while(!digito.matches("[1-9]|([1-9][0-9]*)"));
        
        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "^[A-Za-z]{" + digito + ",10}[0-9 ]+.*";
                
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            cadena = PeticionDatos.pedirCadenaNumeroSimbolos(apoyo);

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));                
        
        // Apartado f
        apoyo = "f) Comprobar si el String cadena empieza por un dígito";
        apoyo += "\n===================================================";
        apoyo += "\nIntroduzca un valor para probar la expresión regular";

        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "^[0-9]+.*";
                
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            cadena = PeticionDatos.pedirCadenaNumeroSimbolos(apoyo);

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));                
        
        // Apartado g
        apoyo = "g) Comprobar si el String cadena no termina con un dígito";
        apoyo += "\n======================================================";
        apoyo += "\nIntroduzca un valor para probar la expresión regular";


        // Definimos la expresión regular que necesitamos
        expresionRegular = ".*[a-zA-Z ]$";
                
        // Iteramos hasta que se cumpla la validación
        do
        {
            cadena = PeticionDatos.pedirCadenaNumeroSimbolos(apoyo);

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));                        
        
        // Apartado h
        apoyo = "h) Comprobar si el String cadena sólo contiene los caracteres a ó b";
        apoyo += "\n================================================================";
        apoyo += "\nIntroduzca un valor para probar la expresión regular";

        
        // Definimos la expresión regular que necesitamos
        expresionRegular = "[a|b]*";
                
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            cadena = PeticionDatos.pedirCadenaNumeroSimbolos(apoyo);

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));                                
        
        
        // Apartado i
        apoyo = "i) Comprobar que si el String cadena contiene un 1, no vaya seguido por un 2";
        apoyo += "\n=========================================================================";
        apoyo += "\nIntroduzca un valor para probar la expresión regular";

        // Definimos la expresión regular que necesitamos
        expresionRegular = "^((?!12).)*$";
                
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            cadena = PeticionDatos.pedirCadenaNumeroSimbolos(apoyo);

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!cadena.matches(expresionRegular));                                                
    }    
}
