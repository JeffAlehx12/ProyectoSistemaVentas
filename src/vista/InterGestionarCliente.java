package vista;





public class InterGestionarCliente extends javax.swing.JInternalFrame {

    

    public InterGestionarCliente() {
        initComponents();
       

        
        
        
        
        
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_cliente = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jtxtIdentificacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtApellido = new javax.swing.JTextField();
        jtxtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxtCorreo = new javax.swing.JTextField();
        jComboBox_estado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jtxtBusqueda = new javax.swing.JTextField();
        jbtnBuscarporDni = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton_editar = new javax.swing.JButton();
        jButton_Guardar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jButton_Cancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_cliente.setBackground(new java.awt.Color(255, 255, 255));
        jTable_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_cliente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1520, 420));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Dni:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 100, 20));

        jtxtIdentificacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jtxtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 620, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Teléfono:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 560, 90, -1));

        jtxtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jtxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 560, 170, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Apellido:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 100, -1));

        jtxtApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jtxtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 170, -1));

        jtxtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jtxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 650, 170, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Direccion:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 90, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 110, -1));

        jtxtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 170, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Estado:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, 90, 20));

        jtxtCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jtxtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 590, 170, -1));

        jComboBox_estado.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_estado.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jComboBox_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_estadoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 620, 170, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Correo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 590, 90, -1));

        jtxtBusqueda.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jtxtBusquedaCaretUpdate(evt);
            }
        });
        jtxtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtBusquedaActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 190, 30));

        jbtnBuscarporDni.setText("Buscar");
        jbtnBuscarporDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarporDniActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnBuscarporDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 20, 30));

        jButton_editar.setBackground(new java.awt.Color(0, 153, 204));
        jButton_editar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_editar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        jButton_editar.setText("Editar");
        jButton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 130, 40));

        jButton_Guardar.setBackground(new java.awt.Color(0, 153, 204));
        jButton_Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Guardar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 130, 40));

        jButton_eliminar.setBackground(new java.awt.Color(0, 153, 204));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 120, 40));

        jButton_Cancelar.setBackground(new java.awt.Color(0, 153, 204));
        jButton_Cancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jButton_Cancelar.setText("Cancelar");
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 130, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1580, 800));

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 19)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("GESTIONAR CLIENTE");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1580, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_estadoActionPerformed

    private void jtxtBusquedaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtxtBusquedaCaretUpdate
     
  
         
        
    }//GEN-LAST:event_jtxtBusquedaCaretUpdate

    private void jbtnBuscarporDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarporDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnBuscarporDniActionPerformed

    private void jtxtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBusquedaActionPerformed

    private void jButton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editarActionPerformed

    }//GEN-LAST:event_jButton_editarActionPerformed

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed

    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_CancelarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_Cancelar;
    public javax.swing.JButton jButton_Guardar;
    public javax.swing.JButton jButton_editar;
    public javax.swing.JButton jButton_eliminar;
    public javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_cliente;
    public javax.swing.JButton jbtnBuscarporDni;
    public javax.swing.JTextField jtxtApellido;
    public javax.swing.JTextField jtxtBusqueda;
    public javax.swing.JTextField jtxtCorreo;
    public javax.swing.JTextField jtxtDireccion;
    public javax.swing.JTextField jtxtIdentificacion;
    public javax.swing.JTextField jtxtNombre;
    public javax.swing.JTextField jtxtTelefono;
    // End of variables declaration//GEN-END:variables

  
}
