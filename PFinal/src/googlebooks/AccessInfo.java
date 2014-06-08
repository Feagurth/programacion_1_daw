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
 * Clase para almacenar la respuesta información de acceso de Google Books
 *
 * @author Luis Cabrerizo Gómez
 */
public class AccessInfo {

    private String country;

    private String viewability;

    private Boolean embeddable;

    private Boolean publicDomain;

    private String textToSpeechPermission;

    private Epub epub;

    private Pdf pdf;

    private String webReaderLink;

    private String accessViewStatus;

    private Boolean quoteSharingAllowed;

    /**
     * Método para recuperar el país del libro
     *
     * @return El país del libro
     */
    public String getCountry() {
        return country;
    }

    /**
     * Método para asignar el país del libro
     *
     * @param country El país a asignar al libro
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Método que permite asignar un país y devolver el objeto AccessInfo
     *
     * @param country El país a asignar
     * @return La información de acceso del libro
     */
    public AccessInfo withCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Método que nos permite recuperar la visibilidad del libro
     *
     * @return La visibilidad del libro
     */
    public String getViewability() {
        return viewability;
    }

    /**
     * Método para asignar la visibilidad del libro
     *
     * @param viewability Visibilidad del libro
     */
    public void setViewability(String viewability) {
        this.viewability = viewability;
    }

    /**
     * Método que nos permite asignar la visibilidad y devolver el objeto
     * AccessInfo
     *
     * @param viewability Visibilidad del libro
     * @return La información de acceso del libro
     */
    public AccessInfo withViewability(String viewability) {
        this.viewability = viewability;
        return this;
    }

    /**
     * Método para recuperar la incrustabilidad del libro
     *
     * @return Incrustabilidad del libro
     */
    public Boolean getEmbeddable() {
        return embeddable;
    }

    /**
     * Método que nos permite asignar la incrustabilidad del libro
     *
     * @param embeddable Incrustabilidad del libro
     */
    public void setEmbeddable(Boolean embeddable) {
        this.embeddable = embeddable;
    }

    /**
     * Método que nos permite asignar la inscrustabilidad del libro y devolver
     * el objeto AccessInfor
     *
     * @param embeddable Incrustabilidad del libro
     * @return La información de acceso del libro
     */
    public AccessInfo withEmbeddable(Boolean embeddable) {
        this.embeddable = embeddable;
        return this;
    }

    /**
     * Método que nos permite recuperar si el libro es de dominio público
     *
     * @return Si el libro es de dominio público
     */
    public Boolean getPublicDomain() {
        return publicDomain;
    }

    /**
     * Método que nos permite asignar si el libro es de dominio público
     *
     * @param publicDomain Si el libro es de dominio público
     */
    public void setPublicDomain(Boolean publicDomain) {
        this.publicDomain = publicDomain;
    }

    /**
     * Método que nos permite asignar si un libro es de dominio público y
     * devolver el objeto AccessInfo relacionado
     *
     * @param publicDomain Si el libro es de dominio público
     * @return La información de acceso del libro
     */
    public AccessInfo withPublicDomain(Boolean publicDomain) {
        this.publicDomain = publicDomain;
        return this;
    }

    /**
     * Método que nos permite recuperar los permisos de texto a voz del libro
     *
     * @return Los permisos de texto a voz del libro
     */
    public String getTextToSpeechPermission() {
        return textToSpeechPermission;
    }

    /**
     * Método para asignar los permisos de texto a voz del libro
     *
     * @param textToSpeechPermission Permisos de texto a voz del libro
     */
    public void setTextToSpeechPermission(String textToSpeechPermission) {
        this.textToSpeechPermission = textToSpeechPermission;
    }

    /**
     * Método para asignar los permisos de texto a voz del libro y devolver el
     * objeto AccessInfo del mismo
     *
     * @param textToSpeechPermission Permisos de texto a voz
     * @return Información de acceso del libro
     */
    public AccessInfo withTextToSpeechPermission(String textToSpeechPermission) {
        this.textToSpeechPermission = textToSpeechPermission;
        return this;
    }

