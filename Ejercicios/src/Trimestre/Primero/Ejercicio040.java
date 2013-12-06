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

package Trimestre.Primero;

import ejercicios.Mensajes;

/**
 * Se dispone de las calificaciones de los alumnos de un curso de informática 
 * correspondiente a las asignaturas de BASIC, FORTRAN y PASCAL. Diseñar un 
 * algoritmo que calcule la media de cada alumno.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio040 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio()
    {
        // Objeto para petición y muestra de datos al usuario
        Mensajes msg = new Mensajes();
        
        // Variables
        double notaBasic,notaFortran,notaPascal, media;

        // Petición de datos
        notaBasic = Double.parseDouble(msg.PedirDatos("Introduzca la nota para BASIC", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        notaFortran = Double.parseDouble(msg.PedirDatos("Introduzca la nota para FORTRAN", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        notaPascal = Double.parseDouble(msg.PedirDatos("Introduzca la nota para PASCAL", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        // Iteramos hasta que las notas sean negativas
        while (notaBasic >= 0 && notaFortran >= 0 && notaPascal >= 0 ) {            
            
            // Calculamos la media
            media = ((notaBasic + notaFortran + notaPascal) / 3);
            
            // Mostramos resultados
            msg.MostrarMensaje("La nota media es: " + media, 
                    "Resultado", Mensajes.TipoMensaje.INFORMACION);
            
            // Petición de datos
            notaBasic = Double.parseDouble(msg.PedirDatos("Introduzca la nota para BASIC", 
                    "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

            notaFortran = Double.parseDouble(msg.PedirDatos("Introduzca la nota para FORTRAN", 
                    "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

            notaPascal = Double.parseDouble(msg.PedirDatos("Introduzca la nota para PASCAL", 
                    "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));            
        }        
    }    
}
