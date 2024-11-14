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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Imagen;
import modelo.Producto;



public class Frm_Ctrl_Entrada {
     
 
    InterEntradas vista;

    private int idProducto;
    private InterSeleccionProductoEntrada interSeleccionProductoEntrada;
    private InterPendiente interPendiente;

    public Frm_Ctrl_Entrada() {
    }

    public Frm_Ctrl_Entrada(InterEntradas vista) {

        this.vista = vista;
        init();

    }

    private void init() {
        
        
        vista.setTitle("Registro de Entradas");
        vista.setSize(new Dimension(1389, 714));
        vista.setLocation(400,20);
        vista.setVisible(true);
        
        cargarIdEntrada();
        CargarTablaEntradas(vista.jtblEntrada);
        
        FromMenu.desktopPane.add(vista);
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
    String idProductoText = vista.jtxtIdProducto.getText();
    String idCategoriaText = vista.jtxtIdCategoria.getText();
    String idProveedorText = vista.jtxtIdProveedor.getText();
    java.util.Date fechaUtil = vista.jtxtFecha.getDate();
    String cantidadText = vista.jtxtCantidad.getText();
    String precioCostoText = vista.jtxtPrecioCosto.getText();
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
    if (precioCostoText.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo 'Precio Costo' está vacío.");
        return;
    }

    // Convertir los valores numéricos una vez que se han validado
    int idProducto, idCategoria, idProveedor, cantidad;
    double precioCosto;

    try {
        idProducto = Integer.parseInt(idProductoText);
        idCategoria = Integer.parseInt(idCategoriaText);
        idProveedor = Integer.parseInt(idProveedorText);
        cantidad = Integer.parseInt(cantidadText);
        precioCosto = Double.parseDouble(precioCostoText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Por favor, asegúrese de que los campos numéricos sean válidos.");
        return;
    }

    // Validar que la cantidad no sea negativa
    if (cantidad <= 0) {
        JOptionPane.showMessageDialog(null, "La cantidad no puede ser negativa o igual a 0.");
        return;
    }

    java.sql.Date fecha = new java.sql.Date(fechaUtil.getTime());
    double total = cantidad * precioCosto;
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
            // Si la validación es correcta, proceder a la inserción
            String sqlInsercion = "INSERT INTO tb_entradas_pendientes "
                    + "(motivo, documento, idProducto, idCategoria, idProveedor, fecha, cantidad, precioCosto, total, obs, estado, confirmado) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement psInsercion = con.prepareStatement(sqlInsercion);
            psInsercion.setString(1, motivo);
            psInsercion.setString(2, documento);
            psInsercion.setInt(3, idProducto);
            psInsercion.setInt(4, idCategoria);
            psInsercion.setInt(5, idProveedor);
            psInsercion.setDate(6, fecha);
            psInsercion.setInt(7, cantidad);
            psInsercion.setDouble(8, precioCosto);
            psInsercion.setDouble(9, total);
            psInsercion.setString(10, obs);
            psInsercion.setInt(11, estado);
            psInsercion.setInt(12, confirmado);

            // Ejecutar la inserción
            int result = psInsercion.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Confirmar Entrega.");
                limpiar();  // Limpia los campos después de la inserción
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar la entrada.");
            }

            psInsercion.close();
        } else {
            // Si la validación falla, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "El producto no está relacionado correctamente con el proveedor y/o categoría.");
        }

