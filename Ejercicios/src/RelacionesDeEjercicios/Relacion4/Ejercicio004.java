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
package RelacionesDeEjercicios.Relacion4;

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * Elaborar un programa que controle la introducción de la matrícula. Tener en
 * cuenta las matrículas de los diferentes países. Podéis generalizar hasta
 * donde estiméis oportuno
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio004 {

    public void Ejercicio() {
        // Variable para almacenar las distitnas expresiones regulares que 
        // usaremos para validar los datos
        String expresionRegular;

        // Variable para almacenar los valores que introducirá el usuario por 
        // teclado
        String cadena;

        // Definimos la expresión regular que necesitamos
        // Valida las matrículas de oches españolas desde 1900 en adelante
        // Se aceptan los siguientes formatos:
        // BI-51452 o BI 51452
        // L-62593 o L 62593
        // Z-103688 o Z 103688
        // AB-1134-D o AB 1134 D
        // B-9999-KT o B 9999 KT
        // M-6666-XN o M 6666 XN
        // M-9999-ZM o M 9999 ZM
        // 9999-BBB o 9999 BBB
        // Valida con las letras en mayúsculas o minúsculas
        expresionRegular = "^((([A-Za-z]{1,2}[-|\\s]?)?[0-9]{4,6})([-|\\s]?[A-Za-z]{1,3})?)$";

        // Iteramos hasta que se cumpla la validación
        do {
            // Pedimos datos al usuario
            cadena = PeticionDatos.pedirCadenaNumeroSimbolos("Introduzca una matrícula");

            // Verificamos si se cumple la validación, de no ser así, seguimos
            // iterando
        } while (!cadena.matches(expresionRegular));

        // Mostramos mensaje
        Mensajes.MostrarMensaje("Matrícula válida",
                Mensajes.TipoMensaje.INFORMACION);
    }

}
