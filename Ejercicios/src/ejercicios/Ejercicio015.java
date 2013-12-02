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
 * Ejercicio 15: Leer dos caracteres y deducir si están en orden alfabético
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio015 
{
    
    public void ejercicio()
    {
    
        // Definición de array de las letras del abecedario
        char[] vector = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        // Variables para almacenar las letras introducidas
        char letra1, letra2;
        
        // Variables de control
        int control, posLetra1 = 0, posLetra2 = 0;
        
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();
        
        // Petición de datos al usuario
        letra1 = msg.PedirDatos("Introduzca la primera letra", 
                "Petición de datos", 
                Mensajes.TipoMensaje.PREGUNTA).charAt(0);

        letra2 = msg.PedirDatos("Introduzca la segunda letra", 
                "Petición de datos", 
                Mensajes.TipoMensaje.PREGUNTA).charAt(0);
        control = 0;
        
        // Recorremos el array de las letras del abecedario y cuando encontremos
        // una de la letras que ha introducido el usuario, guardamos su posición
        while (control <27) 
        {            
            // Primera letra encontrada
            if(vector[control] == letra1)
            {
                // Valor de la letra almacenado
                posLetra1 = control;
            }
            
            // Segunda letra encontrada
            if(vector[control] == letra2)
            {
                // Valor de la letra almcenado
                posLetra2 = control;
            }
            control++;
        }
        
        // Si la posición de la primera letra es inferior al de la segunda,
        // están ordenadas
        if(posLetra1 < posLetra2)
        {
            msg.MostrarMensaje("Están ordenadas alfabeticamente", 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);
        }
        else
        {
            msg.MostrarMensaje("No están ordenadas alfabeticamente", 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);
        }

        
    }
    
}
