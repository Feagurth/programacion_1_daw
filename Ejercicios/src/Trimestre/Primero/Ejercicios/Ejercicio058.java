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
 * Desarrollar un algoritmo que calcule la potencia de n de un numero suponiendo
 * que no tenemos la función primitiva para calcular potencia. Usa programación 
 * modular.
 * Tener en cuenta que 0^0 es una indeterminación, que x^0 es 1 0^y es 0 y 
 * si y< 0 → x ^-y = 1/ x^y y si x = 0 e y < 0 que da indeterminación
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio058 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Objeto para mostrar y tomar datos del usuario
        Mensajes msg = new Mensajes();
        
        // Variables
        Double base, resultado;
        int exponente;
        
        // Petición de datos al usuario
        base = Double.parseDouble(msg.PedirDatos("Introduzca un valor para la base", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        exponente = Integer.parseInt(msg.PedirDatos("Introduzca un entero para "
                + "el exponente", "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        // Ejecutamos la función de potenciación
        resultado = Potencia(base, exponente);
        
        // Mostramos el resultado
        msg.MostrarMensaje("El resultado es: " + resultado, "Resultado", 
                Mensajes.TipoMensaje.INFORMACION);        
    }
    
    
    private Double Potencia(Double valorBase, int valorExponente)
    {
        Double resultado;
        
        // Verificamos los casos básicos
        // Base y exponente 0
        if (valorExponente == 0 && valorBase == 0) 
        {
            return Double.NaN;
        }
        else 
            // Base 0 y exponente != 0
            if( valorExponente < 0 && valorBase == 0)
            {
                return Double.NaN;
            }
            else
            {
                // Exponente 0 y base != 0
                if(valorExponente == 0 && valorBase != 0)
                {
                    return 1.00;
                }
                else
                {
                    // Exponente != 0 y base = 0
                    if(valorExponente != 0 && valorBase == 0)
                    {
                        return 0.00;
                    }
                    else // el resto de caso normales
                    {
                        resultado = valorBase;
                        for (int i = 2; i <= valorAbsoluto(valorExponente); i++) {
                            resultado *= valorBase;                            
                        }
                    }
                }
            }
        
        
        // Devolvemos el resultado tras verificar que si exponente es negativo
        if(valorExponente < 0)
        {
            return (1 / resultado);
        }
        else
        {
            return resultado;
        }        
    }

    /**
     * Función para calcular el valor absoluto de un número
     * @param valor Valor de entrada
     * @return Valor absoluto del valor de entrada
     */
    private int valorAbsoluto(int valor)
    {
        // Comprobamos si el número es negativo
        if (valor < 0) {
            // Si lo es, multiplicamos por -1 para obtener su valor absoluto
            valor *= -1;
        }
        
        return valor;    
    }        
}
