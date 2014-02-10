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
package RelacionesDeEjercicios.Relacion1;

import java.util.Scanner;

/**
 * Crear la clase Punto con una interfaz que nos permita: a) Almacenar las
 * coordenadas b) Saber en qué cuadrante está
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio003 {

    public class Punto {

        // Variables
        int x;
        int y;

        /**
         * Función para recuperar el valor de la coordenada x del punto
         *
         * @return El valor de la coordenada x del punto
         */
        public int getX() {
            return x;
        }

        /**
         * Función para recuperar el valor de la coordenada y del punto
         *
         * @return El valor de la coordenada y del punto
         */
        public int getY() {
            return y;
        }

        /**
         * Constructor de la clase
         *
         * @param x Valor x de la coordenada del punto
         * @param y Valor y de la coordenada del punto
         */
        public Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Función que devuelve el valor del cuadrante donde se encuentre el
         * punto
         *
         * @return 0 si está en el centro 1 si está en el primer cuadrante 2 si
         * está en el segundo cuadrante 3 si está en el tercer cuadrante 4 si
         * está en el cuarto cuadrante 5 si está en la intersección entre el
         * primer cuadrante y el segundo 6 si está en la intersección entre el
         * segundo cuadrante y el tercero 7 si está en la intersección entre el
         * tercer cuadrante y el cuarto 8 si está en la intersección entre el
         * cuarto cuadrante y el primero
         */
        public int valorCuadranteExtendido() {
            // Inicializamos la variable de resultado a 0, y por tanto 
            // supondremos que inicialmente el punto está en (0,0), esto es, en
            // ningún cuadrante
            int resultado;

            // Comprobamos  si el valor x vale 0
            if (this.x == 0) {
                // Comprobamos si el valor y vale 0
                if (this.y == 0) {
                    // (0, 0)
                    resultado = 0;
                } else {
                    // Comprobamos si el valor y es mayor de cero
                    if (this.y > 0) {
                        // (0, +)
                        resultado = 5;
                    } else {
                        // (0, -)
                        resultado = 7;
                    }
                }
            } else {
                // Comprobamos si el valor y vale 0
                if (this.y == 0) {
                    // Comprobamos si el valor x es mayor de cero
                    if (this.x > 0) {
                        // (+, 0)
                        resultado = 8;
                    } else {
                        // (-, 0)
                        resultado = 6;
                    }
                } else {
                    // Comprobamos si el valor de x es mayor de cero
                    if (this.x > 0) {
                        // Comprobamos si el valor de y es mayor de cero
                        if (this.y > 0) {
                            // (+, +)
                            resultado = 1;
                        } else {
                            // (+, -)
                            resultado = 4;
                        }
                    } else {
                        // Comprobamos si el valor de y es mayor de cero
                        if (this.y > 0) {
                            // (-, +)
                            resultado = 2;
                        } else {
                            // (-, -)
                            resultado = 3;
                        }
                    }
                }
            }

            // Devolvemos el resultado
            return resultado;
        }

        /**
         * Función que devuelve el valor del cuadrante donde se encuentre el
         * punto
         *
         * @return 0 si está en el centro 1 si está en el primer cuadrante 2 si
         * está en el segundo cuadrante 3 si está en el tercer cuadrante 4 si
         * está en el cuarto cuadrante 1 si está en la intersección entre el
         * primer cuadrante y el segundo 2 si está en la intersección entre el
         * segundo cuadrante y el tercero 3 si está en la intersección entre el
         * tercer cuadrante y el cuarto 1 si está en la intersección entre el
         * cuarto cuadrante y el primero
         */
        public int valorCuadranteSimple() {
            int resultado = this.valorCuadranteExtendido();

            switch (resultado) {
                case 5:
                    resultado = 1;
                    break;
                case 6:
                    resultado = 2;
                    break;
                case 7:
                    resultado = 3;
                    break;
                case 8:
                    resultado = 1;
                    break;
            }
            return resultado;
        }

    }

    public void Ejercicio() {
        // Objeto para recoger información desde el teclado
        Scanner entrada = new Scanner(System.in);

        // Petición de datos al usuario
        System.out.print("Introduzca la coordenada x del punto: ");
        int x = entrada.nextInt();

        System.out.print("Introduzca la coordenada y del punto: ");
        int y = entrada.nextInt();

        // Creación del objeto
        Punto punto = new Punto(x, y);

        // Volcamos el resultado a una variable y la usamos para procesar
        // el resultado en una cadena que mostrar al usuario
        int cuadrante = punto.valorCuadranteSimple();
        String resultado = "";

        switch (cuadrante) {
            case 0:
                resultado = "En el centro";
                break;
            case 1:
                resultado = "Primer Cuadrante";
                break;
            case 2:
                resultado = "Segundo Cuadrante";
                break;
            case 3:
                resultado = "Tercer Cuadrante";
                break;
            case 4:
                resultado = "Cuarto Cuadrante";
                break;
        }

        // Mostramos el resultado
        System.out.println("Punto (" + x + "," + y + ") Cuadrante: " + resultado);
    }
}
