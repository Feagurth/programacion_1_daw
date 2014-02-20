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
public class PruebaEmpleado1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.printf("Número de empleados antes de instanciar : %d\n",
                Empleado.obtenerCuenta());

        Empleado e1 = new Empleado("Antonio", "Lopez");
        Empleado e2 = new Empleado("Jose", "Feliciano");

        System.out.printf("Número de empleados despues de instanciar : %d\n",
                Empleado.obtenerCuenta());

        System.out.printf("mediante e1.obtenerCuenta(): %d\n", e1.obtenerCuenta());
        System.out.printf("mediante e2.obtenerCuenta(): %d\n", e2.obtenerCuenta());

        e1 = null;                
        e2 = null;
        
        System.gc();
        
        System.out.printf("Número de empleados despues de System.gc(): %d\n",
                Empleado.obtenerCuenta());
        
    }

}
