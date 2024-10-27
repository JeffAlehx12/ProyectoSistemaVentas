package vista;

public class InterGestionarCategoria extends javax.swing.JInternalFrame {
    
    
    public InterGestionarCategoria() {
        
        initComponents();
                
    }

    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_categoria = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jbtnRegresar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxt_nombreCategoria = new javax.swing.JTextField();
        jbtnEliminar = new javax.swing.JButton();
        jbtnGuardar = new javax.swing.JToggleButton();
        jbtnCancelar = new javax.swing.JToggleButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(350, 500));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_categoria.setBackground(new java.awt.Color(255, 255, 255));
        jTable_categoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_categoria);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 540, 370));

        jPanel5.setBackground(new java.awt.Color(204, 204, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Administrar Categorias");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 50));

        jbtnRegresar.setText("R");
        jbtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegresarActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Descripcion :");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jtxt_nombreCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxt_nombreCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxt_nombreCategoriaKeyPressed(evt);
            }
        });
        jPanel3.add(jtxt_nombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, 250, -1));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 280, 80));

        jbtnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        jbtnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 130, 40));

        jbtnGuardar.setBackground(new java.awt.Color(0, 204, 204));
        jbtnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        jbtnGuardar.setText("Guardar");
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(jbtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 130, 40));

        jbtnCancelar.setText("Cancelar");
        jPanel4.add(jbtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 130, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
    
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jtxt_nombreCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_nombreCategoriaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_nombreCategoriaKeyPressed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed

    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable_categoria;
    public javax.swing.JToggleButton jbtnCancelar;
    public javax.swing.JButton jbtnEliminar;
    public javax.swing.JToggleButton jbtnGuardar;
    public javax.swing.JButton jbtnRegresar;
    public javax.swing.JTextField jtxt_nombreCategoria;
    // End of variables declaration//GEN-END:variables

        //metodo para mostrar todas las categorias registradas
    
}
