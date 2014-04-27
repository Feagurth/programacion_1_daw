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

/**
 * Utiliza la herencia para crear una superclase de excepción (llamada ExcepionA) 
 * y las subclases de excepción ExcecionB y ExcepcionC, en donde ExcepcionB 
 * hereda de ExcepcionA y ExepcionC hereda de ExcepcionB. Escribe un programa 
 * para demostrar que el bloque catch para el tipo ExcepcionA atrapa excepciones 
 * de los tipos ExcepcionB y ExcepcionC. Tener en cuenta lo siguiente:
 *     a. La clase ExcepcionA extiende la clase Exception
 *     b. El cuerpo de las clases está vacío
 *     c. En el fichero de prueba lanzar excepciones de tipo ExcepcionB y 
 *     ExcepcionC dentro de los bloques try correspondientes. Vamos a utilizar 
 *     dos bloques try.
 *     d. En los bloques catch asociados a los bloques try correspondientes 
 *     declarar una excepción de tipo ExcepcionA y utilizar la correspondiente 
 *     salida usando el flujo err
 * 
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio004 {

    /**
     * Clase para capturar excepciones. Hereda de la clase Excepcion
     */
    public static class ExcepcionA extends Exception {
    }

    /**
     * Clase para capturar excepciones. Hereda de la clase ExcepcionA
     */
    public static class ExcepcionB extends ExcepcionA {
    }

    /**
     * Clase para capturar excepciones. Hereda de la clase ExcepcionB
     */
    public static class ExcepcionC extends ExcepcionB {
    }

    /**
     * Ejercicio principal de la clase Ejercicio004
     */
    public void ejercicio() {
        
        /**
         * Primer bloque Try/Catch
         */        
        try {
            // Lanzamos una excepción de tipo ExcepcionB
            throw new ExcepcionB();
        } 
        // Hacemos la captura del error con una ExcepcionA
        catch (ExcepcionA e) {

            // Mostramos un mensaje sobre la captura
            System.err.println(mensaje(e.getClass().getSuperclass().getName(), 
                    e.getClass().getName()));

            // Imprimimos la traza de la pila de errores
            e.printStackTrace();
        }

        try {
            throw new ExcepcionC();
        } catch (ExcepcionA e) {

            // Mostramos un mensaje sobre la captura
            System.err.println(mensaje(e.getClass().getSuperclass().getName(), 
                    e.getClass().getName()));

            // Imprimimos la traza de la pila de errores
            e.printStackTrace();
        }

    }

    /**
     * Método para generar una cadena de texto para mostrar la herencia y 
     * captura de errores
     * @param Captura Clase que captura el error.
     * @param Capturada Clase de error que se captura
     * @return Una cadena con los valores de captura de las clases
     */
    private static String mensaje(String Captura, String Capturada) {

        return String.format("%nClase que captura: %s - Clase capturada: %s",
                Captura,
                Capturada);
    }
}
