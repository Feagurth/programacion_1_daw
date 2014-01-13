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

package Trimestre.Segundo.Ejercicios.LibroPdf;

/**
 * Cree una clase llamada Fecha, que incluya tres piezas de información como 
 * variables de instancia — un mes (tipo int), un día (tipo int) y un año 
 * (tipo int). Su clase debe tener un constructor que inicialice las tres 
 * variables de instancia, y debe asumir que los valores que se proporcionan 
 * son correctos. Proporcione un método establecer y un método obtener para 
 * cada variable de instancia. Proporcione un método mostrarFecha, que muestre 
 * el mes, día y año, separados por barras diagonales (/). Escriba una 
 * aplicación de prueba llamada PruebaFecha, que demuestre las capacidades de 
 * la clase Fecha.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio3_15 {
    
public class Fecha {
    
    // Variables
    private int dia;
    private int mes;
    private int anyo;
    
    // Getters & Setters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    /**
     * Constructor de la clase
     * @param dia Dia del mes
     * @param mes Mes del año
     * @param anyo Año
     */
    public Fecha(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }
    
    /**
     * Función para mostrar la fecha
     * @return 
     */
    public String mostrarFecha()
    {
        return this.dia + "/" + this.mes + "/" + this.anyo;
    }
}    
    
    public void Ejercicio()
    {
        // Creamos el objeto
        Fecha fecha = new Fecha(31, 12, 2013);                
                
        // Hacemos que muestre la fecha
        System.out.println(fecha.mostrarFecha());    
    }
    
}
