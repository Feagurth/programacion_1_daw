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
package Utiles;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase de ayuda para peticiones y muestra de datos con ventanas
 *
 * @author Luis Cabrerizo Gómez
 */
public class Mensajes {

    /**
     * Enumerador para contener los tipos de mensajes a mostrar
     */
    public enum TipoMensaje {

        /**
         * Valor para error
         */
        ERROR, 
        /**
         * Valor para información
         */
        INFORMACION, 
        /**
         * Valor para aviso
         */
        AVISO, 
        /**
         * Valor para pregunta
         */
        PREGUNTA, 
        /**
         * Valor para aviso plano
         */
        PLANO
    }

    /**
     * Función para parsear los datos de TipoMensaje a entero
     *
     * @param valor Tipo de mensaje a parsear
     * @return valor entero resultante del parseo
     */
    private static int parseTipoMensaje(TipoMensaje valor) {
        int resultado = -1;

        switch (valor) {

            case ERROR:
                resultado = 0;
                break;
            case INFORMACION:
                resultado = 1;
                break;
            case AVISO:
                resultado = 2;
                break;
            case PREGUNTA:
                resultado = 3;
                break;
            case PLANO:
                resultado = -1;
                break;
        }

        return resultado;

    }

    /**
     * Función para mostrar información al usuario
     *
     * @param mensaje Mensaje que se le muestra al usuario
     * @param titulo Título de la ventana
     * @param tipoMensaje Tipo de mensaje que se mostrará
     * @param newTextArea Permite indicar si se creará un JTextArea al crear el
     * mensaje
     */
    public static void mostrarMensaje(String mensaje, String titulo, TipoMensaje tipoMensaje, boolean newTextArea) {
        if (!newTextArea) {
            JOptionPane.showMessageDialog(null, mensaje, titulo,
                    parseTipoMensaje(tipoMensaje));
        } else {

            // Creamos una nueva area de texto para el mensaje
            JTextArea area = new JTextArea();

            // Hacemos que no sea editable
            area.setEditable(false);
           
            area.setFont(new Font("Courier", Font.PLAIN, 12));

            // Le introducimos el texto
            area.setText(mensaje);

            // La mostramos
            JOptionPane.showMessageDialog(null, area, titulo,
                    parseTipoMensaje(tipoMensaje));
        }
    }

    /**
     * Función para mostrar información al usuario
     *
     * @param mensaje Mensaje que se le muestra al usuario
     * @param titulo Título de la ventana
     * @param tipoMensaje Tipo de mensaje que se mostrará
     * @param newTextArea Permite indicar si se creará un JTextArea al crear el
     * @param tamanyoMaximo  Permite especificar el tamaño máximo de la ventana en filas y columnas
     * mensaje
     */
    public static void mostrarMensaje(String mensaje, String titulo, TipoMensaje tipoMensaje, boolean newTextArea, Dimension tamanyoMaximo) {
        if (!newTextArea) {
            JOptionPane.showMessageDialog(null, mensaje, titulo,
                    parseTipoMensaje(tipoMensaje));
        } else {

            // Creamos una nueva area de texto para el mensaje
            JTextArea area = new JTextArea();

            // Hacemos que no sea editable
            area.setEditable(false);

            // Cambiamos la fuente
            area.setFont(new Font("Courier", Font.PLAIN, 12));

            // Le introducimos el texto
            area.setText(mensaje);

            if (tamanyoMaximo != null) {

                area.setColumns(tamanyoMaximo.width);
                area.setRows(tamanyoMaximo.height);
                
                // wrap a scrollpane around it
                JScrollPane scrollPane = new JScrollPane(area);

                // display them in a message dialog
                JOptionPane.showMessageDialog(null, scrollPane, titulo, parseTipoMensaje(tipoMensaje));

            } else {
                // La mostramos
                JOptionPane.showMessageDialog(null, area, titulo,
                        parseTipoMensaje(tipoMensaje));
            }
        }
    }

    /**
     * Función para mostrar información al usuario
     *
     * @param mensaje Mensaje que se le muestra al usuario
     * @param titulo Título de la ventana
     * @param tipoMensaje Tipo de mensaje que se mostrará
     */
    public static void mostrarMensaje(String mensaje, String titulo, TipoMensaje tipoMensaje) {
        mostrarMensaje(mensaje, titulo, tipoMensaje, false);
    }

    /**
     * Función para mostrar información al usuario
     *
     * @param mensaje Mensaje que se le muestra al usuario
     * @param tipoMensaje Tipo de mensaje que se mostrará
     */
    public static void mostrarMensaje(String mensaje, TipoMensaje tipoMensaje) {

        String titulo;

        switch (tipoMensaje) {
            case INFORMACION:
                titulo = "Información";
                break;
            case AVISO:
                titulo = "Atención!";
                break;
            case ERROR:
                titulo = "Error!";
                break;
            case PREGUNTA:
                titulo = "Petición de Datos";
                break;
            default:
                titulo = "";
                break;
        }

        mostrarMensaje(mensaje, titulo, tipoMensaje, false);
    }

    /**
     * Función para pedir datos al usuario
     *
     * @param mensaje Mensaje que se le muestra al usuario
     * @param titulo Título de la ventana
     * @param tipoMensaje Tipo de mensaje que se mostrará
     * @return Datos introducidos por el usuario
     */
    @Deprecated
    public static String pedirDatos(String mensaje, String titulo, TipoMensaje tipoMensaje) {
        String cadena;

        do {
            cadena = JOptionPane.showInputDialog(null, mensaje, titulo,
                    parseTipoMensaje(tipoMensaje));

        } while (cadena == null);

        return cadena;
    }

    /**
     * Función para pedir datos al usuario. Genera títulos automáticos
     * dependiendo del tipo de mensaje
     *
     * @param mensaje Mensaje que se le muestra al usuario
     * @param tipoMensaje Tipo de mensaje que se mostrará
     * @return Datos introducidos por el usuario
     */
    public static String pedirDatos(String mensaje, TipoMensaje tipoMensaje) {
        String titulo;

        switch (tipoMensaje) {
            case INFORMACION:
                titulo = "Información";
                break;
            case AVISO:
                titulo = "Atención!";
                break;
            case ERROR:
                titulo = "Error!";
                break;
            case PREGUNTA:
                titulo = "Petición de Datos";
                break;
            default:
                titulo = "";
                break;
        }

        return pedirDatos(mensaje, titulo, tipoMensaje);
    }

}
