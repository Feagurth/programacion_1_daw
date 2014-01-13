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
package Trimestre.Primero.Ejercicios.LibroPdf;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio2_31 {

    public void Ejercicio() {

        // Inicializamos el valor
        int valor = 0;

        // Imprimimos el resultado 
        System.out.printf("%d\t%d\t%d", valor, valor * valor, valor * valor * valor);
        System.out.println();

        // Cambiamos el valor e imprimimos el resultado
        valor = 1;
        System.out.printf("%d\t%d\t%d", valor, valor * valor, valor * valor * valor);
        System.out.println();

        // Cambiamos el valor e imprimimos el resultado
        valor = 2;
        System.out.printf("%d\t%d\t%d", valor, valor * valor, valor * valor * valor);
        System.out.println();

        // Cambiamos el valor e imprimimos el resultado
        valor = 3;
        System.out.printf("%d\t%d\t%d", valor, valor * valor, valor * valor * valor);
        System.out.println();

        // Cambiamos el valor e imprimimos el resultado
        valor = 4;
        System.out.printf("%d\t%d\t%d", valor, valor * valor, valor * valor * valor);
        System.out.println();

        // Cambiamos el valor e imprimimos el resultado
        valor = 5;
        System.out.printf("%d\t%d\t%d", valor, valor * valor, valor * valor * valor);
        System.out.println();

        // Cambiamos el valor e imprimimos el resultado
        valor = 6;
        System.out.printf("%d\t%d\t%d", valor, valor * valor, valor * valor * valor);
        System.out.println();

        // Cambiamos el valor e imprimimos el resultado
        valor = 7;
        System.out.printf("%d\t%d\t%d", valor, valor * valor, valor * valor * valor);
        System.out.println();

        // Cambiamos el valor e imprimimos el resultado
        valor = 8;
        System.out.printf("%d\t%d\t%d", valor, valor * valor, valor * valor * valor);
        System.out.println();

        // Cambiamos el valor e imprimimos el resultado
        valor = 9;
        System.out.printf("%d\t%d\t%d", valor, valor * valor, valor * valor * valor);
        System.out.println();

        // Cambiamos el valor e imprimimos el resultado
        valor = 10;
        System.out.printf("%d\t%d\t%d", valor, valor * valor, valor * valor * valor);
        System.out.println();

        // ó
        System.out.println();
        System.out.println();
        
        // Iteramos desde 1 hasta 10 y mostramos los resultados
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d\t%d\t%d", i, i * i, i * i * i);
            System.out.println();
        }
    }

}
