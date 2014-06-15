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
package datos;

import java.sql.ResultSet;

/**
 * Objeto para almacenar los resultados de las interacciones con la base de
 * datos
 *
 * @author Luis Cabrerizo Gómez
 */
public class Resultado {

    private boolean operacionCorrecta = false;
    private String mensaje;
    private ResultSet resultado;

    /**
     * Función que devuelve si la interacción con la base de datos ha sido
     * correcta
     *
     * @return Verdadero si la operación se ha ejecutado correctamente y falso
     * en el caso contrario
     */
    public boolean isOperacionCorrecta() {
        return operacionCorrecta;
    }

    /**
     * Método que permite especificar si una interacción con la base de datos ha
     * sido correcta
     *
     * @param operacionCorrecta Valor del resultado de la interacción
     */
    public void setOperacionCorrecta(boolean operacionCorrecta) {
        this.operacionCorrecta = operacionCorrecta;
    }

    /**
     * Función que devuelve el mensaje
     *
     * @return El mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Método para asignar un valor al mensaje
     *
     * @param mensaje El mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Función que devuelve el resultado
     *
     * @return El resultado
     */
    public ResultSet getResultado() {
        return resultado;
    }

    /**
     * Método para asignar un valor al resultado
     *
     * @param resultado El resultado
     */
    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    /**
     * Constructor de la clase
     */
    public Resultado() {
    }

    /**
     * Constructor de la clase
     *
     * @param operacionCorrecta Define si la operación se ha realizado
     * correctamente
     * @param mensaje Mensaje de error, aviso o información en relación con el
     * resultado
     * @param resultado Resultado de la consulta a la base de datos
     */
    public Resultado(boolean operacionCorrecta, String mensaje, ResultSet resultado) {
        this.operacionCorrecta = operacionCorrecta;
        this.mensaje = mensaje;
        this.resultado = resultado;
    }

}
