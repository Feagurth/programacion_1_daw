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
 * Clase para almacenar la información de identificación de industria de una
 * consulta a GoogleBooks
 *
 * @author Luis Cabrerizo Gómez
 */
public class IndustryIdentifier {

    private String type;

    private String identifier;

    /**
     * Método que nos permite recuperar el tipo de identificador de industria
     *
     * @return El tipo de identificador de industria
     */
    public String getType() {
        return type;
    }

    /**
     * Método que nos permite asignar el tipo de identificador de industria
     *
     * @param type el tipo de identificador de industria
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Método que nos permite asignar el tipo de identificador de industria y
     * devolver el objeto IndustryIdentifier
     *
     * @param type El tipo de identificador de industria
     * @return El objeto IndustryIdentifier
     */
    public IndustryIdentifier withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Método que nos permite recuperar el identificador
     *
     * @return El identificador
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Método que nos permite asignar el identificador
     *
     * @param identifier El identificador
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Método que nos permite asignar el identificador y devolver el objeto
     * IndustryIdentifier correspondiente
     *
     * @param identifier El identificador
     * @return El objeto IndustryIdentifier
     */
    public IndustryIdentifier withIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

}
