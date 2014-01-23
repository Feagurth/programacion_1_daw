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
package Trimestre.Segundo.Ejercicios.LibroPdf;

/**
 * Cree una clase llamada Factura, que una ferretería podría utilizar para
 * representar una factura para un artículo vendido en la tienda. Una Factura
 * debe incluir cuatro piezas de información como variables de instancia: un
 * número de pieza (tipo String), la descripción de la pieza (tipo String), la
 * cantidad de artículos de ese tipo que se van a comprar (tipo int) y el precio
 * por artículo (double). Su clase debe tener un constructor que inicialice las
 * cuatro variables de instancia. Proporcione un método establecer y un método
 * obtener para cada variable de instancia. Además, proporcione un método
 * llamado obtenerMontoFactura, que calcule el monto de la factura (es decir,
 * que multiplique la cantidad por el precio por artículo) y después devuelva
 * ese monto como un valor double. Si la cantidad no es positiva, debe
 * establecerse en 0. Si el precio por artículo no es positivo, debe
 * establecerse a 0.0. Escriba una aplicación de prueba llamada Prueba- Factura,
 * que demuestre las capacidades de la clase Factura.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio3_13 {

    public class Factura {

        // Variables
        private String numeroPieza;
        private String descripcion;
        private int cantidad;
        private double precio;

        // Getters & Setters
        public String getNumeroPieza() {
            return numeroPieza;
        }

        public void setNumeroPieza(String numeroPieza) {
            this.numeroPieza = numeroPieza;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            if (cantidad > 0) {
                this.cantidad = cantidad;
            } else {
                this.cantidad = 0;
            }
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            if (precio > 0) {
                this.precio = precio;
            } else {
                this.precio = 0.0f;
            }
        }

        /**
         * Constructor de la clase
         *
         * @param numPieza Identificador de la pieza
         * @param desc Descripción de la pieza
         * @param cant Cantidad de piezas vendidas
         * @param prec Precio unitario de la pieza
         */
        public Factura(String numPieza, String desc, int cant, double prec) {
            numeroPieza = numPieza;
            descripcion = desc;
            cantidad = cant;
            precio = prec;
        }

       /**
         * Método para devolver el valor de la factura
         *
         * @return Valor de la factura
         */
        public double obtenerMontoFactura() {
            return cantidad * precio;
        }
    }

    public void Ejercicio() {
        
        // Creamos el nuevo objeto
        Factura nuevaFactura = new Factura("1", "Ladrillos", 5, 8.9);
        
        // Mostramos el resultado
        System.out.println("La factura es: " + nuevaFactura.obtenerMontoFactura());
    }
}