package controlador;


import java.sql.Blob;
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



public class Frm_Ctrl_Salida {
     
 
    InterSalidas vista;

   
    private InterSeleccionProductoEntrada interSeleccionProductoSalida;
    private InterPendiente interPendiente;

    public Frm_Ctrl_Salida() {
    }

    public Frm_Ctrl_Salida(InterSalidas vista) {

        this.vista = vista;
        init();

    }

    private void init() {
        
        
        vista.setTitle("Registro de Salidas");
        vista.setSize(new Dimension(1580, 850));
        vista.setLocation(0,0);
        vista.setVisible(true);
        
        cargarIdSalida();
        CargarTablaSalidas(vista.jtblSalida);
        
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
       
        
        
        
        vista.jbtnRegistrar.addActionListener(e -> jbtnRegistrarActionPerformed(e));
        vista.jbtnBuscar.addActionListener(e -> jbtnBuscarActionPerformed(e));
        vista.jbtnPendiente.addActionListener(e -> jbtnPendienteActionPerformed(e));
        vista.jbtnBuscarProducto.addActionListener(e -> jbtnBuscarProductoActionPerformed(e));
        

        
    }
    
        private void jbtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
    // Variables para almacenar los valores de los campos de entrada
    String motivo = vista.jcbxMotivo.getSelectedItem().toString();
    String documento = vista.jtxtDocumento.getText();
    String destinatario = vista.jtxtDestinatario.getText();
    String idProductoText = vista.jtxtIdProducto.getText();
    String idCategoriaText = vista.jtxtIdCategoria.getText();
    String idProveedorText = vista.jtxtIdProveedor.getText();
    java.util.Date fechaUtil = vista.jtxtFecha.getDate();
    String cantidadText = vista.jtxtCantidad.getText();
    String precioUnitarioText = vista.jtxtPrecioUnitario.getText();
    String obs = vista.jtxtObs.getText();

