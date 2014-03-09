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

package Trimestre.Segundo.Ejercicios.LibroPdf;

import Utiles.Mensajes;

/**
 * Clase para realizar el ejercicio 5.29 del libro de texto Como Programar en
 * Java 7ed Deitel*
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_29 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Variable para almacenar el resultado
        String resultado;
        
        // Inicializamos el resultado con la primera estrofa
        resultado = "On the twelfth day of Christmas, my true love gave to me.\n";
        
        // Iteramos de 12 a 1 para las siguientes estrofas
        for (int i = 12; i > 0; i--) 
        {
            // Vamos anexando las estrofas de una en una
            switch(i)
            {
                case 12:
                    resultado += "12 Drummers Drumming\n";
                    break;
                case 11:
                    resultado += "11 Pipers Piping\n";
                    break;
                case 10:
                    resultado += "10 Lords-a-Leaping\n";
                    break;
                case 9:
                    resultado += "9 Ladies Dancing\n";
                    break;
                case 8:
                    resultado += "8 Maids-a-Milking\n";
                    break;
                case 7:
                    resultado += "7 Swans-a-Swimming\n";
                    break;
                case 6:
                    resultado += "6 Geese-a-Laying\n";
                    break;
                case 5:
                    resultado += "5 Gold Rings\n";
                    break;
                case 4:
                    resultado += "4 Colly Birds or Calling Birds\n";
                    break;
                case 3:
                    resultado += "3 French Hens\n";
                    break;
                case 2:
                    resultado += "2 Turtle Doves\n";
                    break;
                case 1:
                    resultado += "And a Partridge in a Pear Tree\n";
                    break;                    
            }            
        }
        
        // Mostramos el resultado
        Mensajes.mostrarMensaje(resultado, Mensajes.TipoMensaje.INFORMACION);
    }   
}
