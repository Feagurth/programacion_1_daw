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
 * Realizar un subprograma que calcule la suma de los divisores de n distintos
 * de n
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio060 {

    /**
     * Función para calcular la suma de los divisores de un número
     *
     * @param valorNumero Número al que calcular la suma de sus divisores
     * @return Suma de los divisores del número
     */
    private int sumaDivisores(int valorNumero) {
        // Variables
        int suma = 0;

        // Iteramos por todos los números hasta el seleccionado
        for (int i = 1; i < valorNumero; i++) {
            // Si el numero es divisible por el número de iteración
            if (valorNumero % i == 0) {
                // Sumamos el número de la iteración al resultado
                suma += i;
            }
        }

        // Devolvemos la suma de los divisores
        return suma;
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables
        int numero;

        // Petición de datos al usuario
        numero = Integer.parseInt(Mensajes.pedirDatos("Introduzca un número",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        // Mostrar resultados
        Mensajes.mostrarMensaje("La suma de los divisores de " + numero + " es: "
                + sumaDivisores(numero), "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }

}
