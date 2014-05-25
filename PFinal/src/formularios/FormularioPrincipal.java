/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formularios;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Super
 */
public class FormularioPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Formulario
     */
    public FormularioPrincipal() {
        initComponents();
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
        setMaximumSize(new java.awt.Dimension(590, 810));
        setMinimumSize(new java.awt.Dimension(590, 810));
        setPreferredSize(new java.awt.Dimension(590, 810));
        setResizable(false);

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(661, 549));
        jToolBar1.setMinimumSize(new java.awt.Dimension(661, 549));
        jToolBar1.setPreferredSize(new java.awt.Dimension(661, 549));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book_add.png"))); // NOI18N
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

        btnAutores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/writer.png"))); // NOI18N
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

        btnBrowse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/library.png"))); // NOI18N
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

        btnInformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        btnInformes.setText("Informes");
        btnInformes.setFocusable(false);
        btnInformes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInformes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnInformes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        FormularioLibros form = new FormularioLibros(null);
        form.setVisible(rootPaneCheckingEnabled);
        form.pack();

        jDesktopPane1.removeAll();
        jDesktopPane1.add(form);
        
        try {
            form.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FormularioPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        FormularioBiblioteca form = new FormularioBiblioteca();
        form.setVisible(rootPaneCheckingEnabled);        

        form.pack();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(form);
        try {
            form.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FormularioPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoresActionPerformed
        FormularioAutores form = new FormularioAutores();
        form.setVisible(rootPaneCheckingEnabled);        

        form.pack();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(form);
        try {
            form.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FormularioPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }       }//GEN-LAST:event_btnAutoresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormularioPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAutores;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnInformes;
    javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
