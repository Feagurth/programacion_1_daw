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
import java.awt.event.MouseListener;
import java.sql.SQLException;
import utiles.Mensajes;
import utiles.Validaciones;

/**
 * Clase para el formulario de autores
 *
 * @author Luis Cabrerizo Gómez
 */
public class FormularioAutores extends javax.swing.JInternalFrame {

    // Variables de instancia
    private final BaseDeDatos baseDatos;
    private String modo;

    /**
     * Constructor de la clase
     */
    public FormularioAutores() {

        // Iniciamos los componentes del formulario
        initComponents();

        // Ocultamos la etiqueta donde guardaremos el identificador del autor
        lblIdAutor.setVisible(false);

        // Creamos una nueva conexión a la base de datos
        baseDatos = new BaseDeDatos();

        // Ajustamos las selecciones de los combos y hacemos invisibles los
        // botones de aceptar y cancelar
        cmbCampo.setSelectedIndex(1);
        cmbOrden.setSelectedIndex(0);
        btnAceptar.setVisible(false);
        btnCancelar.setVisible(false);

    }

    /**
     * Método que se encarga de rellenar la tabla con valores
     */
    private void recargarGrid() {

        // Inicializamos variables para el orden y el filtrado de los registros
        // de la tabla
        String orden = "";
        String filtro = "";

        // Comprobamos los valores seleccionados en los combos de ordenación
        // y creamos la cadena de ordenación en consecuencia
        if (cmbCampo.getSelectedIndex() == 0) {
            if (cmbOrden.getSelectedIndex() == 0) {
                orden += "primerNombre ASC";
            } else {
                orden += "primerNombre DESC";
            }
        } else {
            if (cmbOrden.getSelectedIndex() == 0) {
                orden += "apellidoPaterno ASC";
            } else {
                orden += "apellidoPaterno DESC";
            }
        }

        // Comprobamos los valores seleccionados por el combo de filtro
        // y creamos la cadena de filtrado en consecuencia
        if (cmbFiltro.getSelectedIndex() == 0) {
            filtro += "primerNombre LIKE '" + txtFiltro.getText() + "%'";
        } else {
            filtro += "apellidoPaterno LIKE '" + txtFiltro.getText() + "%'";
        }

        // Realiamos una consulta a la base de datos para que devuelva los valores
        // necesarios para rellenar la tabla, pasandole el filtro y el ordenamiento
        // creado
        Resultado datos = baseDatos.consultar(
                new String[]{"IdAutor", "primerNombre As Nombre", "apellidoPaterno As Apellido"},
                new String[]{"Autores"},
                new String[]{filtro},
                new String[]{orden});

        try {

            // Asignamos a la tabla el modelo de tabla generado a partir del resultado
            tblAutores.setModel(BaseDeDatos.buildTableModel(datos.getResultado()));
            tblAutores.removeColumn(tblAutores.getColumnModel().getColumn(0));

            // Verificamos si el ResultSet se ha cerrado
            if (!datos.getResultado().isClosed()) {
                // Si no se ha cerrado, lo cerramos manualmente
                datos.getResultado().close();
            }

        } catch (SQLException ex) {
            // Mostramos un mensaje de error si se ha producido una excepción al
            // cerrar el ResultSet
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

        panelOrden = new javax.swing.JPanel();
        cmbCampo = new javax.swing.JComboBox();
        cmbOrden = new javax.swing.JComboBox();
        lblOrden = new javax.swing.JLabel();
        lblCampo = new javax.swing.JLabel();
        panelFiltro = new javax.swing.JPanel();
        cmbFiltro = new javax.swing.JComboBox();
        lblFiltro = new javax.swing.JLabel();
        lblCampoFiltro = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        panelTabla = new javax.swing.JScrollPane();
        tblAutores = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        ;
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        btnAñadir = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblIdAutor = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(446, 532));
        setMinimumSize(new java.awt.Dimension(446, 532));

        panelOrden.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden"));

        cmbCampo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Apellido" }));
        cmbCampo.setMaximumSize(new java.awt.Dimension(88, 20));
        cmbCampo.setMinimumSize(new java.awt.Dimension(88, 20));
        cmbCampo.setPreferredSize(new java.awt.Dimension(88, 20));
        cmbCampo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCampoItemStateChanged(evt);
            }
        });

        cmbOrden.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ascendente", "Descendente" }));
        cmbOrden.setMaximumSize(new java.awt.Dimension(88, 20));
        cmbOrden.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOrdenItemStateChanged(evt);
            }
        });

        lblOrden.setText("Orden");

        lblCampo.setText("Campo");

        javax.swing.GroupLayout panelOrdenLayout = new javax.swing.GroupLayout(panelOrden);
        panelOrden.setLayout(panelOrdenLayout);
        panelOrdenLayout.setHorizontalGroup(
            panelOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrdenLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblCampo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCampo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(lblOrden)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelOrdenLayout.setVerticalGroup(
            panelOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOrdenLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panelOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmbCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrden)
                    .addComponent(lblCampo))
                .addContainerGap())
        );

        panelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Apellido" }));
        cmbFiltro.setMaximumSize(new java.awt.Dimension(88, 20));
        cmbFiltro.setMinimumSize(new java.awt.Dimension(88, 20));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(88, 20));
        cmbFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFiltroItemStateChanged(evt);
            }
        });

        lblFiltro.setText("Orden");

        lblCampoFiltro.setText("Campo");

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelFiltroLayout = new javax.swing.GroupLayout(panelFiltro);
        panelFiltro.setLayout(panelFiltroLayout);
        panelFiltroLayout.setHorizontalGroup(
            panelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltroLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblCampoFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFiltro)
                .addGap(18, 18, 18)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelFiltroLayout.setVerticalGroup(
            panelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltroLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmbFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(lblFiltro)
                    .addComponent(lblCampoFiltro)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblAutores.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblAutores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblAutores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAutoresMouseClicked(evt);
            }
        });
        panelTabla.setViewportView(tblAutores);

        txtNombre.setEditable(false);

        txtApellidos.setEditable(false);

        lblApellido.setText("Apellido");

        lblNombre.setText("Nombre");

        btnAñadir.setText("Añadir");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

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
                        .addGap(12, 12, 12)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(txtApellidos))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdAutor)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelOrden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblIdAutor)
                .addGap(12, 12, 12)
                .addComponent(panelOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(panelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(lblApellido))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAñadir)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento para el cambio de valor en el combo de orden
     *
     * @param evt Evento
     */
    private void cmbOrdenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOrdenItemStateChanged
        // Recargamos el grid
        recargarGrid();
    }//GEN-LAST:event_cmbOrdenItemStateChanged

    /**
     * Evento para el cambio de valor en el combo de campo
     *
     * @param evt Evento
     */
    private void cmbCampoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCampoItemStateChanged
        // Recargamos el grid
        recargarGrid();
    }//GEN-LAST:event_cmbCampoItemStateChanged

    /**
     * Evento para la pulsación del ratón en la tabla
     *
     * @param evt Evento
     */
    private void tblAutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutoresMouseClicked

        // Cargamos con los valores seleccionados los textos y etiquetas necesarios
        lblIdAutor.setText(String.valueOf(tblAutores.getModel().getValueAt(tblAutores.rowAtPoint(evt.getPoint()), 0)));
        txtNombre.setText((String) tblAutores.getValueAt(tblAutores.rowAtPoint(evt.getPoint()), 0));
        txtApellidos.setText((String) tblAutores.getValueAt(tblAutores.rowAtPoint(evt.getPoint()), 1));

    }//GEN-LAST:event_tblAutoresMouseClicked

    /**
     * Evento para la pulsación del botón de añadir
     *
     * @param evt Evento
     */
    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed

        // Activamos el modo edición
        modoEdicion(true);

        // Cambiamos a modo de añadir
        this.modo = "A";

        // Limpiamos los campos de nombre y apellidos
        txtNombre.setText("");
        txtApellidos.setText("");
    }//GEN-LAST:event_btnAñadirActionPerformed

    /**
     * Evento para la pulsación del botón de cancelar
     *
     * @param evt Evento
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Cancelamos el modo edición
        modoEdicion(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Evento para la pulsación del botón de modificar
     *
     * @param evt Evento
     */
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        // Comprobamos que haya seleccionada una opción
        if (tblAutores.getSelectedRowCount() != 0) {

            // Activamos el modo de edición
            modoEdicion(true);

            // Cambiamos a modo de modificación de datos
            this.modo = "M";

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * Evento para la pulsación del botón de eliminar
     *
     * @param evt Evento
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        // Comprobamos que haya un registro seleccionado de la tabla antes de 
        // continuar
        if (tblAutores.getSelectedRowCount() != 0) {

            // Mostramos un mensaje al usuario para pedir confirmación
            if (Mensajes.pedirConfirmacion(String.format(
                    "%s %s%n¿Desea eliminar este autor?",
                    txtNombre.getText(),
                    txtApellidos.getText()))) {

                // Si el usuario confirma, lanzamos la consulta a la base de datos
                // y almacenamos el resultado
                Resultado datos = baseDatos.eliminar(
                        new String[]{"Autores"},
                        new String[]{"idAutor = " + lblIdAutor.getText()});

                // Verificamos si la operación es correcta
                if (datos.isOperacionCorrecta()) {

                    // Si lo es mostramos un mensaje y recargamos el grid
                    Mensajes.mostrarMensaje("Operación realizada correctamente", Mensajes.TipoMensaje.INFORMACION);
                    recargarGrid();
                } else {
                    // Si no es correcta, mostramos un mensaje con el error
                    Mensajes.mostrarMensaje(datos.getMensaje(), Mensajes.TipoMensaje.ERROR);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Función que nos permite validar si los datos introducidos para una
     * inserción o actualización son correctos
     *
     * @return Verdadero si son datos válidos, falso en caso contrario
     */
    private boolean validarDatos() {
        // Inicializamos la variable de salida a verdaero
        boolean salida = true;

        // Verificamos que texto introcido en el nombre se corresponda con la validación
        if (!Validaciones.validarDato(txtNombre.getText(), Validaciones.TipoValidacion.CADENA_NUMEROS_SIMBOLOS)) {
            salida = false;
        }

        // Verificamos que texto introcido en el apellido se corresponda con la validación
        if (!Validaciones.validarDato(txtApellidos.getText(), Validaciones.TipoValidacion.CADENA_NUMEROS_SIMBOLOS)) {
            salida = false;
        }

        // Devolvemos el resultado
        return salida;
    }

    /**
     * Evento para la pulsación del botón de aceptar
     *
     * @param evt Evento
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        // Validamos los datos introducidos por el usuario
        if (validarDatos()) {

            // Comprobamos si se esta modificando un registro o dando uno nuevo
            // de alta
            if (this.modo.equals("M")) {

                // Realizamos la consulta con la base de datos para realizar
                // la actualización de datos y almacenamos el resultado de la 
                // operación en una variable
                Resultado datos = baseDatos.actualizar(
                        new String[]{"primerNombre", "apellidoPaterno"},
                        new String[]{"Autores"},
                        new String[]{"idAutor = " + lblIdAutor.getText()},
                        new String[]{txtNombre.getText(), txtApellidos.getText()});

                // Verificamos si la operación se ha realizado correctamente
                if (datos.isOperacionCorrecta()) {

                    // Si es así mostramos un mensaje de información y recargamos
                    // el los valores de la tabla
                    Mensajes.mostrarMensaje("Operación realizada correctamente", Mensajes.TipoMensaje.INFORMACION);
                    recargarGrid();

                } else {
                    // Si no es así mostramos un mensaje de error
                    Mensajes.mostrarMensaje(datos.getMensaje(), Mensajes.TipoMensaje.ERROR);
                }

            } else {

                // Si es una insercción, realizamos una consulta a la base de datos
                // para insertar el registro, almacenando el resultado de la 
                // operación en una variable
                Resultado datos = baseDatos.actualizar(
                        null,
                        new String[]{"Autores"},
                        null,
                        new String[]{"0", txtNombre.getText(), txtApellidos.getText()});

                // Verificamos si la operación se ha realizado correctamente
                if (datos.isOperacionCorrecta()) {

                    // Si es así, mostramos un mensaje y recargamos los datos
                    // de la tabla
                    Mensajes.mostrarMensaje("Operación realizada correctamente", Mensajes.TipoMensaje.INFORMACION);
                    recargarGrid();

                } else {
                    // Si no es así mostramos un mensaje de error
                    Mensajes.mostrarMensaje(datos.getMensaje(), Mensajes.TipoMensaje.ERROR);
                }
            }

            // Desactivamos el modo de edición
            modoEdicion(false);
        } else {
            // Mostramos un mensaje para la modificación de datos erroneos
            Mensajes.mostrarMensaje("Debe introducir datos correctos para poder continuar", Mensajes.TipoMensaje.AVISO);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * Evento para el cambio de valor del combo de Filtro
     *
     * @param evt Evento
     */
    private void cmbFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFiltroItemStateChanged
        // Recargamos los datos de la tabla
        recargarGrid();
    }//GEN-LAST:event_cmbFiltroItemStateChanged

    /**
     * Evento para la pulsación de teclas en el cuadro de texto de filtro
     *
     * @param evt Evento
     */
    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        // Recargamos los datos de la tabla
        recargarGrid();
    }//GEN-LAST:event_txtFiltroKeyReleased

    /**
     * Método para habilitar el modo de edición o deshabilitarlo
     *
     * @param modo Verdadero para activarlo, falso para desactivarlo
     */
    private void modoEdicion(boolean modo) {

        // Los controles se activan, desactivan, muestran u ocultan dependiendo
        // del valor del parámetro
        btnAñadir.setVisible(!modo);
        btnModificar.setVisible(!modo);
        btnEliminar.setVisible(!modo);
        btnAceptar.setVisible(modo);
        btnCancelar.setVisible(modo);
        tblAutores.setEnabled(!modo);
        cmbCampo.setEnabled(!modo);
        cmbOrden.setEnabled(!modo);
        cmbFiltro.setEnabled(!modo);
        tblAutores.setColumnSelectionAllowed(false);
        tblAutores.setCellSelectionEnabled(false);
        tblAutores.setRowSelectionAllowed(!modo);
        txtApellidos.setEditable(modo);
        txtNombre.setEditable(modo);
        txtFiltro.setEditable(!modo);

        // Quitamos los listeners de la tabla para evitar 
        // cambiar los valores durante el modo de edición
        // y los añadimos de nuevo si se desactiva el modo edición
        if (modo) {
            MouseListener[] listeners = tblAutores.getMouseListeners();
            for (MouseListener l : listeners) {
                tblAutores.removeMouseListener(l);
            }

            txtNombre.requestFocus();

        } else {
            tblAutores.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tblAutoresMouseClicked(evt);
                }
            });
            tblAutores.updateUI();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cmbCampo;
    private javax.swing.JComboBox cmbFiltro;
    private javax.swing.JComboBox cmbOrden;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCampo;
    private javax.swing.JLabel lblCampoFiltro;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblIdAutor;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblOrden;
    private javax.swing.JPanel panelFiltro;
    private javax.swing.JPanel panelOrden;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JTable tblAutores;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
