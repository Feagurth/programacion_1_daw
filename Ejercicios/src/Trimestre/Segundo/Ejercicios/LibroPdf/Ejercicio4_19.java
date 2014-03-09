/*
 * Copyright (C) 2013 Luis Cabrerizo Gómez
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

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * Clase para realizar el ejercicio 4.19 del libro de texto Como Programar en
 * Java 7ed Deitel
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_19 {

    /**
     * Clase para calcular las comisiones de un vendedor
     */
    public class CalculoComisiones {

        private final double PAGA_SEMANAL = 200f;

        // Variables que necesita la clase
        private final double paga;
        private final double valorVentas;

        /**
         * Devuelve el valor de la paga del comercial
         *
         * @return El valor de la paga del comercial
         */
        public double getPaga() {
            return paga;
        }

        /**
         * Constructor de la clase
         *
         * @param valorVentas Valor total de las ventas del comercial
         */
        public CalculoComisiones(double valorVentas) {
            this.valorVentas = valorVentas;
            this.paga = (this.valorVentas * 0.09) + this.PAGA_SEMANAL;
        }
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Objeto para calcular las comisiones del comercial
        CalculoComisiones comision;

        // Variable para almacenar el total vendido por el comercial.
        double totalVendido = 0;

        // Variable para almacenar las ventas del comercial
        double vendido;

        // Iteramos hasta que se cumpla la condición de salida
        do {
            // Pedimos datos al usuarios
            vendido = PeticionDatos.pedirRealPositivo("Introduzca el codigo "
                    + "del articulo vendido.\nIntroduzca 0 para finalizar");

            // Dependiendo del valor itnroducido por el usuario le 
            // asignamos un valor
            switch ((int) vendido) {
                case 0: {
                    vendido = 0f;
                    break;
                }
                case 1: {
                    vendido = 239.99f;
                    break;
                }
                case 2: {
                    vendido = 129.75f;
                    break;
                }
                case 3: {
                    vendido = 99.95f;
                    break;
                }
                case 4: {
                    vendido = 350.89f;
                    break;
                }
            }

            // Aumentamos el acumulador
            totalVendido += vendido;

        } while (vendido != 0); // Condición de salida

        // Creamos el objeto pasandole el total de las ventas realizadas
        comision = new CalculoComisiones(totalVendido);

        // Mostramos el el resultado
        Mensajes.mostrarMensaje("Los ingresos del vendedor son de: "
                + comision.getPaga(), Mensajes.TipoMensaje.INFORMACION);
    }

}
