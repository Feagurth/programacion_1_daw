/*
 * Copyright (C) 2013 Luis Cabrerizo Gómez
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
package Trimestre.Tercero.Ejercicios;

import java.awt.Color;

/**
 * Crea un sistema de menús para cambiar el color del fondo de la ventana y su
 * tamaño
 *
 * @author Luis Cabrerizo Gomez
 */
public class EjercicioDeClase002 extends javax.swing.JFrame {

    /**
     * Creates new form EjercicioDeClase002
     */
    public EjercicioDeClase002() {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        mnuOpciones = new javax.swing.JMenu();
        mnuTamaño = new javax.swing.JMenu();
        mnu640 = new javax.swing.JMenuItem();
        mnu800 = new javax.swing.JMenuItem();
        mnu1024 = new javax.swing.JMenuItem();
        mnuColor = new javax.swing.JMenu();
        mnuRojo = new javax.swing.JMenuItem();
        mnuVerde = new javax.swing.JMenuItem();
        mnuAzul = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuOpciones.setText("Opciones");

        mnuTamaño.setText("Tamaño de Ventana");

        mnu640.setText("640x480");
        mnu640.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu640ActionPerformed(evt);
            }
        });
        mnuTamaño.add(mnu640);

        mnu800.setText("800x600");
        mnu800.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu800ActionPerformed(evt);
            }
        });
        mnuTamaño.add(mnu800);

        mnu1024.setText("1024x768");
        mnu1024.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu1024ActionPerformed(evt);
            }
        });
        mnuTamaño.add(mnu1024);

        mnuOpciones.add(mnuTamaño);

        mnuColor.setText("Color de Fondo");

        mnuRojo.setText("Rojo");
        mnuRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRojoActionPerformed(evt);
            }
        });
        mnuColor.add(mnuRojo);

        mnuVerde.setText("Verde");
        mnuVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVerdeActionPerformed(evt);
            }
        });
        mnuColor.add(mnuVerde);

        mnuAzul.setText("Azul");
        mnuAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAzulActionPerformed(evt);
            }
        });
        mnuColor.add(mnuAzul);

        mnuOpciones.add(mnuColor);

        jMenuBar1.add(mnuOpciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnu640ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu640ActionPerformed
        this.setSize(640, 480);
    }//GEN-LAST:event_mnu640ActionPerformed

    private void mnu800ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu800ActionPerformed
        this.setSize(800, 600);
    }//GEN-LAST:event_mnu800ActionPerformed

    private void mnu1024ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu1024ActionPerformed
        this.setSize(1024, 768);
    }//GEN-LAST:event_mnu1024ActionPerformed

    private void mnuRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRojoActionPerformed
        this.getContentPane().setBackground(Color.RED);
    }//GEN-LAST:event_mnuRojoActionPerformed

    private void mnuVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVerdeActionPerformed
        this.getContentPane().setBackground(Color.GREEN);
    }//GEN-LAST:event_mnuVerdeActionPerformed

    private void mnuAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAzulActionPerformed
        this.getContentPane().setBackground(Color.BLUE);
    }//GEN-LAST:event_mnuAzulActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EjercicioDeClase002.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EjercicioDeClase002.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EjercicioDeClase002.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EjercicioDeClase002.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EjercicioDeClase002().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnu1024;
    private javax.swing.JMenuItem mnu640;
    private javax.swing.JMenuItem mnu800;
    private javax.swing.JMenuItem mnuAzul;
    private javax.swing.JMenu mnuColor;
    private javax.swing.JMenu mnuOpciones;
    private javax.swing.JMenuItem mnuRojo;
    private javax.swing.JMenu mnuTamaño;
    private javax.swing.JMenuItem mnuVerde;
    // End of variables declaration//GEN-END:variables
}
