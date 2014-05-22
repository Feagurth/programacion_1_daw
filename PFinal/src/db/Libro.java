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
package db;

/**
 *
 * @author Luis Cabrerizo Gómez
 */
public class Libro {

    private final String isbn;
    private final String titulo;
    private final int numEdicion;
    private final String editorial;
    private final String copyright;
    private final String[] autores;

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNumEdicion() {
        return numEdicion;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getCopyright() {
        return copyright;
    }

    public String[] getAutores() {
        return autores;
    }

    public Libro(String isbn, String titulo, int numEdicion, String editorial, String copyright, String[] autores) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.numEdicion = numEdicion;
        this.editorial = editorial;
        this.copyright = copyright;
        this.autores = autores;
    }
    
    
    
}
