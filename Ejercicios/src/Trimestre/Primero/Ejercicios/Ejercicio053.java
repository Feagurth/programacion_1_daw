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
 * Realizar un procedimiento que obtenga la división entera y el resto de la 
 * misma utilizando únicamente los operadores suma y resta.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio053 {

    public void Ejercicio()
    {
        // Objeto para mostrar y pedir datos al usuario
        Mensajes mensaje = new Mensajes();
        
        // Variable para almacenar el resultado de la división
        ResultadoDivision res;
    
        // Variables
        int div, divs;
        
        // Petición de datos al usuario
        div = Integer.parseInt(mensaje.PedirDatos("Introduzca un valor para "
                + "el dividendo", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));

        divs = Integer.parseInt(mensaje.PedirDatos("Introduzca un valor para "
                + "el divisor", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        // Realizamos la división
        res = Division(div, divs);
        
        // Mostramos resultados
        mensaje.MostrarMensaje("Cociente: " + res.getCociente() + "\nResto: " 
                + res.getResto(), "Resultado", Mensajes.TipoMensaje.INFORMACION);
        
    }
    
    
    /**
     * Fumción para dividir usando solo sumas y restas
     * @param dividendo Dividendo
     * @param divisor Divisor
     * @return Resultado
     */
    private ResultadoDivision Division(int dividendo, int divisor)
    {
        // Objeto para devolver el resultado
        ResultadoDivision result;
        int cociente = 0, resto;
        
        // Iteramos mientras que el divisor sea mayor que el resto
        do
        {
            // El resto será igual al dividendo menos el divisor
            // Y el resto resultante sera el dividendo de la siguiente 
            // iteración, donde el cociente aumentará en 1
            resto = dividendo - divisor;
            dividendo = resto;
            cociente++;
        }while(divisor < resto);

        
       // Creamos el objeto para almacenar el resultado y lo devolvemos
       result = new ResultadoDivision(cociente, resto);
        
        return result;
    }

    /**
     * Clase para devolver el resultado de la división
     */
    private static class ResultadoDivision {

        /**
         * Variable para almacenar el valor del cociente
         */
        final int cociente ;
        
        /**
         * Variable para almacenar el valor del resto
         */
        final int resto;
        
        /**
         * Constructor de la clase
         * @param cociente valor del cociente
         * @param resto valor del resto
         */
        public ResultadoDivision(int cociente, int resto) {
            this.cociente = cociente;
            this.resto = resto;
        }

        /**
         * Devuelve el valor del cociente
         * @return El valor del cociente
         */
        public int getCociente() {
            return cociente;
        }

        /**
         * Devuelve el valor del resto
         * @return El valor del resto
         */
        public int getResto() {
            return resto;
        }
        
        
    }        
}
