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
package RelacionesDeEjercicios.Relacion3;

import java.util.Scanner;

/**
 * (Sistemas de reserva de una aerolínea). Una pequeña aerolínea acaba de
 * comprar una computadora para su nueva sistema de reservas automatizado. Se te
 * ha pedido que desarrolles el nuevo sistema. Escribirás una aplicación para
 * asignar asientos en cada vuelo del único avión de la aerolínea (capacidad: 10
 * asientos). Tu aplicación debe mostrar las siguientes alternativas: 
 * 
 *      Por favor escriba 1 para Primera clase 
 *      Por favor escriba 2 para Económico 
 * 
 * Si el usuario escribe 1, tu aplicación debe asignarle un asiento en la 
 * sección de primera clase (asientos 1 a 5). Si el suaurio escribe 2, tu 
 * aplicación debe asignarle un asiento en la sección económica 
 * (asientos 6 a 10). Tu aplicación deberá enonces imprimir un pase de abordaje, 
 * indicando el número de asiento de la persona y si se encuentra en la sección 
 * de primera clase o clase económica del avión.
 *
 * Utiliza un array unidimensional del tipo primitivo boolean para representar
 * la tabla de asientos del avión. Inicializa todos los elementos del array con
 * false para idnicar que todos los asientos están vacións. A medida que se
 * asigne cada asiento, establece ls elementos correndientes del array en true
 * para indicar que ese asiento ya no está disponible.
 *
 * Tu aplicación nunca deberá asignar un asiento que haya sido asignado. Cuando
 * esté llena la sección económica, tu programa deberá preguntar a la persona si
 * acepta ser colocada en la sección de primera clase (y viceversa). Si la
 * persona acepta, haz la asignación de asiento apropiada. Si no acepta, imprime
 * el mensaje "El próximo vuelo sale en 3 horas"
 *
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio010 {

    public void Ejercicio() {

        // OBjeto para pedir información por el teclado
        Scanner entrada = new Scanner(System.in);
        
        // Array para contener la disponibilidad de los asientos del avion
        boolean[] asientosAvion = new boolean[10];
        
        // Inicializamos el array poniendo todas sus posiciones a false
        // simulando que todos los asientos están vacios
        for (int i = 0; i < asientosAvion.length; i++) {
            asientosAvion[i]= false;            
        }
        
        
        
        
        
        
    }

}
