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
package pruebacraps;

import java.util.Random;

/**
 * Clase para jugar a CRAPS http://es.wikipedia.org/wiki/Craps
 *
 * @author Luis Cabrerizo Gómez
 */
public class Craps {

    // Objeto para generar números aleatorios
    private final Random numerosAleatorios = new Random();

    /**
     * Función para tirar los dados de CRAPS
     *
     * @return Devuelve la suma de la tirada de dos dados
     */
    private int tirarDados() {

        // Variables
        int dado1;
        int dado2;
        int suma;

        // Lanzamiento de dados
        dado1 = numerosAleatorios.nextInt(6) + 1;
        dado2 = numerosAleatorios.nextInt(6) + 1;

        // Realizamos la suma de los resultados
        suma = dado1 + dado2;

        // Impresión de datos por pantalla
        System.out.println("El jugador ha sacado: " + dado1 + " " + dado2
                + " = " + suma);

        // Devolvemos el resultado
        return suma;
    }

    /**
     * Enumerador para controlar el estado del juego
     */
    private enum Estado {

        CONTINUA, GANO, PIERDO
    };

    // Definición de constantes
    private final static int DOS_UNOS = 2;
    private final static int TRES = 3;
    private final static int SIETE = 7;
    private final static int ONCE = 11;
    private final static int DOCE = 12;

    /**
     * Método para jugar al CRAPS
     */
    public void Jugar() {
        // Variables
        int miPunto = 0;
        int sumaDados;
        Estado estadoJuego;

        // Tiramos los dados
        sumaDados = tirarDados();

        // Comprobamos la tirada de dados
        switch (sumaDados) {
            // Si la suma es 7 u 11 el jugador gana
            case SIETE:
            case ONCE: {
                // Establecemos el estado del juego como ganado
                estadoJuego = Estado.GANO;
                break;
            }
            // Si la suma es 2, 3 o 11, el jugador pierde
            case DOS_UNOS:
            case TRES:
            case DOCE: {
                // Establecemos el estado del juego como perdido
                estadoJuego = Estado.PIERDO;
                break;
            }
            // Si no, guardamos la puntuación
            default: {

                // Establecemos el estado del juego como continuar
                estadoJuego = Estado.CONTINUA;
                miPunto = sumaDados;
                System.out.println("La puntuación es: " + miPunto);
            }
        }

        // Mientras no se gane o pierda el juego, realizamos el bucle
        while (estadoJuego == Estado.CONTINUA) {

            // Tiramos los dados de nuevo
            sumaDados = tirarDados();

            // Si la tirada de dados es igual a la puntuación de la primera
            // tirada se gana el juego
            if (sumaDados == miPunto) {
                // Establecemos el estado del juego como ganado
                estadoJuego = Estado.GANO;
            } else {
                // Si no, tenemos que comprobar que la tirada no sea 7
                // en cuyo caso se pierde el juego
                if (sumaDados == SIETE) {
                    // Establecemos el estado del juego como perdido
                    estadoJuego = Estado.PIERDO;
                }
            }
        }

        // Una vez acabadas las jugadas y teniendo el juego ganado o perdido
        // mostramos el resultado al usuario dependiendo del estado del juego
        if (estadoJuego == Estado.GANO) {
            System.out.println("El jugador ha ganado");
        } else {
            System.out.println("El jugador ha perdido");
        }

    }

}
