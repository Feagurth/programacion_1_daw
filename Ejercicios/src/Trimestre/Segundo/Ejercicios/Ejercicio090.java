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

import Utiles.Mensajes;
import java.awt.Dimension;

/**
 * Supongamos que existen N ciudades en la red ferroviaria de un país, y que sus
 * nombres están almacenados en un vector CIUDAD. Diseñar un algoritmo en el que
 * se lea el nombre de cada una de las ciudades y los nombres con los que está
 * enlazada
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio090 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Array para contener el nombre de las ciudades
        String[] arrayNombreCiudades
                = new String[]{"Almeria", "Granada", "Jaen", "Malaga",
                    "Cordoba", "Sevilla", "Cadiz", "Huelva"};

        //              ALM      GRA      JAEN     MALA     COR      SEV     CADIZ     HUEL 
        // Almeria -> {false}, {true},  {false}, {false}, {false}, {false}, {false}, {false};
        // Granada -> {true},  {false}, {true},  {true},  {false}, {false}, {false}, {false};
        // Jaen ->    {false}, {true},  {false}, {false}, {true},  {true},  {false}, {false};
        // Malaga ->  {false}, {true},  {false}, {false}, {true},  {true},  {false}, {false};
        // Cordoba -> {false}, {false}, {true},  {true},  {false}, {true},  {false}, {false};
        // Sevilla -> {false}, {false}, {true},  {true},  {true},  {false}, {true},  {true};
        // Cadiz ->   {false}, {false}, {false}, {false}, {false}, {true},  {false}, {false};  
        // Huelva ->  {false}, {false}, {false}, {false}, {false}, {true},  {false}, {false};
        // Creamos el array que va a contener las conexiones entre provincias
        //  Los valores indican si una provincia tiene conexion con otra
        boolean[][] arrayConexiones = new boolean[][]{
            {false, true, false, false, false, false, false, false},
            {true, false, true, true, false, false, false, false},
            {false, true, false, false, true, true, false, false},
            {false, true, false, false, true, true, false, false},
            {false, false, true, true, false, true, false, false},
            {false, false, true, true, true, false, true, true},
            {false, false, false, false, false, true, false, false},
            {false, false, false, false, false, true, false, false}
        };
        
        StringBuilder cadena;
        String resultado = "";

        // Iteramos el array que contiene el nombre de las ciudades
        // que nos servirá para recorrer la horizontal del array de 
        // conexiones
        for (int i = 0; i < arrayNombreCiudades.length; i++) {

            // Concatenamos los datos de la cabecera, que contiene
            // el nombre de la ciudad y una raya separadora
            resultado += "Ciudad: " + arrayNombreCiudades[i];
            resultado += "\n==================================";

            // Concatenamos el texto enlaza con: y dejamos  la linea lista para
            // imprimir las conexiones con la provincia
            resultado += "\nEnlaza con: ";

            // Reseteamos el valor de la variable cadena
            cadena = new StringBuilder();

            // Iteramos de nuevo por el array de nombres de ciudades
            // para recorrer la vertical del array de conexiones
            for (int j = 0; j < arrayNombreCiudades.length; j++) {

                // Comprobamos si en esa posición el array de conexiones
                // es true, de ser así, hay conexión entre la ciudad
                // arrayNombreCiudades[i] y arrayNombreCiudades[j]
                if (arrayConexiones[i][j]) {
                    // Concatenamos el nombre de la ciudad al acumulador
                    cadena.append(arrayNombreCiudades[j]);
                    cadena.append(", ");
                }
            }

            // Limpiamos los dos últimos caracteres para no tener la 
            // cadena acabada en coma
            //cadena = cadena.substring(0, cadena.length() - 2);
            // Concatenamos la cadena y unos retorno de carro
            resultado += "\n" + cadena.toString().substring(0, cadena.length() - 2) + "\n\n";
        }

        // Mostramos los resultados
        Mensajes.mostrarMensaje(resultado, "Resultado", Mensajes.TipoMensaje.INFORMACION, true, new Dimension(30, 20));
    }
}
