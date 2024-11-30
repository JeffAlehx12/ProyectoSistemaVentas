package com.raven.component;

import com.raven.main.Main;
import controlador.Frm_Ctrl_Configuracion;
import controlador.Frm_Ctrl_Login;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import vista.FromLogin;
import vista.InterConfiguracion;

public class Header extends javax.swing.JPanel {

    Main vista;
    
    private InterConfiguracion interConfiguracion;
    private Frm_Ctrl_Configuracion ctrl_Configuracion;
    
    
    
    public Header() {
        
        initComponents();
        
       
        
        setOpaque(false);
        
    }
    
  
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        searchText1 = new com.raven.swing.SearchText();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search.png"))); // NOI18N

        searchText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchText1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/menu.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(searchText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
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
                
                vista = new Main();
                // Llama al método cerrarVentana() de la instancia de Main
                vista.dispose();
                vista.setVisible(false);

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

    private void searchText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchText1ActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.raven.swing.SearchText searchText1;
    // End of variables declaration//GEN-END:variables
}
