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
import Utiles.PeticionDatos;
import java.awt.Dimension;

/**
 * Clase para realizar el ejercicio 5.14 del libro de texto Como Programar en
 * Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio5_14 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        double monto; // Monto depositado al final de cada año
        double principal; // monto inicial antes de los intereses
        String cadena;

        // Petición de datos al usuario
        principal = PeticionDatos.pedirRealPositivoNoCero("Introduzca el valor del monto inicial");
        
        // Preparamos los encabezados
        cadena = String.format("s%20s\n", "Anio", "Monto en deposito");
        // calcula el monto en deposito para cada uno de diez años
        for (int i = 5; i < 11; i++) {
            
            cadena += String.format("\nInteres: %,1.2f\n", (i/100f));
            
            for (int anio = 1; anio <= 10; anio++) {
                // calcula el nuevo monto para el año especificado
                monto = calculoDeInteres(principal, (i/100f), anio);

                cadena += String.format("%4d%,20.2f\n", anio, monto);
            }
        }
        
        // Mostramos el resultado
        Mensajes.mostrarMensaje(cadena, "Información", 
                Mensajes.TipoMensaje.INFORMACION, true, 
                new Dimension(40, 40));
    }

    /**
     * Función para calcular el interés
     *
     * @param dineroInicial Dinero inicial
     * @param interes Porcentaje de interes
     * @param anyos Numero de años
     * @return Cantidad final
     */
    private double calculoDeInteres(double dineroInicial, double interes, int anyos) {
        double monto = 0;

        for (int i = 0; i < anyos; i++) {
            monto = dineroInicial * Math.pow(1.0 + interes, anyos);
        }

        return monto;
    }
}
