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
package Trimestre.Segundo.Ejercicios.LibroPdf;

/**
 * Modifique la clase LibroCalificaciones (figura 3.10) de la siguiente manera:
 * a) Incluya una segunda variable de instancia String, que represente el nombre
 * del instructor del curso. b) Proporcione un método establecer para modificar
 * el nombre del instructor, y un método obtener para obtener el nombre. c)
 * Modifique el constructor para especificar dos parámetros: uno para el nombre
 * del curso y otro para el nombre del instructor. d) Modifique el método
 * mostrarMensaje, de tal forma que primero imprima el mensaje de bienvenida y
 * el nombre del curso, y que después imprima "Este curso es presentado por: ",
 * seguido del nombre del instructor. Use su clase modificada en una aplicación
 * de prueba que demuestre las nuevas capacidades de la clase.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio3_11 {

    // La clase LibroCalificaciones con un constructor para inicializar el nombre del curso.
    public class LibroCalificaciones {

        private String nombreDelCurso; // nombre del curso para este LibroCalificaciones
        private String nombreInstructor; // nombre del instructor del curso

        // getter del nombre del instructor del curso
        public String getNombreInstructor() {
            return nombreInstructor;
        }

        // setter del nombre del instructor del curso
        public void setNombreInstructor(String nombreInstructor) {
            this.nombreInstructor = nombreInstructor;
        }

        // el constructor inicializa nombreDelCurso con el objeto String que se provee como argumento
        public LibroCalificaciones(String nombre, String instructor) {
            nombreDelCurso = nombre; // inicializa nombreDelCurso
            nombreInstructor = instructor;
        } // fin del constructor 

        // método para establecer el nombre del curso
        public void establecerNombreDelCurso(String nombre) {
            nombreDelCurso = nombre; // almacena el nombre del curso
        } // fin del método establecerNombreDelCurso

        // método para obtener el nombre del curso
        public String obtenerNombreDelCurso() {
            return nombreDelCurso;
        } // fin del método obtenerNombreDelCurso

        // muestra un mensaje de bienvenida al usuario de LibroCalificaciones
        public void mostrarMensaje() {
        // esta instrucción llama a obtenerNombreDelCurso para obtener el
            // nombre del curso que este LibroCalificaciones representa
            System.out.printf("Bienvenido al Libro de calificaciones para\n%s!\n"
                    + "Este curso es presentado por: %s\n", obtenerNombreDelCurso(), getNombreInstructor());
        } // fin del método mostrarMensaje

    } // fin de la clase LibroCalificaciones

    public void Ejercicio() {

        LibroCalificaciones libro = new LibroCalificaciones("1º Desarrollo de Aplicaciones Web", "Alberto Goñi");
        LibroCalificaciones libro2 = new LibroCalificaciones("Pollas en vinagre", "Bartolo el del bombo");

        libro.mostrarMensaje();
        libro2.mostrarMensaje();
    }
}
