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
package RelacionesDeEjercicios.Relacion2;

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * Una compañía desea transmitir datos a través del teléfono, pero le preocupa
 * que sus teléfonos puedan estar intervenidos. Te ha pedido que escribas un
 * programa que cifre los datos, de manera que éstos puedan transmitirse con más
 * seguridad. Todos los datos se transmiten como enteros de cuatro dígitos 
 *      a) La aplicación debe leer un entero de cuatro dígitos introducido por el
 *      usuario y cifrarlo de la siguiente manera: 
 *          i) Reemplazar cada dígito con el resultado de sumar 7 al dígito y 
 *          obtener el residuo después de dividir el nuevo valor entre 10 
 *          ii) Luego intercambia el primer dígito con el tercero, intercambia 
 *          el segundo dígito con el cuarto. b) Simular un canal de transmisión 
 *          de información con el procedimiento de cifrado, es decir: 
 *              i) En el origen: 
 *                  (1) Se lee el número a transmitir 
 *                  (2) Se cifra 
 *              ii) En el destino:
 *                  (1) Se descifra 
 *                  (2) Se imprime
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio003 {

    public void Ejercicio() {
        // Variable para almacenar los datos introducidos por el usuario
        String numero;

        // Petición de datos al usuario
        numero = PeticionDatos.pedirCadenaSoloNumeros("Introduzca un entero de 4 digitos", 4);

        // Codificamos el valor
        numero = codificar(numero);

        // Mostramos en número codificado
        Mensajes.MostrarMensaje("El valor codificado es: " + numero, 
                Mensajes.TipoMensaje.INFORMACION);

        // Descodificamos el numero codificado
        numero = decodificar(numero);

        // Mostramos el número descodificado
        Mensajes.MostrarMensaje("El valor descodificado es: " + numero, 
                Mensajes.TipoMensaje.INFORMACION);
    }

    /**
     * Función para decodificar un valor numérico como una cadena
     *
     * @param valorNumero valor numérico a codificar
     * @return Cadena codificada
     */
    private String codificar(String valorNumero) {
        StringBuilder apoyo = new StringBuilder();

        // Calculamos los nuevos valores para la cadena
        apoyo.append((((Character.getNumericValue(valorNumero.charAt(0))) + 7) % 10));
        apoyo.append((((Character.getNumericValue(valorNumero.charAt(1))) + 7) % 10));
        apoyo.append((((Character.getNumericValue(valorNumero.charAt(2))) + 7) % 10));
        apoyo.append((((Character.getNumericValue(valorNumero.charAt(3))) + 7) % 10));

        // Itencambiamos los valores
        char apoyo1 = apoyo.charAt(0);

        // El primero con el tercero
        apoyo.setCharAt(0, apoyo.charAt(2));
        apoyo.setCharAt(2, apoyo1);

        apoyo1 = apoyo.charAt(1);

        // El segundo con el cuarto
        apoyo.setCharAt(1, apoyo.charAt(3));
        apoyo.setCharAt(3, apoyo1);

        // Devolvemos el resultado
        return apoyo.toString();
    }

    /**
     * Función para decodificar un valor numérico codificado a su valor original
     *
     * @param valorNumero valor numérico a descodificar
     * @return Valor descodificado
     */
    private String decodificar(String valorNumero) {
        StringBuilder apoyo = new StringBuilder(valorNumero);

        // Intercambiamos valores
        char apoyo1 = apoyo.charAt(2);

        // El tercero con el primero
        apoyo.setCharAt(2, apoyo.charAt(0));
        apoyo.setCharAt(0, apoyo1);

        apoyo1 = apoyo.charAt(3);

        // El cuarto con el segundo
        apoyo.setCharAt(3, apoyo.charAt(1));
        apoyo.setCharAt(1, apoyo1);

        // Creamos la cadena descodificada
        StringBuilder apoyo2 = new StringBuilder();

        // Si el número a descodificar es menos de 7, le sumanos 10, si no, 
        // lo dejamos como está y finalmente le restamos 7 para conseguir el
        // digito sin codificar        
        apoyo2.append((Character.getNumericValue(apoyo.charAt(0)) < 7
                ? Character.getNumericValue(apoyo.charAt(0)) + 10
                : Character.getNumericValue(apoyo.charAt(0))) - 7);

        apoyo2.append((Character.getNumericValue(apoyo.charAt(1)) < 7
                ? Character.getNumericValue(apoyo.charAt(1)) + 10
                : Character.getNumericValue(apoyo.charAt(1))) - 7);

        apoyo2.append((Character.getNumericValue(apoyo.charAt(2)) < 7
                ? Character.getNumericValue(apoyo.charAt(2)) + 10
                : Character.getNumericValue(apoyo.charAt(2))) - 7);

        apoyo2.append((Character.getNumericValue(apoyo.charAt(3)) < 7
                ? Character.getNumericValue(apoyo.charAt(3)) + 10
                : Character.getNumericValue(apoyo.charAt(3))) - 7);

        // Devolvemos la cadena sin codificar
        return apoyo2.toString();
    }
}
