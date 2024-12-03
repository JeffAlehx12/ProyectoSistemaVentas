package com.raven.swing;

import com.raven.model.StatusType;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {
    
public Table(DefaultTableModel model) {
        super(model); // Inicializamos con el modelo
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false); // Evita que se reordenen las columnas

        // Personaliza el renderizado del encabezado de la tabla
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel headerLabel = new JLabel(value.toString());
                headerLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centrar horizontalmente
                headerLabel.setVerticalAlignment(SwingConstants.CENTER); // Centrar verticalmente
                headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Fuente del encabezado
                headerLabel.setOpaque(true);
                headerLabel.setBackground(new Color(230, 230, 230)); // Fondo gris claro
                headerLabel.setForeground(Color.BLACK); // Texto negro
                return headerLabel;
            }
        });

        // Personaliza el renderizado de las celdas de la tabla
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                cellComponent.setBackground(Color.WHITE); // Fondo blanco para todas las celdas
                if (isSelected) {
                    cellComponent.setForeground(new Color(15, 89, 140)); // Texto azul cuando está seleccionado
                } else {
                    cellComponent.setForeground(new Color(102, 102, 102)); // Texto gris oscuro
                }
                return cellComponent;
            }
        });
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Hace que todas las celdas sean no editables
    }

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row); // Agrega una fila al modelo
    }
}