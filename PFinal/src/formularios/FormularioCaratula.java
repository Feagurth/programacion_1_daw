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
package formularios;

import db.BaseDeDatos;
import db.Libro;
import db.Resultado;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import utiles.Mensajes;

/**
 * Clase para mostrar los libros con una carátula, el titulo y autores
 *
 * @author Luis Cabrerizo Gómez
 */
public class FormularioCaratula extends javax.swing.JPanel {

    // Variables de instancia
    private String isbn;
    private BaseDeDatos baseDatos;
    private Libro libro;

    /**
     * Constructor de la clase
     *
     * @param isbn Isbn del libro a mostrar
     */
    public FormularioCaratula(String isbn) {

        // Inicializamos los componentes del formulario
        initComponents();

        // Asignamos los parámetros a la variable de instancia
        this.isbn = isbn;

        // Hacemos visible el formulario
        setVisible(true);

        // Creamos un nuevo objeto libro y le asignamos el isbn
        libro = new Libro();
        libro.setIsbn(this.isbn);

        // Creamos una nueva conexión con la base de datos
        baseDatos = new BaseDeDatos("root", "", "127.0.0.1:3306", "libros");

        try {

            // Realizamos una consulta con la base de datos para traer toda la
            // información del libro a mostrar
            Resultado datos = baseDatos.consultar(
                    new String[]{"*"},
                    new String[]{"titulos"},
                    new String[]{"isbn= " + this.isbn}, null);

            // Comprobamos que la operación es correcta y que trae datos
            if (datos.isOperacionCorrecta() && datos.getResultado().next()) {

                // Acabamos de llenar los datos del objeto Libro a partir de los
                // valores de la consulta
                libro.setTitulo(datos.getResultado().getString("titulo"));
                libro.setCopyright(datos.getResultado().getString("copyright"));
                libro.setEditorial(datos.getResultado().getString("editorial"));
                libro.setNumEdicion(datos.getResultado().getInt("numeroEdicion"));
                libro.setResumen(datos.getResultado().getString("resumen"));

                // Asignamos el título a la etiqueta correspondiente
                lblTitulo.setText(libro.getTitulo());
                lblTitulo.setToolTipText(libro.getTitulo());

                // Consultamos los autores relacionados con el libro
                datos = baseDatos.consultar(
                        new String[]{"idAutor"},
                        new String[]{"isbnautor"},
                        new String[]{"isbn = " + this.isbn}, null);

                String idAutor = "";

                // Si la operacion es correcta iteramos por los resultados
                // y creamos la cadena de texto para mostrar en el cuadro de texto
                // y la que ocultaremos en la etiqueta de ids
                if (datos.isOperacionCorrecta()) {
                    while (datos.getResultado().next()) {
                        idAutor = idAutor.concat(datos.getResultado().getString("idAutor")).concat(",");
                    }

                    idAutor = idAutor.substring(0, idAutor.length() - 1);

                    libro.setAutores(idAutor.split(","));

                    lblAutores.setText(baseDatos.consultaNombreAutor(idAutor.split(",")));
                    lblAutores.setToolTipText(lblAutores.getText());

                }

                // Creamos una variable para almacenar el tooltip de la carátula
                // que contendrá un resumen de los datos
                String tooltip = "";

                // Comprobamos si tenemos los valores para cada campo
                // y vamos creando el tooltip
                if (!libro.getIsbn().equals("")) {
                    tooltip = tooltip.concat(String.format("ISBN: %s<br>", libro.getIsbn()));
                }

                if (!libro.getTitulo().equals("")) {
                    tooltip = tooltip.concat(String.format("Título: %s<br>", libro.getTitulo()));
                }

                if (!lblAutores.getText().equals("")) {
                    tooltip = tooltip.concat(String.format("Autor/es: %s<br>", lblAutores.getText()));
                }

                if (!libro.getEditorial().equals("")) {
                    tooltip = tooltip.concat(String.format("Editorial: %s<br>", libro.getEditorial()));
                }

                if (!libro.getCopyright().equals("")) {
                    tooltip = tooltip.concat(String.format("Año: %s<br>", libro.getCopyright()));
                }

                if (!String.valueOf(libro.getNumEdicion()).equals("")) {
                    tooltip = tooltip.concat(String.format("Edición: %s<br>", String.valueOf(libro.getNumEdicion())));
                }

                // Concatenamos etiquetas html entre el tooltip para poder
                // realizar retornos de carro con los carácteres <br> incluidos
                // en la cadena del tooltip
                tooltip = "<html>".concat(tooltip).concat("</html>");
                
                // Asginanos el tooltip a la carátula
                lblCaratula.setToolTipText(tooltip);

                // Finalmente comprobamos si la ResultSet está cerrado
                if (!datos.getResultado().isClosed()) {

                    // Si no lo está, lo cerramos
                    datos.getResultado().close();
                }
            }
        } catch (SQLException ex) {
            // Mostramos un mensaje de error si se produce alguna excepción al 
            // cerrar el ResultSet
            Mensajes.mostrarMensaje(ex.getMessage(), Mensajes.TipoMensaje.ERROR);
        }
    }

