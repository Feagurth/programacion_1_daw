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
 * Math.floor puede utilizarse para redondear un número hasta un lugar decimal
 * específico. La instrucción y = Math.floor(x * 10 + 0.5)/10; Redondea x en la
 * posición de las décimas (es decir, la primera posición a la derecha del punto
 * decimal. La instrucción Redondea x en la posición de las centésimas (es
 * decir, la segunda posición a la derecha del punto decimal). Escribe una
 * aplicación que defina cuatro métodos para redondear un número x en varias
 * formas: 
 * a) redondearAInteger( numero ) 
 * b) redondearADecimas( numero ) 
 * c) redondearACentesimas( numero ) 
 * d) redondearAMilesimas ( numero ) 
 * Para cada valor leído, el programa debe mostrar el valor original, el número 
 * redondeado al entero más cercano, el número redondeado a la décima más 
 * cercana, el número redondeado a la centésima más cercana y el número 
 * redondeado a la milésima más cercana.
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio007 {

    /**
     * Función para realizar el redondeo de un número
     *
     * @param numero Número que queremos redondear
     * @param decimales Cantidad de decimales que tendrá el redondeo
     * @return Valor redondeado con los parámetros introducidos
     */
    private double Redondeo(double numero, int decimales) {
        // Variables
        double resultado;
        int parteEntera, parteDecimal;
        int apoyoDecimales;

        numero = precalculoRedondeo(numero, decimales);
        
        
        // Calculamos el valor por el que tendremos que multiplicar
        // los decimales para conseguir la parte entera del redondeo que
        // queremos
        apoyoDecimales = (int) Math.pow(10, decimales);

        // Calculamos la parte entera, obteniendo la división del número 
        // entre 1
        parteEntera = (int) (numero / 1);

        // Calculamos la parte decimal restandole al número la parte entera
        // Despues, multiplicamos el valor obtenido por el apoyo de decimales,
        // quedandonos la parte que queremos para el redondeo como la parte 
        // entera del numero obtenido, la cual conseguimos dividiendo ese
        // número entre 1
        parteDecimal = (int) ((numero - parteEntera) * apoyoDecimales) / 1;
       
        // Creamos una cadena con el número de la parte entera concatenado 
        // junto con un punto y la parte decimal, y parseamos la cadena
        // para obtener el resultado en float
        resultado = Double.parseDouble(parteEntera + "." + parteDecimal);

        // Devolvemos el resultado
        return resultado;
    }

    /**
     * Función que permite devolver un numero sin decimales
     * @param valor Valor a convertir
     * @return numero sin decimales
     */
    public int redondearAInteger(double valor) {
        return (int) Redondeo(valor, 0);
    }

    /**
     * Función que permite devolver un numero un decimal
     * @param valor Valor a convertir
     * @return numero con un decimal
     */
    public double redondearADecimas(double valor) {
        return Redondeo(valor, 1);
    }

    /**
     * Función que permite devolver un numero dos decimales
     * @param valor Valor a convertir
     * @return numero con dos decimales
     */
    public double redondearACentesimas(double valor) {
        return Redondeo(valor, 2);
    }

    /**
     * Función que permite devolver un numero tres decimales
     * @param valor Valor a convertir
     * @return numero con tres decimales
     */
    public double redondearAMilesimas(double valor) {
        return Redondeo(valor, 3);
    }

    public void Ejercicio() {
        
        // Objeto para leer datos desde el teclado
        Scanner entrada = new Scanner(System.in);
        
        // Variables
        double valor;
        
        // Pedimos datos al usuario
        System.out.print("Introduzca un valor decimal (0 para salir): ");
        valor = entrada.nextDouble();
        do {

            // Mostramos la información a través de las funciones wrappers de la
            // función redondeo
            System.out.printf("Original: %s\n0 Dec: %s\n1 Dec: %s\n2 Dec: %s\n3 Dec: %s\n", 
                    String.valueOf(valor), 
                    String.valueOf(redondearAInteger(valor)),
                    String.valueOf(redondearADecimas(valor)),
                    String.valueOf(redondearACentesimas(valor)),
                    String.valueOf(redondearAMilesimas(valor)));
            
            // Volvemos a pedir datos
            System.out.print("Introduzca un valor decimal (0 para salir): ");
            valor = entrada.nextFloat();
        } while (valor != 0);
    }

    private double precalculoRedondeo(double numero, int decimales) {
        
        numero = numero * (Math.pow(10, (decimales+1)));
        
        if((int)(numero % 10) > 5)
        {
            numero += 10;
        }
        
        numero = numero / (Math.pow(10, (decimales+1)));
        
        return numero;
    }
}
