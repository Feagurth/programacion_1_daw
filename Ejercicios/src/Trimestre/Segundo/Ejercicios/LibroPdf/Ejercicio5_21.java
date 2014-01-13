/*
 * Copyright (C) 2013 Luis Cabrerizo Gómez
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
package Trimestre.Segundo.Ejercicios.LibroPdf;

import Utiles.Mensajes;

/**
 * Clase para realizar el ejercicio 5.21 del libro de texto Como Programar en
 * Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_21 {

    public void Ejercicio() {
        // Objeto para pedir y mostrar datos al usuario
        Mensajes mensaje = new Mensajes();

        // Variables 
        int tamanyo;
        String resultado = "";

        // Petición de datos al usuario
        tamanyo = Integer.parseInt(mensaje.PedirDatos("Introduzca el número "
                + "de iteraciones", "Petición de Datos",
                Mensajes.TipoMensaje.PREGUNTA));

        // Iteramos tantas veces como sea necesario
        for (int i = 1; i <= tamanyo; i++) {
            for (int j = 1; j <= tamanyo; j++) {
                for (int k = 1; k <= tamanyo; k++) {     
                    if (i * i == j * j + k * k) {
                        resultado += String.format("%3d\t%3d\t%3d\n", i, j, k);
                    }
                }
            }
        }
        
        // Muestra de resultados
        //mensaje.MostrarMensaje(resultado, "Información", 
          //      Mensajes.TipoMensaje.INFORMACION);
        
        System.out.print(resultado);
    }

}
