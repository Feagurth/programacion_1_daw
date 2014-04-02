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
 * Realizar tres funciones que permitan hallar el valor de π mediante las 
 * series matemáticas siguientes
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio059 {
   
    /**
     * Función para calcular el valor de pi
     * @param iteraciones Número de iteraciones a realizar
     * @return Valor aproximado de pi
     */
    private float calcularPiMetodoA(int iteraciones)
    {
        float resultado = 0f;
        int contador = 1;
        
        // Iteramos tantas veces como se nos haya establecido multiplicado
        // por dos, pues solo iteraremos los números impares
        for (int i = 1; i <= iteraciones * 2; i += 2) {

            // Si el contador es impar se suma, si no, se resta
            if(contador % 2 == 0)
            {
                resultado -= (1f/i);
            }
            else
            {
                resultado += (1f/i);
            }
            contador++;
        }
        
        // Devolemos el resultado multiplicado por 4
        return resultado * 4f;
    }
    
    /**
     * Función para calcular el valor aproximado de Pi
     * @param iteraciones Número de iteraciones
     * @return Valor aproximado de Pi
     */
    private float calcularPiMetodoB(int iteraciones)
    {
        float resultado = 0;
    
        // Acumulamos en el resultado el valor de 24 dividido entre el cuadradro
        // del numero de la iteración
        for (int i = 1; i <=  iteraciones; i++) {
            resultado +=(24f/(Math.pow(i, 2)));
        }
        
        // Devolvemos el valor de la raiz cuadrada del resultado multiplicada
        // por 1/2
        return (float) ((1/2f) * Math.sqrt(resultado));
    }
    
    /**
     * Función para calcular el valor aproximado de pi
     * @param iteraciones Número de iteraciones
     * @return Valor aproximado de pi
     */
    private float calcularPiMetodoC(int iteraciones)
    {
        // Variables
        int apoyo1 = 2, apoyo2 = 1;
        float resultado = 4f; 
    
        
        // Realizamos tantas iteraciones como se nos indique
        for (int i = 1; i <= iteraciones; i++) {

            // En cada iteración comprobamos si es una iteración par o impar
            // En las impares sumaremos dos al divisor y en las pares sumaremos
            // 2 al dividendo
            if(i % 2 == 0)
            {
                apoyo1 += 2;
            }
            else
            {
                apoyo2 += 2;
            }

            // Multiplicamos el resultado por la división de las dos variables
            // de apoyo
            resultado *= ((apoyo1) / (float)apoyo2);            
        }

        // Devolvemos el resultado
        return resultado;
    }
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Variables
        int ciclos;
        float pi;
        
        // Petición de datos al usuario
        ciclos = Integer.parseInt(Mensajes.pedirDatos("Introduzca el número "
                + "de ciclos", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
                
        // Ejecutamos el primer método
        pi = calcularPiMetodoA(ciclos);
        
        // Mostramos el resultado
        Mensajes.mostrarMensaje("Metodo A - Pi: " + pi, "Resultado", 
                Mensajes.TipoMensaje.INFORMACION);    
        
        // Ejecutamos el segundo método
        pi = calcularPiMetodoB(ciclos);
        
        // Mostramos el resultado
        Mensajes.mostrarMensaje("Metodo B - Pi: " + pi, "Resultado", 
                Mensajes.TipoMensaje.INFORMACION);    
        
        // Ejecutamos el tercer  método
        pi = calcularPiMetodoC(ciclos);
        
        // Mostramos el resultado
        Mensajes.mostrarMensaje("Metodo C - Pi: " + pi, "Resultado", 
                Mensajes.TipoMensaje.INFORMACION);            
        
    }    
}
