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

import java.util.Scanner;

/**
 * Clase para la petición y validación y control de datos al usuario
 *
 * @author Luis Cabrerizo Gómez
 */
public class PeticionDatos {

    /**
     * Método para pedir y validar la entrada de un entero por parte del usuario
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @return El valor validado introducido por el usuario
     */
    public static int pedirEntero(String cadena) {
        // Objeto para pedir valores al usuario
        Scanner entrada = new Scanner(System.in);

        // Variable
        String resultado;

        do {
            // Mostramos el mensaje especificado al usuario
            System.out.print(cadena + ": ");

            // Recogemos lo introducido por el usuario
            resultado = entrada.nextLine();

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.ENTERO));

        // Devolvemos el resultado
        return Integer.valueOf(resultado);
    }
    
    /**
     * Método para pedir y validar la entrada de un entero por parte del usuario
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @return El valor validado introducido por el usuario
     */
    public static int pedirEnteroPositivoNoCero(String cadena) {
        // Objeto para pedir valores al usuario
        Scanner entrada = new Scanner(System.in);

        // Variable
        String resultado;

        do {
            // Mostramos el mensaje especificado al usuario
            System.out.print(cadena + ": ");

            // Recogemos lo introducido por el usuario
            resultado = entrada.nextLine();

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.ENTERO_POSITIVO_NO_0));

        // Devolvemos el resultado
        return Integer.valueOf(resultado);
    }    

    /**
     * Método para pedir y validar la entrada de una cadena por parte del
     * usuario
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @return El valor validado introducido por el usuario
     */
    public static String pedirCadena(String cadena) {
        // Objeto para pedir valores al usuario
        Scanner entrada = new Scanner(System.in);

        // Variable
        String resultado;

        do {
            // Mostramos el mensaje especificado al usuario
            System.out.print(cadena + ": ");

            // Recogemos lo introducido por el usuario
            resultado = entrada.nextLine();

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.CADENA_NUMEROS));
        
        // Devolvemos el resultado
        return resultado;
    }
    
    /**
     * Método para pedir y validar la entrada de una cadena por parte del
     * usuario
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @return El valor validado introducido por el usuario
     */
    public static String pedirCadenaSoloLetras(String cadena) {
        // Objeto para pedir valores al usuario
        Scanner entrada = new Scanner(System.in);

        // Variable
        String resultado;

        do {
            // Mostramos el mensaje especificado al usuario
            System.out.print(cadena + ": ");

            // Recogemos lo introducido por el usuario
            resultado = entrada.nextLine();

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.CADENA));
        
        // Devolvemos el resultado
        return resultado;
    }    

    /**
     * Método para pedir y validar la entrada de un real por parte del usuario
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @return El valor validado introducido por el usuario
     */
    public static double pedirReal(String cadena) {
        // Objeto para pedir valores al usuario
        Scanner entrada = new Scanner(System.in);

        // Variable
        String resultado;

        do {
            // Mostramos el mensaje especificado al usuario
            System.out.print(cadena + ": ");
            
            // Recogemos lo introducido por el usuario
            resultado = entrada.nextLine();
            
            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido            
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.REAL));

        // Devolvemos el resultado
        return Double.valueOf(resultado.replace(",", "."));
    }

    /**
     * Método para pedir y validar la entrada de un real positivo por parte del
     * usuario
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @return El valor validado introducido por el usuario
     */
    public static double pedirRealPositivo(String cadena) {
        // Objeto para pedir valores al usuario
        Scanner entrada = new Scanner(System.in);

        // Variable
        String resultado;

        do {
            // Mostramos el mensaje especificado al usuario
            System.out.print(cadena + ": ");
            
            // Recogemos lo introducido por el usuario
            resultado = entrada.nextLine();
            
            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido                        
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.REAL_POSITIVO));

        // Devolvemos el resultado
        return Double.valueOf(resultado.replace(",", "."));
    }
}
