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
package Trimestre.Segundo.Ejercicios.LibroPdf;

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * Escriba una aplicación que reciba del usuario un número compuesto por cinco 
 * dígitos, que separe ese número en sus dígitos individuales y los imprima, 
 * cada uno separado de los demás por tres espacios. Por ejemplo, si el usuario 
 * escribe el número 42339, el programa debe imprimir 4   2   3   3   9
 * Suponga que el usuario escribe el número correcto de dígitos. ¿Qué ocurre 
 * cuando ejecuta el programa y escribe un número con más de cinco dígitos? 
 * ¿Qué ocurre cuando ejecuta el programa y escribe un número con menos de 
 * cinco dígitos? 
 * [Sugerencia: es posible hacer este ejercicio con las técnicas que aprendió 
 * en este capítulo. Necesitará utilizar los operadores de división y residuo 
 * para “seleccionar” cada dígito].
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio2_30 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        
        // Declaración de variables
        int numero, cociente;
        String resultado = "";
        
        // Petición de datos al usuario 
        numero = PeticionDatos.pedirEnteroRango("Introduzca un número entero [10000-99999]", 10000, 99999);

        // Dividimos entre 10000 pasa sacar el primer númeor
        cociente = numero / 10000;
       // Calculamos el resto de la division entre 1000 y ese será el nuevo
        // número
        numero = numero % 10000;

        resultado = resultado + cociente + "   ";

        // Dividimos entre 1000 pasa sacar el segundo número
        cociente = numero / 1000;
       // Calculamos el resto de la division entre 1000 y ese será el nuevo
        // número
        numero = numero % 1000;
        resultado = resultado + cociente + "   ";

        // Dividimos entre 100 pasa sacar el tercer número
        cociente = numero / 100;
       // Calculamos el resto de la division entre 100 y ese será el nuevo
        // número
        numero = numero % 100;

        resultado = resultado + cociente + "   ";

        // Dividimos entre 10 pasa sacar el cuarto número
        cociente = numero / 10;
       // Calculamos el resto de la division entre 10 y ese será el nuevo
        // número
        numero = numero % 10;

        resultado = resultado + cociente + "   ";

        // Dividimos entre 1 pasa sacar el último número
        cociente = numero / 1;

        resultado = resultado + cociente + "   ";

        // Mostramos el resultado al usuario
        Mensajes.mostrarMensaje(resultado, Mensajes.TipoMensaje.INFORMACION);

    }

}
