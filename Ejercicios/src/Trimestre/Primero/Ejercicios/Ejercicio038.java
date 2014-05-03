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
import Utiles.PeticionDatos;
import java.util.Locale;

/**
 * Se desea un algoritmo que realice la operación de suma o resta de dos 
 * números leídos del teclado en función de la respuesta S o R (suma o resta) 
 * que se dé a un mensaje de petición de datos.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio038 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio(){
    
        // Variables
        int  numero1, numero2;
        int operacion;
        
        // Petición de datos
        numero1 = Integer.parseInt(Mensajes.pedirDatos("Introduzca el primer número", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        numero2 = Integer.parseInt(Mensajes.pedirDatos("Introduzca el segundo número", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        operacion = Mensajes.pedirConfirmacion("Seleccione una operación", new String[]{"Suma", "Resta"});

        // Realizamos una operación u otra dependiendo de la opción seleccionada
        if (operacion == 0) {
            numero1 = numero1 + numero2;
        }
        else
        {
            numero1 = numero1 - numero2;
        }
        
        // Muestra de resultados
        Mensajes.mostrarMensaje("El resultado es: " + numero1, 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);        
    }
}
