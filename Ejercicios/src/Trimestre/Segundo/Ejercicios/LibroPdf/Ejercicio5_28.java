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

/**
 * Clase para realizar el ejercicio 5.28 del libro de texto Como Programar en
 * Java 7ed Deitel*
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_28 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        
        // Variable para contar las iteraciones
        int contador = 0;
        
        
        // Iteramos
        for (int i = 1; i <= 10; i++) {
            
            // Si se cumple la condición se realiza el cuerpo del bucle
            // Si no, se salta como si fuese un continue
            if (i != 5) {
                contador++;
            }
        }     

        // Mostramos resultados al usuario
        System.out.println("Se ha iterado " + contador + " veces");

    }     
}
