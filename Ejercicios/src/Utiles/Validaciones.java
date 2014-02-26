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
public class Validaciones {

    private static final String CADENA = "^[a-zA-Z ]+$";
    private static final String CADENA_MAY = "^[A-Z ]+$";
    private static final String CADENA_MIN = "^[a-z ]+$";
    private static final String ENTERO = "^(\\+|-)?[0-9]+$";
    private static final String ENTERO_POSITIVO = "^(\\+)?[0-9]+$";
    private static final String ENTERO_NEGATIVO = "^-[0-9]+$";
    private static final String ENTERO_POSITIVO_NO_0 = "^[1-9]([0-9]+)?$";
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

    private static final String FECHA_DDMMAAAA = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]"
            + "|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))"
            + "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:"
            + "(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16"
            + "|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])"
            + "(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]"
            + "\\d)?\\d{2})$";

    
    private static final String CADENA_NUMEROS = "^[a-zA-Z0-9 ]+$";
    /**
     * Tipos de validaciones que se pueden llevar a cabo
     */
    public enum TipoValidacion {

        CADENA(0), CADENA_MAY(1), CADENA_MIN(2), ENTERO(3), ENTERO_POSITIVO(4),
        ENTERO_NEGATIVO(5), ENTERO_POSITIVO_NO_0(6), ENTERO_NEGATIVO_NO_0(7), REAL(8),
        REAL_POSITIVO(9), REAL_NEGATIVO(10), USUARIO(11), PASSWORD(12),
        FECHA_DDMMAA(13), FECHA_DDMMAAAA(14), CADENA_NUMEROS(15);

        private final int value;

        private TipoValidacion(int value) {
            this.value = value;
        }

    }

    /**
     * Método para validar datos 
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
            default:
                return false;
        }

    }

}
