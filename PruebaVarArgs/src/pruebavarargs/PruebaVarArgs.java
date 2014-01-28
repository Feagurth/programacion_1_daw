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
package pruebavarargs;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class PruebaVarArgs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double d1 = 10.0;
        double d2 = 20.0;
        double d3 = 30.0;
        double d4 = 40.0;

        System.out.printf("d1 = %.1f\nd2 = %.1f\nd3 = %.1f\nd4 = %.1f\n",
                d1, d2, d3, d4);

        System.out.printf("El promedio de d1 y d2 es %.1f\n", promedio(d1, d2));
        System.out.printf("El promedio de d1, d2 y d3 es %.1f\n", promedio(d1, d2, d3));
        System.out.printf("El promedio de d1, d2, d3 y d4 es %.1f\n", promedio(d1, d2, d3, d4));
    }

    public static double promedio(double... numeros) {
        double total = 0f;
        
        for (double numero : numeros) {
            total += numero;
        }
        
        total /=  numeros.length;
        
        return total;
    }
}
