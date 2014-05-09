/*
 * Copyright (C) 2014 Luis Cabrerizo Gómez
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package Trimestre.Tercero.Ejercicios;

import Utiles.Mensajes;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Ejercicio realizado en clase para la lectura de ficheros. Se creará un menú
 * con distintas opciones que permitirán la lectura del fichero y la muestra en
 * pantalla de los datos especificados mediante el menú.
 *
 * @author Luis Cabrerizo Gómez
 */
public class EjercicioDeClase005 {

    /**
     * Enumerador para las opciones del menú
     */
    public enum OpcionMenu {

        /**
         * Opción para el saldo cero
         */
        SALDO_CERO(1),
        /**
         * Opción para el saldo menor que cero
         */
        SALDO_CREDITO(2),
        /**
         * Opción para el saldo mayor que cero
         */
        SALDO_DEBITO(3),
        /**
         * Opción para salir
         */
        FIN(4);

        private final int valor;

        /**
         * Constructor del enumerador
         *
         * @param valor Valor del enumerador
         */
        OpcionMenu(int valor) {
            this.valor = valor;
        }

        /**
         * Método para recuperar el valor del enumerador
         *
         * @return El valor del enumerador
         */
        public int getValor() {
            return valor;
        }
    }

    /**
     * Clase para leer los datos de un fichero específico
     */
    public class RegistroCuenta {

        // Variables de instancia
        private int cuenta;
        private String nombre;
        private String apellido;
        private double saldo;

        /**
         * Método para recuperar el valor de la cuenta
         *
         * @return Valor de la cuenta
         */
        public int getCuenta() {
            return cuenta;
        }

        /**
         * Método para asignar el valor de la cuenta
         *
         * @param cuenta Valor de la cuenta
         */
        public void setCuenta(int cuenta) {
            this.cuenta = cuenta;
        }

        /**
         * Método para recuperar el nombre
         *
         * @return El valor del nombre
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Método pare asignar el valor del nombre
         *
         * @param nombre El valor del nombre
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        /**
         * Método para recuperar el apellido
         *
         * @return El apellido
         */
        public String getApellido() {
            return apellido;
        }

        /**
         * Método para asignar el apellido
         *
         * @param apellido El valor del apellido
         */
        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        /**
         * Método para recuperar el saldo
         *
         * @return El saldo
         */
        public double getSaldo() {
            return saldo;
        }

        /**
         * Método para asignar el valor del saldo
         *
         * @param saldo El valor del saldo
         */
        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }

        /**
         * Constructor la clase con todos las variables de instancia
         * inicializadas a valores por defecto
         */
        public RegistroCuenta() {
            this(0, "", "", 0.0f);
        }

