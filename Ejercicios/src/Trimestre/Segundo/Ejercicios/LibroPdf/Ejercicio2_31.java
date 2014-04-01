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
package Trimestre.Segundo.Ejercicios.LibroPdf;

import Utiles.Mensajes;

/**
 * Utilizando sólo las técnicas de programación que aprendió en este capítulo, 
 * escriba una aplicación que calcule los cuadrados y cubos de los números 
 * del 0 al 10, y que imprima los valores resultantes en formato de tabla, 
 * como se muestra a continuación. [Nota: Este programa no requiere de ningún 
 * tipo de entrada por parte del usuario].
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio2_31 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // Inicializamos el valor
        int valor = 0;
        StringBuilder resultado = new StringBuilder();

        // Concatenamos el resultado
        resultado.append(String.format("%d\t%d\t%d%n", valor, valor * valor, valor * valor * valor));

        // Cambiamos el valor y concatenamos el resultado
        valor = 1;
        resultado.append(String.format("%d\t%d\t%d%n", valor, valor * valor, valor * valor * valor));

        // Cambiamos el valor y concatenamos el resultado
        valor = 2;
        resultado.append(String.format("%d\t%d\t%d%n", valor, valor * valor, valor * valor * valor));

        // Cambiamos el valor y concatenamos el resultado
        valor = 3;
        resultado.append(String.format("%d\t%d\t%d%n", valor, valor * valor, valor * valor * valor));

        // Cambiamos el valor y concatenamos el resultado
        valor = 4;
        resultado.append(String.format("%d\t%d\t%d%n", valor, valor * valor, valor * valor * valor));

        // Cambiamos el valor y concatenamos el resultado
        valor = 5;
        resultado.append(String.format("%d\t%d\t%d%n", valor, valor * valor, valor * valor * valor));
        
        // Cambiamos el valor y concatenamos el resultado
        valor = 6;
        resultado.append(String.format("%d\t%d\t%d%n", valor, valor * valor, valor * valor * valor));

        // Cambiamos el valor y concatenamos el resultado
        valor = 7;
        resultado.append(String.format("%d\t%d\t%d%n", valor, valor * valor, valor * valor * valor));

        // Cambiamos el valor y concatenamos el resultado
        valor = 8;
        resultado.append(String.format("%d\t%d\t%d%n", valor, valor * valor, valor * valor * valor));

        // Cambiamos el valor y concatenamos el resultado
        valor = 9;
        resultado.append(String.format("%d\t%d\t%d%n", valor, valor * valor, valor * valor * valor));

        // Cambiamos el valor y concatenamos el resultado
        valor = 10;
        resultado.append(String.format("%d\t%d\t%d%n%n%n", valor, valor * valor, valor * valor * valor));

        // ó
        // Iteramos desde 1 hasta 10 y concatenamos los resultados
        for (int i = 0; i <= 10; i++) {
            resultado.append(String.format("%d\t%d\t%d%n", i, i * i, i * i * i));
        }
        
        // Mostramos el resultado
        Mensajes.mostrarMensaje(resultado.toString(), "Resultado", Mensajes.TipoMensaje.INFORMACION, true);
    }

}
