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

import Utiles.Mensajes;
import Utiles.PeticionDatos;
import java.util.Random;

/**
 * Distribuciones bidimendionales
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio008 {

    /**
     * Clase para trabajar con distribuciones bidimensionales
     */
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
            for (int i = 0; i < distribucion[0].length; i++) {
                valorX += distribucion[0][i];
            }

            // Devolvemos la suma de todos los valores divididos
            // entre la longitud de la distribución
            return valorX / this.distribucion[0].length;
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
            for (int i = 0; i < distribucion[1].length; i++) {
                valorY += distribucion[1][i];
            }

            // Devolvemos la suma de todos los valores divididos
            // entre la longitud de la distribución
            return valorY / this.distribucion[1].length;
        }

        /**
         * Función para calcular la varianza de X
         *
         * @return Varianza de X
         */
        private double varianzaX() {
            // Inicializamos la variable acumuladora
            double resultado = 0;

            // Iteramos por la primera fila de la distribución
            // sumando el cuadrado de los valores al acumulador
            for (int i = 0; i < distribucion[0].length; i++) {
                resultado += Math.pow(distribucion[0][i], 2);
            }

            // Dividimos el resultado por el tamaño de la distribución
            resultado /= distribucion[0].length;

            // Y le restamos el cuadrado de la media de esa misma fila
            resultado -= Math.pow(mediaX(), 2);

            // Devolvemos el resultado
            return resultado;
        }

        /**
         * Función para calcular la varianza de Y
         *
         * @return Varianza de Y
         */
        private double varianzaY() {
            // Inicializamos la variable acumuladora
            double resultado = 0;

            // Iteramos por la segunda fila de la distribución
            // sumando el cuadrado de los valores al acumulador
            for (int i = 0; i < distribucion[1].length; i++) {
                resultado += Math.pow(distribucion[1][i], 2);
            }

            // Dividimos el resultado por el tamaño de la distribución
            resultado /= distribucion[1].length;

            // Y le restamos el cuadrado de la media de esa misma fila
            resultado -= Math.pow(mediaY(), 2);

            // Devolvemos el resultado
            return resultado;
        }

        /**
         * Constructor para la clase
         *
         * @param longitud Tamaño de la distribución bidimensional
         * @param aleatorio Si genera una matriz bidimensional aleatoria o usa
         * la establecida en el ejercicio
         */
        public DistribucionBidimensional(int longitud, Boolean aleatorio) {

            // Objeto para generar números aleatorios
            Random random = new Random();

            // Almacenamos la longitud
            this.longitud = longitud;

            // Creamos una matriz de tamaño longitud x 2 para 
            // almacenar los datos
            if (aleatorio) {
                distribucion = new double[2][this.longitud];

                // Iteramos por toda la matriz y generamos numeros aleatorios para
                // rellenarla
                for (double[] distribucion1 : distribucion) {
                    for (int j = 0; j < 8; j++) {
                        distribucion1[j] = random.nextInt(200) + 1;
                    }
                }
            } else {
                distribucion = new double[][]{{156, 165, 170, 175, 165, 172, 178, 160}, {56, 65, 70, 75, 65, 72, 78, 60}};
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
                    default:
                        resultado += "";
                        break;
                }
                for (int j = 0; j < distribucion[0].length; j++) {
                    switch (i) {
                        case 0:
                            resultado += "\t" + j;
                            break;
                        case 1:
                            resultado += "\t" + distribucion[0][j];
                            break;
                        case 2:
                            resultado += "\t" + distribucion[1][j];
                            break;
                        default:
                            resultado += "";
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
         *
         * @return La covarianza de la distribución
         */
        public double valorCovarianza() {
            // Declaramos e inicializamos la variable acumulador
            double resultado = 0;

            // Iteramos por la distribución multiplicando los elementos
            for (int i = 0; i < distribucion[0].length; i++) {
                resultado += distribucion[0][i] * distribucion[1][i];
            }

            // Dividimos por el tamaño de la distribución
            resultado /= distribucion[0].length;

            // Le restamos la multiplicación de las medias de X y de Y, 
            // dando como resultado la covarianza
            resultado -= (mediaX() * mediaY());

            // Devolvemos el resultado
            return resultado;
        }

        /**
         * Función que devuelve el valor del coeficiente de correlación de la
         * distribución
         *
         * @return Valor del coeficiente de correlación
         */
        public double valorCoeficienteCorrelacion() {
            // Devolvemos el cociente entre la covarianza y el producto de la
            // desviación típica de X e Y
            return valorCovarianza()
                    / (valorDesviacionTipicaX() * valorDesviacionTipicaY());
        }

        /**
         * Función para interpretar el coeficiente de correlación de la
         * distribución
         *
         * @return Cadena de texto con la interpretación de la correlación
         */
        public String interpretarCoeficienteCorrelacion() {
            // Definimos una variable para devolver el resultado
            String resultado;

            // Redondeamos el valor del coeficiente de correlación
            // y lo pasamos a entero
            switch ((int) Math.round(valorCoeficienteCorrelacion())) {

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

        /**
         * Función para estimar el peso a partir de una altura
         *
         * @param altura Altura para la que se quiere estimar el peso
         * @return Peso estimado para la altura introducida
         */
        private Double estimarPeso(Double altura) {
            // Calculado según la siguiente formula
            // MediaY + valorCoeficienteCorrelacion(altura - MediaX)
            return (mediaY()
                    + valorCoeficienteCorrelacion() * (altura - mediaX()));
        }
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // Variables
        double valorAltura;
        String resultado = "";
        String generacionAleatoria;

        generacionAleatoria = PeticionDatos.pedirConsentimiento("¿Desea generar "
                + "datos aleatorios? [s/n]", new String[]{"s", "n"});

        // Creamos el objeto con el que trabajemos
        DistribucionBidimensional distro = new DistribucionBidimensional(8,
                (generacionAleatoria.matches("s")));

        // Imprimimos la matriz
        resultado += distro.imprimirMatriz();

        // Concatenamos los datos del centro de gravedad
        resultado += "\nEl centro de gravedad de la distribución es: "
                + distro.centroDeGravedad();

        // Concatenamos los datos de la desviación típica de X
        resultado += "\nLa desviación típica de X es: "
                + distro.valorDesviacionTipicaX();

        // Concatenamos los datos de la desviación típica de Y
        resultado += "\nLa desviación típica de Y es: "
                + distro.valorDesviacionTipicaY();

        // Concatenamos los datos la covarianza de la distribución
        resultado += "\nLa covarianza de la distribución es: "
                + distro.valorCovarianza();

        // Concatenamos los datos del coeficiente de correlación
        resultado += "\nEl valor del coeficiente de correlación es: "
                + distro.valorCoeficienteCorrelacion();

        // Concatenamos la interpretacón del coeficiente de correlación
        resultado += "\n" + distro.interpretarCoeficienteCorrelacion();

        // Mostramos los resultados
        Mensajes.mostrarMensaje(resultado, "Resultado", Mensajes.TipoMensaje.INFORMACION, true);

        // Petición de datos al usuario
        valorAltura = PeticionDatos.pedirRealPositivoNoCero("Introduzca "
                + "una altura en centímetros para estimar el peso");

        // Calculamos el peso estimado basdo en la inforamción introducida por el usuario
        Mensajes.mostrarMensaje("El peso estimado es: "
                + distro.estimarPeso(valorAltura),
                Mensajes.TipoMensaje.INFORMACION);
    }
}
