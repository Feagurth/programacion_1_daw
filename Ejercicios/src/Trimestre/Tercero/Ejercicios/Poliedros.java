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
package Trimestre.Tercero.Ejercicios;

import Utiles.Mensajes;
import Utiles.PeticionDatos;

/**
 * Intefaz para la clase poliedro
 *
 * @author Luis Cabrerizo Gómez
 */
interface InterfazPoliedros {

    /**
     * Método para calcular el área del poliedro
     *
     * @return El área del poliedro
     */
    double area();

    /**
     * Método para calcular el volumen del poliedro
     *
     * @return El volumen del poliedro
     */
    double volumen();

    /**
     * Método para devolver los valores de la clase como una cadena de texto
     *
     * @return Cadena de texto con los valores de la clase
     */
    @Override
    String toString();
}

/**
 * Clase abstracta para calcular áreas y volúmenes de poliedro
 *
 * @author Luis Cabrerizo Gómez
 */
abstract class Poliedro implements InterfazPoliedros {

    final double arista;

    /**
     * Devuelve el valor de la arista del poliedro
     *
     * @return El valor de la arista del poliedro
     */
    public double getArista() {
        return arista;
    }

    /**
     * Constructor de la clase poliedro
     *
     * @param arista Valor de la arista del poliedro
     */
    public Poliedro(double arista) {
        this.arista = arista;
    }

    /**
     * Método para calcular el área del poliedro
     *
     * @return El área del poliedro
     */
    @Override
    public abstract double area();

    /**
     * Método para calcular el volumen del poliedro
     *
     * @return El volumen del poliedro
     */
    @Override
    public abstract double volumen();

    /**
     * Método para devolver los valores de la clase como una cadena de texto
     *
     * @return Cadena de texto con los valores de la clase
     */
    @Override
    public String toString() {
        return String.format("%s: %,.2f%n%s: %,.2f%n%s: %,.2f%n",
                "Arista", getArista(), "Área", area(), "Volumen", volumen());
    }
}

/**
 * Clase para representar un Tetraedro mediante herencia
 *
 * @author Luis Cabrerizo Gómez
 */
class Tetraedro extends Poliedro {

    /**
     * Constructor de la clase tetraedro
     *
     * @param arista Valor de la arista del tetraedro
     */
    public Tetraedro(double arista) {
        super(arista);
    }

    /**
     * Función que calcula el área de tetraedro
     *
     * @return Devuelve el área del tetraedro
     */
    @Override
    public double area() {
        return (Math.pow(getArista(), 2) * Math.sqrt(3));
    }

    /**
     * Calcula el volumen del tetraedro
     *
     * @return Devuelve el volumen del tetraedro
     */
    @Override
    public double volumen() {
        return ((Math.pow(getArista(), 3)) * (Math.sqrt(2) / 12));
    }

    /**
     * Método para devolver los valores de la clase como una cadena de texto
     *
     * @return Cadena de texto con los valores de la clase
     */
    @Override
    public String toString() {
        return String.format("%s%n%s", "Tetraedro", super.toString());
    }

}

/**
 * Clase para representar un Cubo mediante herencia
 *
 * @author Luis Cabrerizo Gómez
 */
class Cubo extends Poliedro {

    /**
     * Constructor de la clase cubo
     *
     * @param arista Arista del cubo
     */
    public Cubo(double arista) {
        super(arista);
    }

    /**
     * Método para calcular el área del cubo
     *
     * @return El área del cubo
     */
    @Override
    public double area() {
        return (6 * Math.pow(super.getArista(), 2));
    }

    /**
     * Método para calcular el volumen del cubo
     *
     * @return El volumen del cubo
     */
    @Override
    public double volumen() {
        return (Math.pow(super.getArista(), 3));
    }

    /**
     * Método para devolver los valores de la clase como una cadena de texto
     *
     * @return Cadena de texto con los valores de la clase
     */
    @Override
    public String toString() {
        return String.format("%s%n%s", "Cubo", super.toString());
    }

}

/**
 * Clase para representar un Octaedro mediante herencia
 *
 * @author Luis Cabrerizo Gómez
 */
class Octaedro extends Poliedro {

    /**
     * Constructor de la clase octaedro
     *
     * @param arista Valor de la arista del octaedro
     */
    public Octaedro(double arista) {
        super(arista);
    }

