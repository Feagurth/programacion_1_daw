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
 * Supongamos que existen N ciudades en la red ferroviaria de un país, y que sus
 * nombres están almacenados en un vector CIUDAD. Diseñar un algoritmo en el que
 * se lea el nombre de cada una de las ciudades y los nombres con los que está
 * enlazada
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio090 {

    public void Ejercicio() {
        // Objeto para pedir datos al usuario por el teclado
        Scanner entrada = new Scanner(System.in);

        // Variables
        int numCiudades;
        String nombreEnlace;

        // Pedimos datos al usuario
        do {
            System.out.print("Introduzca el número de ciudades: ");
            numCiudades = entrada.nextInt();
        } while (numCiudades <= 0);

        // Creamos un array para almacenar los datos
        String[][] arrayCiudades = new String[numCiudades][2];

        // Pedimos resultados al usuario
        for (String[] arrayCiudad : arrayCiudades) {

            // Creamos de nuevo el objeto scanner
            entrada = new Scanner(System.in);

            // Guardamos el nombre de la ciudad
            System.out.print("Introduzca el nombre de la ciudad: ");
            arrayCiudad[0] = entrada.nextLine();

            // Iniciamos el vector para guardar los enlaces
            arrayCiudad[1] = "";

            // Pedimos al usuario introducir los enlaces de la ciudad
            do {
                System.out.print("Introduzca el nombre de la ciudad con la que enlaza. "
                        + "No introduzca nada para continuar: ");
                nombreEnlace = entrada.nextLine();

                // Si el nombre introducido es distinto de "" lo concatenamos 
                // con un punto y coma que luego nos servirá para 
                // desconcatenarlo
                if (!nombreEnlace.equals("")) {
                    arrayCiudad[1] += nombreEnlace + ";";
                }
            } while (!nombreEnlace.equals(""));

        }

        // Creamos un objeto cadena para ayudarnos a mostrar los datos al 
        // usuario
        String cadena = "";
        
        // Ponemos un retorno de carro
        System.out.println("");

        // Mostramos los resultados
        for (String[] arrayCiudade : arrayCiudades) {

            // Mostramos el nombre de la ciudad
            System.out.println("Nombre: " + arrayCiudade[0]);

            // Convertimos la cadena de ciudades enlazadas en un array con la
            // función split usando los puntos y coma como valor de corte
            String[] enlaces = arrayCiudade[1].split(";");

            // Mostramos el encabezamiento de la linea
            System.out.print("Enlaza con: ");

            // Construimos el resto
            for (String enlace : enlaces) {
                cadena += enlace + ", ";
            }

            // Quitamos los dos últimos caracteres para que no salga una 
            // coma de más
            cadena = cadena.substring(0, cadena.length() - 2);

            // Mostramos el resultado
            System.out.print(cadena);

            // Ponemos un retorno de carro
            System.out.println("");
        }

    }

}
