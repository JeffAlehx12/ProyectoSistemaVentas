/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.raven.form;

import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import com.raven.swing.Table;
import conexion.Conexion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.GroupLayout;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Jeff Alehx
 */
public class Form_Hom extends javax.swing.JInternalFrame {

    /**
     * Creates new form Form_Hom
     */
    
    
      public Form_Hom() {
    initComponents();

    // Configuración inicial del formulario
    this.setSize(new Dimension(1580, 845));

    // Eliminar barra de título y bordes del JInternalFrame
    JInternalFrame jif = this;
    ((BasicInternalFrameUI) jif.getUI()).setNorthPane(null);
    jif.setBorder(BorderFactory.createEmptyBorder());
    jif.revalidate();
    jif.repaint();

    // Configurar el diseño
    configurarLayoutPrincipal();

 
    // Llenar la tabla con los datos de la base de datos
    llenarTablaConDatos();
    centrarTabla();

    // Configurar los datos de los cards
    configurarCards();
}

private void configurarLayoutPrincipal() {
    // Usamos un GroupLayout para organizar los componentes
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);

    // Configurar espacios automáticos
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);

    // Alineamos los cards en el centro
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(layout.createSequentialGroup()
                .addComponent(card1, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
                .addComponent(card2, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
                .addComponent(card3, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
            )
            .addComponent(spTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    layout.setVerticalGroup(
        layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(card1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(card2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                .addComponent(card3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
            )
            .addComponent(spTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
}

// Método para llenar la tabla con datos desde la base de datos
private void llenarTablaConDatos() {
    Connection conexion = Conexion.conectar(); // Asegúrate de que la clase Conexion funcione correctamente
    DefaultTableModel model = new DefaultTableModel();

    // Modifica la consulta para obtener los datos sin la columna "Mensaje" y agregando "fecha_registro"
    String query = "SELECT nombre_producto, cantidad_actual, stock_minimo, tipo_alarma, fecha_registro FROM tb_Alarma_Producto";

    Statement stmt = null;
    ResultSet rs = null;

    try {
        stmt = conexion.createStatement();
        rs = stmt.executeQuery(query);

        // Configura las columnas del modelo de la tabla, incluyendo la nueva columna "Fecha Registro"
        model.addColumn("Nombre Producto");
        model.addColumn("Cantidad Actual");
        model.addColumn("Stock Mínimo");
        model.addColumn("Tipo Alarma");
        model.addColumn("Fecha Registro");  // Columna para mostrar la fecha

        // Verificar si el ResultSet tiene datos
        boolean tieneDatos = false;

        while (rs.next()) {
            tieneDatos = true; // Hay datos, marcar como verdadero

            String nombreProducto = rs.getString("nombre_producto");
            int cantidadActual = rs.getInt("cantidad_actual");
            int stockMinimo = rs.getInt("stock_minimo");
            String tipoAlarma = rs.getString("tipo_alarma");
            Timestamp fechaRegistro = rs.getTimestamp("fecha_registro");  // Recupera la fecha de registro

            // Imprimir los datos en la consola para depuración
            System.out.println("Producto: " + nombreProducto + ", Cantidad: " + cantidadActual 
                               + ", Stock Minimo: " + stockMinimo + ", Tipo de Alarma: " + tipoAlarma 
                               + ", Fecha Registro: " + fechaRegistro);

            // Crea un arreglo de objetos para la fila, incluyendo la fecha de registro
            Object[] fila = new Object[5]; // Ahora con 5 columnas
            fila[0] = nombreProducto;
            fila[1] = cantidadActual;
            fila[2] = stockMinimo;
            fila[3] = tipoAlarma;
            fila[4] = fechaRegistro;  // Asigna la fecha de registro a la última columna

            // Agrega la fila al modelo de la tabla
            model.addRow(fila);
        }

        // Si no hay datos, mostrar un mensaje
        if (!tieneDatos) {
            System.out.println("No se encontraron datos en la consulta.");
        }

        // Asigna el modelo de la tabla a la tabla que estás utilizando
        table.setModel(model);

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conexion != null) conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

private void centrarTabla() {
    // 1. Centrar los Encabezados de las columnas con un tamaño de letra más grande
    DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
    headerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Centrado horizontal en los encabezados

    // Aumentar tamaño de letra en encabezados
    headerRenderer.setFont(new Font("Segoe UI", Font.BOLD, 18)); // Fuente más grande (18px) y negrita
    headerRenderer.setBackground(new Color(230, 230, 230)); // Fondo gris claro para encabezados
    headerRenderer.setForeground(Color.BLACK); // Texto negro para el encabezado

    // Aplicar el renderizador de encabezado a todas las columnas
    JTableHeader header = table.getTableHeader();
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer); // Centrar los encabezados
    }

    // 2. Centrar solo los Registros de las filas (datos de la tabla) de manera horizontal
    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
    cellRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto en horizontal

    // Aumentar tamaño de letra en las celdas de la tabla
    cellRenderer.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Fuente moderna, tamaño 14px
    cellRenderer.setBackground(Color.WHITE); // Fondo blanco para las celdas
    cellRenderer.setForeground(new Color(102, 102, 102)); // Texto gris oscuro para las celdas

    // Aplicar el renderizador a todas las celdas de la tabla
    table.setDefaultRenderer(Object.class, cellRenderer);

    // 3. Estilo general de la tabla: mejorar bordes y color
    table.setGridColor(new Color(230, 230, 230)); // Color gris suave para las líneas de la tabla
    table.setRowHeight(35); // Aumentar altura de las filas para que se vea más espacioso
    table.setShowGrid(true); // Mostrar las líneas de la cuadrícula
    table.setIntercellSpacing(new Dimension(5, 5)); // Espacio entre celdas
    table.setSelectionBackground(new Color(0, 123, 255)); // Fondo azul cuando una fila está seleccionada
    table.setSelectionForeground(Color.WHITE); // Texto blanco en filas seleccionadas
}


private void configurarCards() {
    // Crear objetos Model_Card
    Model_Card card1Data = new Model_Card(
        new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")),
        "Stock Total",
        "$200000",
        "Increased by 60%"
    );

    Model_Card card2Data = new Model_Card(
        new ImageIcon(getClass().getResource("/com/raven/icon/profit.png")),
        "Total Profit",
        "$15000",
        "Increased by 25%"
    );

    Model_Card card3Data = new Model_Card(
        new ImageIcon(getClass().getResource("/com/raven/icon/flag.png")),
        "Unique Visitors",
        "$300000",
        "Increased by 70%"
    );

    // Actualizar las tarjetas con los datos
    card1.setData(card1Data);
    card2.setData(card2Data);
    card3.setData(card3Data);

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
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        panel = new javax.swing.JLayeredPane();
        card1 = new com.raven.component.Card();
        card2 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();

        setBorder(null);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("Standard Table Design");

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel.add(card3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private com.raven.swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