    /**
     * Método para calcular el área del octaedro
     *
     * @return El área del octaedro
     */
    @Override
    public double area() {
        return (2 * Math.pow(super.getArista(), 2) * Math.sqrt(3));
    }

    /**
     * Método para calcular el volumen del octaedro
     *
     * @return El volumen del octaedro
     */
    @Override
    public double volumen() {
        return ((Math.pow(super.getArista(), 3) * Math.sqrt(2)) / 3);
    }

    /**
     * Método para devolver los valores de la clase como una cadena de texto
     *
     * @return Cadena de texto con los valores de la clase
     */
    @Override
    public String toString() {
        return String.format("%s%n%s", "Octaedro", super.toString());
    }

}

/**
 * Clase para representar un Dodecaedro mediante herencia
 *
 * @author Luis Cabrerizo Gómez
 */
class Dodecaedro extends Poliedro {

    /**
     * Constructor de la clase Dodecaedro
     *
     * @param arista Arista del dodecaedro
     */
    public Dodecaedro(double arista) {
        super(arista);
    }

    /**
     * Método para calcular el área del dodecaedro
     *
     * @return El área del dodecaedro
     */
    @Override
    public double area() {
        return (3 * Math.pow(super.getArista(), 2) * Math.sqrt(25 + (10 * Math.sqrt(5))));
    }

    /**
     * Método para calcular el volumen del dodecaedro
     *
     * @return
     */
    @Override
    public double volumen() {
        return (Math.pow(super.getArista(), 3) / 4) * (15 + (7 * Math.sqrt(5)));
    }

    /**
     * Método para devolver los valores de la clase como una cadena de texto
     *
     * @return Cadena de texto con los valores de la clase
     */
    @Override
    public String toString() {
        return String.format("%s%n%s", "Dodecaedro", super.toString());
    }

}

/**
 * Clase para representar un Icosaedro mediante herencia
 *
 * @author Luis Cabrerizo Gómez
 */
class Icosaedro extends Poliedro {

    /**
     * Constructor de la clase Icosaedro
     *
     * @param arista Arista del icosaedro
     */
    public Icosaedro(double arista) {
        super(arista);
    }

    /**
     * Método para calcular el área del icosaedro
     *
     * @return El área del icosaedro
     */
    @Override
    public double area() {
        return (5 * super.getArista() * Math.sqrt(3));
    }

    /**
     * Método para calcular el volumen del icosaedro
     *
     * @return El volumen del icosaedro
     */
    @Override
    public double volumen() {
        return (((5 * Math.pow(super.getArista(), 3) / 12) * (3 + Math.sqrt(5))));
    }

    /**
     * Método para devolver los valores de la clase como una cadena de texto
     *
     * @return Cadena de texto con los valores de la clase
     */
    @Override
    public String toString() {
        return String.format("%s%n%s", "Icosaedro", super.toString());
    }
}

/**
 * Clase para calcular el área y volumen de diversos poliedros
 *
 * @author Luis Cabrerizo Gómez
 */
public class Poliedros {

    /**
     * Ejercicio principal
     */
    public void ejercicio() {

        // Declaramos una variable para almacenar el resultado de las operaciones
        String resultado = "";

        // Pedimos el valor de la arista al usuario y la almacenamos 
        // en una variable
        int arista = PeticionDatos.
                pedirEnteroPositivoNoCero("Introduzca el valor de la arista");

        // Creamos objetos para cada uno de los poliedro que vamos a calcular
        Poliedro tetra = new Tetraedro(arista);
        Poliedro cubo = new Cubo(arista);
        Poliedro octa = new Octaedro(arista);
        Poliedro dode = new Dodecaedro(arista);
        Poliedro ico = new Icosaedro(arista);

        // Concatenamos los resultados en la variable a tal efecto
        resultado += tetra.toString() + "\n";
        resultado += cubo.toString() + "\n";
        resultado += octa.toString() + "\n";
        resultado += dode.toString() + "\n";
        resultado += ico.toString() + "\n";

        // Mostramos el resultado al usuario
        Mensajes.mostrarMensaje(resultado, "Resultado", Mensajes.TipoMensaje.INFORMACION);

    }

}
