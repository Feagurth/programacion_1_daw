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
package Utiles;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Varios {

    /**
     * Función para transformar una fecha en numeros en formato DDMMAAAA
     *
     * @param dia El dia del mes
     * @param mes El mes del año
     * @param anyo El año
     * @param separador El separador de dígitos
     * @return
     */
    public static String fechaDDMMAAAA(int dia, int mes, int anyo, String separador) {
        String resultado;

        resultado = (dia < 10 ? "0" : "") + dia
                + separador
                + (mes < 10 ? "0" : "") + mes
                + separador
                + anyo;

        return resultado;
    }

    /**
     * Función que nos permite generar una serie de caracteres para ayudar a la
     * maquetación de los resultados
     *
     * @param caracter Carácter con el que se va a generar la cadena
     * @param cantidad Cantidad de espacios a ocupar
     * @param valorCadena Cantidad de espacios ya ocupados
     * @return Devuelve una cadena de caracteres cuya longitud es la cantidad
     * menos la longitud de valorCadena
     */
    public static String generarCadena(String caracter, int cantidad, String valorCadena) {
        StringBuilder buf = new StringBuilder();
        
        // Generamos una cadena con tantos caracteres repetidos como 
        // cantidad necesitemos menos la longitud del texto que vamos a 
        // introducir
        for (int i = 0; i < cantidad - valorCadena.length(); i++) {
            buf.append(caracter);
        }

        return buf.toString();
    }

}
