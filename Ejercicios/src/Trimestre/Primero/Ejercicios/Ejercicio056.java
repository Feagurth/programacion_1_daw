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
 * Diseñar una función que permita obtener el máximo común divisor de dos 
 * números mediante el algoritmo de Euclides.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio056 {
    
    /**
     * Función para calcular el Máximo Común Divisor de dos valores
     * @param valor1 Primer valor
     * @param valor2 Segundo valor
     * @return Máximo Común Divisor de los dos números
     */
    private int MCD(int valor1, int valor2)
    {
        int numero1, numero2, resto;
        
        // Comprobamos que número es mayor e inicializamos las variables
        // en consecuencia
        if(valor1 > valor2)
        {
            numero1 = valor1;
            numero2 = valor2;
            resto = valor2;
        }
        else
        {
            numero1 = valor2;
            numero2 = valor1;
            resto = valor1;
        }
    
        // Iteramos mientras el resto de la división no sea cero
        while(numero1 % numero2 != 0)
        {
            // Calculamos los valores en cada iteración
            resto = numero1 % numero2;
            numero1 = numero2;
            numero2 = resto;
        }        
        
        // Devolvemos el resto, el cual será el MCD
        return resto;        
    }
    
    public void Ejercicio()
    {
        // Objeto para mostrar y pedir datos al usuario
        Mensajes mensaje = new Mensajes();
        
        // Variables
        int num1, num2, resultado;    
        
        // Petición de datos al usuario
        num1 = Integer.parseInt(mensaje.PedirDatos("Introduzca el primer "
                + "valor", "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        num2 = Integer.parseInt(mensaje.PedirDatos("Introduzca el segundo "
                + "valor", "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));        
    
        // Calculamos el maximo comun divisor
        resultado = MCD(num1, num2);
        
        // Mostramos el resultado
        mensaje.MostrarMensaje("El máximo común divisor de " + num1 + 
                " y de " + num2 + " es " + resultado, "Resultado", 
                Mensajes.TipoMensaje.INFORMACION);
    }    
}
