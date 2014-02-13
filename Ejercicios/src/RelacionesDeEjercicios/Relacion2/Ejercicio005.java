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
package RelacionesDeEjercicios.Relacion2;

import java.util.Scanner;

/**
 * Calcula el valor de PI a partir de la serie infinita 4 - 4/3 + 4/5 - 4/7 +
 * 4/9 - 4/11 + ...
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio005 {

    public void Ejercicio() {
        // Objeto para leer información desde el teclado
        Scanner entrada = new Scanner(System.in);

        // Variables
        int iteraciones;
        float valorPi = 0;
        boolean controlSuma = true;
        int controlSalida = 3;

        do {
            // Pedimos al usuario el número de iteraciones para calcular el valor 
            // de pi
            System.out.print("Introduzca el número de iteraciones a realizar para "
                    + "calcular el valor de PI: ");
            iteraciones = entrada.nextInt();
        } while (iteraciones <= 0);

        // Iteramos desde 1 hasta el numero de iteraciones multiplicada por 2
        // con incremento de 2. Esto nos permite realizar tantas operaciones
        // como quiere el usuario, mientras que el valor de i será el de todos
        // los números impares que queramos
        for (int i = 1; i < iteraciones * 2; i += 2) {

            // Comprobamos si tenemos que sumar o restar
            if (controlSuma) {
                valorPi += (4f / i);
            } else {
                valorPi -= (4f / i);
            }
            // Preparamos la variable para que en la siguiente iteración
            // realize la operación contraria a la actual
            controlSuma = !controlSuma;            
        }

        // Mostramos el resultado al usuario
        System.out.println("El valor final es: " + valorPi);
    }
}
