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

import java.awt.Component;
import java.util.Arrays;
import javax.swing.JPanel;

/**
 * Clase para lanzar informes a través de filtros creados dinámicamente
 *
 * @author Luis Cabrerizo Gómez
 */
public final class DialogInformes extends javax.swing.JDialog {

    // Contador del número de filtros establecidos por pestaña
    private static int contadorAutores = 0;
    private static int contadorTitulos = 0;

    // Número máximo de filtros para cada pestaña
    private static final int MAX_FILTROS_AUTORES = 4;
    private static final int MAX_FILTROS_TITULOS = 4;

    /**
     * Método para recuperar el máximo número de filtros para autores
     *
     * @return El número máximo de filtros para autores
     */
    public static int getMAX_FILTROS_AUTORES() {
        return MAX_FILTROS_AUTORES;
    }

    /**
     * Método para recuperar el máximo número de filtros para títulos
     *
     * @return El número máximo de filtros para títulos
     */
    public static int getMAX_FILTROS_TITULOS() {
        return MAX_FILTROS_TITULOS;
    }

    /**
     * Método para recuperar el número de filtros actuales para autores
     *
     * @return El número de filtros actuales para autores
     */
    public static int getContadorAutores() {
        return contadorAutores;
    }

    /**
     * Método para asignar el número de filtros que tiene la pestaña autores
     *
     * @param contadorAutores La cantidad de filtros de la pestaña autores
     */
    public static void setContadorAutores(int contadorAutores) {
        DialogInformes.contadorAutores = contadorAutores;
    }

    /**
     * Método para recuperar el número de filtros actuales para títulos
     *
     * @return El número de filtros actuales para títulos
     */
    public static int getContadorTitulos() {
        return contadorTitulos;
    }

    /**
     * Método para asignar el número de filtros que tiene la pestaña títulos
     *
     * @param contadorTitulos La cantidad de filtros de la pestaña títulos
     */
    public static void setContadorTitulos(int contadorTitulos) {
        DialogInformes.contadorTitulos = contadorTitulos;
    }

    /**
     * Constructor de la clase DialogInformes
     *
     * @param parent Ventana padre
     * @param modal Valor para especificar si la ventana va a ser moda o no
     */
    public DialogInformes(java.awt.Frame parent, boolean modal) {

        // Inicializamos el formulario
        super(parent, modal);
        initComponents();

        // Creamos dos cajas de filtro iniciales, una para autores y otra
        // para títulos
        DialogInformes.crearCajaFiltro(tbAutores);
        DialogInformes.crearCajaFiltro(tbTitulos);
    }

    /**
     * Método para eliminar un control de filtro
     *
     * @param panel Panel de filtro a eliminar
     */
    public static void eliminarCajaFiltro(PanelFiltro panel) {

        // Comprobamos quien es el padre de la caja de filtro
        if (panel.getParent().equals(tbAutores)) {

            // Disminuimos el número del contador de filtros de autores
            contadorAutores--;

            // Eliminamos el panel de filtro
            tbAutores.remove(panel);

            // Actualizamos y repintamos el formulario
            tbAutores.updateUI();
            tbAutores.repaint();

            // Habilitamos los controles de añadir y eliminar filtros
            habilitarControles(tbAutores);
        } else {
            // Disminuimos el número del contador de filtros de títulos
            contadorTitulos--;

            // Eliminamos el panel de filtro
            tbTitulos.remove(panel);

            // Actualizamos y repintamos el formulario
            tbTitulos.updateUI();
            tbTitulos.repaint();

            // Habilitamos los controles de añadir y eliminar filtros
            habilitarControles(tbTitulos);
        }
    }

    /**
     * Método para crear una nueva caja de filtro
     *
     * @param tab Panel donde se va a crear la nueva caja de filtro
     */
    public static void crearCajaFiltro(JPanel tab) {

        // Objeto para almacenar el filtro
        PanelFiltro tmp;

        // Comprobamos en que pestaña se va a crear el filtro
        if (tab.equals(tbTitulos)) {

            // Creamos el objeto y le pasamos como identificador el número
            // de filtro
            tmp = new PanelFiltro();

            // Incrementamos el número de filtros
            contadorTitulos++;
        } else {
            // Creamos el objeto y le pasamos como identificador el número
            // de filtro            
            tmp = new PanelFiltro();

            // Incrementamos el número de filtros
            contadorAutores++;
        }

        // Añadimos el objeto al panel
        tab.add(tmp);

        // Actualizamos 
        tab.updateUI();

        // Repintamos
        tab.repaint();

        // Habilitamos los controles
        habilitarControles(tab);

    }

