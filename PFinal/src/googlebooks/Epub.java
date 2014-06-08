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
 * Clase para almacenar el Epub de un libro
 *
 * @author Luis Cabrerizo Gómez
 */
public class Epub {

    private Boolean isAvailable;

    /**
     * Método que nos permite recuperar si el Epub está disponible
     *
     * @return Eecupera si el Epub está disponible
     */
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     * Método que nos permite asignar si el Epub está disponible
     *
     * @param isAvailable Si el Epub está disponible
     */
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * Método que nos permite asignar si el Epub está disponible y devolver el
     * Epub relacionado
     *
     * @param isAvailable Si el Epub está disponible
     * @return El Epub del libro
     */
    public Epub withIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
        return this;
    }

}
