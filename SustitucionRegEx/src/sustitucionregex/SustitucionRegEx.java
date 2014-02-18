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

package sustitucionregex;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class SustitucionRegEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String primeraCadena = "Este enunciado termina con 5 estrellas *****";
        String SegundaCadena = "1, 2, 3, 4, 5, 6, 7, 8";

        
        System.out.printf("Cadena 1 original: %s\n", primeraCadena);
        primeraCadena = primeraCadena.replaceAll("[*]", "^");   
        System.out.printf("Cadena 1 modificada: %s\n", primeraCadena);
        primeraCadena = primeraCadena.replaceAll("estrellas", "circunflejos");   
        System.out.printf("Cadena 1 modificada: %s\n", primeraCadena);
        primeraCadena = primeraCadena.replaceAll("[a-zA-Z0-9]+", "palabra");   
        System.out.printf("Cadena 1 modificada: %s\n", primeraCadena);
        
        System.out.println("");
        System.out.printf("Cadena 2 original: %s\n", SegundaCadena);

        for (int i = 0; i < 3; i++) {
            SegundaCadena = SegundaCadena.replaceFirst("[0-9]", "digito");
        }

        System.out.printf("Cadena 2 modificada: %s\n", SegundaCadena);

        String[] Resultados = SegundaCadena.split(",\\s");
                
        for (String cadena : Resultados) {
            System.out.println(cadena);
        }
    }
}
