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
 * Clase para realizar el ejercicio 4.18 del libro de texto
 * Como Programar en Java 7ed Deitel
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_18 {

    /**
     * Clase para controlar la cuenta de un cliente, así como su crédito
     */
    public class CuentaCorriente {

        // Variables para la clase
        private final int numeroCuenta;
        private final int saldoInicial;
        private final int totalArticulosMes;
        private final int totalCreditosMes;
        private final int limitePermitido;
        private final int saldoActual;

        /**
         * Devuelve el saldo actual del cliente
         *
         * @return El saldo actual del cliente
         */
        public int getSaldoActual() {
            return saldoActual;
        }

        /**
         * Devuelve el valor del numero de cuenta
         *
         * @return El numero de cuenta del cliente
         */
        public int getNumeroCuenta() {
            return numeroCuenta;
        }

        /**
         * Devuelve el valor del saldo inicial del cliente
         *
         * @return El valor del saldo inicial del cliente
         */
        public int getSaldoInicial() {
            return saldoInicial;
        }

        /**
         * Devuelve el valor del total de artículos cargados al cliente
         *
         * @return El valor del total de artículosc argados al cliente
         */
        public int getTotalArticulosMes() {
            return totalArticulosMes;
        }

        /**
         * Devuelve el valor del total de los créditos cargados al cliente
         *
         * @return El valor del total de los créditos cargados al cliente
         */
        public int getTotalCreditosMes() {
            return totalCreditosMes;
        }

        /**
         * Devuelve el límite de crédito del cliente
         *
         * @return El límite de crédito del cliente
         */
        public int getLimitePermitido() {
            return limitePermitido;
        }

        /**
         * Constructor de la clase
         *
         * @param numeroCuenta Número de cuenta del cliente
         * @param saldoInicial El saldo al inicio del mes.
         * @param totalArticulosMes El total de todos los artículos cargados por
         * el cliente en el mes.
         * @param totalCreditosMes El total de todos los créditos aplicados a la
         * cuenta del cliente en el mes.
         * @param limitePermitido El límite de crédito permitido.
         */
        public CuentaCorriente(int numeroCuenta, int saldoInicial,
                int totalArticulosMes, int totalCreditosMes, int limitePermitido) {
            this.numeroCuenta = numeroCuenta;
            this.saldoInicial = saldoInicial;
            this.totalArticulosMes = totalArticulosMes;
            this.totalCreditosMes = totalCreditosMes;
            this.limitePermitido = limitePermitido;
            this.saldoActual = (this.saldoInicial + this.totalArticulosMes
                    - this.totalCreditosMes);
        }
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Objeto que usaremos para controlar las cuetnas de un cliente
        CuentaCorriente cuentaCliente;

        // Objeto que usaremos para pedir y mostrar datos al usuario
        Mensajes mensajes = new Mensajes();
        
        // Variables para almacenar datos que pediremos al usuario
        int numCuenta, saldoInicial, totalArticulos, totalCreditos, limiteCredito;
    
        
        // Pedismos los datos necesarios al usuario
        numCuenta = PeticionDatos.pedirEnteroPositivo("Introduzca el número de cuenta del cliente");
        
        saldoInicial = PeticionDatos.pedirEntero("Introduzca el saldo inicial del cliente");
        
        totalArticulos = PeticionDatos.pedirEnteroPositivo("Introduzca el total de artículos cargados este mes");
        
        totalCreditos = PeticionDatos.pedirEnteroPositivo("Introduzca el total de creditos cargados este mes");
        
        limiteCredito = PeticionDatos.pedirEnteroPositivo("Introduzca el límite de crédito del cliente");
                
        // Creamos el objeto
        cuentaCliente = new CuentaCorriente(numCuenta, saldoInicial, totalArticulos, totalCreditos, limiteCredito);
        
        
        // Comparamos valores y mostramos el resultado correspondiente
        if(cuentaCliente.getSaldoActual() <=  cuentaCliente.getLimitePermitido())
        {
            System.out.println("Se excedió el límite de su crédito");
        }
        else
        {
            System.err.println("Su saldo actual es de: " +cuentaCliente.getSaldoActual());
                    
        }
    
    
    }


}