    /**
     * Constructor de la clase
     */
    public FormularioCaratula() {
        // Inicializamos los componentes del formulario
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCaratula = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblAutores = new javax.swing.JLabel();
        lblISBN = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(126, 200));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCaratula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaratula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/no_book.png"))); // NOI18N
        lblCaratula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCaratulaMouseClicked(evt);
            }
        });
        add(lblCaratula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Titulo");
        lblTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblTitulo.setFocusable(false);
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTitulo.setMaximumSize(new java.awt.Dimension(125, 15));
        lblTitulo.setMinimumSize(new java.awt.Dimension(125, 15));
        lblTitulo.setPreferredSize(new java.awt.Dimension(125, 15));
        lblTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTituloMouseClicked(evt);
            }
        });
        add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, 20));

        lblAutores.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblAutores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAutores.setText("Autores");
        lblAutores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblAutores.setMaximumSize(new java.awt.Dimension(125, 15));
        lblAutores.setMinimumSize(new java.awt.Dimension(125, 15));
        lblAutores.setPreferredSize(new java.awt.Dimension(125, 15));
        lblAutores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAutoresMouseClicked(evt);
            }
        });
        add(lblAutores, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, 20));

        lblISBN.setEnabled(false);
        add(lblISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento para la pulsación del ratón en la etiqueta del título
     *
     * @param evt Evento
     */
    private void lblTituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTituloMouseClicked
        // Llamamos al método pulsado
        pulsado();
    }//GEN-LAST:event_lblTituloMouseClicked

    /**
     * Evento para la pulsación del ratón en la etiqueta de autores
     *
     * @param evt Evento
     */
    private void lblAutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAutoresMouseClicked
        // Llamamos al método pulsado
        pulsado();
    }//GEN-LAST:event_lblAutoresMouseClicked

    /**
     * Evento para la pulsación del ratón en la carátula
     *
     * @param evt Evento
     */
    private void lblCaratulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCaratulaMouseClicked
        // Llamamos al método pulsado
        pulsado();
    }//GEN-LAST:event_lblCaratulaMouseClicked

    /**
     * Evento para la pulsación del ratón en el formulario
     *
     * @param evt Evento
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // Llamamos al método pulsado
        pulsado();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAutores;
    private javax.swing.JLabel lblCaratula;
    private javax.swing.JLabel lblISBN;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para pasar valores desde el formulario de carátula al formulario
     * de libros
     */
    private void pulsado() {

        // Creamos un nuevo formulario de libros y pasamos
        // como parámetro los datos del libro recopilados
        FormularioLibros form = new FormularioLibros(this.libro);

        // Lo hacemos visible y ajustamos los controles del mismo
        form.setVisible(true);
        form.pack();

        // Creamos un nuevo objeto Formulario principal, donde guardaremos la 
        // referencia del actual
        FormularioPrincipal frame = (FormularioPrincipal) this.getTopLevelAncestor();

        // Quitamos todos los componentes del mismo
        frame.jDesktopPane1.removeAll();

        // Añadimos el nuevo formulario
        frame.jDesktopPane1.add(form);

        // Intentamos maximizarlo
        try {
            form.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Mensajes.mostrarMensaje(ex.getMessage(), Mensajes.TipoMensaje.ERROR);
        }
    }

}
