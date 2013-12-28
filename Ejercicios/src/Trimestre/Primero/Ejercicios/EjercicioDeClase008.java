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

/**
 * Crear un algoritmo para calcule el área y el volumen de poliedros. 
 * Usar un sistema de menús.
 * @author Luis Cabrerizo Gómez
 */
public class EjercicioDeClase008 {
    
    /**
     * Ejercicio principal
     */
    public void ejercicio(){
        int opcion;
        
        // Iteramos hasta que leamos el valor de salida
        do {            
            // Mostramos el menú y recogemos la opcion selecionada
            opcion = MostrarMenu();
            
            if (opcion >= 1 && opcion <= 5 ) {
                // Realizamos las operaciones necesarias
                operaciones(opcion);
            }
        } while (opcion != 6);
   }

    /**
     * Función que engloba las operaciones del programa
     * @param valorOpciones El tipo de poliedro seleccionado
     */
    private void operaciones(int valorOpciones)
    {
        // Objeto para mostrar y tomar datos del usuario
        Mensajes msg = new Mensajes();
    
        // Variables
        Double arista, volumen = null, area = null;
        String tipoPoliedro = null;
    
        // Petición de datos de usuario
        do
        {
            arista = Double.parseDouble(msg.PedirDatos("Introduzca un valor para la "
                    + "arista", "Petición de Datos", Mensajes.TipoMensaje.INFORMACION));
        }
        while(arista <= 0);
        
        // Realizamos operaciones dependiendo de la opción elegida
        switch(valorOpciones)
        {
            case 1:
                area = areaTetraedro(arista);
                volumen = volumenTetraedro(arista);
                tipoPoliedro = "tetraedro";
                break;
            case 2:
                area = areaCubo(arista);
                volumen = volumenCubo(arista);
                tipoPoliedro = "cubo";
                break;                
            case 3:
                area = areaOctaedro(arista);
                volumen = volumenOctaedro(arista);
                tipoPoliedro = "octaedro";
                break;

            case 4:
                area = areaDodecaedro(arista);
                volumen = volumenDodecaedro(arista);
                tipoPoliedro = "dodecaedro";
                break;
            case 5 : 
                area = areaIcosaedro(arista);
                volumen = volumenIcosaedro(arista);
                tipoPoliedro = "icosaedro";
                break;                
        }
        

        // Muestra de resultados    
        msg.MostrarMensaje("El area de un " + tipoPoliedro + " de arista " + 
                arista + " es de " + area + "\nEl volumen de un " + tipoPoliedro 
                + " de arista " + arista + " es de " + volumen, 
                "Resultado", Mensajes.TipoMensaje.INFORMACION);
            
        
    }    
    
    /**
     * Método para mostrar un menú al usuario y recoger opciones
     * @return Opción elegida
     */
    private int MostrarMenu(){
        // Objeto para la recogida y muestra de información al usuario
        Mensajes msg = new Mensajes();
        
        // Variable
        String mensaje;
        int resultado = 0;
        
        mensaje =  "1.- TETRAEDRO\n";
        mensaje += "2.- CUBO\n";
        mensaje += "3.- OCTAEDRO\n";
        mensaje += "4.- DODECAEDRO\n";
        mensaje += "5.- ICOSAEDRO\n";
        mensaje += "6.- SALIR\n";
        
        do{            
            resultado = Integer.parseInt(msg.PedirDatos(mensaje, "POLIEDROS", 
                    Mensajes.TipoMensaje.PREGUNTA));
        }while (resultado > 6 || resultado < 1) ;
        
        return resultado;
    }    
    
    /**
     * Función que nos calcula el área de un tetraedro
     * @param valorArista
     * @return 
     */
    private Double areaTetraedro(Double valorArista){
        return (Math.pow(valorArista, 2) * Math.sqrt(3));
    }
        
    /**
     * Función para calcular el volumen de un tetraedro
     * @param valorArista Valor de la arista
     * @return Volumen del tetraedro
     */
    private Double volumenTetraedro(Double valorArista){
        return ((Math.pow(valorArista, 3)) * (Math.sqrt(2) / 12));
    }            
    
    /**
     * Función para calcular el área de un cubo
     * @param valorArista
     * @return 
     */
    private Double areaCubo(Double valorArista){
        return (6 * Math.pow(valorArista, 2));
    }
        
    /**
     * Función para calcular el volumen de un cubo
     * @param valorArista Valor de la arista
     * @return Volumen del cubo
     */
    private Double volumenCubo(Double valorArista){
        
        return (Math.pow(valorArista,3));    
    }    
    
    /**
     * Función para calcular el área de un Octaedro
     * @param valorArista Valor de la arista del octaedro
     * @return Área del octaedro
     */
    private Double areaOctaedro(Double valorArista){
        return (2 * Math.pow(valorArista, 2) * Math.sqrt(3));
    }    
    
    /**
     * Función para calcular el volumen de un octaedro
     * @param valorArista Valor de la arista de octaedro
     * @return Volumen del octaedro
     */
    private Double volumenOctaedro(Double valorArista){    
        return ((Math.pow(valorArista, 3) * Math.sqrt(2))/3);    
    }    
    
    /**
     * Función para calcular el área de un dodecaedro
     * @param valorArista Valor de la arista del dodecaedro
     * @return Área del dodecaedro
     */
    private Double areaDodecaedro(Double valorArista)
    {
        return (3 * Math.pow(valorArista, 2) * Math.sqrt(25 + (10 * Math.sqrt(5))));
    }
      
    /**
     * Función para calcular el volumen de un dodecaedro
     * @param valorArista Valor de la arista del dodecaedro
     * @return Volumen del dodecaedro
     */
    private Double volumenDodecaedro(Double valorArista){
        
        return (Math.pow(valorArista, 3) /4) * (15 + (7 * Math.sqrt(5)));
    }
        
    /**
     * Función que nos calcula el área de un icosaedro
     * @param valorArista valor de la arista del icosaedro
     * @return  Área del icosaedro
     */
    private Double areaIcosaedro(Double valorArista)
    {
        return (5 * valorArista * Math.sqrt(3));
    }
        
    /**
     * Función para calcular el volumen de un icosaedro
     * @param valorArista Valor de la arista del icosaedro
     * @return Volumen del icosaedro
     */
    private Double volumenIcosaedro(double valorArista)
    {
        return (((5 * Math.pow(valorArista, 3)/12) * (3 + Math.sqrt(5))));
    }        
}
