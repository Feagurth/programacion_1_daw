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

package Trimestre.Primero.Ejercicios;

import Utiles.Mensajes;

/**
 * Analizar los distintos métodos de realizar la suma de T números introducidos 
 * por teclado (desde, mientras, repetir)
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio037 {

    /**
     * Ejercicio principal
     */
    public void ejercicio(){
        // Variables
        int opcion;
        String mensaje;
        
        mensaje = "Introduzca su selección\n";
        mensaje += "1.- Bucle for\n";
        mensaje += "2.- Bucle while\n";
        mensaje += "3.- Bucle do while\n";
        mensaje += "4.- Salir";
        
        
        // Iteración hasta que se cumpla la condición de salida
        do
        {
            // Petición de datos
            opcion = Integer.parseInt(Mensajes.pedirDatos(mensaje, 
                    "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
            
            // Se realiza un método u otro dependiendo de la opción elegida
            switch(opcion)
            {
                case 1:
                    ejercicio_desde();
                    break;
                case 2:
                    ejercicio_mientras();
                    break;                    
                case 3:
                    ejercicio_repetir();
                    break;                    
            }
        }while(opcion != 4);
    
    }    
    
    /**
     * Ejercicio con bucle for
     */
    private void ejercicio_desde(){

        // Variables
        int suma = 0, numero;
        
        // Petición de datos
        numero = Integer.parseInt(Mensajes.pedirDatos("Introduzca un número", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        // Iteramos
        for (int i = 1; i <= numero; i++) {
            suma += i;
        }
    
        // Muestra de resultados
        Mensajes.mostrarMensaje("La suma es: " + suma, 
                "Resultados", Mensajes.TipoMensaje.INFORMACION);
    }
    
    /**
     * Ejercicio con bucle while
     */
    private void ejercicio_mientras(){

        // Variables
        int suma = 0, numero, contador= 1;
        
        // Petición de datos
        numero = Integer.parseInt(Mensajes.pedirDatos("Introduzca un número", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        // Iteramos
        while (contador <= numero) {   
            suma += contador;
            contador++;
        }
    
        // Muestra de resultados
        Mensajes.mostrarMensaje("La suma es: " + suma, 
                "Resultados", Mensajes.TipoMensaje.INFORMACION);
    }    
    
    /**
     * Ejercicio con bucle do while
     */
    private void ejercicio_repetir(){

        // Variables
        int suma = 0, numero, contador = 0;
        
        // Petición de datos
        numero = Integer.parseInt(Mensajes.pedirDatos("Introduzca un número", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        // Iteramos
        do{            
            contador++;
            suma += contador;
        }while(contador != numero);
    
        // Muestra de resultados
        Mensajes.mostrarMensaje("La suma es: " + suma, 
                "Resultados", Mensajes.TipoMensaje.INFORMACION);
    }           
}
