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
 * Visualizar los múltiplos de 4 comprendidos entre 4 y N, donde N es un 
 * número introducido por teclado
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio026 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio(){
    
        // Objeto para mostrar y tomar datos del usuario
        Mensajes msg = new Mensajes();
        
        // Variables
        int numero;
        String cadena = "";
        
        numero = Integer.parseInt(msg.PedirDatos("Introduzca el limite de la secuencia", 
                "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));
        
        for (int i = 4; i <= numero; i += 4) {
            cadena += i + " ";
        }
        
        
        msg.MostrarMensaje(cadena, "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }
    
}
