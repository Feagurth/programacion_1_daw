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
 * Clase para realizar el ejercicio 5.22 del libro de texto Como Programar en
 * Java 7ed Deitel*
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_22 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        int fila, columna;
        String salida = "";

        for (fila = 1; fila <= 10; fila++) {
            for (columna = 1; columna <= fila; columna++) {
                salida += '*';
            }

            for (int i = columna; i <= 15; i++) {
                salida += ' ';
            }

            for (columna = 10; columna >= fila; columna--) {
                salida += '*';
            }

            for (int i = 0; i < 5 + fila; i++) {
                salida += ' ';
            }

            for (columna = 1; columna < fila; columna++) {
                salida += ' ';
            }
            for (columna = 10; columna >= fila; columna--) {
                salida += '*';
            }

            for (int i = 0; i < 5; i++) {
                salida += ' ';
            }

            for (columna = 10; columna > fila; columna--) {
                salida += ' ';
            }
            for (columna = 1; columna <= fila; columna++) {
                salida += '*';
            }

            salida += "\n";                
            
        }
        
        System.out.println(salida);
        Mensajes.mostrarMensaje(salida,"Información", Mensajes.TipoMensaje.INFORMACION, true);
    }
}
