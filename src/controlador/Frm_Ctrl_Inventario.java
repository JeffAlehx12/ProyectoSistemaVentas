package controlador;


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
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import vista.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import modelo.Imagen;
import modelo.Producto;



public class Frm_Ctrl_Inventario {
     
 
    InterInventario vista;

    private int idProducto;
    private InterSeleccionProductoEntrada interSeleccionProductoEntrada;
    private InterPendiente interPendiente;

    public Frm_Ctrl_Inventario() {
    }

    public Frm_Ctrl_Inventario(InterInventario vista) {

        this.vista = vista;
        init();

    }

    private void init() {
        
        
        vista.setTitle("Registro Inventario");
        vista.setSize(new Dimension(1580, 850));
        vista.setLocation(0,0);
        vista.setVisible(true);
        
       
        CargarTablaInventario(vista.jtblInventario);
        
        // Evitar que se pueda mover el JInternalFrame
        vista.setResizable(false);  // Deshabilita el redimensionamiento
        vista.setClosable(false);   // Deshabilita la opción de cerrar
        vista.setMaximizable(false); // Deshabilita la opción de maximizar
        vista.setIconifiable(false); // Deshabilita la opción de minimizar

        // Eliminar la barra de título y los botones de control (Cerrar, Minimizar, Maximizar)
        JInternalFrame jif = vista;
        ((BasicInternalFrameUI) jif.getUI()).setNorthPane(null); // Quita la barra de título

// Quitar el borde adicional alrededor del contenido
        jif.setBorder(BorderFactory.createEmptyBorder());  // Elimina el borde de todo el JInternalFrame

// Fuerza a que se dibuje correctamente el contenido
        jif.revalidate();
        jif.repaint();
        
        vista.toFront();
        
        
        
    
        //CargarComboProveedores();
       
        
        
        
       
        vista.jbtnBuscar.addActionListener(e -> jbtnBuscarActionPerformed(e));
        vista.jbtnBuscarProducto.addActionListener(e -> jbtnBuscarProductoActionPerformed(e));
        

        
    }
    
        private void jbtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {

        }
      
