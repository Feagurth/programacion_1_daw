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
package RelacionesDeEjercicios.Relacion5.Ejercicio008_Content.formularios;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para mostrar la ventana principal de la aplicación
 *
 * @author Luis Cabrerizo Gómez
 */
public class FormularioPrincipal extends javax.swing.JFrame {

    /**
     * Constructor de la clase
     */
    public FormularioPrincipal() {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Inicializamos los componentes gráficos del formulario
        initComponents();

        //TODO: Quitar cuando se acabe el desarrollo de la aplicación
        btnBrowseActionPerformed(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnAutores = new javax.swing.JButton();
        btnBrowse = new javax.swing.JButton();
        btnInformes = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(590, 810));
        setResizable(false);

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(661, 549));
        jToolBar1.setMinimumSize(new java.awt.Dimension(661, 549));
        jToolBar1.setPreferredSize(new java.awt.Dimension(661, 549));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RelacionesDeEjercicios/Relacion5/Ejercicio008_Content/images/book_add.png"))); // NOI18N
        btnAdd.setText("Añadir Libro");
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd);

        btnAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RelacionesDeEjercicios/Relacion5/Ejercicio008_Content/images/writer.png"))); // NOI18N
        btnAutores.setText("Autores");
        btnAutores.setFocusable(false);
        btnAutores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAutores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoresActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAutores);

        btnBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RelacionesDeEjercicios/Relacion5/Ejercicio008_Content/images/library.png"))); // NOI18N
        btnBrowse.setText("Biblioteca");
        btnBrowse.setFocusable(false);
        btnBrowse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBrowse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBrowse);

        btnInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RelacionesDeEjercicios/Relacion5/Ejercicio008_Content/images/report.png"))); // NOI18N
        btnInformes.setText("Informes");
        btnInformes.setFocusable(false);
        btnInformes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInformes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformesActionPerformed(evt);
            }
        });
        jToolBar1.add(btnInformes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento para la pulsación del botón de añadir libros
     *
     * @param evt Evento
     */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        // Creamos un nuevo objeto FormularioLibros pasándole null como
        // parámetro para que se inicie en modo adición de libros
        FormularioLibros form = new FormularioLibros(null);

        // Lo hacemos visible y ajustamos los controles
        form.setVisible(true);
        form.pack();

        // Eliminamos todos los formularios anteriores que hubiesn en el
        // panel padre y añadimos el que acabamos de crear
        jDesktopPane1.removeAll();
        jDesktopPane1.add(form);

        try {
            // Maximizamos el formulario           
            form.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FormularioPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * Evento para la pulsación del botón de biblioteca
     *
     * @param evt Evento
     */
    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed

        // Creamos un nuevo objeto FormularioBiblioteca
        FormularioBiblioteca form = new FormularioBiblioteca();

        // Lo hacemos visible y ajustamos los controles
        form.setVisible(true);
        form.pack();

        // Eliminamos todos los formularios anteriores que hubiesn en el
        // panel padre y añadimos el que acabamos de crear
        jDesktopPane1.removeAll();
        jDesktopPane1.add(form);

        try {
            // Maximizamos el formulario           
            form.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FormularioPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    /**
     * Evento para la pulsación del botón de autores
     *
     * @param evt Evento
     */
    private void btnAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoresActionPerformed

        // Creamos un nuevo objeto FormularioAutores
        FormularioAutores form = new FormularioAutores();

        // Lo hacemos visible y ajustamos los controles
        form.setVisible(true);
        form.pack();

        // Eliminamos todos los formularios anteriores que hubiesn en el
        // panel padre y añadimos el que acabamos de crear
        jDesktopPane1.removeAll();
        jDesktopPane1.add(form);

        try {
            // Maximizamos el formulario           
            form.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FormularioPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }       }//GEN-LAST:event_btnAutoresActionPerformed

    /**
     * Evento para la pulsación del botón de informes
     *
     * @param evt Eventos
     */
    private void btnInformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformesActionPerformed

    }//GEN-LAST:event_btnInformesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAutores;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnInformes;
    public javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}