    /**
     * Método que nos permite recuperar el Epub del libro
     *
     * @return El Epub del libro
     */
    public Epub getEpub() {
        return epub;
    }

    /**
     * Método que nos permite asignar el Epub del libro
     *
     * @param epub El Epub del libro
     */
    public void setEpub(Epub epub) {
        this.epub = epub;
    }

    /**
     * Método que nos permite asignar el Epub a un libro y devolver el objeto
     * AccessInfo relacionado con el mismo
     *
     * @param epub Epub del libro
     * @return Información de acceso del libro
     */
    public AccessInfo withEpub(Epub epub) {
        this.epub = epub;
        return this;
    }

    /**
     * Método que nos permite recuperar el Pdf del libro
     *
     * @return El Pdf del libro
     */
    public Pdf getPdf() {
        return pdf;
    }

    /**
     * Método que nos permite asignar el Pdf de un libro
     *
     * @param pdf El Pdf de un libro
     */
    public void setPdf(Pdf pdf) {
        this.pdf = pdf;
    }

    /**
     * Método que nos permite asignar el Pdf y devolver el objeto AccessInfo
     * relacionado
     *
     * @param pdf El Pdf del libro
     * @return La información de acceso del libro
     */
    public AccessInfo withPdf(Pdf pdf) {
        this.pdf = pdf;
        return this;
    }

    /**
     * Método que nos permite recuperar el enlace a la versión web del lector
     *
     * @return El enlace a la versión web del lector
     */
    public String getWebReaderLink() {
        return webReaderLink;
    }

    /**
     * Método que nos permite asignar el enlace a la versión web del lector
     *
     * @param webReaderLink El enlace a la versión web del lector
     */
    public void setWebReaderLink(String webReaderLink) {
        this.webReaderLink = webReaderLink;
    }

    /**
     * Método que nos permite asignar el enlace a la versión web del lector y
     * devolver el objeto AccessInfo relacionado
     *
     * @param webReaderLink El enlace a la versión web del lector
     * @return La información de acceso del libro
     */
    public AccessInfo withWebReaderLink(String webReaderLink) {
        this.webReaderLink = webReaderLink;
        return this;
    }

    /**
     * Método que nos permite recuperar el estado de acceso a la visión del
     * libro
     *
     * @return El estado de acceso a la visión del libro
     */
    public String getAccessViewStatus() {
        return accessViewStatus;
    }

    /**
     * Método que nos permite asignar el estado de acceso a la visión del libro
     *
     * @param accessViewStatus El estado de acceso a la visión del libro
     */
    public void setAccessViewStatus(String accessViewStatus) {
        this.accessViewStatus = accessViewStatus;
    }

    /**
     * Método que nos permite asignar el estado de acceso a la visión del libro
     * y devolver el objeto AccessInfo
     *
     * @param accessViewStatus El estado de acceso a la visión del libro
     * @return La información de acceso del libro
     */
    public AccessInfo withAccessViewStatus(String accessViewStatus) {
        this.accessViewStatus = accessViewStatus;
        return this;
    }

    /**
     * Método que nos permite recuperar la cuota de compartición permitida
     *
     * @return La cuota de compartición permitida
     */
    public Boolean getQuoteSharingAllowed() {
        return quoteSharingAllowed;
    }

    /**
     * Método que nos permite asignar la cuota de compartición permitida
     *
     * @param quoteSharingAllowed la cuota de compartición permitida
     */
    public void setQuoteSharingAllowed(Boolean quoteSharingAllowed) {
        this.quoteSharingAllowed = quoteSharingAllowed;
    }

    /**
     * Método que nos permite asignar la cuota de compartición permitida y
     * devolver el objeto AccessInfo relacionado
     *
     * @param quoteSharingAllowed La cuota de compartición permitida
     * @return La información de acceso del libro
     */
    public AccessInfo withQuoteSharingAllowed(Boolean quoteSharingAllowed) {
        this.quoteSharingAllowed = quoteSharingAllowed;
        return this;
    }

}
