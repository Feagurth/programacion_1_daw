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

import java.util.Scanner;

/**
 * Modifique la clase Cuenta (figura 3.13) para proporcionar un método llamado
 * cargar, que retire dinero de un objeto Cuenta. Asegure que el monto a cargar
 * no exceda el saldo de Cuenta. Si lo hace, el saldo debe permanecer sin cambio
 * y el método debe imprimir un mensaje que indique "El monto a cargar excede el
 * saldo de la cuenta". Modifique la clase PruebaCuenta (figura 3.14) para
 * probar el método cargar.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio3_12 {

    // La clase Cuenta con un constructor para
    // inicializar la variable de instancia saldo.
    public class Cuenta {

        // variable de instancia que almacena el saldo
        private double saldo;

        // Metodo para sacar dinero de la cuenta.
        public boolean cargar(double cantidadRetirar) {
            if (cantidadRetirar < saldo) {
                saldo = saldo - cantidadRetirar;
                return true;
            } else {
                System.out.println("El monto a cargar excede el saldo de la cuenta");
                return false;
            }
        }

        // constructor
        public Cuenta(double saldoInicial) {
            // valida que saldoInicial sea mayor que 0.0;
            // si no lo es, saldo se inicializa con el valor predeterminado 0.0
            if (saldoInicial > 0.0) {
                saldo = saldoInicial;
            }
        } // fin del constructor de Cuenta

        // abona (suma) un monto a la cuenta
        public void abonar(double monto) {
            saldo = saldo + monto; // suma el monto al saldo
        } // fin del método abonar

        // devuelve el saldo de la cuenta
        public double obtenerSaldo() {
            return saldo; // proporciona el valor de saldo al método que hizo la llamada
        } // fin del método obtenerSaldo
    } // fin de la clase Cuenta    

    public void Ejercicio() {
        
        Cuenta cuenta1 = new Cuenta(50.00); // crea objeto Cuenta
        Cuenta cuenta2 = new Cuenta(-7.53); // crea objeto Cuenta

        // muestra el saldo inicial de cada objeto
        System.out.printf("Saldo de cuenta1: $%.2f\n", cuenta1.obtenerSaldo());
        System.out.printf("Saldo de cuenta2: $%.2f\n\n", cuenta2.obtenerSaldo());

        // crea objeto Scanner para obtener la entrada de la ventana de comandos
        Scanner entrada = new Scanner(System.in);
        double montoDeposito; // deposita el monto escrito por el usuario
        System.out.print("Escriba el monto a depositar para cuenta1: "); 

        // indicador
        montoDeposito = entrada.nextDouble(); // obtiene entrada del usuario
        System.out.printf("\nsumando %.2f al saldo de cuenta1\n\n", montoDeposito);
        cuenta1.abonar(montoDeposito); // suma al saldo de cuenta1

        // muestra los saldos
        System.out.printf("Saldo de cuenta1: $%.2f\n", cuenta1.obtenerSaldo());
        System.out.printf("Saldo de cuenta2: $%.2f\n\n", cuenta2.obtenerSaldo());
        System.out.print("Escriba el monto a depositar para cuenta2: "); 

        // indicador
        montoDeposito = entrada.nextDouble(); // obtiene entrada del usuario
        System.out.printf("\nsumando %.2f al saldo de cuenta2\n\n",
                montoDeposito);
        cuenta2.abonar(montoDeposito); // suma al saldo de cuenta2

        // muestra los saldos
        System.out.printf("Saldo de cuenta1: $%.2f\n", cuenta1.obtenerSaldo());
        System.out.printf("Saldo de cuenta2: $%.2f\n", cuenta2.obtenerSaldo());

        if (cuenta1.cargar(25)) {
            System.out.printf("Dinero retirado correctamente\n");
        } else {
            System.out.printf("Dinero no retirado correctamente\n");
        }
        System.out.printf("Saldo de cuenta1: $%.2f\n", cuenta1.obtenerSaldo());
        System.out.printf("Saldo de cuenta2: $%.2f\n", cuenta2.obtenerSaldo());
    } 
} 

