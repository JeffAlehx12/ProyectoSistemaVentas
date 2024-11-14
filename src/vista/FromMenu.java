
package vista;


import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;

public class FromMenu extends javax.swing.JFrame {

    public static JDesktopPane desktopPane;

      
    public FromMenu() {
        
        initComponents();
       
    }

  

   
    public JMenuItem getjMenuItem_cerrar_sesion() {
        return jMenuItem_cerrar_sesion;
    }
   

    public JMenuItem getjMenuItem_gestionar_cliente() {
        return jMenuItem_gestionar_cliente;
    }

    

    public JMenuItem getjMenuItem_gestionar_inventario() {
        return jMenuItem_Inventario;
    }


    public JMenuItem getjMenuItem_gestionar_producto() {
        return jMenuItem_gestionar_producto;
    }


    public JMenuItem getjMenuItem_gestionar_proveedores() {
        return jMenuItem_gestionar_proveedores;
    }

 

    public JMenuItem getjMenuItem_gestionar_usuarios() {
        return jMenuItem_gestionar_usuarios;
    }

  

    public JMenuItem getjMenuItem_gestionar_venta() {
        return jMenuItem_gestionar_venta;
    }


    public JMenuItem getjMenuItem_nueva_venta() {
        return jMenuItem_nueva_venta;
    }

   
 
    public JMenuItem getjMenuItem_registrar_ingreso() {
        return jMenuItem_Entradas;
    }


    public JMenuItem getjMenuItem_registrar_salida() {
        return jMenuItem_Salidas;
    }

   
    public JMenuItem getjMenuItem_reportes_categorias() {
        return jMenuItem_reportes_categorias;
    }


    public JMenuItem getjMenuItem_reportes_clientes() {
        return jMenuItem_reportes_clientes;
    }

    

    public JMenuItem getjMenuItem_reportes_productos() {
        return jMenuItem_reportes_productos;
    }


    public JMenuItem getjMenuItem_reportes_ventas() {
        return jMenuItem_reportes_ventas;
    }


