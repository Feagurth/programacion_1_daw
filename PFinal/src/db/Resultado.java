/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.ResultSet;

/**
 *
 * @author Super
 */
public class Resultado {

    private boolean operacionCorrecta = false;
    private String mensaje;
    private ResultSet resultado;

    public boolean isOperacionCorrecta() {
        return operacionCorrecta;
    }

    public void setOperacionCorrecta(boolean operacionCorrecta) {
        this.operacionCorrecta = operacionCorrecta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ResultSet getResultado() {
        return resultado;
    }

    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }
    
    public Resultado() {
    }

    public Resultado(boolean operacionCorrecta, String mensaje, ResultSet resultado) {
        this.operacionCorrecta = operacionCorrecta;
        this.mensaje = mensaje;
        this.resultado = resultado;
    }

}
