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

/**
 * Supongamos que existen N ciudades en la red ferroviaria de un país, y que sus
 * nombres están almacenados en un vector CIUDAD. Diseñar un algoritmo en el que
 * se lea el nombre de cada una de las ciudades y los nombres con los que está
 * enlazada
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio008 {

    public void Ejercicio() {
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

        String cadena;

        // Iteramos el array que contiene el nombre de las ciudades
        // que nos servirá para recorrer la horizontal del array de 
        // conexiones
        for (int i = 0; i < arrayNombreCiudades.length; i++) {

            // Mostramos los datos de la cabecera, que contiene
            // el nombre de la ciudad y una raya separadora
            System.out.println("");
            System.out.println("Ciudad: " + arrayNombreCiudades[i]);
            System.out.println("==================================");
            
            // Imprimimos el texto enlaza con: y dejamos  la linea lista para
            // imprimir las conexiones con la provincia
            System.out.print("Enlaza con: ");

            // Reseteamos el valor de la variable cadena
            cadena = "";

            // Iteramos de nuevo por el array de nombres de ciudades
            // para recorrer la vertical del array de conexiones
            for (int j = 0; j < arrayNombreCiudades.length; j++) {

                // Comprobamos si en esa posición el array de conexiones
                // es true, de ser así, hay conexión entre la ciudad
                // arrayNombreCiudades[i] y arrayNombreCiudades[j]
                if (arrayConexiones[i][j]) {
                    // Concatenamos el nombre de la ciudad al acumulador
                    cadena += arrayNombreCiudades[j] + ", ";
                }
            }

            // Limpiamos los dos últimos caracteres para no tener la 
            // cadena acabada en coma
            cadena = cadena.substring(0, cadena.length() - 2);

            // Imprimimos la cadena y un retorno de carro
            System.out.print(cadena);
            System.out.println("");
        }
    }
}
