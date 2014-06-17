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
package utiles;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * Clase para encriptación de datos
 *
 * @author Luis Cabrerizo Gómez
 */
public class Encriptacion {

    private static SecretKeySpec secretKey;

    /**
     * Método que nos permite asignar la contraseña de encriptación y
     * desencriptación al objeto
     *
     * @param password Contraseña de encriptación
     * @throws UnsupportedEncodingException Excepción para el caso en que no
     * esté soportada la codificación
     * @throws NoSuchAlgorithmException Excepción para el caso en que no exista
     * el algoritmo de encriptación
     */
    public static void setKey(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        // Definimos una clave de encriptación a partir de la cadena pasada
        // al objeto
        byte[] key = password.getBytes("UTF-8");

        // Creamos un compendio de mensajes para aumentar el tamaño de la clave
        // y generar un hash de la contraseña introducida, de donde sacaremos
        // la clave real de encriptación
        MessageDigest sha = MessageDigest.getInstance("SHA-1");

        // Generamos la clave nueva a partir del hash
        key = sha.digest(key);

        // Cogemos los primeros 16 bytes, o 128 bits, como clave de la encriptación
        key = Arrays.copyOf(key, 16);

        // Creamos finalmente la clave de encriptación con encriptación AES
        secretKey = new SecretKeySpec(key, "AES");
    }

    /**
     * Función para encriptar un texto
     *
     * @param texto Texto a encriptar
     * @return Una cadena encriptada
     * @throws IllegalBlockSizeException Excepción para cuando el bloque de
     * encriptación tiene un tamaño distinto
     * @throws BadPaddingException Excepción para cuando la encriptación no
     * tiene los rellenos correctos
     * @throws UnsupportedEncodingException Excepción para cuando la
     * codificación no está soportada por el sistema
     * @throws InvalidKeyException Excepción para cuando la clave de
     * encriptación no es válida
     * @throws NoSuchAlgorithmException Excepción para cuando no existe el
     * algoritmo de encriptación
     * @throws NoSuchPaddingException Excepción para cuando no existe el relleno
     * especificado durante la encriptación
     */
    public static String encriptar(String texto) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {

        // Creamos una instancia del encriptador con encriptación AES
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        // Inicializamos el encriptador especificando el modo y la clave secreta
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Codificamos y transformamos a una cadena en base 64 para mostrar el resultado
        return Base64.encodeBase64String(cipher.doFinal(texto.getBytes("UTF-8")));

    }

    /**
     *
     * @param texto Cadena a desencriptar
     * @return Cadena desencriptada
     * @throws NoSuchAlgorithmException Excepción para cuando no existe el
     * algoritmo de encriptación
     * @throws InvalidKeyException Excepción para cuando la clave de
     * encriptación no es válida
     * @throws NoSuchPaddingException Excepción para cuando el relleno no es
     * válido
     * @throws IllegalBlockSizeException Excepción para cuando el tamaño de los
     * bloques de encriptación no son válidos
     * @throws BadPaddingException Excepción para cuando el relleno especificado
     * no es correcto
     */
    public static String desencriptar(String texto) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        // Creamos una instancia del encriptador con encriptación AES
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

        // Inicializamos el encriptador especificando el modo y la clave secreta        
        cipher.init(Cipher.DECRYPT_MODE, Encriptacion.secretKey);
        
        // Decodificamos y transformamos de una cadena en base 64 para mostrar el resultado
        return (new String(cipher.doFinal(Base64.decodeBase64(texto))));
    }
}
