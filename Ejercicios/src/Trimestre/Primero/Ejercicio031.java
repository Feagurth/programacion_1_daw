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
 * Calcular la raíz cuadrada de un número y escribir el resultado
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio031 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio(){
        // Objeto para mosrtar y tomar datos al usuario
        Mensajes msg = new Mensajes();
        
        // Variables
        int numero, contador = 1;
        
        // Petición de datos al usuario
        numero = Integer.parseInt(msg.PedirDatos("Introduzca un número", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        // Iteramos mientras la potencia de 2 del contador sea distinta 
        // del numero introducido
        while (Math.pow(contador, 2) != numero) 
        {            

            // Si la potencia de dos del contador es superior al numero 
            // introducido nos hemos pasado y el resultado mas aproximado será
            // el valor anterior de contador
            if(Math.pow(contador, 2) > numero)
            {
                // Quitamos uno al contador y salimos del bucle con break
                contador -= 1;
                break;
            }
            else
            {
                // Si no nos hemos pasado, seguimos iterando
                contador += 1;
            }
        }
        
        // Muestra de resultados
        msg.MostrarMensaje("La raiz cuadrada de " + numero + " es: " + contador,
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }  
}