    public JMenuItem getjMenuItem_ver_historial() {
        return jMenuItem_ver_historial;
    }

    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_gestionar_usuarios = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_gestionar_producto = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem_Entradas = new javax.swing.JMenuItem();
        jMenuItem_Salidas = new javax.swing.JMenuItem();
        jMenuItem_Inventario = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem_gestionar_proveedores = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_gestionar_cliente = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem_nueva_venta = new javax.swing.JMenuItem();
        jMenuItem_gestionar_venta = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem_reportes_clientes = new javax.swing.JMenuItem();
        jMenuItem_reportes_categorias = new javax.swing.JMenuItem();
        jMenuItem_reportes_productos = new javax.swing.JMenuItem();
        jMenuItem_reportes_ventas = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem_ver_historial = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem_InformacionEmpresa = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem_cerrar_sesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        jMenu1.setText("Usuario");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_gestionar_usuarios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_gestionar_usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones.png"))); // NOI18N
        jMenuItem_gestionar_usuarios.setText("Gestionar Usuarios");
        jMenuItem_gestionar_usuarios.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_gestionar_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_usuariosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_gestionar_usuarios);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        jMenu2.setText("Producto");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_gestionar_producto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_gestionar_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        jMenuItem_gestionar_producto.setText("Gestionar Productos");
        jMenuItem_gestionar_producto.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_gestionar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_productoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_gestionar_producto);

        jMenuBar1.add(jMenu2);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Invent.png"))); // NOI18N
        jMenu9.setText("Inventario");
        jMenu9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu9.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_Entradas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_Entradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-producto.png"))); // NOI18N
        jMenuItem_Entradas.setText("Registrar Ingreso");
        jMenuItem_Entradas.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_Entradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_EntradasActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem_Entradas);

        jMenuItem_Salidas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_Salidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-producto.png"))); // NOI18N
        jMenuItem_Salidas.setText("Registrar Salida");
        jMenuItem_Salidas.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_Salidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_SalidasActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem_Salidas);

        jMenuItem_Inventario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_Inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/inventario.peque.png"))); // NOI18N
        jMenuItem_Inventario.setText("Consultar Inventario ");
        jMenuItem_Inventario.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_InventarioActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem_Inventario);

        jMenuBar1.add(jMenu9);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N
        jMenu10.setText("Proveedor");
        jMenu10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu10.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_gestionar_proveedores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_gestionar_proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N
        jMenuItem_gestionar_proveedores.setText("Gestionar Proveedores");
        jMenuItem_gestionar_proveedores.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_gestionar_proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_proveedoresActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem_gestionar_proveedores);

        jMenuBar1.add(jMenu10);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N
        jMenu3.setText("Cliente");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_gestionar_cliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_gestionar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente.png"))); // NOI18N
        jMenuItem_gestionar_cliente.setText("Gestionar Clientes");
        jMenuItem_gestionar_cliente.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_gestionar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_clienteActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_gestionar_cliente);

        jMenuBar1.add(jMenu3);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito.png"))); // NOI18N
        jMenu5.setText("Factura");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu5.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_nueva_venta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_nueva_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir.png"))); // NOI18N
        jMenuItem_nueva_venta.setText("Nueva Venta");
        jMenuItem_nueva_venta.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_nueva_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_nueva_ventaActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_nueva_venta);

        jMenuItem_gestionar_venta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_gestionar_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones.png"))); // NOI18N
        jMenuItem_gestionar_venta.setText("Gestionar Ventas");
        jMenuItem_gestionar_venta.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_gestionar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_gestionar_ventaActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_gestionar_venta);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportes.png"))); // NOI18N
        jMenu6.setText("Reportes");
        jMenu6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu6.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_reportes_clientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_reportes_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jMenuItem_reportes_clientes.setText("Reportes Clientes");
        jMenuItem_reportes_clientes.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenu6.add(jMenuItem_reportes_clientes);

        jMenuItem_reportes_categorias.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_reportes_categorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jMenuItem_reportes_categorias.setText("Reportes Categorias");
        jMenuItem_reportes_categorias.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenu6.add(jMenuItem_reportes_categorias);

        jMenuItem_reportes_productos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_reportes_productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jMenuItem_reportes_productos.setText("Reportes Productos");
        jMenuItem_reportes_productos.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_reportes_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_reportes_productosActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem_reportes_productos);

        jMenuItem_reportes_ventas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_reportes_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jMenuItem_reportes_ventas.setText("Reportes Ventas");
        jMenuItem_reportes_ventas.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenu6.add(jMenuItem_reportes_ventas);

        jMenuBar1.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/historial1.png"))); // NOI18N
        jMenu7.setText("Historial");
        jMenu7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu7.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_ver_historial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_ver_historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/historial1.png"))); // NOI18N
        jMenuItem_ver_historial.setText("Ver Historial");
        jMenuItem_ver_historial.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenu7.add(jMenuItem_ver_historial);

        jMenuBar1.add(jMenu7);

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/configuraciones.png"))); // NOI18N
        jMenu11.setText("Configuracion");
        jMenu11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu11.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_InformacionEmpresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_InformacionEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporte1.png"))); // NOI18N
        jMenuItem_InformacionEmpresa.setText("Informacion de la Empresa");
        jMenuItem_InformacionEmpresa.setPreferredSize(new java.awt.Dimension(240, 30));
        jMenuItem_InformacionEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_InformacionEmpresaActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem_InformacionEmpresa);

        jMenuBar1.add(jMenu11);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        jMenu8.setText("Cerrar Sesión");
        jMenu8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu8.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_cerrar_sesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenuItem_cerrar_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        jMenuItem_cerrar_sesion.setText("Cerrar");
        jMenuItem_cerrar_sesion.setPreferredSize(new java.awt.Dimension(200, 30));
        jMenuItem_cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_cerrar_sesionActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem_cerrar_sesion);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_gestionar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_productoActionPerformed
  
        
        
    }//GEN-LAST:event_jMenuItem_gestionar_productoActionPerformed

    private void jMenuItem_reportes_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_reportes_productosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_reportes_productosActionPerformed

    private void jMenuItem_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_cerrar_sesionActionPerformed

        
    }//GEN-LAST:event_jMenuItem_cerrar_sesionActionPerformed

    private void jMenuItem_nueva_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_nueva_ventaActionPerformed
     
        
      
    }//GEN-LAST:event_jMenuItem_nueva_ventaActionPerformed

    private void jMenuItem_gestionar_proveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_proveedoresActionPerformed
           
    }//GEN-LAST:event_jMenuItem_gestionar_proveedoresActionPerformed

    private void jMenuItem_gestionar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_clienteActionPerformed

    }//GEN-LAST:event_jMenuItem_gestionar_clienteActionPerformed

    private void jMenuItem_gestionar_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_usuariosActionPerformed

        
    }//GEN-LAST:event_jMenuItem_gestionar_usuariosActionPerformed

    private void jMenuItem_EntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_EntradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_EntradasActionPerformed

    private void jMenuItem_SalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_SalidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_SalidasActionPerformed

    private void jMenuItem_InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_InventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_InventarioActionPerformed

    private void jMenuItem_gestionar_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_gestionar_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_gestionar_ventaActionPerformed

    private void jMenuItem_InformacionEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_InformacionEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem_InformacionEmpresaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FromMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    public javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem_Entradas;
    public javax.swing.JMenuItem jMenuItem_InformacionEmpresa;
    public javax.swing.JMenuItem jMenuItem_Inventario;
    public javax.swing.JMenuItem jMenuItem_Salidas;
    public javax.swing.JMenuItem jMenuItem_cerrar_sesion;
    public javax.swing.JMenuItem jMenuItem_gestionar_cliente;
    public javax.swing.JMenuItem jMenuItem_gestionar_producto;
    public javax.swing.JMenuItem jMenuItem_gestionar_proveedores;
    public javax.swing.JMenuItem jMenuItem_gestionar_usuarios;
    public javax.swing.JMenuItem jMenuItem_gestionar_venta;
    public javax.swing.JMenuItem jMenuItem_nueva_venta;
    public javax.swing.JMenuItem jMenuItem_reportes_categorias;
    public javax.swing.JMenuItem jMenuItem_reportes_clientes;
    public javax.swing.JMenuItem jMenuItem_reportes_productos;
    public javax.swing.JMenuItem jMenuItem_reportes_ventas;
    public javax.swing.JMenuItem jMenuItem_ver_historial;
    // End of variables declaration//GEN-END:variables


  
}
