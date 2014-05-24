/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import db.BaseDeDatos;
import db.Resultado;
import java.awt.GridLayout;
import java.sql.SQLException;
import utiles.Mensajes;

/**
 *
 * @author Super
 */
public class FormularioBiblioteca extends javax.swing.JInternalFrame {

    private final BaseDeDatos baseDatos;
    private int paginacion = 1;
    private int paginacionMaxima = 1;

    /**
     * Creates new form FormularioBiblioteca
     */
    public FormularioBiblioteca() {
        initComponents();

        baseDatos = new BaseDeDatos("root", "", "127.0.0.1:3306", "libros");

        try {
            Resultado datos = baseDatos.consultar(
                    new String[]{"Count(*) as Total"},
                    new String[]{"titulos"}, null, null);

            if (datos.isOperacionCorrecta() && datos.getResultado().next()) {
                paginacionMaxima = (datos.getResultado().getInt("Total") / 9) + 1;
            }
        } catch (SQLException ex) {
            Mensajes.mostrarMensaje(ex.getMessage(), Mensajes.TipoMensaje.ERROR);
        }

        refrescarLibros(paginacion, null);

    }

    private void refrescarLibros(int pagina, String[] filtro) {
        try {

            Resultado datos = baseDatos.consultar(
                    new String[]{"*"},
                    new String[]{"titulos"},
                    filtro,
                    null,
                    new int[]{pagina - 1, 9});

            if (datos.isOperacionCorrecta()) {

                while (datos.getResultado().next()) {
                    pnlMain.setLayout(new GridLayout(0, 3, 1, 0));
                    pnlMain.add(new FormularioCaratula(datos.getResultado().getString("isbn")));
                }

                if (pagina == 1) {
                    btnLeft.setVisible(false);
                } else {
                    btnLeft.setVisible(true);
                }

                if (pagina == paginacionMaxima) {
                    btnRight.setVisible(false);
                } else {
                    btnRight.setVisible(true);
                }

            }
        } catch (SQLException ex) {
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

        btnRight = new javax.swing.JButton();
        btnLeft = new javax.swing.JButton();
        pnlMain = new javax.swing.JPanel();

        btnRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/next.png"))); // NOI18N
        btnRight.setBorder(null);
        btnRight.setBorderPainted(false);
        btnRight.setContentAreaFilled(false);

        btnLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prev.png"))); // NOI18N
        btnLeft.setBorder(null);
        btnLeft.setBorderPainted(false);
        btnLeft.setContentAreaFilled(false);

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event dispatch thread.
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnRight;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
