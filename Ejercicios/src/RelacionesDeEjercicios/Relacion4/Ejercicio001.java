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
package RelacionesDeEjercicios.Relacion4;

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * Crearos una expresión regular para verificar la fecha con el 
 * formato dd/mm/aa. Tener en cuenta los siguientes aspectos: 
 * a. dd, mm, aa son dígitos 
 * b. dd y mm pueden tener un dígito o dos 
 * c. aa tiene que tener dos dígitos forzosamente 
 * d. mm es un valor comprendido entre 1 y 12 
 * e. dd es una valor comprendido entre 1 y 31 
 * f. Tanto para el día como para el mes pueden de forma opcional mostrar 
 * un cero como primer dígito 
 * 
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio001 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        
        // Valida fechas de 31 dias para los meses 1,3,5,7,8,10 y 12
        String validaMeses31 = "(0?[0-9]|[12][0-9]|3[01])/(0?[13578]|1[02])/[0-9]{2}";
        
        // Valida fechas de 30 dias para los meses 4, 6, 9 y 11
        String validaMeses30 = "(0?[0-9]|[12][0-9]|30)/(0?[469]|11)/[0-9]{2}";
        
        // Valida fechas de 28 dias para el mes 2 y cualquier año
        String validaFebrero = "(0?[0-9]|1[0-9]|2[0-8])/(0?[2])/[0-9]{2}";
        
        // Valida fechas de 29 dias para el mes 2 para los años que sean divisibles entre 4
        String validaFebreroBis = "(0?[0-9]|[12][0-9])/(0?[2])/(0[48]|[13579][26]|[2468][048])";
        
        // Expresión regular para validar la fecha
        String validaFecha = validaMeses31 + "|" + validaMeses30 + "|" + 
                validaFebrero + "|" + validaFebreroBis;

        // Variable para almacenar la fecha
        String fecha;

        do {
            // Pedimos datos al usuario
            fecha = PeticionDatos.pedirCadenaNumeroSimbolos("Introduzca una fecha "
                    + "valida [dd/mm/aa]");

            // Comprobamos si la fecha es correcta usando expresiones regulares
        } while (!fecha.matches(validaFecha));

        // Mostramos el resultado       
        Mensajes.mostrarMensaje("La fecha " + fecha + " es una fecha válida", 
                Mensajes.TipoMensaje.INFORMACION);
    }
}