       private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) { 
          
      
           
      }
       
       
       
     
       
        
    
   private void jbtnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {
        // Comprueba si interSeleccionProductoEntrada es nulo o está cerrada
        if (interSeleccionProductoEntrada == null || interSeleccionProductoEntrada.isClosed()) {
            // No existe una instancia previa o está cerrada, crea una nueva
            interSeleccionProductoEntrada = new InterSeleccionProductoEntrada();
        
            // Crea la instancia del controlador y pásale la vista
            Frm_Ctrl_SeleccionProductoInventario frm_Ctrl_SeleccionProductoInventario = new Frm_Ctrl_SeleccionProductoInventario(interSeleccionProductoEntrada, this);
       
          

        } else {
            // Ya existe una instancia, colócala al frente
            try {
                interSeleccionProductoEntrada.setSelected(true); // Intenta seleccionar la ventana existente
            } catch (PropertyVetoException e) {
                e.printStackTrace(); // Maneja excepciones si la ventana no se puede seleccionar
        }
            interSeleccionProductoEntrada.toFront(); // Lleva la vista al frente
   }
    }
       
    

   
   
 public void CargarTablaInventario(JTable jtblInventario) {
    Connection con = Conexion.conectar();  // Conexión a la base de datos
    DefaultTableModel model = new DefaultTableModel();

    // Consulta SQL para obtener los datos de tb_inventario
    String sql = "SELECT i.idInventario, p.nombre AS productoNombre, c.nombreCategoria, "
            + "pr.razonSocial, "  // No hay alias, usar razonSocial directamente
            + "i.entradas, i.salidas, i.stock_disponible, i.obs, i.estado "
            + "FROM tb_inventario i "
            + "LEFT JOIN tb_producto p ON i.idProducto = p.idProducto "
            + "LEFT JOIN tb_categoria c ON i.idCategoria = c.idCategoria "
            + "LEFT JOIN tb_proveedor pr ON i.idProveedor = pr.idProveedor "
            + "WHERE i.estado = 1 "  // Mostrar solo los inventarios con estado = 1
            + "ORDER BY i.idInventario ASC;";  // Ordenar por idInventario de forma ascendente

    try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        // Establecer el modelo de la tabla
        jtblInventario.setModel(model);
        model.addColumn("ID");
        model.addColumn("Producto");
        model.addColumn("Categoría");
        model.addColumn("Proveedor"); // Columna para proveedor
        model.addColumn("Entradas");
        model.addColumn("Salidas");
        model.addColumn("Stock Disponible");
        model.addColumn("Obs.");   // Observaciones
        

        // Iterar sobre los resultados de la consulta y agregarlos a la tabla
        while (rs.next()) {
            Object[] fila = new Object[9];  // Cambiar a 9 elementos para incluir todas las columnas
            fila[0] = rs.getInt("idInventario");  // ID de inventario
            fila[1] = rs.getString("productoNombre");   // Nombre del producto
            fila[2] = rs.getString("nombreCategoria");  // Nombre de la categoría
            fila[3] = rs.getString("razonSocial"); // Aquí usamos razonSocial directamente
            fila[4] = rs.getInt("entradas");  // Entradas
            fila[5] = rs.getInt("salidas");  // Salidas
            fila[6] = rs.getInt("stock_disponible");  // Stock disponible
            fila[7] = rs.getString("obs");   // Observaciones
            fila[8] = rs.getInt("estado");   // Estado

            model.addRow(fila);
        }

        con.close();

    } catch (SQLException e) {
        System.out.println("Error al llenar la tabla de inventario: " + e);
    }
}
    
    void obtenerDetallesProducto(int idProducto) {
    Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement pstImagen = null; // Preparar para la consulta de imagen
    ResultSet rs = null;
    ResultSet rsImagen = null;

    try {
        con = Conexion.conectar(); // Conexión a la base de datos
        
        // Consulta principal para obtener detalles del producto
        String sql = "SELECT p.nombre, p.idCategoria, p.idProveedor, p.idImagen, c.nombreCategoria AS nombreCategoria, "
                   + "pr.razonSocial AS nombreProveedor, p.precioCosto "
                   + "FROM tb_producto p "
                   + "JOIN tb_categoria c ON p.idCategoria = c.idCategoria "
                   + "JOIN tb_proveedor pr ON p.idProveedor = pr.idProveedor "
                   + "WHERE p.idProducto = ?";

        pst = con.prepareStatement(sql);
        pst.setInt(1, idProducto);  // Asignación del parámetro
        rs = pst.executeQuery();

        if (rs.next()) {
            // Rellena los campos en la vista (InterEntradas)
            vista.jtxtIdProducto.setText(String.valueOf(idProducto));
            vista.jtxtNombreProducto.setText(rs.getString("nombre"));
            vista.jtxtIdCategoria.setText(String.valueOf(rs.getInt("idCategoria")));
            vista.jtxtNombreCategoria.setText(rs.getString("nombreCategoria"));
            vista.jtxtIdProveedor.setText(String.valueOf(rs.getInt("idProveedor")));
            vista.jtxtNombreProveedor.setText(rs.getString("nombreProveedor"));

            // Obtener el ID de la imagen
            int idImagen = rs.getInt("idImagen");
            if (idImagen != 0) {  // Asegurarse de que hay una imagen asignada
                // Consulta para obtener la imagen
                String sqlImagen = "SELECT imagen FROM Imagenes WHERE idImagen = ?";
                pstImagen = con.prepareStatement(sqlImagen);
                pstImagen.setInt(1, idImagen);

                rsImagen = pstImagen.executeQuery();
                if (rsImagen.next()) {
                    Blob blob = rsImagen.getBlob("imagen");
                    if (blob != null) {  // Verificar que el blob no sea null
                        InputStream is = blob.getBinaryStream();
                        BufferedImage bufferedImage = ImageIO.read(is);
                        ImageIcon imageIcon = new ImageIcon(bufferedImage);
                        // Ajusta la imagen al tamaño del JLabel si es necesario
                        Image image = imageIcon.getImage().getScaledInstance(
                                vista.jlbImg.getWidth(), vista.jlbImg.getHeight(), Image.SCALE_SMOOTH);
                        vista.jlbImg.setIcon(new ImageIcon(image));
                    } else {
                        // Si no hay imagen, limpiar el JLabel o asignar una imagen por defecto
                        vista.jlbImg.setIcon(null);  // O colocar una imagen predeterminada
                    }
                }
            } else {
                // Si no hay ID de imagen asociado, limpiar el JLabel o asignar una imagen predeterminada
                vista.jlbImg.setIcon(null);  // O colocar una imagen predeterminada
            }

        } else {
            System.out.println("No se encontraron detalles para el ID de producto: " + idProducto);
        }

    } catch (SQLException | IOException ex) {
        System.out.println("Error al obtener detalles del producto: " + ex.getMessage());
        ex.printStackTrace(); // Imprimir traza de error
    } finally {
        // Cierre de recursos en orden inverso a su apertura
        try {
            if (rsImagen != null) rsImagen.close();
            if (pstImagen != null) pstImagen.close();
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
}
    
    
    private void limpiar() {
    // Limpiar los campos de texto
    vista.jtxtIdProducto.setText("");
    vista.jtxtNombreProducto.setText("");
    vista.jtxtIdCategoria.setText("");
    vista.jtxtNombreCategoria.setText("");
    vista.jtxtIdProveedor.setText("");
    

}

}
