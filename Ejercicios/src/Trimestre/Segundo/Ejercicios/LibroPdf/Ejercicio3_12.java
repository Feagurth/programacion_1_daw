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

    /**
     * Método para mostrar un menú al usuario y validar la selección del mismo
     *
     * @return Un entero con la opción selecionada por el usuario
     */
    private int mostrarMenu() {
        int resultado = 0;
        String seleccion = "";
        Scanner entrada = new Scanner(System.in);

        System.out.println("****************************");
        System.out.println("* 1.- Consultar saldo      *");
        System.out.println("* 2.- Ingresar dinero      *");
        System.out.println("* 3.- Retirar dinero       *");
        System.out.println("* 0.- Salir                *");
        System.out.println("****************************");
        System.out.print("Selecciones una operacion: ");

        do {
            seleccion = entrada.nextLine();

        } while (!seleccion.matches("[0-3]{1}"));

        return Integer.parseInt(seleccion);
    }

    /**
     * Método que nos permite pedirle al usuario que introduzca una cantidad
     * @param cadena Cadena que define la petición al usuario
     * @return Un valor de dinero como un double
     */
    private double pedirDinero(String cadena) {
        String seleccion = "";
        Scanner entrada = new Scanner(System.in);

        System.out.print("Introduzca la cantidad de dinero a " + cadena + ": ");

        do {
            seleccion = entrada.nextLine();

        } while (!seleccion.matches("^([1-9]{1}[0-9]{0,}([\\.|\\,][0-9]{1,})?|0([\\.|\\,][0-9]{1,})?|[\\.|\\,][0-9]{1,})$"));

        return Double.parseDouble(seleccion);
    }    
    
    public void Ejercicio() {

        Cuenta cuenta = new Cuenta(50.00); // crea objeto Cuenta
        int seleccion;

        do {

            seleccion = mostrarMenu();
            switch (seleccion) {
                case 1: {
                    System.out.printf("El saldo actual de la cuenta es: %6.2f\n", cuenta.obtenerSaldo());
                    break;
                }
                case 2: {
                    double monto = pedirDinero("retirar");
                    cuenta.abonar(monto);
                    System.out.printf("El saldo actual de la cuenta es: %6.2f\n", cuenta.obtenerSaldo());
                    break;
                }
                case 3: {
                    double monto = pedirDinero("ingresar");
                    cuenta.cargar(monto);
                    System.out.printf("El saldo actual de la cuenta es: %6.2f\n", cuenta.obtenerSaldo());
                    
                    break;
                }
            }
        } while (seleccion != 0);
    }
}
