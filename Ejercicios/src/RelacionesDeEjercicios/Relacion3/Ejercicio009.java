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

import Utiles.Mensajes;
import Utiles.PeticionDatos;
import Utiles.Varios;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * Las notas de Informática de todos los alumnos de Bachillerato de un centro
 * están recogidas en la hoja de cálculo. Calcula las medidas de centralización
 * y de dispersión. 
 *  a. Indicaciones: 
 *      I. Crearos una clase llamada DistribuciónEstadistica con los siguientes 
 *      elementos: 
 *          1. Crearos un campo de clase que almacene las notas del centro. 
 *          Podéis generar de forma aleatoria los datos. 
 *          2. Métodos de la clase  implementan cada una de las medidas de
 *          centralización y dispersión. 
 *      II. Crearos unas clase de prueba
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
         * Constructor de la clase
         *
         * @param valores Datos que forman parte de la distribución estadística
         */
        public DistribucionEstadistica(int[] valores) {
            this.arrayDatos = valores;
        }

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
         * Método que permite calcular la media de la distribución estadística
         *
         * @return Devuelve la suma de los valores de la distribución
         * estadística dividida entre la cantidad de valores
         */
        public double media() {
            double resultado = 0f;

            Objects.requireNonNull(arrayDatos);

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
        public Object[] moda() {

            Objects.requireNonNull(arrayDatos);

            // Definimos una lista de HasMap donde almacenaremos
            // dos valores, el valor del número leido, y la cantidad de veces
            // que aparece
            Map<Integer, Integer> lista = new HashMap<>();

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
            int valorMaximoRepeticiones = Integer.MIN_VALUE;

            // Recorremos el listado de valores
            for (Map.Entry<Integer, Integer> entry : lista.entrySet()) {

                // Recogemos el valor de la clave y su valor
                Integer clave = entry.getKey();
                Integer valor = entry.getValue();

                // Comprobamos el valor con el valor de control
                if (valor > valorMaximoRepeticiones) {
                    // Si valor es mayor, será el nuevo valor de control
                    // aislando de este modo el valor máximo de repeticiones de 
                    // un valor
                    valorMaximoRepeticiones = valor;
                }
            }

            // Creamos una lista para almacenar los valores numéricos del
            // listado inicial cuyo valor de repeticiones sea igual
            // al que hemos verificado como maximo en la iteración anterior
            ArrayList resultados = new ArrayList();

            // Iteramos de nuevo
            for (Map.Entry<Integer, Integer> entry : lista.entrySet()) {
                Integer clave = entry.getKey();
                Integer valor = entry.getValue();

                // Añadimos a la nueva lista la clave de los registros cuyo 
                // valor de repeticiones ea igual al valor maximo de repeticiones
                if (valor == valorMaximoRepeticiones) {
                    resultados.add(clave);
                }
            }

            // Creamos un array para devolver la salida
            Object[] salida = resultados.toArray();

            // Lo ordenamos para que quede bonito
            Arrays.sort(salida);

            // Devolvemos el resultado
            return salida;

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

            Objects.requireNonNull(arrayDatos);

            // Creamos un nuevo array temporal con el contenido de la 
            // distribución estadistica
            int[] temp = this.arrayDatos.clone();

            // Ordenamos el array
            Arrays.sort(temp);

            // Comprobamos su tamaño
            if (temp.length % 2 == 0) {

                // Si el tamaño es par, la mediana será el elemento del array 
                // ordenado cuya posición sea el tamaño del array dividido 
                // entre 2 más 1  + el elemento del array  ordenado cuya posición sea 
                // el tamaño del array dividido  entre 2 , dividido a su vez enttre 2
                resultado = ((temp[((temp.length + 1) / 2) - 1]
                        + temp[((temp.length) / 2)]) / 2.0f);
            } else {

                // Si el tamaño es impar, la mediana será el elemento del array 
                // ordenado cuya posición sea el tamaño del array más 1 dividido 
                // entre 2
                resultado = temp[((temp.length + 1) / 2) - 1];
            }

            return resultado;
        }

        /**
         * Método para generar el rango de la distribución estadística
         *
         * @return El rango de la distribución estadística. La diferencia ente
         * el valor máximo y el valor mínimo de la distribución estadística
         */
        public int rango() {

            Objects.requireNonNull(arrayDatos);

            // Definimos dos variables para almcenar el valor máximo y mínimo 
            // de la distribución estadística
            int valorMaximo = Integer.MIN_VALUE;
            int valorMinimo = Integer.MAX_VALUE;

            // Itermaos por el array de datos
            for (int i = 0; i < this.arrayDatos.length; i++) {

                // Si valorMaximo es menor que el valor actual
                if (valorMaximo < arrayDatos[i]) {
                    //El valor actual se convierte en el nuevo valorMaximo
                    valorMaximo = arrayDatos[i];
                }

                // Si valorMinimo es mayo que el valor actual
                if (valorMinimo > arrayDatos[i]) {
                    //El valor actual se convierte en el nuevo valorMinimo
                    valorMinimo = arrayDatos[i];
                }
            }

            // Devolvemos la diferencia de los dos valores como resultado
            return valorMaximo - valorMinimo;

        }

        /**
         * Método para calcular la varianza de la distribución estadística
         *
         * @return La varianza de la distribución estadística
         */
        public double varianza() {
            double resultado = 0f;

            Objects.requireNonNull(arrayDatos);

            // Iteramos el array de datos sumando los valores que conteine al 
            // cuadrado
            for (int i = 0; i < this.arrayDatos.length; i++) {
                resultado += Math.pow(arrayDatos[i], 2);
            }

            // Dividimos el resultado por la longitud del array
            resultado /= arrayDatos.length * 1f;

            // Le restamos la media de la distribución estadistica al cuaarado
            resultado -= Math.pow(media(), 2);

            // Devolvemos el resultado
            return resultado;
        }

        /**
         * Método para calcular la desviación típica de la distribución
         * estadística
         *
         * @return Devuelve la desviación típica de la distribución estadística
         */
        public double desviacionTipica() {
            Objects.requireNonNull(arrayDatos);

            // Devolvemos la raiz cuadrada de la varianza
            return Math.sqrt(varianza());
        }

        /**
         * Método para mostrar una representación de la distribución estadística
         * como una cadena
         *
         * @return Una cadena con una representación de la la distribución
         * estadística
         */
        @Override
        public String toString() {
            String salida = "";

            salida += "Distribución estadística\n";
            salida += "========================\n\n";

            // Iteramos el array de datos para concatenar los valores
            for (int i = 1; i <= arrayDatos.length; i++) {
                //salida += String.format("%5s", arrayDatos[i - 1]);
                salida += arrayDatos[i - 1] + Varios.generarCadena(" ", 3, String.valueOf(arrayDatos[i - 1]));

                // Si la iteración es múltiplo de 10, introducimos un 
                // salto de línea
                if (i % 10 == 0) {
                    salida += "\n";
                }
            }

            // Devolvemos el resultado
            return salida;
        }

    }

    public void Ejercicio() {

        // Cantidad de datos a generar aleatoriamente
        int numDatos;

        // Respuesta del usuario
        String respuesta;
        int valor;

        // Creamos el objeto
        DistribucionEstadistica distro;

        // Preguntamos al usuairo si quiere introducir los datos manualmente
        // o generarlos de forma pseudoaleatoria
        respuesta = PeticionDatos.pedirConsentimiento(
                "¿Desea generar datos aleatorios? [s/n]",
                new String[]{"s", "n"});

        // Si la respuesta es afirmativa
        if (respuesta.equalsIgnoreCase("s")) {

            valor = PeticionDatos.pedirEnteroPositivoNoCero("¿Cuantos valores desea generar?");

            // Creamos el nuevo objeto pasando null como parametro
            distro = new DistribucionEstadistica(null);

            // Generamos tantos nuevos datos aleatorios como haya especificado 
            // el usuario
            distro.generarDatosAleatorios(valor);
        } else {

            // Preguntamos cuantos valores deseamos generar
            valor = PeticionDatos.pedirEnteroPositivoNoCero("¿Cuantos valores desea generar?");
            // Creamos un nuevo array del tamaño que nos haya especificado el 
            // usuario
            int[] valores = new int[valor];

            // Iteramos pidiendo al usuario que introduzca nuevos valores
            for (int i = 0; i < valores.length; i++) {

                valor = PeticionDatos.pedirEnteroPositivo("Introduzca el valor número " + (i + 1));
                                
                valores[i] = valor;
            }

            // Una vez creado el array de valores para la distribución 
            // estadística lo usamos como parámetro para generar el objeto
            // correspondiente
            distro = new DistribucionEstadistica(valores);
        }

        String resultado = "";
        
        
        // Mostramos la distribución estadística con la que trabajaremos
        resultado += distro.toString();

        // Mostramos resultados
        resultado += "\nResultados";
        resultado += "\n==========";

        resultado += "\nMedia: " + distro.media();

        resultado += "\nModa: ";

        Object[] modas = distro.moda();

        for (Object moda : modas) {
            resultado += moda + " ";
        }

        resultado += "\n";

        resultado += "\nMediana: " + distro.mediana();

        resultado += "\nRango: " + distro.rango();

        resultado += "\nVarianza: " + distro.varianza();

        resultado += "\nDesviación Típica: " + distro.desviacionTipica();

        
        Mensajes.MostrarMensaje(resultado, "Resultado", 
                Mensajes.TipoMensaje.INFORMACION, true, new Dimension(40, 40));
    }
}
