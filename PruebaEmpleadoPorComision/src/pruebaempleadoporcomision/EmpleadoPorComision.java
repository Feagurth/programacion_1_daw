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

package pruebaempleadoporcomision;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class EmpleadoPorComision {
    
    private String primerNombre;
    private String apellidoPaterno;
    private String numeroSeguridadSocial;
    private double ventasBrutas;
    private double tarifaComision;

    public EmpleadoPorComision(String primerNombre, String apellidoPaterno, 
            String numeroSeguridadSocial, double ventasBrutas, 
            double tarifaComision) {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    public void establecerPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String obtenerApellidoPaterno() {
        return apellidoPaterno;
    }

    public void establecerApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String obtenerNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public void establecerNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public double obtenerVentasBrutas() {
        return ventasBrutas;
    }

    public void establecerVentasBrutas(double ventasBrutas) {
        this.ventasBrutas = ventasBrutas;
    }

    public double obtenerTarifaComision() {
        return tarifaComision;
    }

    public void establecerTarifaComision(double tarifaComision) {
        this.tarifaComision = tarifaComision;
    }
    
    
    
    
    
}
