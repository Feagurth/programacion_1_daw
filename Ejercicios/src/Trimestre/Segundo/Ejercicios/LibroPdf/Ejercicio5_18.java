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
 * Clase para realizar el ejercicio 5.18 del libro de texto Como Programar en
 * Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_18 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        int monto; // Monto depositado al final de cada año
        int principal = 1000; // monto inicial antes de los intereses
        int tasa = 5; // tasa de interés

        // muestra los encabezados
        System.out.printf("s%20s\n", "Anio", "Monto en deposito");
        
        // calcula el monto en deposito para cada uno de diez años
        for (int anio = 1; anio <= 10; anio++) 
        {
            // calcula el nuevo monto para el año especificado
            monto = (int)(principal * (Math.pow(1 + (tasa /100f), anio) * 100));
            
            // muestra el año y el monto
            System.out.printf("%4d%,20.2f\n", anio, (float)monto/100);
        }

    }

}
