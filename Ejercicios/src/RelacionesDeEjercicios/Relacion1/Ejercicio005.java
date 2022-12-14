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
 * Crear la clase TablaMultiplicar cuya interfaz nos permita: 
 *      a) Calcular la tabla de multiplicar 
 *      b) Mostrarla de forma estructurada por pantalla
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio005 {

    /**
     * Clase para trabajar con tablas de multiplicar
     */
    static public class TablaDeMultiplicar {

        // Variable de instancia
        int numero;

        /**
         * Función que devuelve el numero de la tabla
         *
         * @return El numero de la tabla
         */
        public int getNumero() {
            return numero;
        }

        /**
         * Constructor de la clase
         *
         * @param numero Valor de la tabla de multiplicar
         */
        public TablaDeMultiplicar(int numero) {
            this.numero = numero;
        }

        /**
         * Función que devuelve el valor de un número en la tabla
         *
         * @param valor Valor del número
         * @return Resultado del multiplicar el número por el valor de la tabla
         */
        public int valorDeNumero(int valor) {
            return this.numero * valor;

        }

        /**
         * Método que nos permite generar tablas de multiplicar
         * @param numMaximo Número máximo de operadores
         * @return Una cadena con la tabla de multiplicar formateada
         */
        public String generarTabla(int numMaximo) {
            StringBuilder buf = new StringBuilder();

            // Iteramos creando el resultado
            for (int i = 0; i <= numMaximo; i++) {
                buf.append(i).append(" x ").append(this.numero).append(" = ").append(i * this.numero).append("\n");
            }

            // Devolvemos el resultado
            return buf.toString();
        }
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // Petición de datos al usuario
        int numero = PeticionDatos.pedirEntero("Introduzca el número cuya tabla "
                + "quiera mostrar");

        int iteraciones = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca "
                + "la cantidad de operaciones a mostrar");

        // Creamos el objeto
        TablaDeMultiplicar tabla = new TablaDeMultiplicar(numero);

        // Mostramos los resultados
        // Preguntamos si queremos mostrar el resultado a través de la consola 
        // o de una ventana por si se han pedido demasiados resultados que generen
        // una ventana demasiado grande como para no ver el botón de aceptar
        
        if(Mensajes.pedirConfirmacion("¿Desea mostrar el resultado por consola?"))
        {
            System.out.println(tabla.generarTabla(iteraciones));
        } else {
            Mensajes.mostrarMensaje(tabla.generarTabla(iteraciones), "Resultado",
                    Mensajes.TipoMensaje.INFORMACION, false);
        }
    }
}
