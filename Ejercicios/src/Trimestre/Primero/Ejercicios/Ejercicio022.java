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
 * Calcular la suma de los cuadrados de los 100 primeros números naturales.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio022 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio(){
        int sumaCuadrados = 0;
        
        // Iteramos y acumulamos el cuadrado de el contador
        for (int i = 0; i < 100; i++) 
        {
            sumaCuadrados += Math.pow(i, 2);
        }
        
        // Mostramos el resultado al usuario
        Mensajes.mostrarMensaje("El resultado es: " + sumaCuadrados, 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }   
}
