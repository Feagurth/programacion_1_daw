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
package pruebaalcance;

/**
 * Proyecto para hacer pruebas sobre el alcance de las variables
 *
 * @author Luis Cabrerizo Gómez
 */
public class Alcance {

    // Variable global x
    private int x = 1;

    /**
     * Método para mostrar el uso de variables locales y globales>
     */
    public void iniciar() {
        // Variable local x en iniciar
        int x = 5;

        // Mostramos el valor al usuario
        System.out.printf("La x local en el método iniciar es %d\n", x);
        usarVariableLocal();
        usarCampo();
    }

    /**
     * Método para mostrar el uso de variables locales y globales>
     */
    public void usarVariableLocal() {

        // Variable local x en usarVariableLocal
        int x = 25;

        // Mostramos el valor al usuario
        System.out.printf("La x local en el método usarVariableLocal"
                + " es %d\n", x);
        x++;
        
        // Mostramos el valor al usuario
        System.out.printf("La x local en el método usarVariableLocal"
                + " es %d\n", x);        
    }

    /**
     * Método para mostrar el uso de variables locales y globales>
     */
    public void usarCampo() {
        
        // Mostramos el valor al usuario
        System.out.printf("La x local en el método usarCampo"
                + " es %d\n", x);
        
        // Aumentamos el valor de la variable global
        x *= 10;
                
        // Mostramos el valor al usuario
        System.out.printf("La x local en el método usarCampo"
                + " es %d\n", x);
                
    }
}
