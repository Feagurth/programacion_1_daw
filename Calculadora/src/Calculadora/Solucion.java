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
package Calculadora;

/**
 * Clase para almacenar la solución de una operación con calculadora
 *
 * @author Super
 */
public class Solucion {

    // Variable para el resultado
    private String resultado;

    // Variables para mensajes varios
    private String mensaje;

    /**
     * Método para recuperar el resultado a una solución
     *
     * @return Resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Método para asignar un resultado a una solución
     *
     * @param resultado Resultado
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * Método para recuperar el mensaje generado en la solución
     *
     * @return Mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Método para asignar un mensaje a una solución
     *
     * @param mensaje Mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Constructor base de la clase
     */
    public Solucion() {
    }

    /**
     * Constructor de la clase
     *
     * @param resultado Resultado de las operaciones
     * @param mensaje Mensajes a mostrar al usuario
     */
    public Solucion(String resultado, String mensaje) {
        this.resultado = resultado;
        this.mensaje = mensaje;
    }

}
