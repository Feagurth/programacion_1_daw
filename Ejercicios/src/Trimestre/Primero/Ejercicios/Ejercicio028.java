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
 * Dados 10 números enteros que introduciremos por teclado, visualizar la 
 * suma de los números pares de la lista, cuántos números pares existen y 
 * cuál es la media aritmética de los números impares.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio028 {

    /**
     * Ejercicio principal
     */
    public void ejercicio(){
    
        // Variables
        int numero, sumapar = 0, sumaimpar = 0, pares = 0, impares = 0, contador = 0;
        
        // Iteramos mientras el contador no supere los 10 números
        while (contador < 10)
        {            
            // Petición de datos
            numero = Integer.parseInt(Mensajes.pedirDatos("Introduzca un numero", 
                    "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
            
            // Comprobamos si el número es mayor de cero para contarlo entre
            // los 10 números pedidos
            if(numero > 0)
            {
                contador += 1;            
            }
            
            // Comprobamos si es par o impar hayando el resto entre 2
            if(numero % 2 == 0)
            {
                sumaimpar += numero;
                impares += 1;
            }
            else
            {
                sumapar += numero;
                pares += 1;
            }
        }
        
        // Mostrar resultados
        Mensajes.mostrarMensaje("Suma de pares: " + sumapar + "\nSuma de "
                + "impares : " + sumaimpar + "\nMedia aritmética entre pares e "
                + "impares: " + (sumapar / (float)sumapar), 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }
}
