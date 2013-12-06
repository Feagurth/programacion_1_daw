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

package Trimestre.Primero;

import ejercicios.Mensajes;

/**
 * Realizar un algoritmo para realizar combinatorias ordinarias
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio062 {
   
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();
        
        // Variables
        int n, m;
        double resultado;

        do
        {
            // Petición de datos al usuario
            m = Integer.parseInt(msg.PedirDatos("Introduzca el valor para m", 
                    "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));

            n = Integer.parseInt(msg.PedirDatos("Introduzca el valor para n", 
                    "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));

            // Verificación de que los datos introducidos sean correctos
            if(n>= m && n > 0)
            {
                // Se calcula el resultado y se muestra al usuario
                resultado = Factorial(n) / (((Factorial(m)) * Factorial(n-m)));

                msg.MostrarMensaje("El resultado es " + resultado, 
                        "Resultado", Mensajes.TipoMensaje.INFORMACION);
            }
            else
            {
                msg.MostrarMensaje("Los valores introducidos no eran correcto", 
                        "Atención", Mensajes.TipoMensaje.ERROR);
            }
        }while(n <= m || n < 0);
    }
        
    /**
     * Función para calcular el factorial de un número
     * @param numero valor al que calcular el factorial
     * @return Devuelve el resultado de la factorización de número
     */
    private double Factorial(int numero)
    {
        // Iniciamos la variable que devolverá el resultado
        int resultado = 1;
        
        // Iteramos desde el número inicial hasta llegar a 1
        for (int i = numero; i > 1; i--) 
        {
            // Multiplicamos el resultado anterior por el valor del contador
            // del bucle
            resultado = resultado *  i;
        }
    
        return resultado;
    }
        
        
}
