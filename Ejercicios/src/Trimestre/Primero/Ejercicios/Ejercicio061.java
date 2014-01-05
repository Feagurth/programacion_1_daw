/*
 * Copyright (C) 2014 Luis Cabrerizo Gómez
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
 * Dos números son amigos si cada uno de ellos es igual a la suma de los 
 * divisores del otro. Por ejemplo, 220 y 284 son amigos.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio061 {
    
    /**
     * Función para calcular la suma de los divisores de un número
     * @param valorNumero Numero del que queremos calcular la suma de los 
     * divisores
     * @return La suma de los divisores del número
     */
    private int SumaDivisores(int valorNumero)
    {
        // Variables
        int resultado = 0;
    
        // Iteramos por todos los números naturales desde 1 hasta el valor del
        // número menos 1, para evitar dividir por si mismo
        for (int i = 1; i < valorNumero -1; i++) {
            
            // Verificamos si el número es divisible por el valor de la 
            // iteración
            if(valorNumero % i == 0)
            {
                // Si es divisible sumamos el valor de la iteración al
                // resultado
                resultado += i;
            }
        }
        
        // Devolvemos el resultado
        return resultado;
    }
    
    
    /**
     * Función para comprobar si dos números son amigos. Dos números son amigos
     * cuando la suma de divisores del primero es igual al valor del segundo y 
     * viceversa
     * @param valorNumero1 Valor del primer número
     * @param valorNumero2 Valor del segundo número
     * @return Si los números son amigos
     */
    private boolean SonAmigos(int valorNumero1, int valorNumero2)
    {
        // Verificamos si los numeros son amigos y devolvemos el valor
        // correspondiente
        return SumaDivisores(valorNumero1) == valorNumero2 &&
                SumaDivisores(valorNumero2) == valorNumero1;
    }
    
    public void Ejercicio()
    {
        // Objeto para pedir y mostrar información al usuario
        Mensajes mensaje = new Mensajes();

       // Variables
       int numero1, numero2;
              
       // Petición de datos al usuario
       numero1 = Integer.parseInt(mensaje.PedirDatos("Introduzca el valor del "
               + "primer número", "Petición de Datos", 
               Mensajes.TipoMensaje.PREGUNTA));

       numero2 = Integer.parseInt(mensaje.PedirDatos("Introduzca el valor del "
               + "segundo número", "Petición de Datos", 
               Mensajes.TipoMensaje.PREGUNTA));
       
       // Verificamos si son amigo y mostramos el resultado correspondiente
       if(SonAmigos(numero1, numero2))
       {
           mensaje.MostrarMensaje(numero1 + " y " + numero2 + " son amigos", 
                   "Resultado", Mensajes.TipoMensaje.INFORMACION);
       }
       else
       {
           mensaje.MostrarMensaje(numero1 + " y " + numero2 + " no son amigos", 
                   "Resultado", Mensajes.TipoMensaje.INFORMACION);       
       }
    }    
}
