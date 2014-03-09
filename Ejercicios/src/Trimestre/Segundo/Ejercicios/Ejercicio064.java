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
package Trimestre.Segundo.Ejercicios;

import Utiles.Mensajes;

/**
 * Implementar una función Redondeo(a,b), que devuelva el número a redondeado a
 * b decimales.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio064 {

    /**
     * Función para realizar el redondeo de un número
     *
     * @param numero Número que queremos redondear
     * @param decimales Cantidad de decimales que tendrá el redondeo
     * @return Valor redondeado con los parámetros introducidos
     */
    public float Redondeo(float numero, int decimales) {
        // Variables
        float resultado;
        int parteEntera, parteDecimal;
        int apoyoDecimales;

       // Calculamos el valor por el que tendremos que multiplicar
        // los decimales para conseguir la parte entera del redondeo que
        // queremos
        apoyoDecimales = (int) Math.pow(10, decimales);

       // Calculamos la parte entera, obteniendo la división del número 
        // entre 1
        parteEntera = (int) (numero / 1);

       // Calculamos la parte decimal restandole al número la parte entera
        // Despues, multiplicamos el valor obtenido por el apoyo de decimales,
        // quedandonos la parte que queremos para el redondeo como la parte 
        // entera del numero obtenido, la cual conseguimos dividiendo ese
        // número entre 1
        parteDecimal = (int) ((numero - parteEntera) * apoyoDecimales) / 1;

       // Creamos una cadena con el número de la parte entera concatenado 
        // junto con un punto y la parte decimal, y parseamos la cadena
        // para obtener el resultado en float
        resultado = Float.parseFloat(parteEntera + "." + parteDecimal);

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variable para almacenar el valor a redondear
        float valor;

        // Variable para almacenar el valor de decimales a redondear
        int numDecimales;

        // Petición de datos al usuario
        valor = Float.parseFloat(Mensajes.pedirDatos("Introduzca un valor para "
                + "redondear", "Petición de Datos",
                Mensajes.TipoMensaje.PREGUNTA));

        numDecimales = Integer.parseInt(Mensajes.pedirDatos("Introduzca un valor "
                + "para el redondeo", "Petición de Datos",
                Mensajes.TipoMensaje.PREGUNTA));

        // Ejecutamos la función de redondeo
        valor = Redondeo(valor, numDecimales);

        // Mostramos el resultado al usuario
        Mensajes.mostrarMensaje("El resultado es: " + valor, "Resultado",
                Mensajes.TipoMensaje.INFORMACION);

    }
}
