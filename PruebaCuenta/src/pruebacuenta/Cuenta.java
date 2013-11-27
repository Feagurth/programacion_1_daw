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

package pruebacuenta;

/**
 * Clase para controlar una cuenta bancaria
 * @author Luis Cabrerizo Gómez
 */
public class Cuenta {
    
    private double saldo;
        
    /**
     * Constructor de la clase
     * @param saldoInicial Saldo inicial de la cuenta
     */
    public Cuenta(double saldoInicial)
    {
        if(saldoInicial > 0)
        {
            saldo = saldoInicial;    
        }
        else
        {
            saldo = 0;
        }
    }

    /**
     * Aumenta el saldo de la cuenta
     * @param cantidad Valor de la cantidad a abonar
     */
    public void Abonar(double cantidad)
    {
        saldo += cantidad;
    }
    
    /**
     * Disminuye el saldo de la cuenta
     * @param cantidad Valor de la cantidad a retirar
     */
    public void Retirar(double cantidad)
    {
        saldo -= cantidad;    
    }
    
    /**
     * Devuelve el valor actual del saldo
     * @return valor actual del saldo
     */
    public double obtenerSaldo(){        
        return saldo;
    }

}
