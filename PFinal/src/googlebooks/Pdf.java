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
 * Clase para almacenar la información de Pdf de una consulta a Google Books
 *
 * @author Luis Cabrerizo Gómez
 */
public class Pdf {

    private Boolean isAvailable;

    /**
     * Método para recuperar la disponibilidad del Pdf
     *
     * @return La disponibilidad del Pdf
     */
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     * Método que nos permite asignar la disponibilidad del Pdf
     *
     * @param isAvailable La disponibilidad del Pdf
     */
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * Método que nos permite asignar la disponibilidad del Pdf y devolver un
     * objeto Pdf
     *
     * @param isAvailable La disponibilidad del Pdf
     * @return El objeto Pdf correspondiente
     */
    public Pdf withIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
        return this;
    }

}
