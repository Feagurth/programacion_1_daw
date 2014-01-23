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

package tirardado2;

import java.util.Random;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class TirarDado2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random numerosAleatorios = new Random();

        int frecuencia[] = new int[7];
         
        for (int tiro = 0; tiro < 6000; tiro++) {
            frecuencia[1 + numerosAleatorios.nextInt(6)]++;
        }
        
        System.out.println("Cara\tFrecuencia");
        for (int cara = 1; cara < frecuencia.length; cara++) {
            System.out.println(cara + "\t" + frecuencia[cara]);
            
        }
    }
    
}
