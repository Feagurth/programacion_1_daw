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
package RelacionesDeEjercicios.Relacion2;

import java.util.Scanner;

/**
 * Elaborar un programa que reciba una fecha por teclado –dd, mm, aaaa-, así
 * como el día de la semana que fue el primero de enero de dicho año, y muestre
 * por pantalla el día de la semana que corresponde a la fecha que le hemos
 * dado. En la resolución deben considerarse los años bisiestos.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio002 {

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

    /**
     * Función para comprobar si una fecha es válida
     *
     * @param numdia Día
     * @param numMes Mes
     * @param numAnyo Año
     * @return Resultado de la comprobación
     */
    private boolean EsFechaValida(int numdia, int numMes, int numAnyo) {
        int[] dias = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Comprobamos que los valores introducidos sean positivos
        if (numdia <= 0 || numMes <= 0 || numAnyo < 0 || numMes > 12) {
            return false;
        } else {
            // Verificamos si el año es bisiesto y si es febrero
            if (EsAnyoBisiesto(numAnyo) && numMes == 2) {
                // Devolvemos la comprobación de si el dia está en los dias
                // que tiene el mes mas 1 dia por ser bisiesto Febrero                
                return numdia <= (dias[numMes - 1] + 1);
            } else {
                // Devolvemos la comprobación de si el dia está en los dias
                // que tiene el mes
                return numdia <= dias[numMes - 1];
            }
        }
    }

    /**
     * Función para calcular el día de la semana a partir de una fecha usando la
     * congruencia de Zeller
     *
     * @param diaSel Día seleccionado
     * @param mesSel Mes seleccionado
     * @param anyoSel Año Seleccionado
     * @param tipoCalendario Tipo de calendario, Juliano o Gregoriano
     * @return El día de la semana
     */
    private String DiaSemana(int diaSel, int mesSel, int anyoSel, char tipoCalendario) {
        // Variables
        int d, m, y, temporal;
        String resultado = null;

        // Calculamos los valores de apoyo
        d = (14 - mesSel) / 12;
        y = anyoSel - d;
        m = mesSel + (12 * d) - 2;

        // Dependiendo del tipo de calendario, realizaremos unas operaciones u otras
        if (tipoCalendario == 'j') {
            temporal = (5 + diaSel + y + (y / 4) + ((31 * m) / 12)) % 7;
        } else {
            temporal = (diaSel + y + (y / 4) - (y / 100) + (y / 400) + ((31 * m) / 12)) % 7;
        }

        // El valor numérico obtenido se puede extrapolar a una cadena de texto
        // correspondiente a los dias de la semana
        switch (temporal) {
            case 0:
                resultado = "Domingo";
                break;
            case 1:
                resultado = "Lunes";
                break;
            case 2:
                resultado = "Martes";
                break;
            case 3:
                resultado = "Miercoles";
                break;
            case 4:
                resultado = "Jueves";
                break;
            case 5:
                resultado = "Viernes";
                break;
            case 6:
                resultado = "Sabado";
                break;
        }

        // Devolvemos el resultado
        return resultado;
    }

    public void Ejercicio() {
        // Objeto para recibir información desde el teclado
        Scanner entrada = new Scanner(System.in);

        // Variables
        int dia, mes, anyo;
        String calendario;
        String resultado;

        do {
            // Petición de datos al usuario
            System.out.print("Introduzca el valor numérico para el día: ");
            dia = entrada.nextInt();

            System.out.print("Introduzca el valor numérico para el mes: ");
            mes = entrada.nextInt();

            System.out.print("Introduzca el valor numérico para el año: ");
            anyo = entrada.nextInt();
        } while (!EsFechaValida(dia, mes, anyo));

        calendario = "";
        do {
            calendario = entrada.nextLine().toLowerCase();
            System.out.print("\n¿Calendario Juliano o Gregoriano? (j/g): ");
        } while (!"j".equals(calendario) && !"g".equals(calendario));

        // Calculamos el valor del día de la semana
        resultado = DiaSemana(dia, mes, anyo, calendario.charAt(0));

        // Mostramos la información al usuario
        System.out.printf("\nEl %s/%s/%d fue %s\n", (dia < 9 ? "0" : "") + dia, (mes < 9 ? "0" : "") + mes, anyo, resultado);

    }
}
