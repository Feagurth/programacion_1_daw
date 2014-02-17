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

import java.util.Scanner;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio098 {

    /**
     * Clase para almacenar los valores de ventas anuales de un producto mes a
     * mes
     */
    public class VentaAnualProducto {

        String nombreProducto;
        float[] ventasMensuales = new float[12];
        float totalVentasProducto;

        /**
         * Constructor de la clase
         *
         * @param nombreProducto Nombre del producto
         * @param ventasMensuales Ventas del producto mes a mes
         */
        public VentaAnualProducto(String nombreProducto, float[] ventasMensuales) {

            // Asignamos los valores
            this.nombreProducto = nombreProducto;
            this.ventasMensuales = ventasMensuales;

            // Iteramos las ventas mensuales para conseguir el total del año
            for (float ventaMes : ventasMensuales) {
                this.totalVentasProducto += ventaMes;
            }
        }

        /**
         * Función que nos permite recuperar el valor de ventas de un mes
         * específico del producto
         *
         * @param value valor numérico del mes del cual recuperar las ventas
         * (0-11)
         * @return El valor de las ventas del producto en el mes especificado
         */
        public float getVentasMensual(int value) {
            return ventasMensuales[value];
        }
    }

    public void Ejercicio() {
        // Objeto para pedir datos al usuario por teclado
        Scanner entrada = new Scanner(System.in);

        // Variables
        int numProductos;
        String nombreProducto;
        float[] ventaMeses;
        final String[] meses = new String[]{"Enero", "Febrero", "Marzo", "Abril",
            "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
            "Noviembre", "Diciembre"};

        do {
            System.out.print("Introduzca el número de productos a procesar: ");
            numProductos = entrada.nextInt();
        } while (numProductos <= 0);

        // Creamos un array de objetos VentaAnualProducto
        VentaAnualProducto[] ventasAnuales = new VentaAnualProducto[numProductos];

        // Creamos e inicializamos un contador
        int contador = -1;

        for (VentaAnualProducto ventaAnual : ventasAnuales) {

            // Creamos de nuevo el objeto Scanner
            entrada = new Scanner(System.in);

            // Pedimos al usuario el nombre del producto
            System.out.print("Introduzca el nombre del producto: ");
            nombreProducto = entrada.nextLine();

            // Inicializamos el array de ventas
            ventaMeses = new float[12];

            // Creamos e inicializamos un contador para los meses
            int contadorMeses = -1;

            // Iteramos por todos los valores del array
            for (String mes : meses) {

                // Aumentamos el contador
                contadorMeses++;

                // Preguntamos las ventas del producto al usuario para el mes
                System.out.print("Introduzca la ventas del producto para "
                        + mes + ": ");
                ventaMeses[contadorMeses] = entrada.nextFloat();
            }

            // Creamos el objeto correspondiente a las ventas anuales del 
            // producto
            ventaAnual = new VentaAnualProducto(nombreProducto, ventaMeses);

            // Aumentamos el contador
            contador++;

            // Guardamos el objeto en el array de ventas anuales del producto
            ventasAnuales[contador] = ventaAnual;
        }
        
        // Definimos un String para pintar la linea de resultados
        String linea = "";
        
        for (String mes : meses) {
            linea += 
            
        }
        
        
    }
}
