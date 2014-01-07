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
package buscadormaximo;

import java.util.Scanner;

/**
 * Clase para buscar máximos
 *
 * @author Luis Cabrerizo Gómez
 */
public class BuscadorMaximo {

    /**
     * Método para determinar el número máximo de tres números introducidos por
     * teclado
     */
    public void determinarMaximo() {

        // Objeto para recoger datos del usuario
        Scanner entrada = new Scanner(System.in);

        // Variables
        double numero1;
        double numero2;
        double numero3;
        double resultado;

        // Lectura de datos
        System.out.print("A continuación tendrá que introducir 3 números reales."
                + "P.Ej 9,56\n");
        System.out.print("Introduzca el primer número real: ");
        numero1 = entrada.nextDouble();
        System.out.print("Introduzca el segundo número real: ");
        numero2 = entrada.nextDouble();
        System.out.print("Introduzca el tercer número real: ");
        numero3 = entrada.nextDouble();

        // Buscamos el máximo de los tres números
        resultado = maximo(numero1, numero2, numero3);

        // Imprimimos el resultado
        System.out.printf("El máximo es: %.3f\n", resultado);
    }

    /**
     * Función para determinar el máximo de tres números introducidos
     *
     * @param x Primer valor
     * @param y Segundo valor
     * @param z Tercer valor
     * @return Devuelve el número máximo de los tres valores introducidos
     */
    private double maximo(double x, double y, double z) {

        //Variable para devolver el resultado
        // Inicializamos al primer valor
        double valorMaximo = x;

        // Compraramos con el segundo valor y asignamos este si es mayor
        if (y > valorMaximo) {
            valorMaximo = y;
        }

        // Compraramos con el tercer valor y asignamos este si es mayor
        if (z > valorMaximo) {
            valorMaximo = z;
        }

        // Devolvemos el resultado
        return valorMaximo;
    }
}
