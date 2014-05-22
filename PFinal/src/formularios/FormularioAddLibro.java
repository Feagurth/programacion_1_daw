/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import db.BaseDeDatos;
import db.Libro;

/**
 *
 * @author Super
 */
public class FormularioAddLibro extends javax.swing.JInternalFrame {

    BaseDeDatos baseDatos;

    /**
     * Creates new form FormularioAdd
     */
    public FormularioAddLibro() {
        initComponents();
        baseDatos = new BaseDeDatos("root", "", "127.0.0.1:3306", "libros");

        /*
         Resultado solucion = baseDatos.consultar(
         new String[]{"titulos.isbn", "titulos.titulo", "autores.primerNombre", "autores.apellidoPaterno"},
         new String[]{"titulos", "autores", "isbnautor"},
         new String[]{"autores.idAutor = isbnautor.idAutor", "titulos.isbn = isbnautor.isbn"},
         new String[]{"titulos.isbn ASC"});

         if (solucion.isOperacionCorrecta()) {
         try {

         while (solucion.getResultado().next()) {
         System.out.println(
         solucion.getResultado().getObject("isbn") + " - "
         + solucion.getResultado().getObject("titulo") + " - "
         + solucion.getResultado().getObject("primerNombre") + " "
         + solucion.getResultado().getObject("apellidopaterno"));

         }

         solucion.getResultado().close();
         } catch (SQLException ex) {
         Logger.getLogger(FormularioAddLibro.class.getName()).log(Level.SEVERE, null, ex);
         }
         }

         System.out.println("");
         System.out.println("-----------------------------");
         System.out.println("");

         solucion = baseDatos.actualizar(
         new String[]{"titulo"},
         new String[]{"titulos"},
         new String[]{"ISBN = 0131857576"},
         new String[]{"Papafrita"});

         if (solucion.isOperacionCorrecta()) {
         solucion = baseDatos.consultar(
         new String[]{"titulos.isbn", "titulos.titulo", "autores.primerNombre", "autores.apellidoPaterno"},
         new String[]{"titulos", "autores", "isbnautor"},
         new String[]{"autores.idAutor = isbnautor.idAutor", "titulos.isbn = isbnautor.isbn"},
         new String[]{"titulos.isbn ASC"});

         if (solucion.isOperacionCorrecta()) {
         try {

         while (solucion.getResultado().next()) {
         System.out.println(
         solucion.getResultado().getObject("isbn") + " - "
         + solucion.getResultado().getObject("titulo") + " - "
         + solucion.getResultado().getObject("primerNombre") + " "
         + solucion.getResultado().getObject("apellidopaterno"));

         }

         solucion.getResultado().close();
         } catch (SQLException ex) {
         Logger.getLogger(FormularioAddLibro.class.getName()).log(Level.SEVERE, null, ex);
         }

         }
         }

         System.out.println("");
         System.out.println("-----------------------------");
         System.out.println("");

         solucion = baseDatos.actualizar(
         null,
         new String[]{"Titulos"},
         null,
         new String[]{"9788434887138", "El pirata garrapata", "49", "SM", "2002"});

         if (solucion.isOperacionCorrecta()) {
         solucion = baseDatos.actualizar(
         null,
         new String[]{"Autores"},
         null,
         new String[]{"0", "Juan", "Muñoz"});
         }
        
         if (solucion.isOperacionCorrecta()) {
            
         solucion = baseDatos.consultar(
         new String[]{"idAutor"}, 
         new String[]{"Autores"}, 
         new String[]{"primerNombre = 'Juan'", "apellidoPaterno = 'Muñoz'"}, 
         null);
            
         int idAutor = 0;
         try {
         ResultSet algo =  solucion.getResultado();
         algo.first();
         idAutor = algo.getInt(1);
                
         } catch (SQLException ex) {
         Logger.getLogger(FormularioAddLibro.class.getName()).log(Level.SEVERE, null, ex);
         }
            
         solucion = baseDatos.actualizar(
         null,
         new String[]{"isbnautor"},
         null,
         new String[]{String.valueOf(idAutor), "9788434887138"});
         }        
         if (solucion.isOperacionCorrecta()) {
         solucion = baseDatos.consultar(
         new String[]{"titulos.isbn", "titulos.titulo", "autores.primerNombre", "autores.apellidoPaterno"},
         new String[]{"titulos", "autores", "isbnautor"},
         new String[]{"autores.idAutor = isbnautor.idAutor", "titulos.isbn = isbnautor.isbn"},
         new String[]{"titulos.isbn ASC"});

         if (solucion.isOperacionCorrecta()) {
         try {

         while (solucion.getResultado().next()) {
         System.out.println(
         solucion.getResultado().getObject("isbn") + " - "
         + solucion.getResultado().getObject("titulo") + " - "
         + solucion.getResultado().getObject("primerNombre") + " "
         + solucion.getResultado().getObject("apellidopaterno"));

         }

         solucion.getResultado().close();
         } catch (SQLException ex) {
         Logger.getLogger(FormularioAddLibro.class.getName()).log(Level.SEVERE, null, ex);
         }

         }
         }
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBuscarISBN = new javax.swing.JTextField();
        btnBuscarISBN = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        txtISBN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAnyo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEditorial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtaResumen = new javax.swing.JTextArea();
        cmbGenero = new javax.swing.JComboBox();
        lblGenero = new javax.swing.JLabel();
        txtEdicion = new javax.swing.JTextField();
        lblEdicion = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(446, 532));
        setMinimumSize(new java.awt.Dimension(446, 532));

        btnBuscarISBN.setText("Buscar ISBN");
        btnBuscarISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarISBNActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtISBN.setText("9788434887138");

        jLabel1.setText("ISBN");

        txtTitulo.setText("El pirata garrapata");

        jLabel2.setText("Título");

        txtAutor.setText("Juan Muñoz");

        jLabel3.setText("Autor");

        txtAnyo.setText("2002");

        jLabel4.setText("Año");

        txtEditorial.setText("SM");

        jLabel5.setText("Editorial");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumen"));

        TxtaResumen.setColumns(20);
        TxtaResumen.setRows(5);
        TxtaResumen.setBorder(null);
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

        lblGenero.setText("Género");

        txtEdicion.setText("49");

        lblEdicion.setText("Edición");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEdicion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAnyo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtISBN, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAutor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(txtEditorial)
                            .addComponent(txtEdicion)
                            .addComponent(cmbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEdicion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblGenero)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBuscarISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarISBN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addComponent(btnGuardar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarISBNActionPerformed

    }//GEN-LAST:event_btnBuscarISBNActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Libro libro = new Libro(txtISBN.getText(), txtTitulo.getText(), Integer.parseInt(txtEdicion.getText()), txtEditorial.getText(), txtAnyo.getText(), txtAutor.getText().split(", "));
        
        baseDatos.actualizarLibro(libro);

    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxtaResumen;
    private javax.swing.JButton btnBuscarISBN;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cmbGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEdicion;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JTextField txtAnyo;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtBuscarISBN;
    private javax.swing.JTextField txtEdicion;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
