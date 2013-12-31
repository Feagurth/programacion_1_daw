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
 * Diseñar un procedimiento que permita convertir coordenadas polares (radio,
 * ángulo) en cartesianas (x,y)
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio054 {

    private Coordenadas CoordenadasPolares(double radio, double angulo) {

        // Variables
        double valorX, valorY;

        // Calculamos los valores de x e y
        valorX = Math.cos(angulo) * radio;
        valorY = Math.sin(angulo) * radio;

        // Devolvemos el resultado
        return new Coordenadas(valorX, valorY);
    }

    public void Ejercicio() {

        // Objeto para mostrar y pedir datos al usuario
        Mensajes mensaje = new Mensajes();

        // Variable paa almacenar el resultado
        Coordenadas resultado;

        // Variables
        double angulo, radio;

        // Petición de datos al usuario
        angulo = Double.parseDouble(mensaje.PedirDatos("Introduzca el valor "
                + "del angulo", "Petición de Datos",
                Mensajes.TipoMensaje.PREGUNTA));

        radio = Double.parseDouble(mensaje.PedirDatos("Introduzca el valor "
                + "del radio", "Petición de Datos",
                Mensajes.TipoMensaje.PREGUNTA));

        // llamamos la función
        resultado = CoordenadasPolares(radio, angulo);

        // Mostramos resultados
        mensaje.MostrarMensaje("La coordenada es: (" + resultado.getX()
                + ", " + resultado.getY() + ")", "Resultado",
                Mensajes.TipoMensaje.INFORMACION);
    }

    /**
     * Clase para devolver el resultado de la función CoordenadasPolares
     */
    private static class Coordenadas {

        /**
         * Variable para el valor x
         */
        final double x;

        /**
         * Variable para el valor y
         */
        final double y;

        /**
         * Constructor de la clase
         *
         * @param x valor x
         * @param y valor y
         */
        public Coordenadas(double x, double y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Devuelv el valor de x
         *
         * @return el valor de x
         */
        public double getX() {
            return x;
        }

        /**
         * Devuelve el valor de y
         *
         * @return El valo de y
         */
        public double getY() {
            return y;
        }
    }
}
