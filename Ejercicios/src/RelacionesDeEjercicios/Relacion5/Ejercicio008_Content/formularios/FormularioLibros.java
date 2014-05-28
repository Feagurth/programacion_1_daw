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

import RelacionesDeEjercicios.Relacion5.Ejercicio008_Content.db.BaseDeDatos;
import RelacionesDeEjercicios.Relacion5.Ejercicio008_Content.db.Libro;
import RelacionesDeEjercicios.Relacion5.Ejercicio008_Content.db.Resultado;
import Utiles.Mensajes;
import Utiles.Validaciones;

/**
 * Clase para la creación del formulario de libros
 *
 * @author Luis Cabrerizo Gómez
 */
public class FormularioLibros extends javax.swing.JInternalFrame {

    private final BaseDeDatos baseDatos;
    private String modo = "A";
    private Libro libro;

    /**
     * Constructor de la clase
     *
     * @param libro Objeto libro con la información a mostrar del libro
     */
    public FormularioLibros(Libro libro) {

        // Inicializamos los componentes que forman parte del formulario
        initComponents();

        // Oculatamos la etiqueta de Ids de autores, donde almacenaremos los
        // valores para su uso posterior
        lblIdAutores.setVisible(false);

        // Guardamos el valor del parámetro en la variable de instancia
        this.libro = libro;

        // Creamos una nueva conexión con la base de datos
        baseDatos = new BaseDeDatos("root", "", "127.0.0.1:3306", "libros");

        // Ocultamos los botones de aceptar y de cancelar
        btnAceptar.setVisible(false);
        btnCancelar.setVisible(false);

        // Si el parámetro no es nulo rellenamos los campos con sus valores
        // Solo se puede llamar a esta pantalla con valores desde la pantalla
        // de biblioteca para mirar el resto de información del libro, por tanto
        // inicialmente no activamos la edición
        if (libro != null) {
            rellenarCampos(libro);
            activarEdicion(false);
        } else {

            // En caso de que no tenga valor el parámetro, se ha llamado a la
            // pantalla desde el menú lateral, por tanto ponemos los campos
            // vacios y activamos la edición en modo añadir
            rellenarCampos(null);
            activarEdicion(true);
        }
    }

    /**
     * Método que permite modificar los controles del formulario para poder
     * editar valores o añadir registros
     *
     * @param edicion Verdadero para activar el modo edición, falso para
     * desactivarlo
     */
    private void activarEdicion(boolean edicion) {

        // Modificamos la editabilidad y visibilidad de los controles 
        // dependiendo del modo de edición que hayamos especificado
        txtAnyo.setEditable(edicion);
        txtEdicion.setEditable(edicion);
        txtEditorial.setEditable(edicion);
        txtISBN.setEditable(edicion);
        txtTitulo.setEditable(edicion);
        btnBrowseAutores.setEnabled(edicion);

        btnAñadir.setVisible(!edicion);
        btnModificar.setVisible(!edicion);
        btnEliminar.setVisible(!edicion);

        btnAceptar.setVisible(edicion);
        btnCancelar.setVisible(edicion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        txtBuscarISBN = new javax.swing.JTextField();
        btnBuscarISBN = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        txtISBN = new javax.swing.JTextField();
        lblIsbn = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lblAutor = new javax.swing.JLabel();
        txtAnyo = new javax.swing.JTextField();
        lblAnyo = new javax.swing.JLabel();
        txtEditorial = new javax.swing.JTextField();
        lblEditorial = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtaResumen = new javax.swing.JTextArea();
        cmbGenero = new javax.swing.JComboBox();
        lblGenero = new javax.swing.JLabel();
        txtEdicion = new javax.swing.JTextField();
        lblEdicion = new javax.swing.JLabel();
        btnBrowseAutores = new javax.swing.JButton();
        lblCaratula = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        lblIdAutores = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAñadir = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(446, 532));
        setMinimumSize(new java.awt.Dimension(446, 532));
        setName("framePrincipal"); // NOI18N

        txtBuscarISBN.setEnabled(false);

        btnBuscarISBN.setText("Buscar ISBN");
        btnBuscarISBN.setEnabled(false);
        btnBuscarISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarISBNActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtISBN.setEditable(false);
        txtISBN.setAutoscrolls(false);
        txtISBN.setMaximumSize(new java.awt.Dimension(162, 25));
        txtISBN.setMinimumSize(new java.awt.Dimension(162, 25));
        txtISBN.setPreferredSize(new java.awt.Dimension(162, 25));

        lblIsbn.setText("ISBN");

        txtTitulo.setEditable(false);
        txtTitulo.setAutoscrolls(false);
        txtTitulo.setMaximumSize(new java.awt.Dimension(162, 25));
        txtTitulo.setMinimumSize(new java.awt.Dimension(162, 25));
        txtTitulo.setPreferredSize(new java.awt.Dimension(162, 25));

        lblTitulo.setText("Título");

        txtAutor.setEditable(false);
        txtAutor.setAutoscrolls(false);
        txtAutor.setMaximumSize(new java.awt.Dimension(127, 25));
        txtAutor.setMinimumSize(new java.awt.Dimension(127, 25));
        txtAutor.setPreferredSize(new java.awt.Dimension(127, 25));

        lblAutor.setText("Autor");

        txtAnyo.setEditable(false);
        txtAnyo.setAutoscrolls(false);
        txtAnyo.setMaximumSize(new java.awt.Dimension(162, 25));
        txtAnyo.setMinimumSize(new java.awt.Dimension(162, 25));
        txtAnyo.setPreferredSize(new java.awt.Dimension(162, 25));

        lblAnyo.setText("Año");

        txtEditorial.setEditable(false);
        txtEditorial.setAutoscrolls(false);
        txtEditorial.setMaximumSize(new java.awt.Dimension(162, 25));
        txtEditorial.setMinimumSize(new java.awt.Dimension(162, 25));
        txtEditorial.setPreferredSize(new java.awt.Dimension(162, 25));

        lblEditorial.setText("Editorial");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumen"));

        TxtaResumen.setEditable(false);
        TxtaResumen.setColumns(20);
        TxtaResumen.setRows(5);
        TxtaResumen.setBorder(null);
        TxtaResumen.setEnabled(false);
        jScrollPane1.setViewportView(TxtaResumen);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );

