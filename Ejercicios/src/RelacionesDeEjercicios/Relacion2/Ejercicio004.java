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
 * Escribe una aplicación que muestre la siguiente figura de rombo. Puedes
 * utilizar instrucciones de salida que impriman un solo asterisco (*), un solo
 * espacio o un solo carácter de nueva línea. Maximiza el uso de la repetición
 * for anidadas, y minimiza el número de instrucciones de salida.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio004 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables
        int alto;
        StringBuilder resultado = new StringBuilder();

        do {

            // Petición de datos al usuario
            alto = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca un número "
                    + "entero impar\npara definir el ancho máximo del rombo "
                    + "dibujado");

            // Verificamos que el número sea impar para que el triángulo se 
            // dibuje correctamente
        } while (alto % 2 == 0);

        for (int i = 1; i <= ((alto / 2) + 1); i++) {
            for (int k = 1; k <= alto / 2 - i + 1; k++) {
                resultado.append(" ");
            }

            // Iteramos para dibujar la parte superior del rombo
            for (int j = (alto / 2) - i + 2; j <= (alto / 2) + i; j++) {
                resultado.append("*");
            }
            resultado.append("\n");
        }

        // Iteramos para dibujar la parte inferior del rombo
        for (int l = 1; l <= alto / 2; l++) {

            // Imprimimos espacios
            for (int m = 1; m <= l; m++) {
                resultado.append(" ");
            }

            for (int n = l + 1; n <= alto - l; n++) {
                resultado.append("*");
            }
            resultado.append("\n");
        }

        // Mostramos resultados. Se muestra tb por consola pues en un 
        // cuando de mensaje no queda bien alineado
        System.out.println(resultado.toString());
        
        Mensajes.mostrarMensaje(resultado.toString(), "Resultado",
                Mensajes.TipoMensaje.INFORMACION, true);

    }
}
