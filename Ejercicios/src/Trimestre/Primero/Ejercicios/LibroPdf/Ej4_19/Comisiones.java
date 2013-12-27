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

package Trimestre.Primero.Ejercicios.LibroPdf.Ej4_19;

/**
 * Clase para calcular las comisiones de un vendedor
 * @author Luis Cabrerizo Gómez
 */
public class Comisiones {
    
    private final double PAGA_SEMANAL = 200f;
    
    // Variables que necesita la clase
    private final double paga;
    private final double valorVentas;

    /**
     * Devuelve el valor de la paga del comercial
     * @return El valor de la paga del comercial
     */
    public double getPaga() {
        return paga;
    }

    /**
     * Constuctor de la clase
     * @param valorVentas Valor total de las ventas del comercial
     */
    public Comisiones(double valorVentas) {
        this.valorVentas = valorVentas;
        this.paga = (this.valorVentas * 0.09) + this.PAGA_SEMANAL;
    }
}
