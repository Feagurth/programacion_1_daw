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

package comparacion;

import java.util.Scanner;


/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Comparacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero1, numero2;

        System.out.print("Escribe el primer entero: ");
        numero1 = entrada.nextInt();
        System.out.print("Escribe el segundo entero: ");
        numero2 = entrada.nextInt();
        
        if (numero1 > numero2) 
        {
            System.out.printf("%d > %d\n", numero1, numero2);
        }
        else 
            if (numero1 < numero2)
            {
                System.out.printf("%d < %d\n", numero1, numero2);
            }
            else
            {
                System.out.printf("%d = %d\n", numero1, numero2);
            }
        }
}
