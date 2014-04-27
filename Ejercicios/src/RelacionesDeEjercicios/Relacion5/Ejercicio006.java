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
 * Escribe un programa que muestre cómo volver a lanzar una excepción. 
 * Sugerencias:
 *      a. Trabajar con excepciones de tipo Exception
 *      b. Define dos métodos metodo1 y metodo2.
 *      c. El método metodo2 debe lanzar una excepción. Utilizar el constructor 
 *      que permite especificar el mensaje asociado a la excepción, indicando 
 *      dónde tuvo lugar la excepción (en este caso en metodo2)
 *      d. El método metodo1 debe llamar a metodo2 y atrapar la excepción y 
 *      volverla a lanzar
 *      e. Desde main
 *           I. Se llama a metodo1
 *           II. Se atrapa la excepción que se volvió a lanzar desde metodo1.
 *           III. Mostrar mensaje de la excepción (lanzada en metodo2)
 *           IV. Imprimir el rastreo de la pila
 * 
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio006 {
    
    /**
     * Método principal de la clase Ejercicio006
     */
    @SuppressWarnings("unchecked")
    public void ejercicio()
    {
        /**
         * Bloque try/catch
         * En el try se lanzará metodo1.
         * En el catch se capturará la excepción lanzada desde método2
         */
        try {
            metodo1();
        } catch (Exception e) {
            
            // Mostramos el mensaje que tiene la excepción
            System.err.println("Mensaje: " + e.getMessage());
            
            // Imprimimos la traza de la pila
            e.printStackTrace();
        }
    }
    
    /**
     * Método para probar el lanzamiento de excepciones
     * Desde este método se llamará a metodo2, en el cual se lanza una excepción
     * que será capturada en este y lanzada de nuevo al método inicial
     * @throws Exception Excepción de pruebas
     */
    private void metodo1() throws Exception
    {
        // Llamamos a metodo2
        metodo2();
    }

    /**
     * Método para probar el lanzamiento de excepciones.
     * Desde éste método se lanza una excepción
     * @throws Exception Excepción de pruebas
     */
    private void metodo2() throws Exception
    {
        // Lanzamos una excepción de tipo Exception con un mensaje específico       
        throw new Exception("Excepción lanzada en metodo2");
    
    }
    
}
