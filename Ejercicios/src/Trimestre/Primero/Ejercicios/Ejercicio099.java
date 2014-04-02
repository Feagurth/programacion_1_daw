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
package Trimestre.Primero.Ejercicios;

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * Una fábrica de muebles tiene 16 representantes que viajan por toda España
 * ofreciendo sus productos. Para tareas administrativas el país está dividido
 * en cinco zonas: Norte, Sur, Este, Oeste y Centro. Mensualmente almacena sus
 * datos y obtiene distintas estadísticas sobre el comportamiento de sus
 * representantes en cada zona. Se desea hacer un programa que lea los datos de
 * todos los representantes con sus ventas en cada zona y calcule el total de
 * ventas de una zona introducida por teclado, el total de ventas de un vendedor
 * introducido por teclado en cada una de las zonas y el total de ventas de un
 * día y para cada uno de los representantes.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio099 {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Variable para almacenar el número de representantes
        final int N_REPRE = 16;

        // Variable para almacenar el número de zonas
        final int N_ZONAS = 5;

        // Variable para almacenar el número de días
        final int N_DIAS = 31;

        // Array para almacenar los datos de los representantes en un mes
        Double[][][] matrizValores = new Double[N_REPRE][N_ZONAS][N_DIAS];

        // Array para almacenar el los nombres de las zonas
        String[] arrayZonas = new String[]{"Norte", "Sur", "Este", "Oeste", "Centro"};

        // Array para almacenar el nombre de los representantes
        String[] arrayRepresentantes;

        // Variable para almacenar las opciones en el menú
        int opcionMenu;

        // Leemos los nombres de los representantes
        arrayRepresentantes = leerRepresentantes(N_REPRE);

        do {
            opcionMenu = pintarMenu();

            switch (opcionMenu) {
                case 1:
                    matrizValores = leerDatos(arrayZonas, arrayRepresentantes,
                            N_DIAS);
                    break;
                case 2:
                    ventasXZona(matrizValores, arrayZonas);
                    break;
                case 3:
                    ventasXRepresentante(matrizValores, arrayRepresentantes);
                    break;
                case 4:
                    ventasXDia(matrizValores);
                    break;
                default:
                    break;
            }

        } while (opcionMenu != 5);
    }

    /**
     * Función para calcular las ventas de un representante
     *
     * @param valores Matriz con los valores de ventas por representante, zona y
     * día
     * @param nombreRepresentantes Array con los nombre de un representante
     */
    private void ventasXRepresentante(Double[][][] valores, String[] nombreRepresentantes) {

        // Variables
        int control = 0;
        String repreSel;
        Double totalRepre = 0.0;

        // Petición de datos al usuario
        repreSel = Mensajes.pedirDatos("Introduzca el nombre del representante a evaluar",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA);

        // Buscamos la posición de la zona seleccionada 
        if (repreSel != null) {
            for (int i = 0; i <= nombreRepresentantes.length - 1; i++) {
                if (nombreRepresentantes[i].trim().equalsIgnoreCase(repreSel.trim())) {
                    control = i;
                }
            }

       // Contabilizamos todos los valores de esa parte de la matriz para calcular
            // el total de ventas para una zona
            for (int i = 0; i <= valores[0].length - 1; i++) {
                for (int j = 0; j <= valores[0][0].length - 1; j++) {
                    totalRepre += valores[control][i][j];
                }
            }

            // Mostramos los resultados 
            Mensajes.mostrarMensaje("El total para el representante " + repreSel + " es: "
                    + totalRepre, "Resultados", Mensajes.TipoMensaje.INFORMACION);
        }
    }

    /**
     * Función para calcular el total de ventas de un día
     *
     * @param valores Matriz con los valores de ventas por representante, zona y
     * día
     */
    private void ventasXDia(Double[][][] valores) {
        // Variables
        String diaSel;
        Double totalDia = 0.0;

        // Petición de datos al usuario
        diaSel = Mensajes.pedirDatos("Introduzca el día a evaluar",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA);

        if (diaSel != null) {
            // Contabilizamos todos los valores de esa parte de la matriz para calcular
            // el total de ventas para una zona
            for (int i = 0; i <= valores.length - 1; i++) {
                for (int j = 0; j <= valores[0].length - 1; j++) {
                    totalDia += valores[i][j][Integer.parseInt(diaSel) - 1];
                }
            }

            // Mostramos los resultados 
            Mensajes.mostrarMensaje("El total para el día " + diaSel + " es: "
                    + totalDia, "Resultados", Mensajes.TipoMensaje.INFORMACION);
        }
    }

    /**
     * Metodo para calcular las ventas por zona introducida y mostrar el
     * resultado al usuario
     *
     * @param valores Matriz con los valores de ventas por representante, zona y
     * dia
     * @param nombreZonas Array con el nombre de las zonas
     */
    private void ventasXZona(Double[][][] valores, String[] nombreZonas) {
        // Variables
        int control = 0;
        String zonaSel;
        Double totalZona = 0.0;

        // Petición de datos al usuario
        zonaSel = Mensajes.pedirDatos("Introduzca el nombre de la zona a evaluar",
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA);

        // Buscamos la posición de la zona seleccionada 
        if (zonaSel != null) {
            for (int i = 0; i <= nombreZonas.length - 1; i++) {
                if (nombreZonas[i].trim().equalsIgnoreCase(zonaSel.trim())) {
                    control = i;
                }
            }

            // Contabilizamos todos los valroes de esa parte de la matriz para calcular
            // el total de ventas para una zona
            for (int i = 0; i <= valores.length - 1; i++) {
                for (int j = 0; j <= valores[0][0].length - 1; j++) {
                    totalZona += valores[i][control][j];
                }
            }

            // Mostramos los resultados 
            Mensajes.mostrarMensaje("El total de la zona " + zonaSel + " es: " + totalZona,
                    "Resultados", Mensajes.TipoMensaje.INFORMACION);
        }
    }

    private Double[][][] leerDatos(String[] nombresZonas, String[] nombresRepresentantes, int numDias) {
        // Variable para almacenar los resultados de la toma de datos
        Double[][][] resultado = new Double[nombresRepresentantes.length][nombresZonas.length][numDias];

        // Iteramos para preguntar los datos de cada representante en cada zona
        // y los almacenamos en la variable de resultado
        for (int i = 0; i <= nombresRepresentantes.length - 1; i++) {
            for (int j = 0; j <= nombresZonas.length - 1; j++) {
                for (int k = 0; k <= numDias - 1; k++) {
                    resultado[i][j][k] = PeticionDatos.pedirRealPositivo("Introduzca "
                            + "las ventas de " + nombresRepresentantes[i] + " para "
                            + "la zona " + nombresZonas[j] + " el día " + (k + 1));
                }
            }
        }
        return resultado;
    }

    /**
     * Función que nos permite mostrar un menú al usuario y recoger su respuesta
     *
     * @return La opción seleccionada por el usuario
     */
    private int pintarMenu() {

        // Encadenamos el mensaje a mostrar al usuario
        String mensaje = "1.- Lectura de datos\n";
        mensaje += "2.- Total de ventas por zona\n";
        mensaje += "3.- Total de ventas por representante\n";
        mensaje += "4.- Total de ventas por dia\n";
        mensaje += "5.- Salir";

        // Mostramos el menú y pedimos que introduzca una opción
        return Integer.parseInt(Mensajes.pedirDatos(mensaje, "Opciones de Menú",
                Mensajes.TipoMensaje.PLANO));
    }

    /**
     * Función que nos permite recoger los nombres de los representantes
     *
     * @param num_representantes Número de representantes a leer
     * @return array de cadena con los nombres de los representantes
     */
    private String[] leerRepresentantes(int num_representantes) {
        String[] resultado = new String[num_representantes];

        // Iteramos para almacenar los nombres que introduzca el usuario en el 
        // array a devolver
        for (int i = 1; i <= num_representantes; i++) {
            resultado[i - 1] = Mensajes.pedirDatos("Introduzca el nombre del "
                    + "representante número " + i, "Petición de datos",
                    Mensajes.TipoMensaje.PREGUNTA);
        }

        // Devolvemos el resultado
        return resultado;
    }
}
