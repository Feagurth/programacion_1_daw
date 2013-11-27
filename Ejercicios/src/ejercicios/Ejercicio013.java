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

package ejercicios;

/**
 * Realizar un algoritmo que calcule y visualice las potencias de 2 entre 0 y 10
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio013 {
    
    public void ejercicio(){
        for (int i = 0; i < 11; i++) {
            System.out.println("La potencia de dos de " + i + " es :" + 
                    (int)Math.pow(2,i));
        }
        
    }
    
}
