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
 * Clase para almacenar los libros que contiene la respuesta tras una consulta a
 * Google Books
 *
 * @author Luis Cabrerizo Gómez
 */
public class Item {

    private String kind;

    private String id;

    private String etag;

    private String selfLink;

    private VolumeInfo volumeInfo;

    private SaleInfo saleInfo;

    private AccessInfo accessInfo;

    /**
     * Método que nos permite recuperar el tipo de libro
     *
     * @return El tipo de libro
     */
    public String getKind() {
        return kind;
    }

    /**
     * Método que nos permite asignar el tipo de libro
     *
     * @param kind El tipo de libro
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Método que nos permite asignar el tipo de libro y devolver el objeto Item
     * correspondiente
     *
     * @param kind El tipo de libro
     * @return El objeto Item correspondiente
     */
    public Item withKind(String kind) {
        this.kind = kind;
        return this;
    }

    /**
     * Método que nos permite recuperar la id del libro
     *
     * @return La id del libro
     */
    public String getId() {
        return id;
    }

    /**
     * Método que nos permite asignar la id del libro
     *
     * @param id La id del libro
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método que nos permite asignar la id del libro y devolver el objeto Item
     * correspondiente
     *
     * @param id La id del libro
     * @return El objeot Item correspondiente
     */
    public Item withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Método que nos permite asignar el Etag del libro
     *
     * @return El Etag del libro
     */
    public String getEtag() {
        return etag;
    }

    /**
     * Método que nos permite asignar el Etag del libro
     *
     * @param etag El Etag del libro
     */
    public void setEtag(String etag) {
        this.etag = etag;
    }

    /**
     * Método que nos permite asignar el Etag del libro y devolver el objeto
     * Item correspondiente
     *
     * @param etag El Etag del libro
     * @return El objeto Item correspondiente
     */
    public Item withEtag(String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Método que nos permite recuperar el enlace al fichero JSon original
     *
     * @return el enlace al fichero JSon original
     */
    public String getSelfLink() {
        return selfLink;
    }

    /**
     * Método que nos permite asginar el enlace al fichero JSon original
     *
     * @param selfLink el enlace al fichero JSon original
     */
    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    /**
     * Método que nos permite asignar el enlace al fichero JSon original y
     * devolver el objeto Item correspondiente
     *
     * @param selfLink El enlace al fichero JSon original
     * @return El objeto Item correspondiente
     */
    public Item withSelfLink(String selfLink) {
        this.selfLink = selfLink;
        return this;
    }

    /**
     * Método que nos permite recuperar el objeto VolumeInfo asignado al libro
     *
     * @return El objeto VolumeInfo asignado al libro
     */
    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    /**
     * Método que nos permite asignar el objeto VolumeInfo asignado al libro
     *
     * @param volumeInfo El objeto VolumeInfo asignado al libro
     */
    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    /**
     * Método que nos permite asignar el objeto VolumeInfo asignado al libro y
     * devolver el objeto Item correspondiente
     *
     * @param volumeInfo El objeto VolumeInfo asignado al libro
     * @return El objeto Item correspondiente
     */
    public Item withVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
        return this;
    }

    /**
     * Método que nos permite recuperar el objeto SaleInfo asignado al libro
     *
     * @return El objeto SaleInfo asignado al libro
     */
    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    /**
     * Método que nos permite asignar el objeto SaleInfo asignado al libro
     *
     * @param saleInfo El objeto SaleInfo asignado al libro
     */
    public void setSaleInfo(SaleInfo saleInfo) {
        this.saleInfo = saleInfo;
    }

    /**
     * Método que nos permite asignar el objeto SaleInfo asignado al libro y
     * devolver el objeto Item correspondiente
     *
     * @param saleInfo El objeto SaleInfo asignado al libro
     * @return El objeto Item correspondiente
     */
    public Item withSaleInfo(SaleInfo saleInfo) {
        this.saleInfo = saleInfo;
        return this;
    }

    /**
     * Método que nos permite recuperar el objeto AccessInfo asignado al libro
     *
     * @return El objeto AccessInfo asignado al libro
     */
    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    /**
     * Método que nos permite asignar el objeto AccessInfo asignado al libro
     *
     * @param accessInfo El objeto AccessInfo asignado al libro
     */
    public void setAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }

    /**
     * Método que nos permite asignar el objeto AccessInfo asignado al libro y
     * devolver el objeto Item correspondiente
     *
     * @param accessInfo
     * @return
     */
    public Item withAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
        return this;
    }

}
