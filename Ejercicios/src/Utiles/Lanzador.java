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
package Utiles;

import Trimestre.Segundo.Ejercicios.RegExp.Ejercicio005;

/**
 * Clase para lanzar cada uno de los ejercicios del proyecto Para usarla
 * simplemente hay que que crear un objeto de la clase que queramos ejecutar y
 * lanzar el método ejercicio
 *
 * P.Ej. Ejercicio3_14 ejercicio = new Ejercicio3_14();
 *
 * ejercicio.ejercicio();
 *
 * @author Luis Cabrerizo Gómez
 */
public class Lanzador {

    /**
     * @param args argumentos por linea de comandos
     */
    public static void main(String[] args) {

        Ejercicio005 ejercicio = new Ejercicio005();

        ejercicio.ejercicio();
    }
}