        // Cerrar recursos
        rsValidacion.close();
        psValidacion.close();
        con.close();
    } catch (SQLException e) {
        System.out.println("Error al registrar entrada pendiente: " + e);
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
            Frm_Ctrl_PendienteEntrada frm_Ctrl_PendienteEntrada = new Frm_Ctrl_PendienteEntrada(interPendiente, this);

          

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
        if (interSeleccionProductoEntrada == null || interSeleccionProductoEntrada.isClosed()) {
            // No existe una instancia previa o está cerrada, crea una nueva
            interSeleccionProductoEntrada = new InterSeleccionProductoEntrada();

            // Crea la instancia del controlador y pásale la vista
            Frm_Ctrl_SeleccionProductoEntrada frm_Ctrl_SeleccionProductoEntrada = new Frm_Ctrl_SeleccionProductoEntrada(interSeleccionProductoEntrada, this);

          

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

   public void CargarTablaEntradas(JTable jtblEntrada) {
    Connection con = Conexion.conectar();  // Conexión a la base de datos
    DefaultTableModel model = new DefaultTableModel();

    // Consulta SQL para obtener los datos de tb_entradas con estado 1, ordenados por idEntradas
    String sql = "SELECT e.idEntradas, e.motivo, e.documento, p.nombre AS productoNombre, "
            + "c.nombreCategoria, pr.razonSocial AS proveedorNombre, e.fecha, e.cantidad, "
            + "e.precioCosto, e.obs, e.total "
            + "FROM tb_entradas e "
            + "JOIN tb_producto p ON e.idProducto = p.idProducto "
            + "JOIN tb_categoria c ON e.idCategoria = c.idCategoria "
            + "JOIN tb_proveedor pr ON e.idProveedor = pr.idProveedor "
            + "WHERE e.estado = 1 "  // Mostrar solo las entradas con estado = 1
            + "ORDER BY e.idEntradas ASC;";  // Ordenar por idEntradas de forma ascendente

    try {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        // Establecer el modelo de la tabla
        jtblEntrada.setModel(model);
        model.addColumn("ID");
        model.addColumn("Motivo");
        model.addColumn("Documento");
        model.addColumn("Producto");
        model.addColumn("Categoría");
        model.addColumn("Proveedor");
        model.addColumn("Fecha");
        model.addColumn("Cantidad");
        model.addColumn("Precio Costo");
        model.addColumn("Total");  // Total
        model.addColumn("Obs.");   // Observaciones

        // Iterar sobre los resultados de la consulta y agregarlos a la tabla
        while (rs.next()) {
            Object[] fila = new Object[11];  // Cambiar a 11 elementos ya que no tenemos 'estado'
            fila[0] = rs.getInt("idEntradas");  // ID de entrada
            fila[1] = rs.getString("motivo");   // Motivo
            fila[2] = rs.getString("documento");  // Documento
            fila[3] = rs.getString("productoNombre");  // Nombre del producto
            fila[4] = rs.getString("nombreCategoria");  // Nombre de la categoría
            fila[5] = rs.getString("proveedorNombre");  // Nombre del proveedor
            fila[6] = rs.getDate("fecha");   // Fecha
            fila[7] = rs.getInt("cantidad");  // Cantidad
            fila[8] = rs.getDouble("precioCosto");  // Precio de costo
            fila[9] = rs.getDouble("total");  // Total
            fila[10] = rs.getString("obs");   // Observaciones

            model.addRow(fila);
        }

        con.close();

    } catch (SQLException e) {
        System.out.println("Error al llenar la tabla de entradas: " + e);
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
                + "pr.razonSocial AS nombreProveedor, p.precioCosto "
                + "FROM tb_producto p "
                + "JOIN tb_categoria c ON p.idCategoria = c.idCategoria "
                + "JOIN tb_proveedor pr ON p.idProveedor = pr.idProveedor "
                + "WHERE p.idProducto = ?";

        pst = con.prepareStatement(sql);
        pst.setInt(1, idProducto);  // Asignación del parámetro

        rs = pst.executeQuery();

        if (rs.next()) {
            // Rellena los campos en InterEntradas
            vista.jtxtIdProducto.setText(String.valueOf(idProducto));
            vista.jtxtNombreProducto.setText(rs.getString("nombre"));
            vista.jtxtIdCategoria.setText(String.valueOf(rs.getInt("idCategoria")));
            vista.jtxtNombreCategoria.setText(rs.getString("nombreCategoria"));
            vista.jtxtIdProveedor.setText(String.valueOf(rs.getInt("idProveedor")));
            vista.jtxtNombreProveedor.setText(rs.getString("nombreProveedor"));
            vista.jtxtPrecioCosto.setText(String.valueOf(rs.getDouble("precioCosto"))); // Rellenar el precio costo

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
    
    
    public void transportarDatosAEntradas(int idPendienteEntrada) {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    try {
        con = Conexion.conectar(); // Conexión a la base de datos
        
        // Consulta para obtener los datos del pendiente seleccionado
        String sqlSelect = "SELECT motivo, documento, idProducto, idCategoria, idProveedor, fecha, cantidad, precioCosto, total, obs, estado "
                         + "FROM tb_entradas_pendientes WHERE idPendienteEntrada = ?";
        pst = con.prepareStatement(sqlSelect);
        pst.setInt(1, idPendienteEntrada);  // Asignación del parámetro

        rs = pst.executeQuery();

        if (rs.next()) {
            // Prepara la inserción en la tabla tb_entradas
            String sqlInsert = "INSERT INTO tb_entradas (motivo, documento, idProducto, idCategoria, idProveedor, fecha, cantidad, precioCosto, total, obs, estado) "
                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sqlInsert);
            pst.setString(1, rs.getString("motivo"));
            pst.setString(2, rs.getString("documento"));
            pst.setInt(3, rs.getInt("idProducto"));
            pst.setInt(4, rs.getInt("idCategoria"));
            pst.setInt(5, rs.getInt("idProveedor"));
            pst.setDate(6, rs.getDate("fecha"));
            pst.setInt(7, rs.getInt("cantidad"));
            pst.setDouble(8, rs.getDouble("precioCosto"));
            pst.setDouble(9, rs.getDouble("total"));
            pst.setString(10, rs.getString("obs"));
            pst.setInt(11, rs.getInt("estado"));

            // Ejecuta la inserción
            pst.executeUpdate();
           
            
            cargarIdEntrada();
            CargarTablaEntradas(vista.jtblEntrada);
            
            
            
        } else {
            JOptionPane.showMessageDialog(vista, "No se encontraron datos para el ID de pendiente: " + idPendienteEntrada);
        }

    } catch (SQLException ex) {
        System.out.println("Error al transportar los datos a la tabla de entradas: " + ex.getMessage());
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
    
    private void cargarIdEntrada() {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    try {
        // Conexión a la base de datos
        con = Conexion.conectar();
        
        // Consulta para obtener el último idEntradas
        String sql = "SELECT COALESCE(MAX(idEntradas), 0) FROM tb_entradas";
        pst = con.prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        if (rs.next()) {
            int ultimoId = rs.getInt(1); // Obtener el valor de idEntradas
            
            // Si no hay registros, inicializar en 0000, de lo contrario incrementar el valor
            String nuevoIdEntrada = String.format("%04d", ultimoId + 1); // Formatea con 4 dígitos
            
            // Mostrar el nuevo ID en el campo jtxtEntrada
            vista.jtxtEntrada.setText(nuevoIdEntrada);
        }
        
    } catch (SQLException ex) {
        System.out.println("Error al obtener el último idEntrada: " + ex.getMessage());
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
    vista.jtxtIdProducto.setText("");
    vista.jtxtNombreProducto.setText("");
    vista.jtxtIdCategoria.setText("");
    vista.jtxtNombreCategoria.setText("");
    vista.jtxtIdProveedor.setText("");
    vista.jtxtNombreProveedor.setText("");
    vista.jtxtCantidad.setText("");
    vista.jtxtPrecioCosto.setText("");
    vista.jtxtObs.setText("");

    // Limpiar el campo de selección del motivo (JComboBox)
    vista.jcbxMotivo.setSelectedIndex(0);  // Selecciona el primer elemento (o uno vacío)

    // Limpiar el campo de fecha (JDateChooser)
    vista.jtxtFecha.setDate(null);  // Establece la fecha en nulo para vaciar el campo
}

}
