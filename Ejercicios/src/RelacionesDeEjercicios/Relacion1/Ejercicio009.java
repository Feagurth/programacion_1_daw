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
package RelacionesDeEjercicios.Relacion1;

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * Crear una clase para cada poliedro que permita: a) Almacenar la arista b)
 * Calcular el volumen c) Calcular el área
 *
 * Crear un programa de prueba que inicialice poliedros y muestre el área y
 * volumen de cada uno de ellos.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio009 {

    /**
     * Clase para trabajar con tetraedros
     */
    static public class Tetraedro {

        // Variables de instancia
        private final float arista;
        private double area = 0;
        private double volumen = 0;

        /**
         * Función que devuelve el valor de la arista del tetraedro
         *
         * @return El valor de la arista del tetraedro
         */
        public float getArista() {
            return arista;
        }

        /**
         * Función que devuelve el área del tetraedro
         *
         * @return Área del tetraedro
         */
        public double getArea() {
            return area;
        }

        /**
         * Función que devuelve al volumen del tetraedro
         *
         * @return El volumen del tetraedro
         */
        public double getVolumen() {
            return volumen;
        }

        /**
         * Constructor de la clase tetraedro
         *
         * @param arista Arista del tetraedro
         */
        public Tetraedro(float arista) {
            this.arista = arista;
            this.area = Math.pow(arista, 2) * (Math.sqrt(3));
            this.volumen = (Math.pow(arista, 3) * Math.sqrt(2)) / 12;
        }
    }

    /**
     * Clase para trabajar con un cubo
     */
    static public class Cubo {

        // Variables de instancia
        private final float arista;
        private double area = 0;
        private double volumen = 0;

        /**
         * Función que devuelve el valor de la arista del cubo
         *
         * @return El valor de la arista del cubo
         */
        public float getArista() {
            return arista;
        }

        /**
         * Función que devuelve el área del cubo
         *
         * @return Área del tetraedro
         */
        public double getArea() {
            return area;
        }

        /**
         * Función que devuelve al volumen del cubo
         *
         * @return El volumen del cubo
         */
        public double getVolumen() {
            return volumen;
        }

        /**
         * Constructor de la clase cubo
         *
         * @param arista Arista del cubo
         */
        public Cubo(float arista) {
            this.arista = arista;
            this.area = 6 * Math.pow(arista, 2);
            this.volumen = Math.pow(arista, 3);
        }
    }

    /**
     * Clase para trabajar con un octaedro
     */
    static public class Octaedro {

        // Variables de instancia
        private final float arista;
        private double area = 0;
        private double volumen = 0;

        /**
         * Función que devuelve el valor de la arista del octaedro
         *
         * @return El valor de la arista del octaedro
         */
        public float getArista() {
            return arista;
        }

        /**
         * Función que devuelve el área del octaedro
         *
         * @return Área del octaedro
         */
        public double getArea() {
            return area;
        }

        /**
         * Función que devuelve al volumen del octaedro
         *
         * @return El volumen del octaedro
         */
        public double getVolumen() {
            return volumen;
        }

        /**
         * Constructor de la clase octaedro
         *
         * @param arista Arista del octaedro
         */
        public Octaedro(float arista) {
            this.arista = arista;
            this.area = 2 * Math.pow(arista, 2) * Math.sqrt(3);
            this.volumen = ((Math.pow(arista, 3) * Math.sqrt(2)) / 3);
        }
    }

    /**
     * Clase para trabajar con un dodecaedro
     */
    static public class Dodecaedro {

        // Variables de instancia
        private final float arista;
        private double area = 0;
        private double volumen = 0;

        /**
         * Función que devuelve el valor de la arista del dodecaedro
         *
         * @return El valor de la arista del dodecaedro
         */
        public float getArista() {
            return arista;
        }

        /**
         * Función que devuelve el área del dodecaedro
         *
         * @return Área del dodecaedro
         */
        public double getArea() {
            return area;
        }

        /**
         * Función que devuelve al volumen del dodecaedro
         *
         * @return El volumen del dodecaedro
         */
        public double getVolumen() {
            return volumen;
        }

        /**
         * Constructor de la clase dodecaedro
         *
         * @param arista Arista del dodecaedro
         */
        public Dodecaedro(float arista) {
            this.arista = arista;
            this.area = ((3 * Math.pow(arista, 2)
                    * Math.sqrt(25 + (10 * Math.sqrt(5)))));
            this.volumen = ((Math.pow(arista, 3) / 4)
                    * (15 + (7 * Math.sqrt(5))));
        }
    }

    /**
     * Clase para trabajar con un icosaedro
     */
    static public class Icosaedro {

        // Variables de instancia
        private final float arista;
        private double area = 0;
        private double volumen = 0;

        /**
         * Función que devuelve el valor de la arista del icosaedro
         *
         * @return El valor de la arista del icosaedro
         */
        public float getArista() {
            return arista;
        }

        /**
         * Función que devuelve el área del icosaedro
         *
         * @return Área del icosaedro
         */
        public double getArea() {
            return area;
        }

        /**
         * Función que devuelve al volumen del icosaedro
         *
         * @return El volumen del icosaedro
         */
        public double getVolumen() {
            return volumen;
        }

        /**
         * Constructor de la clase icosaedro
         *
         * @param arista Arista del icosaedro
         */
        public Icosaedro(float arista) {
            this.arista = arista;

            this.area = (5 * arista * Math.sqrt(3));
            this.volumen = (((5 * Math.pow(arista, 3) / 12)
                    * (3 + Math.sqrt(5))));
        }
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        String resultado = "";

        // Petición de datos al usuario
        float arista = (float) PeticionDatos.pedirRealPositivoNoCero("Introduzca"
                + " el valor de la arista de los polígonos");

        // Objetos
        Tetraedro tetra = new Tetraedro(arista);
        Cubo cubo = new Cubo(arista);
        Octaedro octa = new Octaedro(arista);
        Dodecaedro dode = new Dodecaedro(arista);
        Icosaedro ico = new Icosaedro(arista);

        // Datos del tetraedro
        resultado += "Tetraedro";
        resultado += "\nArea : " + tetra.getArea();
        resultado += "\nVolumen : " + tetra.getVolumen();

        // Datos del cubo
        resultado += "\n\nCubo";
        resultado += "\nArea : " + cubo.getArea();
        resultado += "\nVolumen : " + cubo.getVolumen();

        // Datos del octaedro
        resultado += "\n\nOctaedro";
        resultado += "\nArea : " + octa.getArea();
        resultado += "\nVolumen : " + octa.getVolumen();

        // Datos del dodecaedro
        resultado += "\n\nDodecaedro";
        resultado += "\nArea : " + dode.getArea();
        resultado += "\nVolumen : " + dode.getVolumen();

        // Datos del icosaedro
        resultado += "\n\nIcosaedro";
        resultado += "\nArea : " + ico.getArea();
        resultado += "\nVolumen : " + ico.getVolumen();

        Mensajes.mostrarMensaje(resultado, Mensajes.TipoMensaje.INFORMACION);
    }
}
