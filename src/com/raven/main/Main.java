/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.main;

import com.raven.event.EventMenuSelected;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;
import vista.*;
import controlador.*;
import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import com.raven.form.*;
import java.awt.Component;
import java.util.Arrays;
import javax.swing.JPanel;


/**
 *
 * @author RAVEN
 */
public class Main extends javax.swing.JFrame {

     // Panel principal y DesktopPane
    public static JDesktopPane desktopPane;

    // InternalFrames
    private Form_Hom home;
    private InterGestionarUsuario interGestionarUsuario;
    private InterGestionarProducto interGestionarProducto;
    private InterEntradas interEntradas;
    private InterSalidas interSalidas;
    private InterInventario interInventario;
    private InterGestionarProveedor interGestionarProveedor;
    private InterGestionarCliente interGestionarCliente;
    private InterFacturacion interFacturacion;
    private InterGestionarVentas interGestionarVentas;
    
    // Controladores
    private Frm_Ctrl_GestionarUsuario ctrl_GestionarUsuario;
    private Frm_Ctrl_GestionarProducto ctrl_GestionarProducto;
    private Frm_Ctrl_Entrada ctrl_Entrada;
    private Frm_Ctrl_Salida ctrl_Salida;
    private Frm_Ctrl_Inventario ctrl_Inventario;
    private Frm_Ctrl_GestionarProveedores ctrl_GestionarProveedores;
    private Frm_Ctrl_GestionarCliente ctrl_GestionarCliente;
    private Frm_Ctrl_RegistrarVenta ctrl_RegistrarVenta;
    private Frm_Ctrl_GestionarVentas ctrl_GestionarVentas;
    private Reportes reportes;
    
    
    
    
    public Main() {
        initComponents();

        // Crea un JDesktopPane personalizado
        desktopPane = new JDesktopPane() {
            private final Image backgroundImage = new ImageIcon(getClass().getResource("/com/raven/icon/desktop_Jpanel.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Configura el tamaño del JDesktopPane
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        desktopPane.setBounds(0, 0, screenSize.width, screenSize.height - 120);

        // Agrega el desktopPane al mainPanel
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(desktopPane, BorderLayout.CENTER);

        
        
        
        
        // Configura tamaño de la ventana principal
        setSize(new Dimension(1800, 900));
        setLocationRelativeTo(null);

        
        
        
        
        // Inicializa los formularios
        home = new Form_Hom();
        interGestionarUsuario = new InterGestionarUsuario();
        interGestionarProducto = new InterGestionarProducto();
        interEntradas = new InterEntradas();
        interSalidas = new InterSalidas();
        interInventario = new InterInventario();
        interGestionarProveedor= new InterGestionarProveedor();
        interGestionarCliente= new InterGestionarCliente();
        interFacturacion = new InterFacturacion();
        interGestionarVentas = new InterGestionarVentas();
        
        
        //Inicializa los controladores
        ctrl_GestionarUsuario = new Frm_Ctrl_GestionarUsuario(interGestionarUsuario);
        ctrl_GestionarProducto = new Frm_Ctrl_GestionarProducto(interGestionarProducto);
        ctrl_Entrada = new Frm_Ctrl_Entrada(interEntradas);
        ctrl_Salida = new Frm_Ctrl_Salida(interSalidas);
        ctrl_Inventario = new Frm_Ctrl_Inventario(interInventario);
        ctrl_GestionarProveedores = new Frm_Ctrl_GestionarProveedores(interGestionarProveedor);
        ctrl_GestionarCliente = new Frm_Ctrl_GestionarCliente(interGestionarCliente);
        ctrl_RegistrarVenta= new Frm_Ctrl_RegistrarVenta(interFacturacion);
        ctrl_GestionarVentas = new Frm_Ctrl_GestionarVentas(interGestionarVentas);
        this.reportes = new Reportes(); 
        
        
        // Inicializa el menú
        menu.initMoving(Main.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                switch (index) {
                    case 0:
                        setForm(home);
                        break;
                    case 2:
                        setForm(interGestionarUsuario);
                        break;
                    case 4:
                        interGestionarProducto = new InterGestionarProducto();
                        ctrl_GestionarProducto = new Frm_Ctrl_GestionarProducto(interGestionarProducto);
                        setForm(interGestionarProducto);
                        break;
                    case 6:
                        setForm(interEntradas);
                        break; 
                    case 7:
                        interSalidas = new InterSalidas();
                        ctrl_Salida = new Frm_Ctrl_Salida(interSalidas);
                        setForm(interSalidas);
                        break;  
                    case 8:
                        interInventario = new InterInventario();
                        ctrl_Inventario = new Frm_Ctrl_Inventario(interInventario);
                        setForm(interInventario);
                        break;
                    case 10:
                        setForm(interGestionarProveedor);
                        break;
                    case 12:
                        setForm(interGestionarCliente);
                        break;
                    case 14:
                        setForm(interFacturacion);
                        break;
                    case 15:
                        interGestionarVentas = new InterGestionarVentas();
                        ctrl_GestionarVentas = new Frm_Ctrl_GestionarVentas(interGestionarVentas);
                        setForm(interGestionarVentas);
                        break;
                    case 17:
                        reportes.ReportesClientes();
                        break;
                    case 18:
                        reportes.ReportesCategorias();
                        break;    
                    case 19:
                        reportes.ReportesProductos();
                        break;    
                    case 20:
                        reportes.ReportesVentas();
                        break;     
                }
            }
        });

        // Muestra la pantalla de inicio
        setForm(home);
    }

    // Método para agregar el formulario al JDesktopPane
    private void setForm(JComponent form) {
        // Oculta todos los componentes existentes en el DesktopPane
        for (Component comp : desktopPane.getComponents()) {
            comp.setVisible(false);
        }

        // Verifica si el formulario ya está en el DesktopPane
        if (!Arrays.asList(desktopPane.getComponents()).contains(form)) {
            desktopPane.add(form); // Agrega el formulario si no está
        }

        // Configura visibilidad y tamaño para JPanel
        if (form instanceof JPanel) {
            form.setBounds(0, 0, desktopPane.getWidth(), desktopPane.getHeight());
        }

        // Muestra el formulario seleccionado
        form.setVisible(true);

        // Lleva al frente si es un JInternalFrame
        if (form instanceof JInternalFrame) {
            try {
                ((JInternalFrame) form).setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
                e.printStackTrace();
            }
        }

        // Actualiza el DesktopPane
        desktopPane.revalidate();
        desktopPane.repaint();
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.swing.PanelBorder();
        menu = new com.raven.component.Menu();
        header2 = new com.raven.component.Header();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 657, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Header header2;
    public javax.swing.JPanel mainPanel;
    private com.raven.component.Menu menu;
    private com.raven.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
