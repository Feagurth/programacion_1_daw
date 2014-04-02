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
import java.math.BigDecimal;

/**
 * Diseña una función que permita obtener el factorial de un número entero
 * positivo.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio055 {

    /**
     * Función para calcular el factorial de un número
     * @param valor Numero del que se quiere calcular el factorial
     * @return Valor del factorial
     */
    private BigDecimal factorial(int valor) {
        
        // Inicializamos la variable
        BigDecimal resultado = BigDecimal.ONE;
        
        // Ireramos multiplicando el resultado por el valor anterior
        for (int i = valor; i > 1; i--) {
            resultado = resultado.multiply(BigDecimal.valueOf(i));
        }

        return resultado;
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

        // Mostramos información al usuario
        Mensajes.mostrarMensaje("El factorial de " + numero + " es " + 
                factorial(numero).stripTrailingZeros().toEngineeringString()
                ,
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }
}
