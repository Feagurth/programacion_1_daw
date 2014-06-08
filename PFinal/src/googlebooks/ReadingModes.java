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

/**
 * Clase para almacenar los modos de lectura de una consulta el Google Books
 *
 * @author Luis Cabrerizo Gómez
 */
public class ReadingModes {

    private Boolean text;
    private Boolean image;

    /**
     * Método que nos permite recupera si tiene texto
     *
     * @return Si tiene texto
     */
    public Boolean getText() {
        return text;
    }

    /**
     * Método que nos permite asignar si tiene texto
     *
     * @param text Si tiene texto
     */
    public void setText(Boolean text) {
        this.text = text;
    }

    /**
     * Método que nos permite asignar si tiene texto
     *
     * @param text si tiene texto
     * @return El objeto ReadingModes
     */
    public ReadingModes withText(Boolean text) {
        this.text = text;
        return this;
    }

    /**
     * Método que nos permite recuperar si tiene imagen
     *
     * @return Si tiene imagen
     */
    public Boolean getImage() {
        return image;
    }

    /**
     * Método para asignar si tiene imagen
     *
     * @param image Si tiene imagen
     */
    public void setImage(Boolean image) {
        this.image = image;
    }

    /**
     * Método que nos permite asignar si tiene imagen y devolver el objeto
     * ReadingMode correspondiente
     *
     * @param image Si tiene imagen
     * @return El objeto ReadingMode
     */
    public ReadingModes withImage(Boolean image) {
        this.image = image;
        return this;
    }

}
