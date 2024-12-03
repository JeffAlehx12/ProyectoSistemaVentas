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
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;



/**
 *
 * @author RAVEN
 */
public class Main extends javax.swing.JFrame {

    
    public static Main main;
    
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
    private InterHistorialVentas interHistorialVentas;
    private InterConfiguracion interConfiguracion;
    
    
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
    private Frm_Ctrl_HistorialVentas ctrl_HistorialVentas;
    private Frm_Ctrl_Configuracion ctrl_Configuracion;
    
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
        interHistorialVentas = new InterHistorialVentas();
        interConfiguracion = new InterConfiguracion();
        
        
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
        ctrl_HistorialVentas = new Frm_Ctrl_HistorialVentas(interHistorialVentas);
        ctrl_Configuracion = new Frm_Ctrl_Configuracion(interConfiguracion);
                
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
                    case 22:
                        setForm(interHistorialVentas);
                        break;   
                    case 24:
                        setForm(interConfiguracion);
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

   public void cerrarVentana() {
       this.dispose();
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
        mainPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        header1 = new com.raven.component.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/menu.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 657, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // Crear un JPopupMenu estilizado
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 1)); // Borde más moderno
        popupMenu.setBackground(new Color(255, 255, 255)); // Fondo blanco para el menú

        // Crear las opciones del menú con estilos
        JMenuItem opcion1 = new JMenuItem("Configuración general");
        JMenuItem opcion2 = new JMenuItem("Información Empresa");
        JMenuItem opcion3 = new JMenuItem("Cerrar sesión");

        // Estilo para las opciones del menú
        Font font = new Font("Tahoma", Font.PLAIN, 14); // Fuente más agradable y pequeña
        opcion1.setFont(font);
        opcion2.setFont(font);
        opcion3.setFont(font);

        opcion1.setBackground(new Color(255, 255, 255)); // Fondo blanco
        opcion2.setBackground(new Color(255, 255, 255));
        opcion3.setBackground(new Color(255, 255, 255));

        opcion1.setForeground(new Color(60, 60, 60)); // Texto gris oscuro, más suave
        opcion2.setForeground(new Color(60, 60, 60));
        opcion3.setForeground(new Color(60, 60, 60));

        // Agregar efectos visuales al pasar el ratón
        MouseAdapter hoverEffect = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ((JMenuItem) e.getSource()).setBackground(new Color(230, 230, 230)); // Fondo claro al pasar el ratón
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ((JMenuItem) e.getSource()).setBackground(Color.WHITE); // Fondo blanco al salir
            }
        };
        opcion1.addMouseListener(hoverEffect);
        opcion2.addMouseListener(hoverEffect);
        opcion3.addMouseListener(hoverEffect);

        // Agregar acción a cada opción
        opcion1.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Abrir configuración general");
        });

        opcion2.addActionListener(e -> {

            // Cerrar todas las ventanas abiertas en el DesktopPane
            for (JInternalFrame iframe : Main.desktopPane.getAllFrames()) {
                iframe.dispose(); // Cierra y elimina la ventana interna
            }

            // Crear e agregar la ventana de configuración si no está abierta
            interConfiguracion = new InterConfiguracion();
            ctrl_Configuracion = new Frm_Ctrl_Configuracion(interConfiguracion);

            Main.desktopPane.add(interConfiguracion);
            interConfiguracion.setVisible(true);
        });

        opcion3.addActionListener(e -> {

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cerrar sesión?", "Confirmar cierre de sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION) {

                
                this.dispose();

                // Ahora abre el formulario de login
                FromLogin fl = new FromLogin();
                Frm_Ctrl_Login cl = new Frm_Ctrl_Login(fl);
                fl.setVisible(true);
                fl.setLocationRelativeTo(null);
            }
        });

        // Agregar las opciones al menú
        popupMenu.add(opcion1);
        popupMenu.add(opcion2);
        popupMenu.add(opcion3);

        // Mostrar el menú en la ubicación del clic
        int x = evt.getX();
        int y = evt.getY();

        // Ajustar la posición si el menú se sale del contenedor
        int popupWidth = popupMenu.getPreferredSize().width; // Ancho del menú
        int screenWidth = jLabel2.getWidth();                // Ancho del JLabel
        if (x + popupWidth > screenWidth) {
            x = screenWidth - popupWidth; // Mueve el menú hacia la izquierda
        }

        popupMenu.show(jLabel2, x, y);
    }//GEN-LAST:event_jLabel2MouseClicked

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
    private com.raven.component.Header header1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPanel mainPanel;
    private com.raven.component.Menu menu;
    private com.raven.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
