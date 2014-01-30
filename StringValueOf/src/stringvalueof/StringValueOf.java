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

package stringvalueof;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class StringValueOf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char arrayChar[] = {'a', 'b', 'c', 'd', 'e', 'f'};
        boolean valorBoolean = true;
        char valorChar = 'Z';
        int valorInt = 7;
        long valorLong = 10000000000L;
        float valorFloat = 2.5f;
        double valorDouble = 33.333;
        Object refObjecto = "hola";
        
        System.out.println("arrayChar: " + String.valueOf(arrayChar));
        System.out.println("valorBoolean: " + String.valueOf(valorBoolean));
        System.out.println("valorChar: " + String.valueOf(valorChar));
        System.out.println("valorInt: " + String.valueOf(valorInt));
        System.out.println("valorLong: " + String.valueOf(valorLong));
        System.out.println("valorFloat: " + String.valueOf(valorFloat));
        System.out.println("valorDouble: " + String.valueOf(valorDouble));
        System.out.println("refObjecto: " + String.valueOf(refObjecto));
    }
    
}
