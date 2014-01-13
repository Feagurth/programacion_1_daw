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

package Trimestre.Segundo.Ejercicios.LibroPdf;

import Utiles.Mensajes;

/**
 * Clase para realizar el ejercicio 5.17 del libro de texto Como Programar en
 * Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_17 {
    
    public void Ejercicio()
    {
        // Objeto para pedir y mostrar mensajes al usuario
        Mensajes mensaje = new Mensajes();
        
        // Variables
        int codigoArticulo;
        double total = 0f;
        
        do {                     
            // Pedimos datos al usuario
            codigoArticulo = Integer.parseInt(mensaje.PedirDatos("Introduzca "
                    + "el código de articulo. 0 para salir", "Petición de "
                            + "Datos", Mensajes.TipoMensaje.PREGUNTA));
            
            // Comprobamos el artículo introducido y sumamos su precio
            switch(codigoArticulo)
            {
                case 1:
                    total += 2.98f;
                    break;
                case 2:
                    total += 4.50f;
                    break;
                case 3:
                    total += 9.98f;
                    break;
                case 4:
                    total += 4.49f;
                    break;
                case 5:
                    total += 6.78f;
                    break;
            }
            
        // Si se cumple la condición salimos de la iteración    
        } while (codigoArticulo != 0);
                
        // Mostramos resultados
        mensaje.MostrarMensaje("El total es: " + String.format("%.2f", total)  , "Información", 
                Mensajes.TipoMensaje.INFORMACION);
    }
}
