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
public class Ejercicio002 {

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
        int numMedicamentos;

        do {
            System.out.print("Introduzca el número de medicamentos a procesar: ");
            numMedicamentos = entrada.nextInt();
        } while (numMedicamentos <= 0);

        // Creamos un array de objetos para almacenar los registros de 
        // los medicamentos
        RegistroMedicamento[] registros = new RegistroMedicamento[numMedicamentos];

        int contador = -1;
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

        for (RegistroMedicamento registro : registros) {
            contador++;

            // Reiniciamos el objeto encargado de leer datos desde el teclado
            entrada = new Scanner(System.in);

            // Pedimos los datos necesarios al usaurio
            System.out.print("Introduzca el código del medicamento: ");
            codigo = entrada.nextLine();

            System.out.print("Introduzca el nombre del medicamento: ");
            nombre = entrada.nextLine();

            System.out.print("Introduzca la descripción del medicamento: ");
            descripcion = entrada.nextLine();

            System.out.print("Introduzca el laboratorio del medicamento: ");
            laboratorio = entrada.nextLine();

            System.out.print("Introduzca el proveedor del medicamento: ");
            proveedor = entrada.nextLine();

            System.out.print("Introduzca el precio del medicamento: ");
            precio = entrada.nextFloat();

            System.out.print("Introduzca el porcentaje del IVA del medicamento: ");
            porcentajeIVA = entrada.nextFloat();

            System.out.print("Introduzca el stock del medicamento: ");
            stock = entrada.nextInt();

            System.out.print("Introduzca el dia de caducidad del medicamento: ");
            diaFechaCaducidad = entrada.nextInt();

            System.out.print("Introduzca el mes de caducidad del medicamento: ");
            mesFechaCaducidad = entrada.nextInt();

            System.out.print("Introduzca el año de caducidad del medicamento: ");
            anyoFechaCaducidad = entrada.nextInt();

            // Cremaos el objeto con los datos que ha introducido el usuario
            registro = new RegistroMedicamento(codigo, nombre, descripcion,
                    laboratorio, proveedor, precio, porcentajeIVA, stock,
                    diaFechaCaducidad, mesFechaCaducidad, anyoFechaCaducidad);

            // Asignamos el objeto con los datos introducidos en el array de 
            // registros
            registros[contador] = registro;

        }

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
    
}
