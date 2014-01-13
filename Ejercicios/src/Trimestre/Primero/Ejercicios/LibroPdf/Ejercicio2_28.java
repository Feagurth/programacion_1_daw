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

package Trimestre.Primero.Ejercicios.LibroPdf;

import java.util.Scanner;

/**
 * He aquí un adelanto. En este capítulo, aprendió sobre los enteros y el 
 * tipo int. Java también puede representar números de punto flotante que 
 * contienen puntos decimales, como 3.14159. Escriba una aplicación que reciba 
 * del usuario el radio de un círculo como un entero, y que imprima el 
 * diámetro, la circunferencia y el área del círculo mediante el uso del valor 
 * de punto flotante 3.14159 para π. Use las técnicas que se muestran en la 
 * figura 2.7. [Nota: también puede utilizar la constante predefi nida Math.PI 
 * para el valor de π. Esta constante es más precisa que el valor 3.14159.
 * La clase Math se define en el paquete java.lang. Las clases en este paquete 
 * se importan de manera automática, por lo que no necesita importar la clase 
 * Math mediante la instrucción import para usarla]. Use las siguientes 
 * fórmulas (r es el radio):
 *                              diámetro = 2r
 *                              circunferencia = 2πr
 *                              área = πr 2
 * 
 * No almacene los resultados de cada cálculo en una variable. En vez de ello, 
 * especifique cada cálculo como el valor que se imprimirá en una instrucción 
 * System.out.printf. Observe que los valores producidos por los cálculos del 
 * área y la circunferencia son números de punto flotante. 
 * 
 * Dichos valores pueden imprimirse con el especificador de formato %f en una 
 * instrucción System.out.printf. En el capítulo 3 aprenderá más acerca de los 
 * números de punto flotante.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio2_28 {
    
    public void Ejercicio()
    {    
       // Declaración de variables
        int radio;
        Scanner entrada = new Scanner(System.in);
        
        // Recogida de datos iniciales
        System.out.print("Introduzca el valor del radio: ");
        radio = entrada.nextInt();
    
        // Se muestra el valor del diametro
        System.out.printf("El diametro es: %d", 2 * radio );
        System.out.println("");
        
        // Se muestra el valor de la circunferencia
        System.out.printf("La circunferencia es: %.2f", 2 * Math.PI * radio );
        System.out.println("");
        
        // Se muestra el valor de la circunferencia
        System.out.printf("El area es: %.2f", Math.PI * (Math.pow(radio, 2))); 
        System.out.println("");                
    }
    
}
