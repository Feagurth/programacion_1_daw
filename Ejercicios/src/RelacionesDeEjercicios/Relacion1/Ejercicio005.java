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
 * Crear la clase TablaMultiplicar cuya interfaz nos permita: a) Calcular la
 * tabla de multiplicar b) Mostrarla de forma estructurada por pantalla
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio005 {

    public class TablaDeMultiplicar {

        // Variable de instancia
        int numero;

        /**
         * Función que devuelve el numero de la tabla
         *
         * @return El numero de la tabla
         */
        public int getNumero() {
            return numero;
        }

        /**
         * Constructor de la clase
         *
         * @param numero Valor de la tabla de multiplicar
         */
        public TablaDeMultiplicar(int numero) {
            this.numero = numero;
        }

        /**
         * Función que devuelve el valor de un número en la tabla
         *
         * @param valor Valor del número
         * @return Resultado del multiplicar el número por el valor de la tabla
         */
        public int valorDeNumero(int valor) {
            return this.numero * valor;

        }

        public String generarTabla(int numMaximo) {
            // Creamos un acumulador y lo inicializamos
            String resultado = "";

            // Iteramos creando el resultado
            for (int i = 0; i <= numMaximo; i++) {
                resultado += i + " x " + this.numero
                        + " = " + (i * this.numero) + "\n";
            }

            // Devolvemos el resultado
            return resultado;
        }
    }

    public void Ejercicio() {

        // Objeto para recibir datos por teclado
        Scanner entrada = new Scanner(System.in);
        
        // Petición de datos al usuario
        System.out.print("Introduzca el número cuya tabla quiera mostrar: ");
        int numero = entrada.nextInt();
        
        System.out.print("Introduzca la cantidad de operaciones a mostrar: ");
        int iteraciones = entrada.nextInt();
        
        // Creamos el objeto
        TablaDeMultiplicar tabla = new TablaDeMultiplicar(numero);

        // Mostramos los resultados
        System.out.println(tabla.generarTabla(iteraciones));
    }
}
