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
import db.Resultado;
import java.awt.GridLayout;
import java.sql.SQLException;
import utiles.Mensajes;

/**
 * Clase para mostrar los libros de la base de datos con carátulas y texto
 *
 * @author Luis Cabrerizo Gómez
 */
public class FormularioBiblioteca extends javax.swing.JInternalFrame {

    // Variables de instancia
    private final BaseDeDatos baseDatos;

    // Variables para el control de la paginación
    private int paginacion = 1;
    private int paginacionMaxima = 1;

    /**
     * Constructor de la clase
     */
    public FormularioBiblioteca() {

        // Inicializamos los componentes del formulario
        initComponents();

        // Creamos una nueva conexión con la base de datos
        baseDatos = new BaseDeDatos("root", "", "127.0.0.1:3306", "libros");
        
        // Cambiamos el tipo de filtro predefinido en el combo
        cmbTipoFiltro.setSelectedIndex(1);

        try {

            // Realizamos una consulta para traer el número total de registros
            // de la tabla títulos
            Resultado datos = baseDatos.consultar(
                    new String[]{"Count(*) as Total"},
                    new String[]{"titulos"}, null, null);

            // Comprobamos si la operación es correcta y si trae resultados
            if (datos.isOperacionCorrecta() && datos.getResultado().next()) {

                // Calculamos el número máximo de páginas que tendremos
                // dividiendo el total entre 9, el numero de libros a mostrar por
                // página y redondeando al entero mas cercano por arriba 
                paginacionMaxima = (int) Math.ceil(datos.getResultado().getInt("Total") / 9f);
            }

            // Comprobamos si el ResultSet está cerrado
            if (!datos.getResultado().isClosed()) {

                // Si no lo está, lo cerramos
                datos.getResultado().close();
            }

        } catch (SQLException ex) {
            // Mostramos un mensaje de error si se produce una excepción al
            // cerrar el ResultSet
            Mensajes.mostrarMensaje(ex.getMessage(), Mensajes.TipoMensaje.ERROR);
        }

        // Refrescamos el contenido del formulario en base
        // a la página en la que nos encontremos
        refrescarLibros(paginacion);

    }

    /**
     * Función para la creación del filtro de libros
     *
     * @return
     */
    private String[] crearFiltro() {

        // Inicializamos una nueva variable
        String sql = "";

        // Comprobamos el tipo de filtro que especifica el combo y creamos
        // la condición especificada en función de su valor
        switch (cmbTipoFiltro.getSelectedIndex()) {
            case 0:
                sql = "ISBN LIKE '" + txtFiltro.getText() + "%'";
                break;

            case 1:
                sql = "TITULO LIKE '" + txtFiltro.getText() + "%'";
                break;

            case 2: {
                sql = "NUMEROEDICION LIKE '" + txtFiltro.getText() + "%'";
                break;
            }
            case 3: {
                sql = "EDITORIAL LIKE '" + txtFiltro.getText() + "%'";
                break;
            }
            case 4: {
                sql = "COPYRIGHT LIKE '" + txtFiltro.getText() + "%'";
                break;
            }
            default:
            {}
        }

        // Devolvemos el filtro creado
        return new String[]{sql};

    }

    /**
     * Método para mostrar la información en el formulario en base a la página
     * de paginación en la que nos encontremos
     * @param pagina Número de página
     */
    private void refrescarLibros(int pagina) {
        try {

            // Realizamos una consulta con la base de datos para traer los
            // isbn correspondientes a la página actual
            Resultado datos = baseDatos.consultar(
                    new String[]{"isbn"},
                    new String[]{"titulos"},
                    crearFiltro(),
                    crearOrden(),
                    new int[]{(pagina - 1) * 9, 9});

            // Comprobamos si la operación es correcta
            if (datos.isOperacionCorrecta()) {

                // Limpiamos el panel
                pnlMain.removeAll();
                
                // Ajustamos el layout del panel a uno tipo grid de 3 objetos de
                // por columa y filas sin determinar
                pnlMain.setLayout(new GridLayout(0, 3, 1, 1));
                
                // Mientras haya datos añadimos al panel objetos FormularioCaratula
                // al que pasaremos el isbn correspondiente
                while (datos.getResultado().next()) {                    
                    pnlMain.add(new FormularioCaratula(datos.getResultado().getString("isbn")));
                }

                // Si la paginación es igual a 1, ocultamos el botón de
                // decrementar paginación, si no es así, lo mostramos
                if (pagina == 1) {
                    btnLeft.setVisible(false);
                } else {
                    btnLeft.setVisible(true);
                }

                // Si la paginación es igual a la paginación máxima, ocultamos 
                // el botón de incrementar paginación, si no es así, lo mostramos
                
                if (pagina == paginacionMaxima) {
                    btnRight.setVisible(false);
                } else {
                    btnRight.setVisible(true);
                }

                // Actualizamos la interfaz de usuario
                pnlMain.updateUI();

                // Comprobamos si el ResultSet está cerrado
                if (!datos.getResultado().isClosed()) {
                    // Si no lo está lo cerramos
                    datos.getResultado().close();
                }

            }
        } catch (SQLException ex) {
            // Mostramos un mensaje si se produce un error durante el cierre 
            // del ResultSet
            Mensajes.mostrarMensaje(ex.getMessage(), Mensajes.TipoMensaje.ERROR);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        btnRight = new javax.swing.JButton();
        btnLeft = new javax.swing.JButton();
        panelFiltro = new javax.swing.JPanel();
        cmbTipoFiltro = new javax.swing.JComboBox();
        txtFiltro = new javax.swing.JTextField();
        lblTipoFiltro = new javax.swing.JLabel();
        lblValorFiltro = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setMaximumSize(new java.awt.Dimension(398, 457));
        pnlMain.setMinimumSize(new java.awt.Dimension(398, 457));

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 420, 590));

        btnRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        btnRight.setBorder(null);
        btnRight.setBorderPainted(false);
        btnRight.setContentAreaFilled(false);
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });
        getContentPane().add(btnRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 700, -1, 24));

        btnLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prev.png"))); // NOI18N
        btnLeft.setBorder(null);
        btnLeft.setBorderPainted(false);
        btnLeft.setContentAreaFilled(false);
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });
        getContentPane().add(btnLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, -1, 24));

        panelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        cmbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ISBN", "Título", "Edición", "Editorial", "Año" }));
        cmbTipoFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoFiltroItemStateChanged(evt);
            }
        });

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        lblTipoFiltro.setText("Tipo");

        lblValorFiltro.setText("Valor");

        javax.swing.GroupLayout panelFiltroLayout = new javax.swing.GroupLayout(panelFiltro);
        panelFiltro.setLayout(panelFiltroLayout);
        panelFiltroLayout.setHorizontalGroup(
            panelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTipoFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblValorFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelFiltroLayout.setVerticalGroup(
            panelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoFiltro)
                    .addComponent(lblValorFiltro))
                .addContainerGap())
        );

        getContentPane().add(panelFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 420, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento para la pulsación de decremento de la paginación
     *
     * @param evt Evento
     */
    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        // Aumentamos el valor de paginación
        paginacion++;

        // Refrescamos el contenido del formulario en base
        // a la página en la que nos encontremos        
        refrescarLibros(paginacion);
    }//GEN-LAST:event_btnRightActionPerformed

    /**
     * Evento para la pulsación de decremento de la paginación
     *
     * @param evt Evento
     */
    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        // Disminuimos el valor de paginación
        paginacion--;

        // Refrescamos el contenido del formulario en base
        // a la página en la que nos encontremos        
        refrescarLibros(paginacion);
    }//GEN-LAST:event_btnLeftActionPerformed

    /**
     * Evento para la pulsación de teclas dentro de la caja de filtro
     *
     * @param evt Evento
     */
    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased

        // Reseteamos el valor de paginación
        paginacion = 1;

        // Refrescamos el contenido del formulario en base
        // a la página en la que nos encontremos
        refrescarLibros(paginacion);

    }//GEN-LAST:event_txtFiltroKeyReleased

    private void cmbTipoFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoFiltroItemStateChanged
        refrescarLibros(paginacion);
    }//GEN-LAST:event_cmbTipoFiltroItemStateChanged

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event dispatch thread.
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnRight;
    private javax.swing.JComboBox cmbTipoFiltro;
    private javax.swing.JLabel lblTipoFiltro;
    private javax.swing.JLabel lblValorFiltro;
    private javax.swing.JPanel panelFiltro;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables

    /**
     * Método que nos permite generar un orden para la consulta de libros
     * basado en la selección del comboBox del formulario
     * @return Un array con la ordenación
     */
    private String[] crearOrden() {
        // Inicializamos una nueva variable
        String sql = "";

        // Comprobamos el tipo de filtro que especifica el combo y creamos
        // la condición especificada en función de su valor
        switch (cmbTipoFiltro.getSelectedIndex()) {
            case 0:
                sql = "ISBN ASC";
                break;

            case 1:
                sql = "TITULO ASC";
                break;

            case 2: {
                sql = "NUMEROEDICION ASC";
                break;
            }
            case 3: {
                sql = "EDITORIAL ASC";
                break;
            }
            case 4: {
                sql = "COPYRIGHT ASC";
                break;
            }
            default:
            {}
        }

        // Devolvemos el filtro creado
        return new String[]{sql};
        
    }
}
