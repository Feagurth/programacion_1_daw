/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
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

    public Resultado actualizar(String[] columnas, String[] tablas, String[] condiciones, String[] valores) {

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
                                        sql += columnas[j] + " = " + valores[j] + ", ";
                                        break;
                                    }

                                    case 12: {
                                        sql += columnas[j] + " = '" + valores[j] + "', ";
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    sql = sql.substring(0, sql.length() - 2);

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

    public Resultado consultar(String[] columnas, String[] tablas, String[] condiciones, String[] ordenacion, int[] limites) {

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

            if (!sql.contains("GROUP")) {
                sql += " WHERE";
            }
            else
            {
                sql+= " HAVING";
            }

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

        if (limites != null) {
            sql += " LIMIT";

            for (int limite : limites) {
                sql += " " + limite + ", ";
            }

            sql = sql.substring(0, sql.length() - 2);

        }

        try {
            salida = new Resultado(true, "", db.query(sql));
        } catch (SQLException ex) {
            salida = new Resultado(false, ex.getMessage(), null);
        }

        return salida;

    }

    public Resultado consultar(String[] columnas, String[] tablas, String[] condiciones, String[] ordenacion) {
        assert tablas != null;
        assert columnas != null;

        return consultar(columnas, tablas, condiciones, ordenacion, null);

    }

    public Resultado eliminar(String[] tablas, String[] condiciones) {
        assert condiciones != null;

        Resultado salida;
        String sql = "";

        sql += "DELETE FROM";

        for (String tabla : tablas) {
            sql += " " + tabla + ", ";
        }

        sql = sql.substring(0, sql.length() - 2);

        sql += " WHERE";

        for (String condicion : condiciones) {
            sql += " " + condicion + " AND";
        }

        sql = sql.substring(0, sql.length() - 4);

        try {
            salida = new Resultado(db.update(sql) > 0, "", null);
        } catch (SQLException ex) {
            salida = new Resultado(false, ex.getMessage(), null);
        }

        return salida;
    }

    public String consultaNombreAutor(String[] idAutor) {

        String salida = "";

        try {

            for (String autor : idAutor) {

                Resultado datos = consultar(
                        new String[]{"Concat(primerNombre, ' ', apellidoPaterno) as Nombre"},
                        new String[]{"autores"},
                        new String[]{"idAutor = " + autor}, null);

                if (datos.isOperacionCorrecta() && datos.getResultado().next()) {
                    salida += datos.getResultado().getString("Nombre") + ", ";
                }
            }

            salida = salida.substring(0, salida.length() - 2);
        } catch (SQLException ex) {
            salida = "";
        }

        return salida;
    }

    public Resultado actualizarLibro(Libro libro) {
        Resultado salida;

        salida = actualizar(
                new String[]{"isbn", "titulo", "numeroEdicion", "editorial", "copyright"},
                new String[]{"titulos"},
                new String[]{"isbn = " + libro.getIsbn()},
                new String[]{
                    libro.getIsbn(),
                    libro.getTitulo(),
                    String.valueOf(libro.getNumEdicion()),
                    libro.getEditorial(),
                    libro.getCopyright()});

        if (salida.isOperacionCorrecta()) {
            salida = eliminar(
                    new String[]{"isbnautor"},
                    new String[]{"isbn = " + libro.getIsbn()});

            if (salida.isOperacionCorrecta()) {
                for (String idAutor : libro.getAutores()) {
                    salida = actualizar(
                            null,
                            new String[]{"isbnautor"},
                            null,
                            new String[]{idAutor, libro.getIsbn()});

                    if (!salida.isOperacionCorrecta()) {
                        salida = new Resultado(false, salida.getMensaje(), null);
                        break;
                    }
                }

                if (!salida.isOperacionCorrecta()) {
                    salida = eliminar(new String[]{"titulos"}, new String[]{"isbn = " + libro.getIsbn()});
                    if (salida.isOperacionCorrecta()) {
                        salida = new Resultado(false, "Error al actualizar los autores del libro", null);
                    }
                }

            } else {
                salida = new Resultado(false, salida.getMensaje(), null);
            }

        } else {
            salida = new Resultado(false, salida.getMensaje(), null);
        }

        return salida;

    }

    public Resultado insertarLibro(Libro libro) {
        Resultado salida;

        salida = actualizar(
                null,
                new String[]{"titulos"},
                null,
                new String[]{
                    libro.getIsbn(),
                    libro.getTitulo(),
                    String.valueOf(libro.getNumEdicion()),
                    libro.getEditorial(),
                    libro.getCopyright()});

        if (salida.isOperacionCorrecta()) {

            for (String idAutor : libro.getAutores()) {

                salida = actualizar(
                        null,
                        new String[]{"isbnautor"},
                        null,
                        new String[]{idAutor, libro.getIsbn()});

                if (!salida.isOperacionCorrecta()) {
                    break;
                }
            }

            if (!salida.isOperacionCorrecta()) {
                salida = eliminar(new String[]{"titulos"}, new String[]{"isbn = " + libro.getIsbn()});
                if (salida.isOperacionCorrecta()) {
                    salida = new Resultado(false, "Error al insertar los autores del libro", null);
                }
            }
        } else {
            salida = new Resultado(false, "Error al insertar el libro", null);
        }

        return salida;
    }

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnLabel(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
}
