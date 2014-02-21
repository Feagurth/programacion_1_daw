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
 * Crear un programa que valide la autenticación de un usuario. Es decir, 
 * debéis validar tanto el nombre de usuario como su contraseña. Por tanto las 
 * entradas del programa serían Usuario y Contraseña. 
 * a. Usuario: debe ser un nombre de persona válido 
 * b. Contraseña segura. Debe tener entre 8 y 10 caracteres, por lo menos un 
 * dígito y un alfanumérico, y no puede contener caracteres espaciales. 
 * 
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio005 {

    
    public void Ejercicio()
    {
        // Objeto pare pedir datos al usuario por teclado
        Scanner entrada = new Scanner(System.in);
    
        // Variable para almacenar las distitnas expresiones regulares que 
        // usaremos para validar los datos
        String expresionRegular;
        
        // Variables para almacenar los valores que introducirá el usuario por 
        // teclado
        String usuario;
        String password;
                
        // Definimos la expresión regular que necesitamos para validar el usuario
        // Validamos usuarios con una letra inicial y entre 5 o 15 caracteres más
        // quedando un nombre de usuario entre 8 y 16 letras
        expresionRegular = "^[a-zA-Z]{1}[a-zA-Z0-9_]{7,15}$";
                
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            System.out.print("Introduzca el nombre de usuario: ");
            usuario = entrada.nextLine();

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!usuario.matches(expresionRegular));
        
        
        // Definimos la expresión regular que necesitamos para validar el usuario
        expresionRegular = "^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{8,10}$";
                
        // Iteramos hasta que se cumpla la validación
        do
        {
            // Pedimos datos al usuario
            System.out.println("Entre 8 y 10 caracteres, por lo menos un dígito "
                    + "y un alfanumérico, y no puede contener caracteres "
                    + "espaciales.");
            System.out.print("Introduzca el password: ");
            password = entrada.nextLine();

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        }while(!password.matches(expresionRegular));        
        
        System.out.println("Usuario: " + usuario);
        System.out.println("Password: " + password);
    
    }
    
}
