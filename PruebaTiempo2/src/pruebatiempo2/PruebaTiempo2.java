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

package pruebatiempo2;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class PruebaTiempo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tiempo t1 = new Tiempo();
        Tiempo t2 = new Tiempo(2);
        Tiempo t3 = new Tiempo(21, 34);
        Tiempo t4 = new Tiempo(12, 25, 42);
        Tiempo t5 = new Tiempo(27, 74, 89);

        System.out.println("Se construyo: ");
        System.out.printf("t1: todos los argumentos predeterminados\n\t%s\n\t%s\n", t1.aStringUniversal(), t1.toString());
        
        System.out.println("t2: se especificó hora; minuto y segundos predeterminados");
        System.out.printf("t2: todos los argumentos predeterminados\n\t%s\n\t%s\n", t2.aStringUniversal(), t2.toString());

        System.out.println("t3: se especificó hora y minuto; segundos predeterminados");
        System.out.printf("t3: todos los argumentos predeterminados\n\t%s\n\t%s\n", t3.aStringUniversal(), t3.toString());

        System.out.println("t4: se especificó hora, minuto y segundos predeterminados");
        System.out.printf("t4: todos los argumentos predeterminados\n\t%s\n\t%s\n", t4.aStringUniversal(), t4.toString());

        System.out.println("t5: se especificaron valores inválidos");
        System.out.printf("t5: todos los argumentos predeterminados\n\t%s\n\t%s\n", t5.aStringUniversal(), t5.toString());
        
        
        
    }
    
}
