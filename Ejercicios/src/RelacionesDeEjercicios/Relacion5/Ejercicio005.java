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

import java.io.IOException;

/**
 * Escribe un programa que demuestre que el orden de los bloques catch es 
 * importante. Si se trata de atrapar un tipo de excepción de superclase antes 
 * de un tipo de subclase, el compilador debe generar errores. 
 * Sugerencias:
 *     a. Probar con la subclase IOException y la superclase Exeption
 *     b. Importar la clase IOException
 *     c. Utilizar un bloque try para lanzar una excepción de tipo IOException
 *     d. Usar dos bloques catch
 *          I. Uno para capturar una excepción de tipo Exception
 *               1. Imprimir la traza de la pila
 *          II. Otro para capturar una excepción de tipo IOException
 *               1. Imprimir mensaje de salida indicando captura de excepción 
 *               (usar flujo err)
 * 
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio005 {

    /**
     * Método principal de la clase Ejercicio005
     */
    public void ejercicio() {
        /**
         * Bloque Try/Catch con dos bloques catch Se debe colocar el bloque
         * catch que capture la excepción de subclase antes del catch que
         * captura la excepción de superclase, puesto que si se hace al
         * contrario, se produce un error al encontrarse la excepción ya
         * capturada por el bloque catch de la superclase y no permite compilar
         */
        try {
            // Lanzamos una excepción tipo IOException
            throw new IOException();
            
            
        } // Bloque que captura excepciones tipo IOException. Aquí se capturará
        // la excepción lanzada en el bloque try
        catch (IOException e) {

            // Imprimimos la traza de error de la pila
            e.printStackTrace(System.err);
            
        } // Bloque que captura excepciones tipo Exception. Aquí se capturará
        // cualquier excepción que no esté contemplada en el resto de bloques
        // catch
        catch (Exception e) {

            // Imprimimos la traza de error de la pila
            e.printStackTrace();
        }
    }
}
