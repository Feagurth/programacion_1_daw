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
 * Clase para almacenar la información del volumen tras una consulta a Google
 * Books
 *
 * @author Luis Cabrerizo Gómez
 */
public class VolumeInfo {

    private String title;

    private List<String> authors = new ArrayList<>();

    private String publisher;

    private String publishedDate;

    private List<IndustryIdentifier> industryIdentifiers = new ArrayList<>();

    private ReadingModes readingModes;

    private Integer pageCount;

    private String printType;

    private List<String> categories = new ArrayList<>();

    private String contentVersion;

    private ImageLinks imageLinks;

    private String language;

    private String previewLink;

    private String infoLink;

    private String canonicalVolumeLink;
    
    private String description;

    /**
     * Método que nos permite recuperar el título del libro
     *
     * @return El título del libro
     */
    public String getTitle() {
        return title;
    }

    /**
     * Método que nos permite asignar el título del libro
     *
     * @param title El título del libro
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Método que nos permite asignar el título del libro y devolver el objeto
     * VolumeInfo correspondiente
     *
     * @param title El título del libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Método que nos permite recuperar los autores de un libro
     *
     * @return Los autores de un libro
     */
    public List<String> getAuthors() {
        return authors;
    }

    /**
     * Método que nos permite asignar los autores de un libro
     *
     * @param authors Los autores de un libro
     */
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    /**
     * Método que nos permite asignar los autores de un libro y devolver el
     * objeto VolumeInfo correspondiente
     *
     * @param authors Los autores de un libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withAuthors(List<String> authors) {
        this.authors = authors;
        return this;
    }

    /**
     * Método que nos permite recuperar el editor del libro
     *
     * @return El editor del libro
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Método que nos permite asignar el editor del libro
     *
     * @param publisher El editor del libro
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Método que nos permite asignar el editor del libro y devolver el objeto
     * VolumeInfo correspondiente
     *
     * @param publisher El editor del libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    /**
     * Método que nos permite recuperar la fecha de publicación
     *
     * @return La fecha de publicación
     */
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     * Método que nos permite asignar la fecha de publicación
     *
     * @param publishedDate La fecha de publicación
     */
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**
     * Método que nos permite asignar la fecha de publicación y devolver el
     * objeto VolumeInfo correspondiente
     *
     * @param publishedDate La fecha de publicación
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
        return this;
    }

    /**
     * Método que nos permite recuperar los objetos IndustryIdentifier
     * relacionados con el libro
     *
     * @return Los objetos IndustryIdentifier relacionados con el libro
     */
    public List<IndustryIdentifier> getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    /**
     * Método que nos permite asignar los objetos IndustryIdentifier
     * relacionados con el libro
     *
     * @param industryIdentifiers Los objetos IndustryIdentifier relacionados
     * con el libro
     */
    public void setIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    /**
     * Método que nos permite asignar los objetos IndustryIdentifier
     * relacionados con el libro y devolver el objeto VolumeInfo correspondiente
     *
     * @param industryIdentifiers Los objetos IndustryIdentifier relacionados
     * con el libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
        return this;
    }

    /**
     * Método que nos permite recuperar el objeto ReadingMode asociado al libro
     *
     * @return El objeto ReadingMode asociado al libro
     */
    public ReadingModes getReadingModes() {
        return readingModes;
    }

    /**
     * Método que nos permite asignar el objeto ReadingMode asociado al libro
     *
     * @param readingModes El objeto ReadingMode asociado al libro
     */
    public void setReadingModes(ReadingModes readingModes) {
        this.readingModes = readingModes;
    }

    /**
     * Método que nos permite asignar el objeto ReadingMode asociado al libro y
     * devolver el objeto VolumeInfo correspondiente
     *
     * @param readingModes El objeto ReadingMode asociado al libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withReadingModes(ReadingModes readingModes) {
        this.readingModes = readingModes;
        return this;
    }

    /**
     * Método que nos permite recuperar el número de paginas del libro
     *
     * @return El número de paginas del libro
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * Método que nos permite asignar el número de paginas del libro
     *
     * @param pageCount El número de paginas del libro
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Método que nos permite asignar el número de paginas del libro y devolver
     * el objeto VolumeInfo correspondiente
     *
     * @param pageCount El número de paginas del libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withPageCount(Integer pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    /**
     * Método que nos permite recupera el tipo de impresión del libro
     *
     * @return El tipo de impresión del libro
     */
    public String getPrintType() {
        return printType;
    }

    /**
     * Método que nos permite asignar el tipo de impresión del libro
     *
     * @param printType El tipo de impresión del libro
     */
    public void setPrintType(String printType) {
        this.printType = printType;
    }

    /**
     * Método que nos permite asignar el tipo de impresión del libro y devolver
     * el objeto VolumeInfo correspondiente
     *
     * @param printType El tipo de impresión del libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withPrintType(String printType) {
        this.printType = printType;
        return this;
    }

    /**
     * Método que nos permite recuperar las categorías del libro
     *
     * @return Las categorías del libro
     */
    public List<String> getCategories() {
        return categories;
    }

    /**
     * Métodos que nos permite asignar las categorías del libro
     *
     * @param categories Las categorías del libro
     */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /**
     * Método que nos permite asignar las categorías del libro y recuperar el
     * objeto VolumeInfo correspondiente
     *
     * @param categories Las categorías del libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withCategories(List<String> categories) {
        this.categories = categories;
        return this;
    }

    /**
     * Método que nos permite recuperar la versión de contenido del libro
     *
     * @return La versión de contenido del libro
     */
    public String getContentVersion() {
        return contentVersion;
    }

    /**
     * Método que nos permite asignar la versión de contenido del libro
     *
     * @param contentVersion La versión de contenido del libro
     */
    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    /**
     * Método que nos permite asignar la versión de contenido del libro y
     * devolver el objeto VolumeInfo correspondiente
     *
     * @param contentVersion La versión de contenido del libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
        return this;
    }

    /**
     * Método que nos permite recuperar el objeto ImageLinks asociado al libro
     *
     * @return El objeto ImageLinks asociado al libro
     */
    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    /**
     * Método para asignar el objeto ImageLinks asociado al libro
     *
     * @param imageLinks El objeto ImageLinks asociado al libro
     */
    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    /**
     * Método que nos permite asignar el objeto ImageLinks asociado al libro y
     * devolver el objeto VolumeInfo correspondiente
     *
     * @param imageLinks El objeto ImageLinks asociado al libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
        return this;
    }

    /**
     * Método que nos permite recuperar el lenguaje del libro
     *
     * @return El lenguaje del libro
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Método que nos permite asignar el lenguaje del libro
     *
     * @param language El lenguaje del libro
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Método que nos permite asignar el lenguaje del libro y devolver el objeto
     * VolumeInfo correspondiente
     *
     * @param language El lenguaje del libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withLanguage(String language) {
        this.language = language;
        return this;
    }

    /**
     * Método que nos permite recupera el enlace a la vista previa del libro
     *
     * @return El enlace a la vista previa del libro
     */
    public String getPreviewLink() {
        return previewLink;
    }

    /**
     * Método que nos permite asignar el enlace a la vista previa del libro
     *
     * @param previewLink El enlace a la vista previa del libro
     */
    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    /**
     * Método que nos permite asignar el enlace a la vista previa del libro y
     * devolver el objeto VolumeInfo correspondiente
     *
     * @param previewLink El enlace a la vista previa del libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withPreviewLink(String previewLink) {
        this.previewLink = previewLink;
        return this;
    }

    /**
     * Método que nos permite recuperar el enlace a la información de libro
     *
     * @return El enlace a la información de libro
     */
    public String getInfoLink() {
        return infoLink;
    }

    /**
     * Método que nos permite asignar el enlace a la información de libro
     *
     * @param infoLink El enlace a la información de libro
     */
    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    /**
     * Método que nos permite asignar el enlace a la información de libro y
     * devolver el objeto VolumeInfo correspondiente
     *
     * @param infoLink El enlace a la información de libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withInfoLink(String infoLink) {
        this.infoLink = infoLink;
        return this;
    }

    /**
     * Método que nos permite recuperar el enlace a la canónica del libro
     *
     * @return El enlace a la canónica del libro
     */
    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

    /**
     * Método que nos permite asignar el enlace a la canónica del libro
     *
     * @param canonicalVolumeLink El enlace a la canónica del libro
     */
    public void setCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    /**
     * Método que nos permite asignar el enlace a la canónica del libro y
     * devolver el objeto VolumeInfo correspondiente
     *
     * @param canonicalVolumeLink El enlace a la canónica del libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
        return this;
    }
    
    /**
     * Método que nos permite recuperar el enlace a la canónica del libro
     *
     * @return El enlace a la canónica del libro
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método que nos permite asignar la descripción del libro
     *
     * @param description Descripción del libro
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Método que nos permite asignar la descripción del libro y
     * devolver el objeto VolumeInfo correspondiente
     *
     * @param description Descripción del libro
     * @return El objeto VolumeInfo correspondiente
     */
    public VolumeInfo withDescription(String description) {
        this.description = description;
        return this;
    }    

}
