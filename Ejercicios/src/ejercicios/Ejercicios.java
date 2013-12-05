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

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicios {

    /**
     * @param args argumentos por linea de comandos
     */
    public static void main(String[] args) {
        
        // Objeto para mostrar y pedir información al usuario
        Mensajes msg = new Mensajes();
        
        //Variables
        String mensaje;
        int opcion = 0;
        
        mensaje = "Introduzca el número del ejercicio que quiere ejecutar\n";
        mensaje += "-----------------------------------------------------------------------------\n";               
        mensaje += "1.- Ejercicio 48\n";
        mensaje += "2.- Ejercicio 58\n";
        mensaje += "3.- Ejercicio 62\n";             
        mensaje += "4.- Ejercicio 99\n";             
        mensaje += "5.- Ejercicio de clase 8\n";   
        mensaje += "6.- Salir\n";   
        
        
        do {            
            opcion = Integer.parseInt(msg.PedirDatos(mensaje, "Petición de Datos", 
                    Mensajes.TipoMensaje.PREGUNTA));
        } while (opcion <= 0 || opcion >= 7);

        switch(opcion)
        {
            case 1:
                Ejercicio048 ej048 = new Ejercicio048();
                
                mensaje = "Algoritmo que reciba una fecha por teclado dd, mm, aaaa, así como el día de \n" +
                "la semana que fue el primero de enero de dicho año, y muestre por pantalla \n" +
                "el día de la semana que corresponde a la fecha que le hemos dado. En \n" +
                "la resolución deben considerarse los años bisiestos.\n" +
                "Se resolverá usando la congruencia de Zeller.";
                
                msg.MostrarMensaje(mensaje, "Info Ejercicio", Mensajes.TipoMensaje.INFORMACION);
                
                ej048.ejercicio();;
                break;
            case 2:
                Ejercicio058 ej058 = new Ejercicio058();
                
                mensaje = "* Desarrollar un algoritmo que calcule la potencia de n de un numero suponiendo\n" +
                "que no tenemos la función primitiva para calcular potencia. Usa programación \n" +
                "modular.\n" +
                "Tener en cuenta que 0^0 es una indeterminación, que x^0 es 1 0^y es 0 y \n" +
                "si y< 0 → x ^-y = 1/ x^y y si x = 0 e y < 0 que da indeterminación";
                
                msg.MostrarMensaje(mensaje, "Info Ejercicio", Mensajes.TipoMensaje.INFORMACION);
                
                ej058.ejercicio();;
                break;
            case 3:
                Ejercicio062 ej062 = new Ejercicio062();
                
                mensaje = "Realizar un algoritmo para realizar combinatorias ordinarias";
                
                msg.MostrarMensaje(mensaje, "Info Ejercicio", Mensajes.TipoMensaje.INFORMACION);
                
                ej062.ejercicio();
                break;
            case 4:
                Ejercicio099 ej099 = new Ejercicio099();
                
                mensaje = "Una fábrica de muebles tiene 16 representantes que viajan por toda España \n" +
                "ofreciendo sus productos. Para tareas administrativas el país está dividido \n" +
                "en cinco zonas: Norte, Sur, Este, Oeste y Centro. Mensualmente almacena \n" +
                "sus datos y obtiene distintas estadísticas sobre el comportamiento de sus \n" +
                "representantes en cada zona. Se desea hacer un programa que lea los datos \n" +
                "de todos los representantes con sus ventas en cada zona y calcule el total \n" +
                "de ventas de una zona introducida por teclado, el total de ventas de un \n" +
                "vendedor introducido por teclado en cada una de las zonas y el total de \n" +
                "ventas de un día y para cada uno de los representantes.";
                
                msg.MostrarMensaje(mensaje, "Info Ejercicio", Mensajes.TipoMensaje.INFORMACION);
                
                ej099.ejercicio();;
                break;
            case 5:
                EjercicioDeClase008 ejdc008 = new EjercicioDeClase008();
                
                mensaje = "Crear un algoritmo para calcule el área y el volumen de poliedros. \n" +
                "Usar un sistema de menús.";
                
                msg.MostrarMensaje(mensaje, "Info Ejercicio", Mensajes.TipoMensaje.INFORMACION);
                
                ejdc008.ejercicio();
                break;
        }               
    }    
}
