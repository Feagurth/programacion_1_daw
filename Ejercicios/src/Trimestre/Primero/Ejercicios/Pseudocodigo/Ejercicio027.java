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
 * Realizar un diagrama que permita realizar un contador e imprimir 
 * los 100 primeros números enteros
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio027 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio(){
        
        // Objeto para mostrar y pedir información al usuario
        Mensajes msg = new Mensajes();
    
        // Variables
        String resultado = "";
        
        for (int i = 1; i <= 100; i++) {
            resultado += i + " ";
        }

        // Muestra de resultados
        msg.MostrarMensaje(resultado, "Resultado", Mensajes.TipoMensaje.INFORMACION);
    
    }
    
}
