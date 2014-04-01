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

import Utiles.PeticionDatos;
import Utiles.Varios;

/**
 * Una empresa de venta de productos por correo desea realizar una estadística
 * de las ventas realizadas de cada uno de los productos a lo largo del año.
 * Distribuye un total de 100 productos, por lo que las ventas se pueden
 * almacenar en una tabla de 100 filas y 12 columnas. Se desea conocer: - El
 * total de ventas de cada uno de los productos - El total de ventas de cada mes
 * - El producto más vendido en cada mes - El nombre, mes y la cantidad del
 * producto más vendido
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio003 {

    /**
     * Clase para almacenar los valores de ventas anuales de un producto mes a
     * mes
     */
    static public class VentaAnualProducto {

        private final String nombreProducto;
        private float[] ventasMensuales = new float[12];
        private float totalVentasProducto;

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
         * Función que devuelve el nombre del producto
         *
         * @return El nombre del producto
         */
        public String getNombreProducto() {
            return nombreProducto;
        }

        /**
         * Función para devolver el valor total de ventas del producto en un año
         *
         * @return Valor total del producto en un año
         */
        public float getTotalVentasProducto() {
            return totalVentasProducto;
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

    /**
     * Clase diseñada para albergar todas las ventas de productos de un año y
     * mostrar los resultados de forma maquetada
     */
    public class SistemaDeVentas {

        private final String[] ARRAY_MESES = new String[]{"Enero", "Febrero", "Marzo", "Abril",
            "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
            "Noviembre", "Diciembre"};

        private final String CADENA_TOTAL_PRODUCTO = "Total Producto";

        private final VentaAnualProducto[] ventasAnuales;

        /**
         * Método para recuperar todas las ventas anuales de productos
         * @return Todas las ventas anuales de los productos
         */
        public VentaAnualProducto[] getVentasAnuales() {
            return ventasAnuales;
        }

        /**
         * Método para recuperar todas las ventas anuales de un producto
         * @param posicion Posición del producto en el array de ventas anuales
         * @return Toads las ventas anuales de un producto
         */
        public VentaAnualProducto getVentaAnualProducto(int posicion) {
            if (posicion <= ventasAnuales.length - 1) {
                return ventasAnuales[posicion];
            }
            else
            {
                return null;                
            }
        }

        /**
         * Constructor de la clase
         *
         * @param ventasAnuales Un array con las ventas de los productos del año
         */
        public SistemaDeVentas(VentaAnualProducto[] ventasAnuales) {
            this.ventasAnuales = ventasAnuales;
        }

        /**
         * Método que nos permite mostrar por pantalla los datos de ventas
         * anuales formateados con un diseño en forma de rejilla
         * @return Cadena formateada con los resultados
         */
        public String mostrarResultadosAnuales() {
            int contador;
            String resultado = "";

            // Definimos un String para pintar la linea de resultados
            String linea;

            // Iniciamos el pintado del cuadro dejando 30 espacios en blanco, esto 
            // es el espacio de 2 columnas de 15 espacios
            linea = Varios.generarCadena(" ", 30, "");

            // Concatenamos a la cadena 223 guiones para crear la primera linea
            linea += Varios.generarCadena("-", 223, "");

            // La imprimimos por pantalla
            resultado += "\n" + linea;

            // Reiniciamos el valor de linea, y le asignamos de nuevo 30 espacios 
            // en blanco
            linea = Varios.generarCadena(" ", 30, "");

            // A continuación iteramos por el array de meses, concatenando a la 
            // linea una barra, el valor del nombre del mes y los espacios 
            // necesarios para llegar a 15 caracteres
            for (String mes : ARRAY_MESES) {
                linea += "| " + mes + Varios.generarCadena(" ", 15, mes);
            }

            // Para finalizar contatenamos una barra más y la cadena del total del 
            // producto formateada a 15 espacios en blanco
            linea += "| " + CADENA_TOTAL_PRODUCTO + Varios.generarCadena(" ", 15,
                    CADENA_TOTAL_PRODUCTO) + " |";

            // Imprimimos la liea
            resultado += "\n" + linea;

            // Asignamos a la linea 253 guiones
            linea = Varios.generarCadena("-", 253, "");

            // Imprimimos la linea, con esto quedaria la cabeza de los meses 
            // dibujada
            resultado += "\n" + linea;

            // Reseteamos la liena una vez más
            linea = "";

            // Definimos unos arrays para ayudarnos a almacenar los totales
            // y controlar cual es el producto más vendido para cada mes
            // de todos los productos vendidos
            float[] totales = new float[13];
            float[] valorMasVendido = new float[12];
            int[] masVendido = new int[12];

            // Reiniciamos el contador para poder controlar en que iteración 
            // nos encontramos
            contador = -1;

            // Iteramos por todos los productos almacenados
            for (VentaAnualProducto producto : ventasAnuales) {

                // Aumentamos la variable contador
                contador++;

                // Concatenamos a la linea una barra vertical y el nombre del 
                // producto, formateado a 28 espacios
                linea += "| " + producto.getNombreProducto()
                        + Varios.generarCadena(" ", 28, producto.getNombreProducto());

                // A continuación iteramos por el array de meses
                for (int i = 0; i < ARRAY_MESES.length; i++) {

                    // Y concatenamos a la linea las ventas mensuales del producto
                    // para el mes correspondiente a la iteración actual
                    linea += "| " + producto.getVentasMensual(i)
                            + Varios.generarCadena(" ", 15,
                                    String.valueOf(producto.getVentasMensual(i)));

                    // Aumentamos el acumulador de ventas mensuales 
                    totales[i] += producto.getVentasMensual(i);

                    // Verificamos si las ventas mensuales son mayores que lo 
                    // almacenado en el array de control
                    if (producto.getVentasMensual(i) > valorMasVendido[i]) {

                        // De ser así actualizamos el array de control con el 
                        // valor más alto
                        valorMasVendido[i] = producto.getVentasMensual(i);

                        // Y guardamos el valor del contador en el array de 
                        // productos más vendidos
                        masVendido[i] = contador;
                    }

                }

                // Para finalizad concatenamos el producto total de ventas para 
                // el año formateado a 15 espacios en blanco 
                linea += "| " + producto.getTotalVentasProducto()
                        + Varios.generarCadena(" ", 15,
                                String.valueOf(producto.getTotalVentasProducto()))
                        + " |";

                // Aumentamos la valor de la última posición del array de totales
                // con el valor total de ventas del año
                totales[12] += producto.getTotalVentasProducto();

                // Imprimimos la linea creada
                resultado += "\n" + linea;

                // Sobreescribimos el valor de linea con 253 guiones
                linea = Varios.generarCadena("-", 253, "");

                // Imprimimos la nueva linea
                resultado += "\n" + linea;

                // Limpiamos la variable para la siguiente iteración
                linea = "";
            }

            // Generamos una nueva linea de 253 guiones
            linea = Varios.generarCadena("-", 253, "");

            // La imprimimos dos veces, marcará la separación de totales
            resultado += "\n" + linea;
            resultado += "\n" + linea;

            // Reseteamos su valor
            linea = "";

            // Concatenamos los valores de Total Mes formateado a 25 espacios en blanco
            linea += "| " + "Total mes" + Varios.generarCadena(" ", 28, "Total mes");

            // Iteramos una vez más por el array de meses concatenando los resultados
            for (int i = 0; i < ARRAY_MESES.length; i++) {

                // Concatenamos los valores antes generados formateados a 15 
                // espacios en blanco
                linea += "| " + totales[i]
                        + Varios.generarCadena(" ", 15, String.valueOf(totales[i]));

            }

            // Finalmente concatenamos tb el total del año
            linea += "| " + totales[12]
                    + Varios.generarCadena(" ", 15, String.valueOf(totales[12])) + " |";

            // Lo imprimirmos
            resultado += "\n" + linea;

            // Imprimimos una linea larga
            linea = Varios.generarCadena("-", 253, "");

            resultado += "\n" + linea;

            // Creamos una nuev a linea para mostrar el producto mas vendido para 
            // cada mes
            linea = "| " + "Producto más vendido"
                    + Varios.generarCadena(" ", 28, "Producto más vendido");

            // Iteramos una vez más por el array de meses
            for (int i = 0; i < ARRAY_MESES.length; i++) {

                // Concatenemos el nombre del producto más vendido formateado
                // a 15 espacios en blanco
                linea += "| " + ventasAnuales[masVendido[i]].getNombreProducto()
                        + Varios.generarCadena(" ", 15,
                                ventasAnuales[masVendido[i]].getNombreProducto());

            }

            // Concatenemoas el último cajón sin psarle valores ninguno y generando
            // simplemente 15 espacios en blanco
            linea += "| " + Varios.generarCadena(" ", 15, "") + " |";
            
            // Imprimimos la linea
            resultado += "\n" + linea;

            // Y finalizamos imprimiendo una linea de 253 guiones
            linea = Varios.generarCadena("-", 253, "");

            resultado += "\n" + linea;
            
            return resultado;
        }
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables
        int numProductos;
        String nombreProducto;
        float[] ventaMeses;
        final String[] ARRAY_MESES = new String[]{"Enero", "Febrero", "Marzo", "Abril",
            "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
            "Noviembre", "Diciembre"};

        numProductos = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el número de productos a procesar");

        // Creamos un array de objetos VentaAnualProducto
        VentaAnualProducto[] ventasAnuales = new VentaAnualProducto[numProductos];

        // Creamos e inicializamos un contador
        int contador = -1;

        for (VentaAnualProducto ventaAnual : ventasAnuales) {

            // Pedimos al usuario el nombre del producto
            nombreProducto = PeticionDatos.pedirCadena("Introduzca el nombre del producto");

            // Inicializamos el array de ventas
            ventaMeses = new float[12];

            // Creamos e inicializamos un contador para los ARRAY_MESES
            int contadorMeses = -1;

            // Iteramos por todos los valores del array
            for (String mes : ARRAY_MESES) {

                // Aumentamos el contador
                contadorMeses++;

                // Preguntamos las ventas del producto al usuario para el mes
                ventaMeses[contadorMeses] = (float) PeticionDatos.pedirRealPositivo("Introduzca la ventas del producto para " + mes);
            }

            // Creamos el objeto correspondiente a las ventas anuales del 
            // producto
            ventaAnual = new VentaAnualProducto(nombreProducto, ventaMeses);

            // Aumentamos el contador
            contador++;

            // Guardamos el objeto en el array de ventas anuales del producto
            ventasAnuales[contador] = ventaAnual;
        }

        // Creamos un nuevo objeto de Sistema de ventas al cual pasaremos en su
        // constructor los valores introducidos por el usuario
        SistemaDeVentas sistemaDeVentas = new SistemaDeVentas(ventasAnuales);

        // Mostramos los resultados formateados
        System.out.println(sistemaDeVentas.mostrarResultadosAnuales());
        
    }
}
