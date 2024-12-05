package vista;


public class InterFacturacion extends javax.swing.JInternalFrame {

   
    

    public InterFacturacion() {
        
          initComponents();
      

    }

  
    
    
    
    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_cliente = new javax.swing.JComboBox<>();
        txt_cliente_buscar = new javax.swing.JTextField();
        jButton_busca_cliente = new javax.swing.JButton();
        jButton_añadir_producto = new javax.swing.JButton();
        txt_cantidad = new javax.swing.JTextField();
        jComboBox_producto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_iva = new javax.swing.JTextField();
        txt_total_pagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        jButton_calcular_cambio = new javax.swing.JButton();
        jButton_RegistrarVenta = new javax.swing.JButton();
        jbtnConsultaIA = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registro de Venta");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Dni:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 80, 30));

        jComboBox_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox_clienteMouseClicked(evt);
            }
        });
        jPanel3.add(jComboBox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 180, 40));

        txt_cliente_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_cliente_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 180, 30));

        jButton_busca_cliente.setBackground(new java.awt.Color(255, 255, 255));
        jButton_busca_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_busca_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jButton_busca_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_busca_clienteActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_busca_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 40, 30));

        jButton_añadir_producto.setBackground(new java.awt.Color(255, 255, 255));
        jButton_añadir_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_añadir_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito.png"))); // NOI18N
        jButton_añadir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_añadir_productoActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_añadir_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 50, 40));

        txt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 120, 40));

        jComboBox_producto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(jComboBox_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 180, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 80, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Subtotal:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Iva:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total a pagar:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_subtotal.setEnabled(false);
        jPanel2.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, -1));

        txt_descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_descuento.setEnabled(false);
        jPanel2.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 120, -1));

        txt_iva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_iva.setEnabled(false);
        jPanel2.add(txt_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 120, -1));

        txt_total_pagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total_pagar.setEnabled(false);
        jPanel2.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 120, -1));

        txt_efectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 120, -1));

        txt_cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_cambio.setEnabled(false);
        jPanel2.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 120, -1));

        jButton_calcular_cambio.setBackground(new java.awt.Color(51, 153, 255));
        jButton_calcular_cambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_calcular_cambio.setText("Calcular Cambio");
        jButton_calcular_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcular_cambioActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_calcular_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 130, 50));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 370, 270));

        jButton_RegistrarVenta.setBackground(new java.awt.Color(51, 153, 255));
        jButton_RegistrarVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_RegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        jButton_RegistrarVenta.setText("Registrar Venta");
        jButton_RegistrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_RegistrarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_RegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarVentaActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_RegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 130, 90));

        jbtnConsultaIA.setBackground(new java.awt.Color(255, 255, 255));
        jbtnConsultaIA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnConsultaIA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ai.png"))); // NOI18N
        jbtnConsultaIA.setBorder(null);
        jbtnConsultaIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnConsultaIAActionPerformed(evt);
            }
        });
        jPanel3.add(jbtnConsultaIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 110, 80));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 980, 630));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 1000, 650));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Consultas IA");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/venta.png"))); // NOI18N
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 70, 60));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Cliente:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 80, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_busca_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_busca_clienteActionPerformed
        
    }//GEN-LAST:event_jButton_busca_clienteActionPerformed

    private void jButton_añadir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_añadir_productoActionPerformed

    }//GEN-LAST:event_jButton_añadir_productoActionPerformed

    private void jButton_calcular_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcular_cambioActionPerformed
        
    }//GEN-LAST:event_jButton_calcular_cambioActionPerformed
   
    
    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked
        
    }//GEN-LAST:event_jTable_productosMouseClicked

    private void jButton_RegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarVentaActionPerformed

    }//GEN-LAST:event_jButton_RegistrarVentaActionPerformed

    private void jComboBox_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_clienteMouseClicked
       
    }//GEN-LAST:event_jComboBox_clienteMouseClicked

    private void jbtnConsultaIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConsultaIAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnConsultaIAActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_RegistrarVenta;
    public javax.swing.JButton jButton_añadir_producto;
    public javax.swing.JButton jButton_busca_cliente;
    public javax.swing.JButton jButton_calcular_cambio;
    public javax.swing.JComboBox<String> jComboBox_cliente;
    public javax.swing.JComboBox<String> jComboBox_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    public javax.swing.JButton jbtnConsultaIA;
    public javax.swing.JTextField txt_cambio;
    public javax.swing.JTextField txt_cantidad;
    public javax.swing.JTextField txt_cliente_buscar;
    public javax.swing.JTextField txt_descuento;
    public javax.swing.JTextField txt_efectivo;
    public javax.swing.JTextField txt_iva;
    public javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables

   
}
