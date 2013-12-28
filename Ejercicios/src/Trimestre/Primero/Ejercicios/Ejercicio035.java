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

package Trimestre.Primero.Ejercicios;

import Utiles.Mensajes;

/**
 * Se desea realizar una estadística de los pesos de los alumnos de un colegio 
 * de acuerdo a la siguiente tabla:
 *                      Alumnos de menos de 40 kg
 *                      Alumnos entre 40 y 50 kg
 *                      Alumnos de más de 50 y menos de 60 kg
 *                      Alumnos de más o igual a 60 kg
 * La entrada de los pesos de los alumnos se terminará cuando se introduzca el 
 * valor centinela – 99. Al final se desea obtener cuántos alumnos hay en cada 
 * uno de los baremos.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio035 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Objeto para pedir y mostrar datos para el usuario
        Mensajes msg = new Mensajes();

        // Variables
        int alumnos40 = 0, alumnos4050 = 0, alumnos5060 = 0, alumnos60 = 0;
        double peso;
                
        // Petición de datos al usuario
        peso = Double.parseDouble(msg.PedirDatos("Introduzca el peso", 
                "Petición de Datos", Mensajes.TipoMensaje.INFORMACION));
        
        // Iteramos hasta que leamos el valor centinela para salir del bucle
        while (peso != (double)-99) {            
            // Aumentamos un contador u otro dependiendo del valor leido
            if(peso < 40) 
            {
                alumnos40++;
            }
            if(peso >= 40 && peso < 50)
            {
                alumnos4050++;
            }
            if(peso >= 50 && peso < 60 )
            {
                alumnos5060++;
            }
            if(peso >= 60)
            {
                alumnos60++;
            }
            
            // Petición de datos al usuario
            peso = Double.parseDouble(msg.PedirDatos("Introduzca el peso", 
                    "Petición de Datos", Mensajes.TipoMensaje.INFORMACION));            
        }
    
        // Muestra de resultados
        msg.MostrarMensaje(
                "Alumnos de menos de 40 kgs: " + alumnos40 + "\n" +
                "Alumnos de mas 40 y menos de 50 kgs: " + alumnos4050 + "\n" +
                "Alumnos de mas 50 y menos de 60 kgs: " + alumnos5060 + "\n" +
                "Alumnos de menos de 60 kgs: " + alumnos60 + "\n",                                                
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
    }    
}
