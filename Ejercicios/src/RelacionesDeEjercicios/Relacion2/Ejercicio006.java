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
import java.awt.Dimension;

/**
 * Triples Pitágoras.
 *
 * Un triángulo recto puede tener lados cuyas longitudes sean valores enteros.
 * El conjunto de tres valores enteros para las longitudes de los lados de un
 * triángulo recto se conoce como triple de Pitágoras. Las longitudes de los
 * tres lados deben satisfacer la relación que establece que la suma de los
 * cuadrados de dos lados es igual al cuadrado de la hipotenusa.
 *
 * Escribe una aplicación para encontrar todos los triples de Pitágoras para
 * lado1, lado2 y la hipotenusa, que no sean mayores de 500. Utiliza un ciclo
 * for triplemente anidado para probar todas las posibilidades. Este método es
 * un ejemplo de “fuerza bruta”.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio006 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variables 
        int tamanyo;
        StringBuilder resultado = new StringBuilder();

        tamanyo = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el número "
                + "limite para calcular los triples pitagóricos");

        // Iteramos tantas veces como sea necesario
        for (int i = 1; i <= tamanyo; i++) {
            for (int j = 1; j <= tamanyo; j++) {
                for (int k = 1; k <= tamanyo; k++) {

                    // Verificamos si se cumple que la suma del cuadrado de los
                    // catetos es igual al cuadrado de la hipotenusa
                    if (i * i == j * j + k * k) {

                        // Concatenamos los resultados
                        resultado.append(String.format("%3d\t%3d\t%3d%n", i, j, k));
                    }
                }
            }
        }

        // Muestra de resultados
        Mensajes.mostrarMensaje(resultado.toString(), "Resultado", 
                Mensajes.TipoMensaje.INFORMACION, true, new Dimension(30, 30));
    }
}
