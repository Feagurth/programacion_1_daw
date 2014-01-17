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

/**
 * Confeccionar una clase que represente un empleado. Nos interesa recoger su 
 * nombre, sueldo y  turno (mañana o tarde). Confeccionar una interfaz que 
 * nos permita: 
 * a) Inicializar datos 
 * b) Imprimir sus datos 
 * c) Saber si debe pagar impuestos (si el sueldo supera a 3000) 
 * Suponer que hay una empresa que tiene 8 trabajadores, realizar además 
 * un programa que permita saber el gasto en el sueldo por turnos, sabiendo que:
 *  Hay dos turnos: Mañana y Tarde
 *  La empresa tiene 4 trabajadores por la mañana y 4 por la tarde

 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio004 {
    
    public class Empleado
    {
        // Variables de instancia
        String nombre;
        float sueldo;
        char turno;

        /**
         * Función que nos devuelve el nombre del empleado
         * @return El nombre del empleado
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Función que nos devuelve el sueldo del empleado
         * @return El sueldo del empleado
         */
        public float getSueldo() {
            return sueldo;
        }

        /**
         * Función que nos devuelve el turno del empleado
         * @return M: Mañana T: Tarde
         */
        public char getTurno() {
            return turno;
        }
      
        /**
         * Constructor de la clase
         * @param nombre
         * @param sueldo
         * @param turno 
         */
        public Empleado(String nombre, float sueldo, char turno) {
            this.nombre = nombre;
            this.sueldo = sueldo;
            this.turno = turno;
        }
        
        /**
         * Función para devolver los datos del empleado
         * @return Los datos del empleado
         */
        public String imprimirDatos()
        {
            // Creamos una variable para acumular los datos y la inicializados
            String resultado = "";

            // Concatenamos los datos del empleado
            resultado += "Nombre: " + this.nombre;
            resultado += "\nTurno: " + (this.turno == 'm' || this.turno == 'M' 
                    ? "Mañana" : "Tarde");
            
            resultado += "\nSueldo: " + this.sueldo;

            // Devolvemos el resultado
            return resultado;
        }
    
        /**
         * Función que nos indica si el empleado debe pagar impuestos
         * @return Verdadero si debe pagar impuestos, falso si no debe pagarlos
         */
        public boolean pagaImpuestos()
        {
            return this.sueldo > 3000;
        }

    }
    
    
    public void Ejercicio()
    {
        Empleado empleado1 = new Empleado("Manolo", 2500, 'M');
        Empleado empleado2 = new Empleado("Jose", 3500, 't');
        
        System.out.println(empleado1.imprimirDatos());
        System.out.println(empleado1.pagaImpuestos() == true 
                ? "Paga Impuestos" : "No Paga Impuestos");
        
        
        System.out.println(empleado2.imprimirDatos());
        System.out.println(empleado2.pagaImpuestos() == true 
                ? "Paga Impuestos" : "No Paga Impuestos");
        
    }
}
