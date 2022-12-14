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
package pruebaenum;

import java.util.EnumSet;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class PruebaEnum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Imprimir todos los libros");
        System.out.println("");
        System.out.printf("%-10s%-45s%-4s\n", "Abrev.", "Título", "Año");
        for (Libro libro : Libro.values()) {
            System.out.printf("%-10s%-45s%-4s\n", libro, libro.obtenerTitulo(), libro.obtenerACopyright());

        }

        System.out.println("");
        System.out.println("Imprimir rango de los libros");  
        System.out.println("");
        System.out.printf("%-10s%-45s%-4s\n", "Abrev.", "Título", "Año");        
        for (Libro libro : EnumSet.range(Libro.JHP6, Libro.CPPHTP4)) {
            System.out.printf("%-10s%-45s%-4s\n", libro, libro.obtenerTitulo(), libro.obtenerACopyright());
        }
    }

}
