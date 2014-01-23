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

package encuestaestudiantes;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class EncuestaEstudiantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int respuestas[] = {1, 2, 6, 4, 8, 5, 9, 7, 8, 10, 1, 6, 3, 8, 6, 10, 
            3, 8, 2, 7, 6, 5, 7, 6, 8, 6, 7, 5, 6, 6, 5, 6, 7, 5, 6, 4, 8, 6, 
            8, 10};
        
        int frecuencia[] = new int[11];
        
        for (int i = 0; i < respuestas.length; i++) {
            frecuencia[respuestas[i]]++;
        }
        
        System.out.println("Calificación\tFrecuencia");
        
        for (int i = 1; i < frecuencia.length; i++) {
            System.out.printf("%12d\t%10d\n", i, frecuencia[i]);
        }
    }
}
