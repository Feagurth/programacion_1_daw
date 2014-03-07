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

/**
 * Clase para realizar el ejercicio 4.17 del libro de texto Como Programar en
 * Java 7ed Deitel
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio4_17 {

    /**
     * Clase para controlar los repostajes y el consumo en gasolina
     */
    public class Repostajes {

        private final double kms;
        private final double litrosGasolina;
        private final float kmsXLitro;

        /**
         * Nos permite recoger el valor de kms / litro del repostaje
         *
         * @return Los kms recorridos con un litro de gasolina
         */
        public float getKmsXLitro() {
            return kmsXLitro;
        }

        /**
         * Constructor de la clase
         *
         * @param kmsRecorridos Numero de kms recorridos en un repostaje
         * @param litrosGasolinaUsada Litros de gasolina usada en el repostaje
         */
        public Repostajes(double kmsRecorridos, double litrosGasolinaUsada) {
            this.kms = kmsRecorridos;
            this.litrosGasolina = litrosGasolinaUsada;
            this.kmsXLitro = (float) (this.kms / this.litrosGasolina);
        }

    }

    public void Ejercicio() {
        // Variable para controlar el número de reabastecimientos que usaremos
        int numReabastecimientos;
        // Variable para acumular el total de los reabastecimientos
        float total = 0.0f;

        // Variables para introducir los datos necesarios
        double kms, litros;

        // Objeto Mensajes que usaremos para leer datos y mostrar resultados
        Mensajes mensaje = new Mensajes();

        // Creamos el objeto que usaremos
        Repostajes reabastecimiento;

        // Pedimos al usuario en numero de reabastecimientos realizados
        numReabastecimientos = PeticionDatos.pedirEnteroPositivoNoCero("Introduzca el número de reabastecimientos realizados");

        // Iteramos tantas veces como reabastecimientos se hayan realizado
        for (int i = 0; i < numReabastecimientos; i++) {

            // Pedimos el número de kms realizados en cada reabastecimiento
            kms = PeticionDatos.pedirRealPositivoNoCero("Introduzca el número de  kms realizados");

            // Pedimos el número de litros de gasolina consumidos en cada reabastecimiento
            litros = PeticionDatos.pedirRealPositivoNoCero("Introduzca el número de litros consumidos");

            // Creamos una clase nueva con los datos pedidos al usuarios
            reabastecimiento = new Repostajes(kms, litros);

            // Acumulamos el valor de kms por litro extraido de la clase
            total += reabastecimiento.getKmsXLitro();

        }

        // Mostramos el resultado final
        System.out.println("El total de kms/litros es de: " + total);

    }

}
