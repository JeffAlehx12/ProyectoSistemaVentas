package vista;





public class InterGestionarUsuario extends javax.swing.JInternalFrame {

    

    public InterGestionarUsuario() {
        initComponents();
       

        
        
        
        
        
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jscllUsuario = new javax.swing.JScrollPane();
        jtbUsuario = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jtxtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtCorreo = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtDireccion = new javax.swing.JTextField();
        jtxtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtDni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton_eliminar = new javax.swing.JButton();
        jComboBox_estado = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jButton_Guardar = new javax.swing.JButton();
        jButton_editar = new javax.swing.JButton();
        jButton_Cancelar = new javax.swing.JButton();
        jtxtBusqueda = new javax.swing.JTextField();
        jbtnBuscarporDni = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jtxtPassword = new javax.swing.JPasswordField();
        jComboBox_Rol = new javax.swing.JComboBox<>();
        jCheckBox_ver_clave = new javax.swing.JCheckBox();
        jtxtUsuario = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtbUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jtbUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        jscllUsuario.setViewportView(jtbUsuario);

        jPanel1.add(jscllUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1510, 410));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Apellido:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 110, -1));

        jtxtApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 230, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Correo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 620, 90, -1));

        jtxtCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jtxtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 620, 230, -1));

        jtxtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 230, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Nombre:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 100, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Direccion:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, 90, -1));

        jtxtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jtxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 560, 230, -1));

        jtxtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jtxtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 590, 230, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Telefono:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 590, 90, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Dni: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 100, -1));

        jtxtDni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(jtxtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 620, 230, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Estado:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 680, 90, 20));

        jButton_eliminar.setBackground(new java.awt.Color(0, 153, 204));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 120, 40));

        jComboBox_estado.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_estado.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jComboBox_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_estadoActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 680, 230, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Usuario:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 560, 90, -1));

        jButton_Guardar.setBackground(new java.awt.Color(0, 153, 204));
        jButton_Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 130, 40));

        jButton_editar.setBackground(new java.awt.Color(0, 153, 204));
        jButton_editar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_editar.setText("Editar");
        jButton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 130, 40));

        jButton_Cancelar.setBackground(new java.awt.Color(0, 153, 204));
        jButton_Cancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Cancelar.setText("Cancelar");
        jButton_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 130, 40));

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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Password:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 590, 90, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Rol:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 620, 90, -1));

        jtxtPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jtxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 590, 230, -1));

        jComboBox_Rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Rol:", "Usuario", "Admin" }));
        jPanel1.add(jComboBox_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 620, 230, -1));

        jCheckBox_ver_clave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_ver_claveMouseClicked(evt);
            }
        });
        jPanel1.add(jCheckBox_ver_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 590, -1, -1));

        jtxtUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 560, 230, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1580, 800));

        jPanel4.setBackground(new java.awt.Color(27, 177, 221));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("GESTIONAR USUARIO");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 50));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1590, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

       

    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editarActionPerformed
        
       
        
        
    }//GEN-LAST:event_jButton_editarActionPerformed

    private void jComboBox_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_estadoActionPerformed

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed

    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void jButton_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_CancelarActionPerformed

    private void jtxtBusquedaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtxtBusquedaCaretUpdate
     
  
         
        
    }//GEN-LAST:event_jtxtBusquedaCaretUpdate

    private void jbtnBuscarporDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarporDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnBuscarporDniActionPerformed

    private void jtxtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBusquedaActionPerformed

    private void jtxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtUsuarioActionPerformed

    private void jtxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNombreActionPerformed

    private void jtxtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtApellidoActionPerformed

    private void jCheckBox_ver_claveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_ver_claveMouseClicked

    }//GEN-LAST:event_jCheckBox_ver_claveMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_Cancelar;
    public javax.swing.JButton jButton_Guardar;
    public javax.swing.JButton jButton_editar;
    public javax.swing.JButton jButton_eliminar;
    public javax.swing.JCheckBox jCheckBox_ver_clave;
    public javax.swing.JComboBox<String> jComboBox_Rol;
    public javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JButton jbtnBuscarporDni;
    public static javax.swing.JScrollPane jscllUsuario;
    public static javax.swing.JTable jtbUsuario;
    public javax.swing.JTextField jtxtApellido;
    public javax.swing.JTextField jtxtBusqueda;
    public javax.swing.JTextField jtxtCorreo;
    public javax.swing.JTextField jtxtDireccion;
    public javax.swing.JTextField jtxtDni;
    public javax.swing.JTextField jtxtNombre;
    public javax.swing.JPasswordField jtxtPassword;
    public javax.swing.JTextField jtxtTelefono;
    public javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables

  
}
