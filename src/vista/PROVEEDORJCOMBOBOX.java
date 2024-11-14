
package vista;


public class PROVEEDORJCOMBOBOX extends javax.swing.JInternalFrame {

    
    
    public PROVEEDORJCOMBOBOX() {
        initComponents();
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxt_nombre = new javax.swing.JTextField();
        jtxt_cantidad = new javax.swing.JTextField();
        jtxt_precio = new javax.swing.JTextField();
        jtxt_descripcion = new javax.swing.JTextField();
        jComboBox_iva = new javax.swing.JComboBox<>();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jButton_Guardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_proveedor = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 153, 255));
        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nuevo Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cantidad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio Venta:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripcion:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("IVA:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categorias:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 90, -1));

        jtxt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jtxt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 170, -1));

        jtxt_cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jtxt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 170, -1));

        jtxt_precio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jtxt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 170, -1));

        jtxt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jtxt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 170, -1));

        jComboBox_iva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione iva:", "No grava iva", "18%" }));
        getContentPane().add(jComboBox_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 170, -1));

        jComboBox_categoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:" }));
        getContentPane().add(jComboBox_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 170, -1));

        jButton_Guardar.setBackground(new java.awt.Color(0, 204, 204));
        jButton_Guardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Guardar.setForeground(new java.awt.Color(0, 0, 0));
        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 90, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Proveedor:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 90, -1));

        jComboBox_proveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:" }));
        getContentPane().add(jComboBox_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 170, -1));

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
       
        


    }//GEN-LAST:event_jButton_GuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton_Guardar;
    public javax.swing.JComboBox<String> jComboBox_categoria;
    public javax.swing.JComboBox<String> jComboBox_iva;
    public javax.swing.JComboBox<String> jComboBox_proveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jtxt_cantidad;
    public javax.swing.JTextField jtxt_descripcion;
    public javax.swing.JTextField jtxt_nombre;
    public javax.swing.JTextField jtxt_precio;
    // End of variables declaration//GEN-END:variables

    

}
