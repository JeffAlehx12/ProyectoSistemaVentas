package vista;

import controlador.*;




public class InterGestionarProducto extends javax.swing.JInternalFrame {

    
    

    public InterGestionarProducto() {
        initComponents();
        

        
        
        
        
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jbtnCategoria = new javax.swing.JButton();
        jbtnProducto = new javax.swing.JButton();
        jbtnActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtBusqueda = new javax.swing.JTextField();
        jbtnBuscarporDni = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setBackground(new java.awt.Color(255, 255, 255));
        jTable_productos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Categoria", "Ubicacion", "Precio Costo", "Precio Venta", "IGV", "Precio total"
            }
        ));
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1510, 440));

        jbtnCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categorias.png"))); // NOI18N
        jbtnCategoria.setText("Categoria");
        jbtnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 130, 30));

        jbtnProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-producto.png"))); // NOI18N
        jbtnProducto.setText("Agregar Producto");
        jbtnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnProductoActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 170, 30));

        jbtnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jbtnActualizar.setText("Actualizar");
        jbtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 140, 30));

        jPanel2.setBackground(new java.awt.Color(59, 130, 246));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTIONAR PRODUCTO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1590, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 20, 30));

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
        jPanel1.add(jtxtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 190, 30));

        jbtnBuscarporDni.setText("Buscar");
        jbtnBuscarporDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarporDniActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnBuscarporDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, 840));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnActualizarActionPerformed

    private void jbtnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnProductoActionPerformed


    }//GEN-LAST:event_jbtnProductoActionPerformed

    private void jbtnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCategoriaActionPerformed


    }//GEN-LAST:event_jbtnCategoriaActionPerformed

    private void jtxtBusquedaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jtxtBusquedaCaretUpdate

    }//GEN-LAST:event_jtxtBusquedaCaretUpdate

    private void jtxtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBusquedaActionPerformed

    private void jbtnBuscarporDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarporDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnBuscarporDniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    public javax.swing.JButton jbtnActualizar;
    public javax.swing.JButton jbtnBuscarporDni;
    public javax.swing.JButton jbtnCategoria;
    public javax.swing.JButton jbtnProducto;
    public javax.swing.JTextField jtxtBusqueda;
    // End of variables declaration//GEN-END:variables

}
