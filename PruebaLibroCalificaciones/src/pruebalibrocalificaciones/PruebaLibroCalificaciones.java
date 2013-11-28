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

package pruebalibrocalificaciones;

/**
 * Clase para probar LibroCalificacioes
 * @author Luis Cabrerizo Gómez
 */
public class PruebaLibroCalificaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LibroCalificaciones miLibroCalificaciones1 = new LibroCalificaciones(
                            "CS01 Introducción a la programación en Java");
        
        LibroCalificaciones miLibroCalificaciones2 = new LibroCalificaciones(
                            "CS02 Estructuras de datos en Java");


        System.out.printf("El nombre del curso de libro de calificaciones1"
                + "es : %s\n", miLibroCalificaciones1.obtenerNombreCurso());
        
        System.out.printf("El nombre del curso de libro de calificaciones2"
                + "es : %s\n", miLibroCalificaciones2.obtenerNombreCurso());
        
        miLibroCalificaciones1.CalcularPromedios();
    }
    
}
