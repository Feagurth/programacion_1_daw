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
package Trimestre.Segundo.Ejercicios.ExpresionesRegulares;

import java.util.Scanner;

/**
 * Confeccionar una clase que represente un empleado. Nos interesa recoger su
 * nombre, sueldo y turno (mañana o tarde). Confeccionar una interfaz que nos
 * permita: a) Inicializar datos b) Imprimir sus datos c) Saber si debe pagar
 * impuestos (si el sueldo supera a 3000) Suponer que hay una empresa que tiene
 * 8 trabajadores, realizar además un programa que permita saber el gasto en el
 * sueldo por turnos, sabiendo que: Hay dos turnos: Mañana y Tarde La empresa
 * tiene 4 trabajadores por la mañana y 4 por la tarde. Validar la entrada de
 * datos usando expresiones regulares
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio001 {

    public class Empleado {

        // Variables de instancia
        String nombre;
        float sueldo;
        char turno;

        /**
         * Función que nos devuelve el nombre del empleado
         *
         * @return El nombre del empleado
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Función que nos devuelve el sueldo del empleado
         *
         * @return El sueldo del empleado
         */
        public float getSueldo() {
            return sueldo;
        }

        /**
         * Función que nos devuelve el turno del empleado
         *
         * @return M: Mañana T: Tarde
         */
        public char getTurno() {
            return turno;
        }

        /**
         * Constructor de la clase
         *
         * @param nombre
         * @param sueldo
         * @param turno
         */
        public Empleado(String nombre, float sueldo, char turno) {
            this.nombre = nombre;
            this.sueldo = sueldo;
            this.turno = turno;
        }

        /**
         * Función para devolver los datos del empleado
         *
         * @return Los datos del empleado
         */
        public String imprimirDatos() {
            // Creamos una variable para acumular los datos y la inicializados
            String resultado = "";

            // Concatenamos los datos del empleado
            resultado += "Nombre: " + this.nombre;
            resultado += "\nTurno: " + (this.turno == 'm' || this.turno == 'M'
                    ? "Mañana" : "Tarde");

            resultado += "\nSueldo: " + this.sueldo;

            // Devolvemos el resultado
            return resultado;
        }

        /**
         * Función que nos indica si el empleado debe pagar impuestos
         *
         * @return Verdadero si debe pagar impuestos, falso si no debe pagarlos
         */
        public boolean pagaImpuestos() {
            return this.sueldo > 3000;
        }
    }

    public void Ejercicio() {

        // Objeto para leer datos del usuario
        Scanner scanner;

        // Array para almacenar los empleados
        Empleado[] arrayEmpleados = new Empleado[8];

        String nombre;
        String sueldo;

        // Iteramos para preguntar los datos de los empleados y almacenarlos
        for (int i = 0; i < 8; i++) {

            scanner = new Scanner(System.in);

            // Los 4 primeros empleados serán los del turno de mañana
            // y los siguientes los de la tarde
            do {
                System.out.print("Introduzca el nombre del trabajador "
                        + "para el turno de " + ((i < 4) ? "mañana" : "tarde") + ": ");
                nombre = scanner.nextLine();
            } while (!validacion(nombre, "[a-zA-Z0-9 ]+"));

            do {

                System.out.print("Introduzca el sueldo del trabajador "
                        + "para el turno de " + ((i < 4) ? "mañana" : "tarde") + ": ");

                sueldo = scanner.nextLine();
            } while (!validacion(sueldo, "[0-9]*\\,[0-9]+|[0-9]*\\.[0-9]+|[0-9]+"));

            sueldo = sueldo.replace(",", ".");

            // Creamos el empleado y lo almacenamos en el array
            arrayEmpleados[i] = new Empleado(nombre, Float.parseFloat(sueldo), (i < 4 ? 'm' : 't'));
        }

        // Creamos los acumuladores y los inicializamos
        float sueldoMañana = 0, sueldoTarde = 0;

        // Iteramos por el arrray y almacenamos los valores de lo sueldos
        // en sus correspondientes acumuladores
        for (int i = 0; i < 8; i++) {
            if (arrayEmpleados[i].getTurno() == 'm') {
                sueldoMañana += arrayEmpleados[i].getSueldo();
            } else {
                sueldoTarde += arrayEmpleados[i].getSueldo();
            }
        }

        // Mostramos resultados
        System.out.println("El total del sueldo de la mañana es: " + sueldoMañana);
        System.out.println("El total del sueldo de la tarde es: " + sueldoTarde);
    }

    /**
     * Función para validar entradas con expresiones regulares
     *
     * @param cadena Cadena de texto a validar
     * @param patron Patrón de validación
     * @return Verdadero si la cadena es validada correctamente y falso en caso
     * contrario
     */
    private boolean validacion(String cadena, String patron) {

        return cadena.matches(patron);
    }

}
