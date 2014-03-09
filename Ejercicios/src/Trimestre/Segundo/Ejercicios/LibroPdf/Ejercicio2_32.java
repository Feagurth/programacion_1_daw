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
 * Escriba un programa que reciba cinco números, y que determine e imprima la
 * cantidad de números negativos, positivos, y la cantidad de ceros recibidos.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio2_32 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Declaración de variables
        int numero1, numero2, numero3, numero4, numero5;
        int positivos = 0, negativos = 0, ceros = 0;
        
        // Petición de datos al usuario
        numero1 = PeticionDatos.pedirEntero("Introduzca el valor del primer número");

        numero2 = PeticionDatos.pedirEntero("Introduzca el valor del segundo número");

        numero3 = PeticionDatos.pedirEntero("Introduzca el valor del tercer número");

        numero4 = PeticionDatos.pedirEntero("Introduzca el valor del cuarto número");

        numero5 = PeticionDatos.pedirEntero("Introduzca el valor del quinto número");

        // Comprobamos el valor de numero1
        if (numero1 == 0) {
            ceros++;
        } else {
            if (numero1 > 0) {
                positivos++;
            } else {
                negativos++;
            }
        }

        // Comprobamos el valor de numero2
        if (numero2 == 0) {
            ceros++;
        } else {
            if (numero2 > 0) {
                positivos++;
            } else {
                negativos++;
            }
        }

        // Comprobamos el valor de numero3
        if (numero3 == 0) {
            ceros++;
        } else {
            if (numero3 > 0) {
                positivos++;
            } else {
                negativos++;
            }
        }

        // Comprobamos el valor de numero4
        if (numero4 == 0) {
            ceros++;
        } else {
            if (numero4 > 0) {
                positivos++;
            } else {
                negativos++;
            }
        }

        // Comprobamos el valor de numero5
        if (numero5 == 0) {
            ceros++;
        } else {
            if (numero5 > 0) {
                positivos++;
            } else {
                negativos++;
            }
        }

        // Mostramos los resultados
        String resultado;

        resultado = "Positivos: " + positivos;
        resultado += "\nCeros: " + ceros;
        resultado += "\nNegativos: " + negativos;
        
        Mensajes.mostrarMensaje(resultado, Mensajes.TipoMensaje.INFORMACION);

    }
}
