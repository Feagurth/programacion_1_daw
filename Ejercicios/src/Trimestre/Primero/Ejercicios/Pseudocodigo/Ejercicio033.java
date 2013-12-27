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
 * Determinar el precio de un billete de ida y vuelta en ferrocarril, conociendo 
 * la distancia a recorrer y sabiendo que si el número de días de estancia es 
 * superior a siete y la distancia superior a 800 kilómetros el billete tiene 
 * una reducción del 30%. El precio por kilómetro es de 2,5 pesetas.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio033 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Objeto para petición y muestra de datos al usuario
        Mensajes msg = new Mensajes();
        
        // Constante que define el precio por km
        final double PRECIO_KM = 2.5;
        
        // Variables
        int numKms, diasEstancia;
        double precio;
                
        // Petición de datos al usuario
        diasEstancia = Integer.parseInt(msg.PedirDatos("Introduzca el número "
                + "de días de estancia", "Petición de datos", 
                Mensajes.TipoMensaje.PREGUNTA));

        numKms = Integer.parseInt(msg.PedirDatos("Introduzca la distancia"
                + " en kms", "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));
        
        // Calculamos el precio del billete
        precio = 2 * numKms * PRECIO_KM;
        
        // Si el usuario está mas de 7 dias de estancia y recorre mas de 800 kms
        // aplicamos un descuento del 30%
        if(diasEstancia > 7 && numKms > 800)
        {
            precio -= (precio * 0.30);
        }
        
        // Muestra de resultados
        msg.MostrarMensaje("El precio del billete es: " + precio, 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);    
    }
    
}
