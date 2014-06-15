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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import utiles.Mensajes;

/**
 * Clase para trabajar con bases de datos, en este caso, específica de libros
 *
 * @author Luis Cabrerizo Gómez
 */
public class BaseDeDatos {

    DBAccess db;

    /**
     * Constructor de la clase
     *
     * @param usuario Usuario de acceso a la base de datos
     * @param password Contraseña de acceso a la base de datos
     * @param db_path Ruta de la base de datos
     * @param database Nombre de la base de datos a la que se conectará
     */
    public BaseDeDatos(String usuario, String password, String db_path, String database) {
        try {

            // Creamos un nuevo objecto DBAccess con los parámetros del método
            db = new DBAccess(usuario, password, db_path, database);
        } catch (ClassNotFoundException | SQLException ex) {

            // Si se produce una excepción, mostramos el mensaje de error y
            // salimos del programa, puesto que no tenedremos acceso a la base
            // de datos
            Mensajes.mostrarMensaje(ex.getMessage(), "Error", Mensajes.TipoMensaje.ERROR);
            System.exit(0);
        }
    }

    /**
     * Función para insertar y actualizar valores en una tabla
     *
     * @param columnas Columnas a actualizar. Si no se especifican columnas se
     * realizará una inserción de los valores
     * @param tablas Tablas en las que se van a actualizar los valores
     * @param condiciones Condiciones sobre las cuales se van a actualizar los
     * valores
     * @param valores Valores a actualizar o insertar
     * @return Devuelve un objeto Resultado con los datos relevantes de la
     * operación
     */
    public Resultado actualizar(String[] columnas, String[] tablas, String[] condiciones, String[] valores) {

        // Asertos
        assert tablas != null;
        assert valores != null;

        // Iniciamos la cadena donde va a crearse la cadena sql a ejecutarse
        String sql = "";

        // Declaramos una variable de salida
        Resultado salida;

        try {

            // Si se especifican columnas es una actualización, si no una insercción
            if (columnas != null) {

                // Comprobamos que el registro existe haciendo una select
                salida = consultar(columnas, tablas, condiciones, null);

                // Comprobamos si la operación se ha realizado correctamente
                if (salida.isOperacionCorrecta()) {

                    // Si existen resultados que concuerden con la consulta es una 
                    // actualización
                    sql += "UPDATE";

                    // Iteramos por el array de tablas del parámetro concatenandolas
                    // a la cadena sql
                    for (String tabla : tablas) {
                        sql = sql.concat(" ").concat(tabla).concat(", ");
                    }

                    // Quitamos los dos últimos caracteres para eliminar la coma
                    // sobrante y concatenamos el comando SET
                    sql = sql.substring(0, sql.length() - 2) + " SET ";

                    // Recuperamos los metadatos de la consulta, para poder identificar
                    // el tipo de dato que hay que introducir en cada campo
                    ResultSetMetaData rsMetaData = salida.getResultado().getMetaData();

                    // Calculamos el número de columnas para iterar por ellas
                    int numberOfColumns = rsMetaData.getColumnCount();

                    // Iteramos tantas veces como columnas tengamos en el parámetro 
                    // de columnas
                    for (int j = 0; j < columnas.length; j++) {

                        // Iteramos tanas veces como columnas haya en el resultado
                        // de la consulta anterior
                        for (int i = 1; i <= numberOfColumns; i++) {

                            // Si el nombre de la columna en la que iteramos
                            // es igual al nombre de la columna de la iteración
                            // del parámetro tenemos una coincidencia
                            if (rsMetaData.getColumnName(i).equals(columnas[j])) {

                                // Comprobamos el tipo de columa y construimos 
                                // la cadena sql en consecuencia concatenando
                                // el nombre de la columna y el valor correspondiente
                                // con el formato adecuado
                                switch (rsMetaData.getColumnType(i)) {
                                    case 1:
                                    case 4: {
                                        sql = sql.concat(columnas[j]).concat(" = ").concat(valores[j]).concat(", ");
                                        break;
                                    }

                                    case 12: {
                                        sql = sql.concat(columnas[j]).concat(" = '").concat(valores[j].replace("'", "''")).concat("', ");
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    // Limpiamos los dos últimos caracteres de la concatenación
                    sql = sql.substring(0, sql.length() - 2);

                    // Si se han especificado condiciones
                    if (condiciones != null) {

                        // Concatenamos WHERE
                        sql += " WHERE";

                        // E iteramos por el array de condiciones concatenandolas
                        for (String condicion : condiciones) {
                            sql = sql.concat(" ").concat(condicion).concat(" AND");
                        }

                        // Limpiamos los últimos 4 caracteres
                        sql = sql.substring(0, sql.length() - 4);
                    }

                    // Lanzamos una actualización a la base de datos con la
                    // cadena sql generada y almacenamos el resultado de la 
                    // operación en un objeto Resultado que asignamos a la 
                    // variable salida
                    salida = new Resultado(db.update(sql) > 0, "", null);

                } else {

                    // Si la operación no es correcta o se ha producido un error
                    // creamos un objeto resultado con los valores correspondientes
                    // y lo asignamos a la variable salida
                    salida = new Resultado(false, salida.getMensaje(), null);
                }
            } else {
                // Si no hay columnas a actualizar es una insercción
                // Realizamos una select a la tabla a insertar para poder traer 
                // la estrucutra de columnas
                salida = consultar((new String[]{"*"}), tablas, condiciones, null);

                // Comprobamos si la operación se ha realizado correctamente
                if (salida.isOperacionCorrecta()) {

                    // Concatenamos INSERT INTO a la variable sql para empezar
                    // a genera la sentencia correspondiente
                    sql += "INSERT INTO";

                    // Iteramos por el vector de tablas de los parámetros y 
                    // concatenamos los valores que contiene
                    for (String tabla : tablas) {
                        sql = sql.concat(" ").concat(tabla).concat(", ");
                    }

                    // Limpiamos los dos últimos carácteres y concatenamos VALUES(
                    // para seguir generando la cadena
                    sql = sql.substring(0, sql.length() - 2) + " VALUES(";

                    // Recuperamos los metadatos de la consulta, para poder identificar
                    // el tipo de dato que hay que introducir en cada campo
                    ResultSetMetaData rsMetaData = salida.getResultado().getMetaData();

                    // Recuperamos el número de columnas y lo almacenamos
                    int numberOfColumns = rsMetaData.getColumnCount();

                    // Iteramos por las columnas que tiene la consulta
                    for (int i = 1; i <= numberOfColumns; i++) {

                        // Comprobamos el tipo de datos que tiene la columna 
                        // y concatenamos los valores como corresponda
                        switch (rsMetaData.getColumnType(i)) {
                            case 1:
                            case 4: {

                                sql = sql.concat(valores[i - 1]).concat(", ");
                                break;
                            }

                            case 12: {
                                sql = sql.concat("'").concat(valores[i - 1].replace("'", "''")).concat("', ");
                                break;
                            }
                            default: {
                            }
                        }
                    }

                    // Limpiamos los dos últimos caracteres de la conatenación
                    // y añadimos el paréntesis de cierre
                    sql = sql.substring(0, sql.length() - 2) + ")";

                    // Lanzamos una actualización a la base de datos con la
                    // cadena sql generada y almacenamos el resultado de la 
                    // operación en un objeto Resultado que asignamos a la 
                    // variable salida                    
                    salida = new Resultado(db.update(sql) > 0, "", null);
                } else {
                    // Si la operación no es correcta o se ha producido un error
                    // creamos un objeto resultado con los valores correspondientes
                    // y lo asignamos a la variable salida                    
                    salida = new Resultado(false, salida.getMensaje(), null);
                }
            }
        } catch (SQLException ex) {
            // Si se produce una excepción, creamos el objeto resultado
            // correspondiente y lo asignamos a la variable de salida
            salida = new Resultado(false, ex.getMessage(), null);
        }

        // Devolvemos el resultado
        return salida;
    }

    /**
     * Función para realizar una consulta a una base de datos
     *
     * @param columnas Columnas a consultar
     * @param tablas Tablas a consultar
     * @param condiciones Condiciones de la consulta
     * @param ordenacion Ordenación de los resultados de la consulta
     * @param limites Limites de la consulta
     * @return Objeto Resultado con los datos de la consulta realizada
     */
    public Resultado consultar(String[] columnas, String[] tablas, String[] condiciones, String[] ordenacion, int[] limites) {

        // Asertos
        assert tablas != null;
        assert columnas != null;

        // Creamos un objeto Resultado
        Resultado salida;

        // Inicializamos la variable sql
        String sql = "SELECT";

        // Iteramos por las columnas concatenando sus valores
        for (String columna : columnas) {
            sql = sql.concat(" ").concat(columna).concat(", ");
        }

        // Limpiamos los dos últimos caracteres de la concatenación
        sql = sql.substring(0, sql.length() - 2);

        // Le añadimos el FROM
        sql += " FROM";

        // Iteramos por las tablas concatenando sus valores
        for (String tabla : tablas) {
            sql = sql.concat(" ").concat(tabla).concat(", ");
        }

        // Limpiamos los dos últimos caracteres de la concatenación
        sql = sql.substring(0, sql.length() - 2);

        // Comprobamos si hay condiciones en los parámetros
        if (condiciones != null) {

            String apoyo = "";

            // Iteramos por las condiciones concatenando sus valores
            for (String condicion : condiciones) {

                // Comprobamos que la condición no sea un caracter vacio
                // proviniente de los filtros de los informes
                if (!condicion.equals("")) {
                    apoyo = apoyo.concat(" ").concat(condicion).concat(" AND");
                }

            }

            // Si tenemos valores para filtrar, las concatenamos a la sql
            if (!apoyo.equals("")) {

                // Comprobamos si la cadena sql contiene una agrupación
                if (!sql.contains("GROUP")) {

                    // Si no la tiene concatenamos WHERE
                    sql += " WHERE";
                } else {

                    // Si la tiene concatenamos HAVING
                    sql += " HAVING";
                }

                // Agregamos las condiciones
                sql += apoyo;

                // Limpiamos los cuatro últimos caracteres de la concatenación
                sql = sql.substring(0, sql.length() - 4);

            }

        }

        // Comprobamos si hay ordenación entre los parámetros
        if (ordenacion != null) {

            // Si la hay, añadimos ORDER BY a la cadena
            sql += " ORDER BY";

            // Iteramos por las ordenaciones concatenando sus valores
            for (String orden : ordenacion) {
                sql = sql.concat(" ").concat(orden).concat(", ");
            }

            // Limpiamos los cuatro últimos caracteres de la concatenación
            sql = sql.substring(0, sql.length() - 2);
        }

        // Comprobamos si los parámetros especifican límites
        if (limites != null) {

            // Si los hay, concatenamos LIMIT
            sql += " LIMIT";

            // Iteramos por las limites concatenando sus valores
            for (int limite : limites) {
                sql = sql.concat(" ").concat(String.valueOf(limite)).concat(", ");
            }

            // Limpiamos los dos últimos caracteres de la concatenación
            sql = sql.substring(0, sql.length() - 2);

        }

        try {
            // Realizamos una consulta almacenando los resultados
            salida = new Resultado(true, "", db.query(sql));
        } catch (SQLException ex) {
            // Si se produce una excepción, creamos el objeto resultado
            // correspondiente y lo asignamos a la variable de salida
            salida = new Resultado(false, ex.getMessage(), null);
        }

        // Devolvemos el resultado
        return salida;

    }

    /**
     * Función para realizar una consulta a una base de datos
     *
     * @param columnas Columnas a consultar
     * @param tablas Tablas a consultar
     * @param condiciones Condiciones de la consulta
     * @param ordenacion Ordenación de los resultados de la consulta
     *
     * @return Objeto Resultado con los datos de la consulta realizada
     */
    public Resultado consultar(String[] columnas, String[] tablas, String[] condiciones, String[] ordenacion) {
        assert tablas != null;
        assert columnas != null;

        return consultar(columnas, tablas, condiciones, ordenacion, null);

    }

    /**
     * Función para eliminar registros de una tabla
     *
     * @param tablas Tablas de las que eliminar registros
     * @param condiciones Condiciones de eliminación
     * @return Objeto Resultado con los datos de la consulta realizada
     */
    public Resultado eliminar(String[] tablas, String[] condiciones) {

        // Asertos
        assert condiciones != null;

        // Creamos un objeto resultado para devolver al final de la función
        Resultado salida;

        // Cremaos e inicializamos una variable para almacenar la sentencia sql
        String sql = "DELETE FROM";

        // Iteramos por las tablas concatenando sus valores
        for (String tabla : tablas) {
            sql = sql.concat(" ").concat(tabla).concat(", ");
        }

        // Limpiamos los dos últimos caracteres de la concatenación
        sql = sql.substring(0, sql.length() - 2);

        // Concatenamos WHERE para seguir construyendo la sentencia
        sql += " WHERE";

        // Iteramos por las condiciones concatenando sus valores
        for (String condicion : condiciones) {
            sql = sql.concat(" ").concat(condicion).concat(" AND");
        }

        // Limpiamos los cuatro últimos caracteres de la concatenación
        sql = sql.substring(0, sql.length() - 4);

        try {
            // Ejecutamos la sentecia, almacenando los resultados en un objeto
            // Resultado
            salida = new Resultado(db.update(sql) > 0, "", null);
        } catch (SQLException ex) {
            // Si se produce una excepción, creamos el objeto resultado
            // correspondiente y lo asignamos a la variable de salida            
            salida = new Resultado(false, ex.getMessage(), null);
        }

        // Devolvemos el resultado
        return salida;
    }

    /**
     * Función que devuelve los nombres y apellidos de los autores,
     * concatenándolos
     *
     * @param idAutor Ids de los autores
     * @return Cadena con el nombre del autor o una cadena vacía
     */
    public String consultaNombreAutor(String[] idAutor) {

        // Inicializamos una variable de salida
        String salida = "";

        try {

            // Iteramos por los ids de los autores
            for (String autor : idAutor) {

                // Consultamos el nombre y el apellido del autor del id de la ietación
                Resultado datos = consultar(
                        new String[]{"Concat(primerNombre, ' ', apellidoPaterno) as Nombre"},
                        new String[]{"autores"},
                        new String[]{"idAutor = " + autor}, null);

                // Verificamos si la consulta se ha generado conrrectamente y si
                // ha devuelto datos
                if (datos.isOperacionCorrecta() && datos.getResultado().next()) {

                    // Si es así, concatenamos el resultado a la variable de 
                    // salida
                    salida = salida.concat(datos.getResultado().getString("Nombre")).concat(", ");
                }

                // Comprobamos si el ResultSet de la consulta está cerrado
                if (!datos.getResultado().isClosed()) {
                    // Si no está cerrado, lo cerramos
                    datos.getResultado().close();
                }
            }

            // Limpiamos los dos últimos caracteres de la concatenación
            salida = salida.substring(0, salida.length() - 2);
        } catch (SQLException ex) {

            // Si se produce una excepción, devolveremos una cadena vacia
            salida = "";
        }

        // Devolvemos el resultado
        return salida;
    }

    /**
     * Función para actualizar un libro
     *
     * @param libro Objeto libro con los datos a actualizar
     * @return Objeto Resultado con los datos de la consulta realizada
     */
    public Resultado actualizarLibro(Libro libro) {
        Resultado salida;

        // Lanzamos una consulta de actualización con los valores
        // pasados coom parámetro
        salida = actualizar(
                new String[]{"isbn", "titulo", "numeroEdicion", "editorial", "copyright", "resumen", "caratula"},
                new String[]{"titulos"},
                new String[]{"isbn = " + libro.getIsbn()},
                new String[]{
                    libro.getIsbn(),
                    libro.getTitulo(),
                    String.valueOf(libro.getNumEdicion()),
                    libro.getEditorial(),
                    libro.getCopyright(),
                    libro.getResumen(),
                    libro.getImagen()});

        // Comprobamos si la operación se ha realizado correctamente
        if (salida.isOperacionCorrecta()) {

            // Si es así, eliminamos los registros de la tabla isbnautor
            // para introducir los nevos registros modificados o losmismos si 
            // no se han modificado
            salida = eliminar(
                    new String[]{"isbnautor"},
                    new String[]{"isbn = " + libro.getIsbn()});

            // Si la operacion se realiza correctamente, los registros están
            // borrados
            if (salida.isOperacionCorrecta()) {

                // Iteramos por los autores que tenga el libro
                for (String idAutor : libro.getAutores()) {

                    // E insertamos nuevos registros en la tabla isbnautor
                    salida = actualizar(
                            null,
                            new String[]{"isbnautor"},
                            null,
                            new String[]{idAutor, libro.getIsbn()});

                    // Si en algún momento la operación no es correcta
                    if (!salida.isOperacionCorrecta()) {

                        // Generamos unobjeto Resultado y cortamos el bucle
                        salida = new Resultado(false, salida.getMensaje(), null);
                        break;
                    }
                }

                // Si la operación no es correcta
                if (!salida.isOperacionCorrecta()) {
                    // Elimiamos los posible registros que se hayan insertado
                    salida = eliminar(new String[]{"titulos"}, new String[]{"isbn = " + libro.getIsbn()});

                    // Si la operación es corracta
                    if (salida.isOperacionCorrecta()) {
                        // Creamos un objeto Resultado con un mensaje de error
                        salida = new Resultado(false, "Error al actualizar los autores del libro", null);
                    } else {
                        // Creamos un objeto Resultado con el mensaje de error
                        salida = new Resultado(false, salida.getMensaje(), null);
                    }
                }

            } else {
                // Creamos un objeto Resultado con el mensaje de error
                salida = new Resultado(false, salida.getMensaje(), null);
            }

        } else {
            // Creamos un objeto Resultado con el mensaje de error
            salida = new Resultado(false, salida.getMensaje(), null);
        }

        // Devolvemos el resultado
        return salida;

    }

    /**
     * Función para insertar un libro en la base de datos
     *
     * @param libro Objeto Libro con los valores a insertar
     * @return Objeto Resultado con los datos de la consulta realizada
     */
    public Resultado insertarLibro(Libro libro) {
        Resultado salida;

        // Insertamos en la base de datos los datos pasados por parámetro
        salida = actualizar(
                null,
                new String[]{"titulos"},
                null,
                new String[]{
                    libro.getIsbn(),
                    libro.getTitulo(),
                    String.valueOf(libro.getNumEdicion()),
                    libro.getEditorial(),
                    libro.getCopyright(),
                    libro.getResumen(),
                    libro.getImagen()});

        // Comprobamos si la operación se ha realizado correctamente
        if (salida.isOperacionCorrecta()) {

            // Si se ha ejecutado correcatamente, los datos del libro
            // están en la base de datos y solo queda almacenar los datos de
            // isbnautor. Para tal fin iiteramos por el array de autores
            for (String idAutor : libro.getAutores()) {

                // Insertamos los valores
                salida = actualizar(
                        null,
                        new String[]{"isbnautor"},
                        null,
                        new String[]{idAutor, libro.getIsbn()});

                // Si hay algún error salimos del bucle
                if (!salida.isOperacionCorrecta()) {
                    break;
                }
            }

            // Verificamos si hay errores
            if (!salida.isOperacionCorrecta()) {

                // Si los hay borramos los registros almacenados de autores
                salida = eliminar(new String[]{"titulos"}, new String[]{"isbn = " + libro.getIsbn()});

                // Verificamos si hay errores
                if (salida.isOperacionCorrecta()) {

                    // Creamos un objeto Resultado con un mensaje de error
                    salida = new Resultado(false, salida.getMensaje(), null);
                } else {
                    // Creamos un objeto Resultado con un mensaje de error
                    salida = new Resultado(false, salida.getMensaje(), null);
                }
            }
        } else {
            // Creamos un objeto Resultado con un mensaje de error
            salida = new Resultado(false, salida.getMensaje(), null);
        }

        // Devolvemos el resultado
        return salida;
    }

    /**
     * Función que permite generar un modelo de tabla a partir de un ResultSet
     *
     * @param rs ResultSet de con los valores con los que poblar la tabla
     * @return un DefaultTableModel generado
     * @throws SQLException Excepción si se produce un error con la base de
     * datos
     */
    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        // Recuperamos los metadatos de los resultados
        ResultSetMetaData metaData = rs.getMetaData();

        // Generamos los nombres de las columnas y las almacenamos un un vector
        Vector<String> columnNames = new Vector<>();

        // Conseguimos el número de columnas
        int columnCount = metaData.getColumnCount();

        // Iteramos y vamos almacenando los nombres de las columnas
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnLabel(column));
        }

        // Ahora introducimos losd atos de las tabla
        Vector<Vector<Object>> data = new Vector<>();

        // Mienras haya registros en el ResultSet iteramos
        while (rs.next()) {

            // Creamos un objeto vector nuevo
            Vector<Object> vector = new Vector<>();

            // Iteramos los valores y los almacenamos en el nuevo vector
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }

            // Añadimos el vector con los valores al vector inicial
            data.add(vector);
        }

        // Devolvemos el resultado
        return new DefaultTableModel(data, columnNames);

    }

    /**
     * Método para buscar el id de un autor a través de su nombre y apellidos
     *
     * @param autor Nombre y apellidos del autor
     * @return 0 si no hay ningún autor con ese nombre y apellidos en la base de
     * datos y su id si lo hay
     * @throws SQLException Excepción para errores de consulta SQL
     */
    public int buscarIdAutor(String autor) throws SQLException {
        int salida = 0;
        Resultado datos;

        datos = consultar(
                new String[]{"idAutor"},
                new String[]{"Autores"},
                new String[]{"CONCAT(primerNombre, ' ', apellidoPaterno) = '".concat(autor).concat("'")},
                null);

        if (datos.isOperacionCorrecta() && datos.getResultado().next()) {
            salida = (int) datos.getResultado().getObject("idAutor");
        }

        datos.getResultado().close();

        return salida;
    }
}