        /**
         * Constructor de la clase
         *
         * @param cuenta Valor de la cuenta
         * @param nombre Valor del nombre
         * @param apellido Valor del apellido
         * @param saldo Valor del saldo
         */
        public RegistroCuenta(int cuenta, String nombre, String apellido, double saldo) {
            this.cuenta = cuenta;
            this.nombre = nombre;
            this.apellido = apellido;
            this.saldo = saldo;
        }

    }

    /**
     * Clase para leer los datos de un fichero de créditos con estructura
     * específica
     */
    public class ConsultaCredito {

        private Scanner entrada;

        /**
         * Método para abrir un fichero
         */
        public void abrirArchivo() {
            try {

                // Creamos un nuevo objecto Scanner con el que leeremos
                // el fichero, el cual está referenciado enel constructor
                // con un objeto File
                entrada = new Scanner(new File("clientes.txt"));

            } // Captura de excepciones
            catch (FileNotFoundException fileNotFoundException) {
                System.err.println("Error al abrir el archivo");
                System.exit(1);
            }
        }

        /**
         * Método para leer registros de un fichero con estructura definida y
         * devolver los datos correspondientes
         *
         * @param tipoLectura Valor que define los datos a devolver dependiendo
         * de su saldo
         * @return Los datos de la cuenta que correspondan con el tipo de
         * lectura
         */
        public String leerRegistros(OpcionMenu tipoLectura) {

            // Creamos un objeto de la clase RegistroCuenta para leer los datos
            // del fichero, los cuales están almacenados con el mismo formato
            RegistroCuenta registro = new RegistroCuenta();

            // Inicializamos la variable que va a devolver los resultados
            String cadena = "";

            // Creamos una variable para verificar cuando los datos leidos van
            // a ser concatenados a la cadena de salida o no.
            boolean concatena;

            try {
                // Iteramos leyendo el fichero mientras haya registros que leer
                while (entrada.hasNext()) {

                    // Ponemos la variable de control a falso
                    concatena = false;

                    // Asignamos al objeto los valores leidos del fichero
                    registro.setCuenta(entrada.nextInt());
                    registro.setNombre(entrada.next());
                    registro.setApellido(entrada.next());
                    registro.setSaldo(entrada.nextDouble());

                    // Comprobamos el tipo de lectura y verificamos si los datos
                    // leidos serán concatenados para devolverlos como salida
                    // de la función
                    switch (tipoLectura) {
                        case SALDO_CERO: {
                            if (registro.getSaldo() == 0) {
                                concatena = true;
                            }
                            break;
                        }
                        case SALDO_CREDITO: {
                            if (registro.getSaldo() < 0) {
                                concatena = true;
                            }
                            break;
                        }
                        case SALDO_DEBITO: {
                            if (registro.getSaldo() > 0) {
                                concatena = true;
                            }
                            break;
                        }
                    }

                    // Concatenamos si fuese necesario
                    if (concatena) {
                        cadena = cadena.concat(String.format("Nº Cuenta: %d%nNombre: %s%nApellidos: %s%nSaldo: %.2f",
                                registro.getCuenta(),
                                registro.getNombre(),
                                registro.getApellido(),
                                registro.getSaldo()));

                        cadena = cadena.concat("\n");
                        cadena = cadena.concat("\n");
                    }
                }

            } // Captura de excepciones
            catch (IllegalStateException illegalStateException) {
                System.err.println("No se ha podido leer el fichero");
                System.exit(1);
            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("El archivo no está bien formado");
                System.exit(1);
            }

            // Devolvemos el resultado generado
            return cadena;
        }

        /**
         * Método para cerrar el archivo una vez finalizada la lectura del mismo
         */
        public void cerrarArchivo() {
            entrada.close();

        }
    }

    /**
     * Método principal de la clase EjercicioDeClase005
     */
    public void ejercicio() {

        int operacion;

        // Creamos un nuevo objeto ConsultaDeCredito
        ConsultaCredito fichero = new ConsultaCredito();

        // Iteramos mientras el usuario no diga lo contrario
        do {
            // Mostramos el menú y guardamos la selección del usuario
            operacion = Mensajes.mostrarMenu("Seleccione una opción", "Menú", 
                    Mensajes.TipoMensaje.PLANO, 
                    new String[]{"Cuentas con saldo cero", 
                                 "Cuentas con saldo credito", 
                                 "Cuentas con saldo débito", 
                                 "Salir"});

            // Realizamos las operaciones seleccionadas por el usuario
            switch (operacion) {
                case 0: {
                    // Abrimos el fichero
                    fichero.abrirArchivo();
                    // Leemos y mostramos los registros con saldo cero
                    Mensajes.mostrarMensaje(fichero.leerRegistros(OpcionMenu.SALDO_CERO), "Resultados", Mensajes.TipoMensaje.INFORMACION, true, new Dimension(10, 10));
                    // Cerramos el fichero
                    fichero.cerrarArchivo();
                    break;
                }
                case 1: {
                    // Abrimos el fichero
                    fichero.abrirArchivo();
                    // Leemos y mostramos los registros con saldo negativo
                    Mensajes.mostrarMensaje(fichero.leerRegistros(OpcionMenu.SALDO_CREDITO), "Resultados", Mensajes.TipoMensaje.INFORMACION, true, new Dimension(10, 10));
                    // Cerramos el fichero
                    fichero.cerrarArchivo();
                    break;
                }
                case 2: {
                    // Abrimos el fichero
                    fichero.abrirArchivo();
                    // Leemos y mostramos los registros con saldo positivo
                    Mensajes.mostrarMensaje(fichero.leerRegistros(OpcionMenu.SALDO_DEBITO), "Resultados", Mensajes.TipoMensaje.INFORMACION, true, new Dimension(10, 10));
                    // Cerramos el fichero
                    fichero.cerrarArchivo();
                    break;
                }
            }

        } while (operacion != 3);
    }
}
