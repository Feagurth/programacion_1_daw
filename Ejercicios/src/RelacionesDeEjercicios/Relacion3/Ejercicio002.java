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
import Utiles.Validaciones;

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
    public static class Medicamento {

        /**
         * Enumerador para almacenar la descrioción del medicamento
         */
        public enum TipoDescripcion {

            analgesico(0), antibiotico(1), antipiretico(2);
            private final int value;
            private String cadena;

            /**
             * Constructor del enumerador
             *
             * @param value
             */
            private TipoDescripcion(int value) {
                this.value = value;

                switch (value) {
                    case 0:
                        this.cadena = "Analgésico";
                        break;
                    case 1:
                        this.cadena = "Antibiotico";
                        break;
                    case 2:
                        this.cadena = "Antipirético";
                        break;
                }
            }

            /**
             * Devuelve el valor numérico del tipo de medicamento
             *
             * @return El valor numérico del tipo de medicamento
             */
            public int getValue() {
                return value;
            }

            /**
             * Método que nos devuelve la cadena representativa de la
             * descripción
             *
             * @return
             */
            public String getString() {
                return cadena;
            }
        };

        // Variables de la clase
        private final String codigo;
        private final String nombre;
        private final TipoDescripcion descripcion;
        private final String laboratorio;
        private final String proveedor;
        private final float precio;
        private final float porcentajeIVA;
        private final int stock;
        private final int diaFechaCaducidad;
        private final int mesFechaCaducidad;
        private final int anyoFechaCaducidad;

        // Getters
        public String getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public TipoDescripcion getDescripcion() {
            return descripcion;
        }

        public String getLaboratorio() {
            return laboratorio;
        }

        public String getProveedor() {
            return proveedor;
        }

        public float getPrecio() {
            return precio;
        }

        public float getPorcentajeIVA() {
            return porcentajeIVA;
        }

        public int getStock() {
            return stock;
        }

        public int getDiaFechaCaducidad() {
            return diaFechaCaducidad;
        }

        public int getMesFechaCaducidad() {
            return mesFechaCaducidad;
        }

        public int getAnyoFechaCaducidad() {
            return anyoFechaCaducidad;
        }

        /**
         * Constructor de la clase
         *
         * @param codigo Código del medicamento
         * @param nombre Nombre del medicamento
         * @param descripcion Descripción del medicamento
         * @param laboratorio Laboratorio del medicamento
         * @param proveedor Proveedor del medicamento
         * @param precio Precio del medicamento
         * @param porcentajeIVA Procentaje de IVA del medicamento
         * @param stock Stock del medicamento
         * @param diaFechaCaducidad Dia de la fecha de caducidad del medicamento
         * @param mesFechaCaducidad Mes de la fecha de caducidad del medicamento
         * @param anyoFechaCaducidad Año de la fecha de caducidad del
         * medicamento
         */
        public Medicamento(String codigo, String nombre,
                TipoDescripcion descripcion, String laboratorio, String proveedor,
                float precio, float porcentajeIVA, int stock,
                int diaFechaCaducidad, int mesFechaCaducidad,
                int anyoFechaCaducidad) {

            // Asginamos los parametros a las variables de instancia
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

        @Override
        /**
         * Método para devolver una representación en cadena de los valores
         * que contiene el objeto
         */
        public String toString() {
            return String.format("Medicamento{codigo=%s, nombre=%s, "
                    + "descripcion=%s, laboratorio=%s, proveedor=%s, precio=%s, "
                    + "porcentajeIVA=%s, stock=%s, diaFechaCaducidad=%s, "
                    + "mesFechaCaducidad=%s, anyoFechaCaducidad=%s}",
                    codigo, nombre, descripcion.getString(), laboratorio, proveedor, precio,
                    porcentajeIVA, stock, diaFechaCaducidad, mesFechaCaducidad,
                    anyoFechaCaducidad);

        }

    }

    public void Ejercicio() {

        // Variables
        int numMedicamentos;

        // Pedimos el número de medicamentos a procesar
        numMedicamentos = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el número de medicamentos a procesar");

        // Creamos un array de objetos para almacenar los registros de 
        // los medicamentos
        Medicamento[] registros = new Medicamento[numMedicamentos];

        // Variables para almacenar los valores que se pedirán al usuario
        int contador = -1;
        String codigo;
        String nombre;
        int descripcion;
        String laboratorio;
        String proveedor;
        float precio;
        float porcentajeIVA;
        int stock;
        int diaFechaCaducidad;
        int mesFechaCaducidad;
        int anyoFechaCaducidad;

        // Iteramos tantasveces como número de medicamentos hayamos especificados
        for (Medicamento registro : registros) {
            contador++;

            // Pedimos los datos necesarios al usaurio
            codigo = PeticionDatos.pedirCadena("Introduzca el código del medicamento");

            nombre = PeticionDatos.pedirCadena("Introduzca el nombre del medicamento");

            // Iteramos por todos los valores del enumerador para mostrar las posibilidades de selección
            // al usuario
            for (Medicamento.TipoDescripcion tipoDescripcion : Medicamento.TipoDescripcion.values()) {
                System.out.println("[" + tipoDescripcion.getValue() + "] " + tipoDescripcion.getString());
            }

            // Pedimos que introduzca la descripción del medicamento, y limitaremos
            // los valores de entrada desde el cero hasta un valor menos del tamaño
            // de los valores del enumerador, para que, de este modo se puedan
            // elegir todos los tipos de descripciones
            descripcion = PeticionDatos.pedirEnteroRango("Introduzca la descripción del medicamento", 0, Medicamento.TipoDescripcion.values().length - 1);

            laboratorio = PeticionDatos.pedirCadena("Introduzca el laboratorio del medicamento");

            proveedor = PeticionDatos.pedirCadena("Introduzca el proveedor del medicamento");

            precio = (float) PeticionDatos.pedirRealPositivo("Introduzca el precio del medicamento");

            porcentajeIVA = (float) PeticionDatos.pedirRealPositivo("Introduzca el porcentaje del IVA del medicamento");

            stock = PeticionDatos.pedirEnteroPositivo("Introduzca el stock del medicamento");

            // Iteramos preguntando los datos de la fechas hasta introducir una válida           
            do {
                diaFechaCaducidad = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el dia de caducidad del medicamento");

                mesFechaCaducidad = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el mes de caducidad del medicamento");

                anyoFechaCaducidad = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el año de caducidad del medicamento");
            } while (!Validaciones.validarDato(
                    diaFechaCaducidad + "/" + mesFechaCaducidad + "/" + anyoFechaCaducidad,
                    Validaciones.TipoValidacion.FECHA_DDMMAAAA));

            // Cremaos el objeto con los datos que ha introducido el usuario
            registro = new Medicamento(codigo, nombre, Medicamento.TipoDescripcion.values()[descripcion],
                    laboratorio, proveedor, precio, porcentajeIVA, stock,
                    diaFechaCaducidad, mesFechaCaducidad, anyoFechaCaducidad);

            // Asignamos el objeto con los datos introducidos en el array de 
            // registros
            registros[contador] = registro;
        }

        // Iteramos mostrando los resultados
        for (Medicamento registro : registros) {

            System.out.println("Datos del medicamento " + registro.nombre);
            System.out.println("Código: " + registro.codigo);
            System.out.println("Nombre: " + registro.nombre);
            System.out.println("Descripción: " + registro.descripcion.getString());
            System.out.println("Laboratorio: " + registro.laboratorio);
            System.out.println("Proveedor: " + registro.proveedor);
            System.out.println("Precio: " + registro.precio);
            System.out.println("% IVA: " + registro.porcentajeIVA);
            System.out.println("Stock: " + registro.stock);
            System.out.println("Fecha Caducidad: " + registro.diaFechaCaducidad
                    + "/" + registro.mesFechaCaducidad + "/"
                    + registro.anyoFechaCaducidad);

            // Mostramos el resultado del método toString de la clase
            System.out.println("");
            System.out.println(registro.toString());
        }
    }
}
