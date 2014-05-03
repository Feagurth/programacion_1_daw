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
package RelacionesDeEjercicios.Relacion3;

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * (Sistemas de reserva de una aerolínea). Una pequeña aerolínea acaba de
 * comprar una computadora para su nueva sistema de reservas automatizado. Se te
 * ha pedido que desarrolles el nuevo sistema. Escribirás una aplicación para
 * asignar asientos en cada vuelo del único avión de la aerolínea (capacidad: 10
 * asientos). Tu aplicación debe mostrar las siguientes alternativas:
 *
 * Por favor escriba 1 para Primera clase Por favor escriba 2 para Económico
 *
 * Si el usuario escribe 1, tu aplicación debe asignarle un asiento en la
 * sección de primera clase (asientos 1 a 5). Si el usuario escribe 2, tu
 * aplicación debe asignarle un asiento en la sección económica (asientos 6 a
 * 10). Tu aplicación deberá entonces imprimir un pase de abordaje, indicando el
 * número de asiento de la persona y si se encuentra en la sección de primera
 * clase o clase económica del avión.
 *
 * Utiliza un array unidimensional del tipo primitivo boolean para representar
 * la tabla de asientos del avión. Inicializa todos los elementos del array con
 * false para indicar que todos los asientos están vacíos. A medida que se
 * asigne cada asiento, establece ls elementos correspondientes del array en
 * true para indicar que ese asiento ya no está disponible.
 *
 * Tu aplicación nunca deberá asignar un asiento que haya sido asignado. Cuando
 * esté llena la sección económica, tu programa deberá preguntar a la persona si
 * acepta ser colocada en la sección de primera clase (y viceversa). Si la
 * persona acepta, haz la asignación de asiento apropiada. Si no acepta, imprime
 * el mensaje "El próximo vuelo sale en 3 horas"
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio010 {

    /**
     * Clase para gestionar el sistema de reservas de una aerolínea
     */
    static public class SistemaReservas {

        // Los valores usaremos para gestionar el sistema de reservas
        private final boolean[] asientosAvion;
        private final int numAsientos;
        private final int numAsientosPrimera;

        /**
         * Constructor de la clase SistemaReservas
         *
         * @param numAsientos Número de asientos que permite gestionar el
         * sistema
         * @param numAsientosPrimera Número de asientos de primera de los
         * definidos
         */
        public SistemaReservas(int numAsientos, int numAsientosPrimera) {
            this.numAsientos = numAsientos;
            this.numAsientosPrimera = numAsientosPrimera;

            asientosAvion = new boolean[numAsientos];
        }

        /**
         * Método que nos permite comprobar si hay asientos libres para un tipo
         * de reserva específico
         *
         * @param primeraClase Especifica si se buscará un asiento libre en
         * primera clase
         * @return Verdadero si hay asientos libres, falso si no hay asientos
         * libres
         */
        public boolean verificarAsiento(boolean primeraClase) {
            int valorInicial;
            int valorFinal;

            if (primeraClase) {
                valorInicial = 0;
                valorFinal = this.numAsientosPrimera;
            } else {
                valorInicial = this.numAsientosPrimera;
                valorFinal = this.numAsientos;
            }

            for (int i = valorInicial; i < valorFinal; i++) {
                if (this.asientosAvion[i] == false) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Método que nos permite reservar un asiento de un tipo específico
         *
         * @param primeraClase Especifica si se reservará el asiento en primera
         * clase
         * @return Número de asiento asignado al usuario
         */
        public int reservarAsiento(boolean primeraClase) {
            int valorInicial;
            int valorFinal;

            if (primeraClase) {
                valorInicial = 0;
                valorFinal = this.numAsientosPrimera;
            } else {
                valorInicial = this.numAsientosPrimera;
                valorFinal = this.numAsientos;
            }

            for (int i = valorInicial; i < valorFinal; i++) {
                if (this.asientosAvion[i] == false) {
                    this.asientosAvion[i] = true;
                    return (i + 1);
                }
            }

            return -1;
        }
    }

    /**
     * Función para imprimir el pase de abordaje
     *
     * @param usuario Nombre del usuario que ha comprado el billete
     * @param asiento Numero de asiento del billete
     * @param primeraClase Especifca si el billete es de primera clase
     */
    private String imprimirPaseAbordaje(String usuario, int asiento, boolean primeraClase) {
        String resultado;

        resultado = "============================================";
        resultado += "\nNombre: " + usuario;
        resultado += "\nNº Asiento: " + asiento;
        resultado += "\nTipo Reserva: "
                + (primeraClase ? "Primera Clase" : "Económica");
        resultado += "\n============================================";

        return resultado;
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // variables
        String nombreUsuario;
        int tipoReserva;
        int numAsiento;
        int cantidadAsientos = 10;
        int cantidadAsientosPrimera = 5;
        String apoyo;

        // Creamos un objeto SistemaReservas para gestionar las reservas        
        SistemaReservas reservas = new SistemaReservas(cantidadAsientos, cantidadAsientosPrimera);

        do {
            // Petición de nombre al usuario
            nombreUsuario = PeticionDatos.pedirCadena("Introduzca su nombre");

            // Pedimos al usuario el tipo de reserva
            apoyo = "1 Primera Clase";
            apoyo += "\n2 Económico";
            apoyo += "\nIntroduzca el tipo de reserva";
            tipoReserva = PeticionDatos.pedirEnteroRango(apoyo, 1, 2);

            // Verificamos que hay asientos para el tipo de reserva seleccionado
            if (reservas.verificarAsiento((tipoReserva == 1))) {

                // Si hay asientos, reservamos uno del tipo especificado y
                // guardamos el num de asiento que se nos ha asignado
                numAsiento = reservas.reservarAsiento(tipoReserva == 1);

                // Imprimimos el pasaje de abordaje con los datos que 
                // tenemos almacenados
                Mensajes.mostrarMensaje(
                        imprimirPaseAbordaje(
                                nombreUsuario,
                                numAsiento,
                                tipoReserva == 1),
                        Mensajes.TipoMensaje.INFORMACION);

            } else {

                // Si no hay asientos para el tipo de reserva seleccionado
                // preguntaremos si el usuario quiere reservar en el otro tipo
                // de reservas. Para almacenar la respuesta creamos una variable
                // booleana
                String pregunta;
                boolean resultado;

                // Realizamos la pregunta clase al usuario
                pregunta = ("No quedan asientos libres en "
                        + (tipoReserva == 1 ? "Primera Clase\n" : "clase económica\n"));

                pregunta += ("¿Desea reservar asiento en "
                        + (tipoReserva == 1 ? "clase económica" : "Primera Clase"));

                // Almacenamos el resultado
                resultado = Mensajes.pedirConfirmacion(pregunta);

                // Si la respuesa es negativa, mostramos la respuesta 
                // especificada
                if (!resultado) {
                    Mensajes.mostrarMensaje("El próximo vuelo sale en 3 horas",
                            Mensajes.TipoMensaje.INFORMACION);
                } else {

                    // Si la respuesta es positiva, reservamos un asiento
                    // con el nuevo tipo de reserva y almacenamos el asiento
                    // que nos ha asignado el sistema
                    numAsiento = reservas.reservarAsiento(tipoReserva != 1);

                    // Imprimimos el pase de abordaje con los datos que 
                    // tenemos almacenados
                    Mensajes.mostrarMensaje(
                            imprimirPaseAbordaje(
                                    nombreUsuario, 
                                    numAsiento, 
                                    tipoReserva != 1), 
                            Mensajes.TipoMensaje.INFORMACION);
                }
            }

            // Comprobamos si hay asientos libres, de haberlos, seguimos iterando
        } while (reservas.verificarAsiento(true) || reservas.verificarAsiento(false));

        // Si no quedan asientos libres, el programa se da por finalizado.
        // Mostramos un mensaje informativo
        apoyo = "============================================";
        apoyo += "\nLo sentimos, no quedan asientos libres";
        apoyo += "\nEl próximo vuelo sale en 3 horas";
        apoyo += "\n============================================";
        
        Mensajes.mostrarMensaje(apoyo, Mensajes.TipoMensaje.AVISO);

    }
}
