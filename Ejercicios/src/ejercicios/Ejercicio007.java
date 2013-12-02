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
 * Escribir un algoritmo que calcule la superficie de un triángulo en función 
 * de la base y la altura.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio007 {
    
    public void ejercicio()
    {
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();
        
        // Variables
        double base, altura;

        // Petición de datos al usuario
        base = Double.parseDouble(msg.PedirDatos("Introduzca la base del triangulo", 
                "Pedir datos", Mensajes.TipoMensaje.PREGUNTA));
        altura = Double.parseDouble(msg.PedirDatos("Introduzca la altura del triangulo", 
                "Pedir datos", Mensajes.TipoMensaje.PREGUNTA));
        
        // Muestra de resultados al usuario
        msg.MostrarMensaje("La superficie es: " + ((base * altura)/2), 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
        
    }
    
}
