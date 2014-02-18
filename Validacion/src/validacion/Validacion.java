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
package validacion;

import java.util.Scanner;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Validacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        String primerNombre, codigoPostal;

        System.out.print("Escribe el primer nombre: ");
        primerNombre = teclado.nextLine();

        if (!ValidacionEntrada.validarPrimerNombre(primerNombre)) {
            System.out.println("Nombre no válido");
        } else {
            System.out.println("Nombre válido");
        }

        System.out.print("Escribe el código postal: ");
        codigoPostal = teclado.nextLine();
        
        if (!ValidacionEntrada.validarCP(codigoPostal)) {
            System.out.println("Código postal no válido");
        } else {
            System.out.println("Código postal válido");
        }
        
    }

}
