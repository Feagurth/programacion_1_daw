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
 * Objeto para almacenar los distintos valores y características de un libro
 *
 * @author Luis Cabrerizo Gómez
 */
public class Libro {

    private String isbn = "";
    private String titulo = "";
    private int numEdicion = 0;
    private String editorial = "";
    private String copyright = "";
    private String[] autores = null;

    /**
     * Función para recuperar el valor del isbn
     *
     * @return El valor del isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Método para asignar el isbn
     *
     * @param isbn El isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Función para recuperar el valor del titulo
     *
     * @return El valor del titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Método para asignar el título
     *
     * @param titulo El título
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Función para recuperar el valor del número de edición
     *
     * @return El número de edición
     */
    public int getNumEdicion() {
        return numEdicion;
    }

    /**
     * Método para asignar el número de edición
     *
     * @param numEdicion El número de edicion
     */
    public void setNumEdicion(int numEdicion) {
        this.numEdicion = numEdicion;
    }

    /**
     * Función para recuperar el valor de la editorial
     *
     * @return El valor de la editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Método para asignar la editorial
     *
     * @param editorial La editorial
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Función para recuperar el valor del copyright
     *
     * @return El copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * Método para asignar el año del copyright
     *
     * @param copyright El año del copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * Función para recuperar el valor del los autores
     *
     * @return El los autores
     */
    public String[] getAutores() {
        return autores;
    }

    /**
     * Método para asignar los autores del libro
     *
     * @param autores Id de los autores del libro
     */
    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    /**
     * Constructor de la clase
     */
    public Libro() {
    }

    /**
     * Constructor de la clase
     *
     * @param isbn isbn del libro
     * @param titulo Titulo del libro
     * @param numEdicion Número de edición del libro
     * @param editorial Editorial del libro
     * @param copyright Año de copyright del libro
     * @param autores Ids de los autores de los libros
     */
    public Libro(String isbn, String titulo, int numEdicion, String editorial, String copyright, String[] autores) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.numEdicion = numEdicion;
        this.editorial = editorial;
        this.copyright = copyright;
        this.autores = autores;
    }

}
