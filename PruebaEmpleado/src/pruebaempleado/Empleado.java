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
package pruebaempleado;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Empleado {

    private final String primerNombre;
    private final String apellidoPaterno;
    private final Fecha FechaNacimiento;
    private final Fecha fechaContratacion;

    public Empleado(String nombre, String apellido, Fecha fechaNacimiento, Fecha fechaContratacion) {
        this.primerNombre = nombre;
        this.apellidoPaterno = apellido;
        this.FechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
    }

    @Override
    public String toString() {
        return String.format(primerNombre, "%s %s Contratado: %s Cumpleaños: %s",
                this.apellidoPaterno,
                this.primerNombre,
                this.fechaContratacion,
                this.FechaNacimiento);

    }

}
