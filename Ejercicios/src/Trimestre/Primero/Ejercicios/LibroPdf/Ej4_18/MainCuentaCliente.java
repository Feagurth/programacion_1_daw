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

package Trimestre.Primero.Ejercicios.LibroPdf.Ej4_18;

import Utiles.Mensajes;

/**
 * Clase para realizar el ejercicio 4.18 del libro de texto
 * Como Programar en Java 7ed Deitel
 * @author Luis Cabrerizo Gómez
 */
public class MainCuentaCliente {
    
    public void Ejercicio()
    {
        // Objeto que usaremos para controlar las cuetnas de un cliente
        CuentaCliente cuentaCliente;

        // Objeto que usaremos para pedir y mostrar datos al usuario
        Mensajes mensajes = new Mensajes();
        
        // Variables para almacenar datos que pediremos al usuario
        int numCuenta, saldoInicial, totalArticulos, totalCreditos, limiteCredito;
    
        
        // Pedismos los datos necesarios al usuario
        numCuenta = Integer.parseInt(mensajes.PedirDatos("Introduzca el número "
                + "de cuenta del cliente", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        saldoInicial = Integer.parseInt(mensajes.PedirDatos("Introduzca el saldo "
                + "inicial del cliente", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        totalArticulos = Integer.parseInt(mensajes.PedirDatos("Introduzca el total "
                + "de artículos cargados este mes", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        totalCreditos = Integer.parseInt(mensajes.PedirDatos("Introduzca el total "
                + "de creditos cargados este mes", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
        
        limiteCredito = Integer.parseInt(mensajes.PedirDatos("Introduzca el límite "
                + "de crédito del cliente", "Petición de Datos", 
                Mensajes.TipoMensaje.PREGUNTA));
                
        // Creamos el objeto
        cuentaCliente = new CuentaCliente(numCuenta, saldoInicial, totalArticulos, totalCreditos, limiteCredito);
        
        
        // Comparamos valores y mostramos el resultado correspondiente
        if(cuentaCliente.getSaldoActual() <=  cuentaCliente.getLimitePermitido())
        {
            mensajes.MostrarMensaje("Se excedió el límite de su crédito", 
                    "Inforamción", Mensajes.TipoMensaje.INFORMACION);
        }
        else
        {
            mensajes.MostrarMensaje("Su saldo actual es de: " + 
                    cuentaCliente.getSaldoActual(), "Información", 
                    Mensajes.TipoMensaje.INFORMACION);
        }
    }
}
