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

import Utiles.PeticionDatos;
import java.util.Scanner;

/**
 * Cree una clase llamada Empleado, que incluya tres piezas de información como
 * variables de instancia: un primer nombre (tipo String), un apellido paterno
 * (tipo String) y un salario mensual (double). Su clase debe tener un
 * constructor que inicialice las tres variables de instancia. Proporcione un
 * método establecer y un método obtener para cada variable de instancia. Si el
 * salario mensual no es positivo, establézcalo a 0.0. Escriba una aplicación de
 * prueba llamada PruebaEmpleado, que demuestre las capacidades de cada
 * Empleado. Cree dos objetos Empleado y muestre el salario anual de cada
 * objeto. Después, proporcione a cada Empleado un aumento del 10% y muestre el
 * salario anual de cada Empleado otra vez.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio3_14 {

    /**
     * Clase para tratar con los empleados
     */
    public class Empleado {

        // Variables
        private String primerNombre;
        private String apellidoPaterno;
        private double sueldoMensual;

        // Getters & Setters
        public String getPrimerNombre() {
            return primerNombre;
        }

        public void setPrimerNombre(String primerNombre) {
            this.primerNombre = primerNombre;
        }

        public String getApellidoPaterno() {
            return apellidoPaterno;
        }

        public void setApellidoPaterno(String apellidoPaterno) {
            this.apellidoPaterno = apellidoPaterno;
        }

        public double getSueldoMensual() {
            return sueldoMensual;
        }

        public void setSueldoMensual(double sueldoMensual) {
            if (sueldoMensual > 0) {
                this.sueldoMensual = sueldoMensual;
            } else {
                this.sueldoMensual = 0.0f;
            }
        }

        /**
         * Constructor de la clase
         *
         * @param primerNombre Nombre del empleado
         * @param apellidoPaterno Apallido del empleado
         * @param sueldoMensual Sueldo del empleado
         */
        public Empleado(String primerNombre, String apellidoPaterno, double sueldoMensual) {
            this.primerNombre = primerNombre;
            this.apellidoPaterno = apellidoPaterno;
            this.sueldoMensual = sueldoMensual;
        }
    }

    public void Ejercicio() {

        String nombre, apellido;
        double sueldoMensual;

        // Pedimos datos al usuario y los validamos
        // apoyados en unas clases diseñadas para ese 
        // propósito
        nombre = PeticionDatos.pedirCadena("Introduzca el nombre del empleado");

        apellido = PeticionDatos.pedirCadena("Introduzca el apellido del empleado");

        sueldoMensual = PeticionDatos.pedirRealPositivo("Introduzca el sueldo mensual del empleado");

        // Creamos el objeto
        Empleado empleado1 = new Empleado(nombre, apellido, sueldoMensual);

        // Imprimimos el sueldo anual
        System.out.print("El sueldo anual del empleado es: ");
        System.out.println(empleado1.getSueldoMensual() * 12);

        // Asignamos el sueldo un 10%
        empleado1.setSueldoMensual(empleado1.getSueldoMensual() + (empleado1.getSueldoMensual() * 0.1));

        // Imprimimos el sueldo anual de nuevo
        System.out.println("Se ha aumentado el sueldo del empleado un 10%");
        System.out.print("El sueldo anual del empleado es: ");
        System.out.println(empleado1.getSueldoMensual() * 12);

    }
}
