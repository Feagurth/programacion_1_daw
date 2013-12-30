/*
 * Copyright (C) 2013 Luis Cabrerizo Gómez
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

package Trimestre.Primero.Ejercicios;

import Utiles.Mensajes;

/**
 * Realizar un procedimiento que permita intercambiar el contenido de 
 * dos variables.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio049 {

    /**
     * Clase para almacenar los resultados de la función intercambiar
     */
    private static class Resultado {

        /**
         * Variable x
         */
        private final int x;
        
        /**
         * Variable y
         */
        private final int y;
        
        /**
         * Constructor de la clase
         * @param x Valor de x
         * @param y Valor de y
         */
        public Resultado(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Devuelve el valor de X
         * @return El valor de X
         */
        public int getX() {
            return x;
        }

        /**
         * Devuelve el valor de Y
         * @return El valor de Y
         */
        public int getY() {
            return y;
        }
    }    
    
    public void Ejercicio()
    {
        // Objeto para mostrar y pedir datos al usuario
        Mensajes mensaje = new Mensajes();

        // Variables
        int a, b;
        
        // Petición de datos al usuario
        a = Integer.parseInt(mensaje.PedirDatos("Introduzca un valor para "
                + "la primera variable", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        b = Integer.parseInt(mensaje.PedirDatos("Introduzca un valor para "
                + "la segunda variable", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));        
        
        // Creamos un objeto resultado y llamamos a la función
        Resultado result = intercambiar(a, b);
        
        // Mostramos el resultado
        mensaje.MostrarMensaje("La primera variable es " + result.getX() + 
                " y la segunda es " + result.getY(), "Resultado", 
                Mensajes.TipoMensaje.INFORMACION);

    }    
  
    /**
     * Función que permite cambiar los valores de dos variables
     * @param x Valor de la variable x
     * @param y Valor de la variable y
     * @return Devuelve la clase resultado con los valores intercambiados
     */
    private Resultado intercambiar(int x, int y)
    {
        // Creamos el objeto con los valores intercambiados
        Resultado resultado = new Resultado(y, x);

        // Devolvemos el resultado
        return resultado;
    }
    
        

}
