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
 * Diseñar un programa que lea el peso de un hombre en libras y nos devuelva su peso 
 * en kilogramos y gramos (Nota: una libra equivale a 0,453592 kilogramos)
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio010 {
    
    /**
    * Ejercicio principal
    */
    public void ejercicio()
    {
        // Valor en kgs de una libra
        final double LIBRA = 0.453592;
    
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();
        
        // Variables
        double peso;
        String resultado;
                
        // Petición de datos al usuario
        peso = Double.parseDouble(msg.PedirDatos("Introduzca el peso en libras", 
                "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));
        
        // Calculamos el peso en kgs
        peso = peso * LIBRA;
        
        // Cremos la cadena con los resultados
        resultado = "El peso en kgs es: " + peso + "\n";
        resultado += "El peso en gramos es: " + peso * 1000;
        
        // Muestra de resultados al usuario
        msg.MostrarMensaje(resultado, "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }
    
}
