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
 * Escribir un algoritmo que lea cuatro números y, a continuación, escriba el mayor de los cuatro.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio004 
{

    /**
    * Ejercicio principal
    */
    public void ejercicio()
    {
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();
        
        // Variables
        int numero1, numero2, numero3, numero4;
        String cadena;

        numero1 = Integer.parseInt(msg.PedirDatos("Introduzca un valor para "
                + "el número 1", "Petición de datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        numero2 = Integer.parseInt(msg.PedirDatos("Introduzca un valor para "
                + "el número 2", "Petición de datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        numero3 = Integer.parseInt(msg.PedirDatos("Introduzca un valor para "
                + "el número 3", "Petición de datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        numero4 = Integer.parseInt(msg.PedirDatos("Introduzca un valor para "
                + "el número 4", "Petición de datos", 
                Mensajes.TipoMensaje.PREGUNTA));

        
        // Verificación del número mayor
        if (numero1 > numero2) 
        {
            if (numero1 > numero3) 
            {
                if(numero1 > numero4)
                {
                    cadena = "El numero mayor es: " + numero1;
                }
                else
                {
                    cadena = "El numero mayor es: " + numero4;
                }
            }
            else
            {
                if (numero3 > numero4) 
                {
                    cadena = "El numero mayor es: " + numero3;
                }
                else
                {
                    cadena = "El numero mayor es: " + numero4;
                }
            }
        }
        else
        {
            if(numero2 > numero3)
            {
                if(numero2 > numero4)
                {
                    cadena = "El numero mayor es: " + numero2;
                }
                else
                {
                    cadena = "El numero mayor es: " + numero4;
                }
            }
            else
            {
                if(numero3 > numero4)
                {
                    cadena = "El numero mayor es: " + numero3;
                }
                else
                {
                    cadena = "El numero mayor es: " + numero4;
                }
            }               
        }
        
        // Muestra de resultados al usuario
        msg.MostrarMensaje(cadena, "Resultados", Mensajes.TipoMensaje.INFORMACION);
        
    }
}
