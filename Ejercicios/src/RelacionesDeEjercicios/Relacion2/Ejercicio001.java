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

import Utiles.Mensajes;
import Utiles.PeticionDatos;
import Utiles.Varios;

/**
 * A partir de una fecha introducida por teclado con el formato DÍA, MES, AÑO,
 * implementar en Java un programa donde se obtenga la fecha del día siguiente.
 * Tener en cuenta los años bisiestos.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio001 {

    /**
     * Función para comprobar si un año es bisiesto
     *
     * @param anyo Año a comprobar
     * @return Resultado de la comprobación
     */
    private boolean esAnyoBisiesto(int anyo) {
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
    private boolean esFechaValida(int numdia, int numMes, int numAnyo) {
        int[] dias = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Comprobamos que los valores introducidos sean positivos
        if (numdia <= 0 || numMes <= 0 || numAnyo < 0 || numMes > 12) {
            return false;
        } else {
            // Verificamos si el año es bisiesto y si es febrero
            if (esAnyoBisiesto(numAnyo) && numMes == 2) {
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
     * Ejercicio principal
     */
    public void ejercicio() {

        // Variables
        int dia, mes, anyo;

        // Lectura de datos
        dia = PeticionDatos.pedirEnteroPositivoNoCeroExtendido("Introduzca el día");

        mes = PeticionDatos.pedirEnteroPositivoNoCeroExtendido("Introduzca el mes");

        anyo = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el año");

        // Verificamos si la fecha introducida es válida
        if (esFechaValida(dia, mes, anyo)) {

            // Realizamos acciones segun el mes que sea y el dia en el que estemos
            switch (mes) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                    // Comprobamos si el dia introducido es el último dia del mes
                    if (dia == 31) {
                        // Si lo es empezamos un mes nuevo
                        dia = 1;

                        // Y sumamos uno al mes
                        mes += 1;
                    } else {
                        // Si no es es último día del mes, simplemente
                        // sumamos 1 a los dias                        
                        dia += 1;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    // Mismo proceso que para los meses de 31 dias
                    if (dia == 30) {
                        dia = 1;
                        mes += 1;
                    } else {
                        // Si no es es último día del mes, simplemente
                        // sumamos 1 a los dias                        
                        dia += 1;
                    }
                    break;
                case 12:
                    // Si es el último dia del mes del último mes
                    if (dia == 31) {
                        // Iniiciamos un nuevo año
                        dia = 1;
                        mes = 1;

                        // Sumamos uno al año
                        anyo += 1;
                    } else {
                        // Si no es es último día del mes, simplemente
                        // sumamos 1 a los dias
                        dia += 1;
                    }
                    break;
                case 2:
                {
                    // Verificamos si la fecha introducida pertenece a un año bisiesto.
                    // De ser así inicializamos la variable apoyoBisiesto a 1, para
                    // poder calcular los rangos de fecha en el mes de Febrero
                    int apoyoBisiesto = 0;

                    // Comprobamos si es un año bisiesto
                    if (!esAnyoBisiesto(anyo)) {
                        // Si no es así, cambiamos el valor a 1 para ayudar
                        // en la compración de los dias de Febrero
                        apoyoBisiesto = 1;
                    }

                    // Comprobamos si es el último dia de Febrero
                    if (dia == (29 - apoyoBisiesto)) {

                        // Iniciamos nuevo mes                        
                        dia = 1;

                        // Sumamos uno a los meses
                        mes += 1;
                    } else {
                        // Si no es es último día del mes, simplemente
                        // sumamos 1 a los dias

                        dia += 1;
                    }
                }
                default:
            }

            // Muestra de resultados
            String resultado = "El día siguiente al introducido es: "
                    + Varios.fechaDDMMAAAA(dia, mes, anyo, "/");

            Mensajes.mostrarMensaje(resultado, Mensajes.TipoMensaje.INFORMACION);
        } else {
            // Mostramos mensaje de error
            Mensajes.mostrarMensaje("La fecha intrododucida no es válida",
                    Mensajes.TipoMensaje.ERROR);
        }

    }
}
