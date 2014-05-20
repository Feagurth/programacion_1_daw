/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Super
 */
public class BaseDeDatos {

    

    /**
     * Tipos de validaciones que se pueden llevar a cabo
     */
    public enum TipoValidacion {

        /**
         * Valor para cadena
         */
        SELECT_TODO_AUTORES("SELECT * FROM AUTORES"),
        SELECT_TODO_ISBNAUTOR("SELECT * FROM ISBNAUTOR"),
        SELECT_TODO_TITULOS("SELECT * FROM TITULOS"),
        UPDATE_AUTORES("");
        

        private final String value;

        public String getValue() {
            return value;
        }
        
        private TipoValidacion(String value) {
            this.value = value;
        }
    }
    
    DBAccess db;

    public BaseDeDatos(String usuario, String password, String db_path, String database) {
        try {
            db = new DBAccess(usuario, password, db_path, database);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Resultado actualizar(String sql) {
        Resultado salida = new Resultado();
        salida.setOperacionCorrecta(true);

        try {
            salida.setOperacionCorrecta((db.update(sql) == 1));
        } catch (SQLException e) {
            salida.setMensaje(e.getMessage());
            salida.setOperacionCorrecta(false);
        }
        return salida;
    }
    
    public Resultado consultar(TipoValidacion sentencia)
    {
        Resultado salida = new Resultado();
        salida.setOperacionCorrecta(true);
        
        try {
            salida.setResultado(db.query(sentencia.getValue()));
            
        } catch (SQLException e) {
            salida.setOperacionCorrecta(false);
            salida.setMensaje(e.getMessage());
            salida.setResultado(null);
        }
        
        return salida;    
    }

}
