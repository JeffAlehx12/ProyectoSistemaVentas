
package vista;



public class InterSalidas extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterEntradas
     */
    public InterSalidas() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxtSalida = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtPrecioUnitario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtDocumento = new javax.swing.JTextField();
        jtxtFecha = new com.toedter.calendar.JDateChooser();
        jcbxMotivo = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jtxtObs = new javax.swing.JTextField();
        jtxtDestinatario = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jbtnRegistrar = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();
        jbtnPendiente = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblSalida = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jtxtIdProducto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jbtnBuscarProducto = new javax.swing.JButton();
        jtxtNombreProducto = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtxtIdCategoria = new javax.swing.JTextField();
        jtxtNombreCategoria = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtxtIdProveedor = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtxtNombreProveedor = new javax.swing.JTextField();
        jlbImg = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("ID Entrada");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jtxtSalida.setEnabled(false);
        jPanel1.add(jtxtSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 96, -1));

        jLabel3.setText("Motivo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jtxtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtCantidadKeyReleased(evt);
            }
        });
        jPanel1.add(jtxtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 205, -1));

        jLabel5.setText("Cantidad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel6.setText("Fecha");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel7.setText("Precio Unitario");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jtxtPrecioUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtPrecioUnitarioKeyReleased(evt);
            }
        });
        jPanel1.add(jtxtPrecioUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 205, -1));

        jLabel10.setText("Destinatario");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        jPanel1.add(jtxtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 205, -1));

        jtxtFecha.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jtxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 205, -1));

        jcbxMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Motivo", "Venta", "Devolución a Proveedor ", "Transferencia de Almacén ", "Ajuste de Inventario ", "Uso Interno" }));
        jPanel1.add(jcbxMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 200, 30));

        jLabel18.setText("Obs");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 60, -1));

        jtxtObs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtObs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtObsActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 200, 50));

        jtxtDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDestinatarioActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 200, -1));

        jLabel19.setText("Documento");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jbtnRegistrar.setBackground(new java.awt.Color(255, 102, 102));
        jbtnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        jbtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 70, 60));

        jbtnBuscar.setBackground(new java.awt.Color(255, 102, 102));
        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 70, 60));

        jbtnPendiente.setBackground(new java.awt.Color(255, 102, 102));
        jbtnPendiente.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jbtnPendiente.setForeground(new java.awt.Color(255, 255, 255));
        jbtnPendiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/proceso.png"))); // NOI18N
        jbtnPendiente.setText("PENDIENTE");
        jbtnPendiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPendienteActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnPendiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 150, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 260, 780));

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE SALIDA");
        jLabel1.setPreferredSize(new java.awt.Dimension(207, 20));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Complete la Informacion de las salidas.");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1261, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jtblSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Motivo", "Documento", "IDProducto", "IDCategoria", "IDProveedor", "Fecha", "Cantidad", "Precio Costo", "Obs", "Total"
            }
        ));
        jtblSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblSalidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtblSalidaMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jtblSalida);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 43, 153));
        jLabel17.setText("Buscar Producto");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("ID Producto");

        jbtnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jbtnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarProductoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Producto");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtxtIdProducto)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel17))
                        .addComponent(jLabel9)
                        .addComponent(jtxtNombreProducto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jbtnBuscarProducto)
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnBuscarProducto)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(jtxtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 153, 0));
        jLabel11.setText("Datos de la Categoria ");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("ID Categoria");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel3.add(jtxtIdCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 143, -1));
        jPanel3.add(jtxtNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 143, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Categoria");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(238, 173, 61));
        jLabel14.setText("Datos del Proveedor");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("ID Proveedor");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));
        jPanel5.add(jtxtIdProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 143, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Proveedor");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        jPanel5.add(jtxtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 143, -1));

        jlbImg.setBackground(new java.awt.Color(102, 102, 102));
        jlbImg.setForeground(new java.awt.Color(0, 0, 0));
        jlbImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jlbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 1310, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btniconoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniconoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btniconoActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed

    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCategoriaActionPerformed

    }//GEN-LAST:event_btnBuscarCategoriaActionPerformed

    private void jtxtPrecioUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtPrecioUnitarioKeyReleased

    }//GEN-LAST:event_jtxtPrecioUnitarioKeyReleased

    private void jtxtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCantidadKeyReleased

    }//GEN-LAST:event_jtxtCantidadKeyReleased

    private void btnBuscaProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaProveedorActionPerformed

    }//GEN-LAST:event_btnBuscaProveedorActionPerformed

    private void jtxtObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtObsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtObsActionPerformed

    private void jtxtDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDestinatarioActionPerformed

    private void jtblSalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblSalidaMouseClicked

    }//GEN-LAST:event_jtblSalidaMouseClicked

    private void jtblSalidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblSalidaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jtblSalidaMouseEntered

    private void jbtnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnBuscarProductoActionPerformed

    private void jbtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnRegistrarActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jbtnPendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPendienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnPendienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtnBuscar;
    public javax.swing.JButton jbtnBuscarProducto;
    public javax.swing.JButton jbtnPendiente;
    public javax.swing.JButton jbtnRegistrar;
    public javax.swing.JComboBox<String> jcbxMotivo;
    public javax.swing.JLabel jlbImg;
    public javax.swing.JTable jtblSalida;
    public javax.swing.JTextField jtxtCantidad;
    public javax.swing.JTextField jtxtDestinatario;
    public javax.swing.JTextField jtxtDocumento;
    public com.toedter.calendar.JDateChooser jtxtFecha;
    public javax.swing.JTextField jtxtIdCategoria;
    public javax.swing.JTextField jtxtIdProducto;
    public javax.swing.JTextField jtxtIdProveedor;
    public javax.swing.JTextField jtxtNombreCategoria;
    public javax.swing.JTextField jtxtNombreProducto;
    public javax.swing.JTextField jtxtNombreProveedor;
    public javax.swing.JTextField jtxtObs;
    public javax.swing.JTextField jtxtPrecioUnitario;
    public javax.swing.JTextField jtxtSalida;
    // End of variables declaration//GEN-END:variables
}
