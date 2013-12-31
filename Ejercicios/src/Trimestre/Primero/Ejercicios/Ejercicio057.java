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
 * Realizar una función que permita saber si una fecha es válida.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio057 {

    /**
     * Función para comprobar si un año es bisiesto
     *
     * @param anyo Año a comprobar
     * @return Resultado de la comprobación
     */
    private boolean EsAnyoBisiesto(int anyo) {
        // Para verificar si un año es bisiesto se tiene que verificar esta
        // condición
        return (anyo % 4 == 0) && ((anyo % 100 != 0) || (anyo % 400 == 0));
    }

    /**
     * Función para comprobar si una fecha es válida
     * @param numdia Día 
     * @param numMes Mes
     * @param numAnyo Año
     * @return Resultado de la comprobación
     */
    private boolean EsFechaValida(int numdia, int numMes, int numAnyo) {
        int[] dias = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Comprobamos que los valores introducidos sean positivos
        if (numdia <= 0 || numMes <= 0 || numAnyo < 0 || numMes > 12) {
            return false;
        } else {
            // Verificamos si el año es bisiesto y si es febrero
            if (EsAnyoBisiesto(numAnyo) && numMes == 2) {
                // Devolvemos la comprobación de si el dia está en los dias
                // que tiene el mes mas 1 dia por ser bisiesto Febrero                
                return numdia <= (dias[numMes - 1] + 1);
            } else {
                // Devolvemos la comprobación de si el dia está en los dias
                // que tiene el mes
                return numdia <= dias[numMes - 1];
            }
        }
    }

public void Ejercicio() {
    
    // Objeto para pedir o mostrar datos al usuario
    Mensajes mensaje = new Mensajes();
    
    // Variables
    int dia, mes, anyo;
    boolean resultado;
    
    // Petición de datos al usuario
    dia = Integer.parseInt(mensaje.PedirDatos("Introduzca un valor numérico "
            + "para el día", "Petición de Datos", 
            Mensajes.TipoMensaje.PREGUNTA));

    mes = Integer.parseInt(mensaje.PedirDatos("Introduzca un valor numérico "
            + "para el mes", "Petición de Datos", 
            Mensajes.TipoMensaje.PREGUNTA));
    
    anyo = Integer.parseInt(mensaje.PedirDatos("Introduzca un valor numérico "
            + "para el año", "Petición de Datos", 
            Mensajes.TipoMensaje.PREGUNTA));
    
    // Llamamos a la función
    resultado = EsFechaValida(dia, mes, anyo);
        
    // Mostramos resultado
    mensaje.MostrarMensaje("La fecha " + dia + "/" + mes + "/" + anyo + 
            " es valida: " + (resultado ? "Verdadero" : "Falso"), "Resultado", 
            Mensajes.TipoMensaje.INFORMACION);
    }
}