    /**
     * Método para habilitar y deshabilitar los botones de añadir y eliminar
     * filtros
     *
     * @param tab Panel donde están los filtros
     */
    private static void habilitarControles(JPanel tab) {

        // Número máximo de filtros permitidos para la pestaña
        int valorMaximo;

        // Número de filtros que tiene la pestaña
        int valorActual;

        // Contador del número de filtros de la pestaña
        int contador = 1;

        // Comprobamos sobre que pestaña vamos a trabajar
        if (tab.equals(tbTitulos)) {

            // Recuperamos el valor actual y el valor máximo
            valorMaximo = MAX_FILTROS_TITULOS;
            valorActual = contadorTitulos;

        } else {

            // Recuperamos el valor actual y el valor máximo
            valorMaximo = MAX_FILTROS_AUTORES;
            valorActual = contadorAutores;
        }

        // Iteramos por los componentes que hay en el panel
        for (Component panel : tab.getComponents()) {

            // Si el componente no es el último de los componentes del panel
            if (contador < valorActual) {

                // Deshabilitamos el botón de añadir nuevo filtro
                ((PanelFiltro) panel).habilitaNuevo(false);
            } else {

                // Si no es así, lo habilitamos
                ((PanelFiltro) panel).habilitaNuevo(true);
            }

            // Comprobamos si el componente es el primero del panel
            if (contador == 1) {

                // Si es así, deshabilitamos el botón de eliminar
                ((PanelFiltro) panel).habilitaEliminar(false);
            } else {

                // Si no es así, lo habilitamos
                ((PanelFiltro) panel).habilitaEliminar(true);
            }

            // Comprobamos si el componente es el último del panel
            if (contador > valorMaximo) {
                // Si es así, deshabilitamos el botón de añadir nuevos filtros
                ((PanelFiltro) panel).habilitaNuevo(false);
            }

            // Aumentamos la variable contador
            contador++;
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tbAutores = new javax.swing.JPanel();
        tbTitulos = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(627, 324));
        setMinimumSize(new java.awt.Dimension(627, 324));
        setName("principal"); // NOI18N
        setResizable(false);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setAutoscrolls(true);

        tbAutores.setMaximumSize(new java.awt.Dimension(400, 10));
        tbAutores.setMinimumSize(new java.awt.Dimension(400, 10));
        tbAutores.setName("Autores"); // NOI18N
        tbAutores.setPreferredSize(new java.awt.Dimension(400, 10));
        jTabbedPane1.addTab("Autores", tbAutores);

        tbTitulos.setMaximumSize(new java.awt.Dimension(400, 10));
        tbTitulos.setMinimumSize(new java.awt.Dimension(400, 10));
        tbTitulos.setName("Titulos"); // NOI18N
        tbTitulos.setPreferredSize(new java.awt.Dimension(400, 10));
        jTabbedPane1.addTab("Titulos", tbTitulos);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para cerrar la ventana de filtro
     *
     * @param evt Evento
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Ocultamos la ventana
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Método para recuperar los filtros establecidos agruparlos y lanzar el
     * informe correspondiente
     *
     * @param evt Evento
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tbAutores.isShowing()) {
            for (Component component : tbAutores.getComponents()) {
                System.out.println(Arrays.toString(((PanelFiltro) component).getFiltros()));
            }
        } else {
            for (Component component : tbTitulos.getComponents()) {
                System.out.println(Arrays.toString(((PanelFiltro) component).getFiltros()));
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(DialogInformes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogInformes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogInformes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogInformes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DialogInformes dialog = new DialogInformes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JPanel tbAutores;
    private static javax.swing.JPanel tbTitulos;
    // End of variables declaration//GEN-END:variables

}