    // Validar que no haya campos vacíos
    if (motivo.trim().isEmpty() || motivo.equals("Seleccionar Motivo")) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un motivo válido.");
        return;
    }
    if (documento.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo 'Documento' está vacío.");
        return;
    }
    if (destinatario.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo 'Destinatario' está vacío.");
        return;
    }
    if (idProductoText.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo 'ID Producto' está vacío.");
        return;
    }
    if (idCategoriaText.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo 'ID Categoría' está vacío.");
        return;
    }
    if (idProveedorText.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo 'ID Proveedor' está vacío.");
        return;
    }
    if (fechaUtil == null) {
        JOptionPane.showMessageDialog(null, "El campo 'Fecha' está vacío.");
        return;
    }
    if (cantidadText.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo 'Cantidad' está vacío.");
        return;
    }
    if (precioUnitarioText.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo 'Precio Unitario' está vacío.");
        return;
    }

    // Convertir los valores numéricos una vez que se han validado
    int idProducto, idCategoria, idProveedor, cantidad;
    double precioUnitario;

    try {
        idProducto = Integer.parseInt(idProductoText);
        idCategoria = Integer.parseInt(idCategoriaText);
        idProveedor = Integer.parseInt(idProveedorText);
        cantidad = Integer.parseInt(cantidadText);
        precioUnitario = Double.parseDouble(precioUnitarioText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Por favor, asegúrese de que los campos numéricos sean válidos.");
        return;
    }


      // Validar que la cantidad sea mayor 
    if (cantidad <= 0) {
        JOptionPane.showMessageDialog(null, "La cantidad no puede ser negativa o igual a 0.");
        return;
    }

    java.sql.Date fecha = new java.sql.Date(fechaUtil.getTime());
    double total = cantidad * precioUnitario;
    int estado = 1;  // Estado por defecto: Activo (1)
    int confirmado = 0;  // Confirmado por defecto: No recibido (0)

    // Validar que el producto, proveedor y categoría están relacionados correctamente
    Connection con = Conexion.conectar();
    String sqlValidacion = "SELECT COUNT(*) FROM tb_producto WHERE idProducto = ? AND idCategoria = ? AND idProveedor = ?";

    try {
        PreparedStatement psValidacion = con.prepareStatement(sqlValidacion);
        psValidacion.setInt(1, idProducto);
        psValidacion.setInt(2, idCategoria);
        psValidacion.setInt(3, idProveedor);

        ResultSet rsValidacion = psValidacion.executeQuery();
        if (rsValidacion.next() && rsValidacion.getInt(1) > 0) {
            // Consultar la cantidad actual del producto
            String sqlStock = "SELECT cantidad_actual FROM tb_producto WHERE idProducto = ?";
            PreparedStatement psStock = con.prepareStatement(sqlStock);
            psStock.setInt(1, idProducto);

            ResultSet rsStock = psStock.executeQuery();
            if (rsStock.next()) {
                int cantidadActual = rsStock.getInt("cantidad_actual");

                // Validar que la cantidad a salir no exceda el stock disponible
                if (cantidad > cantidadActual) {
                    JOptionPane.showMessageDialog(null, "La cantidad solicitada supera el stock disponible. Actualmente hay " + cantidadActual + " unidades en inventario.");
                    return;
                }

                // Si la validación es correcta, proceder a la inserción
                String sqlInsercion = "INSERT INTO tb_salidas_pendientes "
                        + "(motivo, documento, destinatario, idProducto, idCategoria, idProveedor, fecha, cantidad, precio_unitario, total, obs, estado, confirmado) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement psInsercion = con.prepareStatement(sqlInsercion);
                psInsercion.setString(1, motivo);
                psInsercion.setString(2, documento);
                psInsercion.setString(3, destinatario);
                psInsercion.setInt(4, idProducto);
                psInsercion.setInt(5, idCategoria);
                psInsercion.setInt(6, idProveedor);
                psInsercion.setDate(7, fecha);
                psInsercion.setInt(8, cantidad);
                psInsercion.setDouble(9, precioUnitario);
                psInsercion.setDouble(10, total);
                psInsercion.setString(11, obs);
                psInsercion.setInt(12, estado);
                psInsercion.setInt(13, confirmado);

                // Ejecutar la inserción
                int result = psInsercion.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Confirmar Salida.");
                    limpiar();  // Limpia los campos después de la inserción
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar la Salida.");
                }

                psInsercion.close();
            }

            rsStock.close();
            psStock.close();
        } else {
            // Si la validación falla, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "El producto no está relacionado correctamente con el proveedor y/o categoría.");
        }

        // Cerrar recursos
        rsValidacion.close();
        psValidacion.close();
        con.close();
    } catch (SQLException e) {
        System.out.println("Error al registrar salida pendiente: " + e);
    }
}

      
       private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) { 
          
      
           
      }
       
       
       
        private void jbtnPendienteActionPerformed(java.awt.event.ActionEvent evt) { 
            
             // Comprueba si interSeleccionProductoEntrada es nulo o está cerrada
        if (interPendiente == null || interPendiente.isClosed()) {
            // No existe una instancia previa o está cerrada, crea una nueva
            interPendiente = new InterPendiente();

            // Crea la instancia del controlador y pásale la vista
            Frm_Ctrl_PendienteSalida frm_Ctrl_PendienteSalida = new Frm_Ctrl_PendienteSalida(interPendiente, this);

          

        } else {
            // Ya existe una instancia, colócala al frente
            try {
                interPendiente.setSelected(true); // Intenta seleccionar la ventana existente
            } catch (PropertyVetoException e) {
                e.printStackTrace(); // Maneja excepciones si la ventana no se puede seleccionar
            }
            interPendiente.toFront(); // Lleva la vista al frente
        }
      
     
        }
        
    
   private void jbtnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {
        // Comprueba si interSeleccionProductoEntrada es nulo o está cerrada
        if (interSeleccionProductoSalida == null || interSeleccionProductoSalida.isClosed()) {
            // No existe una instancia previa o está cerrada, crea una nueva
            interSeleccionProductoSalida = new InterSeleccionProductoEntrada();

            // Crea la instancia del controlador y pásale la vista
            Frm_Ctrl_SeleccionProductoSalida frm_Ctrl_SeleccionProductoSalida = new Frm_Ctrl_SeleccionProductoSalida(interSeleccionProductoSalida, this);

          

        } else {
            // Ya existe una instancia, colócala al frente
            try {
                interSeleccionProductoSalida.setSelected(true); // Intenta seleccionar la ventana existente
            } catch (PropertyVetoException e) {
                e.printStackTrace(); // Maneja excepciones si la ventana no se puede seleccionar
            }
            interSeleccionProductoSalida.toFront(); // Lleva la vista al frente
        }
    }

  public void CargarTablaSalidas(JTable jtblSalida) {
    Connection con = Conexion.conectar();  // Conexión a la base de datos
    DefaultTableModel model = new DefaultTableModel();

    // Consulta SQL para obtener los datos de tb_salidas con estado 1, ordenados por idSalidas
    String sql = "SELECT s.idSalidas, s.motivo, s.documento, s.destinatario, "
            + "p.nombre AS productoNombre, c.nombreCategoria, pr.razonSocial AS proveedorNombre, "
            + "s.fecha, s.cantidad, s.precio_unitario, s.total, s.obs "
            + "FROM tb_salidas s "
            + "JOIN tb_producto p ON s.idProducto = p.idProducto "
            + "JOIN tb_categoria c ON s.idCategoria = c.idCategoria "
            + "JOIN tb_proveedor pr ON s.idProveedor = pr.idProveedor "
            + "WHERE s.estado = 1 "  // Mostrar solo las salidas con estado = 1
            + "ORDER BY s.idSalidas ASC;";  // Ordenar por idSalidas de forma ascendente

    try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        // Establecer el modelo de la tabla
        jtblSalida.setModel(model);
        model.addColumn("ID");
        model.addColumn("Motivo");
        model.addColumn("Documento");
        model.addColumn("Destinatario");
        model.addColumn("Producto");
        model.addColumn("Categoría");
        model.addColumn("Destinatario");
        model.addColumn("Fecha");
        model.addColumn("Cantidad");
        model.addColumn("Precio Unitario");
        model.addColumn("Total");  // Total
        model.addColumn("Obs.");   // Observaciones

        // Iterar sobre los resultados de la consulta y agregarlos a la tabla
        while (rs.next()) {
            Object[] fila = new Object[12];  // Cambiar a 12 elementos para incluir todas las columnas
            fila[0] = rs.getInt("idSalidas");  // ID de salida
            fila[1] = rs.getString("motivo");   // Motivo
            fila[2] = rs.getString("documento");  // Documento
            fila[3] = rs.getString("destinatario");  // Destinatario
            fila[4] = rs.getString("productoNombre");  // Nombre del producto
            fila[5] = rs.getString("nombreCategoria");  // Nombre de la categoría
            fila[6] = rs.getString("proveedorNombre");  // Nombre del proveedor
            fila[7] = rs.getDate("fecha");   // Fecha
            fila[8] = rs.getInt("cantidad");  // Cantidad
            fila[9] = rs.getDouble("precio_unitario");  // Precio unitario
            fila[10] = rs.getDouble("total");  // Total
            fila[11] = rs.getString("obs");   // Observaciones

            model.addRow(fila);
        }

        con.close();

    } catch (SQLException e) {
        System.out.println("Error al llenar la tabla de salidas: " + e);
    }
}
    
    void obtenerDetallesProducto(int idProducto) {
    Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement pstImagen = null; // Preparar para la consulta de imagen
    ResultSet rs = null;
    ResultSet rsImagen = null;

    try {
        // Conexión a la base de datos
        con = Conexion.conectar();

        // Consulta principal para obtener detalles del producto
        String sql = "SELECT p.nombre, p.idCategoria, p.idProveedor, p.idImagen, c.nombreCategoria AS nombreCategoria, "
                + "pr.razonSocial AS nombreProveedor, p.precioVenta "
                + "FROM tb_producto p "
                + "JOIN tb_categoria c ON p.idCategoria = c.idCategoria "
                + "JOIN tb_proveedor pr ON p.idProveedor = pr.idProveedor "
                + "WHERE p.idProducto = ?";

        pst = con.prepareStatement(sql);
        pst.setInt(1, idProducto);  // Asignación del parámetro

        rs = pst.executeQuery();

        if (rs.next()) {
            // Rellena los campos en InterSalidas
            vista.jtxtIdProducto.setText(String.valueOf(idProducto));
            vista.jtxtNombreProducto.setText(rs.getString("nombre"));
            vista.jtxtIdCategoria.setText(String.valueOf(rs.getInt("idCategoria")));
            vista.jtxtNombreCategoria.setText(rs.getString("nombreCategoria"));
            vista.jtxtIdProveedor.setText(String.valueOf(rs.getInt("idProveedor")));
            vista.jtxtNombreProveedor.setText(rs.getString("nombreProveedor"));
            vista.jtxtPrecioUnitario.setText(String.valueOf(rs.getDouble("precioVenta"))); // Rellenar el precio de venta

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

    
    
    public void transportarDatosASalidas(int idPendienteSalida) {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
        con = Conexion.conectar(); // Conexión a la base de datos
        
        // Consulta para obtener los datos del pendiente seleccionado
        String sqlSelect = "SELECT motivo, documento, destinatario, idProducto, idCategoria, idProveedor, fecha, cantidad, precio_unitario, total, obs, estado "
                         + "FROM tb_salidas_pendientes WHERE idPendienteSalida = ?";
        pst = con.prepareStatement(sqlSelect);
        pst.setInt(1, idPendienteSalida);  // Asignación del parámetro

        rs = pst.executeQuery();

        if (rs.next()) {
            // Prepara la inserción en la tabla tb_salidas
            String sqlInsert = "INSERT INTO tb_salidas (motivo, documento, destinatario, idProducto, idCategoria, idProveedor, fecha, cantidad, precio_unitario, total, obs, estado) "
                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
            pst = con.prepareStatement(sqlInsert);
            pst.setString(1, rs.getString("motivo"));
            pst.setString(2, rs.getString("documento"));
            pst.setString(3, rs.getString("destinatario"));
            pst.setInt(4, rs.getInt("idProducto"));
            pst.setInt(5, rs.getInt("idCategoria"));
            pst.setInt(6, rs.getInt("idProveedor"));
            pst.setDate(7, rs.getDate("fecha"));
            pst.setInt(8, rs.getInt("cantidad"));
            pst.setDouble(9, rs.getDouble("precio_unitario"));
            pst.setDouble(10, rs.getDouble("total"));
            pst.setString(11, rs.getString("obs"));
            pst.setInt(12, rs.getInt("estado"));

            // Ejecuta la inserción
            pst.executeUpdate();
            
            
            cargarIdSalida();
            CargarTablaSalidas(vista.jtblSalida);
            
            
            
        } else {
            JOptionPane.showMessageDialog(vista, "No se encontraron datos para el ID de pendiente: " + idPendienteSalida);
        }

    } catch (SQLException ex) {
        System.out.println("Error al transportar los datos a la tabla de salidas: " + ex.getMessage());
        ex.printStackTrace(); // Imprimir traza de error
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
}
    
    private void cargarIdSalida() {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    try {
        // Conexión a la base de datos
        con = Conexion.conectar();
        
        // Consulta para obtener el último idSalidas
        String sql = "SELECT COALESCE(MAX(idSalidas), 0) FROM tb_salidas";
        pst = con.prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        if (rs.next()) {
            int ultimoId = rs.getInt(1); // Obtener el valor de idSalidas
            
            // Si no hay registros, inicializar en 0000, de lo contrario incrementar el valor
            String nuevoIdSalida = String.format("%04d", ultimoId + 1); // Formatea con 4 dígitos
            
            // Mostrar el nuevo ID en el campo jtxtEntrada
            vista.jtxtSalida.setText(nuevoIdSalida);
        }
        
    } catch (SQLException ex) {
        System.out.println("Error al obtener el último idSalida: " + ex.getMessage());
    } finally {
        try {
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
    vista.jtxtDocumento.setText("");
    vista.jtxtDestinatario.setText("");
    vista.jtxtIdProducto.setText("");
    vista.jtxtNombreProducto.setText("");
    vista.jtxtIdCategoria.setText("");
    vista.jtxtNombreCategoria.setText("");
    vista.jtxtIdProveedor.setText("");
    vista.jtxtNombreProveedor.setText("");
    vista.jtxtCantidad.setText("");
    vista.jtxtPrecioUnitario.setText("");
    vista.jtxtObs.setText("");

    // Limpiar el campo de selección del motivo (JComboBox)
    vista.jcbxMotivo.setSelectedIndex(0);  // Selecciona el primer elemento (o uno vacío)

    // Limpiar el campo de fecha (JDateChooser)
    vista.jtxtFecha.setDate(null);  // Establece la fecha en nulo para vaciar el campo
}

}
