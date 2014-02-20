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
package pruebaempleado1;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Empleado {

    private String primerNombre;
    private String apellidoPaerno;
    private static int cuenta = 0;

    public Empleado(String primerNombre, String apellidoPaerno) {
        this.primerNombre = primerNombre;
        this.apellidoPaerno = apellidoPaerno;

        cuenta++;

        System.out.printf("Contructor de Empleado: %s %s: cuenta = %d\n",
                this.primerNombre, this.apellidoPaerno, cuenta);
    }

    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    public String obtenerApellidoPaerno() {
        return apellidoPaerno;
    }

    public static int obtenerCuenta() {
        return cuenta;
    }

    protected void finalize() {
        cuenta--;
        System.out.printf("Finalizador de Empleado: %s %s: cuenta = %d\n",
                this.primerNombre, this.apellidoPaerno, cuenta);

    }

}
