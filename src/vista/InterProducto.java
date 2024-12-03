
package vista;

import modelo.JpanelRound;


public class InterProducto extends javax.swing.JInternalFrame {

    
    
    public InterProducto() {
        initComponents();
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtnRegresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxt_nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtxt_descripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jtxt_precioCosto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_igv = new javax.swing.JComboBox<>();
        jbtnGuardar = new javax.swing.JButton();
        jtxt_ubicacion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jspn_stockMinimo = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jtxt_Cantidad_Inicial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jbtnCancelar = new javax.swing.JButton();
        jtxt_precioVenta = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jbtnExaminar = new javax.swing.JButton();
        jbtnQuitar = new javax.swing.JButton();
        jtxtMargenGanancia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox_proveedor = new javax.swing.JComboBox<>();
        jbtnProveedor = new javax.swing.JButton();
        jbtnCategoria = new javax.swing.JButton();
        jlbImg = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 255));
        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(59, 130, 246));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE PRODUCTO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 50));

        jbtnRegresar.setText("R");
        jbtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1110, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre: (*)  ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 90, -1));

        jtxt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxt_nombre.setName(""); // NOI18N
        jtxt_nombre.setNextFocusableComponent(jtxt_descripcion);
        jPanel2.add(jtxt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 280, 50));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripcion:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 90, -1));

        jtxt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxt_descripcion.setNextFocusableComponent(jComboBox_categoria);
        jPanel2.add(jtxt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 280, 50));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categorias:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 90, -1));

        jComboBox_categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:" }));
        jComboBox_categoria.setNextFocusableComponent(jComboBox_proveedor);
        jPanel2.add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 280, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Margen de ganancia(%)");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 170, 30));

        jtxt_precioCosto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxt_precioCosto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtxt_precioCosto.setFocusCycleRoot(true);
        jtxt_precioCosto.setName(""); // NOI18N
        jtxt_precioCosto.setNextFocusableComponent(jtxt_precioVenta);
        jtxt_precioCosto.setOpaque(true);
        jPanel2.add(jtxt_precioCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 280, 50));
        jtxt_precioCosto.getAccessibleContext().setAccessibleName("");
        jtxt_precioCosto.getAccessibleContext().setAccessibleDescription("");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Imagen (opcional)");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 320, -1, -1));

        jComboBox_igv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_igv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione igv:", "No grava igv", "18%" }));
        jComboBox_igv.setNextFocusableComponent(jbtnExaminar);
        jPanel2.add(jComboBox_igv, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, 280, 50));

        jbtnGuardar.setBackground(new java.awt.Color(59, 130, 246));
        jbtnGuardar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jbtnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnGuardar.setText("Guardar");
        jbtnGuardar.setNextFocusableComponent(jbtnCancelar);
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 140, 40));

        jtxt_ubicacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxt_ubicacion.setNextFocusableComponent(jtxt_Cantidad_Inicial);
        jPanel2.add(jtxt_ubicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 280, 50));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Ubicacion:   ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 90, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Control de Inventario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jspn_stockMinimo.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel3.add(jspn_stockMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 280, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Stock Min  (opcional)");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 150, 20));

        jtxt_Cantidad_Inicial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxt_Cantidad_Inicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxt_Cantidad_Inicial.setNextFocusableComponent(jspn_stockMinimo);
        jtxt_Cantidad_Inicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_Cantidad_InicialActionPerformed(evt);
            }
        });
        jPanel3.add(jtxt_Cantidad_Inicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 260, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cantidad Inicial: (*)");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 140, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 360, 330));

        jbtnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        jbtnCancelar.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jbtnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.setNextFocusableComponent(jtxt_nombre);
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 150, 40));

        jtxt_precioVenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtxt_precioVenta.setNextFocusableComponent(jComboBox_igv);
        jPanel2.add(jtxt_precioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 280, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Precio de Venta: (*)");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 170, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Precio de Costo: (*)");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 170, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("IGV:    ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 230, -1, -1));

        jbtnExaminar.setText("Examinar");
        jbtnExaminar.setNextFocusableComponent(jbtnQuitar);
        jPanel2.add(jbtnExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 350, -1, 30));

        jbtnQuitar.setText("Quitar");
        jbtnQuitar.setNextFocusableComponent(jbtnGuardar);
        jPanel2.add(jbtnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 390, 80, -1));

        jtxtMargenGanancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMargenGananciaActionPerformed(evt);
            }
        });
        jPanel2.add(jtxtMargenGanancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 90, 30));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Proveedor: ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 90, -1));

        jComboBox_proveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione proveedor:" }));
        jComboBox_proveedor.setNextFocusableComponent(jtxt_ubicacion);
        jPanel2.add(jComboBox_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 280, 50));

        jbtnProveedor.setBackground(new java.awt.Color(51, 102, 255));
        jbtnProveedor.setForeground(new java.awt.Color(51, 255, 0));
        jbtnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnProveedorActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 20, 15));

        jbtnCategoria.setBackground(new java.awt.Color(51, 102, 255));
        jbtnCategoria.setForeground(new java.awt.Color(51, 255, 0));
        jbtnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(jbtnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 211, 20, 15));

        jlbImg.setBackground(new java.awt.Color(102, 102, 102));
        jlbImg.setForeground(new java.awt.Color(0, 0, 0));
        jlbImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jlbImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 350, 170, 150));

        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("128px");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 500, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 60, 1110, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed

    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jtxtMargenGananciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtMargenGananciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtMargenGananciaActionPerformed

    private void jbtnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnProveedorActionPerformed

    private void jbtnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCategoriaActionPerformed

    private void jbtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnRegresarActionPerformed

    private void jtxt_Cantidad_InicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_Cantidad_InicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_Cantidad_InicialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> jComboBox_categoria;
    public javax.swing.JComboBox<String> jComboBox_igv;
    public javax.swing.JComboBox<String> jComboBox_proveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JButton jbtnCancelar;
    public javax.swing.JButton jbtnCategoria;
    public javax.swing.JButton jbtnExaminar;
    public javax.swing.JButton jbtnGuardar;
    public javax.swing.JButton jbtnProveedor;
    public javax.swing.JButton jbtnQuitar;
    public javax.swing.JButton jbtnRegresar;
    public javax.swing.JLabel jlbImg;
    public javax.swing.JSpinner jspn_stockMinimo;
    public javax.swing.JTextField jtxtMargenGanancia;
    public javax.swing.JTextField jtxt_Cantidad_Inicial;
    public javax.swing.JTextField jtxt_descripcion;
    public javax.swing.JTextField jtxt_nombre;
    public javax.swing.JTextField jtxt_precioCosto;
    public javax.swing.JTextField jtxt_precioVenta;
    public javax.swing.JTextField jtxt_ubicacion;
    // End of variables declaration//GEN-END:variables

}
