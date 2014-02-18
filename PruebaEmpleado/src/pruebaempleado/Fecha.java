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
package pruebaempleado;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Fecha {

    private int mes;
    private int dia;
    private int anio;

    public Fecha(int mes, int dia, int anio) {
        this.mes = comprobarMes(mes);
        this.dia = comprobarDia(dia);
        this.anio = anio;
    }

    private int comprobarMes(int mes) {
        if (mes > 0 && mes <= 12) {
            return mes;
        } else {
            System.out.printf("Mes inválido (%d)", mes);
            return 1;
        }
    }

    private int comprobarDia(int dia) {
        int[] diasMes = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (dia > 0 && dia <= (EsAnyoBisiesto(this.anio) ? (diasMes[this.mes] + 1) : diasMes[this.mes])) {
            return dia;
        } else {
            System.out.printf("Dia inválido (%d)", dia);
            return 1;
        }
    }

    /**
     * Función para comprobar si un año es bisiesto
     *
     * @param anyo Año a comprobar
     * @return Resultado de la comprobación
     */
    private boolean EsAnyoBisiesto(int anyo) {
        // Para verificar si un año es bisiesto se tiene que verificar esta
        // condición
        return (anyo % 4 == 0) && ((anyo % 100 != 0) || (anyo % 400 == 0));
    }

    @Override
    public String toString()
    {
        return String.format("%d/%d/%d", this.dia, this.mes, this.anio);
    }
    
    
}
