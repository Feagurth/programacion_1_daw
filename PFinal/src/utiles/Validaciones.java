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

/**
 * Clase para validar datos
 *
 * @author Luis Cabrerizo Gómez
 */
public class Validaciones {

    private static final String CADENA = "^[a-zA-ZñÑ ]+$";
    private static final String CADENA_MAY = "^[A-ZÑ ]+$";
    private static final String CADENA_MIN = "^[a-zñ ]+$";
    private static final String ENTERO = "^(\\+|-)?[0-9]+$";
    private static final String ENTERO_POSITIVO = "^(\\+)?[0-9]+$";
    private static final String ENTERO_NEGATIVO = "^-[0-9]+$";
    private static final String ENTERO_POSITIVO_NO_0 = "^[1-9]([0-9]+)?$";
    private static final String ENTERO_POSITIVO_NO_0_EXT = "([0-9]+)?$";
    private static final String ENTERO_NEGATIVO_NO_0 = "^-[1-9]([0-9]+)?$";
    private static final String REAL = "^[-]?([1-9]{1}[0-9]{0,}([\\.|\\,][0-9]{1,})?|0([\\.|\\,][0-9]{1,})?|[\\.|\\,][0-9]{1,})$";
    private static final String REAL_POSITIVO = "^([1-9]{1}[0-9]{0,}([\\.|\\,][0-9]{1,})?|0([\\.|\\,][0-9]{1,})?|[\\.|\\,][0-9]{1,})$";
    private static final String REAL_NEGATIVO = "^[-]([1-9]{1}[0-9]{0,}([\\.|\\,][0-9]{1,})?|0([\\.|\\,][0-9]{1,})?|[\\.|\\,][0-9]{1,})$";
    private static final String USUARIO = "^[a-zA-Z]{1}[a-zA-Z0-9_]{7,15}$";
    private static final String PASSWORD = "^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{8,10}$";

    // Valida fechas de 31 dias para los meses 1,3,5,7,8,10 y 12
    private static final String validaMeses31 = "(0?[0-9]|[12][0-9]|3[01])/(0?[13578]|1[02])/[0-9]{2}";

    // Valida fechas de 30 dias para los meses 4, 6, 9 y 11
    private static final String validaMeses30 = "(0?[0-9]|[12][0-9]|30)/(0?[469]|11)/[0-9]{2}";

    // Valida fechas de 28 dias para el mes 2 y cualquier año
    private static final String validaFebrero = "(0?[0-9]|1[0-9]|2[0-8])/(0?[2])/[0-9]{2}";

    // Valida fechas de 29 dias para el mes 2 para los años que sean divisibles entre 4
    private static final String validaFebreroBis = "(0?[0-9]|[12][0-9])/(0?[2])/(0[48]|[13579][26]|[2468][048])";

    // Expresión regular para validar la fecha
    private static final String FECHA_DDMMAA = validaMeses31 + "|" + validaMeses30 + "|"
            + validaFebrero + "|" + validaFebreroBis;

    private static final String FECHA_DDMMAAAA = "(((0*[1-9]|[12][0-9]|3[01])"
            + "([-./])(0*[13578]|10|12)([-./])(\\d{4}))|((0*[1-9]|[12][0-9]|30)"
            + "([-./])(0*[469]|11)([-./])(\\d{4}))|((0*[1-9]|1[0-9]|2[0-8])"
            + "([-./])(02|2)([-./])(\\d{4}))|((29)(\\.|-|\\/)(02|2)"
            + "([-./])([02468][048]00))|((29)"
            + "([-./])(02|2)"
            + "([-./])([13579][26]00))|((29)"
            + "([-./])(02|2)([-./])([0-9][0-9][0][48]))|((29)"
            + "([-./])(02|2)([-./])([0-9][0-9][2468][048]))|((29)"
            + "([-./])(02|2)([-./])([0-9][0-9][13579][26])))";

    private static final String CADENA_NUMEROS = "^[a-zA-Z0-9 ]+$";

    private static final String DNI = "(([X-Z]{1})([-]?)(\\d{7})([-]?)([A-Z]{1}))|((\\d{8})([-]?)([A-Z]{1}))";

    private static final String BINARIO = "^[0-1]+$";

    private static final String CADENA_SOLO_NUMEROS = "^[0-9]+$";

    private static final String CADENA_NUMEROS_SIMBOLOS = "^[a-zA-ZñÑ0-9 +-–<>/_.,:;(){}$áÁéÉíÍóÓúÚ¿?\"“”'@#$%&ç#1¡!]+";

    private static final String CADENA_SOLO_LETRAS_NUMEROS = "^[a-zA-ZñÑ0-9]+$";

    private static final String NUMERO = "[-+]?\\d*\\.?\\d+";

    private static final String ISBN = "((?=\\d{1,5}\\d{1,7}\\2?\\d{1,6}\\2?\\d)(?:\\d\\2*){9}[\\dX])|(97(?:8|9)(?=\\d{1,5}\\2?\\d{1,7}\\2?\\d{1,6}\\2?\\d)(?:\\d\\2*){9}\\d)";

    private static final String IP = "^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\."
            + "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\."
            + "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\."
            + "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$";

