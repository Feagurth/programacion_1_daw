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
import db.Libro;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

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
     */
    public static Libro query(String isbn) throws MalformedURLException, UnsupportedEncodingException, IOException {

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
            
            // TODO: Modificar pare realizar una búsqueda de autores en la
            // base de datos y reemplalzar el nombre por el id correspondiente
            // Queda pendiente pensar que hacer en el caso de que devuelva
            // un autor que no esté en la base de datos
            
            
            String autores = "";
            for (String autor : item.getVolumeInfo().getAuthors()) {
                autores = autores.concat(autor).concat("-_-");
            }
            
            libro.setAutores(autores.split("-_-"));            
            
        }

        // Devolvemos el resultado
        return libro;
    }
}
