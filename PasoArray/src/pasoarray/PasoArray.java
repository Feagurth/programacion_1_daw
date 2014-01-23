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

package pasoarray;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class PasoArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5};
        
        System.out.println("Efectos de pasar una referencia a un array completo");
        System.out.println("Los valores del array original son");

        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.println("");
        modificarArray(array);
        
        for (int valor: array) {
            System.out.printf("%d ", valor);
        }
        System.out.println("");
        System.out.println("Efectos de pasar el valor de un elemento del array");
        System.out.printf("array[3] antes de moficiar el elemento: %d\n", array[3]);
        modificarElemento(array[3]);
        System.out.printf("array[3] despues de moficiar el elemento: %d\n", array[3]);
        
    }

    private static void modificarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;            
        }
    }
    
    public static void modificarElemento(int elemento)
    {
        elemento *= 2;
        System.out.printf("Valor elemento modificado: %d\n", elemento);
    
    }
    
}
