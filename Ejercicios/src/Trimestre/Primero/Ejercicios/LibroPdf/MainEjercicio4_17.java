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

package Trimestre.Primero.Ejercicios.LibroPdf;

import Utiles.Mensajes;

/**
 * Clase para realizar el ejercicio 4.17 del libro de texto
 * Como Programar en Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class MainEjercicio4_17 {

    public MainEjercicio4_17() {
    }

    /**
     * Lanzador del ejercicio
     */
    public void Ejercicio()
    {
        // Variable para controlar el número de reabastecimientos que usaremos
        int numReabastecimientos;        
        // Variable para acumular el total de los reabastecimientos
        float total = 0.0f;
        
        // Variables para introducir los datos necesarios
        double kms, litros;
        
        // Objeto Mensajes que usaremos para leer datos y mostrar resultados
        Mensajes mensaje = new Mensajes();
        
        // Creamos el objeto que usaremos
        Ejercicio4_17 reabastecimiento;
        
        // Pedimos al usuario en numero de reabastecimientos realizados
        numReabastecimientos = Integer.parseInt(mensaje.PedirDatos("Introduzca el número de "
                + "reabastecimientos realizados", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        // Iteramos tantas veces como reabastecimientos se hayan realizado
        for (int i = 0; i < numReabastecimientos; i++) {
            
            // Pedimos el número de kms realizados en cada reabastecimiento
            kms = Double.parseDouble(mensaje.PedirDatos("Introduzca el número de "
                + "kms realizados", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));

            // Pedimos el número de litros de gasolina consumidos en cada reabastecimiento
            litros = Double.parseDouble(mensaje.PedirDatos("Introduzca el número de "
                + "litros consumidos", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
            
            // Creamos una clase nueva con los datos pedidos al usuarios
            reabastecimiento = new Ejercicio4_17(kms, litros);
            
            // Acumulamos el valor de kms por litro extraido de la clase
            total += reabastecimiento.getKmsXLitro();
            
        }
        
        // Mostramos el resultado final
        mensaje.MostrarMensaje("El total de kms/litros es de: " + total, 
                "Mostrar Resultados", Mensajes.TipoMensaje.INFORMACION);
    }    
}
