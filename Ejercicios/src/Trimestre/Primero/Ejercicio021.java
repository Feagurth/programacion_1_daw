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
 * Se trata de escribir el algoritmo que permita emitir la factura 
 * correspondiente a una compra de un artículo determinado del que se adquieren 
 * una o varias unidades. El IVA a aplicar es del 12% y si el precio bruto 
 * (precio de venta + IVA) es mayor de 50.000 pesetas, se aplicará un descuento 
 * del 5%.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio021 {
    
    /**
    * Ejercicio principal
    */
    public void ejercicio()
    {
        
        // Precio del artículo
        final int VALOR_ARTICULO = 500;
      
        // Objeto para mensajes y recogida de datos
        Mensajes msg = new Mensajes();
        
        int unidades;
        double precioTotal;

        // Iteramos hasta que el usuario introduzca un número de unidades positivo
        do 
        {            
            // Petición de datos al usuario
            unidades = Integer.parseInt(msg.PedirDatos(
                    "Introduzca el número de unidades a comprar", 
                    "Introduzca datos", Mensajes.TipoMensaje.PREGUNTA));
            
        } while (unidades <= 0);
        
        // Calculamos el precio de los artículos
        precioTotal = VALOR_ARTICULO * unidades;
        
        // Sumamos el IVA
        precioTotal = precioTotal + (precioTotal *0.12);
        
        // Si el precio es superior a 50000
        if (precioTotal > 50000) {
            
            // Aplicamos una rebaja del 5%
            precioTotal = precioTotal - (precioTotal *0.05);
        }
        
        // Muestra de resulados al usuario
        msg.MostrarMensaje("El precio total es: " + precioTotal, 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);

    }
}
