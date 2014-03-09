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
 * Clase para realizar el ejercicio 4.22 del libro de texto
 * Como Programar en Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_22 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Creamos una cadena, la cual inicializaremos con los primeros valores
        // para crear una represetanción por columnas separadas por tabulaciones
        String resultado = "N\t\t10 * N\t\t100 * N\t\t1000 * N\n";
        
        // Iteramos añadiendo a la cadena resultado los valores calculados
        for (int i = 1; i < 6; i++) {
            resultado += i + "\t\t" + 10 * i  + "\t\t" + 100 * i + "\t\t" + 1000 * i + "\n";
        }

        // Mostramos los resultados
        System.out.println(resultado);
    }    
}
