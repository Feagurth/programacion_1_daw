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
public class PruebaEmpleado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fecha nacimiento = new Fecha(7,24,1949);
        Fecha contratacion = new Fecha(9, 12, 1988);
        
        Empleado empleado = new Empleado("Antonio", "Lopez", nacimiento, 
                contratacion);
       
        System.out.println(empleado.toString());
        
    }
    
}
