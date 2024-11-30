package controlador;

import com.raven.main.Main;
import conexion.Conexion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import vista.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Imagen;
import modelo.Producto;

public class Frm_Ctrl_PendienteEntrada {

    private InterPendiente vista;
    private Frm_Ctrl_Entrada controladorEntrada;
    private int idPendienteEntrada;

    public Frm_Ctrl_PendienteEntrada(InterPendiente vista, Frm_Ctrl_Entrada controladorEntrada) {
        this.vista = vista;
        this.controladorEntrada = controladorEntrada; // Guarda la referencia del controlador
        CargarTablaPendientes(); // Puedes llamar a este método aquí o desde otro lugar
        init();
    }

    private void init() {

        vista.setTitle("Confirmacion de Entrega");
        vista.setSize(new Dimension(1300, 520));
        vista.setLocation(300, 80);
        vista.setVisible(true);

        Main.desktopPane.add(vista);
        vista.toFront();

        vista.jbtnConfirmar.addActionListener(e -> jbtnConfirmarActionPerformed(e));
        vista.jbtnEliminar.addActionListener(e -> jbtnEliminarActionPerformed(e));
        vista.jbtnCancelar.addActionListener(e -> jbtnCancelarActionPerformed(e));

    }

    private void jbtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {
// Obtener la fila seleccionada de la tabla de pendientes
        int filaSeleccionada = vista.jtblPendientes.getSelectedRow();
        if (filaSeleccionada >= 0) { // Verifica que haya una fila seleccionada
            // Obtiene el ID del pendiente de entrada seleccionado
            int idPendienteEntrada = (int) vista.jtblPendientes.getValueAt(filaSeleccionada, 0);

            // Llama a un método para transportar los datos a la tabla tb_entradas
            controladorEntrada.transportarDatosAEntradas(idPendienteEntrada);

            // Actualiza el estado del pendiente a confirmado (1) y estado a 0
            try {
                Connection con = Conexion.conectar();
                String sql = "UPDATE tb_entradas_pendientes SET confirmado = 1, estado = 0 WHERE idPendienteEntrada = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idPendienteEntrada); // Pasar el idPendienteEntrada al query

                int resultado = ps.executeUpdate(); // Ejecutar la actualización

                if (resultado > 0) {
                    JOptionPane.showMessageDialog(vista, "Entrada confirmada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al confirmar la entrada.");
                }

                ps.close();
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(vista, "Error al confirmar la entrada: " + e.getMessage());
            }

            // Cierra la ventana de selección
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor, selecciona una entrada pendiente.");
        }
    }

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent etv) {
        int filaSeleccionada = vista.jtblPendientes.getSelectedRow(); // Obtener la fila seleccionada en la tabla

        if (filaSeleccionada >= 0) { // Verifica que haya una fila seleccionada
            // Obtener el valor de idPendienteEntrada desde la columna correcta
            try {
                Object valor = vista.jtblPendientes.getValueAt(filaSeleccionada, 0); // Obtener el valor de la celda

                // Intentar convertir el valor a un entero
                idPendienteEntrada = Integer.parseInt(valor.toString()); // Asegúrate de que es el índice correcto

                // Confirmar la eliminación (cambio de estado)
                int confirmacion = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro de que desea marcar esta entrada como eliminada?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    Connection con = Conexion.conectar();
                    String sql = "UPDATE tb_entradas_pendientes SET estado = 0 WHERE idPendienteEntrada = ?"; // Cambia el estado a 0

                    try {
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, idPendienteEntrada); // Pasar el idPendienteEntrada al query

                        int resultado = ps.executeUpdate(); // Ejecutar la actualización

                        if (resultado > 0) {
                            JOptionPane.showMessageDialog(null, "Entrada Pendiente eliminada correctamente.");
                            CargarTablaPendientes(); // Volver a cargar la tabla para reflejar los cambios
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al marcar la entrada como eliminada.");
                        }

                        ps.close();
                        con.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al eliminar la entrada pendiente: " + e.getMessage());
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al convertir el ID de la entrada. El valor obtenido es: " + vista.jtblPendientes.getValueAt(filaSeleccionada, 0));
            } catch (ClassCastException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener el ID de la entrada. Asegúrate de que el valor sea un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una entrada pendiente para eliminar.");
        }

    }

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {

        vista.dispose();

    }

    private void CargarTablaPendientes() {
        Connection con = Conexion.conectar();  // Método para conectar a la base de datos
        DefaultTableModel model = new DefaultTableModel();

        // Consulta SQL para obtener los datos de tb_entradas_pendientes con el nuevo orden
        String sql = "SELECT ep.idPendienteEntrada, ep.motivo, ep.documento, p.nombre AS productoNombre, "
                + "c.nombreCategoria, pr.razonSocial AS proveedorNombre, ep.fecha, ep.cantidad, ep.precioCosto, "
                + "ep.total, ep.obs, ep.confirmado "
                + "FROM tb_entradas_pendientes ep "
                + "JOIN tb_producto p ON ep.idProducto = p.idProducto "
                + "JOIN tb_categoria c ON ep.idCategoria = c.idCategoria "
                + "JOIN tb_proveedor pr ON ep.idProveedor = pr.idProveedor "
                + "WHERE ep.estado = 1;"; // Filtrar solo registros con estado 1

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Establecer el modelo de la tabla
            vista.jtblPendientes.setModel(model);
            model.addColumn("ID"); // Añadir columna para ID, pero la ocultaremos después
            model.addColumn("Motivo");
            model.addColumn("Documento");
            model.addColumn("Producto");
            model.addColumn("Categoría");
            model.addColumn("Proveedor");
            model.addColumn("Fecha");
            model.addColumn("Cantidad");
            model.addColumn("Precio Costo");
            model.addColumn("Total");  // Ahora el total está al final
            model.addColumn("Obs."); // Mover Observaciones después de Total
            model.addColumn("Confirmado");  // Columna Confirmado

            // Iterar sobre los resultados de la consulta y agregarlos a la tabla
            while (rs.next()) {
                Object[] fila = new Object[12]; // Ahora tiene 12 elementos
                fila[0] = rs.getInt("idPendienteEntrada"); // Guardamos el ID
                fila[1] = rs.getString("motivo");  // Se obtiene el motivo
                fila[2] = rs.getString("documento");  // Documento
                fila[3] = rs.getString("productoNombre");
                fila[4] = rs.getString("nombreCategoria");
                fila[5] = rs.getString("proveedorNombre");
                fila[6] = rs.getDate("fecha");  // Fecha
                fila[7] = rs.getInt("cantidad");
                fila[8] = rs.getDouble("precioCosto");
                fila[9] = rs.getDouble("total");  // Total
                fila[10] = rs.getString("obs");    // Observaciones (ahora después de Total)

                // Verificar el valor del campo 'confirmado' y mostrar "Sí" o "No"
                int confirmado = rs.getInt("confirmado");
                fila[11] = confirmado == 0 ? "No" : "Sí";

                model.addRow(fila);
                
                
                
            }

           
           
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de pendientes: " + e);
        }
    }
    
    

}
