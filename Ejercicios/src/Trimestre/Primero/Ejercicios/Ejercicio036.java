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
 * Realiza un algoritmo que averigüe si dados dos números introducidos por 
 * teclado, uno es divisor del otro.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio036 {

    /**
     * Ejercicio principal
     */
    public void ejercicio(){
    
        // Objeto para pedir y mostrar datos al usuarios
        Mensajes msg = new Mensajes();
                
        // Variables
        int numero1, numero2;
        boolean control = false;
        
        // Petición de datos
        numero1 = Integer.parseInt(msg.PedirDatos("Introduzca el primer número",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        numero2 = Integer.parseInt(msg.PedirDatos("Introduzca el segundo número",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));        

        // Comprobamos si un numero es divisible por el otro y viceversa
        if (numero1 % numero2 == 0) {
            control = true;
            
        }
        if (!control && (numero2 % numero1 == 0)) {
            control = true;
        }
        
        // Muestra de resultados dependiendo del valor de control
        if(control)
        {
            msg.MostrarMensaje("Uno es divisor de el otro", 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);
        }
        else
        {
            msg.MostrarMensaje("Uno no es divisor de el otro", 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);        
        }
    }
    
}
