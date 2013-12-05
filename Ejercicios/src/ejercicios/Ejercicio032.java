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

package ejercicios;

/**
 * Escribir los diferentes métodos para deducir si una variable o 
 * expresión numérica es par.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio032 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio(){
    
        // Objeto para toma y muestra de datos al usuario
        Mensajes msg = new Mensajes();
        
        // Variables
        int numero;
        String resultado;
      
        // Lectura de datos
        numero = Integer.parseInt(msg.PedirDatos("Introduzca un número", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        // Comprobamos si el número es par usando el modulo de 2
        if(numero % 2 == 0)
        {
            resultado = "El número es par";
        }
        else
        {
            resultado = "El número es impar";
        }
        
        // Muestra de resultados
        msg.MostrarMensaje(resultado, "Resultados", Mensajes.TipoMensaje.INFORMACION);
    }
}
