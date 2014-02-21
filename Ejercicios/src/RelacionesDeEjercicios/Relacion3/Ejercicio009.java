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
package RelacionesDeEjercicios.Relacion3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Las notas de Informática de todos los alumnos de Bachillerato de un centro
 * están recogidas en la hoja de cálculo. Calcula las medidas de centralización
 * y de dispersión. a. Indicaciones: I. Crearos una clase llamada
 * DistribuciónEstadistica con los siguientes elementos: 1. Crearos un campo de
 * clase que almacene las notas del centro. Podéis generar de forma aleatoria
 * los datos. 2. Métodos de la clase  implementan cada una de las medidas de
 * centralización y dispersión. II. Crearos unas clase de prueba
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio009 {

    public class DistribucionEstadistica {

        // Variable para almacenar el tamaño del vector donde se almacenarán
        // los datos de la distribución estadística
        private int tamanyo;

        // Array para almacenar los datos de la distribución estadística
        int[] arrayDatos;

        /**
         * Método para generar datos aleatorios para la distribución estadística
         *
         * @param cantidadDatos Cantidad de datos a generar
         */
        public void generarDatosAleatorios(int cantidadDatos) {
            Random rnd = new Random();

            this.arrayDatos = new int[cantidadDatos];

            for (int i = 0; i < this.arrayDatos.length; i++) {

                arrayDatos[i] = rnd.nextInt(11);
            }
        }

        /**
         * Constructor de la clase
         *
         * @param arrayDatos Datos que forman parte de la distribución
         * estadística
         */
        public void DistribucionEstadistica(int[] arrayDatos) {
            this.arrayDatos = arrayDatos;
        }

        /**
         * Método que permite calcular la media de la distribución estadística
         *
         * @return Devuelve la suma de los valores de la distribución
         * estadística dividida entre la cantidad de valores
         */
        public double media() {
            double resultado = 0f;

            // Verificamos que el array que mantiene los datos de la distribución
            // estadística contiene datos
            if (this.arrayDatos != null) {

                // Iteramos la longitud del array
                for (int i = 0; i < this.arrayDatos.length; i++) {

                    // Sumamos todos los valores del array
                    resultado += arrayDatos[i];
                }

                // Dividimos la suma de todos los valores del array por su 
                // longitud para conseguir la media
                resultado /= arrayDatos.length;
            }

            // Devolvemos el resultado
            return resultado;
        }

        /**
         * Método que permite calcular la moda de la distribución estadística
         *
         * @return Devuelve el valor que más aparece en la distribución
         * estadística
         */
        public int moda() {

            // Definimos una lista de HasMap donde almacenaremos
            // dos valores, el valor del número leido, y la cantidad de veces
            // que aparece
            Map<Integer, Integer> lista = new HashMap<>();

            // Inicializamos la variable resultado
            int resultado = 0;

            // Iteramos la longitud del array
            for (int i = 0; i < this.arrayDatos.length; i++) {

                // Comprobamos si la lista contiene una entrada con el valor 
                // del número que leemos en esta iteración
                if (lista.containsKey(arrayDatos[i])) {
                    // Si ya hay un registro para el valor actual del vector, 
                    // le sumamos uno
                    lista.put(arrayDatos[i], lista.get(arrayDatos[i]).intValue() + 1);
                } else {
                    // Si no existe, creamos un registro nuevo en la lista 
                    // con valor 1
                    lista.put(arrayDatos[i], 1);
                }
            }

            // Declaramos una variable de control y la inicializamos
            int control = Integer.MIN_VALUE;

            // Recorremos el listado de valores
            for (Map.Entry<Integer, Integer> entry : lista.entrySet()) {

                // Recogemos el valor de la clave y su valor
                Integer clave = entry.getKey();
                Integer valor = entry.getValue();

                // Comprobamos el valor con el valor de control
                if (valor > control) {
                    // Si valor es mayor, será el nuevo valor de conrol
                    // y el resultado será el valor de la clave
                    control = valor;
                    resultado = clave;
                }
            }

            // Devolvemos el resultado de la moda
            return resultado;
        }

        /**
         * Método que nos devuelve el valor de la variable de posición central
         * de los datos de la distribución estadística ordenados
         *
         * @return Devuelve el valor que tiene el elemento central de la
         * distribución dimensional si estuviese ordenado
         */
        public double mediana() {
            double resultado;

            int[] temp = this.arrayDatos.clone();

            Arrays.sort(temp);

            if (temp.length % 2 == 0) {
                resultado = ((temp[((temp.length +1)/2)-1] + temp[(temp.length / 2)]-1))/2f;
            } else {
                resultado = temp[((temp.length + 1) / 2)-1];
            }

            return resultado;
        }

    }

    public void Ejercicio() {

        DistribucionEstadistica distro = new DistribucionEstadistica();

        distro.generarDatosAleatorios(10);

        System.out.println("Media: " + distro.media());

        System.out.println("Moda: " + distro.moda());
        
        System.out.println("Mediana: " + distro.mediana());

    }
}
