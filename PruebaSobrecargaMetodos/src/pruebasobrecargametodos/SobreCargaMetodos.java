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
package pruebasobrecargametodos;

/**
 * Clase para probar la sobrecarga de métodos
 *
 * @author Luis Cabrerizo Gómez
 */
public class SobreCargaMetodos {

    /**
     * Método para probar las sobrecargas
     */
    public void probarMetodosSobrecargados() {
        
        // Mostramos información al usuario y llamamos a las funciones
        // que calculan el cuadrado correspondiente
        System.out.printf("El cuadrado del entero 7 es %d\n", cuadrado(7));        
        System.out.printf("El cuadrado del double 7.5 es %f\n", cuadrado(7.5));
        
    }

    /**
     * Calcula el cuadrado de un número
     * @param valorInt Valor del número a calcular
     * @return Cuadrado del número introducido
     */
    public int cuadrado(int valorInt) {
        
        // Mostramos información al usuario
        System.out.printf("\nSe llamó a cuadrado con argumento int : %d\n",
                valorInt);

        // Devolvemos el cuadrado del valor introducido
        return valorInt * valorInt;
    }

    /**
     * Calcula el cuadrado de un número
     * @param valorDouble Valor del número a calcular
     * @return Cuadrado del número introducido
     */
    public double cuadrado(double valorDouble) {
        
        // Mostramos información al usuario
        System.out.printf("\nSe llamó a cuadrado con argumento double : %f\n",
                valorDouble);

        // Devolvemos el cuadrado del valor introducido
        return valorDouble * valorDouble;
    }

}
