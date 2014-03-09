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
 * Dados tres números, deducir cual es el central.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio030 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Variables
        int numero1, numero2, numero3;
        String cadena;
        
        // Petición de datos al usuario
        numero1 = Integer.parseInt(Mensajes.pedirDatos("Introduzca un valor para el "
                + "primer número", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        numero2 = Integer.parseInt(Mensajes.pedirDatos("Introduzca un valor para el "
                + "segundo número", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        numero3 = Integer.parseInt(Mensajes.pedirDatos("Introduzca un valor para el "
                + "tercer número", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        // Comparando los valores
        if(numero1 > numero2)
        {
            if(numero1 < numero3)
            {
                cadena = "El número del medio es: " + numero1;
            }
            else
            {
                if(numero2 < numero3)
                {
                    cadena = "El número del medio es: " + numero3;
                }
                else
                {
                    cadena = "El número del medio es: " + numero2;
                }            
            }
        }
        else
        {
            if(numero2 < numero3)
            {
                cadena = "El número del medio es: " + numero2;
            }
            else
            {
                if(numero3 < numero1)
                {
                    cadena = "El número del medio es: " + numero1;
                }
                else
                {
                    cadena = "El número del medio es: " + numero3;
                }
            }
        }
        
        // Muestra de resultados al usuario
        Mensajes.mostrarMensaje(cadena, "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }
}
