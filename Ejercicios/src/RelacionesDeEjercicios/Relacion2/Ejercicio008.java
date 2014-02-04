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

/**
 * Escribe una aplicación que muestre los siguientes patrones por separado, uno 
 * debajo del otro. Utiliza ciclos for para generar los patrones. Todos los 
 * asteriscos (*) deben imprimirse mediante una sola instrucción de la 
 * forma System.print( ‘*’ ); la cual hace que los asteriscos se impriman uno al 
 * lado del otro. Puede utilizarse una instrucción de la forma 
 * System.out.println(); para posicionarse en la siguiente línea. Puede 
 * utilizarse una instrucción de la forma System.out.print( ‘ ’ ); para mostrar 
 * un espacio para los últimos patrones.
 * No debe haber ninguna otra instrucción de salida en el programa. 
 * [Sugerencias: los últimos dos patrones que cada línea empieza con un número 
 * apropiado de espacios en blanco]
 * (a)              (b)                (c)                   (d)
 *  *               **********          **********                      *
 *  **              *********            *********                     **
 *  ***             ********              ********                    ***
 *  ****            *******                *******                   ****
 *  *****           ******                  ******                  *****
 *  ******          *****                    *****                 ******
 *  *******         ****                      ****                *******
 *  ********        ***                        ***               ********
 *  *********       **                          **              *********
 *  **********      *                            *             **********
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio008 {
    
    public void Ejercicio()
    {
        apartadoA();
        System.out.println();
        apartadoB();
        System.out.println();
        apartadoC();
        System.out.println();
        apartadoD();    
    }
    
    /**
     * Realiza el dibujo especificado en el apartado A
     */
    private void apartadoA()
    {
        System.out.println("Apartado A");
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Realiza el dibujo especificado en el apartado B
     */
    
    private void apartadoB()
    {
        System.out.println("Apartado B");
        for (int i = 10; i >= 1; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    /**
     * Realiza el dibujo especificado en el apartado C
     */
    private void apartadoC()
    {
        System.out.println("Apartado C");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if(j >= i)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");                
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Realiza el dibujo especificado en el apartado D
     */
    private void apartadoD()
    {
        System.out.println("Apartado D");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if(j <= 10 - i)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print("*");                
                }
            }
            System.out.println();
        }
    }        
}
