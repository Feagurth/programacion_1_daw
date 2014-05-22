/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import utiles.Mensajes;

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
            Mensajes.mostrarMensaje(ex.getMessage(), "Error", Mensajes.TipoMensaje.ERROR);
            System.exit(0);
        }
    }

    private Resultado actualizar(String[] columnas, String[] tablas, String[] condiciones, String[] valores) {

        assert tablas != null;
        assert valores != null;

        String sql = "";

        Resultado salida;

        try {

            // Si se especifican columnas es una actualización, si no una insercción
            if (columnas != null) {

                // Comprobamos que el registro existe haciendo una select
                salida = consultar(columnas, tablas, condiciones, null);

                // Comprobamos si la operación se ha realizado correctamente
                if (salida.isOperacionCorrecta()) {

                    ResultSetMetaData rsMetaData = salida.getResultado().getMetaData();

                    // Si existen resultados que concuerden con la consulta es una 
                    // actualización
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
                                    case 1:
                                    case 4: {
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
                    salida = new Resultado(false, salida.getMensaje(), null);
                }
            } else {
                // Si no hay columnas a actualizar es una insercción

                // Realizamos una select a la tabla a insertar para poder traer 
                // la estrucutra de columnas
                salida = consultar((new String[]{"*"}), tablas, condiciones, null);

                // Comprobamos si la operación se ha realizado correctamente
                if (salida.isOperacionCorrecta()) {

                    ResultSetMetaData rsMetaData = salida.getResultado().getMetaData();

                    sql += "INSERT INTO";

                    for (String tabla : tablas) {
                        sql += " " + tabla + ", ";
                    }

                    sql = sql.substring(0, sql.length() - 2) + " VALUES(";

                    int numberOfColumns = rsMetaData.getColumnCount();

                    for (int i = 1; i <= numberOfColumns; i++) {
                        switch (rsMetaData.getColumnType(i)) {
                            case 1:
                            case 4: {
                                sql += valores[i - 1] + ", ";
                                break;
                            }

                            case 12: {
                                sql += "'" + valores[i - 1] + "', ";
                                break;
                            }
                        }
                    }

                    sql = sql.substring(0, sql.length() - 2) + ")";

                    salida = new Resultado(db.update(sql) > 0, "", null);
                } else {
                    salida = new Resultado(false, "", null);
                }
            }
        } catch (SQLException ex) {
            salida = new Resultado(false, ex.getMessage(), null);
        }

        return salida;
    }

    private Resultado consultar(String[] columnas, String[] tablas, String[] condiciones, String[] ordenacion) {
        assert tablas != null;
        assert columnas != null;

        Resultado salida;
        String sql = "SELECT";

        for (String columna : columnas) {
            sql += " " + columna + ", ";
        }

        sql = sql.substring(0, sql.length() - 2);

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

    public Resultado actualizarLibro(Libro libro) {
        Resultado salida;
        int[] idAutores = new int[libro.getAutores().length];

        try {
            salida = consultar(
                    new String[]{"isbn"},
                    new String[]{"titulos"},
                    new String[]{"isbn = '" + libro.getIsbn() + "'"},
                    null);

            if (salida.isOperacionCorrecta()) {
                if (salida.getResultado().next()) {
                    // Actualización
                } else {
                    // Insercción
                    salida = actualizar(
                            null,
                            new String[]{"Titulos"},
                            null,
                            new String[]{libro.getIsbn(), libro.getTitulo(), String.valueOf(libro.getNumEdicion()), libro.getEditorial(), libro.getCopyright()});

                    if (salida.isOperacionCorrecta()) {
                        for (String autor : libro.getAutores()) {
                            salida = consultar(
                                    new String[]{"idAutor"},
                                    new String[]{"Autores"},
                                    new String[]{"primerNombre = '" + autor.split(" ")[0] + "'",
                                        "apellidoPaterno = '" + autor.split(" ")[1] + "'"},
                                    null);

                            if (salida.isOperacionCorrecta()) {
                                if (!salida.getResultado().next()) {
                                    salida = actualizar(
                                            null,
                                            new String[]{"Autores"},
                                            null,
                                            new String[]{"0", autor.split(" ")[0], autor.split(" ")[1]});

                                    if (salida.isOperacionCorrecta()) {
                                        salida = consultar(
                                                new String[]{"idAutor"},
                                                new String[]{"Autores"},
                                                new String[]{"primerNombre = '" + autor.split(" ")[0] + "'",
                                                    "apellidoPaterno = '" + autor.split(" ")[1] + "'"},
                                                null);

                                        if (salida.isOperacionCorrecta() && salida.getResultado().next()) {
                                            
                                            ResultSet datos = salida.getResultado();
                                            
                                            idAutores[datos.getRow()-1] = datos.getInt(1);

                                        } else {

                                        }

                                    } else {

                                    }

                                } else {

                                }
                            } else {
                            }
                        }
                    } else {

                    }

                }
            } else {
            }
        } catch (SQLException ex) {
            salida = new Resultado(false, ex.getMessage(), null);
        }
        return salida;

    }

}
