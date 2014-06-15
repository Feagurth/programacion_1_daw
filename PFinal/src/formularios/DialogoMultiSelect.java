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

import datos.BaseDeDatos;
import datos.Resultado;
import java.sql.SQLException;
import javax.swing.ListSelectionModel;
import utiles.Mensajes;

/**
 * Clase que nos muestra un grid en el cual podemos elegir varias opciones, en
 * este caso concreto de autores
 *
 * @author Luis Cabrerizo Gómez
 */
public class DialogoMultiSelect extends javax.swing.JDialog {

    private final BaseDeDatos baseDatos;
    private String[] seleccion = new String[0];

    /**
     * Método que nos permite recuperar los valores almacenados de selección del
     * grid
     *
     * @return Los valores seleccionados del grid
     */
    public String[] getSeleccion() {
        return seleccion;
    }

    /**
     * Constructor de la clase
     *
     * @param parent Ventana padre de esta
     * @param modal Especificación sobre si la ventana será una ventana modal o
     * no
     * @param idAutores Ids de autores que queremos que salgan seleccionados al
     * inicio
     */
    public DialogoMultiSelect(java.awt.Frame parent, boolean modal, String[] idAutores) {
        super(parent, modal);
        initComponents();

        // Creamos un objeto BaseDeDatos con el que comunicarnos con la base de 
        // datos
        baseDatos = new BaseDeDatos("root", "", "127.0.0.1:3306", "libros");

        // Especificamos el tipo de selección que queremos en la tabla, en este
        // caso solo está permitida la selección de filas completas
        tblValores.setColumnSelectionAllowed(false);
        tblValores.setCellSelectionEnabled(false);
        tblValores.setRowSelectionAllowed(true);
        tblValores.setCellEditor(null);

        // Recargamos el grid
        recargarGrid();

        // Comprobamos si se han psado autores como parámetros para que se 
        // muestren marcados
        if (idAutores != null) {

            // Almacenamos el modelo de la lista de selección y limpiamos los
            // seleccionados
            ListSelectionModel model = tblValores.getSelectionModel();
            model.clearSelection();

            // Iteramos por todos los los autores pasados como parámetros
            for (String idAutor : idAutores) {
                // Iteramos por las columas que contenga  el modelos de selección
                for (int i = 0; i < tblValores.getModel().getRowCount(); i++) {

                    // Si coincide el valor del id del parámetro con el id del 
                    // modelos de selección seleccionamos ese registro
                    if (tblValores.getModel().getValueAt(i, 0).toString().equals(idAutor)) {
                        model.addSelectionInterval(i, i);
                    }
                }
            }

            // Asignamos el modelo de selección a la tabla
            tblValores.setSelectionModel(model);
        }
    }

    /**
     * Método para recargar la tabla y asignarle el estilo de la misma
     */
    private void recargarGrid() {

        // Realizamos una consulta para traer los valores de autores de la base
        // de datos
        Resultado datos = baseDatos.consultar(
                new String[]{"IdAutor", "concat(primerNombre, ' ', apellidoPaterno) As Nombre"},
                new String[]{"Autores"},
                null,
                new String[]{"Nombre ASC"});

        try {
            // Asignamos el modelo de la tabla a partir de los resultados
            tblValores.setModel(BaseDeDatos.buildTableModel(datos.getResultado()));

            // Eliminamos la primera columna de la tabla, escondiendo de 
            // este modo la columna de los ids de los autores
            tblValores.removeColumn(tblValores.getColumnModel().getColumn(0));

            // Definimos que se van a poder seleccionar varios registros y que
            // se seleccionarán filas enteras
            tblValores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            tblValores.setRowSelectionAllowed(true);

            // Negamos la selección de columnas
            tblValores.setColumnSelectionAllowed(false);

            // Verificamos si el ResulSet está cerrado
            if (!datos.getResultado().isClosed()) {
                // Si no lo está lo cerramos
                datos.getResultado().close();
            }

        } catch (SQLException ex) {
            // Si se produce una excepción, mostramos un mensaje de erro
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

        btnOk = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblValores = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnOk.setText("Seleccionar");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        tblValores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblValores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnOk, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento del botón de selección
     *
     * @param evt Evento
     */
    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

        // Creamos un array del mismo tamaño que el número de filas seleccionadas
        seleccion = new String[tblValores.getSelectedRowCount()];
        int i = 0;

        // Recorremos los valores seleccionados en la tabla
        for (int fila : tblValores.getSelectedRows()) {

            // Almacenamos el id del autor seleccionado y lo guardamos en el array
            seleccion[i] = String.valueOf(tblValores.getModel().getValueAt(fila, 0));
            i++;
        }

        // Ocultamos la ventana
        this.setVisible(false);
    }//GEN-LAST:event_btnOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblValores;
    // End of variables declaration//GEN-END:variables
}
