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
 * Crear la clase Persona cuya interfaz nos permita: 
 *      a) Almacenar el nombre, laedad de una persona, nivel de estudios y sueldo 
 *          i) Niveles de estudios 
 *              (1) Codificarlo como enumerado 
 *              (2) Valores: ESO, BACHILLERATO, UNIVERSIDAD, DOCTORADO 
 *      b) Mostrar los datos cargados 
 *      c) Indicar si es mayor de edad o no.
 *      d) Si la edad es menor o igual a 28 y el nivel de estudios es mayor 
 *      que tres bien, si la edad es menor de 30 y los ingresos superan los 
 *      28000 euros entonces es un jasp (campo booleano).
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio001 {

    /**
     * Clase para contener los datos de una persona
     */
    public static class Persona {

        /**
         * Enumerador para almacenar el nivel de estudios
         */
        public enum NivelEstudios {

            /**
             * Valor para estudios ESO
             */
            ESO(1), 
            /**
             * Valor para estudios BACHILLERATO
             */
            BACHILLERATO(2), 
            /**
             * Valor para estudios UNIVERSIDAD
             */
            UNIVERSIDAD(3), 
            /**
             * Valor para estudios DOCTORADO
             */
            DOCTORADO(4);
            private final int value;

            /**
             * Constructor del enumerador
             *
             * @param value
             */
            private NivelEstudios(int value) {
                this.value = value;
            }

            /**
             * Devuelve el valor numérico del nivel de estudios especificado
             *
             * @return El valor numérico del nivel de estudios especificado
             */
            public int getValue() {
                return value;
            }
        };

        // Variables de instancia
        private final String nombre;
        private final int edad;
        private final float sueldo;
        private final NivelEstudios nivelEstudios;

        /**
         * Función para devovler el valor del nombre de la persona
         *
         * @return El nombre de la persona
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Función para devolver el valor de la edad de la persona
         *
         * @return La edad de la persona
         */
        public int getEdad() {
            return edad;
        }

        /**
         * Función para devolver el valor del sueldo de la persona
         *
         * @return El sueldo de la persona
         */
        public float getSueldo() {
            return sueldo;
        }

        /**
         * Función para devolver el valor del nivel de estudios de la persona
         *
         * @return El nivel de estudios de la persona
         */
        public NivelEstudios getNivelEstudios() {
            return nivelEstudios;
        }

        /**
         * Función para verificar si una persona es mayor de edad
         *
         * @return
         */
        public boolean esMayorDeEdad() {
            // Devolvemos verdadero si la edad es mayor o igual a 18
            return this.edad >= 18;
        }

        /**
         * Función para verificar si una persona es Joven Aunque Sobradamente
         * Preparado
         *
         * @return Verdadero si lo es, falso si no lo es
         */
        public boolean esJASP() {
            boolean resultado = false;

            // Verificamos si se complen las condiciones
            if (this.edad < 30 && this.sueldo >= 28000) {
                resultado = true;
            }

            // Verificamos si se complen las condiciones
            if (this.edad == 28 && this.nivelEstudios.getValue() > 3) {
                resultado = true;
            }

            // Devolvemos el resultado
            return resultado;
        }

        /**
         * Función para mostrar los datos de la persona
         *
         * @return Una cadena que contiene la información de la persona
         */
        public String mostrarDatosPersona() {
            // Variable para almacenar el resutlado
            String resultado = "";

            // Concatenamos las información antes de devolverla
            resultado += "El nombre de la persona es " + this.nombre;
            resultado += "\nSu edad es " + this.edad;
            resultado += "\nSu nivel de estudios es " + this.nivelEstudios;
            resultado += "\nSu sueldo es de  " + this.sueldo;

            // Devolvemos la información
            return resultado;
        }

        /**
         * Constructor de la clase
         *
         * @param nombre Nombre de la persona
         * @param edad Edad de la persona
         * @param sueldo Sueldo de la persona
         * @param nivelEstudios Nivel de estudios de la persona
         */
        public Persona(String nombre, int edad, float sueldo, NivelEstudios nivelEstudios) {
            this.nombre = nombre;
            this.edad = edad;
            this.sueldo = sueldo;
            this.nivelEstudios = nivelEstudios;
        }
    }

    /**
     * Ejercicio principal
     */
    public void ejercicio() {
        // Petición de datos al usuario
        String nombre = PeticionDatos.pedirCadena("Nombre");

        int edad = PeticionDatos.pedirEnteroPositivoNoCero("Edad");

        float sueldo = (float) PeticionDatos.pedirRealPositivoNoCero("Sueldo");

        Persona.NivelEstudios nivelEstudios;

        switch (PeticionDatos.pedirEnteroRango("Nivel de Estudios [ESO(1), "
                + "BACHILLERATO(2), UNIVERSIDAD(3), DOCTORADO(4)]", 1, 4)) {
            case 1:
                nivelEstudios = Persona.NivelEstudios.ESO;
                break;
            case 2:
                nivelEstudios = Persona.NivelEstudios.BACHILLERATO;
                break;
            case 3:
                nivelEstudios = Persona.NivelEstudios.UNIVERSIDAD;
                break;
            case 4:
                nivelEstudios = Persona.NivelEstudios.DOCTORADO;
                break;
            default:
                nivelEstudios = null;
                break;
        }

        // Creamos el objeto
        Persona persona = new Persona(
                nombre, edad, sueldo, nivelEstudios);

        // Mostramos la información
        Mensajes.mostrarMensaje("Datos de la persona:\n " + 
                persona.mostrarDatosPersona(), "Resultados", 
                Mensajes.TipoMensaje.INFORMACION);

        // Mostramos si es mayor de edad
        Mensajes.mostrarMensaje((persona.esMayorDeEdad()? 
                "Es mayor de edad" : 
                "No es mayor de edad"), 
                "Resultados", Mensajes.TipoMensaje.INFORMACION);        
        
        
        // Mostramos si es JASP
        Mensajes.mostrarMensaje((persona.esJASP()? 
                "Es JASP" : 
                "No es JASP"), 
                "Resultados", Mensajes.TipoMensaje.INFORMACION);        
    }
}
