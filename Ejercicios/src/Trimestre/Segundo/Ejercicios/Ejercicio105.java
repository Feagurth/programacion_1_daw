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
 * Una empresa tiene almacenados a sus vendedores en un registro. Por cada
 * vendedor se guarda su DNI, Apellidos, Nombre, Zona, Sueldo Base, Ventas,
 * Total Anual y Comisión. Las ventas mensuales será un vector de 12 elementos
 * que guardará las ventas realizadas en cada uno de los meses. Total Anual será
 * la suma de las ventas mensuales del vendedor. La Comisión se calculará
 * aplicando un porcentaje variable al Total Anual del vendedor. Dicho
 * porcentaje variará según las ventas del vendedor, según la siguiente tabla:
 * Hasta de 1.500.000 0,00% Más de 1.500.000 y hasta 2.150.000 13,75% Más de
 * 2.150.000 y hasta 2.900.000 16,50% Más de 2.900.000 y hasta 3.350.000 17,60%
 * Más de 3.350.000 18,85% Implementar una clase que recoja los datos de cada
 * vendedor. Probar la clase para un número variable de vendedores. A la hora de
 * probar la clase, hacer que de forma interactiva se introduzcan los datos
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio105 {

    /**
     * Clase para almacenar los datos de un vendedor
     *
     * @author Luis Cabrerizo Gómez
     */
    class Vendedor {

        String DNI;
        String nombre;
        String apellidos;
        String zona;
        float sueldoBase;
        float ventasMes[];
        float totalAnual;
        float comision;

        /**
         * Constructor de la clase Vendedor
         *
         * @param DNI DNI del vendedor como cadena
         * @param nombre Nombre del vendedor
         * @param apellidos Apellido del vendedor
         * @param zona Zona en la que trabaja el vendedor
         * @param sueldoBase Sueldo base del vendedor
         */
        public Vendedor(String DNI, String nombre, String apellidos, String zona, float sueldoBase) {

            // Asignamos los valores a las variables de instancia
            this.DNI = DNI;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.zona = zona;
            this.sueldoBase = sueldoBase;

        // Creamos un array de float de 12 de tamaño, que corresponderá a los 
            // meses del año
            ventasMes = new float[12];
        }

        /**
         * Método que nos permite asignar las ventas de un mes a un vendedor
         *
         * @param mes Mes al que corresponden las ventas como un entero
         * @param ventas Total de las ventas de el mes
         */
        public void setVentaMes(int mes, float ventas) {
            // Introducimos el valor de ventas del mes
            this.ventasMes[mes] = ventas;

            // Reseteamos el total anual
            this.totalAnual = 0;

            // Calculamos el total anual sumando las ventas de todos los meses
            for (int i = 0; i < ventasMes.length; i++) {
                this.totalAnual += ventasMes[i];
            }

        // Asginamos el porcentaje de la comisión del vendedor dependiendo del 
            // total de ventas anual
            if (totalAnual < 1500000) {
                this.comision = 0;
            }

            if (totalAnual >= 1500000 && totalAnual < 2150000) {
                this.comision = 13.75f;
            }

            if (totalAnual >= 2150000 && totalAnual < 2900000) {
                this.comision = 16.50f;
            }

            if (totalAnual >= 2900000 && totalAnual < 3350000) {
                this.comision = 17.60f;
            }

            if (totalAnual >= 3350000) {
                this.comision = 18.85f;
            }

            // Calculamos el total de comisión que recibirá el vendedor
            this.comision = ((this.comision * totalAnual) / 100);
        }

        /**
         * Método que nos permite recuperar el valor del total de ventas anual
         * del vendedor
         *
         * @return El valor total de las ventas anuales del vendedor
         */
        public float getTotalAnual() {
            return totalAnual;
        }

        /**
         * Método que nos permite recuperar el valor de la comisión generada por
         * el vendedor
         *
         * @return Comisión generada por el vendedor
         */
        public float getComision() {
            return comision;
        }
    }

    public void Ejercicio() {
        // Objeto para recoger datos desde el teclado
        Scanner entrada = new Scanner(System.in);

        // Array con los nombres de los meses del año
        final String[] meses = new String[]{"Enero", "Febrero", "Marzo", "Abril",
            "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
            "Noviembre", "Diciembre"};

        // Variables
        int numVendedores;
        float ventaMes;
        String nombre;
        String apellidos;
        String dni;
        String zona;
        float sueldoBase;
        int contMeses;

        // Pedimos al usuario el número de vendedores
        do {
            System.out.print("Introduzca el número de vendedores: ");
            numVendedores = entrada.nextInt();
        } while (numVendedores <= 0);

        // Creamos un array de objetos Vendedor
        Vendedor[] vendedores = new Vendedor[numVendedores];
        int loop = -1;

        for (Vendedor vendedor : vendedores) {

            // Aumentamos el contador de vendedores
            loop++;

            // Reinicializamos el objeto de petición de datos por teclado
            entrada = new Scanner(System.in);

            // Pedimos al usuario los datos principales del vendedor
            System.out.print("Introduzca el DNI del vendedor: ");
            dni = entrada.nextLine();

            System.out.print("Introduzca el nombre del vendedor: ");
            nombre = entrada.nextLine();

            System.out.print("Introduzca los apellidos del vendedor: ");
            apellidos = entrada.nextLine();

            System.out.print("Introduzca la zona de trabajo del vendedor: ");
            zona = entrada.nextLine();

            System.out.print("Introduzca el sueldo base del vendedor: ");
            sueldoBase = entrada.nextFloat();

            // Creamos el objeto vendedor
            vendedor = new Vendedor(dni, nombre, apellidos, zona, sueldoBase);

            // Inicializamos el contador de meses
            contMeses = -1;

            // Iteramos por el array de meses para pedir los datos del ventas 
            // al usuario
            for (String mes : meses) {

                // Aumentamos el contador de meses
                contMeses++;

                System.out.print("Introduzca el total de ventas para el mes "
                        + "de " + mes + ": ");
                ventaMes = entrada.nextFloat();
                vendedor.setVentaMes(contMeses, ventaMes);
            }

            // Asignamos el objeto con los datos introducidos al array de 
            // vendedores creado anteriormente
            vendedores[loop] = vendedor;

            System.out.println("");

        }

        // Iteramos para ver los resultados del todos los vendedores que haya 
        // en el array de vendedores
        for (Vendedor vendedor : vendedores) {

            System.out.println("Datos del vendedor: " + vendedor.nombre + " "
                    + vendedor.apellidos);
            System.out.println("DNI: " + vendedor.DNI);
            System.out.println("Zona: " + vendedor.zona);
            System.out.println("Sueldo Base: " + vendedor.sueldoBase);
            System.out.println("Total Ventas Anual: " + vendedor.totalAnual);
            System.out.println("Comisión : " + vendedor.comision);
            System.out.println("");
        }
    }
}
