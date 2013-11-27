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

package pruebacuenta;

import java.util.Scanner;

/**
 * Clase para probar la clase Cuenta
 * @author Luis Cabrerizo Gómez
 */
public class PruebaCuenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta(50.00);
        Cuenta cuenta2 = new Cuenta(-7.00);
        double importeCuenta;
        Scanner entrada = new Scanner(System.in);
        
        System.out.printf("Saldo de la cuenta1: %.2f€\n", cuenta1.obtenerSaldo());
        System.out.printf("Saldo de la cuenta2: %.2f€\n", cuenta2.obtenerSaldo());
        
        System.out.print("Escribe el importe para la cuenta1: ");
        importeCuenta = entrada.nextDouble();
        
        cuenta1.Abonar(importeCuenta);
        
        System.out.printf("Saldo de la cuenta1: %.2f€\n", cuenta1.obtenerSaldo());
        System.out.printf("Saldo de la cuenta2: %.2f€\n", cuenta2.obtenerSaldo());

        System.out.print("Escribe el importe para la cuenta2: ");
        importeCuenta = entrada.nextDouble();
        
        cuenta2.Abonar(importeCuenta);
        
        System.out.printf("Saldo de la cuenta1: %.2f€\n", cuenta1.obtenerSaldo());
        System.out.printf("Saldo de la cuenta2: %.2f€\n", cuenta2.obtenerSaldo());
        
        
    }
    
}