        cmbGenero.setEnabled(false);
        cmbGenero.setFocusable(false);
        cmbGenero.setMaximumSize(new java.awt.Dimension(162, 25));
        cmbGenero.setMinimumSize(new java.awt.Dimension(162, 25));
        cmbGenero.setPreferredSize(new java.awt.Dimension(162, 25));

        lblGenero.setText("Género");

        txtEdicion.setEditable(false);
        txtEdicion.setAutoscrolls(false);
        txtEdicion.setMaximumSize(new java.awt.Dimension(162, 25));
        txtEdicion.setMinimumSize(new java.awt.Dimension(162, 25));
        txtEdicion.setPreferredSize(new java.awt.Dimension(162, 25));

        lblEdicion.setText("Edición");

        btnBrowseAutores.setText("...");
        btnBrowseAutores.setEnabled(false);
        btnBrowseAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseAutoresActionPerformed(evt);
            }
        });

        lblCaratula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaratula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RelacionesDeEjercicios/Relacion5/Ejercicio008_Content/images/no_book.png"))); // NOI18N
        lblCaratula.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCaratula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEdicion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIsbn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtISBN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAnyo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBrowseAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                            .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCaratula, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAutor)
                            .addComponent(btnBrowseAutores))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIsbn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAnyo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEditorial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEdicion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGenero))))
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAceptar.setText("    Aceptar   ");
        btnAceptar.setOpaque(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblIdAutores.setEnabled(false);
        lblIdAutores.setFocusable(false);
        lblIdAutores.setInheritsPopupMenu(false);
        lblIdAutores.setRequestFocusEnabled(false);
        lblIdAutores.setVerifyInputWhenFocusTarget(false);

        btnCancelar.setText("   Cancelar   ");
        btnCancelar.setOpaque(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnModificar.setText("   Modificar  ");
        btnModificar.setOpaque(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("   Eliminar   ");
        btnEliminar.setOpaque(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAñadir.setText("    Añadir    ");
        btnAñadir.setOpaque(false);
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(lblIdAutores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAceptar)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(btnAñadir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(txtBuscarISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarISBN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdAutores)
                    .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar)
                        .addComponent(btnAñadir)
                        .addComponent(btnEliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento para la pulsación del botón de buscar ISBN por internet
     *
     * @param evt Evento
     */
    private void btnBuscarISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarISBNActionPerformed

    }//GEN-LAST:event_btnBuscarISBNActionPerformed

    /**
     * Método que nos permite validar la corrección de los datos introducidos en
     * el formulario
     *
     * @return Verdadero si los datos son válidos, falso si no lo son
     */
    private boolean validarDatos() {
        boolean salida = true;

        // Comprobamos que el titulo se puedan introducir letras, números y algunos símbolos especiales
        if (!Validaciones.validarDato(txtTitulo.getText(), Validaciones.TipoValidacion.CADENA_NUMEROS_SIMBOLOS)) {
            salida = false;
        }

        // Comprobamos que en el isbn solo se puedan introducir números
        if (!Validaciones.validarDato(txtISBN.getText(), Validaciones.TipoValidacion.CADENA_SOLO_NUMEROS)) {
            salida = false;
        }

        // Comprobamos que el editorial se puedan introducir letras, números y algunos símbolos especiales
        if (!Validaciones.validarDato(txtEditorial.getText(), Validaciones.TipoValidacion.CADENA_NUMEROS_SIMBOLOS)) {
            salida = false;
        }

        // Comprobamos que el número de edición es un digito positivo distinto de 0
        if (!Validaciones.validarDato(txtEdicion.getText(), Validaciones.TipoValidacion.ENTERO_POSITIVO_NO_0)) {
            salida = false;
        }

        // Comprobamos que el año es un número de tamaño 4
        if (!Validaciones.validarDato(txtAnyo.getText(), Validaciones.TipoValidacion.CADENA_SOLO_NUMEROS) || txtAnyo.getText().length() != 4) {
            salida = false;
        }

        // Comprobamos que al menos hemos seleccionado un autor
        // Para libros con autores anónimos, habrá que crear un autor específico
        // para hacer referencia a este caso especial
        if (lblIdAutores.getText().equals("")) {
            salida = false;
        }

        // Devolvemos el resultado de la validación
        return salida;
    }

    /**
     * Evento de pulsación del botón de aceptar
     *
     * @param evt Evento
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        // Validamos que los datos introducidos por el usuario antes de continuar
        if (validarDatos()) {

            // Si son correctos, creamos nuevo objeto libro con los datos 
            // introducidos y lo asignamos a la variable de instancia
            this.libro = new Libro(txtISBN.getText(),
                    txtTitulo.getText(),
                    Integer.parseInt(txtEdicion.getText()),
                    txtEditorial.getText(),
                    txtAnyo.getText(),
                    lblIdAutores.getText().split(","));

            // Si el modo del formulario es de añadir
            if (this.modo.equals("A")) {

                // Insertamos el libro en la base de datos, almacenando el resultado
                // en una variable a tal efecto
                Resultado datos = baseDatos.insertarLibro(libro);

                // Comprobamos si la operación es correcta
                if (datos.isOperacionCorrecta()) {

                    // Si lo es, mostramos un mensaje
                    Mensajes.mostrarMensaje("El libro se ha insertado correctamente",
                            Mensajes.TipoMensaje.INFORMACION);

                } else {
                    // Si hay un error mostramos un mensaje a tal efecto y 
                    // anulamos la variable de instancia
                    Mensajes.mostrarMensaje(datos.getMensaje(),
                            Mensajes.TipoMensaje.ERROR);
                    this.libro = null;
                }

                // Rellenamos los campos con los datos de la variable de instancia
                // y desactivamos el modo de edición del formulario
                rellenarCampos(this.libro);
                activarEdicion(false);

            } else {

                // Si el formulario no está en modo añadir, es una actualización.
                // Actualizamos los datos del libro y guardamos el resultado
                // en una variable                
                Resultado datos = baseDatos.actualizarLibro(libro);

                // Comprobamos si la operación se ha realizado correctamente
                if (datos.isOperacionCorrecta()) {

                    // Si es así, mostramos un mensaje al respecto
                    Mensajes.mostrarMensaje("El libro se ha actualizado correctamente", Mensajes.TipoMensaje.INFORMACION);

                } else {
                    // Si han sucedido errores, mostramos un mensaje y anulamos 
                    // la variable de instancia
                    Mensajes.mostrarMensaje(datos.getMensaje(), Mensajes.TipoMensaje.ERROR);
                    this.libro = null;
                }

                // Rellenamos los campos con los valores de la variable de 
                // instancia y desactivamos el modo de edición
                rellenarCampos(this.libro);
                activarEdicion(false);

            }
        } else {
            // Si no son datos correctos, mostramos un mensaje al respecto
            Mensajes.mostrarMensaje("Debe introducir datos correctos para poder continuar", Mensajes.TipoMensaje.AVISO);
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * Evento para la pulsación del botón de exploración de autores
     *
     * @param evt Evento
     */
    private void btnBrowseAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseAutoresActionPerformed

        // Creamos un objeto DialogMultiSelect pasándole los valores necesarios
        // Paramos null como ventana padre, verdadero para que sea una ventana
        // modal y los valores de autores si la varible de instancia no es nula
        DialogoMultiSelect dialog = new DialogoMultiSelect(null, true, (this.libro != null ? libro.getAutores() : null));

        // Hacemos que el formulario se posicione en relación al formulario
        // de libros y lo hacemos visible
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        // Comprobamos si se han seleccionado autores en el formulario        
        if (dialog.getSeleccion().length > 0) {

            // Si se han seleccionado autores creamos una variable para
            // concatenar los identificadores
            String ids = "";

            // Iteramos por todos los registros seleccionados
            for (String idAutor : dialog.getSeleccion()) {

                // Y concatenamos los identificadores, separándolos con una coma
                ids += idAutor + ",";
            }

            // Quitamos la coma final tras las concatenación
            ids = ids.substring(0, ids.length() - 1);

            // Asginamos las ids a la etiqueta oculta para tal efecto
            lblIdAutores.setText(ids);

            // Asignamos al cuadro de texto de autores los nombres de estos tras
            // buscarlos en la base de datos
            txtAutor.setText(baseDatos.consultaNombreAutor(dialog.getSeleccion()));
        }


    }//GEN-LAST:event_btnBrowseAutoresActionPerformed

    /**
     * Evento para la pulsación del boton de cancelar
     *
     * @param evt Evento
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        // Rellenamos los campos del formulario con los valores de la variable
        // de instancia
        rellenarCampos(this.libro);

        // Desactivamos la edición en el formulario
        activarEdicion(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        // Comprobamos si la variable de instancia no es nula
        // Si no es nula, tenemos valores y podemos modificarlos
        if (this.libro != null) {

            // Cambiamos el modo del formulario
            this.modo = "M";

            // Rellenamos los campos del formulario con los valores de la variable
            // de instancia            
            rellenarCampos(libro);

            // Activamos el modo de edición
            activarEdicion(true);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * Evento para la pulsación del botón de eliminar
     *
     * @param evt Evento
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        // Comprobamos si la variable de instancia no es nula
        // Si no es nula, tenemos valores y podemos eliminar el libro
        if (libro != null) {

            // Mostramos un mensaje pidiendo confirmación al usuario
            if (Mensajes.pedirConfirmacion(
                    String.format("%s%n¿Desea borrar este libro?",
                            libro.getTitulo()))) {

                // Si el usuario confirma, eliminamos el libro y guardamos el 
                // resultado de la consulta en una variable
                Resultado datos = baseDatos.eliminar(
                        new String[]{"Titulos"},
                        new String[]{"ISBN = " + libro.getIsbn()});

                // Verificamos si la operación es corracta
                if (datos.isOperacionCorrecta()) {

                    // Si es correcta, mostramos un mensaje a tal efecto y 
                    // borramos los campos del formulario
                    Mensajes.mostrarMensaje("El libro se ha borrado correctamente",
                            Mensajes.TipoMensaje.INFORMACION);

                    rellenarCampos(null);
                } else {

                    // Si la operación no es correcta, mostramos un mensaje de 
                    // error
                    Mensajes.mostrarMensaje("Error al borrar el libro",
                            Mensajes.TipoMensaje.ERROR);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Método para rellenar los campos del formulario
     *
     * @param datosLibro Datos a mostrar en el formulario
     */
    private void rellenarCampos(Libro datosLibro) {

        // Si el parámetro es nulo, ponemos los campos en blanco
        if (datosLibro == null) {
            TxtaResumen.setText("");
            txtAnyo.setText("");
            txtAutor.setText("");
            txtEdicion.setText("");
            txtEditorial.setText("");
            txtISBN.setText("");
            txtTitulo.setText("");
            lblIdAutores.setText("");
            cmbGenero.setSelectedIndex(-1);
        } else {

            // Si el parámetro tiene valores, rellenamos los campos con ellos
            TxtaResumen.setText("");
            txtAnyo.setText(datosLibro.getCopyright());
            txtEdicion.setText(String.valueOf(datosLibro.getNumEdicion()));
            txtEditorial.setText(datosLibro.getEditorial());
            txtISBN.setText(datosLibro.getIsbn());
            txtTitulo.setText(datosLibro.getTitulo());
            cmbGenero.setSelectedIndex(-1);

            String ids = "";

            // Concatenamos los ids del autores
            for (String idAutor : datosLibro.getAutores()) {
                ids += idAutor + ",";
            }

            // Limpiamos la concatenación
            ids = ids.substring(0, ids.length() - 1);

            // Asignamos los ids a la etiqueta oculta, y los nombres
            // al cuadro de texto visible
            lblIdAutores.setText(ids);
            txtAutor.setText(baseDatos.consultaNombreAutor(datosLibro.getAutores()));
        }
    }

    /**
     * Evento para la pulsación del botón de añadir
     *
     * @param evt Evento
     */
    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed

        // Limpiamos la variable de instancia
        this.libro = null;

        // Cambiamos el modo del formulario
        this.modo = "A";

        // Limpiamos los campos y activamos el modo de edición
        rellenarCampos(libro);
        activarEdicion(true);
    }//GEN-LAST:event_btnAñadirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxtaResumen;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBrowseAutores;
    private javax.swing.JButton btnBuscarISBN;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cmbGenero;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAnyo;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCaratula;
    private javax.swing.JLabel lblEdicion;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblIdAutores;
    private javax.swing.JLabel lblIsbn;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtAnyo;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtBuscarISBN;
    private javax.swing.JTextField txtEdicion;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
