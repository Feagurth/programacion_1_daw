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

import javax.swing.JPanel;

/**
 * Clase para generar un filtro para la base de datos
 *
 * @author Luis Cabrerizo Gómez
 */
public class PanelFiltro extends javax.swing.JPanel {

    /**
     * Constructor de la clase PanelFiltro
     */
    public PanelFiltro() {

        // Inicializamos los componentes gráficos de la clase
        initComponents();

        // Hacemos el formulario visible
        this.setVisible(true);
    }

    /**
     * Método para habilitar o deshabilitar el botón de agregar nuevo filtro
     *
     * @param valor Verdadero para habilitarlo, falso para deshabilitarlo
     */
    public void habilitaNuevo(boolean valor) {
        btnAñadir.setEnabled(valor);
    }

    /**
     * Método para habilitar o deshabilitar el botón de eliminar un filtro
     *
     * @param valor Verdadero para habilitarlo, falso para deshabilitarlo
     */
    public void habilitaEliminar(boolean valor) {
        btnEliminar.setEnabled(valor);
    }

    /**
     * Método para recuperar el valor de los filtros de búsqueda y ordenación
     *
     * @return Un array de cadenas conteniendo el filtro de búsqueda y de
     * ordenación. La primera posición guardará el filtro de búsqueda y la
     * segunda posición el filtro de ordenación
     */
    public String[] getFiltros() {

        // Creamos la variable de salida
        String[] salida = new String[2];

        // Comprobamos si el campo texto no es vacío, si no lo es, tenemos filtro
        // de búsqueda
        if (!txtFiltro.getText().equals("")) {

            // Comprobamos que valor de filtro usaremos y vamos creando la
            // cadena de salida en consecuencia
            switch (cmbFiltro.getSelectedIndex()) {
                case 0: {
                    salida[0] = "ISBN LIKE ";
                    break;
                }
                case 1: {
                    salida[0] = "TITULO LIKE ";
                    break;
                }
                case 2: {
                    salida[0] = "AUTOR LIKE ";
                    break;
                }
                case 3: {
                    salida[0] = "NUMEROEDICION LIKE ";
                    break;
                }
                case 4: {
                    salida[0] = "EDITORIAL LIKE ";
                    break;
                }
                case 5: {
                    salida[0] = "COPYRIGHT LIKE ";
                    break;
                }
            }

            // Comprobamos el tipo de filtro que usaremos y seguimos creando
            // la cadena
            switch (cmbTipoFiltro.getSelectedIndex()) {
                case 0: {
                    salida[0] += "'%" + txtFiltro.getText() + "'";
                    break;
                }

                case 1: {
                    salida[0] += "'" + txtFiltro.getText() + "%'";
                    break;
                }
                case 2: {
                    salida[0] += "'%" + txtFiltro.getText() + "%'";
                    break;
                }
            }
        } else {
            salida[0] = "";
        }

        // Comprobamos el tipo de filtro seleccionado para crear la cadena de
        // ordenación
        switch (cmbFiltro.getSelectedIndex()) {
            case 0: {
                salida[1] = "ISBN ";

                break;
            }
            case 1: {
                salida[1] = "TITULO ";
                break;
            }
            case 2: {
                salida[1] = "AUTOR ";
                break;
            }
            case 3: {
                salida[1] = "NUMEROEDICION ";
                break;
            }
            case 4: {
                salida[1] = "EDITORIAL ";
                break;
            }
            case 5: {
                salida[1] = "COPYRIGHT ";
                break;
            }
        }

        // Comprobamos que tipo de ordenación se usará y se continúa creando
        // la cadena
        switch (cmbOrden.getSelectedIndex()) {
            case 0: {
                salida[1] += "ASC";
                break;
            }
            case 1: {
                salida[1] += "DESC";
                break;
            }

        }

        // Devolvemos el resultado
        return salida;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        cmbFiltro = new javax.swing.JComboBox();
        cmbTipoFiltro = new javax.swing.JComboBox();
        cmbOrden = new javax.swing.JComboBox();
        txtFiltro = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnAñadir = new javax.swing.JButton();

        panelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelPrincipal.setMaximumSize(new java.awt.Dimension(840, 48));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(840, 48));

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ISBN", "Titulo", "Autor", "NumeroEdicion", "Editorial", "Copyright" }));

        cmbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acaba", "Comienza", "Contiene" }));

        cmbOrden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ascendente", "Descendente" }));

        btnEliminar.setText("-");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAñadir.setText("+");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAñadir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAñadir)
                        .addComponent(btnEliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 623, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para crear un nueva caja de filtro
     *
     * @param evt Evento
     */
    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        // Llamamos al método crearCajaFiltro de DialogInformes
        DialogInformes.crearCajaFiltro((JPanel) this.getParent());
    }//GEN-LAST:event_btnAñadirActionPerformed

    /**
     * Método para eliminar una caja de filtro
     *
     * @param evt Evento
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // Llamamos al método eliminarCaja de DialogInformes
        DialogInformes.eliminarCajaFiltro(this);
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox cmbFiltro;
    private javax.swing.JComboBox cmbOrden;
    private javax.swing.JComboBox cmbTipoFiltro;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
