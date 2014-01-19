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

import java.awt.Point;
import java.util.Random;

/**
 * Distribuciones bidimendional
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio008 {

    public class DistribucionBidimensional {

        // Variable para almacena el tamaño de la distribución
        private final int longitud;

        // Matriz para almacenar los valores de la distribución
        private final double[][] distribucion;

        /**
         * Función para calcular la media de la primera fila de la distribución
         *
         * @return La media de valores de la primera fila de la distribución
         */
        private double mediaX() {
            // Inicializamos el acumulador
            double valorX = 0;

            // Iteramos para calcular la suma de todos los valores 
            // para la fila 0
            for (double[] distribucion1 : this.distribucion) {
                valorX += distribucion1[0];
            }

            // Devolvemos la suma de todos los valores divididos
            // entre la longitud de la distribución
            return valorX / this.distribucion.length;
        }

        /**
         * Función para calcular la media de la primera fila de la distribución
         *
         * @return La media de valores de la primera fila de la distribución
         */
        private double mediaY() {
            // Inicializamos el acumulador
            double valorY = 0;

            // Iteramos para calcular la suma de todos los valores 
            // para la fila 1
            for (double[] distribucion1 : this.distribucion) {
                valorY += distribucion1[1];
            }

            // Devolvemos la suma de todos los valores divididos
            // entre la longitud de la distribución
            return valorY / this.distribucion.length;
        }

        /**
         * Función para calcular la varianza de X
         * @return Varianza de X
         */
        private double varianzaX() {
            // Inicializamos la variable acumuladora
            double resultado = 0;

            // Iteramos por la primera fila de la distribución
            // sumando el cuadrado de los valores al acumulador
            for (double[] distribucion1 : distribucion) {
                resultado += Math.pow(distribucion1[0], 2);
            }

            // Dividimos el resultado por el tamaño de la distribución
            resultado /= distribucion.length;

            // Y le restamos el cuadrado de la media de esa misma fila
            resultado -= Math.pow(mediaX(), 2);

            // Devolvemos el resultado
            return resultado;
        }

        /**
         * Función para calcular la varianza de Y
         * @return Varianza de Y
         */
        private double varianzaY() {
            // Inicializamos la variable acumuladora
            double resultado = 0;

            // Iteramos por la segunda fila de la distribución
            // sumando el cuadrado de los valores al acumulador
            for (double[] distribucion1 : distribucion) {
                resultado += Math.pow(distribucion1[1], 2);
            }

            // Dividimos el resultado por el tamaño de la distribución
            resultado /= distribucion.length;

            // Y le restamos el cuadrado de la media de esa misma fila
            resultado -= Math.pow(mediaY(), 2);

            // Devolvemos el resultado
            return resultado;
        }
        
        /**
         * Constructor para la clase
         *
         * @param longitud Tamaño de la distribución bidimensional
         */
        public DistribucionBidimensional(int longitud) {

            // Objeto para generar números aleatorios
            Random random = new Random();

            // Almacenamos la longitud
            this.longitud = longitud;

            // Creamos una matriz de tamaño longitud x 2 para 
            // almacenar los datos
            distribucion = new double[this.longitud][2];

            // Iteramos por toda la matriz y generamos numeros aleatorios para
            // rellenarla
            for (double[] distribucion1 : distribucion) {
                for (int j = 0; j < 2; j++) {
                    distribucion1[j] = random.nextInt(100);
                }
            }
        }

        /**
         * Función que calcula y devuelve el centro de gravedad de la
         * distribución bidimensional
         *
         * @return Un objeto Point con los valores del centro de gravedad
         */
        public String centroDeGravedad() {
            // Objeto para devolver el resultado
            String resultado;

            // El centro de gravedad es la media de la primera fila de la
            // distribución para el valor x y lo mismo de la segunda fila para
            // el valor Y
            resultado = "(" + mediaX() + ", " + mediaY() + ")";

            // Devolvemos el resultado. 
            return resultado;
        }

        /**
         * Función para calcular la desviación típica de X en la distribución
         *
         * @return Desviación típica de X en la distribución
         */
        public double valorDesviacionTipicaX() {
            // Devolvemos el resultadoa
            // La desviación típica es la raiz cuadrada de la varianza
            return Math.sqrt(varianzaX());
        }

        /**
         * Función para calcular la desviación típica de Y en la distribución
         *
         * @return Desviación típica de Y en la distribución
         */
        public double valorDesviacionTipicaY() {
            // Devolvemos el resultadoa
            // La desviación típica es la raiz cuadrada de la varianza

            return Math.sqrt(varianzaY());
        }

        /**
         * Función para mostrar la matriz por pantalla
         *
         * @return
         */
        public String imprimirMatriz() {
            // Inicializamos la variable de retorno
            String resultado = "";

            // Iteramos 3 veces, la primera para disponer valores de posición
            // La segunda para disponer los valores de X
            // La tercera para los valores de Y
            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        resultado += "i";
                        break;
                    case 1:
                        resultado += "x";
                        break;
                    case 2:
                        resultado += "y";
                        break;
                }
                for (int j = 0; j < distribucion.length; j++) {
                    switch (i) {
                        case 0:
                            resultado += "\t" + j;
                            break;
                        case 1:
                            resultado += "\t" + distribucion[j][0];
                            break;
                        case 2:
                            resultado += "\t" + distribucion[j][1];
                            break;
                    }
                }
                resultado += "\n";
            }

            // Devolvemos la cadena con la matriz formateada
            return resultado;
        }

        /**
         * Función para devolver un único valor de la distribución
         *
         * @param posX Valor X
         * @param posY Valor Y
         * @return El valor de la posición X, Y
         */
        public double valorDistribución(int posX, int posY) {
            return distribucion[posX][posY];
        }

        /**
         * Función que nos permite calcular la covarianza de la distribución
         * @return La covarianza de la distribución
         */
        public double valorCovarianza()
        {
            // Declaramos e inicializamos la variable acumulador
            double resultado = 0;

            // Iteramos por la distribución multiplicando los elementos
            for (double[] distribucion1 : this.distribucion) {
                resultado += distribucion1[0] * distribucion1[1];
            }
            
            // Dividimos por el tamaño de la distribución
            resultado /= distribucion.length;
            
            // Le restamos la multiplicación de las medias de X y de Y, 
            // dando como resultado la covarianza
            resultado -= (mediaX() * mediaY());
            
            // Devolvemos el resultado
            return resultado;
        }
        
        /**
         * Función que devuelve el valor del coeficiente de correlación de la 
         * distribución
         * @return Valor del coeficiente de correlación
         */
        public double valorCoeficienteCorrelacion()
        {
            // Devolvemos el cociente entre la covarianza y el producto de la
            // desviación típica de X e Y
            return valorCovarianza() / 
                    (valorDesviacionTipicaX() * valorDesviacionTipicaY());
        }
        
        /**
         * Función para interpretar el coeficiente de correlación de 
         * la distribución
         * @return Cadena de texto con la interpretación de la correlación
         */
        public String interpretarCoeficienteCorrelacion()
        {
            // Definimos una variable para devolver el resultado
            String resultado;

            // Redondeamos el valor del coeficiente de correlación
            // y lo pasamos a entero
            switch((int) Math.round(valorCoeficienteCorrelacion()))
            {
                
                case 0: // Si es cero, la correlación es debil
                    resultado = "La correlación es debil";
                    break;
                case 1: // Si es uno, la correlación es fuerte y directa
                    resultado = "La correlación es fuerte y directa";
                    break;
                case -1: // Si es menos uno la correlación es fuerte e inversa
                    resultado = "La correlación es fuerte e inversa";
                    break;
                default: // Si sale cualquier otra cosa es un error
                   resultado = "Error al interpretar el Coeficiente de "
                           + "Correlación";
            }
            
            // Devolvemos el resultado
            return resultado;
        }        
    }

    public void Ejercicio() {
        DistribucionBidimensional distro = new DistribucionBidimensional(10);

        System.out.print(distro.imprimirMatriz());

        System.out.print("El centro de gravedad de la distribución es: "
                + distro.centroDeGravedad());

        System.out.print("\nLa desviación típica de X es: "
                + distro.valorDesviacionTipicaX());

        System.out.print("\nLa desviación típica de Y es: "
                + distro.valorDesviacionTipicaY());

        System.out.print("\nLa covarianza de la distribución es: "
                + distro.valorCovarianza());

        System.out.print("\nEl valor del coeficiente de correlación es: "
                + distro.valorCoeficienteCorrelacion());

        System.out.print("\n" + distro.interpretarCoeficienteCorrelacion());
        
        
    }
}
