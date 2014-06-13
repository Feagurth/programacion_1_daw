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
package googlebooks;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import com.google.gson.Gson;
import db.BaseDeDatos;
import db.Libro;
import db.Resultado;
import formularios.DialogInsertarAutores;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.SQLException;

/**
 * Clase pare realizar consultas a Google Books usando GSon
 *
 * @author Luis Cabrerizo Gómez
 */
public class GoogleBooks {

    /**
     * Método que nos permite realizar una consulta a Google Books pare
     * recuperar información de un libro
     *
     * @param isbn ISBN del libro a buscar
     * @return Objeto Libro con la información recuperada
     * @throws MalformedURLException Excepción por malformación de URL
     * @throws UnsupportedEncodingException Excepción por codificación no
     * soportada
     * @throws IOException Excepción por error de entrada/salida
     * @throws SQLException Excepción por error en consulta SQL
     */
    public static Libro query(String isbn) throws MalformedURLException, UnsupportedEncodingException, IOException, SQLException {

        // Creamos un nuevo objeto libro donde almacenar la información
        // recuperada para devolverla
        Libro libro = new Libro();

        // Definimos las constantes que almacenaran la diracción de consulta
        // y la codificación de los caracteres
        final String ADDRESS = "https://www.googleapis.com/books/v1/volumes?q=isbn:";
        final String CHARSET = "UTF-8";

        // Creamos una URL con la diracción y el isbn a consulta con la 
        // codificación especificada
        URL url = new URL(ADDRESS + URLEncoder.encode(isbn, CHARSET));

        // Creamos un flujo de lectura que lee la respuesta dada por la web
        // consultada
        Reader reader = new InputStreamReader(url.openStream(), CHARSET);

        // Pasamos la información recuperada por la web y la pasamos al objeto
        // GoogleBooksResponse creado específicamente para almacenar la 
        // información devuelta por la consulta a Google Books
        GoogleBooksResponse results = new Gson().fromJson(reader, GoogleBooksResponse.class);

        // Comprobamos si la consulta ha generado resultados
        if (results.getTotalItems() > 0) {

            // Si es así, cogemos el primer resultado
            Item item = results.getItems().get(0);

            // Asignamos sus valores al objeto libro
            libro.setTitulo(item.getVolumeInfo().getTitle());
            libro.setCopyright(item.getVolumeInfo().getPublishedDate());
            libro.setEditorial(item.getVolumeInfo().getPublisher());
            libro.setIsbn(isbn);

            // Creamos una conexión a la base de datos
            BaseDeDatos baseDatos = new BaseDeDatos("root", "", "127.0.0.1:3306", "libros");

            // Inicializamos dos variables para controlar los autores que ya están
            // en la base de datos y los que no
            String conocidos = "";
            String desconocidos = "";
            int id;

            // Iteramos por todos los autores que tenga el libro
            for (String autor : item.getVolumeInfo().getAuthors()) {

                // Buscamos el id del autor
                id = baseDatos.buscarIdAutor(autor);

                // Comprobamos si tiene id
                if (id != 0) {

                    // Si lo tiene, ya está en la base de datos, concatenamos su
                    // id a la cadena de conocidos
                    conocidos = conocidos.concat(String.valueOf(id)).concat(";");

                } else {

                    // Si no tiene id, es un autor desconocido. concatenamos el 
                    // nombre del mismo en la cadena de desconocido
                    desconocidos = desconocidos.concat(autor).concat(";");
                }
            }

            // Si hay autores desconocidos
            if (!desconocidos.equals("")) {

                // Creamos un objeto DialogInsertarAutores y le pasamos los autores desocnocidos
                DialogInsertarAutores dialogAutores = new DialogInsertarAutores(null, true, desconocidos.split(";"));

                // Hacemos el objeto visible
                dialogAutores.setVisible(true);

                // Comprobamos si se han seleccionado autores para insertar en la
                // base de datos
                if (dialogAutores.getAutores() != null) {

                    // Iteramos por los autores a insertar
                    for (String autor : dialogAutores.getAutores()) {

                        // Concatenamos un 0 y unos caracteres de corte
                        // para pasar el id del autor nuevo como 0
                        autor = "0-_-".concat(autor);

                        // Insertamos y guardamos el resultado
                        Resultado salida = baseDatos.actualizar(
                                null,
                                new String[]{"Autores"},
                                null,
                                autor.split("-_-"));

                        // Comprobamos si la operación es correcta
                        if (salida.isOperacionCorrecta()) {

                            // Si lo es, reestructuramos la variable donde guardamos la cadena
                            // de inserción para que muestre solo el nombre y el apellido del autor
                            autor = autor.substring(4, autor.length()).replace("-_-", " ");

                            // Buscamos el id del mismo en la base de datos
                            id = baseDatos.buscarIdAutor(autor);

                            // Lo concatenamos a la cadena de autores conocidos
                            conocidos = conocidos.concat(String.valueOf(id)).concat(";");
                        }
                    }
                }
            }

            // Coramos los id's de los autores y los asignamos al objeto Libro
            libro.setAutores(conocidos.split(";"));

        }

        // Devolvemos el resultado
        return libro;
    }

}
