package controlador;

import com.itextpdf.text.log.Logger;
import com.raven.main.Main;
import conexion.Conexion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Imagen;
import modelo.Producto;



public class Ctrl_Producto {
     
 
    
     InterProducto vista;
     InterGestionarProducto i;

    public Ctrl_Producto() {}

    public Ctrl_Producto(InterProducto vista) {

        
        this.vista = vista;
        init();
        
    }

    private void init() {
        
        
        
        vista.setSize(new Dimension(1109, 622));
        vista.setTitle("Nuevo Producto");
        vista.setVisible(true);  
        vista.setLocation(150, 40);
        
        Main.desktopPane.add(vista);
        
        
        
        
        
        
        
        vista.toFront();
        
        
        
        CargarComboCategorias();
        CargarComboProveedores();
       
        
        
        vista.jbtnRegresar.addActionListener(e -> jbtnRegresarActionPerformed(e));
        vista.jbtnGuardar.addActionListener(e -> jButton_GuardarActionPerformed(e));
        vista.jbtnProveedor.addActionListener(e -> jbtnProveedorActionPerformed(e));
        vista.jbtnCategoria.addActionListener(e -> jbtnCategoriaActionPerformed(e));
        vista.jbtnCancelar.addActionListener(e -> jbtnCancelarActionPerformed(e));
        vista.jbtnExaminar.addActionListener(e -> jbtnExaminarActionPerformed(e));
        vista.jbtnQuitar.addActionListener(e -> jbtnQuitarActionPerformed(e));

            vista.jtxtMargenGanancia.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         jtxtMargenGananciaActionPerformed(e);
     }
 });
          
      
        
    }
    
    
    private void jtxtMargenGananciaActionPerformed(java.awt.event.ActionEvent evt) {    
        
       try {
        float costo = Float.parseFloat(vista.jtxt_precioCosto.getText());
        float margen = formatAndParseMargen(vista.jtxtMargenGanancia); // Parsea y formatea el margen
        float precioVenta = costo * (1 + margen / 100); // Asume que el margen está en porcentaje
        vista.jtxt_precioVenta.setText(String.format("%.2f", precioVenta));
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Ingrese números válidos en ambos campos.");
    }
    
        
    }
    
    private float formatAndParseMargen(JTextField field) {
    try {
        float value = Float.parseFloat(field.getText());
        field.setText(String.format("%.2f", value)); // Formatea el campo a dos decimales
        return value;
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido para el margen.");
        throw ex; // Vuelve a lanzar la excepción para manejarla en el método calcularPrecioVenta
    }
}
    
    ArrayList<Imagen> imagenes;
    String ruta,nombre;
   
    int contador=0;
    
    
    
     private void jbtnExaminarActionPerformed(java.awt.event.ActionEvent evt) {    
        
       final JFileChooser elegirImagen = new JFileChooser();
        elegirImagen.setMultiSelectionEnabled(false);
        int o = elegirImagen.showOpenDialog(vista);
        if(o == JFileChooser.APPROVE_OPTION){
            ruta = elegirImagen.getSelectedFile().getAbsolutePath();
            nombre = elegirImagen.getSelectedFile().getName();
            
            Image preview = Toolkit.getDefaultToolkit().getImage(ruta);
            if(preview != null){
                vista.jlbImg.setText("");
                ImageIcon icon = new ImageIcon(preview.getScaledInstance(vista.jlbImg.getWidth(), vista.jlbImg.getHeight(), Image.SCALE_DEFAULT));
                vista.jlbImg.setIcon(icon);
            }
        }
       
    } 
     
     
     private void jbtnQuitarActionPerformed(java.awt.event.ActionEvent evt) {    
        
            vista.jlbImg.setIcon(null);
    } 
     
     
 
     
     
    
    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {    
        
       Limpiar();
        
       vista.jtxt_nombre.requestFocus();
       
    } 
    
    private void jbtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {    
        
        vista.dispose();
        
        InterGestionarProducto interGestionarProducto = new InterGestionarProducto();
        Frm_Ctrl_GestionarProducto frm_Ctrl_GestionarProducto = new Frm_Ctrl_GestionarProducto(interGestionarProducto);
        
        
        
    } 
    
     private void jbtnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {                                              
      
         InterGestionarCategoria interGestionarCategoria = new InterGestionarCategoria();
         Frm_Ctrl_GestionarCategoriaProducto frm_Ctrl_GestionarCategoria = new Frm_Ctrl_GestionarCategoriaProducto(interGestionarCategoria);
         
         vista.dispose();
        
         
        }
    
     private void jbtnProveedorActionPerformed(java.awt.event.ActionEvent evt) {                                              
             
         InterGestionarProveedor interGestionarProveedor = new InterGestionarProveedor();
         Frm_Ctrl_GestionarProveedores frm_Ctrl_GestionarProveedores = new Frm_Ctrl_GestionarProveedores(interGestionarProveedor);
         
         
        } 
    
   private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {
    Producto producto = new Producto();
    Ctrl_Producto controladorProducto = new Ctrl_Producto();

    String igv = vista.jComboBox_igv.getSelectedItem().toString().trim();
    String categoria = vista.jComboBox_categoria.getSelectedItem().toString().trim();
    String proveedor = vista.jComboBox_proveedor.getSelectedItem().toString().trim();

    // Validar campos
    if (vista.jtxt_nombre.getText().equals("") || vista.jtxt_Cantidad_Inicial.getText().equals("") || vista.jtxt_precioCosto.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Complete todos los campos");
        vista.jtxt_nombre.setBackground(Color.red);
        vista.jtxt_Cantidad_Inicial.setBackground(Color.red);
        vista.jtxt_precioCosto.setBackground(Color.red);
    } else {
        // Consulta para ver si el producto ya existe
        if (!controladorProducto.existeProducto(vista.jtxt_nombre.getText().trim())) {
            if (igv.equalsIgnoreCase("Seleccione igv:")) {
                JOptionPane.showMessageDialog(null, "Seleccione igv:");
            } else if (categoria.equalsIgnoreCase("Seleccione categoria:")) {
                JOptionPane.showMessageDialog(null, "Seleccione categoria:");
            } else if (proveedor.equalsIgnoreCase("Seleccione proveedor:")) {
                JOptionPane.showMessageDialog(null, "Seleccione proveedor:");
            } else {
                try {
                    // Setear los valores del producto
                    producto.setNombre(vista.jtxt_nombre.getText().trim());
                    producto.setDescripcion(vista.jtxt_descripcion.getText().trim());
                    producto.setIdCategoria(IdCategoria());
                    producto.setIdProveedor(IdProveedor());
                    producto.setUbicacion(vista.jtxt_ubicacion.getText().trim());
                    producto.setCantidad_actual(Integer.parseInt(vista.jtxt_Cantidad_Inicial.getText().trim()));
                    producto.setStock_min((int) vista.jspn_stockMinimo.getValue());
                    producto.setStock_max((int) vista.jspn_StockMaximo.getValue());

                    // Precios de costo, venta, IGV y total
                    double precioCosto = Double.parseDouble(vista.jtxt_precioCosto.getText().trim().replace(",", "."));
                    double precioVenta = Double.parseDouble(vista.jtxt_precioVenta.getText().trim().replace(",", "."));
                    producto.setPrecioCosto(precioCosto);
                    producto.setPrecioVenta(precioVenta);

                    // Porcentaje Igv
                    if (igv.equalsIgnoreCase("No grava igv")) {
                        producto.setPorcentajeIgv(0);
                    } else if (igv.equalsIgnoreCase("18%")) {
                        producto.setPorcentajeIgv(18);
                    }

                    producto.setPrecio_total(calcularPrecioTotal(precioVenta, igv));
                    producto.setEstado(1);

                   
                    // Guardar el producto y la imagen
                    if (controladorProducto.guardar(producto, ruta, nombre)) {
                        JOptionPane.showMessageDialog(null, "Registro Guardado");
                        InterGestionarProducto interGestionarProducto = new InterGestionarProducto();
                        Frm_Ctrl_GestionarProducto frm_Ctrl_GestionarProducto = new Frm_Ctrl_GestionarProducto(interGestionarProducto);                
                        vista.dispose();
                        Limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Guardar");
                    }

                } catch (HeadlessException | NumberFormatException e) {
                    System.out.println("Error en: " + e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El producto ya existe en la Base de Datos");
        }
    }
}
    
   
    
    
    
    
    
    
    
    
    
    private void Limpiar(){
    
        vista.jtxt_nombre.setText("");
        vista.jtxt_descripcion.setText("");
        vista.jtxt_ubicacion.setText("");
        vista.jtxt_Cantidad_Inicial.setText("");
        vista.jspn_stockMinimo.setValue(0);
        vista.jspn_StockMaximo.setValue(0);
        vista.jtxt_precioCosto.setText("");
        vista.jtxt_precioVenta.setText("");
        vista.jComboBox_categoria.setSelectedIndex(0);
        vista.jComboBox_proveedor.setSelectedIndex(0);
        vista.jComboBox_igv.setSelectedIndex(0);
        
        
    
    }
    
    
    
    
    
    
    
    
    //metodo para cargar las categorias
    
    private int IdCategoria() {
        return obtenerId("select * from tb_categoria where nombreCategoria = '" + vista.jComboBox_categoria.getSelectedItem() + "'");
    }
    
    
    public void CargarComboCategorias() {

        Connection cn = Conexion.conectar();
        String sql = "select * from tb_categoria";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            vista.jComboBox_categoria.removeAllItems();
            vista.jComboBox_categoria.addItem("Seleccione categoria:");

            while (rs.next()) {

                vista.jComboBox_categoria.addItem(rs.getString("nombreCategoria"));

            }
            cn.close();

        } catch (Exception e) {
            System.out.println("Error al cargar categorias");
        }

    }
    
    
    
    
    private int IdProveedor() {
        return obtenerId("select * from tb_proveedor where razonSocial = '" +
                vista.jComboBox_proveedor.getSelectedItem() + "'");
    }

    
    private void CargarComboProveedores() {

        Connection cn = Conexion.conectar();
        String sql = "select * from tb_proveedor";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            vista.jComboBox_proveedor.removeAllItems();
            vista.jComboBox_proveedor.addItem("Seleccione proveedor:");

            while (rs.next()) {

                vista.jComboBox_proveedor.addItem(rs.getString("razonSocial"));

            }
            cn.close();

        } catch (Exception e) {
            System.out.println("Error al cargar categorias");
        }

    }
   
    
    
    private int obtenerId(String sql) {
        int id = -1;
        Connection cn = Conexion.conectar();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt(1); // Asumiendo que el ID es la primera columna
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener ID: " + e.getMessage());
        }
        return id;
    }
    
    
    
    
    
    
      public boolean guardar(Producto objeto, String ruta, String nombre) {
    boolean respuesta = false;
    Connection cn = null;
    PreparedStatement psProducto = null;
    PreparedStatement psImagen = null;
    PreparedStatement psEntrada = null;
    PreparedStatement psInventario = null;
    ResultSet rs = null;

    try {
        cn = Conexion.conectar();
        cn.setAutoCommit(false);  // Inicia una transacción

        int idImagen = -1;  // Inicializa idImagen como -1 o cualquier valor por defecto

        // Guardar la imagen si hay una ruta y un nombre de imagen
        if (ruta != null && !ruta.isEmpty() && nombre != null && !nombre.isEmpty()) {
            String insertImagen = "INSERT INTO Imagenes(imagen, nombre) VALUES(?, ?)";
            FileInputStream fis = new FileInputStream(new File(ruta));
            psImagen = cn.prepareStatement(insertImagen, Statement.RETURN_GENERATED_KEYS);
            psImagen.setBinaryStream(1, fis, (int) new File(ruta).length());
            psImagen.setString(2, nombre);
            psImagen.executeUpdate();

            // Recuperar el ID de la imagen recién guardada
            rs = psImagen.getGeneratedKeys();
            if (rs.next()) {
                idImagen = rs.getInt(1);  // Obtener el idImagen generado automáticamente
            }
        }

        // Guardar el producto en `tb_producto`
        String insertProducto = "INSERT INTO tb_producto (nombre, descripcion, idCategoria, idProveedor, ubicacion, cantidad_actual, stock_min, stock_max, precioCosto, precioVenta, porcentajeIgv, precio_total, idImagen, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        psProducto = cn.prepareStatement(insertProducto, Statement.RETURN_GENERATED_KEYS);
        psProducto.setString(1, objeto.getNombre());
        psProducto.setString(2, objeto.getDescripcion());
        psProducto.setInt(3, objeto.getIdCategoria());
        psProducto.setInt(4, objeto.getIdProveedor());
        psProducto.setString(5, objeto.getUbicacion());
        psProducto.setInt(6, objeto.getCantidad_actual());
        psProducto.setInt(7, objeto.getStock_min());
        psProducto.setInt(8, objeto.getStock_max());
        psProducto.setDouble(9, objeto.getPrecioCosto());
        psProducto.setDouble(10, objeto.getPrecioVenta());
        psProducto.setInt(11, objeto.getPorcentajeIgv());
        psProducto.setDouble(12, objeto.getPrecio_total());

        if (idImagen != -1) {
            psProducto.setInt(13, idImagen);  // Usa el ID de la imagen si existe
        } else {
            psProducto.setNull(13, java.sql.Types.INTEGER);  // Si no hay imagen, asigna NULL
        }

        psProducto.setInt(14, objeto.getEstado());

        // Ejecutar la inserción del producto
        if (psProducto.executeUpdate() > 0) {
            // Recuperar el ID del producto recién guardado
            rs = psProducto.getGeneratedKeys();
            int idProductoGuardado = -1;
            if (rs.next()) {
                idProductoGuardado = rs.getInt(1); // Obtener el ID del producto

                // Insertar en tb_entradas para el ajuste de inventario
                String insertEntrada = "INSERT INTO tb_entradas (motivo, documento, idProducto, idCategoria, idProveedor, fecha, cantidad, precioCosto, total, obs, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                psEntrada = cn.prepareStatement(insertEntrada);
                psEntrada.setString(1, "Nuevo Producto"); // Motivo
                psEntrada.setString(2, "Ingreso inicial - " + objeto.getNombre()); // Documento
                psEntrada.setInt(3, idProductoGuardado); // Usa el ID del producto insertado
                psEntrada.setInt(4, objeto.getIdCategoria());
                psEntrada.setInt(5, objeto.getIdProveedor());
                psEntrada.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now())); // Fecha actual
                psEntrada.setInt(7, objeto.getCantidad_actual()); // Cantidad del producto
                psEntrada.setDouble(8, 0); // Precio costo para el ingreso inicial
                psEntrada.setDouble(9, 0); // Total como 0 para el ingreso inicial
                psEntrada.setString(10, "Ingreso de inventario inicial para el producto " + objeto.getNombre()); // Observación
                psEntrada.setInt(11, 1); // Estado (puedes modificar según tus requisitos)

                // Ejecutar la inserción de entrada
                psEntrada.executeUpdate();

                
                // ACTUALIZAR LA CANTIDAD DEL PRODUCTO RESTANDO LO QUE SE INSERTÓ EN ENTRADA
                String updateProducto = "UPDATE tb_producto SET cantidad_actual = cantidad_actual - ? WHERE idProducto = ?";
                psInventario = cn.prepareStatement(updateProducto);
                psInventario.setInt(1, objeto.getCantidad_actual()); // Restar la cantidad ingresada
                psInventario.setInt(2, idProductoGuardado); // Usar el ID del producto insertado
                psInventario.executeUpdate();
            }
            respuesta = true;
        }

        cn.commit();  // Confirma la transacción

    } catch (SQLException | FileNotFoundException e) {
        try {
            if (cn != null) {
                cn.rollback();  // Revierte la transacción en caso de error
            }
        } catch (SQLException ex) {
            System.out.println("Error al revertir la transacción: " + ex);
        }
        System.out.println("Error al guardar producto o imagen: " + e);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (psProducto != null) {
                psProducto.close();
            }
            if (psImagen != null) {
                psImagen.close();
            }
            if (psEntrada != null) {
                psEntrada.close();
            }
            if (psInventario != null) {
                psInventario.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar recursos: " + ex);
        }
    }
    return respuesta;
}
 
    // metodo para consultar si el producto ya esta registrado en la BBDD
    
    public boolean existeProducto(String producto) {
        boolean respuesta = false;
        String sql = "select nombre from tb_producto where nombre = '" + producto + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar producto: " + e);
        }
        return respuesta;
    }
    
     
   
    
  
     // metodo para eliminar un producto
     
    public boolean eliminar(int idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_producto where idProducto ='" + idProducto + "'");
            consulta.executeUpdate();
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e);
        }
        return respuesta;
    }
    
    
     // metodo para actualizar stock un producto

    
      public boolean actualizarStock(Producto object, int idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_producto set cantidad_actual=? where idProducto ='" + idProducto + "'");
            consulta.setInt(1, object.getCantidad_actual());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar stock del producto: " + e);
        }
        return respuesta;
    }
      
        public double calcularPrecioTotal(double precioVenta, String igvStr) {

        Producto producto = new Producto();

        double totalIgv;
        int porcentajeIgv;

        // Determinar el porcentaje de IGV según la cadena proporcionada
        if (igvStr.equalsIgnoreCase("No grava igv")) {
            porcentajeIgv = 0;
            producto.setPorcentajeIgv(0);
        } else if (igvStr.equalsIgnoreCase("18%")) {
            porcentajeIgv = 18;
            producto.setPorcentajeIgv(18);
        } else {
            throw new IllegalArgumentException("Porcentaje de IGV no soportado");
        }

        // Calcular el IGV y el precio total
        totalIgv = precioVenta * porcentajeIgv / 100.0;
        return precioVenta + totalIgv;
    }

      
      
      
      
}
