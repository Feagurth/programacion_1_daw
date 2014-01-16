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

/**
 * Crear la clase Triangulo cuya interfaz nos permita a) Saber el área b)
 * Conocer el lado mayor c) Saber si es equilátero
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio002 {

    public class Triangulo {

        // Variables de instancia
        int lado1;
        int lado2;
        int lado3;
        boolean valido;

        /**
         * Función para devolver el valor del lado1
         *
         * @return El valor del lado1
         */
        public int getLado1() {
            return lado1;
        }

        /**
         * Función para devolver el valor del lado2
         *
         * @return El valor del lado2
         */
        public int getLado2() {
            return lado2;
        }

        /**
         * Función para devolver el valor del lado3
         *
         * @return El valor del lado3
         */
        public int getLado3() {
            return lado3;
        }

        /**
         * Función para comprobar si un triangulo está bien definido
         *
         * @return
         */
        public boolean isValido() {
            return valido;
        }

        /**
         * Constructor de la clase
         *
         * @param lado1 Lado 1 del triangulo
         * @param lado2 Lado 2 del triangulo
         * @param lado3 Lado 3 del triangulo
         */
        public Triangulo(int lado1, int lado2, int lado3) {
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
            this.valido = false;

            // Verificamos si el triangulo es construible y cambiamos 
            // el valor de validación si es así
            if (lado1 + lado2 > lado3
                    && lado2 + lado3 > lado1
                    && lado3 + lado1 > lado2) {
                this.valido = true;
            }
        }

        /**
         * Función para averiguar que lado del triangulo es el mayor
         *
         * @return
         */
        public int ladoMayor() {
            // Inicializamos la varable
            int resultado = -0;

            // Comprobamos si el primer lado es mayor que el resultado
            if (lado1 > resultado) {
                // Si es mayor, ponemos a resultado su valor
                resultado = lado1;
            }

            // Repetimos la acción con el segundo lado
            if (lado2 > resultado) {
                resultado = lado2;
            }

            // Y con el tercero
            if (lado3 > resultado) {
                resultado = lado3;
            }

            // Devolvemos el resultado
            return resultado;
        }

        /**
         * Función que comprueba si el triangulo es equilatero
         *
         * @return
         */
        public boolean esEquilatero() {
            // Si los tres lados miden lo mismo es equilatero
            return lado1 == lado2 && lado2 == lado3;
        }

        /**
         * Función para calcular el area del triangulo usando la formula 
         * de Heron
         * @return El valor del area del triangulo
         */
        public double valorArea() {
            double resultado;

            // Calculamos el area usando la formula de Heron
            resultado = (lado1 + lado2 + lado3) / (float)2;

            resultado = resultado * (resultado - lado1) * (resultado - lado2) * (resultado - lado3);
            
            resultado = Math.sqrt(resultado);
            
            return resultado;
        }
    }

    public void Ejercicio() {

        Triangulo triangulo = new Triangulo(1, 1, 1);

        System.out.print(triangulo.isValido());
        
        System.out.print(triangulo.valorArea());

    }

}
