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
 * Diseñar una función que permita obtener el valor absoluto de un número
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio052 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Variables
        int valor;

        // Petición de datos al usuario
        valor = Integer.parseInt(Mensajes.pedirDatos("Introduzca un valor", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        
        // Muestra de resultados
        Mensajes.mostrarMensaje("El valor absoluto es: " + ValorAbsoluto(valor), 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }    
    
    /**
     * Función que nos permite obtener el valor absoluto de un número
     * @param numero Número del que queremos obtener el valor absoluto
     * @return Valor absoluto del número introducido
     */
    private int ValorAbsoluto(int numero)
    {
        // Comprobamos si es mayor que cero(positivo)
        // Si lo es, lo devolvemos tal cual, si no, lo devolvemos 
        // multiplicado por -1
        if(numero > 0)
        {
            return numero;
        }
        else
        {
            return numero * -1;
        }
    }    
}
