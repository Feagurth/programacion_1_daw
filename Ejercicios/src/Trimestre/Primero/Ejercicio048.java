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

package Trimestre.Primero;

import ejercicios.Mensajes;

/**
 * Algoritmo que reciba una fecha por teclado dd, mm, aaaa, así como el día de 
 * la semana que fue el primero de enero de dicho año, y muestre por pantalla 
 * el día de la semana que corresponde a la fecha que le hemos dado. En 
 * la resolución deben considerarse los años bisiestos.
 * Se resolverá usando la congruencia de Zeller.
 * @author Luis Cabrerizo Gómez
 */
public class Ejercicio048 {
    
    public void ejercicio()
    {
        // Objeto para pedir y mostrar datos al usuario
        Mensajes msg = new Mensajes();
        
        // Variables
        int dia, mes, anyo;
        char calendario;
        String resultado;
        
        // Petición de datos al usuario
        dia = Integer.parseInt(msg.PedirDatos("Introduzca el valor numérico para el día", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        mes = Integer.parseInt(msg.PedirDatos("Introduzca el valor numérico para el mes", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));

        anyo = Integer.parseInt(msg.PedirDatos("Introduzca el valor numérico para el año", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA));
        
        calendario = msg.PedirDatos("¿Calendario Juliano o Gregoriano? (j/g)", 
                "Petición de Datos", Mensajes.TipoMensaje.PREGUNTA).toLowerCase().charAt(0);
        
        
        // Calculamos el valor del día de la semana
        resultado = DiaSemana(dia, mes, anyo, calendario);
        
        // Mostramos la información al usuario
        msg.MostrarMensaje("El dia " + dia + "/" + mes + "/" + anyo + " fue " + 
                resultado, "Resultado", Mensajes.TipoMensaje.INFORMACION);
        

    }
    
    
    /**
     * Función para calcular el día de la semana a partir de una fecha usando la
     * congruencia de Zeller
     * @param diaSel Día seleccionado
     * @param mesSel Mes seleccionado
     * @param anyoSel Año Seleccionado
     * @param tipoCalendario Tipo de calendario, Juliano o Gregoriano
     * @return El día de la semana
     */
    private String DiaSemana(int diaSel, int mesSel, int anyoSel, char tipoCalendario)
    {
        // Variables
        int d, m, y, temporal;
        String resultado = null;
  
        // Calculamos los valores de apoyo
        d = (14 - mesSel) / 12;
        y = anyoSel - d;
        m = mesSel + (12 * d) - 2;
        
        
        // Dependiendo del tipo de calendario, realizaremos unas operaciones u otras
        if(tipoCalendario == 'j')
        {
            temporal = (5 + diaSel + y + (y / 4) + ((31 * m)/12)) %7;
        }
        else
        {
            temporal = (diaSel + y + (y/4) - (y / 100) + (y/400) + ((31 * m) / 12)) % 7;
        }
    
        // El valor numérico obtenido se puede extrapolar a una cadena de texto
        // correspondiente a los dias de la semana
        switch(temporal)
        {
            case 1: resultado  = "Lunes"; break;
            case 2: resultado  = "Martes"; break;
            case 3: resultado  = "Miercoles"; break;
            case 4: resultado  = "Jueves"; break;
            case 5: resultado  = "Viernes"; break;
            case 6: resultado  = "Sabado"; break;
            case 7: resultado  = "Domingo"; break;
        }
        
        // Devolvemos el resultado
        return resultado;
    }
    
}