    private static final String CADENA_SOLO_LETRAS = "^[a-zA-ZñÑ]+$";

    /**
     * Tipos de validaciones que se pueden llevar a cabo
     */
    public enum TipoValidacion {

        /**
         * Valor para cadena
         */
        CADENA(0),
        /**
         * Valor para cadena de mayúsculas
         */
        CADENA_MAY(1),
        /**
         * Valor para cadena en minúsculas
         */
        CADENA_MIN(2),
        /**
         * Valor para enteros
         */
        ENTERO(3),
        /**
         * Valor para enteros positivos
         */
        ENTERO_POSITIVO(4),
        /**
         * Valor para enteros negativos
         */
        ENTERO_NEGATIVO(5),
        /**
         * Valor para enteros positivos excepto cero
         */
        ENTERO_POSITIVO_NO_0(6),
        /**
         * Valor para enteros negativos excepto cero
         */
        ENTERO_NEGATIVO_NO_0(7),
        /**
         * Valor para números reales
         */
        REAL(8),
        /**
         * Valor para reales positivos
         */
        REAL_POSITIVO(9),
        /**
         * Valor para reales negativos
         */
        REAL_NEGATIVO(10),
        /**
         * Valor para usuario
         */
        USUARIO(11),
        /**
         * Valor para password
         */
        PASSWORD(12),
        /**
         * Valor para fecha DDMMAA
         */
        FECHA_DDMMAA(13),
        /**
         * Valor para fecha DDMMAAAA
         */
        FECHA_DDMMAAAA(14),
        /**
         * Valor para cadena con números
         */
        CADENA_NUMEROS(15),
        /**
         * Valor para DNI
         */
        DNI(16),
        /**
         * Valor para binario
         */
        BINARIO(17),
        /**
         * Valor para enteros positivos sin cero extendido
         */
        ENTERO_POSITIVO_NO_0_EXT(18),
        /**
         * Valor para cadena de números
         */
        CADENA_SOLO_NUMEROS(19),
        /**
         * Valor para cadena de números y símbolos
         */
        CADENA_NUMEROS_SIMBOLOS(20),
        /**
         * Valor para cadena de letras y números exclusivamente
         */
        CADENA_SOLO_LETRAS_NUMEROS(21),
        /**
         * Valor para cadena de números
         */
        NUMERO(22),
        /**
         * Valor para ISBN
         */
        ISBN(23),
        /**
         * Valor para IPs
         */
        IP(24),
        /**
         * Valor para cadenas de letras sin espacios
         */
        CADENA_SOLO_LETRAS(25);

        private final int value;

        private TipoValidacion(int value) {
            this.value = value;
        }

    }

    /**
     * Método para validar datos
     *
     * @param dato Dato a validar
     * @param tipoValidacion Tipo de validación que se llevara a cabo
     * @return Verdadero si valida, falso si no valida
     */
    public static boolean validarDato(String dato, TipoValidacion tipoValidacion) {

        switch (tipoValidacion) {
            case CADENA:
                return dato.matches(CADENA);
            case CADENA_MAY:
                return dato.matches(CADENA_MAY);
            case CADENA_MIN:
                return dato.matches(CADENA_MIN);
            case ENTERO:
                return dato.matches(ENTERO);
            case ENTERO_POSITIVO:
                return dato.matches(ENTERO_POSITIVO);
            case ENTERO_NEGATIVO:
                return dato.matches(ENTERO_NEGATIVO);
            case ENTERO_POSITIVO_NO_0:
                return dato.matches(ENTERO_POSITIVO_NO_0);
            case ENTERO_NEGATIVO_NO_0:
                return dato.matches(ENTERO_NEGATIVO_NO_0);
            case REAL:
                return dato.matches(REAL);
            case REAL_POSITIVO:
                return dato.matches(REAL_POSITIVO);
            case REAL_NEGATIVO:
                return dato.matches(REAL_NEGATIVO);
            case USUARIO:
                return dato.matches(USUARIO);
            case PASSWORD:
                return dato.matches(PASSWORD);
            case FECHA_DDMMAA:
                return dato.matches(FECHA_DDMMAA);
            case FECHA_DDMMAAAA:
                return dato.matches(FECHA_DDMMAAAA);
            case CADENA_NUMEROS:
                return dato.matches(CADENA_NUMEROS);
            case DNI:
                return dato.matches(DNI);
            case BINARIO:
                return dato.matches(BINARIO);
            case ENTERO_POSITIVO_NO_0_EXT:
                return dato.matches(ENTERO_POSITIVO_NO_0_EXT);
            case CADENA_SOLO_NUMEROS:
                return dato.matches(CADENA_SOLO_NUMEROS);
            case CADENA_NUMEROS_SIMBOLOS:
                return dato.matches(CADENA_NUMEROS_SIMBOLOS);
            case CADENA_SOLO_LETRAS_NUMEROS:
                return dato.matches(CADENA_SOLO_LETRAS_NUMEROS);
            case NUMERO:
                return dato.matches(NUMERO);
            case ISBN:
                return dato.matches(ISBN);
            case IP:
                return dato.matches(IP);
            case CADENA_SOLO_LETRAS:
                return dato.matches(CADENA_SOLO_LETRAS);
            default:
                return false;
        }
    }
}
