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
 * Se considera la serie definida por: a1=0, a2=1, an=3 * an-1 + 2 * an-2 
 * (para n>=3). Se desea obtener el valor y el rango del primer termino que 
 * sea mayor o igual que 1000
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio045 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Variables
        int numero = 0, valor, apoyo = 0, contador;
        
        // Iteramos mientras el valor sea menor de 1000
        do
        {   
            // Con cada iteración inicializamos el valor a 0 y 
            // aumentamos en 1 el valor del número
            numero = numero + 1;
            valor = 0;
            
            // Realizamos los calculos pertinentes
            for(contador = 1; contador < numero; contador++)
            {

                switch(contador)
                {                    
                    case 1:
                    {
                        apoyo = 0;
                        valor = valor + apoyo;
                        break;
                    }
                    case 2:
                    {
                        apoyo = 1;
                        valor = valor + apoyo;
                        break;
                    }
                    default:
                    {
                        apoyo = contador * apoyo;
                        valor = valor + apoyo;                            
                    }
                }
            
            }
        }while(valor < 1000);
        
        
        // Mostramos el resultado
        Mensajes.mostrarMensaje(String.valueOf(contador), "Información", 
                Mensajes.TipoMensaje.INFORMACION);                
    }
    
}
