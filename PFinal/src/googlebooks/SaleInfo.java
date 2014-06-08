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
 * Clase para almacenar la información de venta de un libro tras una consulta a
 * Google Books
 *
 * @author Luis Cabrerizo Gómez
 */
public class SaleInfo {

    private String country;

    private String saleability;

    private Boolean isEbook;

    /**
     * Método que nos permite recuperar el país del libro
     *
     * @return El país del libro
     */
    public String getCountry() {
        return country;
    }

    /**
     * Método que nos permite asignar el país del libro
     *
     * @param country El país del libro
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Método que nos permite asignar el país del libro y devolver el objeto
     * SaleInfo correspondiente
     *
     * @param country El país del libro
     * @return El objeto SaleInfo
     */
    public SaleInfo withCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Método que nos permite recupera lo vendible que es el libro
     *
     * @return Lo vendible que es el libro
     */
    public String getSaleability() {
        return saleability;
    }

    /**
     * Método que nos permite asignar lo vendible que es el libro
     *
     * @param saleability Lo vendible que es el libro
     */
    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    /**
     * Método que nos permite asignar lo vendible que es el libro y devolver un
     * objeto SaleInfo correspondiente
     *
     * @param saleability Lo vendible que es el libro
     * @return El objeto SaleInfo correspondiente
     */
    public SaleInfo withSaleability(String saleability) {
        this.saleability = saleability;
        return this;
    }

    /**
     * Método que nos permite recuperar si el libro es un Ebook
     *
     * @return Si el libro es un Ebook
     */
    public Boolean getIsEbook() {
        return isEbook;
    }

    /**
     * Método que nos permite asignar si el libro es un Ebook
     *
     * @param isEbook Si el libro es un Ebook
     */
    public void setIsEbook(Boolean isEbook) {
        this.isEbook = isEbook;
    }

    /**
     * Método que nos permite asignar si el libro es un Ebook y devuelve un
     * objeto SaleInfo correspondiente
     *
     * @param isEbook Si el libro es un Ebook
     * @return El objeto SaleInfo correspondiente
     */
    public SaleInfo withIsEbook(Boolean isEbook) {
        this.isEbook = isEbook;
        return this;
    }

}
