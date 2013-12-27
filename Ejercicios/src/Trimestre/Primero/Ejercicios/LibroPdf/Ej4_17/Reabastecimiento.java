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

package Trimestre.Primero.Ejercicios.LibroPdf.Ej4_17;

/**
 * Clase para controlar los repostajes y el consumo en gasolina
 * @author Luis Cabrerizo Gómez
 */
public class Reabastecimiento {

    private final double kms;
    private final double litrosGasolina;
    private final float kmsXLitro;

    /**
     * Nos permite recoger el valor de kms / litro del repostaje
     * @return Los kms recorridos con un litro de gasolina
     */
    public float getKmsXLitro() {
        return kmsXLitro;
    }
    
    /**
     * Constructor de la clase
     * @param kmsRecorridos Numero de kms recorridos en un repostaje
     * @param litrosGasolinaUsada Litros de gasolina usada en el repostaje
     */
    public Reabastecimiento(double kmsRecorridos, double litrosGasolinaUsada) {
        this.kms = kmsRecorridos;
        this.litrosGasolina = litrosGasolinaUsada;
        this.kmsXLitro = (float) (this.kms / this.litrosGasolina);
    }
    

    
    
}
