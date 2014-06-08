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

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para almacenar la respuesta del JSon de GoogleBooks
 *
 * @author Luis Cabrerizo Gómez
 */
public class GoogleBooksResponse {

    private String kind;

    private Integer totalItems;

    private List<Item> items = new ArrayList<>();

    /**
     * Método que nos permite recuperar el tipo de libro
     *
     * @return El tipo de libro
     */
    public String getKind() {
        return kind;
    }

    /**
     * Método que nos permite asignar el tipo del libro
     *
     * @param kind El tipo de libro
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Método que nos permite asignar el tipo de libro y devuelve un objeto
     * GoogleBooksResponde
     *
     * @param kind El tipo de libro
     * @return El objeto GoogleBooksResponse
     */
    public GoogleBooksResponse withKind(String kind) {
        this.kind = kind;
        return this;
    }

    /**
     * Método que nos permite recuperar el total de objetos que contiene la
     * respuesta
     *
     * @return El número total de objetos
     */
    public Integer getTotalItems() {
        return totalItems;
    }

    /**
     * Método que nos permite asignar el número total de objetos
     *
     * @param totalItems El número total de objetos
     */
    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * Método que nos permite asignar el número total de items y devuelve el
     * objeto GoogleBooksResponse correspondiente
     *
     * @param totalItems El número total del items
     * @return El objeto GoogleBooksResponse correspondiente
     */
    public GoogleBooksResponse withTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
        return this;
    }

    /**
     * Método que nos permite recuperar el número de objetos
     *
     * @return Una lista con los objetos correspondientes
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Método que nos permite asignar los items al objeto GoogleBooksResponse
     *
     * @param items Items del objeto GoogleBooksResponse
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Método que nos permite asignar los items y devuelve un objeto
     * GoogleBooksResponse
     *
     * @param items Los items a asignar al objeto GoogleBooksResponse
     * @return El objeto GoogleBooksResponse correspondiente
     */
    public GoogleBooksResponse withItems(List<Item> items) {
        this.items = items;
        return this;
    }
}
