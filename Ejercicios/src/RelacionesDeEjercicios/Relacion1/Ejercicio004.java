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
package RelacionesDeEjercicios.Relacion1;

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * Confeccionar una clase que represente un empleado. Nos interesa recoger su
 * nombre, sueldo y turno (mañana o tarde). Confeccionar una interfaz que nos
 * permita: 
 *      a) Inicializar datos 
 *      b) Imprimir sus datos 
 *      c) Saber si debe pagar impuestos (si el sueldo supera a 3000)
 *
 * Suponer que hay una empresa que tiene 8 trabajadores, realizar además un
 * programa que permita saber el gasto en el sueldo por turnos, sabiendo que:
 * Hay dos turnos: Mañana y Tarde La empresa tiene 4 trabajadores por la mañana
 * y 4 por la tarde
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio004 {

    /**
     * Clase para trabajar con empleados
     */
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

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // Array para almacenar los empleados
        Empleado[] arrayEmpleados = new Empleado[8];

        String nombre;
        float sueldo;

        // Iteramos para preguntar los datos de los empleados y almacenarlos
        for (int i = 0; i < 8; i++) {

            // Los 4 primeros empleados serán los del turno de mañana
            // y los siguientes los de la tarde
            nombre = PeticionDatos.pedirCadena("Introduzca el nombre del "
                    + "trabajador para el turno "
                    + "de " + ((i < 4) ? "mañana" : "tarde"));

            sueldo = (float) PeticionDatos.pedirRealPositivoNoCero("Introduzca "
                    + "el sueldo del trabajador para el turno "
                    + "de " + ((i < 4) ? "mañana" : "tarde"));

            // Creamos el empleado y lo almacenamos en el array
            arrayEmpleados[i] = new Empleado(nombre, sueldo, (i < 4 ? 'm' : 't'));
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

        String menu = "";
        int valorMenu;

        // Mostramos un menú con opciones para el usuario
        menu += "Introduzca una opción para continuar\n";
        menu += "------------------------------------\n";
        menu += "[1] Imprimir los datos de un trabajador\n";
        menu += "[2] Saber si un trabajador debe pagar impuestos\n";
        menu += "[3] Mostrar el sueldo total de los trabajadores de la mañana\n";
        menu += "[4] Mostrar el sueldo total de los trabajadores de la tarde\n";
        menu += "[0] Salir\n\n";

        valorMenu = PeticionDatos.pedirEnteroRango(menu, 0, 4);

        String valorNombre;
        String valorTurno;
        int localizador;

        while (valorMenu != 0) {
            switch (valorMenu) 
            {
                // Opción de menú numero 1
                case 1: {
                    // Pedimos el nombre del trabajador y el turno al usuario
                    valorNombre = PeticionDatos.pedirCadena("Introduzca el nombre del trabajador");
                    valorTurno = PeticionDatos.pedirConsentimiento("Introduzca "
                            + "el turno [m/t]", new String[]{"m", "t"});

                    // Intentamos localizar al trabajador
                    localizador = localizarTrabajador(arrayEmpleados, valorNombre, valorTurno);

                    // Verificamos si lo hemos localizado
                    if (localizador >= 0) {

                        // Si lo hemos localizado, comprobamos si paga impuestos
                        // y mostramos el mensaje adecuado
                        Mensajes.mostrarMensaje(arrayEmpleados[localizador].imprimirDatos(), Mensajes.TipoMensaje.INFORMACION);
                    } else {
                        Mensajes.mostrarMensaje("No se ha podido localizar al "
                                + "trabajador en el turno especificado",
                                Mensajes.TipoMensaje.ERROR);
                    }
                    break;
                }

                // Opción de menú numero 2
                case 2: {

                    // Pedimos el nombre del trabajador y el turno al usuario
                    valorNombre = PeticionDatos.pedirCadena("Introduzca el nombre del trabajador");
                    valorTurno = PeticionDatos.pedirConsentimiento("Introduzca "
                            + "el turno [m/t]", new String[]{"m", "t"});

                    // Intentamos localizar al trabajador
                    localizador = localizarTrabajador(arrayEmpleados, valorNombre, valorTurno);

                    // Verificamos si lo hemos localizado
                    if (localizador >= 0) {

                        // Si lo hemos localizado, comprobamos si paga impuestos
                        // y mostramos el mensaje adecuado
                        if (arrayEmpleados[localizador].pagaImpuestos()) {
                            Mensajes.mostrarMensaje("El trabajador "
                                    + valorNombre + " debe pagar impuestos",
                                    Mensajes.TipoMensaje.INFORMACION);
                        } else {
                            Mensajes.mostrarMensaje("El trabajador "
                                    + valorNombre + " no debe pagar impuestos",
                                    Mensajes.TipoMensaje.INFORMACION);

                        }
                    } else {
                        Mensajes.mostrarMensaje("No se ha podido localizar al "
                                + "trabajador en el turno especificado",
                                Mensajes.TipoMensaje.ERROR);
                    }
                    break;
                }
                
                // Opción de menú numero 3
                case 3: {
                    Mensajes.mostrarMensaje("El total del sueldo de la mañana es: "
                            + sueldoMañana, Mensajes.TipoMensaje.INFORMACION);
                    break;

                }
                // Opción de menú numero 4
                case 4: {
                    Mensajes.mostrarMensaje("El total del sueldo de la tarde es: "
                            + sueldoTarde, Mensajes.TipoMensaje.INFORMACION);
                    break;
                }
                
                default:
                    break;
            }
            
            valorMenu = PeticionDatos.pedirEnteroRango(menu, 0, 4);
        }
    }

    /**
     * Método para localizar a un trabajador buscando por el nombre. Devolverá
     * el primer trabajador con ese nombre en el turno indicado
     *
     * @param array Array donde están almacenados los trabajadores
     * @param nombre Nombre del trabajador a buscar
     * @param turno Turno del trabajador
     * @return Devuelve la posición del trabajador en el array
     */
    private int localizarTrabajador(Empleado[] array, String nombre, String turno) {
        for (int i = (turno.equals("m") ? 0 : 4); i < array.length - (turno.equals("m") ? 4 : 0); i++) {
            if (array[i].getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;

    }

}
