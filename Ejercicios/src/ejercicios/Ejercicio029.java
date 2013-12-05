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

package ejercicios;

/**
 * Calcular la nota media por alumno de una clase de a alumnos. Cada alumno 
 * podrá tener un número n de notas distintas.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio029 {
   
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Objeto para petición y muestra de información al usuario
        Mensajes msg = new Mensajes();
        
        int numeroNotas, contador = 0;
        double nota, notaMedia = 0;

        // Petición de datos al usuario
        numeroNotas = Integer.parseInt(msg.PedirDatos("Número de notas a "
                + "introducir", "Petición de datos", Mensajes.TipoMensaje.PREGUNTA));
        
        
        // Iteramos mientras el contador de notas sea menor al número de notas
        // introducidas
        while (contador < numeroNotas) {            
            contador += 1;
            
            // Petición de datos al usuario
            nota = Double.parseDouble(msg.PedirDatos("Introduzca la nota", 
                    "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
            
            notaMedia += nota;
        }

        // Escribir resultados
        msg.MostrarMensaje("La media del alumno es: " + (notaMedia / numeroNotas), 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);        
    }
}
