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

package constructoresstringbuilder;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class ConstructoresStringBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuilder buffer1 = new StringBuilder();
        StringBuilder buffer2 = new StringBuilder(10);
        StringBuilder buffer3 = new StringBuilder("hola");

        System.out.println("buffer1: " + buffer1.toString());
        System.out.println("buffer2: " + buffer2.toString());
        System.out.println("buffer3: " + buffer3.toString());
        
        System.out.println(new StringBuilder("Hola Don Pepito").toString());
    }
}
