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

package Trimestre.Primero.Ejercicios.Pseudocodigo;

import Utiles.Mensajes;

/**
 * Calcular la media de 50 números introducidos por teclado y 
 * visualizar su resultado.        
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio025 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio(){
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();
        
        // Variables
        int numero, suma = 0, contador = 0;
    
        
        // Iteramos 
        while (contador < 50) {            
            contador++;
            
            // Petición de datos al usuario
            numero = Integer.parseInt(msg.PedirDatos("Introduzca el número " + contador, 
                    "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));
            
            // Acumulamos el número introducido a la suma existente
            suma += numero;
            
        }
                
        // Muestra de resultados al usuario
        msg.MostrarMensaje("El resultado es: " + suma, 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }
    
}
