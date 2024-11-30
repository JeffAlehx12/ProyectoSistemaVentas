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



public class Frm_Ctrl_SeleccionProductoInventario {
     
 
    private InterSeleccionProductoEntrada vista;
    private Frm_Ctrl_Inventario controladorInventario;
    
    
    public Frm_Ctrl_SeleccionProductoInventario(InterSeleccionProductoEntrada vista, Frm_Ctrl_Inventario controladorInventario) {
        this.vista = vista;
        this.controladorInventario = controladorInventario; // Guarda la referencia del controlador
        CargarTablaProductos(); // Puedes llamar a este método aquí o desde otro lugar
        init();
    }

    private void init() {
        
    
    vista.setTitle("Seleccione Producto");
        vista.setSize(new Dimension(771, 540));
        vista.setLocation(460,80);
        vista.setVisible(true);
        
        Main.desktopPane.add(vista);
        vista.toFront();
        
        
        vista.jbtnConfirmar.addActionListener(e -> jbtnConfirmarActionPerformed(e));
        vista.jbtnCancelar.addActionListener(e -> jbtnCancelarActionPerformed(e));
        
        
        
    }
    
    private void jbtnConfirmarActionPerformed(java.awt.event.ActionEvent evt){
        
    int filaSeleccionada = vista.jtblProductos.getSelectedRow();
    if (filaSeleccionada >= 0) { // Verifica que haya una fila seleccionada
        // Obtiene el ID del producto seleccionado
        int idProductoSeleccionado = (int) vista.jtblProductos.getValueAt(filaSeleccionada, 0);
      
        // Ahora puedes obtener los detalles del producto usando el ID
        controladorInventario.obtenerDetallesProducto(idProductoSeleccionado); // Usar la referencia del controlador
        
        // Cierra la ventana de selección
        vista.dispose();
    } else {
        JOptionPane.showMessageDialog(vista, "Por favor, selecciona un producto.");
    }
    
    }
    
    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent etv){
    
    vista.dispose();
    
    }
    
    
    private void CargarTablaProductos() {
    Connection con = Conexion.conectar();
    DefaultTableModel model = new DefaultTableModel();

    // Consulta SQL para obtener los datos de tb_producto filtrando por estado "1"
    String sql = "SELECT p.idProducto, p.nombre AS productoNombre, c.nombreCategoria, "
            + "pr.razonSocial AS proveedorNombre, p.cantidad_actual, i.imagen "
            + "FROM tb_producto p "
            + "JOIN tb_categoria c ON p.idCategoria = c.idCategoria "
            + "JOIN tb_proveedor pr ON p.idProveedor = pr.idProveedor "
            + "LEFT JOIN Imagenes i ON p.idImagen = i.idImagen "
            + "WHERE p.estado = 1 "  // Filtrar por estado "1"
            + "ORDER BY p.idProducto ASC;";  // Ordenar por idProducto de forma ascendente

    try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        // Establecer el modelo de la tabla
        vista.jtblProductos.setModel(model);
        model.addColumn("ID Producto");
        model.addColumn("Nombre");
        model.addColumn("Categoría");
        model.addColumn("Proveedor");
        model.addColumn("Cantidad Actual");
        model.addColumn("Imagen");

        while (rs.next()) {
            Object[] fila = new Object[6];
            fila[0] = rs.getInt("idProducto");
            fila[1] = rs.getString("productoNombre");
            fila[2] = rs.getString("nombreCategoria");
            fila[3] = rs.getString("proveedorNombre");
            fila[4] = rs.getInt("cantidad_actual");

            byte[] imagenBlob = rs.getBytes("imagen");
            fila[5] = (imagenBlob != null) ? new ImageIcon(imagenBlob) : null;

            model.addRow(fila);
        }

        con.close();
        vista.jtblProductos.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
        vista.jtblProductos.setRowHeight(80);

    } catch (SQLException e) {
        System.out.println("Error al llenar la tabla productos: " + e);
    }
}



}
