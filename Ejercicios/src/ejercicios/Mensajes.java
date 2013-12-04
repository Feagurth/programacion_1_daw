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

package ejercicios;

import javax.swing.JOptionPane;

/**
 * Clase de ayuda para peticiones y muestra de datos con ventanas
 * @author Luis Cabrerizo Gómez
 */
public class Mensajes {

    /**
     * Enumerador para contener los tipos de mensajes a mostrar
     */
    public enum TipoMensaje{
        ERROR, INFORMACION, AVISO, PREGUNTA, PLANO
    }
    
    
    /**
     * Función para parsear los datos de TipoMensaje a entero
     * @param valor Tipo de mensaje a parsear
     * @return valor entero resultante del parseo
     */
    private int parseTipoMensaje(TipoMensaje valor){
        int resultado = -1;
        
        switch(valor){
            
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
     * @param mensaje Mensaje que se le muestra al usuario
     * @param titulo Título de la ventana
     * @param tipoMensaje Tipo de mensaje que se mostrará
     */
    public void MostrarMensaje(String mensaje, String titulo, TipoMensaje tipoMensaje ){
        JOptionPane.showMessageDialog(null, mensaje, titulo, 
                parseTipoMensaje(tipoMensaje));
    }

    /**
     * Función para pedir datos al usuario
     * @param mensaje Mensaje que se le muestra al usuario
     * @param titulo Título de la ventana
     * @param tipoMensaje Tipo de mensaje que se mostrará
     * @return Datos introducidos por el usuario
     */
    public String PedirDatos(String mensaje, String titulo, TipoMensaje tipoMensaje){
        String cadena;
        do
        {
            cadena = JOptionPane.showInputDialog(null, mensaje, titulo, 
                parseTipoMensaje(tipoMensaje));
        
        }while(cadena == null);
        
        return cadena;
        
    }
}
