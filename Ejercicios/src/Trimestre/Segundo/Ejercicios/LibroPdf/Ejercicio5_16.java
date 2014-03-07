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

package Trimestre.Segundo.Ejercicios.LibroPdf;

import Utiles.PeticionDatos;

/**
 * Clase para realizar el ejercicio 5.16 del libro de texto Como Programar en
 * Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_16 {
    
    public void Ejercicio()
    {
        // Variable para almacenar el numero elegido por el usuario
        int numero;
        
        // Variable para mostrar el resultado
        String resultado;
                
        // Iteramos tantas veces como números vamos a pedir al usuario
        for (int i = 0; i < 5; i++) {
            
            // Pedimos el número al usuario
            numero = PeticionDatos.pedirEnteroRango("Introduzca un número entre 1 y 20", 1, 20);
                    
            // Inicializamos la variable para que no acumule valores del número
            // anterior
            resultado = "";
            
            // Iteramos hasta llegar al número selecionado por el usuario
            for (int j = 0; j < numero; j++) {
                resultado +=  "*";                
            }
            
            // Mostramos el resultado
            System.out.println(resultado);            
        }
    }
}
