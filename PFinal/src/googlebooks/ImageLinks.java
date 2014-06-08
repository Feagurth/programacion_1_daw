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
 * Clase para almacenar los links de imágenes correspondientes a un libro
 *
 * @author Luis Cabrerizo Gómez
 */
public class ImageLinks {

    private String smallThumbnail;

    private String thumbnail;

    /**
     * Método que nos permite recuperar la url de la imagen pequeña
     *
     * @return url de la imagen pequeña
     */
    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    /**
     * Método que nos permite asignar la url de la imagen pequeña
     *
     * @param smallThumbnail url de la imagen pequeña
     */
    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    /**
     * Método que nos permite asignar la url de la imagen pequeña y devolver el
     * objeto ImageLinks correspondiente
     *
     * @param smallThumbnail url de la imagen pequeña
     * @return El objeto ImageLinks
     */
    public ImageLinks withSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
        return this;
    }

    /**
     * Método que nos permite recuperar la url de la imagen
     *
     * @return La url de la imagen
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Método que nos permite asignar la url de la imagen
     *
     * @param thumbnail La url de la imagen
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * Método que nos permite asignar la url de la imagen y devolver el objeto
     * ImageLinks correspondiente
     *
     * @param thumbnail La url de la imagen
     * @return El objeto ImageLinks
     */
    public ImageLinks withThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }
}
