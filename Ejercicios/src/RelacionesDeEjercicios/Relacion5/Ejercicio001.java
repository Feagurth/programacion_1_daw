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
package RelacionesDeEjercicios.Relacion5;

import Utiles.Mensajes;

/**
 * Escribe un tipo enum llamado LuzSemaforo, cuyas constantes (ROJO, VERDE, AMARILLO) 
 * reciban un parámetro: la duración de la luz. Escribe un programa para probar 
 * el tipo enum LuzSemaforo, de manera que muestre las constantes de la enum y 
 * sus duraciones. Sugerencias:
 *     a. Duraciones de luz:
 *          I. ROJO  50 (segundos)
 *         II. AMARILLO  40
 *        III. VERDE  5
 *     b. Elementos que debe tener el tipo enumerado:
 *          I. Variable constante para almacenar la duración de cada constante
 *         II. Constructor de LuzSemaforo que inicialice el campo del tipo 
 *             enumerado que almacena la duración de las luces (constantes enumeradas)
 *        III. Método que devuelve el contenido del campo de LuzSemaforo
 *         IV. En el programa de prueba de la clase enum, utilizar el método values() 
 *             que devuelve una matriz con los valores de tipo LuzSemaforo para mostrar la 
 *             luz y su duración. Tener en cuenta:
 *                    1. Debéis utilizar el método get de la clase y el for 
 *                    optimizado para recorrer el array devuelto por el 
 *                    método values()
 * 
 *  * @author Luis Cabrerizo Gómez
 */
public class Ejercicio001 {

    /**
     * Enumerador para almacenar las luces del semáforo
     */
    public enum LuzSemaforo {

        /**
         * Valor para el color rojo del semáforo
         */
        ROJO(50),
        /**
         * Valor para el color amarillo del semáforo
         */
        AMARILLO(40),
        /**
         * Valor para el color verde del semáforo
         */
        VERDE(5);

        /**
         * Variable para almacenar la duración de la luz del semáforo
         */
        private final int duracion;

        /**
         * Constructor del enumerador
         *
         * @param duracion Duración de la luz del semáforo
         */
        LuzSemaforo(int duracion) {
            this.duracion = duracion;
        }

        /**
         * Método para recuperar la duración de la luz del semáforo
         *
         * @return Duración de la luz del semáforo
         */
        public int getDuracion() {
            return duracion;
        }

        /**
         * Método para recuperar el nombre de la luz del semáforo
         *
         * @return
         */
        public String getNombre() {
            return this.name();
        }

        /**
         * Método que devuelve el nombre y la duración de la luz del semáforo
         * formateada convenientemente
         *
         * @return Nombre de la luz del semáforo: Duración de la luz del
         * semáforo
         */
        @Override
        public String toString() {
            return String.format("%s: %d", this.name(), duracion);
        }
    };

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

         // Variable para almacenar el resultado
        StringBuilder salida = new StringBuilder("");

        // Concatenamos un texto explicativo
        salida.append("Usando el método toString()\n"
                + "----------------------------------------\n");

        // Iteramos por todos los objetos del enumerador usando el método toString()
        // para mostrar el nombre de la luz y su duración
        for (LuzSemaforo luz : LuzSemaforo.values()) {
            salida.append(luz.toString());
            salida.append("\n");
        }

        // Concatenamos otro texto explicativo
        salida.append("\nUsando métodos get\n"
                + "-------------------------------\n");

        // Iteramos por los objetos del enumerador usando los métodos get
        // correspondientes para mostrar el nombre de la luz y su duración
        for (LuzSemaforo luz : LuzSemaforo.values()) {
            salida.append(String.format("%s: %d%n", luz.getNombre(), luz.getDuracion()));
        }

        // Mostramos los resultados al usuario
        Mensajes.mostrarMensaje(salida.toString(), "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }

}
