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
        // Variable
        String resultado;

        do {
            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.ENTERO));

        // Devolvemos el resultado
        return Integer.valueOf(resultado);
    }

    public static int pedirEnteroRango(String cadena, int valorMinimo, int valorMaximo) {
        // Variable
        String resultado;

        do {
            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.ENTERO)
                || Integer.valueOf(resultado) < valorMinimo
                || Integer.valueOf(resultado) > valorMaximo);

        // Devolvemos el resultado
        return Integer.valueOf(resultado);
    }

    /**
     * Método para pedir y validar la entrada de un entero por parte del usuario
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @return El valor validado introducido por el usuario
     */
    public static int pedirEnteroPositivo(String cadena) {
        // Variable
        String resultado;

        do {
            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.ENTERO_POSITIVO));

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
        // Variable
        String resultado;

        do {
            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.ENTERO_POSITIVO_NO_0));

        // Devolvemos el resultado
        return Integer.valueOf(resultado);
    }

    /**
     * Método para pedir y validar la entrada de un entero por parte del
     * usuario. Permite introducir números con ceros como primer dígito
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @return El valor validado introducido por el usuario
     */
    public static int pedirEnteroPositivoNoCeroExtendido(String cadena) {
        // Variable
        String resultado;

        do {
            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.ENTERO_POSITIVO_NO_0_EXT));

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
        // Variable
        String resultado;

        do {
            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

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
    public static String pedirCadenaNumeroSimbolos(String cadena) {
        // Variable
        String resultado;

        do {
            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.CADENA_NUMEROS_SIMBOLOS));

        // Devolvemos el resultado
        return resultado;
    }    
    
    
    /**
     * Método para pedir y validar la entrada de una cadena por parte del
     * usuario. Solo admite la introducción de letras y del espacio en blanco
     * como caracteres
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @return El valor validado introducido por el usuario
     */
    public static String pedirCadenaSoloLetras(String cadena) {
        // Variable
        String resultado;

        do {

            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.CADENA));

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Método para pedir y validar la entrada de una cadena por parte del
     * usuario. Solo admite la introducción de numeros como caracteres
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @return El valor validado introducido por el usuario
     */
    public static String pedirCadenaSoloNumeros(String cadena) {
        // Variable
        String resultado;

        do {
            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.CADENA_SOLO_NUMEROS));

        // Devolvemos el resultado
        return resultado;
    }
    
    /**
     * Método para pedir y validar la entrada de una cadena por parte del
     * usuario. Solo admite la introducción de numeros como caracteres
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @param longitud Tamaño que tiene que tener el número para ser validado
     * @return El valor validado introducido por el usuario
     */
    public static String pedirCadenaSoloNumeros(String cadena, int longitud) {
        // Variable
        String resultado;

        do {

            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.CADENA_SOLO_NUMEROS)
                || resultado.length() != longitud);

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Método para pedir y validar la entrada de una cadena por parte del
     * usuario. Solo admite la introducción de letras y números
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @return El valor validado introducido por el usuario
     */
    public static String pedirCadenaSoloLetrasNumeros(String cadena) {
        // Variable
        String resultado;

        do {
            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.CADENA_SOLO_LETRAS_NUMEROS));

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
        // Variable
        String resultado;

        do {

            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

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
        // Variable
        String resultado;

        do {

            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido                        
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.REAL_POSITIVO));

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
    public static double pedirRealPositivoNoCero(String cadena) {
        // Variable
        String resultado;

        do {

            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido                        
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.REAL_POSITIVO)
                || resultado.equals("0")
                || resultado.equals("0.0"));

        // Devolvemos el resultado
        return Double.valueOf(resultado.replace(",", "."));
    }

    /**
     * Método para validar una petición de consentimiento para realizar una
     * acción
     *
     * @param cadena Cadena que se mostrará al usuario
     * @param valores Valores que puede tomar la cadena para ser validada
     * @return Verdadero si es un caracter que concuerde con algún valor del
     * array de valores
     */
    public static String pedirConsentimiento(String cadena, String[] valores) {
        // Variable
        String resultado;
        boolean validado = false;

        do {

            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Comprobamos que la cadena contenga alguno de los valores de
            // consentimiento almacenados en el array
            for (String valor : valores) {
                if (resultado.toLowerCase().contains(valor.toLowerCase())) {
                    validado = true;
                    break;
                }
            }

            // Verificamos que solo sea un caracter
            if (resultado.length() > 1) {
                validado = false;
            }

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido                        
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.CADENA) || !validado);

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Método para pedir un DNI al usuario
     *
     * @param cadena Cadena con el mensaje a mostrar al usuario
     * @return DNI validado
     */
    public static String pedirDNI(String cadena) {
        // Variable
        String resultado;

        do {

            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.DNI));

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Método para pedir y validar la entrada de un entero por parte del usuario
     *
     * @param cadena Mensaje que se mostrará el usuario al pedir el valor
     * @return El valor validado introducido por el usuario
     */
    public static String pedirBinario(String cadena) {
        // Variable
        String resultado;

        do {

            // Realizamos una petición de datos la usuario
            resultado = Mensajes.PedirDatos(cadena, "Petición de datos", Mensajes.TipoMensaje.PREGUNTA);

            // Seguimos iteranndo mientras no se valide
            // como correcto el texto introducido
        } while (!Validaciones.validarDato(resultado, Validaciones.TipoValidacion.BINARIO));

        // Devolvemos el resultado
        return resultado;
    }

}
