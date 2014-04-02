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
 * Diseñar un algoritmo para calcular la velocidad (en metros/segundo) de 
 * los corredores de una carrera de 1500m. La entrada serán las parejas 
 * (minutos, segundos) que darán el tiempo para cada corredor. Por cada 
 * corredor, se imprimirá el tiempo en minutos y segundos, así como la 
 * velocidad media. El bucle se ejecutará hasta que demos una entrada 0,0 que 
 * será la marca de fin de entrada de datos. Imprimir también el nombre del 
 * corredor.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio005 
{    
    /**
    * Ejercicio principal
    */
    public void ejercicio()
    {
        // Variable con el valor del recorrido
        int RECORRIDO = 1500;

        // Variables
        String nombre;
        int minutos, segundos;
        double media;
        StringBuilder cadena;

        // Petición de datos al usuario
        nombre = Mensajes.pedirDatos("Introduzca el nombre del corredor", 
                "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

        minutos = Integer.parseInt(Mensajes.pedirDatos("Introduzca "
                + "la cantidad de minutos para el corredor", 
                "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));

        segundos = Integer.parseInt(Mensajes.pedirDatos("Introduzca la cantidad de "
                + "segundos para el corredor: ", "Petición de datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        
        // Mientras que los minutos y los segundos sean distintos de cero
        while (segundos != 0 && minutos != 0) 
        {            
             cadena = new StringBuilder();
            
            cadena.append(String.format("%s -> %d:%d%n", nombre, minutos, segundos));
            
            // Calulo de media
            segundos = segundos + (minutos * 60);
            media = (RECORRIDO / (double)segundos);
            
            cadena.append(String.format("Su media es de : %,.2f", media));
            
            Mensajes.mostrarMensaje(cadena.toString(), "Resultados", 
                    Mensajes.TipoMensaje.INFORMACION);
            
        // Petición de datos al usuario
        nombre = Mensajes.pedirDatos("Introduzca el nombre del corredor", 
                "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

        minutos = Integer.parseInt(Mensajes.pedirDatos("Introduzca "
                + "la cantidad de minutos para el corredor", 
                "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));

        segundos = Integer.parseInt(Mensajes.pedirDatos("Introduzca la cantidad de "
                + "segundos para el corredor: ", "Petición de datos", 
                Mensajes.TipoMensaje.PREGUNTA));        }
    }
}
