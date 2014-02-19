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
package Trimestre.Segundo.Ejercicios.ExpresionesRegulares;

import java.util.Scanner;

/**
 * Una farmacia desea almacenar sus productos en una estructura de registros.
 * Cada registro tiene los campos Código, Nombre, Descripción del Medicamento
 * (antibiótico, analgésico, etc.), Laboratorio, Proveedor, Precio, Porcentaje
 * de IVA, Stock y Fecha de Caducidad. La fecha deberá guardar por separado el
 * día, mes y año. Diseñe la estructura de datos y un procedimiento que permita
 * escribir los datos de un medicamento.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio004 {

    /**
     * Clase que nos permite almacenar los datos de un registro de medicamentos
     */
    public class RegistroMedicamento {

        String codigo;
        String nombre;
        String descripcion;
        String laboratorio;
        String proveedor;
        float precio;
        float porcentajeIVA;
        int stock;
        int diaFechaCaducidad;
        int mesFechaCaducidad;
        int anyoFechaCaducidad;

        public RegistroMedicamento(String codigo, String nombre,
                String descripcion, String laboratorio, String proveedor,
                float precio, float porcentajeIVA, int stock,
                int diaFechaCaducidad, int mesFechaCaducidad,
                int anyoFechaCaducidad) {

            this.codigo = codigo;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.laboratorio = laboratorio;
            this.proveedor = proveedor;
            this.precio = precio;
            this.porcentajeIVA = porcentajeIVA;
            this.stock = stock;
            this.diaFechaCaducidad = diaFechaCaducidad;
            this.mesFechaCaducidad = mesFechaCaducidad;
            this.anyoFechaCaducidad = anyoFechaCaducidad;
        }

    }

    public void Ejercicio() {
        // Objeto para pedir datos por teclado al usuario
        Scanner entrada = new Scanner(System.in);
        String numMedicamentos;

        do {
            System.out.print("Introduzca el número de medicamentos a procesar: ");
            numMedicamentos = entrada.nextLine();
        } while (!validacion(numMedicamentos, "[0-9]+") || Integer.parseInt(numMedicamentos) <= 0);

        // Creamos un array de objetos para almacenar los registros de 
        // los medicamentos
        RegistroMedicamento[] registros = new RegistroMedicamento[Integer.parseInt(numMedicamentos)];

        int contador = -1;
        String codigo;
        String nombre;
        String descripcion;
        String laboratorio;
        String proveedor;
        String precio;
        String porcentajeIVA;
        String stock;
        int diaFechaCaducidad = 0;
        int mesFechaCaducidad = 0;
        int anyoFechaCaducidad = 0;
        String fechaCaducidad;

        for (RegistroMedicamento registro : registros) {
            contador++;

            // Reiniciamos el objeto encargado de leer datos desde el teclado
            entrada = new Scanner(System.in);

            // Pedimos los datos necesarios al usaurio validando las entradas
            // con expresiones regulares
            do {
                System.out.print("Introduzca el código del medicamento: ");
                codigo = entrada.nextLine();
            } while (!validacion(codigo, "[a-zA-Z0-9]+"));

            do {
                System.out.print("Introduzca el nombre del medicamento: ");
                nombre = entrada.nextLine();
            } while (!validacion(nombre, "[a-zA-Z0-9 ]+"));

            do {
                System.out.print("Introduzca la descripción del medicamento: ");
                descripcion = entrada.nextLine();
            } while (!validacion(descripcion, "[a-zA-Z0-9 ]+"));

            do {
                System.out.print("Introduzca el laboratorio del medicamento: ");
                laboratorio = entrada.nextLine();
            } while (!validacion(laboratorio, "[a-zA-Z0-9 ]+"));

            do {
                System.out.print("Introduzca el proveedor del medicamento: ");
                proveedor = entrada.nextLine();
            } while (!validacion(proveedor, "[a-zA-Z0-9 ]+"));

            do {
                System.out.print("Introduzca el precio del medicamento: ");
                precio = entrada.nextLine();
            } while (!validacion(String.valueOf(precio), "[0-9]*\\,[0-9]+|[0-9]*\\.[0-9]+|[0-9]+"));

            precio = precio.replace(",", ".");

            do {
                System.out.print("Introduzca el porcentaje del IVA del medicamento: ");
                porcentajeIVA = entrada.nextLine();
            } while (!validacion(String.valueOf(porcentajeIVA), "[0-9]*\\,[0-9]+|[0-9]*\\.[0-9]+|[0-9]+"));

            porcentajeIVA = porcentajeIVA.replace(",", ".");

            do {
                System.out.print("Introduzca el stock del medicamento: ");
                stock = entrada.nextLine();
            } while (!validacion(String.valueOf(stock), "[0-9]+"));

            // Definimos una variable control para poder validar la fecha 
            // introducida por teclado
            boolean control = false;

            // Iteraremos mientras control sea falso
            do {
                System.out.print("Introduzca la fecha de caducidad del medicamento [dd/mm/yyy]: ");
                fechaCaducidad = entrada.nextLine();

                // Validamos la fecha con expresiones regulares
                if (validacion(String.valueOf(fechaCaducidad), "[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
                    
                    // Partimos la cadena en cachos usando el carácter / 
                    // como punto de partición
                    diaFechaCaducidad = Integer.parseInt(fechaCaducidad.split("/")[0]);
                    mesFechaCaducidad = Integer.parseInt(fechaCaducidad.split("/")[1]);
                    anyoFechaCaducidad = Integer.parseInt(fechaCaducidad.split("/")[2]);

                    // Validamos si la fechas es válida
                    if (EsFechaValida(diaFechaCaducidad, mesFechaCaducidad, anyoFechaCaducidad)) {
                        // Si es válida cambiamos el valor de la variable de 
                        // control
                        control = true;
                    }
                }

            } while (!control);

            // Cremaos el objeto con los datos que ha introducido el usuario
            registro = new RegistroMedicamento(codigo, nombre, descripcion,
                    laboratorio, proveedor, Float.parseFloat(precio),
                    Float.parseFloat(porcentajeIVA), Integer.parseInt(stock),
                    diaFechaCaducidad, mesFechaCaducidad, anyoFechaCaducidad);

            // Asignamos el objeto con los datos introducidos en el array de 
            // registros
            registros[contador] = registro;

        }

        // Iteramos por los registros para mostrar los resultados
        for (RegistroMedicamento registro : registros) {

            System.out.println("Datos del medicamento " + registro.nombre);
            System.out.println("Código: " + registro.codigo);
            System.out.println("Nombre: " + registro.nombre);
            System.out.println("Descripción: " + registro.descripcion);
            System.out.println("Laboratorio: " + registro.laboratorio);
            System.out.println("Proveedor: " + registro.proveedor);
            System.out.println("Precio: " + registro.precio);
            System.out.println("% IVA: " + registro.porcentajeIVA);
            System.out.println("Stock: " + registro.stock);
            System.out.println("Fecha Caducidad: " + registro.diaFechaCaducidad
                    + "/" + registro.mesFechaCaducidad + "/"
                    + registro.anyoFechaCaducidad);
        }
    }

    /**
     * Función para validar entradas con expresiones regulares
     *
     * @param cadena Cadena de texto a validar
     * @param patron Patrón de validación
     * @return Verdadero si la cadena es validada correctamente y falso en caso
     * contrario
     */
    private boolean validacion(String cadena, String patron) {

        return cadena.matches(patron);
    }

    /**
     * Función para comprobar si una fecha es válida
     *
     * @param numdia Día
     * @param numMes Mes
     * @param numAnyo Año
     * @return Resultado de la comprobación
     */
    private boolean EsFechaValida(int numdia, int numMes, int numAnyo) {
        int[] dias = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Comprobamos que los valores introducidos sean positivos
        if (numdia <= 0 || numMes <= 0 || numAnyo < 0 || numMes > 12) {
            return false;
        } else {
            // Verificamos si el año es bisiesto y si es febrero
            if (EsAnyoBisiesto(numAnyo) && numMes == 2) {
                // Devolvemos la comprobación de si el dia está en los dias
                // que tiene el mes mas 1 dia por ser bisiesto Febrero                
                return numdia <= (dias[numMes - 1] + 1);
            } else {
                // Devolvemos la comprobación de si el dia está en los dias
                // que tiene el mes
                return numdia <= dias[numMes - 1];
            }
        }
    }

    /**
     * Función para comprobar si un año es bisiesto
     *
     * @param anyo Año a comprobar
     * @return Resultado de la comprobación
     */
    private boolean EsAnyoBisiesto(int anyo) {
        // Para verificar si un año es bisiesto se tiene que verificar esta
        // condición
        return (anyo % 4 == 0) && ((anyo % 100 != 0) || (anyo % 400 == 0));
    }

}
