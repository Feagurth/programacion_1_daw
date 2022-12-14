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
package divisionentrecerosinmanejodeexcepciones;

import java.util.Scanner;

/**
 *
 * @author Super
 */
public class DivisionEntreCeroSinManejoDeExcepciones {

    public static int cociente(int numerador, int denominador) {

        return numerador / denominador;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Introduzca el numerador: ");
        int numerador = entrada.nextInt();

        System.out.print("Introduzca el denominador: ");
        int denominador = entrada.nextInt();

        int resultado = cociente(numerador, denominador);

        System.out.printf("%nResultado: %d / %d = %d%n", numerador, denominador, resultado);

    }

}
