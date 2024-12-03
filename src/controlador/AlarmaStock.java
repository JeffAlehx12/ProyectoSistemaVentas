package controlador;

import java.sql.*;
import conexion.Conexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class AlarmaStock {
    
        // Método para verificar las alarmas de stock
    public void verificarStock() {
        Connection cn = Conexion.conectar();

        try {
            // Alarma 1: Productos cerca del stock mínimo (actualizado a +100)
            String sqlCercaStock = "SELECT nombre, cantidad_actual, stock_min "
                    + "FROM tb_producto "
                    + "WHERE cantidad_actual > stock_min "
                    + "AND cantidad_actual <= (stock_min + 100) "
                    + // Cambiado a +100
                    "AND estado = 1";
            PreparedStatement pst1 = cn.prepareStatement(sqlCercaStock);
            ResultSet rs1 = pst1.executeQuery();
            String mensajeCercaStock = "";

            while (rs1.next()) {
                String nombreProducto = rs1.getString("nombre");
                int cantidadActual = rs1.getInt("cantidad_actual");
                int stockMinimo = rs1.getInt("stock_min");

                // Verificar si ya existe la alarma antes de guardarla
                if (!existeAlarma(cn, nombreProducto, cantidadActual, "Cerca del mínimo")) {
                    // Guardar alarma en la base de datos con detalles completos
                    guardarAlarmaProducto(cn, nombreProducto, cantidadActual, stockMinimo, "Cerca del mínimo");
                }

                // Agregar al mensaje el nombre del producto con la cantidad entre paréntesis
                mensajeCercaStock += "- " + nombreProducto + " (" + cantidadActual + ")\n";
            }

            if (!mensajeCercaStock.isEmpty()) {
                // Mostrar notificación desvanecida con los productos cercanos al stock mínimo
                mostrarNotificacion("Atención: Los siguientes productos están cerca del stock mínimo:\n" + mensajeCercaStock, new Color(0, 123, 255), "TOP");
            }

            // Alarma 2: Productos en el stock mínimo
            String sqlStockMinimo = "SELECT nombre, cantidad_actual, stock_min "
                    + "FROM tb_producto "
                    + "WHERE cantidad_actual <= stock_min "
                    + "AND estado = 1";
            PreparedStatement pst2 = cn.prepareStatement(sqlStockMinimo);
            ResultSet rs2 = pst2.executeQuery();
            String mensajeStockMinimo = "";

            while (rs2.next()) {
                String nombreProducto = rs2.getString("nombre");
                int cantidadActual = rs2.getInt("cantidad_actual");
                int stockMinimo = rs2.getInt("stock_min");

                // Verificar si ya existe la alarma antes de guardarla
                if (!existeAlarma(cn, nombreProducto, cantidadActual, "Crítico")) {
                    // Guardar alarma en la base de datos con detalles completos
                    guardarAlarmaProducto(cn, nombreProducto, cantidadActual, stockMinimo, "Crítico");
                }

                // Agregar al mensaje el nombre del producto con la cantidad entre paréntesis
                mensajeStockMinimo += "- " + nombreProducto + " (" + cantidadActual + ")\n";
            }

            if (!mensajeStockMinimo.isEmpty()) {
                // Mostrar notificación desvanecida con los productos que han alcanzado el stock mínimo
                mostrarNotificacion("Alerta crítica: Los siguientes productos han alcanzado el stock mínimo:\n" + mensajeStockMinimo, Color.RED, "BOTTOM");
            }

            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar el stock: " + e.getMessage());
        }
    }

// Método para guardar la alarma en la base de datos
    private void guardarAlarmaProducto(Connection cn, String nombreProducto, int cantidadActual, int stockMinimo, String tipoAlarma) {
        String sqlInsert = "INSERT INTO tb_Alarma_Producto (nombre_producto, cantidad_actual, stock_minimo, tipo_alarma, mensaje) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = cn.prepareStatement(sqlInsert)) {
            pst.setString(1, nombreProducto);
            pst.setInt(2, cantidadActual);
            pst.setInt(3, stockMinimo);
            pst.setString(4, tipoAlarma);
            pst.setString(5, "Producto: " + nombreProducto + ", Cantidad actual: " + cantidadActual + ", Stock mínimo: " + stockMinimo);
            pst.executeUpdate(); // Ejecuta la inserción en la base de datos
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la alarma en la base de datos: " + e.getMessage());
        }
    }

// Método para verificar si ya existe una alarma
    private boolean existeAlarma(Connection cn, String nombreProducto, int cantidadActual, String tipoAlarma) {
        String sqlCheck = "SELECT COUNT(*) FROM tb_Alarma_Producto "
                + "WHERE nombre_producto = ? AND cantidad_actual = ? AND tipo_alarma = ?";
        try (PreparedStatement pst = cn.prepareStatement(sqlCheck)) {
            pst.setString(1, nombreProducto);
            pst.setInt(2, cantidadActual);
            pst.setString(3, tipoAlarma);
            ResultSet rs = pst.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true; // Existe la alarma
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar si existe la alarma: " + e.getMessage());
        }
        return false; // No existe la alarma
    }

    // Método para mostrar la notificación con desvanecimiento
    private static void mostrarNotificacion(String mensaje, Color color, String ubicacion) {
        // Crear un JPanel para la notificación
        JPanel notificationPanel = new JPanel();
        notificationPanel.setBackground(color); // Color del panel
        notificationPanel.setLayout(new BorderLayout());

        // Crear un JLabel con el mensaje
        JLabel messageLabel = new JLabel(mensaje, JLabel.CENTER);
        messageLabel.setForeground(Color.WHITE); // Texto en color blanco
        messageLabel.setFont(new Font("Arial", Font.BOLD, 15));

        notificationPanel.add(messageLabel, BorderLayout.CENTER);

        // Crear una ventana temporal para mostrar la notificación
        JDialog notificationDialog = new JDialog();
        notificationDialog.setUndecorated(true); // Sin bordes
        notificationDialog.setSize(1300, 50); // Tamaño reducido (más delgado)
        notificationDialog.getContentPane().add(notificationPanel);

        // Ubicar la notificación en la pantalla según la ubicación deseada
        switch (ubicacion.toUpperCase()) {
            case "TOP":
                notificationDialog.setLocationRelativeTo(null); // Centrado en la parte superior
                notificationDialog.setLocation(notificationDialog.getX(), 65); // Colocarla en la parte superior
                break;
            case "BOTTOM":
                notificationDialog.setLocationRelativeTo(null); // Centrado en la parte inferior
                int offset = 113; // Ajusta este valor para subir o bajar el cuadro
                notificationDialog.setLocation(
                        notificationDialog.getX(),
                        Toolkit.getDefaultToolkit().getScreenSize().height - notificationDialog.getHeight() - offset
                );
                break;
            default:
                notificationDialog.setLocationRelativeTo(null); // Centrado en la pantalla por defecto
        }

        // Mostrar la notificación
        notificationDialog.setVisible(true);

        // Hacer que la notificación desaparezca después de 3 segundos
        Timer timer = new Timer(8000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notificationDialog.dispose(); // Cerrar la notificación
            }
        });
        timer.setRepeats(false); // Solo se ejecuta una vez
        timer.start();
    }
}
