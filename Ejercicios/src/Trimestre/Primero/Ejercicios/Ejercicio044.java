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
package Trimestre.Primero.Ejercicios;

import Utiles.Mensajes;

/**
 * Leer una serie de números desde el terminal y calcular su media. La marca de
 * fin de lectura será el numero -999
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio044 {

    public void Ejercicio() {

        // Objeto para pedir y mostrar información al usuario
        Mensajes mensaje = new Mensajes();

        // Variables
        double numero, suma = 0;
        int contador = 0;

        // Petición de datos al usuario
        numero = Integer.parseInt(mensaje.PedirDatos("Introduzca un valor. -999 para salir",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        // Verificamos la condición
        while (numero != -999) {
            // Incrementamos el contador y sumamos el número
            contador = contador + 1;
            suma = suma + numero;
            
            // Petición de datos al usuario
            numero = Integer.parseInt(mensaje.PedirDatos("Introduzca un valor. -999 para salir",
                    "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        }

        // Verificamos si se han introducido números y mostramos resultados
        if (contador != 0) {
            mensaje.MostrarMensaje("El resultado es: "
                    + (suma / (double) contador), "Información",
                    Mensajes.TipoMensaje.INFORMACION);
        } else {
            mensaje.MostrarMensaje("No se han introducido valores",
                    "Información", Mensajes.TipoMensaje.INFORMACION);
        }
    }

}
