/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Super
 */
public class BaseDeDatos {

    DBAccess db;

    public BaseDeDatos(String usuario, String password, String db_path, String database) {
        try {
            db = new DBAccess(usuario, password, db_path, database);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Resultado actualizar(String sql) {
        Resultado salida;
        try {
            salida = new Resultado((db.update(sql) == 1), "", null);
        } catch (SQLException e) {
            salida = new Resultado(false, "", null);
        }
        return salida;
    }

    public Resultado actualizar(String[] columnas, String[] tablas, String[] condiciones, String[] valores) {

        assert tablas != null;
        assert valores != null;

        String sql = "";

        Resultado salida;

        try {
            // Comprobamos que el registro existe haciendo una select
            salida = consultar(columnas, tablas, condiciones, null);

            // Comprobamos si la operación se ha realizado correctamente
            if (salida.isOperacionCorrecta()) {

                ResultSetMetaData rsMetaData = salida.getResultado().getMetaData();

                // Si existen resultados que concuerden con la consulta es una 
                // actualización
                if (salida.getResultado() != null){

                    sql += "UPDATE";

                    for (String tabla : tablas) {
                        sql += " " + tabla + ", ";
                    }

                    sql = sql.substring(0, sql.length() - 2) + " SET ";

                    int numberOfColumns = rsMetaData.getColumnCount();

                    for (int j = 0; j < columnas.length; j++) {
                        for (int i = 1; i <= numberOfColumns; i++) {
                            if (rsMetaData.getColumnName(i).equals(columnas[j])) {
                                switch (rsMetaData.getColumnType(i)) {
                                    case 1: {
                                        sql += columnas[j] + " = " + valores[j];
                                        break;
                                    }

                                    case 12: {
                                        sql += columnas[j] + " = '" + valores[j] + "'";
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    if (condiciones != null) {
                        sql += " WHERE";
                        for (String condicion : condiciones) {
                            sql += " " + condicion + " AND";
                        }

                        sql = sql.substring(0, sql.length() - 4);
                    }

                    salida = new Resultado(db.update(sql) > 0, "", null);

                } else {
                    // Si no hay resultados es un insert

                    sql += "INSERT INTO";

                    for (String tabla : tablas) {
                        sql += " " + tabla + ", ";
                    }

                    sql = sql.substring(0, sql.length() - 2) + " VALUES (";

                    int numberOfColumns = rsMetaData.getColumnCount();

                    for (int j = 0; j < columnas.length; j++) {
                        for (int i = 1; i <= numberOfColumns; i++) {
                            if (rsMetaData.getColumnName(i).equals(columnas[j])) {
                                switch (rsMetaData.getColumnType(i)) {
                                    case 1: {
                                        sql += valores[j] + ", ";
                                        break;
                                    }

                                    case 12: {
                                        sql += "'" + valores[j] + "', ";
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    sql = sql.substring(0, sql.length() - 2);

                    salida = new Resultado(db.update(sql) > 0, "", null);
                }
            } else {
                salida = new Resultado(false, salida.getMensaje(), null);
            }
        } catch (SQLException ex) {
            salida = new Resultado(false, ex.getMessage(), null);
        }

        return salida;
    }

    public Resultado consultar(String[] columnas, String[] tablas, String[] condiciones, String[] ordenacion) {
        assert tablas != null;

        Resultado salida;
        String sql = "SELECT";

        if (columnas == null) {
            sql += " * ";
        } else {
            for (String columna : columnas) {
                sql += " " + columna + ", ";
            }

            sql = sql.substring(0, sql.length() - 2);
        }

        sql += " FROM";

        for (String tabla : tablas) {
            sql += " " + tabla + ", ";
        }

        sql = sql.substring(0, sql.length() - 2);

        if (condiciones != null) {
            sql += " WHERE";

            for (String condicion : condiciones) {
                sql += " " + condicion + " AND";
            }

            sql = sql.substring(0, sql.length() - 4);
        }

        if (ordenacion != null) {
            sql += " ORDER BY";

            for (String orden : ordenacion) {
                sql += " " + orden + " AND";
            }

            sql = sql.substring(0, sql.length() - 4);
        }

        try {
            salida = new Resultado(true, "", db.query(sql));
        } catch (SQLException ex) {
            salida = new Resultado(false, ex.getMessage(), null);
        }

        return salida;

    }

}
